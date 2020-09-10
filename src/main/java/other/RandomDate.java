package other;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class RandomDate {

    public static void main(String[] args)
    {
    }

    private String randomDate() {
        Format format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
        Date randomDate = new Date((long) (Math.random() * (System.currentTimeMillis())));

        return (format.format(randomDate));
    }

}
