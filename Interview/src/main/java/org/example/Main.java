package org.example;

import java.lang.annotation.Retention;
import java.util.*;
import java.util.concurrent.Semaphore;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        String box = "001011";
        int len = box.length();
        int[] psl = new int[len];
        int[] psr = new int[len];
        psl[0] =  box.charAt(0) == '1'? 1 : 0;
        psr[len-1] = box.charAt(len-1) == '1'? 1 : 0;
        int[] ansl = new int[len];
        int[] ansr = new int[len];
        ansl[0] = 0;
        ansr[len-1] = 0;
        for(int i = 1;i<len;i++){
            int j = len-i-1;

            psl[i] = psl[i-1] +  box.charAt(i) == '1'? 1 : 0;
            ansl[i] = ansl[i-1] + psl[i-1];

            psr[j] = psr[j+1] + box.charAt(i) == '1'? 1 : 0;
            ansr[j] = psr[j+1] + ansr[j+1];
        }
        for(int i = 0;i<len;i++){
            ansl[i] += ansr[i];
        }
        System.out.println(Arrays.toString(ansl));

    }
}





