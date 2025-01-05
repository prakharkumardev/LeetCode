package code.medium;

import java.util.HashSet;
import java.util.Set;

public class UniqueLength3PalindromicSubsequences {
    class pairs {
        Character c;
        int start;
        int end;
        int charCount;

        pairs(Character c, int s, int e) {
            this.c = c;
            this.start = s;
            this.end = e;
            this.charCount = 0;
        }
        void setStart(int s){
            this.start = s;
        }
        void setEnd(int e){
            this.end = e;
        }
        void incCharCount(){
            this.charCount++;
        }
        int getDiffrence(){
            return this.end - this.start;
        }
        int getCharCount(){
            return charCount;
        }
    }

    public int countPalindromicSubsequence(String s) {
        int n = s.length();
        pairs[] arr = new pairs[26];
        for (int i = 0; i < 26; i++) {
            arr[i] = new pairs((char) ('a' + i), -1, -1);
        }
        for(int i = 0;i<s.length();i++){
            int index = s.charAt(i) - 'a';
            if(arr[index].start == -1){
                arr[index].setStart(i);
            }
            arr[index].incCharCount();
            arr[index].setEnd(i);
        }
        int count = 0;
        for(int i = 0;i<26;i++){
            if(arr[i].getCharCount()>1){
                Set<Character> unique = new HashSet<>();
                for(int j = arr[i].start;j<=arr[i].end;j++){
                    unique.add(s.charAt(j));
                }
                count+=unique.size();
            }
        }
        return count;
    }
}
