package org.kdalib.trip_planner.queue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kdalib.trip_planner.model.queue.Message;
import org.kdalib.trip_planner.repositories.MessageRepositiry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ListenerTest {

    @Autowired
    MessageRepositiry messageRepositiry;

    @Test
    public void testListener () {

        Message message = new Message();
        message.setMessageBody("Privet".getBytes());
        messageRepositiry.save(message);

    }
}
