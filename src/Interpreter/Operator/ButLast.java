package Interpreter.Operator;

import Interpreter.Interpreter;
import Values.LIST;
import Values.STRING;
import Values.VALUE;
import Exception.*;

import java.util.ArrayList;

public class ButLast extends Operator{

    public VALUE Parse()throws ParseFailException{
        Interpreter TempInterpreter = new Interpreter();
        VALUE v1 = TempInterpreter.ParseValue();
        if (v1.TYPE == Interpreter.STR_TYPE){
            return new STRING(v1.tostr().substring(0,v1.tostr().length()-1));
        }
        if (v1.TYPE == Interpreter.LIST_TYPE){
            ArrayList<String> TempArrList = ((LIST)v1).getStrings();
            TempArrList.remove(TempArrList.size()-1);
            return new LIST(TempArrList);
        }
        throw new ParseFailException();
    }
}
