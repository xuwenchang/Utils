package com.my.money;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Random;

public class MoneyToCN {
    
    public String numberToCN(String str){
        //金额大写
        String[] CN_UPPER_NUMBER = {"零", "壹", "贰", "叁", "肆","伍", "陆", "柒", "捌", "玖"};
        //单位
        String[] CN_MONETARY_UNIT = { "分", "角", "元","拾", "佰", "仟", "万", "拾", "佰", "仟", "亿", "拾", "佰", "仟", "兆", "拾","佰", "仟"};
        //特殊 整数
        String CN_FULL = "整";
        //特殊 负数
        String CN_NEGATIVE = "负";
        //零元0元整的特殊情况
        String CN_ZERO_FULL = "零元"+CN_FULL;
        BigDecimal numberOfMoney = new BigDecimal(str);
        //如果参数大于零返回1.0，如果参数小于零返回-1，如果参数为0，则返回signum函数的参数为零
        int signum = numberOfMoney.signum();
        
        if (signum == 0) {
            return CN_ZERO_FULL;
        }
        //四舍五入
        Long number = numberOfMoney.movePointRight(2).setScale(0, 4).abs().longValue();
        //取得小数后两位
        Long scale = number % 100;
        int numUnit = 0;//单位数组下标
        int numIndex = 0;//金额大写数组下标
        StringBuffer buffer = new StringBuffer();//保存结果
        boolean getZero = false;//是否获得0
        int zeroNum = 0;//为0的个数
        //判断最后两位数
        if (!(scale > 0)) {
            numIndex = 2;
            number = number / 100;
            getZero = true;
        }
        
        if (scale > 0 && !(scale % 10 >0)) {
            numIndex = 1;
            number = number / 10;
            getZero = true;
        }
        
        while (true) {
            if (number <= 0) {
                break;
            }
            //去最后一个数
            numUnit = (int)(number % 10);
            if (numUnit > 0) {
                if (numIndex == 9 && zeroNum >= 3) {
                    buffer.insert(0, CN_MONETARY_UNIT[6]);
                }
                if (numIndex == 13 && zeroNum >= 3) {
                    buffer.insert(0, CN_MONETARY_UNIT[10]);
                }
                buffer.insert(0, CN_MONETARY_UNIT[numIndex]);//加入单位
                buffer.insert(0, CN_UPPER_NUMBER[numUnit]);//结果加入数字大写
                getZero = false;
                zeroNum = 0;//连续的数字中一个不为0，则下次遇到0时在开始计数
            }else {
                ++zeroNum;
                if (!getZero) {
                    buffer.insert(0, CN_UPPER_NUMBER[numUnit]);
                }
                if (numIndex == 2) {
                    if (numUnit > 0) {
                        buffer.insert(0, CN_MONETARY_UNIT[numIndex]);
                    }
                } else if (((numIndex - 2) % 4 == 0) && (number % 1000 > 0)) {
                    buffer.insert(0, CN_MONETARY_UNIT[numIndex]);
                }
                
                getZero = true;
            }
            
            number = number / 10;
            ++numIndex;
        }
        //输入的为负数 
        if (signum == -1) {
            buffer.insert(0, CN_NEGATIVE);
        }
        
        if (!(scale > 0)) {
            buffer.append(CN_FULL);
        }
        return buffer.toString();
    }
    
    public static void main(String[] args) {
        MoneyToCN cn = new MoneyToCN();
        
        Random random = new Random(System.currentTimeMillis());
        int i;
        for (int j = 0; j < 10; j++) {
            i = random.nextInt(1000000000);
            i = random.nextInt(i);
            System.out.println(i+":"+cn.numberToCN(String.valueOf(i)+".09"));
        }
        
    }
}
