package algorithms;


import java.io.IOException;
import java.util.*;

public class HackerRankSolutions {

  public static void main(String[] args) throws IOException {
    String a = "fcrxzwscanmligyxyvym";
    String b = "jxwtrhvujlmrpdoqbisbwhmgpmeoke";
    System.out.println(makeAnagram(a, b));
  }

  //    Complete the hackerrankInString function in the editor below. It must return YES or NO.
//    For each query, print YES on a new line if s contains 'hackerrank', otherwise, print NO.
  static String hackerrankInString(String s) {

    List<String> listOfStrings = Arrays.asList(s.split("\\R"));
    String returnedString = "";
    char[] hackerrank = {'h', 'a', 'c', 'k', 'e', 'r', 'r', 'a', 'n', 'k'};
    for (String str : listOfStrings) {
      int currentPositionInString = 0;
      boolean contain = true;
      for (char c : hackerrank) {
        if (str.substring(currentPositionInString).contains(String.valueOf(c))) {
          currentPositionInString = str.substring(currentPositionInString).indexOf(String.valueOf(c));
        } else {
          contain = false;
          break;
        }
      }
      if (contain) {
        returnedString = returnedString.concat("YES\n");
      } else {
        returnedString = returnedString.concat("NO\n");
      }
    }
    return returnedString;
  }

  // Complete the marsExploration function below. Check the number of errors in SOSSOSSOS chain
  static int marsExploration(String s) {
    int numberOfChanges = 0;
    for (int i = 0; i < s.length(); i++) {
      if ((i % 3 == 0 || i % 3 == 2) && !s.substring(i, i + 1).equals("S")) {
        numberOfChanges++;
      }
      if (i % 3 == 1 && !s.substring(i, i + 1).equals("O")) {
        numberOfChanges++;
      }
    }
    return numberOfChanges;
  }

  /*
   * Complete the 'pickingNumbers' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts INTEGER_ARRAY a as parameter.
   */

  public static int pickingNumbers(List<Integer> a) {
    int max = 1;
    for (int i = 0; i < a.size(); i++) {
      int sameOrHigher = 0;
      int sameOrLower = 0;
      for (int j = 0; j < a.size(); j++) {
        if (a.get(j) == a.get(i)) {
          sameOrHigher++;
          sameOrLower++;
        }
        if (a.get(j) == a.get(i) + 1) {
          sameOrHigher++;
        }
        if (a.get(j) == a.get(i) - 1) {
          sameOrLower++;
        }
      }
      if (sameOrHigher > max) {
        max = sameOrHigher;
      }
      if (sameOrLower > max) {
        max = sameOrLower;
      }
    }
    return max;
  }

  // Complete the encryption function below.
  static String encryption(String s) {
    String textWithoutWhiteMarks = s.replaceAll("\\s", "");
    double rowsNumber = Math.floor(Math.sqrt(textWithoutWhiteMarks.length()));
    double columnsNumber = Math.ceil(Math.sqrt(textWithoutWhiteMarks.length()));
    if (rowsNumber * columnsNumber < textWithoutWhiteMarks.length()) {
      rowsNumber++;
    }
    char[][] tab = new char[(int) rowsNumber][(int) columnsNumber];
    int index = 0;
    String encryptedText = "";
    for (int r = 0; r < rowsNumber; r++) {
      for (int c = 0; c < columnsNumber; c++) {
        tab[r][c] = textWithoutWhiteMarks.charAt(index);
        index++;
        if (index >= textWithoutWhiteMarks.length()) {
          break;
        }
      }
    }

//        just for testing
    for (int r = 0; r < rowsNumber; r++) {
      for (int c = 0; c < columnsNumber; c++) {
        System.out.print(tab[r][c]);
      }
      System.out.println();
    }
//        end of testing

    for (int c = 0; c < columnsNumber; c++) {
      for (int r = 0; r < rowsNumber; r++) {
        if (c == columnsNumber && tab[r][c] != '\u0000') {
          break;
        }
        if (tab[r][c] != '\u0000') {
          encryptedText = encryptedText.concat(String.valueOf(tab[r][c]));
        }
      }
      encryptedText = encryptedText.concat(" ");
    }
    return encryptedText;
  }

  // Complete the superReducedString function below.
  static String superReducedString(String s) {
    StringBuilder reducedString = new StringBuilder(s);
    for (int i = 0; i < reducedString.length() - 1; i++) {
      if (reducedString.substring(i, i + 1).equals(reducedString.substring(i + 1, i + 2))) {
        reducedString = reducedString.delete(i, i + 2);
        reducedString = new StringBuilder(superReducedString(reducedString.toString()));
      }
    }
    return reducedString.toString().isEmpty() ? "Empty String" : reducedString.toString();
  }

  // Complete the findMedian function below.
  static int findMedian(int[] arr) {
    Arrays.sort(arr);
    return arr[(arr.length - 1) / 2];
  }

  // Complete the closestNumbers function below.
  static int[] closestNumbers(int[] arr) {
    if (arr.length <= 1) {
      return arr;
    }
    Arrays.sort(arr);
    int smallestDiff = Math.abs(arr[0] - arr[1]);
    for (int i = 1; i < arr.length - 1; i++) {
      if (Math.abs(arr[i] - arr[i + 1]) < smallestDiff) {
        smallestDiff = Math.abs(arr[i] - arr[i + 1]);
      }
    }
    List<Integer> smallestDiffElems = new ArrayList<>();
    for (int i = 0; i < arr.length - 1; i++) {
      if (Math.abs(arr[i] - arr[i + 1]) == smallestDiff) {
        smallestDiffElems.add(arr[i]);
        smallestDiffElems.add(arr[i + 1]);
      }
    }
    int[] array = smallestDiffElems.stream().mapToInt(i -> i).toArray();
    return array;
  }

  // Complete the libraryFine function below.
  static int libraryFine(int returnDay, int returnMonth, int returnYear, int dueDay, int dueMonth, int dueYear) {
    int fine = 0;
    if (returnYear > dueYear) {
      fine = 10000;
    } else if (returnYear == dueYear && returnMonth > dueMonth) {
      fine = (returnMonth - dueMonth) * 500;
    } else if (returnYear == dueYear && returnMonth == dueMonth && returnDay > dueDay) {
      fine = (returnDay - dueDay) * 15;
    }
    return fine;
  }

  // Complete the squares function below.
  static int squares(int a, int b) {
    int counter = 0;
    for (int i = 1; i <= b; i++) {
      int square = i * i;
      if (square >= a && square <= b) {
        counter++;
      }
      if (square > b) {
        break;
      }
    }
    return counter;
  }

  // Complete the chocolateFeast function below.
  static int chocolateFeast(int actualMoney, int chocolateCost, int wrappersPromo) {
    int numberOfChocolatesEaten = Math.floorDiv(actualMoney, chocolateCost);
    int actualNumberOfWrappers = numberOfChocolatesEaten;
    while (actualNumberOfWrappers >= wrappersPromo) {
      int numberOfPromoChocolates = Math.floorDiv(actualNumberOfWrappers, wrappersPromo);
      numberOfChocolatesEaten += numberOfPromoChocolates;
      actualNumberOfWrappers = actualNumberOfWrappers - numberOfPromoChocolates * wrappersPromo + numberOfPromoChocolates;
    }
    return numberOfChocolatesEaten;
  }

  // Complete the makingAnagrams function below.
  static int makingAnagrams(String s1, String s2) {

    for (char c : s1.toCharArray()) {
      int S2IndexOfC = s2.indexOf(c);
      if (S2IndexOfC >= 0) {
        s1 = s1.replaceFirst(String.valueOf(c), "");
        s2 = s2.replaceFirst(String.valueOf(c), "");
      }
    }
    return s1.length() + s2.length();
  }

  // Complete the gameOfThrones function below.
  static String gameOfThrones(String s) {

    Map<Character, Integer> charOccurences = new HashMap<>();
    for (char c : s.toCharArray()) {
      if (!charOccurences.containsKey(c)) {
        charOccurences.put(c, 1);
      } else {
        charOccurences.replace(c, charOccurences.get(c) + 1);
      }
    }
    int oddCharsNumber = 0;
    for (Character c : charOccurences.keySet()) {
      if (charOccurences.get(c) % 2 != 0) {
        oddCharsNumber++;
      }
      if (oddCharsNumber > 1) {
        return "NO";
      }
    }
    return "YES";
  }

  // Complete the twoStrings function below.
  static String twoStrings(String s1, String s2) {
    for (char c : "abcdefghijklmnopqrstuvwxyz".toCharArray()) {
      if (s1.contains(String.valueOf(c)) && s2.contains(String.valueOf(c))) {
        return "YES";
      }
    }
    return "NO";
  }

  // Complete the balancedSums function below.
  static String balancedSums(List<Integer> arr) {
    if (arr.size() <= 1) {
      return "YES";
    }

    int leftSum = 0;
    int rightSum = 0;
    for (int i = 1; i < arr.size(); i++) {
      rightSum += arr.get(i);
    }
    if (rightSum == 0) {
      return "YES";
    }
    for (int middle = 1; middle < arr.size(); middle++) {
      leftSum += arr.get(middle - 1);
      rightSum -= arr.get(middle);
      if (leftSum == rightSum) {
        return "YES";
      }
      if (leftSum > rightSum) {
        return "NO";
      }
    }
    return "NO";
  }

  // Complete the alternatingCharacters function below.
  static int alternatingCharacters(String s) {
    int counter = 0;
    for (int i = 0; i < s.length() - 1; i++) {
      if (s.charAt(i) == s.charAt(i + 1)) {
        counter++;
      }
    }
    return counter;
  }

  // Complete the hourglassSum function below.
  static int hourglassSum(int[][] arr) {
    List<Integer> sums = new ArrayList<>();
    for (int i = 0; i < arr.length - 2; i++) {
      for (int j = 0; j < arr.length - 2; j++) {
        Integer currentSum = arr[i][j] + arr[i][j + 1] + arr[i][j + 2] + arr[i + 1][j + 1] + arr[i + 2][j] + arr[i + 2][j + 1] + arr[i + 2][j + 2];
        sums.add(currentSum);
      }
    }
    Integer maxSum = sums.get(0);
    for (int i = 1; i < sums.size(); i++) {
      if (sums.get(i) > maxSum) {
        maxSum = sums.get(i);
      }
    }

    return maxSum;
  }

  // Complete the rotLeft function below.
  static int[] rotLeft(int[] a, int d) {
    int[] rotatedArray = new int[a.length];
    for (int i = 0; i < a.length - d; i++) {
      rotatedArray[i] = a[i + d];
    }
    for (int i = 0; i < d; i++) {
      rotatedArray[a.length - d + i] = a[i];
    }
    return rotatedArray;
  }

  // Complete the countSwaps function below.
  static void countSwaps(int[] a) {
    int n = a.length;
    int counter = 0;
    for (int i = 0; i < n; i++) {

      for (int j = 0; j < n - 1; j++) {
        // Swap adjacent elements if they are in decreasing order
        if (a[j] > a[j + 1]) {
          swap(a, j, j + 1);
          counter++;
        }
      }
    }
    System.out.println("Array is sorted in " + counter + ".");
    System.out.println("First Element: " + a[0]);
    System.out.println("Last Element: " + a[n - 1]);
  }

  //    simple swap function
  static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  // Complete the maximumToys function below.
  static int maximumToys(int[] prices, int k) {
    Arrays.sort(prices);
    int moneyLeft = k;
    int toysBought = 0;
    for (int i = 0; i < prices.length; i++) {
      if (moneyLeft >= prices[i]) {
        moneyLeft -= prices[i];
        toysBought++;
      }
    }
    return toysBought;
  }

  // Complete the minimumAbsoluteDifference function below.
  static int minimumAbsoluteDifference(int[] arr) {
    if (arr.length < 2) {
      return 0;
    }
    Arrays.sort(arr);
    int minAbsDiff = Math.abs(arr[1] - arr[0]);
    for (int i = 1; i < arr.length - 1; i++) {
      if (Math.abs(arr[i] - arr[i + 1]) < minAbsDiff) {
        minAbsDiff = Math.abs(arr[i] - arr[i + 1]);
      }
    }
    return minAbsDiff;
  }

  // Complete the marcsCakewalk function below.
  static long marcsCakewalk(int[] calorie) {
    long milesTotal = 0;
    Arrays.sort(calorie);
    for (int i = calorie.length - 1; i >= 0; i--) {
      milesTotal += Math.pow(2, Math.abs(i + 1 - calorie.length)) * calorie[i];
    }
    return milesTotal;
  }

  // Complete the luckBalance function below.
  static int luckBalance(int k, int[][] contests) {
    int luckBalance = 0;
    int numberOfImportantContests = 0;
    for (int i = 0; i < contests.length; i++) {
      if (contests[i][1] == 1) {
        numberOfImportantContests++;
      } else {
        luckBalance += contests[i][0];
      }
    }
    int[] importantContests = new int[numberOfImportantContests];
    for (int i = 0, counter = 0; i < contests.length; i++) {
      if (contests[i][1] == 1) {
        importantContests[counter] = contests[i][0];
        counter++;
      }
    }
    Arrays.sort(importantContests);
    for (int actual_contest = importantContests.length - 1, importantContestsLeft = k; actual_contest >= 0; actual_contest--) {
      if (importantContestsLeft > 0) {
        luckBalance += importantContests[actual_contest];
        importantContestsLeft--;
      } else {
        luckBalance -= importantContests[actual_contest];
      }
    }
    return luckBalance;
  }

  // Complete the makeAnagram function below.
  static int makeAnagram(String a, String b) {

    List<Character> ACharacters = new ArrayList<>();
    List<Character> BCharacters = new ArrayList<>();
    for (Character c : a.toCharArray()) {
      ACharacters.add(c);
    }
    for (Character c : b.toCharArray()) {
      BCharacters.add(c);
    }
    Iterator<Character> iterator = ACharacters.iterator();
    while (iterator.hasNext()) {
      Character tmp = iterator.next();
      if (BCharacters.contains(tmp)) {
        BCharacters.remove(tmp);
        iterator.remove();
      }
    }

    return ACharacters.size() + BCharacters.size();
  }

  // Complete the whatFlavors function below.
  static void whatFlavors(int[] cost, int money) {
    Map<Integer, Integer> map = new HashMap<>();
    map.put(money - cost[0], 1);
    for (int i = 1; i < cost.length; i++) {
      if (map.containsKey(cost[i])) {
        System.out.println(map.get(cost[i]) + " " + (i + 1));
        break;
      } else if (!map.containsKey(cost[i]) && money - cost[i] > 0) {
        map.put(money - cost[i], i + 1);
      }
    }
  }

  // Detect a cycle in a linked list. Note that the head pointer may be 'null' if the list is empty.
  static boolean hasCycle(Node head) {
    if (head == null) {
      return false;
    }
    Set<Node> nodes = new HashSet<>();
    while (head != null) {
      if (nodes.contains(head)) {
        return true;
      }
      nodes.add(head);
      head = head.next;
    }
    return false;
  }

  // Complete the reverse function below.
  static DoublyLinkedListNode reverse(DoublyLinkedListNode head) {
    DoublyLinkedListNode temp = head.next;
    head.next = head.prev;
    head.prev = temp;
    return temp == null ? head : reverse(temp);
  }

  // Complete the matchingStrings function below.
  static int[] matchingStrings(String[] strings, String[] queries) {
    int[] output = new int[queries.length];
    int counter = 0;

    for (String query : queries) {
      int matches = 0;
      for (String string : strings) {
        if (query.equals(string)) {
          matches++;
        }
      }
      output[counter] = matches;
      counter++;
    }
    return output;
  }

  // Complete the compareLists function below.
  static boolean compareLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
    while (head1 != null && head2 != null) {
      if (head1.data != head2.data) {
        return false;
      }
      head1 = head1.next;
      head2 = head2.next;
    }
    return head1 == null && head2 == null;
  }

  /*
   * Complete the 'rotateLeft' function below.
   *
   * The function is expected to return an INTEGER_ARRAY.
   * The function accepts following parameters:
   *  1. INTEGER d
   *  2. INTEGER_ARRAY arr
   */

  public static List<Integer> rotateLeft(int d, List<Integer> arr) {
    List<Integer> rotatedArray = new ArrayList<>();
    rotatedArray.addAll(arr.subList(d, arr.size()));
    rotatedArray.addAll(arr.subList(0, d));
    return rotatedArray;
  }

  //    tree-huffman-decoding problem
  void decode(String s, TreeNode root) {
      StringBuilder decodedString = new StringBuilder();
      TreeNode actualNode = root;
      for (int i=0 ; i<s.length() ; i++) {
          actualNode = s.charAt(i) == '0' ? actualNode.left : actualNode.right;
          if (actualNode.data != '\u0000') {
              decodedString.append(actualNode.data);
              actualNode = root;
          }
      }
      System.out.println(decodedString);
  }

  // Complete the funnyString function below.
  static String funnyString(String s) {
    int[] ascii = new int[s.length()];
    int[] reversed = new int[s.length()];
    for (int i=0 ; i<s.length() ; i++) {
      ascii[i] = s.charAt(i);
      reversed[s.length()-i-1] = s.charAt(i);
    }
    int[] asciiDiffs = new int[ascii.length-1];
    int[] reversedDiffs = new int[ascii.length-1];
    for (int i=0 ; i<ascii.length-1 ; i++) {
      asciiDiffs[i] = Math.abs(ascii[i]-ascii[i+1]);
      reversedDiffs[i] = Math.abs(reversed[i]-reversed[i+1]);
      if (asciiDiffs[i] != reversedDiffs[i]) {
        return "Not Funny";
      }
    }
    return "Funny";
  }

//  Lowest Common Ancestor problem
  public static TreeNode lca(TreeNode root, int v1, int v2) {
    if (root.data == v1 || root.data == v2) {
      return root;
    }
    List<TreeNode> pathToV1 = new ArrayList<>();
    List<TreeNode> pathToV2 = new ArrayList<>();
    pathToV1.add(root);
    pathToV2.add(root);
    findPathToTreeNodeByItsData(Direction.LEFT, v1, pathToV1);
    findPathToTreeNodeByItsData(Direction.LEFT, v2, pathToV2);

    int longer = Math.max(pathToV1.size(), pathToV2.size());
    for (int i=0 ; i<longer ; i++) {
      TreeNode actual = pathToV1.get(i);
      if (!pathToV1.get(i+1).equals(pathToV2.get(i+1))) {
        return actual;
      }
    }

    return new TreeNode();
  }

  private static void findPathToTreeNodeByItsData(Direction direction, int data, List<TreeNode> path) {
    int lastIndex = path.size()-1;
    if (direction == Direction.LEFT) {
      TreeNode left = path.get(lastIndex).left;
      if (left != null) {
        path.add(left);
        if (left.data != data) {
          findPathToTreeNodeByItsData(Direction.LEFT, data, path);
        }
      } else {
        findPathToTreeNodeByItsData(Direction.RIGHT, data, path);
      }
    } else {
      TreeNode right = path.get(lastIndex).right;
      if (right != null) {
        path.add(right);
        if (right.data != data) {
          findPathToTreeNodeByItsData(Direction.LEFT, data, path);
        }
      } else {
        path.remove(lastIndex);
      }
    }
  }

}

enum Direction {
  LEFT, RIGHT
}

class TreeNode {
    TreeNode left;
    TreeNode right;
    char data;
}

class Node {
  int data;
  Node next;
}

class DoublyLinkedListNode {
  int data;
  DoublyLinkedListNode next;
  DoublyLinkedListNode prev;
}

class SinglyLinkedListNode {
  int data;
  SinglyLinkedListNode next;
}