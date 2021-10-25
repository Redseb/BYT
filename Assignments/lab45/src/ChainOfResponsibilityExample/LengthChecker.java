package ChainOfResponsibilityExample;

public class LengthChecker extends Handler{
    public LengthChecker(Handler next) {
        super(next);
    }

    @Override
    public boolean check(String password) {
        if(password.length() > 10){
            return passToNext(password);
        }
        System.out.println("Password length must be > 10");
        return false;
    }
}
