package MyTube;

public class EmailService2020 implements NotificationService {
    @Override
    public void notify(User user){
        System.out.println("Successfully sent confirmation email notification to "+ user.getEmail());
    }
}
