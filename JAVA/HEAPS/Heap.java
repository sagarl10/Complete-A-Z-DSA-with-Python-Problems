package JAVA.HEAPS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Heap {
    public static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data) {
            this.data = data;
        }

    }

    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    public class Element implements Comparable<Element> {
        int data;
        int row;
        int col;

        public Element(int data, int row, int col) {
            this.data = data;
            this.row = row;
            this.col = col;
        }

        @Override
        public int compareTo(Element o) {
            // TODO Auto-generated method stub
            return Integer.compare(this.data, o.data);
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

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    public boolean isCBT(TreeNode root, int index, int counts) {
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

    public boolean isMaxOrder(TreeNode root) {
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

    public boolean isHeap(TreeNode root) {
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

    public void bstToArray(ArrayList<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }
        bstToArray(list, root.right);
        list.add(root.data);
        bstToArray(list, root.left);
    }

    public void arrayToHeap(ArrayList<Integer> list, TreeNode root, int index) {
        if (root == null) {
            return;
        }
        root.data = list.get(index++);
        arrayToHeap(list, root.right, index);
        arrayToHeap(list, root.left, index);

    }

    public TreeNode convert_BST_to_MaxHeap(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        bstToArray(list, root);
        arrayToHeap(list, root, 0);
        return root;
    }

    public int kthLaregestSum(int arr[], int k) {
        if (k > arr.length) {
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

    public ArrayList<Integer> mergeKsortedArray(ArrayList<ArrayList<Integer>> list) {
        PriorityQueue<Element> pq = new PriorityQueue<>(list.size(), Comparator.comparingInt(e -> e.data));
        for (int i = 0; i < list.size(); i++) {
            pq.offer(new Element(list.get(i).get(0), i, 0));
        }
        ArrayList<Integer> ans = new ArrayList<>();
        while (!pq.isEmpty()) {
            Element e = pq.poll();
            int data = e.data;
            int row = e.row;
            int col = e.col;

            ans.add(data);

            if (col + 1 < list.get(row).size()) {
                pq.offer(new Element(list.get(row).get(col + 1), row, col + 1));
            }
        }
        return ans;
    }

    public Node mergeKsortedLL(ArrayList<Node> list) {
        PriorityQueue<Node> pq = new PriorityQueue<>(list.size(), Comparator.comparingInt(n -> n.data));
        for (Node node : list) {
            pq.offer(node);
        }
        Node dummyhead = new Node(-1);
        Node cur = dummyhead;

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            cur.next = node;
            cur = cur.next;
            if (node.next != null) {
                pq.offer(node.next);
            }
        }
        return dummyhead.next;

    }

    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<Element> pq = new PriorityQueue<Element>(Comparator.comparingInt(e -> e.data));
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.size(); i++) {
            if (!nums.get(i).isEmpty()) {
                int val = nums.get(i).get(0);
                pq.offer(new Element(val, i, 0));
                max = Math.max(max, val);
                min = Math.min(min, val);
            }
        }
        int start = min;
        int end = max;
        while (!pq.isEmpty()) {
            Element e = pq.poll();
            int data = e.data;
            int row = e.row;
            int col = e.col;
            min = data;
            if (max - min < end - start) {
                start = min;
                end = max;
            }

            if (col + 1 < nums.get(row).size()) {
                int val = nums.get(row).get(col + 1);
                pq.offer(new Element(val, row, col + 1));
                max = Math.max(max, val);
            } else {
                break;
            }

        }
        return new int[] { start, end };

    }

    public static void main(String[] args) {
        Heap h = new Heap();
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>(Arrays.asList(1, 2, 3, 4)));
        list.add(new ArrayList<>(Arrays.asList(5, 7, 9, 10)));
        list.add(new ArrayList<>(Arrays.asList(30, 31, 33, 40)));
        list.add(new ArrayList<>(Arrays.asList(41, 47, 49, 70)));
        ArrayList<Integer> ans = h.mergeKsortedArray(list);
        for (Integer integer : ans) {
            System.out.println(integer);
        }
        ArrayList<Node> nodes = new ArrayList<>();
        nodes.add(new Node(3));
        nodes.add(new Node(2));
        nodes.add(new Node(1));

        Node ans1 = h.mergeKsortedLL(nodes);
        while (ans1 != null) {
            System.out.println(ans1.data);
            ans1 = ans1.next;
        }

    }

}
