package com.gxf.disruptor;

import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import java.nio.ByteBuffer;

/**
 * Created by GongXingFa on 2015/2/10.
 */
public class LongEventMain {
    public static void main(String[] args) throws Exception{
        Executor executor= Executors.newCachedThreadPool();
        LongEventFactory factory=new LongEventFactory();
        int bufferSize=1024;
        Disruptor<LongEvent> disruptor=new Disruptor<LongEvent>(factory, bufferSize, executor);
        disruptor.handleEventsWith(new LongEventHandler());
        disruptor.start();
        // Get the ring buffer from the Disruptor to be used for publishing.
        RingBuffer<LongEvent> ringBuffer = disruptor.getRingBuffer();

        LongEventProducer producer = new LongEventProducer(ringBuffer);

        ByteBuffer bb = ByteBuffer.allocate(8);
        for (long l = 0; true; l++)
        {
            bb.putLong(0, l);
            producer.onData(bb);
        }
    }
}
