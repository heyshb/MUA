package Interpreter.Operator;

import Interpreter.Interpreter;
import Values.NUM;
import Values.STRING;
import Values.VALUE;
import Exception.*;

public class Word extends Operator{

    public VALUE Parse()throws ParseFailException {
        VALUE v1, v2;
        Interpreter TempInterpreter = new Interpreter();
        v1 = TempInterpreter.ParseValue();
        v2 = TempInterpreter.ParseValue();
        CheckCondition(v1.TYPE == Interpreter.STR_TYPE);
        if (v2.TYPE == Interpreter.STR_TYPE ||
            v2.TYPE == Interpreter.NUM_TYPE ||
            v2.TYPE == Interpreter.BOOL_TYPE){
            return new STRING(v1.tostr() + v2.tostr());
        }
        throw new ParseFailException();
    }
}
