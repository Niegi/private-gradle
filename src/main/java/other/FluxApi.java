package other;

import reactor.core.publisher.Flux;

public class FluxApi {
    public static void main(String[] args) {
        Flux<String> myFlux = Flux.just("Tomek", "Martyna");
        System.out.println("Whatever");
    }
}
