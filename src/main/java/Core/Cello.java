package Core;

public class Cello {
    private boolean state=false;
    private boolean newState;

    public Cello(){

    }

    public Cello(boolean state){
        this.state=state;
    }

    public void setNewState(boolean state){
        newState=state;
    }

    public void updateState(){
        state=newState;
    }

    public boolean getState(){
        return state;
    }
}
