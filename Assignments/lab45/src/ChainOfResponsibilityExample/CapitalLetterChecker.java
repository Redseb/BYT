package ChainOfResponsibilityExample;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CapitalLetterChecker extends Handler{
    public CapitalLetterChecker(Handler next) {
        super(next);
    }

    @Override
    public boolean check(String password) {
        Pattern pattern = Pattern.compile("[A-Z]");
        Matcher match = pattern.matcher(password);
        boolean hasCapitalLeters = match.find();
        if(hasCapitalLeters){
            return passToNext(password);
        }
        System.out.println("Password must contain capital letters");
        return false;
    }
}
