package code.interval;

import java.util.Arrays;

public class CanAttendMeetings {
    public boolean canAttendMeetings(int[][] intervals) {
        if(intervals.length<=1){
            return true;
        }
        Arrays.sort(intervals, (a,b)-> a[1]!=b[1] ? Integer.compare(a[1],b[1]): Integer.compare(a[0],b[0]));
        int end = intervals[0][1];
        for(int i =1 ;i<intervals.length;i++){
            if(end<=intervals[i][0]){
                end = intervals[i][1];
            }else{
                return false;
            }
        }
        return true;
    }
}
