package code.important;

import java.util.PriorityQueue;
import java.util.zip.Inflater;

public class maximumAbsoluteDiffrence {
    public int maxArr(int[] A) {
        int len = A.length;
        int [] plusI = new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE};
        int [] minusI = new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE};

        int ans = Integer.MIN_VALUE;
        for(int i = 0;i<len;i++){
            plusI[0] = Math.min(plusI[0], A[i]+i);
            plusI[1] = Math.max(plusI[1], A[i]+i);
            minusI[0] = Math.min(minusI[0], A[i]-i);
            minusI[1] = Math.max(minusI[1], A[i]-i);
        }
        ans = Math.max(ans, plusI[1] - plusI[0]);
        ans = Math.max(ans, minusI[1] - minusI[0]);
        return ans;
    }


    public String stringShift(String s, int[][] shifts) {
        int mod = s.length();
        int left = 0;
        int right = 0;
        for(int[] shift:shifts){
            if(shift[0] == 0){
                left+=shift[1]%mod;
            }else{
                right+=shift[1]%mod;
            }
        }
        if(left == right){
            return s;
        }else if(left> right){
            left = left-right;
        }else{
            right = right-left;
            left = s.length() - right;
        }
        System.out.println(left+" "+right+" "+mod);
        String s1 = s.substring(0,left);
        String s2 = s.substring(left+1,s.length());
        return s2+s1;
    }

    class Pair{
        char character;
        int count;
        public Pair(char c,  int count){
            this.character = c;
            this.count = count;

        }
        void increaseCount(){
            count++;
        }
        int getCount(){
            return count;
        }
    }
    public int minimumPushes(String word) {

        PriorityQueue<Pair> queue = new PriorityQueue<>((a,b)->b.getCount()-a.getCount());
        int[] arr = new int[26];
        for(char c:word.toCharArray()){
           arr[c-'a']++;
        }
        for(int i = 0;i<arr.length;i++){
            if(arr[i] != 0) {
                queue.add(new Pair((char) (i + 'a'), arr[i]));
            }
        }
        int numberPressed = 1;
        int count = 0;
        int minPressed = 0;
        while(!queue.isEmpty()){
            Pair p = queue.poll();
            minPressed += p.getCount() * numberPressed;
            count++;
            System.out.println("minPressed:"+minPressed+" count:"+count + " numberPressed:"+numberPressed);
            if(count > 7){
                numberPressed++;
                count = 0;
            }
        }

        return minPressed;


    }
}
