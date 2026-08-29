class num implements Comparable<num> {
    int n;
    num(int n) {
        this.n = n;
    }
    public int compareTo(num other) {
        return this.n - other.n;
    }
}

class KthLargest {
    HashSet<num> h = new HashSet<>();
    PriorityQueue<num> pq;
    int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue<>();

        for (int x : nums) {
            h.add(new num(x));
        }

        for (num x : h) {
            pq.offer(x);

            if (pq.size() > k) {
                pq.poll();
            }
        }
    }

    public int add(int val) {
        num x = new num(val);

        h.add(x);
        pq.offer(x);

        if (pq.size() > k) {
            pq.poll();
        }

        return pq.peek().n;
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
