package practice.ds;

/**
 * Created by asaxena on 9/24/2018.
 */
public class BST extends BinaryTree{
    @Override
    public void init() {
        root = new BinaryTree.Node(10);
        root.left = new BinaryTree.Node(5);
        root.right = new BinaryTree.Node(20);
        root.left.left = new BinaryTree.Node(3);
        root.left.right = new BinaryTree.Node(7);
        root.right.left = new BinaryTree.Node(15);
    }
}
