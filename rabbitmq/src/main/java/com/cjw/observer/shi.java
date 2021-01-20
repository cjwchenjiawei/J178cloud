package com.cjw.observer;

public class shi implements IChina{
    @Override
    public void getInfo(String str) {
        if (str.equals("新冠")){
            System.out.println("市级向省级汇报");
        }
    }
}
