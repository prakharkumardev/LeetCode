package code.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MinCostTicket {
    private Set<Integer> isTravelNeeded = new HashSet<>();
    public int mincostTickets(int[] days, int[] costs) {
        int len = days.length;
        int[] dp  = new int[days[len - 1] + 1];
        Arrays.fill(dp, -1);
        for(int day : days) {
            isTravelNeeded.add(day);
        }
        return minCost(days, costs, days[0], dp);
    }

    private int minCost(int[] days, int[] costs, int day, int[] dp) {
        int lastDay = days[days.length - 1];
        if(day > lastDay) {
            return 0;
        }
        if(!isTravelNeeded.contains(day)) {
            return minCost(days, costs, day + 1, dp);
        }
        if(dp[day] > 0){
            return dp[day];
        }
        int oneDayPass = minCost(days, costs, day + 1, dp) + costs[0];
        int sevenDayPass = minCost(days, costs, day + 7, dp) + costs[1];
        int oneMonthPass = minCost(days, costs, day + 30, dp) + costs[2];

        dp[day] =  Math.min(oneDayPass, Math.min(sevenDayPass, oneMonthPass));

        return dp[day];


    }
}
