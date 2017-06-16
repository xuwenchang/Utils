package com.my.test;

public class Adventure {
    public static void f(CanFight c){c.canFight();}
    public static void fly(CanFly f){f.canFly();}
    public static void s(CanSwim s){s.canSwim();}
    public static void a(ActionCharacter a){a.canFight();}
    public static void main(String[] args) {
        Hero hero = new Hero();
        f(hero);
        fly(hero);
        s(hero);
        a(hero);
    }
}
