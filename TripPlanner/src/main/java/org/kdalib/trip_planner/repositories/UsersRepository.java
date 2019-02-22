package org.kdalib.trip_planner.repositories;

import org.kdalib.trip_planner.model.security.Users;
import org.springframework.data.repository.CrudRepository;

public interface UsersRepository extends CrudRepository<Users, Long> {

    Users findByUserName (String name);

}
