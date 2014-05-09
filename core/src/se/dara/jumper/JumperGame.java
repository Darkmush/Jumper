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

        float gameWidth = 300;
        float gameHeight = screenHeight/(screenWidth/gameWidth);

        int midPointY = (int) (gameHeight/2);


        world = new GameWorld((int)gameHeight);
        renderer = new GameRenderer(world, (int) gameWidth, (int) gameHeight, midPointY);

        Gdx.input.setInputProcessor(new InputHandler(world.getRunner()));
    }

	@Override
	public void render () {
        world.update(Gdx.graphics.getDeltaTime());
        renderer.render();
	}
}
