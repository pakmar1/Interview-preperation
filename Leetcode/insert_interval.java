/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
     public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        int n = intervals.size();
        
        List<Interval> ans = new ArrayList<>();
        
        boolean newIntervalInserted = false;
        
        for(int i = 0; i < n; i++)
        {
            if(isOverlapping(intervals.get(i), newInterval))
            {
                newInterval = merge(intervals.get(i), newInterval);
            } 
            else if(intervals.get(i).end < newInterval.start)
            {
                ans.add(intervals.get(i));
            }
            else if(intervals.get(i).start > newInterval.end)
            {
                if(!newIntervalInserted)
                {
                    ans.add(newInterval);
                    newIntervalInserted = true;
                }
                ans.add(intervals.get(i));
            }
        }
        
        if(!newIntervalInserted)
        {
            ans.add(newInterval);
        }
        
        return ans;
    }
    
    boolean isOverlapping(Interval a, Interval b)
    {
        if(a.end < b.start || b.end < a.start)
            return false;
        return true;
    }
    
    Interval merge(Interval a, Interval b)
    {
        Interval merged = new Interval(Math.min(a.start, b.start), Math.max(a.end, b.end));
        
        return merged;
    }
}
