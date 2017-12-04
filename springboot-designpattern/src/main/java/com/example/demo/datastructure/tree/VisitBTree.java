package com.example.demo.datastructure.tree;

/**
 * Created by jiaozhiguang on 2017/11/28.
 */
public class VisitBTree {

    /**
     * 前序遍历
     * @param root
     */
    public void preOrder(BTree root) {
        visit(root);
        if (root.hasLeftChild()) {
            preOrder(root.getLeftChild());
        }
        if (root.hasRightChild()) {
            preOrder(root.getRightChild());
        }
    }

    /**
     * 中序遍历
     * @param root
     */
    public void midOrder(BTree root) {
        if (root.hasLeftChild()) {
            midOrder(root.getLeftChild());
        }
        visit(root);
        if (root.hasRightChild()) {
            midOrder(root.getRightChild());
        }
    }
    /**
     * 后序遍历
     * @param root
     */
    public void postOrder(BTree root) {
        if (root.hasLeftChild()) {
            postOrder(root.getLeftChild());
        }
        if (root.hasRightChild()) {
            postOrder(root.getRightChild());
        }
        visit(root);
    }


    public void visit(BTree bTree) {
        System.out.println(bTree.getRootData() + "\t");
    }

}
