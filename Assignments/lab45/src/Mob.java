public abstract class Mob {
    public String username;
    private int hp;
    private int strength;
    private int mp;
    private int intelligence;
    public int x; //position on grid
    public int y;
    private Mediator mediator;
    public Mob(String username, int x, int y, Mediator mediator){
        this.username = username;
        hp = (int) (Math.random() * 100);
        strength = (int) (Math.random() * 100);
        mp = (int) (Math.random() * 100);
        intelligence = (int) (Math.random() * 100);
        this.x = x;
        this.y = y;
        this.mediator = mediator;
        mediator.addMob(this);
    }

    public void send(String action){
        mediator.send(action, this);
    }

    public abstract void receive(String action, Mob sendingMob);

    public Mediator getMediator() {
        return mediator;
    }

    public int getHp() {
        return hp;
    }

    public int getStrength() {
        return strength;
    }

    public int getMp() {
        return mp;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setMp(int mp) {
        this.mp = mp;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    @Override
    public String toString() {
        return this.username + " HP: " + this.getHp() + " MP: " + this.getMp() + " Intelligence: " + this.getIntelligence() + " Strength: " + this.getStrength();
    }
}
