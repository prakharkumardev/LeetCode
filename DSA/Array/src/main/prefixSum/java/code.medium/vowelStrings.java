package java.code.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class vowelStrings {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int m = queries.length;
        int[] noOfVowels = new int[m];
        noOfVowels[0] = isStartEndVowel(words[0]);
        for(int i = 1; i<words.length;i++){
            noOfVowels[i] = noOfVowels[i-1] + isStartEndVowel(words[i]);
        }
        int[] result = new int[m];
        for(int i = 0;i<m;i++){
            result[i] = noOfVowels[queries[i][1]] - (queries[i][0] == 0 ? 0 : noOfVowels[queries[i][0]-1]);
        }
        return result;
    }
    public int isStartEndVowel(String str){
        Set<Character> vowel = new HashSet<>(Arrays.asList('e','i','o','u','a'));
        if(vowel.contains(str.charAt(0)) && vowel.contains(str.charAt(str.length()-1))){
            return 1;
        }
        return 0;
    }
}
