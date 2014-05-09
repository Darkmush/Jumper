package se.dara.jumper.gameworld;


import se.dara.jumper.gameobjects.Ground;
import se.dara.jumper.gameobjects.Runner;

/**
 * Created by dara on 18/04/14.
 */
public class GameWorld {
    Runner runner;
    Ground ground;

    public GameWorld(int gameHeight) {
        ground = new Ground(gameHeight);
        runner = new Runner(75, ground.getGroundLevel(), 17, 12, ground);
    }

    public void update(float delta){
        runner.update(delta);
    }

    public Runner getRunner() {
        return runner;
    }
}
