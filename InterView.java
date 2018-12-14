
import java.util.*;
import java.io.IOException;

/// build a tree template code

class InterView{
    static TreeNode root;

    public static void main(String[] args) throws IOException {
        

       
        // 建立BST 
        int[] A = new int[] {4,2,6,1,3,5,7};
        TreeNode root = buildTree(A);
        System.out.println(root.val);
        System.out.println(root.right.val);
        System.out.println(root.left.val);            
    }



    public static TreeNode insert(TreeNode root, int x){
        if(root == null) {
            root = new TreeNode(x);
            return root;
        }
        if(x> root.val){
            root.right = insert(root.right, x);
            return root; 
        }else {
            root.left = insert(root.left, x);
            return root;
        }

    }
    public static TreeNode buildTree(int[] A){
        TreeNode root = null;
        for(int i=0;i<A.length ; i++){
            root = insert(root, A[i]);
        }
        return root;
    }


}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode (int x ){
        val =x;
    }
}