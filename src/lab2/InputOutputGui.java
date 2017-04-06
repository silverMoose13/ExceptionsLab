package lab2;

import javax.swing.JOptionPane;

/**
 * This class is responsible for all input and output in the program.
 *
 * @author Jim Lombardo, jlombardo@wctc.edu
 * @version 1.00
 */
public class InputOutputGui {

    private NameService nameService;

    public InputOutputGui() {
        nameService = new NameService();
    }

    public void startConversation() throws IllegalArgumentException {

        //do a do while and move the try catch here. Move the output to the try since that should
        //run only when try succeeds
        // do {
        try {
            String fullName = JOptionPane.showInputDialog("Enter full name:");
            String lastName = "";
            lastName = nameService.extractLastName(fullName);
            String msg = "Presuming you followed the directions "
                    + "properly (FirstName LastName), your last name is: " + lastName;
            JOptionPane.showMessageDialog(null, msg);
        } catch (IllegalArgumentException iae) {
            JOptionPane.showMessageDialog(null, iae.getMessage());
        }
        // } while ();

    }

}
