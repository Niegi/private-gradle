package designpatterns.adapter;

public class AudioPlayer implements MediaPlayer {
  MediaAdapter mediaAdapter;
  @Override
  public void play(String audioType, String filename) {
    if (audioType.equalsIgnoreCase("mp3") || audioType.equalsIgnoreCase("vlc")) {
      mediaAdapter = new MediaAdapter(audioType);
      mediaAdapter.play(audioType, filename);
    } else {
      System.out.println("incorrect audio type!");
    }
  }
}
