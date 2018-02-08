package Interpreter.Operator;

import Interpreter.Interpreter;
import Values.LIST;
import Values.NUM;
import Values.STRING;
import Values.VALUE;
import Exception.*;

import java.util.ArrayList;

import static Interpreter.Interpreter.LIST_TYPE;

public class Sentence extends Operator{

    public VALUE Parse()throws ParseFailException {
        VALUE v1, v2;
        Interpreter TempInterpreter = new Interpreter();
        v1 = TempInterpreter.ParseValue();
        v2 = TempInterpreter.ParseValue();
        ArrayList<String> Result = new ArrayList<>();
        if (v1.TYPE == LIST_TYPE){
            LIST TempList = (LIST)v1;
            ArrayList<String> list1 = TempList.getStrings();
            for (int i=0;i<list1.size();i++){
                Result.add(list1.get(i));
            }
        }
        else{
            Result.add(v1.tostr());
        }

        if (v2.TYPE == LIST_TYPE){
            LIST TempList = (LIST)v2;
            ArrayList<String> list2 = TempList.getStrings();
            for (int i=0;i<list2.size();i++){
                Result.add(list2.get(i));
            }
        }
        else{
            Result.add(v2.tostr());
        }
        return new LIST(Result);
    }
}
