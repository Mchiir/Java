package Concurrency.synchronization;

import Concurrency.DownloadStatus;

public class FileDownloader implements Runnable {
    private final DownloadStatus status;

    public FileDownloader(DownloadStatus status) {
        this.status = status;
    }

    @Override
    public void run() {
        System.out.println("Downloading file: "+ Thread.currentThread().getName());

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Download complete. Current slept thread"+ Thread.currentThread().getName());
    }
}
