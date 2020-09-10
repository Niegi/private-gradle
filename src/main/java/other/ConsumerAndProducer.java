package other;

import java.util.function.Consumer;

public class ConsumerAndProducer {

    public static void main(String[] args) {

        Consumer<String> myConsumerOld = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };

        Consumer<String> myConsumer = str -> System.out.println(str);

        myConsumer.andThen(myConsumer).accept("test1");

    }

}
