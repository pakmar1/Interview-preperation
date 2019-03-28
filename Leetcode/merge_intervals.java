class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<Interval>();
        if(intervals.size() == 0) return res;
        Collections.sort(intervals, new Comparator<Interval>(){
           public int compare(Interval a, Interval b){
               return a.start - b.start;
           } 
        });
        Interval cur = intervals.get(0);
        for(int i = 1; i < intervals.size(); i++){
            if(intervals.get(i).start > cur.end){
                res.add(cur);
                cur = intervals.get(i);
            } else {
                cur.end = Math.max(cur.end, intervals.get(i).end);
            }
        }
        res.add(cur);
        return res;
    }
}
