class MedianFinder {

    PriorityQueue<Integer> minheapright;
    PriorityQueue<Integer> maxheapleft;

    public MedianFinder() {
        minheapright = new PriorityQueue<>();
        maxheapleft = new PriorityQueue<>((a, b) -> b - a);
    }

    public void addNum(int num) {

        //insertion
        if(maxheapleft.isEmpty() || num <= maxheapleft.peek()){
            maxheapleft.offer(num);
        }else{
            minheapright.offer(num);
        }

        //balancing the heap sizes
        if(minheapright.size() > maxheapleft.size()){
            maxheapleft.offer(minheapright.poll());
        }
        else if(maxheapleft.size() > minheapright.size() + 1){
            minheapright.offer(maxheapleft.poll());
        }
    }

    public double findMedian() {

        if(maxheapleft.size() > minheapright.size()){
            return maxheapleft.peek();
        }

        return (maxheapleft.peek() + minheapright.peek()) / 2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
