package does_it_blend;

public abstract class Blender implements Runnable {

    private final String name;

    public Blender(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void run() {
        job();
        finished();
    }

    public abstract void job();

    public abstract void finished();
}
