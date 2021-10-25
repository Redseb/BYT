package MediationExample;

import java.util.ArrayList;

public class MobMediator implements Mediator{
    ArrayList<Mob> mobList;
    public MobMediator(){
        mobList = new ArrayList<>();
    }

    public void addMob(Mob mob){
        mobList.add(mob);
    }

    public void printAllMobs(){
        System.out.println();
        for(Mob mob:mobList){
            System.out.println(mob);
        }
        System.out.println();

    }

    @Override
    public void send(String action, Mob sendingMob) {
        for (Mob mob:mobList) {
            if(Math.abs(mob.x - sendingMob.x)<10){ //if mobs are close enough
                if(Math.abs(mob.y - sendingMob.y)<10){
                    if(mob != sendingMob){ //dont attack / heal ourself
                        mob.receive(action, sendingMob);
                    }
                }
            }
        }
    }
}
