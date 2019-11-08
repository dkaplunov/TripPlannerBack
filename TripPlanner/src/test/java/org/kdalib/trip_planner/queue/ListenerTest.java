package org.kdalib.trip_planner.queue;

import lombok.extern.java.Log;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kdalib.trip_planner.model.queue.Message;
import org.kdalib.trip_planner.repositories.MessageRepositiry;
import org.kdalib.trip_planner.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Log
public class ListenerTest {

    @Autowired
    MessageRepositiry messageRepositiry;

    @Autowired
    AsyncService asyncService;

    @Test
    public void testListener () {

        Message message = new Message();
        message.setMessageBody("Privet".getBytes());
        messageRepositiry.save(message);

    }

    @Test
    public void testAsync () throws Exception {
        log.info("Test: before call");
        for (int i=0;i<10;i++) {
            asyncService.asyncMethod1(i);
        }
        log.info("Test: after method");
    }
}
