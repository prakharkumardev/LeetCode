package org.example;

import java.io.*;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

/*
    understand the code


 */

class Solution {
    public static void main(String[] args) {

        //remove static declaration
        List<DataItem> input = new CopyOnWriteArrayList<>();
        input.add(new DataItem(5));
        input.add(new DataItem(17));
        input.add(new DataItem(15));
        input.add(new DataItem(21));
        input.add(new DataItem(3));
        System.out.println("Before clean");
        input.stream().forEach(obj -> System.out.println(obj.toString()));
        List<DataItem> newList  =  input.stream().filter(item -> {
            if( item.value > 15){
                return false;
            }else if(item.value<15){
                item.processed = true;
            }else{
                item.exact = true;
            }
            return true;
        }).toList();
        System.out.println("Cleaned " + (input.size() - newList.size()) + " items");
        System.out.println("After clean");
        newList.stream().forEach(obj -> System.out.println(obj.toString()));

    }
    static class DataItem {
        public int value;
        public boolean processed;
        public boolean exact;

        public DataItem(int value) {
            this.value = value;
        }

        public String toString() {
            return "value: " + value + " isProcessed: "+processed+ " isExact:  "+ exact ;
        }
    }
}
