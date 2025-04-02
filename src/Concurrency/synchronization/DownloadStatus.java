
package Concurrency.synchronization;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DownloadStatus {
    private int status;
    private Lock lock = new ReentrantLock();

    public int getTotalBytes(){
        return status;
    }

    public void incrementStatus(){
        lock.lock();
        try {
            status++; // if codes may throw some Exceptions
        }finally {
            lock.unlock();
        }
    }
}