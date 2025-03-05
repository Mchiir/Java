package MyTube;

public class VideoProcessor {
    private CanEncode encoder;
    private CanStoreInDB database;
    private NotificationService emailService;

    // cons Dep Injection
    public VideoProcessor(CanEncode encoder,CanStoreInDB database, NotificationService emailService) {
        this.encoder = encoder;
        this.database = database;
        this.emailService = emailService;
    }

    public void process(Video video){
//        CanEncode encoder = new Encoder2020();
        encoder.encode(video);

//        CanStoreInDB database = new VideoDatabase2020();
        database.store(video);

//        EmailSender emailService = new EmailService2020();
        emailService.notify(video.getUser());
    }
}
