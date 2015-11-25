package com.xiodine.tap.di.varianta3;


import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created on 20/11/15.
 */
public class NanoTimer {
    private Constructor<?> constructor;
    private long timerDuration;

    public long getTimerDuration() {
        return timerDuration;
    }

    public void setLambda(Constructor<?> constructor) {
        this.constructor = constructor;
    }

    public void runTest(Object... initArgs) throws IllegalAccessException, InvocationTargetException, InstantiationException {

        long timerStart = System.nanoTime();
        this.constructor.newInstance(initArgs);
        long timerEnd = System.nanoTime();
        timerDuration = timerEnd - timerStart;
    }
}
