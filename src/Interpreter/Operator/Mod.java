package Interpreter.Operator;

import Interpreter.Interpreter;
import Values.NUM;
import Values.STRING;
import Values.VALUE;
import Exception.*;

public class Mod extends Operator{

    public VALUE Parse()throws ParseFailException{
        VALUE v1, v2;
        Interpreter TempInterpreter = new Interpreter();
        v1 = TempInterpreter.ParseValue();
        v2 = TempInterpreter.ParseValue();
        CheckCondition(v1.TYPE == Interpreter.NUM_TYPE && v2.TYPE == Interpreter.NUM_TYPE);
        return new NUM(Math.round(v1.tonum()) % Math.round(v2.tonum()));
    }
}
