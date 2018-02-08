package Interpreter.Operator;

import Interpreter.Interpreter;
import Values.STRING;
import Values.VALUE;
import Exception.*;

import java.util.Map;


public class Poall extends Operator{

    public VALUE Parse()throws ParseFailException{
        System.out.println("------All values in namespace-----");
        for (int i=Interpreter.RecursiveDep;i>=1;i--){
            for (Map.Entry entry:Interpreter.ValueMap[i].entrySet()){
                String Key,Value;
                Key = (String)entry.getKey();
                Value = ((VALUE)entry.getValue()).tostr();
                System.out.println("Key = " + Key + " Value = " + Value);
            }
        }
        System.out.println("------All values int namespace are above-----");
        return new STRING("Post all End");
    }
}
