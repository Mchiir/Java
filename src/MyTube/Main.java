package MyTube;

public class Main {
    public static void main(String[] args) {
        var video = new Video();
        video.setFileName("mchiir_bd.txt");
        video.setTitle("Mchrispin BD");
        video.setUser(new User("mugishachrispin590@gmail.com"));

        CanEncode encoder = new Encoder2020();
        CanStoreInDB database = new VideoDatabase2020();
        NotificationService emailService = new EmailService2020();
        var videoProcessor = new VideoProcessor(encoder, database, emailService);
        videoProcessor.process(video);
    }
}
