package Values;

import Interpreter.Interpreter;

public class NUM extends VALUE {
    public double V;

    public NUM(double tmp){
        V = tmp;
        TYPE = Interpreter.NUM_TYPE;
    }

    public NUM(String tmp){
        V = Double.valueOf(tmp);
        TYPE = Interpreter.NUM_TYPE;
    }

    public void print(){
        System.out.print(V);
    }

    @Override
    public double tonum() {
        return V;
    }

    public String tostr(){
        return Double.toString(V);
    }
}
