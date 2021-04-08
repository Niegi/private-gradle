package algorithms;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

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
    return new int[][] { { 4 , 6, 2, 3 } };
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
}