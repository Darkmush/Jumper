package se.dara.jumper.gameobjects;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by dara on 09/05/14.
 */
public class Ground {

    int gameHeight;
    int groundY;
    ArrayList<Hole> holes;
    public enum playerLocation {GROUND, AIR, HOLE}
    Random r = new Random();

    public Ground(int gameHeight){
        this.gameHeight = gameHeight;
        groundY = (int) (gameHeight * 0.9);
        holes = new ArrayList<Hole>();
        holes.add(new Hole(300, r.nextInt(60)+30));
        holes.add(new Hole(490, r.nextInt(60)+30));
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
            holes.add(new Hole(300, r.nextInt(60)+30));
        }
    }

    public playerLocation getPlayerLocation(Runner runner){
        if(runner.getY() + runner.getHeight() >= groundY ){
            for (Hole h : holes) {
                if(runner.getX() > h.getX() && runner.getX() < h.getX()+h.getLength()){
                    return playerLocation.HOLE;
                }
            }

            return playerLocation.GROUND;
        }
        return playerLocation.AIR;
    }

    public int getGroundLevel(){
        return groundY;
    }

    public ArrayList<Hole> getHoles() {
        return holes;
    }
}
