package com.cjw.observer;

import java.util.HashSet;
import java.util.Set;

public abstract class ICity {
    Set<IChina> sets = new HashSet<>();

    public abstract void infect();

    public abstract void add (IChina china);

    public abstract void del (IChina china);

    public abstract void notifyChina(String str);

}
