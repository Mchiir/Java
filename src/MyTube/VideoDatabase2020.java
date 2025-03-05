package MyTube;

public class VideoDatabase2020 implements CanStoreInDB {
    @Override
    public void store(Video video){
        System.out.println("Successfully stored "+ video.getTitle() + " video in 2020 DB");
    }
}
