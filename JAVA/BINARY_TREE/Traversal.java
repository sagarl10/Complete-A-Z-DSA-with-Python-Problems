

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;

public class Traversal {
    BinaryTree bt=new BinaryTree();
    public Traversal(BinaryTree bt){
        this.bt=bt;
    }
    
    public List<Integer> preOrder(Node root){
        List<Integer> list=new ArrayList<>();
        Stack<Node> s=new Stack<>();
        s.push(root);

        while(!s.isEmpty()){
            Node cur=s.pop();
            list.add(cur.data);
            if(cur.right!=null){
                s.push(cur.right);
            }
            if(cur.left!=null){
                s.push(cur.left);
            }
        }
        return list;
        
    }
    public List<Integer> inOrder(Node root){
        List<Integer> list=new ArrayList<>();
        Stack<Node> s=new Stack<>();
        Node cur=root;

        while(cur!=null || !s.isEmpty()){
            while(cur!=null){
                s.push(cur);
                cur=cur.left;
            }
            cur=s.pop();
            list.add(cur.data);
            cur=cur.right;
        }
        return list;
        
    }

    public int height(Node root){
        if(root==null){
            return 0;
        }
        int left=height(root.left);
        int right=height(root.right);

        return Math.max(left,right)+1;
    }
    public int check_bal(Node root){
        if (root==null){
            return 0;
        }
        int left=check_bal(root.left);
        if(left==-1){
            return -1;
        }
        int right=check_bal(root.right);
        if(right==-1){
            return -1;
        }
        if(Math.abs(left-right)>=1){
            return -1;
        }
        return Math.max(left,right)+1;
    }

    public boolean isBalanced(Node root){
        if(root==null){
            return true;
        }
        if(check_bal(root)==-1){
            return false;
        }
        return true;
    }
    public  int diameter(Node root,int[] maxi){
        if(root==null){
            return 0;
        }
        int left=diameter(root.left, maxi);
        int right=diameter(root.right, maxi);
        maxi[0]=Math.max(maxi[0], left+right);
        return Math.max(left,right)+1;

    }
    public List<List<Integer>> zigzag(Node root){
        List<List<Integer>> list=new ArrayList<>();
        Queue<Node> q=new LinkedList();
        q.offer(root);
        boolean lefttoright=true;
        while(!q.isEmpty()){
            int size=q.size();
            List<Integer> l=new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node cur=q.poll();
                if(lefttoright){
                    l.add(cur.data);
                }
                else{
                    l.add(0,cur.data);
                }
                if(cur.left!=null){
                    q.offer(cur.left);
                }
                if(cur.right!=null){
                    q.offer(cur.right);
                }
                
            }
            lefttoright=!lefttoright;
            list.add(l);
        }
        return list;
    }
    public void left_tree(Node root_l,List<Integer> list){
        if(root_l==null || root_l.left==null && root_l.right==null){
            return;
        }
        if(root_l!=null){
            list.add(root_l.data);
            left_tree(root_l.left, list);
        }
        else{
            list.add(root_l.data);
            left_tree(root_l.right, list);
        }

    }
    public void leaf_nodes(Node root,List<Integer> list){
        if(root==null){
            return;
        }
        if(root.left==null && root.right==null){
            list.add(root.data);
        }
        leaf_nodes(root.left, list);
  
        leaf_nodes(root.right, list);
        

    }
    public void right_tree(Node root_r,List<Integer> list){
        if(root_r==null || root_r.left==null && root_r.right==null){
            return;
        }
        if(root_r!=null){
            right_tree(root_r.right, list);
            list.add(root_r.data);
        }
        else{
            right_tree(root_r.left, list);
            list.add(root_r.data);
        }

    }
    public List<Integer> boundary_tra(Node root){
        List<Integer> list=new ArrayList<>();
        list.add(root.data);
        left_tree(root.left, list);
        leaf_nodes(root, list);
        right_tree(root.right, list);

        return list;

        
    }
    public List<List<Integer>> reverse_level_order(Node root){
        List<List<Integer>> list=new ArrayList<>();
        Queue<Node> q=new LinkedList();
        q.offer(root);
        while(!q.isEmpty()){
            int size=q.size();
            List<Integer> l=new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node cur=q.poll();
                l.add(cur.data);
                if(cur.left!=null){
                    q.offer(cur.left);
                }
                if(cur.right!=null){
                    q.offer(cur.right);
                }
                
            }
            list.add(0,l);
        }
        return list;

    }
    public List<Integer> top_view(Node root){
        List<Integer> list=new ArrayList<>();
        if(root==null){
            return list;
        }
        TreeMap<Integer,Integer> t=new TreeMap<>();
        Queue<Pair> q=new LinkedList<>();
        q.offer(new Pair(root,0));
        while(!q.isEmpty()){
            int size=q.size();
            for (int i = 0; i < size; i++) {
                Pair p=q.poll();
                int hd=p.hd;
                Node cur=p.node;
                if(t.get(hd)==null){
                    t.put(hd, cur.data);
                }
                if(cur.left!=null){
                    q.offer(new Pair(cur.left, hd-1));
                }
                if(cur.right!=null){
                    q.offer(new Pair(cur.right, hd+1));
                }
                
            }
        }
        for (Integer i: t.keySet()) {
            list.add(t.get(i));
            
        }
        return list;

    }
    public List<Integer> bottom_view(Node root){
        List<Integer> list=new ArrayList<>();
        if(root==null){
            return list;
        }
        TreeMap<Integer,Integer> t=new TreeMap<>();
        Queue<Pair> q=new LinkedList<>();
        q.offer(new Pair(root,0));
        while(!q.isEmpty()){
            int size=q.size();
            for (int i = 0; i < size; i++) {
                Pair p=q.poll();
                int hd=p.hd;
                Node cur=p.node;
                t.put(hd, cur.data);
                if(cur.left!=null){
                    q.offer(new Pair(cur.left, hd-1));
                }
                if(cur.right!=null){
                    q.offer(new Pair(cur.right, hd+1));
                }

            }
        }
        for (Integer i: t.keySet()) {
            list.add(t.get(i));
            
        }
        return list;

    }
    public void solve_left(Node root,int level,List<Integer> list){
        if(root==null){
            return;
        }
        if(level==list.size()){
            list.add(root.data);
        }
        solve_left(root.left, level+1, list);
        solve_left(root.right, level+1, list);
    }
      public void solve_right(Node root,int level,List<Integer> list){
        if(root==null){
            return;
        }
        if(level==list.size()){
            list.add(root.data);
        }
        solve_right(root.right, level+1, list);
        solve_right(root.left, level+1, list);
        
    }
    
    public List<Integer> left_view(Node root){
        List<Integer> list=new ArrayList<>();
        solve_left(root, 0, list);
        return list;
    }
    public List<Integer> right_view(Node root){
        List<Integer> list=new ArrayList<>();
        solve_right(root, 0, list);
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
        n3.right.left=new Node(8);
        n3.right.right=new Node(9);
        Traversal t=new Traversal(bt);
        List<Integer> list=t.preOrder(bt.root);
        for (Integer integer : list) {
            System.out.println(integer);
        }
        System.out.println("--------------------------------------------");
        List<Integer> list1=t.inOrder(bt.root);
        for (Integer integer : list1) {
            System.out.println(integer);
        }
        System.out.println("-----------------------------------------------");
        System.out.println(t.height(bt.root));
        System.out.println("-----------------------------------------------");
        System.out.println(t.isBalanced(bt.root));
        System.out.println("-----------------------------------------------");
        int maxi[]=new int[1];
        t.diameter(bt.root,maxi);
        System.out.println(maxi[0]);

        System.out.println("-----------------------------------------------");
        List<List<Integer>> list2=t.zigzag(bt.root);
        for (List<Integer> list3 : list2) {
            for (Integer integer: list3) {
                System.out.println(integer);
                
            }
            
        }
        System.out.println("-----------------------------------------------");
        List<Integer> l4=t.boundary_tra(bt.root);
        for (Integer integer : l4) {
            System.out.println(integer);
        }
        System.out.println("-----------------------------------------------");
        List<List<Integer>> l5=t.reverse_level_order(bt.root);
        for (List<Integer> integer : l5) {
            System.out.println(integer);
        }
        System.out.println("-----------------------------------------------");
        List<Integer> l6=t.top_view(bt.root);
        for (Integer integer : l6) {
            System.out.println(integer);
        }
        System.out.println("-----------------------------------------------");
        List<Integer> l7=t.bottom_view(bt.root);
        for (Integer integer : l7) {
            System.out.println(integer);
        }
        System.out.println("-----------------------------------------------");
        List<Integer> l8=t.left_view(bt.root);
        System.out.println(l8);
        System.out.println("-----------------------------------------------");
        List<Integer> l9=t.right_view(bt.root);
        System.out.println(l9);
    }
    }



