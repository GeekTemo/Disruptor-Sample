package com.gxf.disruptor;

/**
 * Created by GongXingFa on 2015/2/10.
 */
public class LongEvent {
    private long value;

    public void set(long value){
        this.value=value;
    }

    @Override
    public String toString() {
        return "LongEvent{" +
                "value=" + value +
                '}';
    }
}
