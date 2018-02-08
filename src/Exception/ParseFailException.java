package Exception;

public class ParseFailException extends RuntimeException {
    public ParseFailException(String Massage){
        super(Massage);
    }

    public ParseFailException(){

    }
}
