package org.kdalib.trip_planner.service.lisetener;

import lombok.extern.java.Log;
import org.kdalib.trip_planner.model.queue.Message;

import javax.persistence.PostPersist;
import java.time.ZonedDateTime;

@Log
public class QueueListener {

    @PostPersist
    public void processMessage(Message message) {
        log.info("Message processed! Id="+message.getId());
        message.setDeleteDate(ZonedDateTime.now());
    }
}
