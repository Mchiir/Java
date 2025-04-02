package Concurrency.synchronization;

public class Concurrency {
    public static void main(String[] args) {
        useVolatile(); // to prevent "visilibity issues"
        synchronization();// to prevent "race conditions"
    }

    public static void useVolatile(){
        var status = new DownloadStatus3();
        var thread1 = new Thread(new FileDownloader2(status));
        var thread2 = new Thread(()->{
            while(!status.isDone()){}

            System.out.println(status.getTotalBytes());
        });

        thread1.start();
        thread2.start();
    }

    public static void synchronization(){
        IsDownloadStatus downloadStatus = new DownloadStatus2();
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
