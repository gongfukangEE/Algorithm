package Algorithm.commons;

import java.util.Stack;

/**
 * @Auther gongfukang
 * @Date 1/11 20:08
 */
public class Tree {
    private TreeNode root;

    public Tree() {
        root = null;
    }

    public void insert(int value) {
        TreeNode newNode = new TreeNode(value);
        if (root == null)
            root = newNode;
        else {
            TreeNode current = root;
            TreeNode parent;
            while (true) {
                parent = current;
                if (value < current.val) {
                    current = current.left;
                    if (current == null) {
                        parent.left = newNode;
                        return;
                    }
                } else {
                    current = current.right;
                    if (current == null) {
                        parent.right = newNode;
                        return;
                    }
                }
            }
        }
    }

    public void displayTree() {
        Stack globalStack = new Stack();
        globalStack.push(root);
        int nBlamks = 32;
        boolean isRowEmpty = false;
        System.out.println("******************************************************************");
        while (isRowEmpty == false) {
            Stack localStack = new Stack();
            isRowEmpty = true;

            for (int j = 0; j < nBlamks; j++)
                System.out.print(' ');

            while (globalStack.isEmpty() == false) {
                TreeNode temp = (TreeNode) globalStack.pop();
                if (temp != null) {
                    System.out.print(temp.val);
                    localStack.push(temp.left);
                    localStack.push(temp.right);

                    if (temp.left != null || temp.right != null)
                        isRowEmpty = false;
                } else {
                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
                }

                for (int j = 0; j < nBlamks * 2 - 2; j++)
                    System.out.print(' ');
            }
            System.out.println();
            nBlamks /= 2;
            while (localStack.isEmpty() == false)
                globalStack.push(localStack.pop());
        }
        System.out.println("******************************************************************");
    }
}
