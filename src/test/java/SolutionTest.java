import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
  final private Solution sol = new Solution();
  @Test
  void maxPathSumExample1() {
    assertEquals(6,
        sol.maxPathSum(sol.createBinaryTree(new String[]{"1", "2", "3"})));
  }
  @Test
  void maxPathSumExample2() {
    assertEquals(42,
        sol.maxPathSum(sol.createBinaryTree(new String[]{"-10", "9", "20", "null", "null", "15", "7"})));
  }
}