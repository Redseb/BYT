package MediationExample;

public interface Mediator {
    public void send(String action, Mob sendingMob);
    public void addMob(Mob mob);
}
