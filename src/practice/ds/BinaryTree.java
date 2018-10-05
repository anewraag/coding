package practice.ds;

/**
 * Created by asaxena on 9/24/2018.
 */
 public class BinaryTree<T>{

    Node root;

    static class Node<T> {
        T value;
        Node left;
        Node right;

        Node(T value){
            this.value = value;
        }

        void print(){
            System.out.println("Value: " + value);
        }

    }

    public void postOrderTraversal(){
        postOrderTraversal(root);
    }
    private void postOrderTraversal(Node root){

        if(root==null)
            return;

        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        root.print();
    }

    public void preOrderTraversal(){
        preOrderTraversal(root);
    }
    private void preOrderTraversal(Node root){

        if(root==null)
            return;

        root.print();
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    public void inOrderTraversal(){
        inOrderTraversal(root);
    }
    private void inOrderTraversal(Node root){

        if(root==null)
            return;

        inOrderTraversal(root.left);
        root.print();
        inOrderTraversal(root.right);
    }

    public void init(){

        root = new BinaryTree.Node(1);
        root.left = new BinaryTree.Node(2);
        root.right = new BinaryTree.Node(3);
        root.left.left = new BinaryTree.Node(4);
        root.left.right = new BinaryTree.Node(5);
        root.right.left = new BinaryTree.Node(6);

    }
}


