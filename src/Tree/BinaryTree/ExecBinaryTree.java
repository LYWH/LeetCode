package Tree.BinaryTree;
/*
 * 写程序仔细一点，不要出错
 * */

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class ExecBinaryTree {
    Scanner scanner = new Scanner(System.in);

    public BinaryTree createBinaryTree() {
        //通过输入创建，0用于创建空孩子.
        int num = scanner.nextInt();
        if (num == 0) {
            return null;
        }
        BinaryTree binaryTree = new BinaryTree(num);
        binaryTree.leftChild = createBinaryTree();
        binaryTree.rightChild = createBinaryTree();
        return binaryTree;
    }

    public BinaryTree createBinaryTreeByArray(int[] arr) {
        if (arr.length == 0) return null;
        BinaryTree[] binaryTrees = new BinaryTree[arr.length];
        int i = 0;
        for (i = 0; i < binaryTrees.length; i++) {
            if (arr[i] != 0) binaryTrees[i] = new BinaryTree(arr[i]);
        }
        for (i = 0; i < binaryTrees.length / 2 - 1; i++) {
            binaryTrees[i].leftChild = binaryTrees[i * 2 + 1];
            binaryTrees[i].rightChild = binaryTrees[i * 2 + 2];
        }
        if (arr.length > 1) {
            binaryTrees[i].leftChild = binaryTrees[i * 2 + 1];
            if (binaryTrees.length % 2 != 0)
                binaryTrees[i].rightChild = binaryTrees[i * 2 + 2];
        }
        return binaryTrees[0];
    }

    //递归前序遍历:根、左、右
    public void preOrderTraverseRecursive(BinaryTree binaryTree) {
        System.out.print(binaryTree.num + "  ");
        if (binaryTree.leftChild != null)
            preOrderTraverseRecursive(binaryTree.leftChild);
        if (binaryTree.rightChild != null)
            preOrderTraverseRecursive(binaryTree.rightChild);
    }

    //递归中序遍历:左、根、右
    public void inOrderTraverseRecursive(BinaryTree binaryTree) {

        if (binaryTree.leftChild != null)
            inOrderTraverseRecursive(binaryTree.leftChild);
        System.out.print(binaryTree.num + "  ");
        if (binaryTree.rightChild != null)
            inOrderTraverseRecursive(binaryTree.rightChild);
    }

    //递归后序遍历：左、右、根
    public void outOrderTraverseRecursive(BinaryTree binaryTree) {
        if (binaryTree.leftChild != null)
            outOrderTraverseRecursive(binaryTree.leftChild);
        if (binaryTree.rightChild != null)
            outOrderTraverseRecursive(binaryTree.rightChild);
        System.out.print(binaryTree.num + "  ");
    }

    //非递归先序遍历
    public void preOrderTraverseNoRecursive(BinaryTree binaryTree) {
        if (binaryTree == null) {
            System.out.println("空树\n");
            return;
        }
        Stack<BinaryTree> stack = new Stack<>();
        BinaryTree temp;
        stack.add(binaryTree);
        while (!stack.isEmpty()) {
            temp = stack.pop();
            System.out.print(temp.num + "  ");
            if (temp.rightChild != null) stack.add(temp.rightChild);
            if (temp.leftChild != null) stack.add(temp.leftChild);
        }
    }

    public void inOrderTraverseNoRecursive(BinaryTree binaryTree) {
        if (binaryTree == null) {
            System.out.println("空树");
            return;
        }
        Stack<BinaryTree> stack = new Stack<>();
        BinaryTree temp = binaryTree;
        //stack.add(binaryTree);
        /*while (!stack.isEmpty()) {
            while (binaryTree.leftChild != null) {
                binaryTree = binaryTree.leftChild;
                stack.add(binaryTree);
            }
            binaryTree = stack.pop();
            System.out.print(binaryTree.num + "  ");
            if (binaryTree.rightChild != null) {
                binaryTree = binaryTree.rightChild;
                stack.add(binaryTree);
            }
        }*/
        while (temp != null || !stack.isEmpty()) {
            if (temp != null) {
                stack.add(temp);
                temp = temp.leftChild;
            } else {
                temp = stack.pop();
                System.out.print(temp.num + "  ");
                temp = temp.rightChild;
            }
        }
    }

    //二叉树非递归后序遍历
    public void outOrderTraverseNoRecursive(BinaryTree binaryTree) {
        Stack<BinaryTree> stack = new Stack<>();
        BinaryTree temp = binaryTree;
        BinaryTree lastVisit = binaryTree;
        while (temp != null || !stack.isEmpty()) {
            while (temp != null) {//不为空，就一直添加左孩子
                stack.add(temp);
                temp = temp.leftChild;
            }
            temp = stack.peek();
            //这个if表明这个栈顶端的节点的右孩子为空或者已经被访问，需要访问当前节点
            if (temp.rightChild == null || temp.rightChild == lastVisit) {
                System.out.print(temp.num + "  ");
                stack.pop();
                lastVisit = temp;
                temp = null;
            } else {//将右孩子添加进栈
                temp = temp.rightChild;
            }
        }//当栈只剩最后一个元素后，并取出时，节点访问后会置空，并将循环节点置空，此时循环就可以 结束
    }
    public void hierarchicalTraversal(BinaryTree binaryTree){
        LinkedList<BinaryTree> linkedList = new LinkedList<>();
        linkedList.add(binaryTree);
        while (!linkedList.isEmpty()){
            binaryTree = linkedList.pop();
            System.out.print(binaryTree.num + "  ");
            if(binaryTree.leftChild != null)
                linkedList.add(binaryTree.leftChild);
            if(binaryTree.rightChild != null)
                linkedList.add(binaryTree.rightChild);
        }
    }
}
