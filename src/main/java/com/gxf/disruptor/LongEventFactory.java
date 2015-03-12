package com.gxf.disruptor;

import com.lmax.disruptor.EventFactory;

/**
 * Created by GongXingFa on 2015/2/10.
 */
public class LongEventFactory implements EventFactory<LongEvent> {
    @Override
    public LongEvent newInstance() {
        return new LongEvent();
    }
}
