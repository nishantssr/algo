package com.humsare.algo.tree;

/**
 * Created by krsna on 05/03/2017.
 */
public class BinaryTreeNode {
    public int data;
    public BinaryTreeNode left;
    public BinaryTreeNode right;

    public BinaryTreeNode(int data, BinaryTreeNode left, BinaryTreeNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public BinaryTreeNode getLeft() {
        return left;
    }

    public void setLeft(BinaryTreeNode left) {
        this.left = left;
    }

    public BinaryTreeNode getRight() {
        return right;
    }

    public void setRight(BinaryTreeNode right) {
        this.right = right;
    }

    public String toString1() {
        return Integer.toString(data);
    }

    public void setValue(int data) {
        this.data = data;
    }

    public boolean isLeaf() {
        return left == null && right == null;
    }

    public static boolean findInBinaryTree(BinaryTreeNode root, int data) {
        if (root == null) {
            return false;
        }
        if (root.getData() == data) {
            return true;
        }
        return findInBinaryTree(root.getLeft(), data) || findInBinaryTree(root.getRight(), data);
    }

    public String toString() {
        if (isLeaf()) {
            return this.toString();
        } else {
            String root, left = null, right = null;
            root = this.toString1();
            if (getLeft() != null) {
                left = getLeft().toString();
            }
            if (getRight() != null) {
                right = getRight().toString();
            }
            return root + " (" + left + ", " + right + ")";
        }
    }

    public int hashCode() {
        int result = this.hashCode();
        if (left != null) {
            result += 3 * left.hashCode();
        }
        if (right != null) {
            result += 7 * right.hashCode();
        }
        return result;
    }

    public int numberOfNodes() {
        int leftCount = this.left == null ? 0 : left.numberOfNodes();
        int rightCount = this.right == null ? 0 : right.numberOfNodes();
        return leftCount + rightCount + 1;
    }

    public BinaryTreeNode copy() {
        BinaryTreeNode left = null, right = null;
        if (this.left != null) {
            left = this.left.copy();
        }
        if (this.right != null) {
            right = this.right.copy();
        }
        return new BinaryTreeNode(this.data, left, right);

    }

    public BinaryTreeNode reverse() {
        BinaryTreeNode left = null;
        right = null;
        if (this.left != null) {
            left = this.left.reverse();
        }
        if (this.right != null) {
            right = this.right.reverse();
        }
        return new BinaryTreeNode(this.data, right, left);
    }

    public void reverseInPlace() {
        if (this.left != null) {
            this.left.reverseInPlace();
        }
        if (this.right != null) {
            this.right.reverseInPlace();
        }
        this.setLeft(this.right);
        this.setRight(this.left);
    }


}
