package se.dara.jumper.gameworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

/**
 * Created by dara on 18/04/14.
 */
public class GameRenderer {

    GameWorld world;
    OrthographicCamera camera;
    ShapeRenderer shapeRenderer;

    public GameRenderer(GameWorld world, int gameWidth, int midPointY) {
        this.world = world;

        camera = new OrthographicCamera();
        // TODO: fix viewport
        camera.setToOrtho(true, gameWidth, 337);

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
        shapeRenderer.end();

    }
}