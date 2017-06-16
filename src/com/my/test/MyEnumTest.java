package com.my.test;

public enum MyEnumTest {
    RED(30){
        public  MyEnumTest nextLamp() {
            return GREEN ;
        }
    },
    GREEN(20){
        public  MyEnumTest nextLamp() {
            return YELLOW ;
        }
    },
    YELLOW(10){
        public  MyEnumTest nextLamp() {
            return RED ;
        }
    } ;
    public abstract MyEnumTest nextLamp() ;
    private int time ;
    private MyEnumTest(int time){
        this.time = time ;
        System.out.println(time);
    }
    
    public static void main(String[] args) {
        System.out.println(MyEnumTest.GREEN);
    }
}
