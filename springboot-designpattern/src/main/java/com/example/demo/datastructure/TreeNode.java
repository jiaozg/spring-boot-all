package com.example.demo.datastructure;

/**
 * Created by jiaozhiguang on 2017/10/16.
 */
class TreeNode<E> {

    E element;
    TreeNode<E> left;
    TreeNode<E> right;

    public TreeNode(E e) {
        element = e;
    }
    //先序遍历
    protected void preorder(TreeNode<E> root) {

        if (root == null)
            return;

        System.out.println(root.element + " ");

        preorder(root.left);

        preorder(root.right);
    }
    //中序遍历
    protected void inorder(TreeNode<E> root) {

        if (root == null)
            return;

        inorder(root.left);

        System.out.println(root.element + " ");

        inorder(root.right);
    }
    //后序遍历
    protected void postorder(TreeNode<E> root) {

        if (root == null)
            return;

        postorder(root.left);

        postorder(root.right);

        System.out.println(root.element + " ");
    }



}
