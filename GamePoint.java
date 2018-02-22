import java.io.Serializable;

public class GamePoint implements Serializable{
    int x;
    int y;
    
    public GamePoint(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public int getX() {
        return this.x;
    }
    
    public int getY() {
        return this.y;
    }
       
}
