package Values;

import Interpreter.Interpreter;

public class BOOL extends VALUE {
    boolean V;

    public BOOL(boolean tmp){
        TYPE = Interpreter.BOOL_TYPE;
        V = tmp;
    }

    public BOOL(String tmp){
        TYPE = Interpreter.BOOL_TYPE;
        if (tmp.equals("true")){
            V = true;
        }
        else{
            V = false;
        }
    }

    public String tostr(){
        if (V) return "true";
        else return "false";
    }

    public void print(){
        if (V) System.out.print("true");
        else System.out.print("false");
    }
}
