//Java command-line program to implement FCFS Job Scheduling
package com.scheduler;

/**
 * This class implements First Come First Serve (FCFS) Job Scheduling Algorithm.
 * 
 * @author Chinmay Jain
 * @version 1.0
 * @since 2021-03-02
 */
public class FCFS {

	// Default constructor
	public FCFS() {
	}

	/**
	 * This method computes various parameters of a process and displays them to
	 * console.
	 * 
	 * @param arrivalTime Array of integers where each index represents the arrival
	 *                    time of a process.
	 * @param burstTime   Array of integers where each index represents the burst
	 *                    time of a process.
	 */
	public static void compute(int[] arrivalTime, int[] burstTime) {
		int processCount = arrivalTime.length;
		double averageWaitingTime;
		int maxWaitingTime;

		final int completionTime[] = computeCompletionTime(arrivalTime, burstTime);
		final int turnAroundTime[] = computeTurnAroundTime(completionTime, arrivalTime);
		final int waitingTime[] = computeWaitingTime(turnAroundTime, burstTime);

		averageWaitingTime = ((double) getTotalWaitingTime(waitingTime)) / processCount;
		maxWaitingTime = getMaxWaitingTime(waitingTime);

		System.out.println("\nPID" + "\tARRIVAL" + "\tBURST" + "\tCOMPLETION" + "\tTURN AROUND" + "\tWAITING");
		System.out.println("---------------------------------------------------------------");
		for (int i = 0; i < processCount; i++) {
			System.out.println(" " + (i + 1) + "\t  " + arrivalTime[i] + "\t " + burstTime[i] + "\t  "
					+ completionTime[i] + "\t\t  " + turnAroundTime[i] + "\t\t  " + waitingTime[i]);
		}
		System.out.print("\nAVERAGE WAITING TIME: " + averageWaitingTime);
		System.out.print("\nMAXIMUM WAITING TIME: " + maxWaitingTime);
	}

	/**
	 * Method to calculate Completion Time of each process.
	 * 
	 * @param arrivalTime Array of integers where each index represents the arrival
	 *                    time of a process.
	 * @param burstTime   Array of integers where each index represents the burst
	 *                    time of a process.
	 * @return Integer[] Array of integers where each index represents the
	 *         completion time of a process.
	 */
	public static int[] computeCompletionTime(int[] arrivalTime, int[] burstTime) {
		int processCount = arrivalTime.length;
		int[] completionTime = new int[processCount];
		for (int i = 0; i < processCount; i++) {
			if (i == 0) {
				completionTime[i] = arrivalTime[i] + burstTime[i];
			} else if (arrivalTime[i] > completionTime[i - 1]) {
				completionTime[i] = arrivalTime[i] + burstTime[i];
			} else {
				completionTime[i] = completionTime[i - 1] + burstTime[i];
			}
		}
		return completionTime;
	}

	/**
	 * Method to calculate Turn Around Time of each process.
	 * 
	 * @param completionTime Array of integers where each index represents the
	 *                       completion time of a process.
	 * @param arrivalTime    Array of integers where each index represents the
	 *                       arrival time of a process.
	 * @return Integer[] Array of integers where each index represents the turn
	 *         around time of a process.
	 */
	public static int[] computeTurnAroundTime(int[] completionTime, int[] arrivalTime) {
		int processCount = completionTime.length;
		int[] turnAroundTime = new int[processCount];
		for (int i = 0; i < processCount; i++) {
			turnAroundTime[i] = completionTime[i] - arrivalTime[i];
		}
		return turnAroundTime;
	}

	/**
	 * Method to calculate Waiting Time of each process.
	 * 
	 * @param turnAroundTime Array of integers where each index represents the turn
	 *                       around time of a process.
	 * @param burstTime      Array of integers where each index represents the burst
	 *                       time of a process.
	 * @return Integer[] Array of integers where each index represents the waiting
	 *         time of a process.
	 */
	public static int[] computeWaitingTime(int[] turnAroundTime, int[] burstTime) {
		int processCount = turnAroundTime.length;
		int[] waitingTime = new int[processCount];
		for (int i = 0; i < processCount; i++) {
			waitingTime[i] = turnAroundTime[i] - burstTime[i];
		}
		return waitingTime;
	}

	/**
	 * Method to calculate Total Waiting Time.
	 * 
	 * @param waitingTime Array of integers where each index represents the waiting
	 *                    time of a process.
	 * @return Integer Total waiting time of all processes.
	 */
	public static int getTotalWaitingTime(int[] waitingTime) {
		int total = 0;
		for (int i : waitingTime) {
			total += i;
		}
		return total;
	}

	/**
	 * Method to find Maximum Waiting Time.
	 * 
	 * @param waitingTime Array of integers where each index represents the waiting
	 *                    time of a process.
	 * @return Integer Maximum waiting time.
	 */
	public static int getMaxWaitingTime(int[] waitingTime) {
		int max = 0;
		for (int i : waitingTime) {
			if (i > max) {
				max = i;
			}
		}
		return max;
	}

	/**
	 * This is the main method which contains the Driver code.
	 * 
	 * @param args Unused.
	 */
	public static void main(String[] args) {
		// input array of processes with their arrival time and burst time
		int processes[][] = { { 0, 10 }, { 6, 20 }, { 25, 10 }, { 40, 5 } };

		int processCount = processes.length;
		int arrivalTime[] = new int[processCount];
		int burstTime[] = new int[processCount];

		for (int i = 0; i < processCount; i++) {
			arrivalTime[i] = processes[i][0];
			burstTime[i] = processes[i][1];
		}

		FCFS.compute(arrivalTime, burstTime);
	}
}