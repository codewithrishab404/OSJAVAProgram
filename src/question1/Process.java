package question1;

import java.util.Scanner;

public class Process {
    int pid, bt;

    public Process(int pid, int bt) {
        this.pid = pid;
        this.bt = bt;
    }
}

class main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Input number of processes
        System.out.print("Enter number of processes: ");
        int n = sc.nextInt();

        Process[] processes = new Process[n];
        // Input PID and Burst Time
        for (int i = 0; i < n; i++) {
            int pid = sc.nextInt();
            int bt = sc.nextInt();
            processes[i] = new Process(pid, bt);
        }
        System.out.println("\nGantt Chart:");

        int currentTime =0;
        for(int i =0;i<n;i++){
            Process p = processes[i];
            if(i==0) {
                System.out.print(currentTime + " : Process " + p.pid + " start\n");
            }
            currentTime+=p.bt;

            if(i<n-1) {
                System.out.print(currentTime + " : Process " + p.pid + " end Process " + processes[i + 1].pid + " start\n");
            }
            else{
                System.out.print(currentTime + " : Process " + p.pid + " end\n");
            }
        }
    }
}