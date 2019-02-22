package org.kdalib.trip_planner.model.administration;

import lombok.Data;
import org.kdalib.trip_planner.model.EntityBase;
import org.kdalib.trip_planner.model.security.Users;

import javax.persistence.*;

@Data
@Entity
@Table(name = "app_log", schema = "admin")
public class AppLog extends EntityBase {

    @Column(name="events")
    private String event;

    @Column(name="event_type")
    private String eventType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Users user;
}
