package BinaryTree;

import java.util.*;

public class BinaryTree {
    public static class Node{
        public int value;
        public Node leftChild;
        public Node rightChild;

        public Node(int value){
            this.value = value;

        }
        @Override
        public String toString(){
            return "node = " + value;
        }
    }
    private Node root;

    public void insert(int value) {
        var node = new Node(value);

        if (root == null) {
            root = node;
            return;
        }

        var current = root;
        while (true) {
            if (value < current.value) {
                if (current.leftChild == null) {
                    current.leftChild = node;
                    break;
                }
                current = current.leftChild;
            }
            else {
                if (current.rightChild == null) {
                    current.rightChild = node;
                    break;
                }
                current = current.rightChild;
            }
        }
    }

    public boolean find(int value){
        var current = root;
        while (root != null){
            if(value < current.value)
                current = current.leftChild;
            else if (value > current.value)
                current = current.rightChild;
            else return true;
        }
        return false;
    }
    public void traversPreOrder(){
        traversPreOrder(root);
    }
    private void traversPreOrder(Node root){
        if(root == null)
            return;
        System.out.println(root.value);
        traversPreOrder(root.leftChild);
        traversPreOrder(root.rightChild);
    }
    public void traversInOrder(Node root){
        if(root == null)
            return;
        traversPreOrder(root.leftChild);
        System.out.println(root.value);
        traversPreOrder(root.rightChild);
    }
    public void traversPostOrder(Node root, List<Integer> result){
        if(root == null)
            return;
        traversPreOrder(root.leftChild);
        traversPreOrder(root.rightChild);
        System.out.println(root.value);
    }
    public int height(){
        return height(root);
    }

    private int height(Node root){
        if(root == null)
            return -1;
        if(isLeaf(root))
            return 0;
        return 1+ Math.max(height(root.rightChild), height(root.leftChild));
    }

    private boolean isLeaf(Node root) {
        return root.leftChild == null && root.rightChild == null;
    }

    public boolean isBalanced(Node root) {
        if (root == null)
            return true;
        int leftHeight = height(root.leftChild);
        int rightHeight = height(root.rightChild);
        if (Math.abs(leftHeight - rightHeight) <= 1 && isBalanced(root.rightChild) && isBalanced(root.leftChild))
            return true;

        return false;

    }
    public boolean isSymmetric(Node root){
        return root == null || checkSymmetric(root.leftChild , root.rightChild);
    }

    private boolean checkSymmetric(BinaryTree.Node leftSubTree, BinaryTree.Node rightSubTree) {
        if(leftSubTree == null && rightSubTree == null )
            return true;
        else if (leftSubTree != null && rightSubTree != null ){
            return leftSubTree.value == rightSubTree.value &&
                    checkSymmetric(leftSubTree.leftChild, rightSubTree.rightChild)&&
                    checkSymmetric(leftSubTree.rightChild,rightSubTree.leftChild);
        }
        return false;
    }
    public Node lowestCommonAncestor(Node root, Node p, Node q){
        if (root == null)
            return null;
        else if  (root == p || root == q )
            return root;
        var moveToRight = lowestCommonAncestor(root.rightChild,p,q);
        var moveToLeft = lowestCommonAncestor(root.rightChild, p,q);
       if (moveToLeft != null && moveToRight != null )
           return root;
       if (moveToLeft != null)
           return moveToLeft;
       else
           return moveToRight;
    }
  public List<Integer> implementInOrder(Node root){
      Deque<Node> s = new LinkedList<>();
      var current = root;
      List<Integer> result = new ArrayList<>();
      while (!s.isEmpty() || current != null){
          if (current != null){
          s.addFirst(current);
          current = current.leftChild;
      } else {
              current = s.removeFirst();
              result.add(current.value);
              current = current.rightChild;
          }
      }
        return result;
  }

  public List<Integer> implementInorderRe(Node root){
      List<Integer> result = new ArrayList<>();
        if (root == null)
            return null;
        inorder(root , result);
      return result;

  }

    private void inorder(Node root , List<Integer> result) {
        if(root == null) return;
        inorder(root.leftChild , result);
        result.add(root.value );
        inorder(root.rightChild , result);
    }

  public List<Integer> implementPreOrder(Node root){
      List<Integer> result = new ArrayList<>();
      var current = root;
      Deque<Node> nodes = new LinkedList<>();
     if (root == null)
         return null;
     nodes.addFirst(current);
      while (!nodes.isEmpty() || current != null)
          if (current !=null){
              result.add(current.value);
              nodes.addFirst(current.rightChild);
              nodes.addFirst(current.leftChild);
          }



      return result;
  }
  public Node findThNode(Node root , int k ) {
        var current = root;
        while (root != null){
            int leftSize = current.leftChild  !=null ? current.leftChild.value : 0 ;
            if (leftSize + 1 < k) {
                k-=(leftSize + 1 );
                current = current.rightChild;
            } else if (leftSize == k -1 ){
                return current;
            } else {
                current = current.leftChild;
            }
        }
        return null;
  }
    public static Node mergeBinaryTree(Node root1,Node root2 , int x){
        if(root1 == null && root2 == null) return null;
        if(root1 == null) return root2;
        if(root2 == null) return root1;

        Node left = mergeBinaryTree(root1.leftChild, root2.leftChild , ++x);
        Node right = mergeBinaryTree(root1.rightChild, root2.rightChild, ++x);

        Node root = new Node(root1.value + root2.value);
        return root;
    }
}

