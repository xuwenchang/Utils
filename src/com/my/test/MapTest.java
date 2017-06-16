package com.my.test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapTest {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Map<String, Object> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            map.put("key"+String.valueOf(i), i);
        }
        
        System.out.println(map.keySet());
        System.out.println(map.entrySet());
        Set<String> set = map.keySet();
        System.out.println(set);
       for (String str: set) {
            
            System.out.println(str+":"+map.get(str));
        }
    }
    
}
