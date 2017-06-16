package com.my.pdftest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestTryCatch {
    public void testTry(){
        FileInputStream inputStream = null;
        try {
            System.out.println("HRHRHRHRHRHRHRHRHRHR");
            inputStream = new FileInputStream("E:\\pdf.pdf");
            
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            try {
                inputStream.close();
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }
    }
    
    public static void main(String[] args) {
        TestTryCatch test = new TestTryCatch();
        test.testTry();
    }
}
