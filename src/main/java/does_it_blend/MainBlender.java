package does_it_blend;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class MainBlender {

    public static void main(String[] args) {
        /*
        var internetBlenders = List.of("INTERNET".split("")).stream().map(InternetBlender::new).collect(Collectors.toList());
        var homeBlenders = List.of(HomeBlender.generateName().split("")).stream().map(HomeBlender::new).collect(Collectors.toList());
        var blenders = Stream.of(internetBlenders, homeBlenders).flatMap(Collection::stream).collect(Collectors.toList());
        blenders.parallelStream().forEach(Runnable::run);*/

        ExecutorService executor = Executors.newFixedThreadPool(10_000_000);
        var homeBlenders = List.of(HomeBlender.generateName().split("")).stream().map(s -> Executors.callable(new HomeBlender(s))).collect(Collectors.toList());

        try {
            executor.invokeAll(homeBlenders);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
