package Interpreter.Operator;

import Interpreter.Interpreter;
import Values.STRING;
import Values.VALUE;
import Exception.*;

public class Erase extends Operator{

    public VALUE Parse()throws ParseFailException{
        Interpreter TempInterpreter = new Interpreter();
        VALUE v1 = TempInterpreter.ParseValue();
        CheckCondition(v1.TYPE == Interpreter.STR_TYPE);
        TempInterpreter.EraseValue(v1.tostr());
        return new STRING(this.getClass().getSimpleName() + " Parse Done");
    }
}
