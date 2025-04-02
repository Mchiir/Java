package Concurrency.synchronization;

import java.util.ArrayList;

public class Concurrency {
    public static void main(String[] args) {
        var downloadStatus = new DownloadStatus();
        var fileDownloader = new FileDownloader(downloadStatus);

        Thread[] threads = new Thread[10];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(fileDownloader);
            threads[i].start();
        }

        for(var task : threads) {
            try {
                task.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("Latest status: "+ downloadStatus.getTotalBytes());
    }
}
