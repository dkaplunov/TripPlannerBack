package org.kdalib.trip_planner.model.queue;

import lombok.Data;
import org.kdalib.trip_planner.model.EntityBase;
import org.kdalib.trip_planner.service.lisetener.QueueListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "message", schema = "processes")
@EntityListeners(value = QueueListener.class)
public class Message extends EntityBase {
    @Column(name="message_body")
    private byte[] messageBody;
}
