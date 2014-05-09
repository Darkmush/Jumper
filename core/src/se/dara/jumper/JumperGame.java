package se.dara.jumper;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;

import se.dara.jumper.gameworld.GameRenderer;
import se.dara.jumper.gameworld.GameWorld;
import se.dara.jumper.input.InputHandler;

public class JumperGame extends ApplicationAdapter {
	GameWorld world;
    GameRenderer renderer;
	
	@Override
	public void create () {
        float screenWidth = Gdx.graphics.getWidth();
        float screenHeight = Gdx.graphics.getHeight();
        float gameHeight = 337;
        float gameWidth = screenWidth/(screenHeight/gameHeight);


        int midPointY = (int) (gameHeight/2);


        world = new GameWorld(midPointY);
        renderer = new GameRenderer(world, (int) gameWidth, midPointY);

        Gdx.input.setInputProcessor(new InputHandler(world.getRunner()));
    }

	@Override
	public void render () {
        world.update(Gdx.graphics.getDeltaTime());
        renderer.render();
	}
}
