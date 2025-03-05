package Concurrency;

public class Main {
    public static void main(String[] args) {
        try{
            int threads = Thread.activeCount(); // 2 (one for garbage collecting, and main thread)
            int cores = Runtime.getRuntime().availableProcessors(); // cores are for multi-threading

            System.out.println("Starting: ");
            System.out.println("Available cores: "+ cores);
            System.out.println("Active threads: "+ threads);
        }
        catch (Exception e){
            System.out.println("Error "+ e.getMessage());
        }
    }

    public static void Race_condition(){
        var status = new DownloadStatus();

        Thread[] threads = new Thread[10];
        for(int i=0; i< threads.length; i++){
            threads[i] = new Thread(new Runnable(){
                public void run(){
                    for(int i=0; i< 10_000; i++){ // 10_000 * 10 threads
                        status.incrementStatus();
                    }
                }
            });
            threads[i].start();
        }
        for(Thread thread : threads){
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("Last status: "+ status.getTotalBytes());// not 100_000 as expected
        // due to changing status by different threads at raughly same time
    }

    public static void interrupting() throws InterruptedException{
        var thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < Integer.MAX_VALUE; i++) {
                    if (Thread.currentThread().isInterrupted()) {
                        System.out.println("Thread is interrupted, due to taking too long, decided to terminate.");
                        return;
                    }
                    System.out.println("Downloading byte: " + i);
                }
                System.out.println("Download completed in given time.");
            }
        });
        thread.start();

        Thread.sleep(1_000);// if the download doesn't complete in 1sec, interrupt
        thread.interrupt();
    }

    public static double uniThreaded(){ // (3sec * threads)sec
        long start = System.nanoTime();

        for (int i = 0; i < 10; i++) {
            try{
                System.out.println("UniThreaded text.");
                Thread.sleep(3000); // 3sec
            }catch(InterruptedException e){
                System.out.println("Error with thread: "+ e.getMessage());
            }
        }

        long end = System.nanoTime();
        return (end-start)/1_000_000_000.0; // to sec
    }

    public static double multi_threaded(){ // all threads sleeps 3sec-> 3sec
        long start = System.nanoTime();

        // printing 10 texts, 10 threads, 30sec paused
        int threadCount = 10;
        Thread[] threads = new Thread[threadCount];

        for(int i=0; i< threadCount; i++){
            threads[i] = new Thread(()->{
                System.out.println("My thread text, "+ Thread.currentThread().getName());

                try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                }
            });
            threads[i].start();
        }

        // Ensure all threads complete execution
        for (Thread thread : threads) {
            try {
                thread.join();// telling main/caller thread to wait for current thread exec
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted: " + e.getMessage());
            }
        }


        long end = System.nanoTime();
        return (end-start)/1_000_000_000.0;
    }
}