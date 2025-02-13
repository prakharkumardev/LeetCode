package code.medium;

import java.util.*;

public class numberOfDistinctColour3160 {
    public int[] queryResults(int limit, int[][] queries) {
        Set<Integer> dc = new HashSet<>();
        int[] balls = new int[limit+1];
        Map<Integer, Integer> count = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        Arrays.fill(balls, -1);
        for(int[] query : queries){
            if(balls[query[0]] == -1){
                balls[query[0]] = query[1];
                dc.add(query[1]);
                count.put(query[1], count.getOrDefault(query[1], 0) + 1);
                res.add(dc.size());
            }else {
                int oldColour = balls[query[0]];
                balls[query[0]] = query[1];
                dc.add(query[1]);
                count.put(query[1], count.getOrDefault(query[1], 0) + 1);
                count.put(oldColour, count.get(oldColour) - 1);
                if(count.get(oldColour) == 0){
                    dc.remove(oldColour);
                }
                res.add(dc.size());
            }
        }
        return res.stream().mapToInt(i->i).toArray();


    }
}
