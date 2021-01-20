package com.cjw.observer;

public class zhongyang implements IChina{
    @Override
    public void getInfo(String str) {
        if (str.equals("新冠")){
            System.out.println("中央下达指令");
        }
    }
}
