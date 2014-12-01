package mcdsoftware.ai.Marcus;

import mcdsoftware.ai.communication.CommunicationHandler;
import mcdsoftware.ai.utils.Util;

import java.util.Scanner;

/**
 * Created by Tyler on 30/11/2014.
 */
public class Marcus extends Thread {
    public Scanner scannerInput;

    public Marcus() {
        Util.logMessage(0, "Waking up Marcus...", false);
        scannerInput = new Scanner(System.in);
    }

    public void run() {
        Util.logMessage(0, "Initializing Marcus Thread.", true);
        while (true) {
            System.out.print("Marcus > ");
            String instruction = scannerInput.nextLine();
            if (instruction.length() > 0) {
                if (!(instruction.substring(instruction.length() - 1).equalsIgnoreCase("q"))) {
                    new CommunicationHandler(instruction);
                } else {
                    Util.logMessage(0, "Session ended by user.", false);
                    break;
                }
            } else {
                System.out.println("Marcus: Please give me an instruction. Type help for more information.");
            }
        }
    }
}
