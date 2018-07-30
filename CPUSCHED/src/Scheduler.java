import java.util.ArrayList;

public class Scheduler {
    /*
    list that stores the queue of processes
     */
    ArrayList<Process> FIFOqueue;
    /*
    Total elapsed time for FIFO scheduler
     */
    double elapsedT;
    /*
    Number of processes completed per ms
     */
    double throughput;
    /*
    CPU utilization as a decimal
     */
    double utilization;
    /*
    Average time a process spends in the ready queue in ms
     */
    double avgWait;
    /*
    Average time a process takes to execute in ms
     */
    double avgTurnaround;
    /*
    Average time a process takes from submission to start responding
     */
    double avgResponse;


    public FIFO(ArrayList<Process> p) {

    }

}
