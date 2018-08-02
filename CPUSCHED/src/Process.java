//test
public class Process {
    private int processID;
    private int arrivalTime;
    public int burstLength;
    private int priority;
    public int timeElapsed;
    private int wait;
    private int turnaround;
    public int completion;

    public Process(int arrT, int burstT, int p) {
        this.arrivalTime = arrT;
        this.burstLength = burstT;
        this.priority = p;
        this.timeElapsed = 0;
    }

    public Process(int pid, int arrT, int burstT, int p) {
        this.processID = pid;
        this.arrivalTime = arrT;
        this.burstLength = burstT;
        this.priority = p;
        this.timeElapsed = 0;
    }


    public int getArrivalTime() {
        return arrivalTime;
    }

    public int getPriority() {
        return priority;
    }


    public int getBurstLength() {
        return burstLength;
    }

    public int getID() {
        return processID;
    }


}

