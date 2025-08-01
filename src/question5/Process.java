package question5;

import java.util.*;

public class Process {
    int pid , burstTime, remainingTime;

    public Process(int pid, int burstTime) {
        this.pid = pid;
        this.burstTime = burstTime;
        this.remainingTime = burstTime;
    }
}
class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of process");
        int n = sc.nextInt();

        System.out.println("Enter Time quanta");
        int timeQuanta = sc.nextInt();

        List<Process> processes = new ArrayList<>();
        Queue<Process> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            System.out.println("Enter pid and burst time");
            int pid = sc.nextInt();
            int bt = sc.nextInt();
            Process p = new Process(pid, bt);
            processes.add(p);
            queue.add(p);
        }
        int time =0;
        System.out.println(time+":"+ "Process"+queue.peek().pid+ "start");
        while(!queue.isEmpty()){
           Process currentProcess = queue.poll();

           if(currentProcess.burstTime>timeQuanta){
               currentProcess.burstTime-=timeQuanta;
               time+=timeQuanta;
               System.out.print(time+ ":"+ "Process"+currentProcess.pid+" preempt ");

               // Add back to the queue , as it has remaining burst time left
               queue.add(currentProcess);
               if(!queue.isEmpty()){
                   System.out.print(" Process "+queue.peek().pid+"starts");
               }
               System.out.println();

           }else{
               time += currentProcess.remainingTime;
               currentProcess.remainingTime = 0;
               System.out.print(time+":"+" Process " + currentProcess.pid + " end");

               // Show next process start if exists
               if (!queue.isEmpty()) {
                   System.out.print(" Process " + queue.peek().pid + " start");
               }
               System.out.println();
           }
        }

    }
}
