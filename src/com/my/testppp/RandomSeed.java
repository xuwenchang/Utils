package com.my.testppp;

import java.util.Random;
import java.util.TimerTask;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class RandomSeed {
    public static void main(String[] args) {
        Random random = new Random(System.currentTimeMillis());
        for (int i = 0; i < 10; i++) {
            int a = random.nextInt(10);
            System.out.println(a);
        }
       /* ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(10);
        executor.scheduleAtFixedRate(new TimerTask() {
            
            @Override
            public void run() {
                // TODO Auto-generated method stub
                int i = 0;
                
                System.out.println("我执行了"+i);
                i++;
                
            }
        }, 10, 5, TimeUnit.SECONDS);*/
    }
}
