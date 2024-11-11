package org.squidmin.java.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

@Service
public class AsyncService {

    private final ThreadPoolTaskExecutor taskExecutor;

    @Autowired
    public AsyncService(ThreadPoolTaskExecutor taskExecutor) {
        this.taskExecutor = taskExecutor;
    }

    public void executeAsyncTask(Runnable task) {
        taskExecutor.execute(task);
    }

}
