/**
 * Created by rtdimpsey on 1/20/15.
 */
public class Worker2 implements Runnable
{
    private int thread_id;
    Worker2(int id)
    {
        thread_id = id;
    }
    public void run()
    {
        while (true)
        {
            System.out.println("Working...id = " + thread_id);
            try
            {
                Thread.sleep(500);
            }
            catch (InterruptedException ioe) {}
        }
    }
}
