package code.interval;

import java.util.ArrayList;
import java.util.List;

public class MinimumPlatforms {
//    static class Train{
//        int start;
//        int end;
//        Train(int s, int e){
//            this.start = s;
//            this.end = e;
//        }
//    }
//    static int findPlatform(int arr[], int dep[]) {
//        // add your code here
//
//        List<Train> train = new ArrayList<>();
//        for(int i = 0;i<arr.length;i++){
//            train.add(new Train(arr[i], dep[i]));
//        }
//        train.sort((a,b)-> a.end != b.end ?
//                Integer.compare(a.end,b.end) :
//                Integer.compare(a.start, b.start));
//
//        int maxPlatform = 0;
//        int totalPlatForm = 0;
//        int finish = train.get(0).end;
//        for(int i = 1;i<train.size();i++){
//            if(finish<train.get(i).start){
//                finish = train.get(i).end;
//                totalPlatForm = 0;
//            }else{
//                finish = Math.max(finish, train.get(i).end);
//                totalPlatForm++;
//            }
//            maxPlatform = Math.max(maxPlatform, totalPlatForm);
//        }
//
//        return maxPlatform;
//
//    }
}
