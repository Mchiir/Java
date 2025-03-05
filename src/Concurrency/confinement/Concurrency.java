package Concurrency.confinement;

import java.util.ArrayList;
import java.util.List;

public class Concurrency {
    public static void main(String[] args) {
        try {
            confinement();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void confinement() throws InterruptedException {
        List<FileDownloader> tasks = new ArrayList<>();
        List<Thread> threads = new ArrayList<>();

        for(int i=0; i< 10; i++){
            var task = new FileDownloader();
            tasks.add(task);

            var thread = new Thread(task);
            thread.start();
            threads.add(thread);
        }

        for(Thread thread : threads){
            thread.join();
        }

        var tot_size = tasks.stream()
                .map(t -> t.getStatus().getTotalBytes())
                .reduce(Integer::sum);

        System.out.println("Toto size : "+ tot_size);
    }
}
