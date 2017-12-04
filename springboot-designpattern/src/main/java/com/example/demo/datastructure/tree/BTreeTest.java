package com.example.demo.datastructure.tree;

/**
 * Created by jiaozhiguang on 2017/11/28.
 */
public class BTreeTest {

    public static void main(String args[]) {
        BTree btree = new LinkBTree('A');
        BTree bt1, bt2, bt3, bt4;
        bt1 = new LinkBTree('B');
        btree.addLeftTree(bt1);
        bt2 = new LinkBTree('D');
        bt1.addLeftTree(bt2);

        bt3 =  new LinkBTree('C');
        btree.addRightTree(bt3);
        bt4 =  new LinkBTree('E');
        bt3.addLeftTree(bt4);
        bt4 =  new LinkBTree('F');
        bt3.addRightTree(bt4);

//        System.out.println("树的深度：" + btree.dept());
        System.out.println("树的结点数：" + btree.size());
        System.out.println("是否为空树：" + btree.isEmpty());
        System.out.println("是否为叶子结点：" + btree.isLeaf());
        System.out.println("最左下边结点是否为叶子结点：" + btree.getRightChild().getRightChild().isLeaf());
        System.out.println("root结点：" + btree.root());

        VisitBTree order = new VisitBTree();
        System.out.println("\n前序遍历：");
        order.preOrder(btree);
        System.out.println("\n中序遍历：");
        order.midOrder(btree);
        System.out.println("\n后序遍历：");
        order.postOrder(btree);

        btree.removeLeftChild();
        System.out.println("\n删除左子树后中序遍历为：");
        order.midOrder(btree);
    }

}
