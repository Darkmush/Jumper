package se.dara.jumper.gameobjects;

/**
 * Created by dara on 11/05/14.
 */
public class Hole {
    float x;
    int length;

    public Hole(int x, int length){
        this.x = x;
        this.length = length;
    }

    public void update(float delta){
        x -= delta*100;
    }

    public int getX(){
        return (int) (x+0.5);
    }

    public int getLength(){
        return length;
    }
}
