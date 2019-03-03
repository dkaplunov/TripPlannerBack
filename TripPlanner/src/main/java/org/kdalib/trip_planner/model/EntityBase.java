package org.kdalib.trip_planner.model;

import lombok.Data;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Data
@MappedSuperclass
public class EntityBase {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;


    @Column(name="create_date")
    private ZonedDateTime createDate;

    @Column(name="delete_date")
    private ZonedDateTime deleteDate;

    @PrePersist
    public void setCreateDate () {
        this.createDate = ZonedDateTime.now();
    }

}
