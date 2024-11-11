package org.squidmin.java.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
public class AppConfig {

    @Bean
    public ThreadPoolTaskExecutor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(10);
        executor.setMaxPoolSize(20);
        executor.setQueueCapacity(100);
        executor.initialize();

        // Set context class loader to prevent ClassNotFoundException
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        executor.setThreadFactory(runnable -> {
            Thread thread = new Thread(runnable);
            thread.setContextClassLoader(contextClassLoader);
            return thread;
        });
        return executor;
    }

}
