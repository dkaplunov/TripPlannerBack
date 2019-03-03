package org.kdalib.trip_planner.repositories;

import org.kdalib.trip_planner.model.queue.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepositiry extends CrudRepository<Message, Long> {
}
