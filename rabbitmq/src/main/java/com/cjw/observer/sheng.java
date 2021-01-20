package com.cjw.observer;

public class sheng implements IChina{
    @Override
    public void getInfo(String str) {
        if (str.equals("新冠")){
            System.out.println("省级向中央汇报");
        }
    }
}
