package code.interval;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int i = 0;
        int newIntervalStart = newInterval[0];
        int newIntervalEnd = newInterval[1];
        List<int[]> ans = new ArrayList<>();
        int len = intervals.length;
        //add left
        while(i<len && newIntervalStart > intervals[i][1]){
            ans.add(intervals[i]);
            i++;
        }
        //add middle
        while(i<len && newIntervalEnd >= intervals[i][0]){
            newIntervalStart = Math.min(newIntervalStart, intervals[i][0]);
            newIntervalEnd = Math.max(newIntervalEnd,intervals[i][1]);
            i++;
        }
        ans.add(new int[]{newIntervalStart,newIntervalEnd});
        while (i<len){
            ans.add(intervals[i]);
            i++;
        }
        return ans.toArray(new int[ans.size()][2]);
    }
}
