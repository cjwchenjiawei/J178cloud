package com.cjw.observer;

public class ChengDu extends ICity{
    @Override
    public void infect() {
        System.out.println("成都发现感染者");
        this.notifyChina("新冠");
    }

    @Override
    public void add(IChina china) {
        this.sets.add(china);
    }

    @Override
    public void del(IChina china) {
        this.sets.remove(china);
    }

    @Override
    public void notifyChina(String str) {
        for (IChina china:sets) {
            china.getInfo(str);
        }
    }
}
