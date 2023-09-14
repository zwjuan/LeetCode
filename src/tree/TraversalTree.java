package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的遍历：
 * 1. 前序遍历 - 根 - 左 - 右  （非递归实现时，双层while循环）
 * 2. 中序遍历 - 左 - 根 - 右  （递归时，left树遍历完后，插入结点值）
 * 3. 后序遍历 - 左 - 右 - 根   (非递归遍历时，注意保存pre变量)
 * 4. 层序遍历 - 记录每层的结点数
 */
public class TraversalTree {
    public static void main(String[] args) {

    }

    /**
     * 层序遍历
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        List<TreeNode> list = new LinkedList<>();

        if (root == null) {
            return result;
        }

        TreeNode cur = root;
        list.add(cur);
        while(!list.isEmpty()) {
            int size = list.size(); // 每层的个数
            List<Integer> level = new ArrayList<>();
            while(size > 0) {
                cur = list.remove(0);
                level.add(cur.val);

                if (cur.left != null) {
                    list.add(cur.left);
                }

                if (cur.right != null) {
                    list.add(cur.right);
                }
                size--;
            }
            result.add(level);
        }
        return result;
    }


    /**
     * 3. 后序遍历 - 递归
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }
        postorderTraversal_D(root, result);
        return result;

    }

    public void postorderTraversal_D(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        postorderTraversal_D(root.left, result);
        postorderTraversal_D(root.right, result);
        result.add(root.val);
    }

    /**
     * 后序遍历 - 非递归
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        List<TreeNode> list = new LinkedList<>();
        TreeNode node = root, pre = null;

        while (!list.isEmpty() || node != null) {
            while(node != null) {
                list.add(node);
                node = node.left;
            }
            node = list.remove(list.size()-1);
            if (node.right == null || node.right == pre) {  //说明没有右子树，直接获取值
                result.add(node.val);
                pre = node;
                node = null;
            } else { //遍历右子树
                list.add(node);
                node = node.right;
            }

        }

        return result;

    }

    /**
     * 2. 中序遍历 - 递归
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }
        inorderTraversal_D(root, result);
        return result;
    }

    public void inorderTraversal_D(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        inorderTraversal_D(root.left, result);
        result.add(root.val);
        inorderTraversal_D(root.right, result);

    }

    /**
     * 中序遍历 - 非递归
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        List<TreeNode> list = new LinkedList<>();
        TreeNode cur = root;

        while(!list.isEmpty() || cur != null) {
            while(cur != null) {
                list.add(cur);
                cur = cur.left;
            }
            cur = list.remove(list.size()-1);
            result.add(cur.val);
            cur = cur.right;
        }
        return result;
    }



    /**
     * 1. 前序遍历 - 递归思想
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();

        if (root == null) {
            return ret;
        }
        preorderTraversal_D(root, ret);
        return ret;
    }

    public void preorderTraversal_D(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        list.add(root.val);
        preorderTraversal_D(root.left, list);
        preorderTraversal_D(root.right, list);

    }

    /**
     * 前序遍历 - 非递归思想
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> ret = new ArrayList<>();

        if (root == null) {
            return ret;
        }

        List<TreeNode> linkedList = new LinkedList<>();
        TreeNode cur = root;

        while(!linkedList.isEmpty() || cur != null) {
            while(cur != null) {
                ret.add(cur.val);
                linkedList.add(cur);
                cur = cur.left;
            }
            cur = linkedList.remove(linkedList.size()-1).right;
        }
        return ret;
    }

}

