package other;

import java.util.Collections;
import java.util.List;

public class ProcessAggregation {

    static class Process {
        int pid;
        String name;
        long memory;

        Process(int pid, String name, long memory) {
            this.pid = pid;
            this.name = name;
            this.memory = memory;
        }
    }

    static class ProcessGroup {
        String name;
        long memory; // summarized memory of all processes
        List<Integer> pids; // list of process identifiers for all processes with the same name
    }

    static List<ProcessGroup> aggregate(List<Process> processes) {
        //TODO: missing implementation
        return Collections.emptyList();
    }

    public static void main(String[] args) {
        List<Process> processes = List.of(
                new Process(1, "chrome.exe", 1000),
                new Process(2, "firefox.exe", 2000),
                new Process(2, "chrome.exe", 3000));

        System.out.println(aggregate(processes));
    }
}