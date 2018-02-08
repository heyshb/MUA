package Interpreter.Operator;

import Interpreter.Interpreter;
import Values.LIST;
import Values.STRING;
import Values.VALUE;
import Exception.*;

public class First extends Operator{

    public VALUE Parse()throws ParseFailException{
        Interpreter TempInterpreter = new Interpreter();
        VALUE v1 = TempInterpreter.ParseValue();
        if (v1.TYPE == Interpreter.STR_TYPE){
            return new STRING("" + v1.tostr().charAt(0));
        }
        if (v1.TYPE == Interpreter.LIST_TYPE){
            return new STRING(((LIST) v1).getStrings().get(0));
        }
        throw new ParseFailException();
    }
}
