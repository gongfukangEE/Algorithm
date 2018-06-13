package BinaryTree;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @Auther gongfukang
 * @Date 2017/12/8 10:00
 */
public class Tree {
    private Node root;

    public Tree() {
        root = null;
    }

    public Node find(int key) {
        Node current = root;
        while (current.iData != key) {
            if (key < current.iData)
                current = current.leftChild;
            else
                current = current.rightChild;
            if (current == null)
                return null;
        }
        return current;
    }

    public void insert(int id, double dd) {
        Node newNode = new Node();
        newNode.iData = id;
        newNode.dData = dd;
        if (root == null)
            root = newNode;
        else {
            Node current = root;
            Node parent;
            while (true) {
                parent = current;
                if (id < current.iData) {
                    current = current.leftChild;
                    if (current == null) {
                        parent.leftChild = newNode;
                        return;
                    }
                } else {
                    current = current.rightChild;
                    if (current == null) {
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }
    }

    public boolean delete(int key) {
        Node current = root;
        Node parent = root;

        boolean isLeftChild = true;

        while (current.iData != key) {
            parent = current;
            if (key < current.iData) {
                isLeftChild = true;
                current = current.leftChild;
            } else {
                isLeftChild = false;
                current = current.rightChild;
            }
            if (current == null)
                return false;
        }

        if (current.leftChild == null && current.rightChild == null) {
            if (current == root)
                root = null;
            else if (isLeftChild)
                parent.leftChild = null;
            else
                parent.rightChild = null;
        } else if (current.rightChild == null) {
            if (current == root)
                root = current.leftChild;
            else if (isLeftChild)
                parent.leftChild = current.leftChild;
            else
                parent.rightChild = current.leftChild;
        } else if (current.leftChild == null) {
            if (current == root)
                root = current.rightChild;
            else if (isLeftChild)
                parent.leftChild = current.rightChild;
            else
                parent.rightChild = current.rightChild;
        } else {
            Node successor = getSuccessor(current);

            if (current == root)
                root = successor;
            else if (isLeftChild)
                parent.leftChild = successor;
            else
                parent.rightChild = successor;

            successor.leftChild = current.leftChild;
        }
        return true;
    }

    private Node getSuccessor(Node delNode) {
        Node successorParent = delNode;
        Node successor = delNode;
        Node current = delNode.rightChild;
        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.leftChild;
        }

        if (successor != delNode.rightChild) {
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = delNode.rightChild;
        }
        return successor;
    }

    public void traverse(int traverseType) {
        switch (traverseType) {
            case 1:
                System.out.print("\nPreorder traverType:");
                preOrder(root);
                break;
            case 2:
                System.out.print("\nInorder traverType:");
                inOrder(root);
                break;
            case 3:
                System.out.print("\nPostorder traverType:");
                postOrder(root);
                break;
            case 4:
                System.out.print("\nLevelTravel：");
                levelTravel(root);
                break;
        }
    }

    private void preOrder(Node localRoot) {
        if (localRoot != null) {
            System.out.print(localRoot.iData + " ");
            preOrder(localRoot.leftChild);
            preOrder(localRoot.rightChild);
        }
    }

    private void inOrder(Node localRoot) {
        if (localRoot != null) {
            inOrder(localRoot.leftChild);
            System.out.print(localRoot.iData + " ");
            inOrder(localRoot.rightChild);
        }
    }

    private void postOrder(Node localRoot) {
        if (localRoot != null) {
            postOrder(localRoot.leftChild);
            postOrder(localRoot.rightChild);
            System.out.print(localRoot.iData + " ");
        }
    }

    private void levelTravel(Node localRoot) {
        if (root == null)
            return;
        Queue<Node> q = new LinkedList<Node>();
        q.add(localRoot);

        while (!q.isEmpty()) {
            Node temp = q.poll();
            System.out.print(temp.iData + " ");
            if (temp.leftChild != null)
                q.add(temp.leftChild);
            if (temp.rightChild != null)
                q.add(temp.rightChild);
        }
    }

    public int PostOrderGetHeight(Node localRoot) {
        int HL, HR, MaxH;
        if (localRoot != null) {
            HL = PostOrderGetHeight(localRoot.leftChild);
            HR = PostOrderGetHeight(localRoot.rightChild);
            MaxH = (HL > HR) ? HL : HR;
            return (MaxH + 1);
        } else
            return 0;
    }

    public void TreeHeight() {
        System.out.println(PostOrderGetHeight(root));
    }

    public Node FindMin() {
        Node current;
        Node last = null;
        current = root;

        while (current != null) {
            last = current;
            current = current.leftChild;
        }
        return last;
    }

    public Node FindMax(Node localRoot) {
        if (localRoot == null)
            return null;
        else if (localRoot.rightChild == null)
            return localRoot;
        else
            return FindMax(localRoot.rightChild);
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
                Node temp = (Node) globalStack.pop();
                if (temp != null) {
                    System.out.print(temp.iData);
                    localStack.push(temp.leftChild);
                    localStack.push(temp.rightChild);

                    if (temp.leftChild != null || temp.rightChild != null)
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
