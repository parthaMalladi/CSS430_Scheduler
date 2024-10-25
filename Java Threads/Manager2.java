/**
 * Created by rtdimpsey on 1/20/15.
 */
public class Manager2
{
    private final static int NUM_WORKERS = 10;

    public static void main(String args[])
    {
        Runnable[] workers = new Worker2[NUM_WORKERS];
        Thread[] myThreads = new Thread[NUM_WORKERS];

        for (int i = 0; i < NUM_WORKERS; i++)
        {
            workers[i] = new Worker2(100 + i);
            myThreads[i] = new Thread(workers[i]);
            myThreads[i].start();
        }

        while (true)
        {
            System.out.println("Manager ....");
            try
            {
                Thread.sleep(2000);
            }
            catch (InterruptedException ioe) {}
        }
    }
}
