package SwordForOffer;

public class ConvertBTree {

     static class TreeNode {
     int val = 0;
     TreeNode left = null;
     TreeNode right = null;

     public TreeNode(int val) {
     this.val = val;

     }

     }
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) return pRootOfTree;
        TreeNode tmp = pRootOfTree;
        convertCore(null, pRootOfTree);
        while (tmp.left != null){
            tmp = tmp.left;
        }
         return tmp;
    }

    public TreeNode convertCore(TreeNode pre, TreeNode now){
         if (now.left != null){
             convertCore(now, now.left);
         }else {
             now.left = pre;
         }
         if (now.right != null){
             convertCore(now, now.right);
         }else {
             now.right = pre;
         }
         return now;
    }
}
