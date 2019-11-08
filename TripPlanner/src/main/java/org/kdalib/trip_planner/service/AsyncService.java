package org.kdalib.trip_planner.service;

import lombok.extern.java.Log;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@Log
public class AsyncService {

    @Async ("poolExecutor")
    public void asyncMethod1 (int step) throws Exception {
        log.info("Start method");

        try {
            log.info("Process async method...");
            Thread.sleep(10000);
        } catch (Exception e) {
            log.info("Upss "+e.getMessage());
        }
        log.info("Process async method... step"+step);
        log.info("Finish method");

    }
}
