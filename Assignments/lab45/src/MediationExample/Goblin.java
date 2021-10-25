package MediationExample;

public class Goblin extends Mob{
    public Goblin(String username, int x, int y, Mediator mediator) {
        super(username, x, y, mediator);
    }

    //Goblin is a normal mob, except it takes half damage from magic attacks

    @Override
    public void receive(String action, Mob sendingMob) {
        System.out.println("Goblin: " + this.username + " just got " + action + " by: " + sendingMob.username);

        switch(action){
            case("attackStrength"):
                setHp(getHp()-sendingMob.getStrength());
                break;
            case("attackMagic"):
                setHp(getHp()-sendingMob.getIntelligence()/2);
                break;
            case("heal"):
                setHp(getHp()+ sendingMob.getIntelligence());
                break;
            default:
                break;
        }
    }

    @Override
    public String toString() {
        return "Goblin: " + super.toString();
    }
}
