package com.college;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.queue.CircularQueue;

/**
 * This class provides methods for counseling process of a College.
 * 
 * @author Chinmay Jain
 * @version 1.0
 * @since 2021-03-08
 */
public class CounselingProcess {
	private CircularQueue<Student> queue;
	private Map<String, Integer> programs = new HashMap<String, Integer>();
	private Map<String, String> allotments = new HashMap<String, String>();
	private final String filename = "CollegeCounseling.xls";
	private Workbook wb;

	// Default constructor
	public CounselingProcess() {
	}

	/**
	 * This method reads the programs data and student data from input file and puts
	 * them into queue for processing.
	 * 
	 * @throws IOException
	 */
	public void readInputsFromSheet() throws IOException {
		// Loading excel file into input stream
		InputStream fileIn = new FileInputStream(filename);
		wb = WorkbookFactory.create(fileIn);

		// getting rows from Sheet 0 (StudentsList)
		Sheet sheet1 = wb.getSheet("StudentsList");
		int totalStudents = sheet1.getPhysicalNumberOfRows() - 1; // total no. of student rows

		queue = new CircularQueue<Student>(totalStudents);

		// adding each student to queue
		for (int rowIndex = 1; rowIndex < sheet1.getPhysicalNumberOfRows(); rowIndex++) {
			Row row = sheet1.getRow(rowIndex);

			String studentName = row.getCell(0).getStringCellValue();
			List<String> stuProgramsPref = new ArrayList<String>();

			for (int cellIndex = 1; cellIndex < row.getPhysicalNumberOfCells(); cellIndex++) {
				stuProgramsPref.add(row.getCell(cellIndex).getStringCellValue());
			}

			queue.enQueue(new Student(studentName, stuProgramsPref));
		}

		// getting rows from Sheet 1 (ProgramsList)
		Sheet sheet2 = wb.getSheet("ProgramsList");

		// adding each program to HashMap
		for (int rowIndex = 1; rowIndex < sheet2.getPhysicalNumberOfRows(); rowIndex++) {
			Row row = sheet2.getRow(rowIndex);
			String programName = row.getCell(0).getStringCellValue();
			int capacity = (int) row.getCell(1).getNumericCellValue();

			programs.put(programName, capacity);
		}

		fileIn.close();
	}

	/**
	 * This method allots program to a student based on the rank and program
	 * preference list of student.
	 */
	public void processInputs() {
		while (!queue.isEmpty()) {
			Student student = queue.deQueue();

			for (String programName : student.getProgramsPref()) {
				int capacity = programs.get(programName);
				if (capacity > 0) {
					allotments.put(student.getName(), programName);
					programs.put(programName, capacity - 1);
					break;
				}
			}

			if (null == allotments.get(student.getName())) {
				allotments.put(student.getName(), "-");
			}
		}
	}

	/**
	 * This method writes the processed data to the excel sheet.
	 * 
	 * @throws IOException
	 */
	public void writeOutputsToSheet() throws IOException {
		Sheet sheet3 = wb.getSheet("AllotmentsList");
		if (null == sheet3) {
			sheet3 = wb.createSheet("AllotmentsList");
		}

		// creating header row
		int rowCount = 0;
		Row rowHead = sheet3.createRow(rowCount++);
		rowHead.createCell(0).setCellValue("STUDENT_NAME");
		rowHead.createCell(1).setCellValue("PROGRAM_NAME");

		// inserting student allotment details
		for (String key : allotments.keySet()) {
			Row row = sheet3.createRow(rowCount++);
			row.createCell(0).setCellValue(key);
			row.createCell(1).setCellValue(allotments.get(key));
		}

		FileOutputStream fileOut = new FileOutputStream(filename);
		wb.write(fileOut);

		fileOut.close();
		wb.close();
	}

	/**
	 * @param args Unused.
	 */
	public static void main(String[] args) {
		CounselingProcess cp = new CounselingProcess();

		try {
			System.out.println("\nReading inputs...");
			cp.readInputsFromSheet();
			System.out.println("\nProcessing...");
			cp.processInputs();
			System.out.println("\nWriting to file...");
			cp.writeOutputsToSheet();
			System.out.println("\nProcess Complete.");
		} catch (Exception e) {
			System.out.println("\n" + e.toString());
		}
	}
}
