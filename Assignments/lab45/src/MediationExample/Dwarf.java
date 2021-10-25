package MediationExample;

public class Dwarf extends Mob{

    public Dwarf(String username, int x, int y, Mediator mediator) {
        super(username, x, y, mediator);
    }

    //Dwarf is a normal mob, except it takes half damage from strength attacks

    @Override
    public void receive(String action, Mob sendingMob) {
        System.out.println("Dwarf: " + this.username + " just got " + action + " by: " + sendingMob.username);
        switch(action){
            case("attackStrength"):
                setHp(getHp()-sendingMob.getStrength()/2);
                break;
            case("attackMagic"):
                setHp(getHp()-sendingMob.getIntelligence());
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
        return "Dwarf: " + super.toString();
    }
}
