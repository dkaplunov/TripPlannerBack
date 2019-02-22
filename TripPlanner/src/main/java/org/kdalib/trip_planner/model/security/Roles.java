package org.kdalib.trip_planner.model.security;

import lombok.Data;
import org.kdalib.trip_planner.model.EntityBase;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "roles", schema = "security")
public class Roles extends EntityBase {

    @Column(name="role_name")
    private String roleName;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "users_roles", schema = "security",
            joinColumns = { @JoinColumn(name = "user_id") },
            inverseJoinColumns = { @JoinColumn(name = "role_id") }
    )
    List<Users> users = new ArrayList();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_role_id")
    private Roles parentRole;


}
