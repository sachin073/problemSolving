import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sachin on 15/6/19.
 *
 */
public class Sample {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        //reader = new BufferedReader(new FileReader(new File("src/input.in")));

        List<Integer> integerList = new ArrayList<>();
        Thread t1 = new Thread(new Runner1(integerList));
        Thread t2 = new Thread(new Runner2(integerList));
        t1.start();

        t2.start();
    }

    static class Runner1 implements Runnable{

        List<Integer> list ;

        Runner1(List<Integer> list){
            this.list=list;

        }

        @Override
        public void run() {

        synchronized (list) {
            for (int i = 0; i < 100; i++) {
                list.add(i);
            }

            System.out.println(list);
        }
            list.clear();
        }
    }


    static class Runner2 implements Runnable{

        List<Integer> list ;

        Runner2(List<Integer> list){
            this.list=list;

        }

        @Override
        public void run() {
            synchronized (list) {

                for (int i = 2000; i < 2100; i++) {
                    list.add(i);
                }
                System.out.println(list);
            }
            list.clear();
        }
    }


}
