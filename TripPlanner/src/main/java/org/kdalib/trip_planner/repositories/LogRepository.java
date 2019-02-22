package org.kdalib.trip_planner.repositories;


import org.kdalib.trip_planner.model.administration.AppLog;
import org.springframework.data.repository.CrudRepository;

public interface LogRepository extends CrudRepository<AppLog, Long> {
}
