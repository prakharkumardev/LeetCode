package code.interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeInterval {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a, b) -> Integer.compare(a[0],b[0]));
        List<int[]> ans = new ArrayList<>();
        int n = intervals.length;
        int i = 1;
        int currentMin = intervals[0][0];
        int currentMax = intervals[0][1];

        while(i<n){
            if(intervals[i][0] <= currentMax){
                currentMin = Math.min(currentMin, intervals[i][0]);
                currentMax = Math.max(currentMax, intervals[i][1]);
                i++;
            }else{
                ans.add(new int[]{currentMin, currentMax});
                currentMin = intervals[i][0];
                currentMax = intervals[i][1];
                i++;
            }
        }
        ans.add(new int[]{currentMin, currentMax});
        return ans.toArray(new int[ans.size()][2]);




    }
}
