package cpuSchedulingAlgo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Process {
    int pid , arrivalTime ,burstTime , completionTime , turnaroundTime , waitingTime;

    public Process(int pid, int arrivalTime, int burstTime) {
        this.pid = pid;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
    }
}

class FCFS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of Processes");
        int n = sc.nextInt();

        Process[] process  = new Process[n];
        for(int i = 0;i<n;i++){
            System.out.println("Enter arrival time and burst Time for process"+i+":");
            int at = sc.nextInt();
            int bt= sc.nextInt();
            process[i]= new Process(i, at,bt);
        }
        // sort process by arrival time
        Arrays.sort(process, Comparator.comparingInt(p-> p.arrivalTime));

        int currentTime =0;
        for(Process p: process){
            if(currentTime< p.arrivalTime){
                currentTime = p.arrivalTime;
            }
            p.completionTime = currentTime + p.burstTime;
            p.turnaroundTime = p.completionTime -p.arrivalTime;
            p.waitingTime= p.turnaroundTime-p.burstTime;
            currentTime = p.completionTime;
        }
        System.out.println("\nPID\tAT\tBT\tCT\tTAT\tWT");
        for (Process p : process) {
            System.out.println("P" + p.pid + "\t" + p.arrivalTime + "\t" + p.burstTime + "\t" +
                    p.completionTime + "\t" + p.turnaroundTime + "\t" + p.waitingTime);
        }
    }
}
