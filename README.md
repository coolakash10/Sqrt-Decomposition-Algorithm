# Sqrt-Decomposition-Algorithm
Algorithm to work with block instead of working with whole array

The key concept of this technique is to decompose given array into small chunks specifically of size sqrt(n).

There are total 3 code 

  1. LCA without Sqrt: This code is about calculation of lowest common ancestor of 2 nodes in a given tree.
                       The naive approach is using depth first search. 
                       First of all we start jumping one parent above for highest depth node till we reach the depth value of second node.
                       Now both nodes are at same depth. Therefore, now both the nodes will jump one parent up till both the nodes become equal. 
                       This end node at which both the nodes become equal for the first time is our LCA.
                       
    But drawback is in worst case time complexity is 0(h) where h is heigh of tree
   
  2. LCA with Sqrt decomposition: The same approach as above but categorize nodes of the tree into different groups according to their depth. 
                      If h is height of tree then it will be having sqrt(h) blocks or groups. 
                      Nodes from depth 0 to depth sqrt(h) – 1 lie in first group.
                      Nodes having depth sqrt(H) to 2*sqrt(h)-1 lie in second group and so on till last node. 
                      
    Advantage over naive approach is in worst case time complexity is 0(sqrt(h)) where h is heigh of tree.
    
  3. Minimum from array in given range: Array is divide into different block according index of array.
                      If n is length of array then it will be having sqrt(n) blocks or groups. 
                      Then calculation of minimum in that group is 0(1)
                      
    Advantage over naive approach is in worst case time complexity is 0(sqrt(n)) where n is length of array.                      
                       
