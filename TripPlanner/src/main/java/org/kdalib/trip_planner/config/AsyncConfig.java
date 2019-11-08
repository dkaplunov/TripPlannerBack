package org.kdalib.trip_planner.config;

import lombok.extern.java.Log;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.aop.interceptor.SimpleAsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.lang.reflect.Method;
import java.util.concurrent.Executor;

@Configuration
@EnableAsync
@Log
public class AsyncConfig implements AsyncConfigurer {

    @Bean ("poolExecutor")
    public Executor getPoolExecutor () {
        return getAsyncExecutor();
    }

    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setMaxPoolSize(10);
        executor.setThreadNamePrefix("worker-");
        return executor;
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {



        return new MySimpleAsyncUncaughtExceptionHandler();
    }


    private class MySimpleAsyncUncaughtExceptionHandler extends SimpleAsyncUncaughtExceptionHandler {
        @Override
        public void handleUncaughtException(Throwable ex, Method method, Object... params) {
            log.info("Upss from handler: "+ ex.getMessage());
            //super.handleUncaughtException(ex, method, params);
        }
    }

}
