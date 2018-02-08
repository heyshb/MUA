package Values;
import Exception.ParseFailException;

import static Interpreter.Interpreter.*;

public class VALUE {
    public int TYPE;

    public VALUE(){

    }

    public String tostr(){
        return "";
    }
    public double tonum() throws ParseFailException
    {
        throw new ParseFailException();
    }

    public void print(){

    }

    public static VALUE plus(VALUE a,VALUE b)throws ParseFailException{
        if (a.TYPE != b.TYPE) throw new ParseFailException();
        if (a.TYPE == NUM_TYPE){
            return new NUM(a.tonum() + b.tonum());
        }
        if (a.TYPE == STR_TYPE){
            return new STRING(a.tostr() + b.tostr());
        }
        throw new ParseFailException();
    }

    public static VALUE sub(VALUE a,VALUE b)throws ParseFailException{
        if (a.TYPE != b.TYPE) throw new ParseFailException();
        if (a.TYPE == NUM_TYPE){
            return new NUM(a.tonum() - b.tonum());
        }
        throw new ParseFailException();
    }

    public static VALUE mul(VALUE a,VALUE b)throws ParseFailException{
        if (a.TYPE != b.TYPE) throw new ParseFailException();
        if (a.TYPE == NUM_TYPE){
            return new NUM(a.tonum() * b.tonum());
        }
        throw new ParseFailException();
    }

    public static VALUE div(VALUE a,VALUE b)throws ParseFailException{
        if (a.TYPE != b.TYPE) throw new ParseFailException();
        if (a.TYPE == NUM_TYPE){
            return new NUM(a.tonum() / b.tonum());
        }
        throw new ParseFailException();
    }

    public static VALUE mod(VALUE a,VALUE b)throws ParseFailException{
        if (a.TYPE != b.TYPE) throw new ParseFailException();
        if (a.TYPE == NUM_TYPE){
            return new NUM((int)a.tonum() % (int)b.tonum());
        }
        throw new ParseFailException();
    }

}
