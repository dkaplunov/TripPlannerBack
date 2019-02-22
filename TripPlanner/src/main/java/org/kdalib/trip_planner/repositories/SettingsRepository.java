package org.kdalib.trip_planner.repositories;

import org.kdalib.trip_planner.model.administration.Settings;
import org.springframework.data.repository.CrudRepository;

public interface SettingsRepository extends CrudRepository<Settings, Long> {
}
