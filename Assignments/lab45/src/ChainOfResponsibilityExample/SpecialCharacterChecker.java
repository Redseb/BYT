package ChainOfResponsibilityExample;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SpecialCharacterChecker extends Handler{
    public SpecialCharacterChecker(Handler next) {
        super(next);
    }

    @Override
    public boolean check(String password) {
        Pattern pattern = Pattern.compile("[^a-zA-Z0-9]");
        Matcher match = pattern.matcher(password);
        boolean hasSpecialCharacters = match.find();
        if(hasSpecialCharacters){
            return passToNext(password);
        }
        System.out.println("Password must contain special characters");
        return false;
    }
}
