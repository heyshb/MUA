package Interpreter.Operator;

import Interpreter.Interpreter;
import Values.STRING;
import Values.VALUE;
import Exception.*;

public class And extends Operator{

    public VALUE Parse()throws ParseFailException{
        VALUE v1, v2;
        Interpreter TempInterpreter = new Interpreter();
        v1 = TempInterpreter.ParseValue();
        v2 = TempInterpreter.ParseValue();
        CheckCondition(v1.TYPE == Interpreter.BOOL_TYPE && v2.TYPE == Interpreter.BOOL_TYPE);
        return new Values.BOOL(v1.tostr().equals("true") && v2.tostr().equals("true"));
        //return new STRING(this.getClass().getSimpleName() + " Parse Done");
    }
}
