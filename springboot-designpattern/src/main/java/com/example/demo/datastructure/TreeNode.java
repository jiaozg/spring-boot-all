package com.example.demo.datastructure;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by jiaozhiguang on 2017/10/16.
 * 序列化二叉树时，根据前序遍历方式将二叉树节点的值转换为字符串，如果二叉树节点为空，则以‘#’代替，
 * 每个节点的值以‘，’分隔，反序列化时，也以前序遍历方式从队列中取出数值构建二叉树
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

    String Serialize(TreeNode root) {
        if (root==null)
            return "#,";
        StringBuilder sb = new StringBuilder(root.element + ",");
        sb.append(Serialize(root.left));
        sb.append(Serialize(root.right));
        return sb.toString();
    }

    TreeNode Deserialize(String str) {
        String[] strs = str.split(",");
        Queue<String> q = new LinkedList<>();
        for (int i=0;i<strs.length;i++){
            q.add(strs[i]);
        }
        return PreOrder(q);
    }

    TreeNode PreOrder(Queue<String> q){
        String val = q.poll();
        if (val.equals("#"))
            return null;
        TreeNode node = new TreeNode(Integer.valueOf(val));
        node.left = PreOrder(q);
        node.right = PreOrder(q);
        return node;
    }



}
