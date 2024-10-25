import java.net.*;
import java.io.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class DateServerMTP
{
    public static void main(String[] args)
    {
        try {
            ServerSocket sock = new ServerSocket(6013);
            ExecutorService threadExecutor = Executors.newCachedThreadPool();

            while (true) {
                Socket client = sock.accept();
                threadExecutor.execute(new Worker(client));
            }
        } catch (IOException ioe) {
            System.err.println(ioe);
        }
    }
}

// worker class to handle clients as threads
class Worker implements Runnable {
    private Socket client;

    public Worker(Socket clientSocket) {
        System.out.println("New Client Connected");
        this.client = clientSocket;
    }

    @Override
    public void run() {
        try
        {
            while (true)
            {
                PrintWriter pout = new PrintWriter(client.getOutputStream(), true);
		try
		{
		    Thread.sleep(5000);
		}
		catch (InterruptedException e) {}
                pout.println(new java.util.Date().toString());
                client.close();
            }
        }
        catch (IOException ie) {}
    }
}
