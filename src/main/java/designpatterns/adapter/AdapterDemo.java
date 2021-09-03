package designpatterns.adapter;

public class AdapterDemo {
  public static void main(String[] args) {
    AudioPlayer audioPlayer = new AudioPlayer();
    audioPlayer.play("mp3", "Roxanne");
    audioPlayer.play("vlc", "Ona lubi we mnie piniondz");
    audioPlayer.play("avi", "Daddy cool");
  }
}
