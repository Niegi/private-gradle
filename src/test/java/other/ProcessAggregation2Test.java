package other;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ProcessAggregation2Test {

  @Test
  void aggregate() {
//    given
    List<ProcessAggregation2.Process> processes = List.of(
      new ProcessAggregation2.Process(1, "chrome.exe", 1000),
      new ProcessAggregation2.Process(2, "firefox.exe", 2000),
      new ProcessAggregation2.Process(2, "chrome.exe", 3000));

//    when
    List<ProcessAggregation2.ProcessGroup> actual = ProcessAggregation2.aggregate(processes);
    List<ProcessAggregation2.ProcessGroup> expected = new ArrayList<>();
    ProcessAggregation2.ProcessGroup processGroup1 = new ProcessAggregation2.ProcessGroup("chrome.exe", 4000, List.of(1, 2));
    ProcessAggregation2.ProcessGroup processGroup2 = new ProcessAggregation2.ProcessGroup("firefox.exe", 2000, List.of(2));
    expected.add(processGroup1);
    expected.add(processGroup2);

//    then
    assertThat(actual.size(), is(equalTo(2)));
    assertTrue(actual.contains(processGroup1));
    assertTrue(actual.contains(processGroup2));
  }
}
