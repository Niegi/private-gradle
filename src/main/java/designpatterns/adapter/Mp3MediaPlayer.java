package designpatterns.adapter;

public class Mp3MediaPlayer implements AdvancedMediaPlayer {
  @Override
  public void playMp3(String filename) {
    System.out.println("Playing MP3 file:" + filename);
  }

  @Override
  public void playVlc(String filename) {
// do nothing
  }
}
