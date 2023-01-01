import java.net.*;
import java.io.*;

public class Client implements Constants {

    Socket kkSocket = null;

    PrintWriter out = null;

    BufferedReader in = null;

    int Clientport;

    String ip;

    Alert alert;

    boolean openSocket() {
        try {
            kkSocket = new Socket(ip, this.Clientport);
        } catch (Exception e) {
            System.err.println("Don't know about host: " + ip);
            return false;
        }
        return true;
    }

    boolean openWriter() {
        try {
            out = new PrintWriter(kkSocket.getOutputStream(), true);
        } catch (Exception e) {
            System.err.println("Couldn't get I/O for the connection to: " + ip);
            return false;
        }
        return true;
    }

    public Client(String ip, int port) {
        this.alert = new Alert();
        this.ip = ip;
        if (port <= 0) {
            this.Clientport = Constants.port;
        } else this.Clientport = port;
    }

    public boolean send(String msg) {
        if (msg == null) return false;
        try {
            this.out.println(msg);
        } catch (Exception e) {
            System.err.println("" + e);
            return false;
        }
        return true;
    }
}
