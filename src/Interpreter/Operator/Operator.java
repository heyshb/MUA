package Interpreter.Operator;

import Values.STRING;
import Values.VALUE;
import Exception.*;

public class Operator {

    public void CheckCondition(boolean Condition) throws ParseFailException{
        if (!Condition){
            throw new ParseFailException();
        }
    }

    public VALUE Parse()throws ParseFailException{
        return new STRING(this.getClass().getSimpleName() + " Parse Done");
    }
}
