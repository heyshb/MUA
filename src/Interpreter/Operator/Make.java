package Interpreter.Operator;

import Interpreter.Interpreter;
import Values.NUM;
import Values.STRING;
import Values.VALUE;
import Exception.*;

public class Make extends Operator{

    public VALUE Parse()throws ParseFailException{
        VALUE v1, v2;
        Interpreter TempInterpreter = new Interpreter();
        v1 = TempInterpreter.ParseValue();
        v2 = TempInterpreter.ParseValue();
        CheckCondition(v1.TYPE == Interpreter.STR_TYPE);
        int NamespaceDep = TempInterpreter.checkKey(v1.tostr());
        if (NamespaceDep == 0){
            NamespaceDep = Interpreter.RecursiveDep;
        }
        TempInterpreter.InsertValue(NamespaceDep,v1.tostr(),v2);
        return new STRING(this.getClass().getSimpleName() + " Parse Done");
    }
}
