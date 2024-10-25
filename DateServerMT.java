import java.net.*;
import java.io.*;

public class DateServerMT
{
    public static void main(String[] args)
    {
        try {
            ServerSocket sock = new ServerSocket(6013);

            while (true) {
                Socket client = sock.accept();
                Thread myThread = new Thread(new Worker(client));
                myThread.start();
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