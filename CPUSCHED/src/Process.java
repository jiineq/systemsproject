import java.util.List;

/**
 *https://www.geeksforgeeks.org/operating-system-priority-scheduling-different-arrival-time-set-2/
 *http://iips.icci.edu.iq/images/exam/Abraham-Silberschatz-Operating-System-Concepts---9th2012.12.pdf
 *https://www.geeksforgeeks.org/program-shortest-job-first-scheduling-set-2srtf-make-changesdoneplease-review/
 *https://www.youtube.com/watch?v=DvF3AsTglUU
 *https://github.com/search?q=cpu+scheduler+fifo
 *
 * https://github.com/ElvisGarcia079/Virtualization/blob/master/Scheduler.java
 * https://github.com/rrqq/cpu-scheduler
 *
 * runnable is for managing multiple threads
 *https://github.com/CormacAsGaeilge/CPU-Scheduler-Simulator
 * https://github.com/priyasjoshi/CPU-Scheduling
 * https://en.wikibooks.org/wiki/Operating_System_Design/Scheduling_Processes/FCFS
 * https://stackoverflow.com/questions/420223/what-is-the-difference-between-compare-and-compareto
 */



public class Process implements Comparable<Process> {
    private int processID;
    private int arrivalTime;
    private int burstLength;
    private int priority;

    public Process(int pid, int arrT, int burstT, int p) {
        this.processID = pid;
        this.arrivalTime = arrT;
        this.burstLength = burstT;
        this.priority = p;
    }

    public int getProcessID() {
        return processID;
    }
    public int getBurstLength() {
        return burstLength;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public int getPriority() {
        return priority;
    }



}
