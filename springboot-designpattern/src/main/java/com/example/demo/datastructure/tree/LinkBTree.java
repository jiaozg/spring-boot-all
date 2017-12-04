package com.example.demo.datastructure.tree;

/**
 * Created by jiaozhiguang on 2017/11/28.
 */
public class LinkBTree implements BTree {

    private Object data;
    private BTree leftChild;
    private BTree rightChild;

    public LinkBTree(Object o) {
        this.data = o;
    }

    @Override
    public void addLeftTree(BTree leftChild) {
        this.leftChild = leftChild;
    }

    @Override
    public void addRightTree(BTree rightChild) {
        this.rightChild = rightChild;
    }

    @Override
    public BTree getLeftChild() {
        return leftChild;
    }

    @Override
    public BTree getRightChild() {
        return rightChild;
    }

    @Override
    public boolean hasLeftChild() {
        return leftChild != null;
    }

    @Override
    public boolean hasRightChild() {
        return rightChild != null;
    }

    @Override
    public void removeLeftChild() {
        this.leftChild = null;
    }

    @Override
    public void removeRightChild() {
        this.rightChild = null;
    }

    @Override
    public boolean isEmpty() {
        if (data == null && leftChild == null && rightChild == null) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isLeaf() {
        if (leftChild == null && rightChild == null) {
            return true;
        }
        return false;
    }

    @Override
    public BTree root() {
        return this;
    }

    @Override
    public int size() {
        return size(this);
    }

    @Override
    public int size(BTree bTree) {
        if (bTree.isEmpty()) {
            return 0;
        } else if (bTree.isLeaf()) {
            return 1;
        } else {
            if (bTree.getLeftChild() == null) {
                return size(bTree.getRightChild()) + 1;
            } else if (bTree.getRightChild() == null) {
                return size(bTree.getLeftChild()) + 1;
            } else {
                return size(bTree.getLeftChild()) + size(bTree.getRightChild()) + 1;
            }
        }
    }

    @Override
    public void clear() {
        data = null;
        this.leftChild = null;
        this.rightChild = null;
    }

    @Override
    public void dept() {

    }

    @Override
    public Object getRootData() {
        return data;
    }

    @Override
    public void setRootData(Object o) {
        this.data = o;
    }
}
