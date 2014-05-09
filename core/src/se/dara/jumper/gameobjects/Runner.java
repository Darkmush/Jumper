package se.dara.jumper.gameobjects;

import com.badlogic.gdx.math.Vector2;

/**
 * Created by dara on 20/04/14.
 */
public class Runner {
    Vector2 pos, velocity, acceleration;
    float rotation;
    int width, height;

    public Runner(float x, float y, int width, int height){
        this.width = width;
        this.height = height;
        pos = new Vector2(x, y);
        velocity = new Vector2(0,0);
        acceleration = new Vector2(0, 460);
    }

    public void update(float delta){

        if(pos.y <300) {
            velocity.add(acceleration.cpy().scl(delta));
        }

        if(velocity.y < -200) {
            velocity.y = -200;
        }
        if(pos.y > 300) {
            velocity.y = 0;
            pos.y = 300;
        }

        pos.add(velocity.cpy().scl(delta));
    }

    public void touchDown(){

    }

    public void touchUp() {
        velocity.y = -140;
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