package mcdsoftware.ai.Marcus;

import mcdsoftware.ai.communication.CommunicationHandler;
import mcdsoftware.ai.utils.Util;

import java.util.Scanner;

/**
 * Created by Tyler on 30/11/2014.
 */
public class Marcus extends Thread {
    public Scanner scannerInput;
    private boolean introduced;

    public Marcus() {
        Util.logMessage(0, "Waking up Marcus...", false);
        introduced = false;
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
                System.out.println("Marcus: Please give me an instruction. Type help for more information, or tpye 'q' to quit.");
            }
        }
    }

    public void introduceMarcus(){
        if(!introduced){
            marcusSay("Greetings Human.\n" +
                    "My name is Marcus, what is your name?");
            introduced = true;
        }
    }

    public void marcusSay(String messageToSay){
        System.out.println("Marcus > "+messageToSay);
    }
}
