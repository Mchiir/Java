package Concurrency.confinement;

import Concurrency.DownloadStatus;

public class FileDownloader implements Runnable {
    private final DownloadStatus status;

    public FileDownloader() {
        this.status = new DownloadStatus();
    }

    @Override
    public void run() {

        for(int i=0; i<10_000; i++) {
            if(Thread.currentThread().isInterrupted()) {
                System.out.println("Thread is interrupted, name : "+ Thread.currentThread().getName());
                return;
            }
            status.incrementStatus();
        }

        System.out.println("Download complete. Current Thread: "+ Thread.currentThread().getName());
    }

    public DownloadStatus getStatus() {
        return status;
    }
}
