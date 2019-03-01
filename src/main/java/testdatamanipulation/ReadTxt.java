package testdatamanipulation;

import java.io.*;
import java.util.Random;
import testdatamanipulation.SubData;
import utility.Utility;

public class ReadTxt {
    static private FileReader file;
    static private BufferedReader reader;
    static private String line;
    static private int lineNumber;


    public static String returnRandomLineNumberOfIds() throws IOException {
        file = new FileReader("D:\\Idea\\tests\\IssueTracker\\src\\main\\java\\properties\\ids.txt");
        reader = new BufferedReader(file);
        Random random = new Random();
        lineNumber = random.nextInt((8-2)+2);
//        lineNumber = 2;
        System.out.println("linenumber"+lineNumber);

        for(int i=1;i<=lineNumber;i++){
            line = reader.readLine();
        }
        return line;
    }
}
