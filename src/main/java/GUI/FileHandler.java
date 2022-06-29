package GUI;

import Core.Board;
import Core.Cello;
import javafx.scene.control.Cell;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileHandler {
    public static Board openFromFile(int defaultSize){
        File file=askForOpenFile();
        if(file==null){
            return null;
        }
        return loadFromFile(file,defaultSize);
    }

    public static Board loadFromFile(File file,int defaultSize){
        String input=" ";
        int sz=defaultSize;
        try(Scanner s=new Scanner(file)){
            while(s.hasNextLine()){
                String line=s.nextLine().replaceAll("\\s+","");
                input +=line;

                sz=line.length();
            }
        }catch (FileNotFoundException e){
            throw new RuntimeException(e);
        }
        Cello[][] gi= new Cello[sz][sz];

        int pos=0;
        for(int i=0;i<sz;i++){
            for(int j=0;j<sz;j++){
                boolean state=(input.charAt(pos)=='1');
                gi[i][j] = new Cello();
                pos++;
            }
        }
        return new Board(gi);
    }

    public static void saveToFile(Board board){
        File file= askForSaveFile();
        if(file==null){
            return;
        }
    }
}
