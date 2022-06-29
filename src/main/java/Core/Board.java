package Core;

public class Board {
    private Cello[][] grid;
    private int height=3;
    private int width=3;

    public Board(Cello[][] grid){
        this.grid=grid;
        height=width=grid.length;
    }

    public Board(int height,int width,double p){
        this.height=height;
        this.width=width;
        grid=new Cello[height][width];

        for(int h=0;h<grid.length;h++){
            for(int w=0;w<grid[h].length;w++){
                grid[h][w]=new Cello();
                if(Math.random()<=p){
                    grid[h][w].setNewState(true);
                   grid[h][w].updateState();
                }
            }
        }
    }

    public Cello[][] getGrid(){
        return grid;
    }

    public int getSize(){
        return width;
    }

    public int neighboursCountAt(int row,int col){
        int sum=0;

        if(row!=0 && col!=0){
            if(isAlive(row-1,col)){
                sum++;
            }
        }
        if(row != 0){
            if (isAlive(row - 1, col)) {
                sum++;
            }
        }
        if(row !=0&&col !=width-1){
            if(isAlive(row-1,col+1)){
                sum++;
            }
        }
        if(col!=0){
            if(isAlive(row,col+1)){
                sum++;
            }
        }
        if (col != width-1){
            if(isAlive(row,col+1)){ //6
                sum++;
            }
        }

        if (row != height-1 && col != 0){
            if(isAlive(row+1,col-1)){ //7
                sum++;
            }
        }

        if (row != height-1){
            if(isAlive(row+1,col)){ //8
                sum++;
            }
        }

        if (row != height-1 && col != width-1){
            if(isAlive(row+1,col+1)){ //9
                sum++;
            }
        }

        return sum;
    }

    public boolean isAlive(int row,int col){
        return grid[row][col].getState();
    }

    public void update(){
        prepare();
        commit();
    }

//    getting new states to each cell

    private void prepare(){
        for(int h=0;h<grid.length;h++){
            for(int w=0;w<grid[h].length;w++){
                int nr=neighboursCountAt(h,w);
                if(nr<2){
                    grid[h][w].setNewState(false);
                }//underpopulated
                else if (nr>3) { grid[h][w].setNewState(false); //overcroweded
                } else if (nr==3) { grid[h][w].setNewState(true); //newcellisborn
                } else if (nr==2) {grid[h][w].setNewState(grid[h][w].getState());//nochages
                }
            }

        }
    }

    private void commit(){
        for(int h=0;h<grid.length;h++){
            for(int w=0;w<grid[h].length;w++){
                grid[h][w].updateState();
            }
        }
    }
}
