package sample;

public class Position {

    private int x;
    private int y;
    Position(int x,int y){
        this.x=x;
        this.y=y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX(){
        return x;
    }
    public boolean equals(Position position){
         if(position.getX()==x&&position.getY()==y){
             return  true;
         }
         else return false;
    }
}
