import lejos.nxt.*;
import lejos.nxt.comm.*;

/**
 * BlueStats: display local device Bluetooth information.
 * 
 * @author Lawrie Griffiths
 *
 */
public class BlueStats {

    public static void main(String[] args) {
        String versionString = "BC4 version ";
        String nameString = "Name";
        String visString = "Visibility";
        String statusString = "Status";
        String portString = "Port Open";
        String opString = "Op Mode";
        String addrString = "Adr";
        String connsString = "Conns";
        while (!Button.ESCAPE.isPressed()) {
            byte[] version = Bluetooth.getVersion();
            String fn = Bluetooth.getFriendlyName();
            ;
            byte[] connections = Bluetooth.getConnectionStatus();
            String addr = Bluetooth.getLocalAddress();
            LCD.drawString(nameString, 0, 0);
            LCD.drawString(fn, 5, 0);
            LCD.drawString(versionString + version[0] + "." + version[1], 0, 1);
            LCD.drawString(addrString, 0, 2);
            LCD.drawString(addr, 4, 2);
            LCD.drawString(visString, 0, 3);
            LCD.drawInt(Bluetooth.getVisibility(), 11, 3);
            LCD.drawString(statusString, 0, 4);
            LCD.drawInt(Bluetooth.getStatus() & 0xFF, 7, 4);
            LCD.drawString(connsString, 0, 5);
            for (int i = 0; i < 4; i++) LCD.drawInt(connections[i], 2, 5 + i * 3, 5);
            LCD.drawString(portString, 0, 6);
            LCD.drawInt(Bluetooth.getPortOpen(), 10, 6);
            LCD.drawString(opString, 0, 7);
            LCD.drawInt(Bluetooth.getOperatingMode(), 8, 7);
            LCD.refresh();
        }
    }
}
