package BinaryTree;

public class Main {
    public static void main(String[] args) {
        var tree = new BinaryTree();
        var root = new BinaryTree.Node(1);
        root.leftChild = new BinaryTree.Node(2);
        root.rightChild = new BinaryTree.Node(3);
        root.leftChild.leftChild = new BinaryTree.Node(4);
        root.rightChild.leftChild = new BinaryTree.Node(5);
        root.rightChild.rightChild = new BinaryTree.Node(6);
        root.rightChild.leftChild.leftChild = new BinaryTree.Node(7);
        root.rightChild.leftChild.rightChild = new BinaryTree.Node(8);

        System.out.println(tree.implementInorderRe(root));
        //[4, 2, 1, 7, 5, 8, 3, 6]

    }
}
