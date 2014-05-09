package se.dara.jumper.gameobjects;

/**
 * Created by dara on 09/05/14.
 */
public class Ground {

    int gameHeight;
    int groundY;

    public Ground(int gameHeight){
        this.gameHeight = gameHeight;
        groundY = (int) (gameHeight * 0.8);
    }

    public boolean isOnGround(int y){
        if(y >= groundY ){
            return true;
        }
        return false;
    }

    public int getGroundLevel(){
        return groundY;
    }
}
