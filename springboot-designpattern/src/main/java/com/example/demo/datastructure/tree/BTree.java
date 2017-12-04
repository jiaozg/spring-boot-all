package com.example.demo.datastructure.tree;

/**
 * Created by jiaozhiguang on 2017/11/28.
 */
public interface BTree {

    void addLeftTree(BTree leftChild);

    void addRightTree(BTree rightChild);

    BTree getLeftChild();

    BTree getRightChild();

    boolean hasLeftChild();

    boolean hasRightChild();

    void removeLeftChild();

    void removeRightChild();

    boolean isEmpty();

    boolean isLeaf();

    BTree root();

    int size();

    int size(BTree bTree);

    /**
     * 置空树
     */
    void clear();

    /**
     * 树的深度
     */
    void dept();

    Object getRootData();

    void setRootData(Object o);


}
