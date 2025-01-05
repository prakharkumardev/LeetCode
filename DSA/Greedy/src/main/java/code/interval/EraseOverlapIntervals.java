package code.interval;

import java.util.Arrays;

public class EraseOverlapIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->
                a[1]!=b[1]? Integer.compare(a[1],b[1]) :
                        Integer.compare(a[0],b[0]));

        int finish = intervals[0][1];
        int maxInterval = 1;
        for(int i = 1;i<intervals.length;i++){
            if(finish<=intervals[i][0]){
                finish = intervals[i][1];
                maxInterval ++ ;
            }
        }
        return intervals.length - maxInterval;

    }
}
