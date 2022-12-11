package other;

import java.util.*;

class ProcessAggregation2 {

  public static void main(String[] args) {
    List<Process> processes = List.of(
      new Process(1, "chrome.exe", 1000),
      new Process(2, "firefox.exe", 2000),
      new Process(2, "chrome.exe", 3000));

    List<ProcessGroup> processGroups = aggregate(processes);
    System.out.println(processGroups);
  }

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

    public ProcessGroup(String name, long memory, List<Integer> pids) {
      this.name = name;
      this.memory = memory;
      this.pids = pids;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      ProcessGroup that = (ProcessGroup) o;
      return memory == that.memory && name.equals(that.name) && pids.equals(that.pids);
    }

    @Override
    public int hashCode() {
      return Objects.hash(name, memory, pids);
    }

    @Override
    public String toString() {
      return "ProcessGroup{" +
        "name='" + name + '\'' +
        ", memory=" + memory +
        ", pids=" + pids +
        '}';
    }
  }

  static List<ProcessGroup> aggregate(List<Process> processes) {
    Map<String, ProcessGroup> processGroupMap = new HashMap<>();
    for (Process p : processes) {
      if (!processGroupMap.containsKey(p.name)) {
        List<Integer> pids = new ArrayList<>();
        pids.add(p.pid);
        processGroupMap.put(p.name, new ProcessGroup(p.name, p.memory, pids));
      } else {
        ProcessGroup existingProcessGroup = processGroupMap.get(p.name);
        existingProcessGroup.pids.add(p.pid);
        existingProcessGroup.memory += p.memory;
      }
    }
    return new ArrayList<>(processGroupMap.values());
  }
}
