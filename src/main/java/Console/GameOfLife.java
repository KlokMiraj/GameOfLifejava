package Console;

import Core.Board;
import Core.DisplayDriver;

public class GameOfLife {
    public static void main(String[] args) throws Exception{
        DisplayDriver dd=Display.getDriver();
        Board b=new Board(10,10,0.3);

        for(int i=0;i<20;i++){
            dd.displayBoard(b);
            b.update();
            Thread.sleep(300);
        }
    }
}
