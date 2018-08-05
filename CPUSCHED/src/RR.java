import java.util.LinkedList;
import java.util.HashMap;
import java.util.Map;

/**
 * Round robin scheduler	
 * preemptive
 */
public class RR {

    private LinkedList<Process> jobs;
    private LinkedList<Process> readyQ;
    private LinkedList<Integer> arrivalTime ;
    private Map<Integer, Integer> responseTime = new HashMap<Integer, Integer>();
    private int quantum;


    public RR(LinkedList<Process> jobslist, int q) {
        this.jobs = jobslist;
        this.quantum = q;

    }

    public int arrMin(LinkedList<Process> p) {
        int min = p.get(0).getArrivalTime();
        for (Process proc : p) {
            if (proc.getArrivalTime() < min) {
                min = proc.getArrivalTime();
            }
        }
        return min;
    }

    private void sortJobs(LinkedList<Process> joblist, int returnAux) {
        int min = 0;

        for (Process proc : joblist) {
            if (!arrivalTime.contains(proc.getArrivalTime()) && proc.getArrivalTime() <= returnAux) {
                if (!readyQ.contains(proc)) {
                    min = proc.getArrivalTime();
                    arrivalTime.add(min);
                    for (Process p2 : joblist) {
                        if (p2.getArrivalTime() == min) {
                            readyQ.add(p2);
                        }
                    }
                }
            }
        }
    }

    private int calcTotalResponse() {
        int sum = 0;
        for (int key : responseTime.keySet()) {
            sum += responseTime.get(key);
        }
        return sum;


    }
    public String calcRR() {

        int turnaround = 0;
        int wait = 0;
        int arr = arrMin(jobs);
        int remainingBurst = 0;
        int numProcesses = jobs.size();

        sortJobs(jobs, arr);

        while (!readyQ.isEmpty()) {
            Process p = readyQ.remove(0);

            //key: processo
            //value: tempo em que foi atendido
            if (!responseTime.containsKey(p.getID())) {
                responseTime.put(p.getID(), arr - p.getArrivalTime());
            }

            if (p.getRemainingBurst() > quantum) {
                p.setRemainingBurst(p.getRemainingBurst() - quantum);
                arr += quantum;
                sortJobs(jobs, arr);

                readyQ.add(p);
            } else {
                arr += p.getRemainingBurst();
            }

            if (!readyQ.contains(p)) {
                turnaround += (arr - p.getArrivalTime());
                wait += (arr - p.getArrivalTime() - p.getBurstLength());
            }
        }

        double avgTurnaround = ((double) turnaround / numProcesses);
        double setAvgResponse = ((double) calcTotalResponse() / numProcesses);
        double avgWait = ((double) wait / numProcesses);


//        for (int i = 0; i < completed.size(); i++) {
//            turnaroundTotal += completed.get(i).completion - completed.get(i).getArrivalTime();
//            waitTotal += (completed.get(i).completion - completed.get(i).getArrivalTime()) - completed.get(i).burstLength;
//            util += completed.get(i).burstLength;
//        }

//        double avgTurnaround = turnaroundTotal/completed.size();
//        double avgWait = waitTotal/completed.size();
//        double cpuUtil = (util - (contextSwitch*0.01))/timer;
//        double throughput = (double)completed.size()/timer;
//
//        System.out.println(avgTurnaround);
//        System.out.println(avgWait);
        return "adsf";


    }



}