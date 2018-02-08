package Interpreter.Operator;

import Interpreter.Interpreter;
import Values.STRING;
import Values.VALUE;
import Exception.*;

import static Interpreter.Interpreter.LIST_TYPE;
import static Interpreter.Interpreter.NUM_TYPE;

public class Repeat extends Operator{

    public VALUE Parse()throws ParseFailException{
        Interpreter TempInterpreter = new Interpreter();
        VALUE v1,v2;
        v1 = TempInterpreter.ParseValue();
        CheckCondition(v1.TYPE == NUM_TYPE);
        v2 = TempInterpreter.ParseValue();
        CheckCondition(v2.TYPE == LIST_TYPE);
        long RepeatNum = Math.round(v1.tonum());
        String Code = v2.tostr();
        for (long i=1;i<=RepeatNum;i++) {
            TempInterpreter.ExecuteCode(Code.substring(1, Code.length() - 1));
        }
        return new STRING(this.getClass().getSimpleName() + " Parse Done");
    }
}
