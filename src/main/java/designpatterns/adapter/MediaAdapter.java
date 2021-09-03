package designpatterns.adapter;

public class MediaAdapter implements MediaPlayer {

  AdvancedMediaPlayer advancedMediaPlayer;

  public MediaAdapter(String audioType) {
    if (audioType.equals("mp3")) {
      advancedMediaPlayer = new Mp3MediaPlayer();
    } else if (audioType.equals("vlc")) {
      advancedMediaPlayer = new VlcMediaPlayer();
    }
  }

  @Override
  public void play(String audioType, String filename) {
    if (audioType.equalsIgnoreCase("mp3")) {
      advancedMediaPlayer.playMp3(filename);
    } else if (audioType.equalsIgnoreCase("vlc")) {
      advancedMediaPlayer.playVlc(filename);
    }
  }
}
