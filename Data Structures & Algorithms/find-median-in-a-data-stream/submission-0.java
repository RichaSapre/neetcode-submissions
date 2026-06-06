class MedianFinder {

    private PriorityQueue<Integer> lo; // max heap
    private PriorityQueue<Integer> hi; // min heap

    public MedianFinder() {

        lo = new PriorityQueue<>((a, b) -> b - a);
        hi = new PriorityQueue<>();

    }
    
    public void addNum(int num) {
        lo.offer(num); // add to max heap
        hi.offer(lo.poll());

        if(lo.size() < hi.size()){
            lo.offer(hi.poll());
        }

        
    }
    
    public double findMedian() {
        return lo.size() > hi.size() ? lo.peek() :(lo.peek()+ hi.peek()) * 0.5;
        
    }
}
