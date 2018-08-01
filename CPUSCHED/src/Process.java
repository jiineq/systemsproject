//test 
public class Process implements Comparable<Process> {
	private int processID;
    private int arrivalTime;
    private int burstLength;
    private int priority;

    public Process(int arrT, int burstT, int p) {
        this.arrivalTime = arrT;
        this.burstLength = burstT;
        this.priority = p;
    }

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

    @Override
    public int compareTo(Process p) {
        return 1;
    }

}

