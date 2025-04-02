package Concurrency.synchronization;

public class FileDownloader2 implements Runnable {
    private final IsDownloadStatus2 status;

    public FileDownloader2(IsDownloadStatus2 status) {
        this.status = status;
    }

    @Override
    public void run() {
        for(int i=0; i<1_000_000; i++) {
            if(Thread.currentThread().isInterrupted()) return;
            status.incrementStatus();
        }

        status.done();
    }
}