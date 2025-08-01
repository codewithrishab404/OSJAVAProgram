package question3;

import java.util.*;

class Process {
    int pid;
    int bt;
    int priority;

    public Process(int pid, int bt, int priority) {
        this.pid = pid;
        this.bt = bt;
        this.priority = priority;
    }
}

 class PriorityGanttChart {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input number of processes
        System.out.print("Enter number of processes: ");
        int n = sc.nextInt();

        Process[] processes = new Process[n];

        // Input PID, Burst Time, Priority
        for (int i = 0; i < n; i++) {
            int pid = sc.nextInt();
            int bt = sc.nextInt();
            int pr = sc.nextInt();
            processes[i] = new Process(pid, bt, pr);
        }

        // Sort by priority (lower number = higher priority)
        Arrays.sort(processes, Comparator.comparingInt(p -> p.priority));

        System.out.println("\nGantt Chart:");
        int currentTime = 0;

        for (int i = 0; i < n; i++) {
            Process p = processes[i];

            // Start
            if(i==0){
            System.out.println(currentTime + " : Process " + p.pid + " start");
            }
            currentTime += p.bt;

            // End + Start of Next
            if (i < n - 1) {
                System.out.println(currentTime + " : Process " + p.pid + " end Process " + processes[i + 1].pid + " start");
            } else {
                System.out.println(currentTime + " : Process " + p.pid + " end");
            }
        }
    }
}

