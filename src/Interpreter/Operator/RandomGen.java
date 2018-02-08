package Interpreter.Operator;

import Interpreter.Interpreter;
import Values.NUM;
import Values.VALUE;
import Exception.*;

import java.util.Random;

public class RandomGen extends Operator{

    public VALUE Parse()throws ParseFailException{
        Random rand = new Random();
        Interpreter TempInterpreter = new Interpreter();
        VALUE v1 = TempInterpreter.ParseValue();
        int up = (int)Math.round(v1.tonum());
        int Result = rand.nextInt(up);
        return new NUM(Result);
    }
}
