package se.dara.jumper.gameobjects;

import com.badlogic.gdx.math.Vector2;

import se.dara.jumper.gameworld.GameWorld;

/**
 * Created by dara on 20/04/14.
 */
public class Runner {
    Vector2 pos, velocity, acceleration;
    float rotation, charge;
    int width, height;
    GameWorld world;

    public Runner(float x, float y, int width, int height, GameWorld world){
        this.width = width;
        this.height = height;
        pos = new Vector2(x, y);
        velocity = new Vector2(0,0);
        acceleration = new Vector2(0, 460);
        this.world = world;
    }

    public void update(float delta){

        // TODO: edge case, end of hole
        if((world.getGround().getPlayerLocation(this) == Ground.playerLocation.HOLE &&
                pos.y > world.getGameHeight()))
        {
            charge = 0;
            world.restartGame();
        }

        if(pos.y < world.getGround().getGroundLevel()) {
            velocity.add(acceleration.cpy().scl(delta));
        }

        if(velocity.y > 200) {
            velocity.y = 200;
        }
        if(world.getGround().getPlayerLocation(this) == Ground.playerLocation.GROUND && velocity.y > 0) {
            velocity.y = 0;
            pos.y = world.getGround().getGroundLevel()-getHeight();
        }

        if(charge > 0 && charge < 1){
            charge += delta;
        }

        pos.add(velocity.cpy().scl(delta));
    }

    public void touchDown(){
        if(world.getGround().getPlayerLocation(this) == Ground.playerLocation.GROUND) {
            charge = 0.01f;
        }
    }

    public float getCharge() {
        return charge;
    }

    public void touchUp() {
        if(world.getGround().getPlayerLocation(this) == Ground.playerLocation.GROUND && charge > 0) {
            velocity.y = -150 - (150*charge);
            charge = 0;
        }
    }

    public float getX() {
        return pos.x;
    }

    public float getY() {
        return pos.y;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

    public float getRotation() {
        return rotation;
    }
}