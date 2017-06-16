package com.my.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class GetEnvironmentVariables<T> extends ArrayList<T>{
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        for (Entry<String, String> map  : System.getenv().entrySet()) {
            System.out.println(map.getKey()+":"+map.getValue());
        }
    }
    public Iterable<T> reversed(){
        return new Iterable<T>() {
            public Iterator<T> iterator(){
                return new Iterator<T>() {

                    @Override
                    public boolean hasNext() {
                        // TODO Auto-generated method stub
                        return false;
                    }

                    @Override
                    public T next() {
                        // TODO Auto-generated method stub
                        return null;
                    }

                    @Override
                    public void remove() {
                        // TODO Auto-generated method stub
                        
                    }
                };
            }
        };
    }
}
