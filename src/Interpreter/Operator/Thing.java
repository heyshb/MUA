package Interpreter.Operator;

import Interpreter.Interpreter;
import Values.STRING;
import Values.VALUE;
import Exception.*;

import static Interpreter.Interpreter.STR_TYPE;

public class Thing extends Operator{

    public VALUE Parse()throws ParseFailException{
        VALUE v1;
        Interpreter TempInterpreter = new Interpreter();
        v1 = TempInterpreter.ParseValue();
        CheckCondition(v1.TYPE == STR_TYPE);
        return TempInterpreter.GetValue(v1.tostr());
    }
}
