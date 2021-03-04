package ajurakudroot.does_it_blend;

import java.util.Random;

public class HomeBlender extends Blender {

    public HomeBlender(String name) {
        super(name);
    }

    @Override
    public void job() {
        /*
        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        System.out.println(new Random().nextDouble() + new Random().nextDouble());
    }

    @Override
    public void finished() {
        System.out.printf("HomeBlender %s finished%n", getName());
    }

    public static String generateName() {
        int leftLimit = 97;
        int rightLimit = 122;
        Random random = new Random();

        return random.ints(leftLimit, rightLimit + 1)
                .limit(10_000_000)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

}
