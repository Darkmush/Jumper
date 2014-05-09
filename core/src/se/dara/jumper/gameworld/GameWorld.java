package se.dara.jumper.gameworld;


import se.dara.jumper.gameobjects.Runner;

/**
 * Created by dara on 18/04/14.
 */
public class GameWorld {
    Runner runner;

    public GameWorld(int midPointY) {
        runner = new Runner(100, midPointY-5, 17, 12);
    }

    public void update(float delta){
        runner.update(delta);
    }

    public Runner getRunner() {
        return runner;
    }
}
