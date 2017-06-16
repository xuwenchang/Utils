package com.my.test;

public class Hero extends ActionCharacter implements CanFight,CanFly,CanSwim {

    @Override
    public void canSwim() {
        // TODO Auto-generated method stub
        System.out.println("I'm CanSwim");
    }

    @Override
    public void canFly() {
        // TODO Auto-generated method stub
        System.out.println("I'm CanFly");
    }

    @Override
    public void canFight() {
        // TODO Auto-generated method stub
        System.out.println("I'm CanFight");
    }
    
}
