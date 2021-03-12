package com.college;

import java.util.List;

/**
 * This class provides structure of Student object. Student name and the list of
 * programs as per student's preference.
 * 
 * @author Chinmay Jain
 * @version 1.0
 * @since 2021-03-08
 */
public class Student {
	private String name;
	private List<String> programsPref;

	// Parameterized constructor
	public Student(String studentName, List<String> stuProgramsPref) {
		this.name = studentName;
		this.programsPref = stuProgramsPref;
	}

	/**
	 * @return String Name of student.
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return List<String> Programs list as per student's preference.
	 */
	public List<String> getProgramsPref() {
		return programsPref;
	}
}
