package Concurrency.synchronization;

public class FileDownloader implements Runnable {
    private final IsDownloadStatus status;

    public FileDownloader(IsDownloadStatus status) {
        this.status = status;
    }

    @Override
    public void run() {
        for(int i=0; i<10_000; i++) {
            status.incrementStatus();
        }
    }
}