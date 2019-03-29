class MovingAverage {

    /** Initialize your data structure here. */
    double sum = 0;
    int size = 0;
    Queue<Integer> q;
    
    public MovingAverage(int size) {
        this.size = size;
        q = new LinkedList<>();
    }
    
    public double next(int val) {
        q.add(val);
        sum+=val;
        if(q.size()>size){
            sum-=q.poll();
        }
        return sum/q.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
