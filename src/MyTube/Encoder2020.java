package MyTube;

public class Encoder2020 implements CanEncode {
    @Override
    public void encode(Video video){
        System.out.println("Successfully encoded "+ video.getTitle() + " video");
    }
}
