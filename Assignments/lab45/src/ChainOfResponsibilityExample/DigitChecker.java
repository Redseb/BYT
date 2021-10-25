package ChainOfResponsibilityExample;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DigitChecker extends Handler{
    public DigitChecker(Handler next) {
        super(next);
    }

    @Override
    public boolean check(String password) {
        Pattern pattern = Pattern.compile("[0-9]");
        Matcher match = pattern.matcher(password);
        boolean hasDigits = match.find();
        if(hasDigits){
            return passToNext(password);
        }
        System.out.println("Password must contain digits");
        return false;
    }
}
