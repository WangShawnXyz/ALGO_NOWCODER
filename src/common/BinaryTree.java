package common;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 公共基础数据结构类  方便后面的算法题做测试
 */
public class BinaryTree {
    TreeNode root = null;
    public BinaryTree(){}

    /**
     * 该构造函数从整数型数组生成一棵二叉树
     * @param input 整数型数组表示前序遍历结果  0表示该处为空
     */
    public BinaryTree(int[] input) {
        if (input == null || input.length == 0 || input[0] == 0) return;
        root = deserialize(input);
    }
    public static TreeNode deserialize(int[] input){
        TreeNode[] treeNodes = new TreeNode[input.length];
        for (int i = 0; i < input.length; i ++){
            treeNodes[i] = input[i] == 0? null : new TreeNode(input[i]);
        }
        Stack<TreeNode> stack = new Stack<>();
        //先处理左子链
        stack.push(treeNodes[0]);
        int index = 1;
        while (treeNodes[index] != null){
            stack.peek().left = treeNodes[index];
            stack.push(treeNodes[index ++]);
        }
        //处理剩下的部分
        while (!stack.isEmpty()){
            index += 1;
            if (index < input.length){
                stack.pop().right = treeNodes[index];
            }
            if (treeNodes[index] != null){
                stack.push(treeNodes[index ++]);
                while (treeNodes[index] != null){
                    stack.peek().left = treeNodes[index];
                    stack.push(treeNodes[index ++]);
                }
            }
        }
//        System.out.println(1);
        return treeNodes[0];
    }

    public static void preorderTraversal(TreeNode root){
        ArrayList<Integer> preorderList = new ArrayList<>();
        preorder(preorderList, root);
        for (Integer i : preorderList){
            System.out.print(i + " ");
        }
        System.out.println();
    }
    private static void preorder(ArrayList<Integer> preorderList, TreeNode root){
        if (root == null) return;
        preorderList.add(root.val);
        preorder(preorderList, root.left);
        preorder(preorderList, root.right);
    }


    public static void main(String[] args) {
        int[] input = new int[]{5, 3, 2, 1, 0, 0, 0, 4, 0, 0, 7, 6, 0, 0, 8, 0, 9, 0, 0};
        BinaryTree bt = new BinaryTree(input);
        BinaryTree.preorderTraversal(bt.root);
    }
}
