package code.medium;

import java.util.PriorityQueue;

public class ConstructStringWithRepeatLimit2182 {
    public static class pair{
        char c;
        int val;

        public pair(char c, int val){
            this.c = c;
            this.val = val;
        }
        void decreaseVal(){
            this.val--;
        }
        int getVal(){
            return this.val;
        }
        int getChar(){
            return (int)this.c - 'a';
        }

    }
    public String repeatLimitedString(String s, int repeatLimit) {
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
        }

        PriorityQueue<pair> pq = new PriorityQueue<>((a, b) -> b.getChar() - a.getChar());
        for (int i = 0; i < 26; i++) {
            if (arr[i] > 0) {
                pq.add(new pair((char) (i + 'a'), arr[i]));
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            pair p = pq.poll();
            if(p.getVal() > repeatLimit){
               for(int i = 0; i < repeatLimit; i++) {
                   sb.append(p.c);
                   p.decreaseVal();
               }
               pair temp = pq.poll();
                if(temp != null){
                    sb.append(temp.c);
                    temp.decreaseVal();
                    if(temp.getVal() > 0){
                        pq.add(temp);
                    }
                }
                if(p.getVal() > 0){
                    pq.add(p);
                }
            }else{
                for(int i = 0; i < p.getVal(); i++){
                    sb.append(p.c);
                }
            }
        }
        return sb.toString();
    }
}
