

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import JAVA.LINKED_LIST.LinkedList;

public class BinaryTree {
    public Node root;

    public List<Integer> inorderTraversal(Node root){
        List<Integer> list = new ArrayList<>();
        if (root == null){
            return list;
        }
        
        List<Integer> l1 = inorderTraversal(root.left);
        list.addAll(l1);
        
        list.add(root.data);
        
        List<Integer> l2 = inorderTraversal(root.right);
        list.addAll(l2);

        return list; 
    }
    public List<Integer> preorderTraversal(Node root){
        List<Integer> list = new ArrayList<>();
        if (root == null){
            return list;
        }
        list.add(root.data);
        List<Integer> l1 = preorderTraversal(root.left);
        list.addAll(l1);
        
        List<Integer> l2 = preorderTraversal(root.right);
        list.addAll(l2);

        return list; 
    }
    public List<Integer> postorderTraversal(Node root){
        List<Integer> list = new ArrayList<>();
        if (root == null){
            return list;
        }
        
        List<Integer> l1 = postorderTraversal(root.left);
        list.addAll(l1);
    
        List<Integer> l2 = postorderTraversal(root.right);
        list.addAll(l2);
        list.add(root.data);

        return list; 
    }
    public List<Integer> bfs(Node root){
        List<Integer> list=new ArrayList<>();
        if(root==null){
            return list;
        }
        Queue<Node> q = (Queue) new LinkedList();
        q.offer(root);
        while(!q.isEmpty()){
            Node current=(Node) q.poll();
            list.add(current.data);
                if(current.left!=null){
                    q.offer(current.left);
                }
                if(current.right!=null){
                    q.offer(current.right);
                }

        }
        
        return list;
        
    }
     

   
    public static void main(String[] args) {
        BinaryTree bt=new BinaryTree();
        Node node=new Node(1);
        bt.root=node;
        Node n2=bt.root.left=new Node(2);
        Node n3=bt.root.right=new Node(3);
        n2.left=new Node(4);
        n2.right=new Node(5);
        n3.left=new Node(6);
        n3.right=new Node(7);

        List<Integer> list=bt.inorderTraversal(bt.root);
        for (Integer integer : list) {
            System.out.println(integer);
            
        }
        System.out.println("---------------------------------------------------");
        List<Integer> list1=bt.preorderTraversal(bt.root);
        for (Integer integer : list1) {
            System.out.println(integer);
            
        }
        System.out.println("---------------------------------------------------");
        List<Integer> list2=bt.postorderTraversal(bt.root);
        for (Integer integer : list2) {
            System.out.println(integer);
            
        }
        ArrayList<Integer> l=(ArrayList<Integer>) bt.bfs(bt.root);
        for (Integer integer : l) {
            System.out.println(integer);
        }

    }
    
}
