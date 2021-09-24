package malek.terrafabricraft.common.util;

public class ReentrantRunnable implements Runnable
{
    private final Runnable mainRunner;
    private boolean working = false;

    public ReentrantRunnable(Runnable mainRunner)
    {
        this.mainRunner = mainRunner;
    }

    /**
     * Run something, while blocking any execution of the main runner (direct access)
     */
    public void runBlocking(Runnable runner)
    {
        boolean prev = working;
        working = true;
        runner.run();
        working = prev;
    }

    /**
     * This is to be used as a callback for the main runner. (change listener)
     */
    @Override
    public void run()
    {
        if (!working)
        {
            working = true;
            mainRunner.run();
            working = false;
        }
    }
}
