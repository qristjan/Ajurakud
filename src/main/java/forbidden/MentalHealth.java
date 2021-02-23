package forbidden;

import java.lang.reflect.Field;
import java.util.Random;

/**
 * Don't forget to add -Xmx10g
 */
public class MentalHealth {

    public static void main(String[] args) {
        MentalHealthParticles mentalHealthParticles = new MentalHealthParticles();

        try {
            for (char ch : "abcdefghijklmnopqrstuvwxyz".toCharArray()) {
                Random random = new Random();
                Field field = MentalHealthParticles.class.getDeclaredField(String.valueOf(ch));
                field.setAccessible(true);
                field.set(mentalHealthParticles, random.ints(0, 100_000_001).limit(100_000_000).toArray());
            }
        } catch (NoSuchFieldException | IllegalAccessException noSuchFieldException) {
            // We do not have time for exceptions
        }

        System.out.println(mentalHealthParticles);
    }

}

class MentalHealthParticles {
    private int[] a;
    private int[] b;
    private int[] c;
    private int[] d;
    private int[] e;
    private int[] f;
    private int[] g;
    private int[] h;
    private int[] i;
    private int[] j;
    private int[] k;
    private int[] l;
    private int[] m;
    private int[] n;
    private int[] o;
    private int[] p;
    private int[] q;
    private int[] r;
    private int[] s;
    private int[] t;
    private int[] u;
    private int[] v;
    private int[] w;
    private int[] x;
    private int[] y;
    private int[] z;
}
