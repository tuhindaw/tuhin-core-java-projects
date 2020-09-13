package thread;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RequestProcessor {


    public void processCarRequest(List<Task> submittedTasks){
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        ExecutorService pool = Executors.newFixedThreadPool(availableProcessors);
        try {
            for (Task task : submittedTasks) {
                System.out.println("Current task is being executed by Thread :: " + Thread.currentThread().getName());
                pool.execute(task);
            }
        }

        finally {
            System.out.println("Shutting down thread pool...");
            pool.shutdown();
        }

    }


}


