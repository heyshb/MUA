package Interpreter.Operator;

import Interpreter.Interpreter;
import Values.BOOL;
import Values.STRING;
import Values.VALUE;
import Exception.*;

public class IsEmpty extends Operator{

    public VALUE Parse()throws ParseFailException{
        Interpreter TempInterpreter = new Interpreter();
        VALUE v1 = TempInterpreter.ParseValue();
        if (v1.TYPE == Interpreter.STR_TYPE){
            return new BOOL(v1.tostr().equals(""));
        }
        if (v1.TYPE == Interpreter.LIST_TYPE){
            return new BOOL(v1.tostr().length() == 3);
        }
        throw new ParseFailException();
    }
}
