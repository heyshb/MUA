package Interpreter.Operator;

import Interpreter.Interpreter;
import Values.STRING;
import Values.VALUE;
import Exception.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Iterator;

public class Save extends Operator{

    public VALUE Parse()throws ParseFailException{
        Interpreter TempInterpreter = new Interpreter();
        VALUE v1 = TempInterpreter.ParseValue();
        CheckCondition(v1.TYPE == Interpreter.STR_TYPE);
        String FileName = v1.tostr();
        StringBuilder Namespace = new StringBuilder();
        for (int i=Interpreter.RecursiveDep;i>=1;i--){
            for (HashMap.Entry entry:Interpreter.ValueMap[i].entrySet()){
                Namespace.append(((String)entry.getKey()));
                Namespace.append("\n");
            }
        }
        try{
            File file = new File(FileName);
            if (!file.exists()){
                file.createNewFile();
            }
            BufferedWriter bufferedWriter = new BufferedWriter(
                                            new FileWriter(FileName));
            bufferedWriter.write(Namespace.toString());
            bufferedWriter.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return new STRING("Save End");
    }
}
