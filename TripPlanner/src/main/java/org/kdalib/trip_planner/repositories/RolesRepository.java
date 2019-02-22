package org.kdalib.trip_planner.repositories;

import org.kdalib.trip_planner.model.security.Roles;
import org.springframework.data.repository.CrudRepository;

public interface RolesRepository extends CrudRepository<Roles, Long> {
}
