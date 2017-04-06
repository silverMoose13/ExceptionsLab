package lab3;

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

    public void startConversation() {

        try {
            String fullName = JOptionPane.showInputDialog("Enter full name:");
            String lastName = nameService.extractLastName(fullName);
            String msg = "Presuming you followed the directions "
                    + "properly (FirstName LastName), your last name is: " + lastName;
            JOptionPane.showMessageDialog(null, msg);
            //the custom message can be caught here, but the super class can also be caught here too
            //use the getMessage() method that is built into Exception
        } catch (ImproperFullNameFormatException customException) {
            JOptionPane.showMessageDialog(null, customException.getMessage());
        }

    }
}
