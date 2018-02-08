package Interpreter.Operator;

import Interpreter.Interpreter;
import Values.STRING;
import Values.VALUE;
import Exception.*;

public class IsWord extends Operator{

    public VALUE Parse()throws ParseFailException{
        Interpreter TempInterpreter = new Interpreter();
        VALUE v1 = TempInterpreter.ParseValue();
        return new Values.BOOL(v1.TYPE == Interpreter.STR_TYPE);
    }
}
