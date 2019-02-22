package org.kdalib.trip_planner.model.administration;

import lombok.Data;
import org.kdalib.trip_planner.model.EntityBase;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "settings", schema = "admin")
public class Settings extends EntityBase {

    @Column(name="settings")
    private String settings;

}
