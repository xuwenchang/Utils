package com.my.test;

import java.lang.reflect.ParameterizedType;
import java.util.regex.Pattern;

import com.alibaba.fastjson.JSONObject;
import com.sun.xml.internal.ws.wsdl.writer.document.ParamType;

public class TestSay {
    public static void main(String[] args) {
//        Animal animal = new Dog();
        //Dog dog = new Dog();
        //Cat cat = new Cat();
//        TestSay testSay = new TestSay();
//        testSay.test(animal);
        
     /*   String s = "\"{\"data\":[{\"salesDepartmentName\":\"衡阳营业部\",\"salesDepartmentNo\":\"1DDFBB8455700001ADC1F4E3D6E61F22\"}]}\"";
        JSONObject json = JSONObject.parseObject(s);*/
        
        //(\\d{14}[0-9a-zA-Z])|(\\d{17}[0-9a-zA-Z])
        
        //String regex = "/^[1-9]\\d{7}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}$|^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}([0-9]|X)$/";
       // String regex = "^[1-9]\\d{7}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}$|^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}([0-9]|X)$";
        //String regex = "^[\u4e00-\u9fa5a-zA-Z]*$";
        //String regex = "^.*[\\~\\!\\/\\@\\#\\$\\%\\^\\&\\*\\(\\)\\-\\_\\=\\+\\\\\\|\\[\\{\\}\\]\\;\\:\\\'\\\"\\,\\<\\.\\>\\/\\?]*$";
        //String regex = "^.*[\\_]*$";
        //String regex = "^[.]*$";
        String regex = "^[A-G]|other$";
        System.out.println(Pattern.matches(regex, "other"));
        if (!Pattern.matches(regex, "X")) {
           
           System.out.println("gggg");
        }
        
        
        
        
    }
   /* public void test(Animal animal) {
        animal.say(animal);
       
    }*/
}
