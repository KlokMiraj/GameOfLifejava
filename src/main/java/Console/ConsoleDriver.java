package Console;

import Core.Board;
import Core.Cello;
import Core.DisplayDriver;

public class ConsoleDriver implements DisplayDriver {

    @Override
    public void displayBoard(Board board) {
        Cello[][] grid=board.getGrid();

        String border = String.format("+%0" + 2*grid.length + "d+", 0).replace("0","-");

        System.out.println(border);

        for(Cello[] row :grid){
            String r ="|";
            for(Cello c:row){
                r+=c.getState() ?"*":" ";
            }
            r+="|";
            System.out.println(r);
        }
        System.out.println(border);
    }
}
