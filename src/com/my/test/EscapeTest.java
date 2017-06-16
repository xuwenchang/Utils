package com.my.test;

public class EscapeTest {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String a = "10000.wav.ttt'yyy";
        String[] aaa = a.split("\\.");
        for (int i = 0; i < aaa.length; i++) {
            System.out.println(aaa[i]);
        }
    }
    
}
