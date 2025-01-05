package org.example;

import java.lang.annotation.Retention;
import java.util.*;
import java.util.concurrent.Semaphore;

public class Main {


        public static void main(String[] args) {

                List<Integer> list = new ArrayList<>();
                list.add(1);
                list.add(2);
                list.add(3);


                List<Integer> odd = new ArrayList<>();
                List<Integer> even = new ArrayList<>();

                list.stream().forEach(a->{
                        if(a%2 == 0){
                                even.add(a);}else{


                                odd.add(a);
                        }

                });

                List<Integer> l1 = new ArrayList<>(Arrays.asList(1,4,2,6,3));
                List<Integer> l2  = new ArrayList<>(Arrays.asList(5,9,10,7));




        }

}





