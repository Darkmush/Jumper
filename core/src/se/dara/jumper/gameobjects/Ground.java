package se.dara.jumper.gameobjects;

import java.util.ArrayList;

/**
 * Created by dara on 09/05/14.
 */
public class Ground {

    int gameHeight;
    int groundY;
    ArrayList<Hole> holes;

    public Ground(int gameHeight){
        this.gameHeight = gameHeight;
        groundY = (int) (gameHeight * 0.9);
        holes = new ArrayList<Hole>();
        holes.add(new Hole(300, 40));
        holes.add(new Hole(490, 40));
    }

    public void update(float delta) {

        Hole toBeRemoved = null;
        for (Hole h : holes){
            h.update(delta);
            // System.out.println("Updated hole, new x: " + h.getX() + ", x+length: " + (h.getX()+h.getLength()));
            if(h.getX()+h.getLength() < 0 ){
                // System.out.println("Removing hole");
                toBeRemoved = h;
            }
        }

        if(toBeRemoved != null) {
            holes.remove(toBeRemoved);
            holes.add(new Hole(300, 40));
        }
    }

    public boolean isOnGround(Runner runner){
        if(runner.getY() + runner.getHeight() >= groundY ){
            return true;
        }
        return false;
    }

    public int getGroundLevel(){
        return groundY;
    }

    public ArrayList<Hole> getHoles() {
        return holes;
    }
}
