package com.company;

public class Debugging {

    public static void printArray(String[] arr){
        System.out.print("[");
        for (String element : arr){
            System.out.print(element + ",");
        }
        System.out.print("]");
    }
}
