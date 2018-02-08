package Values;

import Interpreter.Interpreter;

public class STRING extends VALUE {
    private String V;

    public STRING(String tmp)
    {
        V = tmp;
        TYPE = Interpreter.STR_TYPE;
    }

    public String tostr(){
        return V;
    }

    public void print(){
        System.out.print(V);
    }
}
