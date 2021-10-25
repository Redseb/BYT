package ChainOfResponsibilityExample;

public abstract class Handler {
    Handler next;
    public Handler(Handler next){
        this.next = next;
    }

    public abstract boolean check(String password);
    public boolean passToNext(String password){
        if(next != null){
            return next.check(password);
        }
        return true;
    }
}
