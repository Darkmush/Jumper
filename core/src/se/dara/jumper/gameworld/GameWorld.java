package se.dara.jumper.gameworld;


import se.dara.jumper.gameobjects.Ground;
import se.dara.jumper.gameobjects.Runner;

/**
 * Created by dara on 18/04/14.
 */
public class GameWorld {
    Runner runner;
    Ground ground;
    int gameHeight, gameWidth;


    public GameWorld(int gameHeight, int gameWidth) {
        this.gameHeight = gameHeight;
        this.gameWidth = gameWidth;
        ground = new Ground(gameHeight);
        int runnerHeight = 12;
        runner = new Runner(75, ground.getGroundLevel()-runnerHeight, 17, runnerHeight, ground);
    }

    public void update(float delta){

        runner.update(delta);
        ground.update(delta);
    }

    public Runner getRunner() {
        return runner;
    }
    public Ground getGround() { return ground; }
    public int getGameHeight() { return gameHeight; }
    public int getGameWidth() { return gameWidth; }
}
