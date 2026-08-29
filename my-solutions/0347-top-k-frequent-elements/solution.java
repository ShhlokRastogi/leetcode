class num implements Comparable<num> {
    int n;
    int freq;

    num(int n, int freq) {
        this.n = n;
        this.freq = freq;
    }

    public int compareTo(num other) {
        return other.freq - this.freq;
    }
}

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> fmap = new HashMap<>();

        for (int i : nums) {
            fmap.put(i, fmap.getOrDefault(i, 0) + 1);
        }

        PriorityQueue<num> pq = new PriorityQueue<>();

        for (int i : fmap.keySet()) {
            pq.offer(new num(i, fmap.get(i)));
        }

        int[] ans = new int[k];

        for (int i = 0; i < k; i++) {
            ans[i] = pq.poll().n;
        }

        return ans;
    }
}
