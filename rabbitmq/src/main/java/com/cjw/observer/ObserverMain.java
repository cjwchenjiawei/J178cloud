package com.cjw.observer;

public class ObserverMain {
    public static void main(String[] args) {
        zhongyang zhongyang = new zhongyang();
        sheng sheng = new sheng();
        shi shi = new shi();

        ChengDu chengDu = new ChengDu();

        chengDu.add(zhongyang);
        chengDu.add(sheng);
        chengDu.add(shi);
        chengDu.del(sheng);

        chengDu.infect();
    }
}
