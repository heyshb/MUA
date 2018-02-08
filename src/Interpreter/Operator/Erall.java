package Interpreter.Operator;

import Interpreter.Interpreter;
import Values.STRING;
import Values.VALUE;
import Exception.*;


public class Erall extends Operator{

    public VALUE Parse()throws ParseFailException{
        Interpreter.ValueMap[Interpreter.RecursiveDep].clear();
        return new STRING("Erase all End");
    }
}
