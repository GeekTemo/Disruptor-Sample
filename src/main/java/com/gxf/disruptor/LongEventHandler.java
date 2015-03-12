package com.gxf.disruptor;

import com.gxf.util.ConnectionFactory;
import com.lmax.disruptor.EventHandler;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

/**
 * Created by GongXingFa on 2015/2/10.
 */
public class LongEventHandler implements EventHandler<LongEvent> {
    @Override
    public void onEvent(LongEvent event, long sequence, boolean endOfBatch) throws Exception {
        Connection conn = ConnectionFactory.getConnection();
        String sql = " insert into log(log_message, log_time) values(? ,?)";
        PreparedStatement stamt = conn.prepareStatement(sql);
        stamt.setString(1, event.toString());
        stamt.setDate(2,  new Date(System.currentTimeMillis()));
        stamt.execute();
        conn.close();
        System.out.println("Log:"+event);
    }
}
