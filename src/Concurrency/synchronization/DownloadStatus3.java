package Concurrency.synchronization;

public class DownloadStatus3 implements IsDownloadStatus2 {
    private volatile boolean isDone;
    private int status;
    private Object statusIncrementStatusObj = new Object();// manager object for sync
    private Object totalFilesIncrementObj = new Object();
    private int totalFiles;

    public Number getTotalBytes(){
        return status;
    }

    public void incrementStatus(){
        synchronized (statusIncrementStatusObj) {
            status++; // if codes may throw some Exceptions
        }
    }

    public int getTotalFiles() {
        return totalFiles;
    }

    public void incrementTotalFiles() {
        synchronized (this) { // % public synchronized void incrementTotalFiles() %
            totalFiles++;
        }
    }

    public boolean isDone() {
        return isDone;
    }

    public void done() {
        isDone = true;
    }
}
