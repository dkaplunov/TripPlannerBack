package org.kdalib.trip_planner.model.security;

import lombok.Data;
import org.kdalib.trip_planner.model.EntityBase;

import javax.persistence.*;

@Data
@Entity
@Table (name = "users", schema = "security")
public class Users extends EntityBase {

    @Column (name="user_name")
    private String userName;

    @Column (name="password")
    private String password;

}
