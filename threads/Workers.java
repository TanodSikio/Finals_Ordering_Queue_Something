package threads;

public abstract class Workers implements Runnable {
    protected int workerId;
    protected String name;
    
    public Workers(int workerId, String name) {
        this.workerId = workerId;
        this.name = name;
    }
    
    public int getWorkerId() {
        return workerId;
    }
    
    public String getName() {
        return name;
    }
    
    @Override
    public abstract void run();
}
