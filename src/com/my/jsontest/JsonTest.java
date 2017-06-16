package com.my.jsontest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import com.alibaba.fastjson.JSONObject;

public class JsonTest {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Data data = new Data();
        List<Object> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new Person("zhang", "16"));
        }
        data.setName("WTF");
        data.setAge("19");
        data.setGender("男");
        data.setList(list);
        
        
        JSONObject jsonObject = (JSONObject)JSONObject.toJSON(data);
        System.out.println(jsonObject.toJSONString());
        
        Set<Entry<String, Object>> objects = jsonObject.entrySet();
        Iterator<Entry<String, Object>> it = objects.iterator();
        while (it.hasNext()) {
            String key = it.next().getKey();
            System.out.println(key+":"+jsonObject.get(key));
        }
    }
    
}
