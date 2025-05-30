
public class Nodes  {
    private int value;
    private int row;
    private int column;
    private boolean isConnected;
    private boolean isSelected;
    private GameBoard board;

    public Nodes(int value, int row, int column){
        this.value = value;
        this.row = row;
        this.column = column;
        isConnected = false;
        isSelected = true;
    }
    public Nodes(int value){

        this.value = value;
        isConnected = false;
        isSelected = true;
    }
    public void setConnected(){
        isConnected = true;
    }
    public void setSelected(){
        isSelected = true;
    }
    public int getValue(){
        return value;
    }
    public int getRow(){
        return row;
    }
    public int getColumn(){
        return column;
    }
}
