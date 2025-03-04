package code.easy;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        List<Integer> powerof3 = new ArrayList<>();
        int val = 1;
        powerof3.add(val);
        while(val<10000001){
            val = val * 3;
            powerof3.add(val);
        }
        System.out.println(powerof3.toString());
    }
    public boolean checkPowersOfThree(int n) {
        List<Integer> powerof3 = new ArrayList<>();
        int val = 1;
        powerof3.add(val);
        while(val<10000001){
            val = val * 3;
            powerof3.add(val);
        }

        return false;
    }
    public boolean isSumPower(int n, List<Integer> list, int index){
        if(n == 0){
            return true;
        }
        if(n < 0 || index > list.size()){
            return false;
        }
        System.out.println(n + " "+ list.get(index));
        return isSumPower(n - list.get(index), list, index+1) || isSumPower(n, list, index+1);
    }

}