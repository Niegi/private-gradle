package other;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

        @Override
        public String toString() {
            return "name: " + name +
                    "\nmemory: " + memory +
                    "\npids list: " + pids.toString();
        }
    }

    static List<ProcessGroup> aggregate(List<Process> processes) {
        Map<String, ProcessGroup> processGroups = new HashMap<>();
        processes.forEach(p -> {
                    if (!processGroups.containsKey(p.name)) {
                        ProcessGroup processGroup = new ProcessGroup();
                        processGroup.name = p.name;
                        processGroup.memory = p.memory;
                        processGroup.pids = new ArrayList<>();
                        processGroup.pids.add(p.pid);
                        processGroups.put(p.name, processGroup);
                    } else {
                        processGroups.get(p.name).memory += p.memory;
                        processGroups.get(p.name).pids.add(p.pid);
                    }
                });
        List<ProcessGroup> processGroupsAsList = new ArrayList<>(processGroups.values());
        return processGroupsAsList;
    }

    public static void main(String[] args) {
        List<Process> processes = List.of(
                new Process(1, "chrome.exe", 1000),
                new Process(2, "firefox.exe", 2000),
                new Process(2, "chrome.exe", 3000));

        aggregate(processes).forEach(System.out::println);
    }
}