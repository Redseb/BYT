public class lab45 {
    public static void main(String[] args) {
        MobMediator mobMediator = new MobMediator();
        Dwarf dwarf = new Dwarf("Dwarfman", 10, 10, mobMediator);
        Skeleton skeleton = new Skeleton("Skelly", 12, 12, mobMediator);
        Goblin goblin = new Goblin("Golbino", 8, 8, mobMediator);
        Goblin goblin1 = new Goblin("LazyGoblino", 50, 50, mobMediator);

        System.out.println("START");
        mobMediator.printAllMobs();


        skeleton.send("attackStrength");
        mobMediator.printAllMobs();

        goblin1.send("attackStrength");
        mobMediator.printAllMobs();

        goblin.send("attackMagic");
        mobMediator.printAllMobs();

        dwarf.send("attackMagic");
        mobMediator.printAllMobs();

        System.out.println("FINISH");
    }
}
