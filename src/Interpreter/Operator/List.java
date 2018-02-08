package Interpreter.Operator;

import Interpreter.Interpreter;
import Values.LIST;
import Values.NUM;
import Values.STRING;
import Values.VALUE;
import Exception.*;

import java.util.ArrayList;

import static Interpreter.Interpreter.LIST_TYPE;

public class List extends Operator{

    public VALUE Parse()throws ParseFailException {
        VALUE v1, v2;
        Interpreter TempInterpreter = new Interpreter();
        v1 = TempInterpreter.ParseValue();
        v2 = TempInterpreter.ParseValue();
        ArrayList<String> Result = new ArrayList<>();
        Result.add(v1.tostr());
        Result.add(v2.tostr());
        return new LIST(Result);
    }
}
