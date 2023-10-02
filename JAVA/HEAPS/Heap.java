package JAVA.HEAPS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class Heap {
    public static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }

    }

    int a[];
    int size;

    public Heap() {
        a = new int[100];
        size = 0;
    }

    public void offer(int data) {
        size++;
        int index = size - 1;
        a[index] = data;
        while (index > 0) {
            int parent = index / 2;
            if (a[parent] < a[index]) {
                int temp = a[parent];
                a[parent] = a[index];
                a[index] = temp;
                index = parent;
            } else {
                return;
            }
        }
    }

    public static void heapify(int a[], int n, int size) {
        int left = 2 * n + 1;
        int right = 2 * n + 2;

        int largest = n;
        if (left < size && a[left] > a[largest]) {
            largest = left;
        }
        if (right < size && a[right] > a[largest]) {
            largest = right;
        }

        if (largest != n) {
            int temp = a[n];
            a[n] = a[largest];
            a[largest] = temp;
            heapify(a, largest, size);
        }
    }

    public int poll() {
        if (size == 0) {
            return 0;
        }
        int ans = a[0];
        a[0] = a[size - 1];
        size--;
        int i = 0;
        while (i < size) {
            int largest = i;
            int left = 2 * i + 1;
            int right = 2 * i + 2;

            if (left < size && a[largest] < a[left]) {
                largest = left;
            } else if (right < size && a[largest] < a[right]) {
                largest = right;
            }
            if (largest != i) {
                int temp = a[largest];
                a[largest] = a[i];
                a[i] = temp;
                i = largest;

            } else {
                break;
            }
        }
        return ans;

    }

    public int peek() {
        return a[0];
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;

    }

    public void heapSort(int arr[], int i, int n) {
        while (i < n) {
            int temp = arr[i];
            arr[i] = arr[n - 1];
            arr[n - 1] = temp;
            n--;
            heapify(arr, i, n);
        }
    }

    public int kthMax(int arr[], int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            pq.offer(arr[i]);
        }
        for (int j = k; j < arr.length; j++) {
            if (arr[j] > pq.peek()) {
                pq.poll();
                pq.offer(arr[j]);
            }
        }
        return pq.peek();
    }

    public int kthMin(int arr[], int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < k; i++) {
            pq.offer(arr[i]);
        }
        for (int j = k; j < arr.length; j++) {
            if (arr[j] < pq.peek()) {
                pq.poll();
                pq.offer(arr[j]);
            }
        }
        return pq.peek();
    }

    public int[] mergeHeaps(int[] a, int[] b, int n, int m) {
        int ans[] = new int[n + m];

        // Copy elements from array 'a' to 'ans'
        for (int i = 0; i < n; i++) {
            ans[i] = a[i];
        }

        int len = ans.length;

        // Copy elements from array 'b' to 'ans'
        for (int j = 0; j < m; j++) {
            ans[n + j] = b[j];
        }

        // Build a max-heap from the combined array 'ans'
        for (int k = len / 2 - 1; k >= 0; k--) {
            heapify(ans, k, len);
        }

        return ans;
    }

    public int countNodes(Node root) {
        if (root == null) {
            return 0;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    public boolean isCBT(Node root, int index, int counts) {
        if (root == null) {
            return true;
        }
        if (index >= counts) {
            return false;
        }
        boolean left = isCBT(root.left, 2 * index + 1, counts);
        boolean right = isCBT(root.right, 2 * index + 2, counts);

        return left && right;
    }

    public boolean isMaxOrder(Node root) {
        if (root == null) {
            return true;
        }
        if (root.left != null && root.left.data > root.data) {
            return false;
        }
        if (root.right != null && root.right.data > root.data) {
            return false;
        }
        return isMaxOrder(root.left) && isMaxOrder(root.right);
    }

    public boolean isHeap(Node root) {
        // 1. Check firstis it Complete Binary tree
        // i.Count numnber of node is tree
        // ii.Traverse in Binary tree until size matches to counts.
        // 2. Check whether its Min or Max heap
        int index = 0;
        int counts = countNodes(root);
        if (isCBT(root, index, counts) && isMaxOrder(root)) {
            return true;
        }
        return false;

    }

    public int minCostRopes(int ropes[]) {
        // Given ropes array which consists of rope length
        // Connecting two ropes equal to sum of length of two ropes
        // Find min cost to connect all ropes
        int n = ropes.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < ropes.length; i++) {
            pq.offer(ropes[i]);
        }
        int cost = 0;
        while (pq.size() > 1) {
            int sum = 0;
            int l1 = pq.poll();
            int l2 = pq.poll();
            sum = sum + l1 + l2;
            cost += sum;
            pq.offer(sum);
        }
        return cost;
    }

    public void bstToArray(ArrayList<Integer> list, Node root) {
        if (root == null) {
            return;
        }
        bstToArray(list, root.right);
        list.add(root.data);
        bstToArray(list, root.left);
    }

    public void arrayToHeap(ArrayList<Integer> list, Node root, int index) {
        if (root == null) {
            return;
        }
        root.data = list.get(index++);
        arrayToHeap(list, root.right, index);
        arrayToHeap(list, root.left, index);

    }

    public Node convert_BST_to_MaxHeap(Node root) {
        ArrayList<Integer> list = new ArrayList<>();
        bstToArray(list, root);
        arrayToHeap(list, root, 0);
        return root;
    }

    public int kthLaregestSum(int arr[], int k) {
        if(k>arr.length){
            return -1;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum = sum + arr[j];
                if (pq.size() < k) {
                    pq.offer(sum);
                } else {
                    if (sum > pq.peek()) {
                        pq.poll();
                        pq.offer(sum);
                    }
                }

            }

        }
        return pq.poll();

    }

    public static void main(String[] args) {
        Heap h = new Heap();
        int a[]=new int[]{1,2,3,4,5};
        // int b[]=new int[]{6,4,8,3,2};
        // int ans[]=h.mergeHeaps(a, b, a.length, b.length);
        // for (int i : ans) {
        // System.out.println(i);

        // }
        // Node root=new Node(5);
        // root.left=new Node(6);
        // root.right=new Node(3);
        // System.out.println(h.isHeap(root));
        // int ropes[]={4,2,7,6,9};
        // System.out.println(h.minCostRopes(ropes));
        System.out.println(h.kthLaregestSum(a, 6));

    }

}
