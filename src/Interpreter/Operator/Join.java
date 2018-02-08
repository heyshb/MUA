package Interpreter.Operator;

import Interpreter.Interpreter;
import Values.LIST;
import Values.NUM;
import Values.STRING;
import Values.VALUE;
import Exception.*;

import java.util.ArrayList;

import static Interpreter.Interpreter.LIST_TYPE;

public class Join extends Operator{

    public VALUE Parse()throws ParseFailException {
        VALUE v1, v2;
        Interpreter TempInterpreter = new Interpreter();
        v1 = TempInterpreter.ParseValue();
        CheckCondition(v1.TYPE == Interpreter.LIST_TYPE);
        v2 = TempInterpreter.ParseValue();
        ArrayList<String> Result = ((LIST) v1).getStrings();
        Result.add(v2.tostr());
        return new LIST(Result);
    }
}
