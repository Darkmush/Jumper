package se.dara.jumper.input;

import com.badlogic.gdx.InputProcessor;

import se.dara.jumper.gameobjects.Runner;

/**
 * Created by dara on 20/04/14.
 */
public class InputHandler implements InputProcessor {

    Runner runner;

    public InputHandler(Runner runner){
        this.runner = runner;
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        runner.touchDown();
        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        runner.touchUp();
        return true;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
