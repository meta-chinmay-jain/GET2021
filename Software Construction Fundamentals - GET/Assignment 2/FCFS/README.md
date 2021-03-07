# FCFS Job Scheduling
## Assignment 2 - Static Checking and Code Review

### <u>**Question 2**</u>

### Design a class JobScheduler to simulate FCFS (First Come First Serve) scheduling algorithm.

> FCFS means the process which arrives first, gets executed first. 

* Assume that we are receiving a number of processes with their arrival time and burst time (in seconds) in a two dimensional array as input. For example:

    ```
    [0][10]
    [6][20]
    [60][10]
    [110][5]
    ```

*  Define methods to perform following operations:
    1. Calculate completion time for each process. 
    2. Calculate waiting time for each process.
    3. Calculate turn around time for each process.
    4. Average waiting time of processes.
    5. Maximum waiting time period for a process in queue.

> Some DEFINITIONS for reference: <br>
> - **Completion Time**: Time taken for the execution to complete, starting from arrival time of first process. <br>
> - **Turn Around Time**: Time taken to complete after arrival. In simple words, it is the difference between the Completion time and the Arrival time. <br>
> - **Waiting Time**: Total time the process has to wait before it's execution begins. It is the difference between the Turn Around time and the Burst time of the process. <br>
> - **Burst Time**: Time required to execute a process.