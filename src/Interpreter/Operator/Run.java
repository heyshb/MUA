package Interpreter.Operator;

import Interpreter.Interpreter;
import Values.STRING;
import Values.VALUE;
import Exception.*;

import static Interpreter.Interpreter.LIST_TYPE;

public class Run extends Operator{

    public VALUE Parse()throws ParseFailException{
        VALUE v1;
        Interpreter TempInterpreter = new Interpreter();
        v1 = TempInterpreter.ParseValue();
        CheckCondition(v1.TYPE == LIST_TYPE);
        String Code = v1.tostr();
        Code = Code.substring(1,Code.length() - 1);
        return TempInterpreter.ExecuteCode(Code);
    }
}
