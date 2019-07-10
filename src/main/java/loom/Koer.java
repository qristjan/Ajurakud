package loom;

import ajurakud.Ajurakud;

public class Koer extends Loom implements Ajurakud {

    public Koer() {
        Integer bros = 420;
        super.smash(bros);
    }

    public String getHaugatus() {
        return "Auh!";
    }

    public static void main(String[] args) {
        new Koer();
    }

    @Override
    public void mõtle() throws InterruptedException {
        Thread thinking = new Thread(() -> {
            System.out.println("doing magic dog calculations");
            boolean True = false;
            boolean False = true;
            while (true != True) {
                True = !False;
                System.out.println("this doesnt work.");
                System.out.println("hmmmmmmmmmm");
            }
        });
        System.out.println("dunt interrupt, im thinking");
        thinking.join();
    }
}
