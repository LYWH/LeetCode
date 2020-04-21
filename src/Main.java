import ListNodeSum.ListNode;
import ListNodeSum.ListNodeMethod;
import Palindrome.LongestPalindrome;
import StringPackage.MaxSubString;
import Tree.BinaryTree.BinaryTree;
import Tree.BinaryTree.ExecBinaryTree;
import java.util.stream.StreamSupport;
public class Main {
    public static void main(String[] args) {
        /*int arr1[] = {5,2};
        int arr2[] = {5};
        ListNodeMethod listNodeMethod = new ListNodeMethod();
        ListNode listNode1 = listNodeMethod.createLinkNoeByArray(arr1);
        ListNode listNode2 = listNodeMethod.createLinkNoeByArray(arr2);
        ListNode listNode = listNodeMethod.addTwoNumbers(listNode1,listNode2);
        listNodeMethod.readList(listNode);*/
        /*LongestPalindrome longestPalindrome = new LongestPalindrome();
        String str = "babad";
      //  System.out.println(str.substring(0,2));
        System.out.println("send = " + longestPalindrome.longestPalindrome(str));*/
        //1 2 0 4 0 0 3 5 0 0 6 0 0
        //二叉树创建、遍历开始
        ExecBinaryTree execBinaryTree = new ExecBinaryTree();
        BinaryTree binaryTree;
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        int arr1[] = {1};
        System.out.println("创建二叉树开始");
        //binaryTree = execBinaryTree.createBinaryTree();
        binaryTree = execBinaryTree.createBinaryTreeByArray(arr);
        System.out.println("\n递归前序遍历二叉树开始");
        execBinaryTree.preOrderTraverseRecursive(binaryTree);
        System.out.println("\n非递归前序遍历二叉树开始");
        execBinaryTree.preOrderTraverseNoRecursive(binaryTree);
        System.out.println("\n递归中序遍历二叉树开始");
        execBinaryTree.inOrderTraverseRecursive(binaryTree);
        System.out.println("\n非递归中序遍历二叉树开始");
        execBinaryTree.inOrderTraverseNoRecursive(binaryTree);
        System.out.println("\n递归后序遍历二叉树开始");
        execBinaryTree.outOrderTraverseRecursive(binaryTree);
        System.out.println("\n非递归后序遍历二叉树开始");
        execBinaryTree.outOrderTraverseNoRecursive(binaryTree);
        System.out.println("\n层次遍历二叉树开始");
        execBinaryTree.hierarchicalTraversal(binaryTree);
    }
}
