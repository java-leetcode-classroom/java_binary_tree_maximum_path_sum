import java.util.HashMap;

public class Solution {
  int accumResult;
  public TreeNode createBinaryTree(String[] inputs) {
    TreeNode result = null, cur;
    HashMap<Integer, TreeNode> hash = new HashMap<>();
    int size = inputs.length;
    for (int idx = 0; idx < size; idx++) {
      int num = 0;
      String val = inputs[idx];
      if (!val.equals("null")) {
        num = Integer.parseInt(val);
      }
      if (idx == 0) {
        result = new TreeNode(num);
        hash.put(num, result);
      }
      if (hash.containsKey(num)) {
        cur = hash.get(num);
      } else {
        cur = new TreeNode(num);
        hash.put(num, cur);
      }
      if (2*idx+1 < size) {
        if (!inputs[2*idx+1].equals("null")) {
          int leftVal = Integer.parseInt(inputs[2*idx+1]);
          if (hash.containsKey(leftVal)) {
            cur.left = hash.get(leftVal);
          } else {
            cur.left = new TreeNode(leftVal);
            hash.put(leftVal, cur.left);
          }
        }
      }
      if (2*idx+2 < size) {
        if (!inputs[2*idx+2].equals("null")) {
          int rightVal = Integer.parseInt(inputs[2*idx+2]);
          if (hash.containsKey(rightVal)) {
            cur.right = hash.get(rightVal);
          } else {
            cur.right = new TreeNode(rightVal);
            hash.put(rightVal, cur.right);
          }
        }
      }
    }
    return result;
  }
  public int maxPathSum(TreeNode root) {
    if (root == null) {
      return 0;
    }
    accumResult = root.val;
    MaxSum(root);
    return accumResult;
  }
  public int MaxSum(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int leftMax = MaxSum(root.left);
    int rightMax = MaxSum(root.right);
    // leftMax = choose or not choose maximum
    leftMax = Math.max(leftMax, 0);
    rightMax = Math.max(rightMax, 0);
    // split Max = not split result  or (leftMax + root.val + rightMax)
    accumResult = Math.max(accumResult, leftMax + root.val + rightMax);
    // not split result = root.val + Max(leftMax, rightMax)
    return root.val + Math.max(leftMax, rightMax);
  }
}
