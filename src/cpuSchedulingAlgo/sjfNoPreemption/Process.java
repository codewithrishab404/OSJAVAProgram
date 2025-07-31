package cpuSchedulingAlgo.sjfNoPreemption;

import java.util.Scanner;

public class Process {
    int pid , arrivalTime ,burstTime , completionTime , turnaroundTime , waitingTime;
    boolean isCompleted =false;
    public Process(int pid, int arrivalTime, int burstTime) {
        this.pid = pid;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
    }
}
class SJF_NonPreemptive{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of process");
        int n = sc.nextInt();
        Process[] p = new Process[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter arrival time and burst Time for process"+(i+1));
            int at =sc.nextInt();
            int bt = sc.nextInt();
            p[i]= new Process(i+1,at,bt);
        }
        int currentTime =0;
        int completed =0;
        while(completed<n){
            int index=-1;
            int  minBt = Integer.MAX_VALUE;
            //we have to find process  which have minimum burst time
            for(int i=0;i<n;i++){
                if(!p[i].isCompleted && p[i].arrivalTime <= currentTime && p[i].burstTime<minBt){
                    minBt =p[i].burstTime;
                    index =i;
                }
            }
           if(index != -1){
               p[index].completionTime = currentTime + p[index].burstTime;
               p[index].turnaroundTime = p[index].completionTime-p[index].arrivalTime;
               p[index].waitingTime = p[index].turnaroundTime - p[index].burstTime;
               currentTime = p[index].completionTime;
               p[index].isCompleted=true;
               completed++;
           }else {
               currentTime++;
           }
        }

        // Display the result:
        System.out.println("\nPID\tAT\tBT\tCT\tTAT\tWT");
        for(Process proc:p){
            System.out.println("P"+proc.pid +"\t"+proc.arrivalTime+"\t"+proc.burstTime+"\t"+proc.completionTime+"\t"+proc.turnaroundTime+"\t"+proc.waitingTime);
        }
    }
}