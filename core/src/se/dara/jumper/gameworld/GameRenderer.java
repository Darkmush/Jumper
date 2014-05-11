package se.dara.jumper.gameworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import se.dara.jumper.gameobjects.Hole;

/**
 * Created by dara on 18/04/14.
 */
public class GameRenderer {

    GameWorld world;
    OrthographicCamera camera;
    ShapeRenderer shapeRenderer;
    int gameWidth, gameHeight;

    public GameRenderer(GameWorld world, int gameWidth , int gameHeight, int midPointY) {
        this.world = world;
        this.gameHeight = gameHeight;
        this.gameWidth = gameWidth;

        camera = new OrthographicCamera();
        camera.setToOrtho(true, gameWidth, gameHeight);

        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setProjectionMatrix(camera.combined);
    }

    public void render(){

        // background
        Gdx.gl.glClearColor(131/255.0f, 173/255.0f, 1f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(0,0,0,1);
        shapeRenderer.rect(world.getRunner().getX(), world.getRunner().getY(),
                world.getRunner().getWidth(), world.getRunner().getHeight());

        // Draw dirt
        shapeRenderer.setColor(147 / 255.0f, 80 / 255.0f, 27 / 255.0f, 1);
        shapeRenderer.rect(0, world.getGround().getGroundLevel(), gameWidth, gameHeight - world.getGround().getGroundLevel());

        // Draw grass
        shapeRenderer.setColor(0,1,0,1);
        shapeRenderer.rect(0, world.getGround().getGroundLevel(), gameWidth, 5);

        // Draw holes
        shapeRenderer.setColor(131/255.0f, 173/255.0f, 1f, 1f);
        for (Hole h : world.getGround().getHoles()) {
            shapeRenderer.rect(h.getX(), world.getGround().getGroundLevel(), h.getLength(),
                    gameHeight - world.getGround().getGroundLevel());
        }


        // Draw charge-bar
        if(world.getRunner().getCharge() > 0) {
            shapeRenderer.setColor(1, 0, 0, 1);
            shapeRenderer.rect(100, 20, 100, 20);

            shapeRenderer.setColor(0, 1, 0, 1);
            int progress = (int) (96*world.getRunner().getCharge());
            shapeRenderer.rect(102, 22, progress, 16);
        }

        shapeRenderer.end();

    }
}
