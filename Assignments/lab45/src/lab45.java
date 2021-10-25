import ChainOfResponsibilityExample.CapitalLetterChecker;
import ChainOfResponsibilityExample.DigitChecker;
import ChainOfResponsibilityExample.LengthChecker;
import ChainOfResponsibilityExample.SpecialCharacterChecker;
import MediationExample.Dwarf;
import MediationExample.Goblin;
import MediationExample.MobMediator;
import MediationExample.Skeleton;

public class lab45 {
    public static void main(String[] args) {
        //Chain of responsibility
        String PASSWORD = "testA1!dsafa";
        LengthChecker lc = new LengthChecker(null);
        SpecialCharacterChecker scc = new SpecialCharacterChecker(lc);
        DigitChecker dc = new DigitChecker(scc);
        CapitalLetterChecker clc = new CapitalLetterChecker(dc);

        boolean passwordIsValid =  clc.check(PASSWORD);
        System.out.println("Password Validity: " + passwordIsValid);

        //Mediator
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
