package MediationExample;

public class Skeleton extends Mob {
    public Skeleton(String username, int x, int y, Mediator mediator) {
        super(username, x, y, mediator);
    }

    @Override
    public void receive(String action, Mob sendingMob) {
        System.out.println("Skeleton: " + this.username + " just got " + action + " by: " + sendingMob.username);
        switch(action){
            case("attackStrength"):
                setHp(getHp()-sendingMob.getStrength());
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
        return "Skeleton: " + super.toString();
    }
}
