package Random.tinkers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.concurrent.*;

/**
 * Created by sachin on 14/6/19.
 */
public class ExecutoresException {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        //reader = new BufferedReader(new FileReader(new File("src/input.in")));


        ExecutorService service = new ThreadPoolExecutor(1, 1,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>()){
            @Override
            protected void afterExecute(Runnable r, Throwable t) {
                super.afterExecute(r, t);
                System.out.println("logging this "+t.getCause());

            }
        };
        Runnable erun= new RunAndThrow();
        Thread thread = new Thread(erun);
        thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println(" oops"+e.getCause());
            }
        });
        //thread.start();
        //Future runFut = service.submit(erun);

        try {
            service.execute(thread);
        } catch (Exception e) {
            System.out.println("");
        }
        Future<Integer> future= service.submit(new CallAndThow());
        System.out.println(">>"+future.get());

        service.shutdown();
        System.out.println("i am done waiting 5 sec");

    }


    static class RunAndThrow implements Runnable{

        @Override
        public void run() {
            if (true)
                throw new NullPointerException("runnable throw");

        }
    }

    static class CallAndThow implements Callable<Integer>{

        @Override
        public Integer call() throws Exception {

            if (false){
                throw new NullPointerException(" bad way to call");
            }

            return 8;
        }
    }

}
