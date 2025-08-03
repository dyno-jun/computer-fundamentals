package com.dyno.tree;

public class MinimumDepthOfBinaryTree {
  // Problem: Given a binary tree, find its minimum depth.
  // Input: root = [3,9,20,null,null,15,7]
  // Output: 2

  public static void main(String[] args) {
    /*
        트리 구조:
              3
             / \
            9  20
               / \
              15  7
        최소 깊이는 3 → 9 → 리프노드, 깊이 = 2
    */

    TreeNode root = new TreeNode(
        3,
        new TreeNode(9),
        new TreeNode(20, new TreeNode(15), new TreeNode(7))
    );

    int result = minDepth(root);
    System.out.println("Minimum Depth: " + result);  // Output: 2
  }


  // Step
  // 1. 왼쪽 자식 없는경우 null이 아닌 오른쪽으로 재귀 진행
  // 2. 오른쪽 자식이 없는 경우  왼쪽으로 재귀 진행
  // 3. 양쪽 자식 모두 있는 경우 둘중 작은 깊이를 선택
  public static int minDepth(TreeNode root) {
    if (root == null) return 0;

    // 1. 왼쪽 자식 없는경우 null이 아닌 오른쪽으로 재귀 진행
    if (root.left == null) return 1 + minDepth(root.right);
    // 2. 오른쪽 자식이 없는 경우  왼쪽으로 재귀 진행
    if (root.right == null) return 1 + minDepth(root.left);

    // 3. 양쪽 자식 모두 있는 경우 둘중 작은 깊이를 선택
    return 1 + Math.min(minDepth(root.left), minDepth(root.right));
  }
}

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode() {
  }

  TreeNode(int val) {
    this.val = val;
  }

  TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }
}