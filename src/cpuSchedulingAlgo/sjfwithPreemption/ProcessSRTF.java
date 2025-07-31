package cpuSchedulingAlgo.sjfwithPreemption;

import java.util.*;

class ProcessSRTF {
    int pid, at, bt, rt, ct, tat, wt;
    boolean isCompleted = false;

    ProcessSRTF(int pid, int at, int bt) {
        this.pid = pid;
        this.at = at;
        this.bt = bt;
        this.rt = bt; // Remaining time
    }
}

 class SJF_Preemptive_SRTF {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of processes: ");
        int n = sc.nextInt();

        ProcessSRTF[] p = new ProcessSRTF[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter arrival time and burst time for process " + (i + 1));
            int at = sc.nextInt();
            int bt = sc.nextInt();
            p[i] = new ProcessSRTF(i + 1, at, bt);
        }

        int completed = 0, currentTime = 0;

        while (completed < n) {
            int idx = -1;
            int minRT = Integer.MAX_VALUE;

            for (int i = 0; i < n; i++) {
                if (p[i].at <= currentTime && !p[i].isCompleted && p[i].rt < minRT && p[i].rt > 0) {
                    minRT = p[i].rt;
                    idx = i;
                }
            }

            if (idx != -1) {
                p[idx].rt--;
                currentTime++;

                if (p[idx].rt == 0) {
                    p[idx].ct = currentTime;
                    p[idx].tat = p[idx].ct - p[idx].at;
                    p[idx].wt = p[idx].tat - p[idx].bt;
                    p[idx].isCompleted = true;
                    completed++;
                }
            } else {
                currentTime++;
            }
        }

        // Print result
        System.out.println("\nPID\tAT\tBT\tCT\tTAT\tWT");
        for (ProcessSRTF proc : p) {
            System.out.println("P" + proc.pid + "\t" + proc.at + "\t" + proc.bt + "\t" + proc.ct + "\t" + proc.tat + "\t" + proc.wt);
        }
    }
}
