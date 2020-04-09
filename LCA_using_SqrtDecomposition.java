/*********************************************************************************************************************
     **
     **  LCA of BST using Sqrt Decomposition algorithm
     **  Queue, DFS, HashMap is used 
     **  Input in the form of array
     **  Output is Lowest Common Ancestor
     
     **  Written By:    Akash Vishwas Londhe
     **
*********************************************************************************************************************/

//import package
import java.util.*;
import java.math.*;

//main class
public class Main
{
    public static void main (String[] args) 
    {
        String []a={"3","5","1","6","2","0","8","null","null","7","4"};
        TreeNode root=new TreeNode().createTree(a);
        
        
        TreeNode ans=new Solution().lowestCommonAncestor(root,new TreeNode(5),new TreeNode(3));
        System.out.println("The LCA of nodes "+5 +" and "+ 1+" is :"+ans.val);
    }
}

//class TreeNode to store tree
class TreeNode 
{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode()
    {}
    TreeNode(int x)
    {
        val = x;
        left=null;
        right=null;
    }
    public static TreeNode createTree(String []a)
    {
        String s=a[0];
        TreeNode root=new TreeNode(Integer.parseInt(s));
        Queue<TreeNode>queue=new LinkedList<>();
        queue.add(root);
        int i=1;
        while(queue.size()!=0)
        {
            TreeNode t=queue.poll();
            if(i==a.length)
                break;
            s=a[i++];
            if(!s.equals("null"))
            {
                t.left=new TreeNode(Integer.parseInt(s));
                queue.add(t.left);
            }
            if(i==a.length)
                break;
            s=a[i++];
            if(!s.equals("null"))
            {
                t.right=new TreeNode(Integer.parseInt(s));
                queue.add(t.right);
            }
        }
        return root;
    }
    
 }

 //class solution to calculate LCA
class Solution 
{
    
	//Hashmap to store depth, parent & node in block 
    static HashMap<Integer,Integer>depth=new HashMap<>();
    static HashMap<Integer,Integer>parent=new HashMap<>();
    static HashMap<Integer,Integer>block=new HashMap<>();
    static int size;
    
    public void dfs(TreeNode t,int cur,int prev)
    {
        depth.put(cur,depth.get(prev)+1);
        parent.put(cur,prev);

		//store only one node in each block whose depth is multiple of size
        if(depth.get(cur)%size==0)
            block.put(cur,parent.get(cur));
        else
            block.put(cur,block.get(prev));
    
        if(t.left!=null)
            dfs(t.left,t.left.val,cur);
        if(t.right!=null)
            dfs(t.right,t.right.val,cur);
            
    }
    
	//calculate LCA of 2 nodes which are in same block
    public int lca(int u,int v)
    {
        
        if(u==v)
            return u;
    
        if(depth.get(u)>depth.get(v))
        {
            int tmp=u;
            u=v;
            v=tmp;
        }
        
        v=parent.get(v);
        return lca(u,v);
        
    }

	//take 2 nodes in same block
    public int lca_sqrt(int u,int v)
    {
        while(block.get(u)!=block.get(v))
        {
            if(depth.get(u)>depth.get(v))
            {
                int tmp=u;
                u=v;
                v=tmp;
            }
            v=block.get(v);
        }
        return lca(u,v);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) 
    {
        //height is considered directly but we can calculate which is maximum depth
        int height=4;
        
        size=(int)Math.sqrt(4);
        
        depth.put(0,-1);
        dfs(root,root.val,0);
        
        int t=lca_sqrt(p.val,q.val);
        return new TreeNode(t);
        
    }
    
}