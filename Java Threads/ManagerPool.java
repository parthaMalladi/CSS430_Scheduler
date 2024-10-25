/**
 * Created by rtdimpsey on 1/20/15.
 */
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class ManagerPool
{
    private final static int NUM_WORKERS = 10;

    public static void main(String args[])
    {
        ExecutorService threadExecutor = Executors.newCachedThreadPool();

        for (int i = 0; i < NUM_WORKERS; i++)
        {
            threadExecutor.execute(new Worker2(100 + i));
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
