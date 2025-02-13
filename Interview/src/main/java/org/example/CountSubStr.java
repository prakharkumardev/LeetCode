package org.example;

/*
Given a string of lowercase alphabets,
 count all possible substrings (not necessarily distinct)
 that has exactly k distinct characters.

Examples:
Input: abc, k = 2
Output: 2
Possible substrings are {“ab”, “bc”}

Input: aaba, k = 2
Output: 3
Possible substrings are {“ab”, “ba”, “aba”}


aaa k = 2 return empty

min length = 2 -> str.length -> all the substring -> check distinct

Set uni -> two pointer approch



 */


import java.util.*;

public class CountSubStr {

    public static class CountKSubStr
    {
        // Function to count number of substrings
        // with exactly k unique characters
        int countkDist(String str, int k)
        {
            Map<Character, Integer> uniMap = new HashMap<>();
            Set<String> uniStr = new HashSet<>();
            int start = 0;
            int end = 0;
            int count = 0;
            while(end<str.length()){
                if(uniMap.size() < k){
                    uniMap.put(str.charAt(end), uniMap.getOrDefault(str.charAt(end), 0) + 1);
                    end++;
                }else if(uniMap.size() == k){
                    count++;
                    uniStr.add(str.substring(start,end));
                    System.out.println(str.substring(start, end));
                    uniMap.put(str.charAt(end), uniMap.getOrDefault(str.charAt(end), 0) + 1);
                    end++;
                } else {
                    Character atStart = str.charAt(start);
                    int countAtStart = uniMap.get(atStart);
                    if(countAtStart > 1){
                        uniMap.put(atStart, uniMap.get(atStart)-1);
                    }else {
                        uniMap.remove(atStart);
                    }
                    start++;
                }
            }
            while (start < str.length()){
                if(uniMap.size() == k){
                    count++;
                    uniStr.add(str.substring(start,end));
                    System.out.println(str.substring(start, end));
                }
                Character atStart = str.charAt(start);
                int countAtStart = uniMap.get(atStart);
                if(countAtStart > 1){
                    uniMap.put(atStart, countAtStart-1);
                }else {
                    uniMap.remove(atStart);
                }
                //System.out.println("test :" +uniMap.size() + " "+ start+" "+ end);
                start++;
            }
            start = 0;
            end = 0;
            uniMap = new HashMap<>();
            while (start<str.length()){
                if(uniMap.size() < k && end<str.length()){
                    uniMap.put(str.charAt(end), uniMap.getOrDefault(str.charAt(end), 0) + 1);
                    end++;
                }  else {
                    if(uniMap.size() == k){
                        count++;
                        uniStr.add(str.substring(start,end));
                    }
                    Character atStart = str.charAt(start);
                    int countAtStart = uniMap.get(atStart);
                    if(countAtStart > 1){
                        uniMap.put(atStart, uniMap.get(atStart)-1);
                    }else {
                        uniMap.remove(atStart);
                    }
                    start++;
                }
            }
            return uniStr.size();
        }

        // Driver Program
        public static void main(String[] args)
        {
            CountKSubStr ob = new CountKSubStr();
            String ch = "abcbaa";
            int k = 3;
            System.out.println("Total substrings in " + ch + "with exactly " +
                    k +    " distinct characters : "
                    + ob.countkDist(ch, k));
        }
    }







    public String clearDigits(String s) {
        Stack<Character> stk = new Stack<>();
        for(Character c : s.toCharArray()){
            if(Character.isDigit(c) && !stk.isEmpty()){
                stk.pop();
                continue;
            }
            stk.push(c);
        }
        return stk.stream().collect(StringBuilder::new, StringBuilder::append, StringBuilder::append).toString();
    }































}
