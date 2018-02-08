package API;
import Interpreter.Interpreter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import Exception.KeyNotFoundException;
import Exception.ParseFailException;
import Values.NUM;
import Values.VALUE;

import static Interpreter.Interpreter.MAX_RECURSIVE_DEP;


public class Main {


    public static void main(String[] args) throws FileNotFoundException, KeyNotFoundException, ParseFailException{

        /*
            InputStream in = new FileInputStream(new File("test2.mua"));
            Scanner s = new Scanner(in);
        */

        Scanner s = new Scanner(System.in);

        Interpreter.Init();
        Interpreter it = new Interpreter();
        it.run();
    }
}
