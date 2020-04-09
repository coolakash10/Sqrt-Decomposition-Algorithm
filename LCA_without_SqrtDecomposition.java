/*********************************************************************************************************************
     **
     **  LCA of BST
     **  Queue, DFS, HashMap is used 
     **  Input in the form of array
     **  Output is Lowest Common Ancestor
     
     **  Written By:    Akash Vishwas Londhe
     **
*********************************************************************************************************************/

//import package

import java.util.*;
import java.math.*;

//Main class 
public class Main
{
    public static void main (String[] args) 
    {
		//node is taken from BFT
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

 //class Solution to calculate LCA
class Solution 
{
    
	//HashMap to store depth & parent of each node
    static HashMap<Integer,Integer>depth=new HashMap<>();
    static HashMap<Integer,Integer>parent=new HashMap<>();
    
	//dfs traversal
    public void dfs(TreeNode t,int cur,int prev)
    {
        depth.put(cur,depth.get(prev)+1);
        parent.put(cur,prev);
    
        if(t.left!=null)
            dfs(t.left,t.left.val,cur);
        if(t.right!=null)
            dfs(t.right,t.right.val,cur);
            
    }
    
	//lca calculation
    public int lca(int u,int v)
    {
        
        if(u==v)
            return u;
    
		//always keep depth of v more than u
        if(depth.get(u)>depth.get(v))
        {
            int tmp=u;
            u=v;
            v=tmp;
        }
        
        v=parent.get(v);
        return lca(u,v);
        
    }
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) 
    {
        
        depth.put(0,-1);
        dfs(root,root.val,0);
        
        int t=lca(p.val,q.val);
        return new TreeNode(t);
        
    }
    
}