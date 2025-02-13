package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
    public String removeOccurrences(String s, String part) {
        StringBuffer ans = new StringBuffer();
        Stack<Character> stk = new Stack<>();
        Character lastChar = part.charAt(part.length()-1);
        Stack<Character> partStk = new Stack<>();
        for(Character character: part.toCharArray()) partStk.add(character);
        for(Character ch : s.toCharArray()){
            if(ch == lastChar){
                Boolean isRemovePossible = removePart(stk, partStk);
                if(!isRemovePossible) {
                    stk.forEach(ans::append);
                    stk.clear();
                }
            }else{
                stk.add(ch);
            }
        }
        stk.forEach(ans::append);
        return ans.toString();
    }
    private boolean removePart(Stack<Character>stk, Stack<Character> part){
        if(stk.size()<part.size()) return false;
        Stack<Character> stkCopy = stk;
        while(part.size() > 0){
            if(stkCopy.peek() == part.peek()){
                stkCopy.pop();
                part.pop();
            }else {
                return false;
            }
        }
        stk = stkCopy;
        return true;
    }

    class Pair{
        int first;
        int second;
        Pair(){
            first = Integer.MIN_VALUE;
            second = Integer.MIN_VALUE;
        }
        Pair addNumbers(int num){
            if(num > first){
                second = first;
                first = num;
            }else if(num > second){
                second = num;
            }
            return this;
        }
        int getSum(){
            return first + second;
        }
    }
    public int maximumSum(int[] nums) {
        Map<Integer, Pair> dp = new HashMap<>();
        int maxSum = Integer.MIN_VALUE;
        for(int num : nums){
            int digitSum = getDigitSum(num);
            dp.put(num, dp.getOrDefault(num, new Pair()).addNumbers(num));
            maxSum = Math.max(maxSum, dp.get(num).getSum());
        }
        return maxSum;
    }
    public int getDigitSum(int num){
        int sum = 0;
        while(num > 0){
            sum += num%10;
            num /= 10;
        }
        return sum;
    }





































}
