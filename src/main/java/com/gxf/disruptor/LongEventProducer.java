package com.gxf.disruptor;

import com.lmax.disruptor.RingBuffer;

import java.nio.ByteBuffer;

/**
 * Created by GongXingFa on 2015/2/10.
 */
public class LongEventProducer {
    private final RingBuffer<LongEvent> ringBuffer;

    public LongEventProducer(RingBuffer<LongEvent> ringBuffer) {
        this.ringBuffer = ringBuffer;
    }

    public void onData(ByteBuffer bb){
        long sequence = ringBuffer.next();
        try{
            LongEvent event = ringBuffer.get(sequence);
            event.set(bb.getLong(0));
        }finally {
            ringBuffer.publish(sequence);
        }
    }
}
