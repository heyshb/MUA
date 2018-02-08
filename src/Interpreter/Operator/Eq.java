package Interpreter.Operator;

import Interpreter.Interpreter;
import Values.BOOL;
import Values.NUM;
import Values.STRING;
import Values.VALUE;
import java.math.*;
import Exception.*;

public class Eq extends Operator{

    public VALUE Parse()throws ParseFailException{
        VALUE v1, v2;
        Interpreter TempInterpreter = new Interpreter();
        v1 = TempInterpreter.ParseValue();
        v2 = TempInterpreter.ParseValue();
        CheckCondition((v1.TYPE == Interpreter.NUM_TYPE && v2.TYPE == Interpreter.NUM_TYPE)
                    || (v1.TYPE == Interpreter.STR_TYPE && v2.TYPE == Interpreter.STR_TYPE));

        if (v1.TYPE == Interpreter.NUM_TYPE){
            return new BOOL(Math.abs(v1.tonum() - v2.tonum()) < 1e-7);
        }
        if (v1.TYPE == Interpreter.STR_TYPE){
            return new BOOL(v1.tostr().equals(v2.tostr()));
        }
        return new STRING("ERROR");
    }w
}
