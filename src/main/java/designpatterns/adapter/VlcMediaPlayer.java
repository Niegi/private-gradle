package designpatterns.adapter;

public class VlcMediaPlayer implements AdvancedMediaPlayer {
  @Override
  public void playMp3(String filename) {
//    Do nothing
  }

  @Override
  public void playVlc(String filename) {
    System.out.println("Playing VLC file: " + filename);
  }
}
