package DataStructures.BinaryTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Auther gongfukang
 * @Date 2017/12/8 20:39
 * 二叉查找树
 */
public class TreeApp {
    public static void main(String[] args) throws IOException {
        int value;
        Tree theTree=new Tree();

        theTree.insert(50,1.5);
        theTree.insert(25,1.2);
        theTree.insert(75,1.7);
        theTree.insert(12,1.5);
        theTree.insert(37,1.2);
        theTree.insert(43,1.7);
        theTree.insert(30,1.5);
        theTree.insert(33,1.2);
        theTree.insert(87,1.7);
        theTree.insert(93,1.5);
        theTree.insert(97,1.5);

        while (true){
            System.out.print("enter first letter of show,insert,find,delete,traverse or getheight:  ");
            int choice=getChar();
            switch (choice){
                case 's':
                    theTree.displayTree();
                    break;
                case 'i':
                    System.out.println("enter value to insert: ");
                    value=getInt();
                    theTree.insert(value,value+0.9);
                    break;
                case 'f':
                    System.out.println("enter value to find: ");
                    value=getInt();
                    Node found=theTree.find(value);
                    if(found!=null){
                        System.out.print("Found: ");
                        found.displayNode();
                        System.out.println("\n");
                    }else
                        System.out.println("can't find ");
                    System.out.println(value+'\n');
                    break;
                case 'd':
                    System.out.println("enter value to delete: ");
                    value=getInt();
                    boolean didDelete=theTree.delete(value);
                    if(didDelete)
                        System.out.print("Deleted "+value+'\n');
                    else
                        System.out.println("can't delete ");
                    System.out.println(value+'\n');
                    break;
                case 't':
                    System.out.println("enter type 1,2，3 or 4 :");
                    value=getInt();
                    theTree.traverse(value);
                    break;
                case 'g':
                    System.out.println("Tree Height:");
                    theTree.TreeHeight();
                    default:
                        System.out.println("Invalid entry\n");

            }
        }
    }

    public static String getString() throws IOException {
        InputStreamReader inputStreamReader=new InputStreamReader(System.in);
        BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
        String s=bufferedReader.readLine();
        return s;
    }

    public static char getChar() throws IOException {
        String s=getString();
        return s.charAt(0);
    }

    public static int getInt() throws IOException {
        String s=getString();
        return Integer.parseInt(s);
    }
}
