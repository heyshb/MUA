package Values;

import Interpreter.Interpreter;

import java.util.ArrayList;

public class LIST extends VALUE {
    private ArrayList<String> Strings;

    public LIST(){TYPE = Interpreter.LIST_TYPE;}

    public LIST(ArrayList<String> str){
        Strings = str;
        TYPE = Interpreter.LIST_TYPE;
    }

    public ArrayList<String> getStrings() {
        return Strings;
    }

    public void print(){
        System.out.print("[ ");
        for (int i=0;i<Strings.size();i++){
            if (i > 0){
                System.out.print(' ');
            }
            System.out.print(Strings.get(i));
        }
        if (Strings.size() > 0) System.out.print(" ");
        System.out.print("]");
    }

    public String tostr(){
        /*
        String ret = "[";
        for (int i=0;i<V.size();i++)
        {
            if (i > 0){
                ret += "";
            }
            ret += V.get(i).tostr();
        }
        ret += ']';
        return ret;*/
        String ret = "[ ";
        for (int i=0;i<Strings.size();i++){
            if (i > 0){
                ret += ' ';
            }
            ret += Strings.get(i);
        }
        if (Strings.size() > 0){
            ret += ' ';
        }
        ret += "]";
        return ret;
    }

}
