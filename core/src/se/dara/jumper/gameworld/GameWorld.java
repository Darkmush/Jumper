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
    int runnerHeight = 12;


    public GameWorld(int gameHeight, int gameWidth) {
        this.gameHeight = gameHeight;
        this.gameWidth = gameWidth;
        ground = new Ground(gameHeight);

        runner = new Runner(75, ground.getGroundLevel()-runnerHeight, 6, runnerHeight, this);
    }

    public void update(float delta){

        runner.update(delta);
        ground.update(delta);
    }

    public void restartGame() {
        ground = new Ground(gameHeight);
        // runner = new Runner(75, ground.getGroundLevel()-runnerHeight, 6, runnerHeight, this);
    }

    public Runner getRunner() {
        return runner;
    }
    public Ground getGround() { return ground; }
    public int getGameHeight() { return gameHeight; }
    public int getGameWidth() { return gameWidth; }
}
