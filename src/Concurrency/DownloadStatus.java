package Concurrency;

public class DownloadStatus {
    private int status;

    public int getTotalBytes(){
        return status;
    }

    public void incrementStatus(){
        status++;
    }
}
