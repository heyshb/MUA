package Interpreter.Operator;

import Interpreter.Interpreter;
import Values.STRING;
import Values.VALUE;
import Exception.*;

public class IsName extends Operator{

    public VALUE Parse()throws ParseFailException{
        Interpreter TempInterpreter = new Interpreter();
        VALUE v1 = TempInterpreter.ParseValue();
        CheckCondition(v1.TYPE == Interpreter.STR_TYPE);
        return new Values.BOOL(TempInterpreter.checkKey(v1.tostr()) > 0);
    }
}
