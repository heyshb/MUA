package Interpreter.Operator;

import Interpreter.Interpreter;
import Values.BOOL;
import Values.STRING;
import Values.VALUE;
import Exception.*;

import java.util.concurrent.TimeUnit;

import static Interpreter.Interpreter.NUM_TYPE;

public class Wait extends Operator{

    public VALUE Parse()throws ParseFailException{
        VALUE v1, v2;
        Interpreter TempInterpreter = new Interpreter();
        v1 = TempInterpreter.ParseValue();
        CheckCondition(v1.TYPE == NUM_TYPE);
        try {
            TimeUnit.MILLISECONDS.sleep(Math.round(v1.tonum()));
        }catch (Exception e){
            e.printStackTrace();
        }
        return new STRING("Wait End");
    }
}
