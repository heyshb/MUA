package Interpreter.Operator;

import Interpreter.Interpreter;
import Values.STRING;
import Values.VALUE;
import Exception.*;

import static Interpreter.Interpreter.BOOL_TYPE;
import static Interpreter.Interpreter.LIST_TYPE;
import static Interpreter.Interpreter.NUM_TYPE;

public class If extends Operator{

    public VALUE Parse()throws ParseFailException{
        Interpreter TempInterpreter = new Interpreter();
        VALUE v1,v2,v3;
        v1 = TempInterpreter.ParseValue();
        CheckCondition(v1.TYPE == BOOL_TYPE);
        v2 = TempInterpreter.ParseValue();
        CheckCondition(v2.TYPE == LIST_TYPE);
        v3 = TempInterpreter.ParseValue();
        CheckCondition(v3.TYPE == LIST_TYPE);

        String Code;
        if (v1.tostr().equals("true")){
            Code = v2.tostr();
        }
        else{
            Code = v3.tostr();
        }
        TempInterpreter.ExecuteCode(Code.substring(1, Code.length() - 1));
        return new STRING(this.getClass().getSimpleName() + " Parse Done");
    }
}
