package algorithms;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HackerRankSolutionsTest {

  @Test
  void hackerrankInString() {
  }

  @Test
  void marsExploration() {
  }

  @Test
  void pickingNumbers() {
  }

  @Test
  void encryption() {
  }

  @Test
  void superReducedString() {
  }

  @Test
  void findMedian() {
  }

  @Test
  void closestNumbers() {
  }

  @Test
  void libraryFine() {
  }

  @Test
  void squares() {
  }

  @Test
  void chocolateFeast() {
  }

  @Test
  void makingAnagrams() {
  }

  @Test
  void gameOfThrones() {
  }

  @Test
  void twoStrings() {
  }

  @Test
  void balancedSums() {
  }

  @Test
  void alternatingCharacters() {
  }

  @Test
  void hourglassSum() {
  }

  @Test
  void rotLeft() {
  }

  @Test
  void countSwaps() {
  }

  @Test
  void swap() {
  }

  @Test
  void maximumToys() {
  }

  @Test
  void minimumAbsoluteDifference() {
  }

  @Test
  void marcsCakewalk() {
  }

  @Test
  void luckBalance() {
  }

  @Test
  void makeAnagram() {
  }

  @Test
  void whatFlavors() {
  }

  @Test
  void hasCycle() {
    Node nullNode = null;
    Node node1 = new Node();
    Node node2 = new Node();
    Node node3 = new Node();
    node1.next = node2;
    node2.next = node3;
    node3.next = node1;
    assertFalse(HackerRankSolutions.hasCycle(nullNode));
    assertTrue(HackerRankSolutions.hasCycle(node1));
  }

  @Test
  void reverseDoublyLinkedList() {
    DoublyLinkedListNode node1 = new DoublyLinkedListNode();
    DoublyLinkedListNode node2 = new DoublyLinkedListNode();
    DoublyLinkedListNode node3 = new DoublyLinkedListNode();
    node1.next = node2;
    node1.prev = null;
    node2.next = node3;
    node2.prev = node1;
    node3.next = null;
    node3.prev = node2;
    assertTrue(HackerRankSolutions.reverse(node1) == node3);
    assertTrue(node1.next == null);
    assertTrue(node1.prev == node2);
    assertTrue(node2.next == node1);
    assertTrue(node2.prev == node3);
    assertTrue(node3.next == node2);
    assertTrue(node3.prev == null);
  }

  @Test
  void matchingStringsTest() {
    String[] strings = {"def", "de", "fgh"};
    String[] queries = {"de", "lmn", "fgh"};
    int[] expected = {1, 0, 1};
    int[] actual = HackerRankSolutions.matchingStrings(strings, queries);
    assertArrayEquals(expected, actual);
  }

  public static int[][] dataSetForSaveThePrisonerTest() {
    return new int[][]{{4, 6, 2, 3}};
  }

  @ParameterizedTest
  @MethodSource("dataSetForSaveThePrisonerTest")
  void saveThePrisonerTest(int[] dataSetForSaveThePrisonerTest) {
    int numberOfPrisoners = dataSetForSaveThePrisonerTest[0];
    int numberOfCandies = dataSetForSaveThePrisonerTest[1];
    int initialPosition = dataSetForSaveThePrisonerTest[2];
    int expectedFinalPosition = dataSetForSaveThePrisonerTest[3];

    int finalPosition = HackerRankSolutions.saveThePrisoner(numberOfPrisoners, numberOfCandies, initialPosition);
    assertEquals(expectedFinalPosition, finalPosition);
  }

  @Test
  void stonesTest() {
    int numberOfStones = 58;
    int a = 69;
    int b = 24;

    List actual = HackerRankSolutions.stones(numberOfStones, a, b);
    List expected = Arrays.asList(1368, 1413, 1458, 1503, 1548, 1593, 1638, 1683, 1728, 1773, 1818, 1863, 1908, 1953,
      1998, 2043, 2088, 2133, 2178, 2223, 2268, 2313, 2358, 2403, 2448, 2493, 2538, 2583, 2628, 2673, 2718, 2763, 2808,
      2853, 2898, 2943, 2988, 3033, 3078, 3123, 3168, 3213, 3258, 3303, 3348, 3393, 3438, 3483, 3528, 3573, 3618, 3663,
      3708, 3753, 3798, 3843, 3888, 3933);

    assertEquals(expected, actual);

    numberOfStones = 73;
    a = 25;
    b = 25;

    actual = HackerRankSolutions.stones(numberOfStones, a, b);
    expected = Arrays.asList(1800);

    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @CsvSource({
    "1234, YES 1",
    "91011, YES 9",
    "99100, YES 99",
    "101103, NO",
    "010203, NO",
    "13, NO",
    "1, NO",
    "00000000000000000000000000000000, NO",
    "11111111111111111111111111111111, NO",
    "10001001100210031004100510061007, YES 1000",
  })
  void separateNumbersTest(String input, String output) {
    String actual = HackerRankSolutions.separateNumbers(input);
    String expected = output;

    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @CsvSource({
    "hackerhappy, hackerrank, 9, Yes",
    "aba, aba, 7, Yes",
    "ashley, ash, 2, No"
  })
  void appendAndDelete(String initial, String expected, String numberOfOperations, String expectedResult) {
    String actual = HackerRankSolutions.appendAndDelete(initial, expected, Integer.parseInt(numberOfOperations));
    assertEquals(actual, expectedResult);
  }
}
