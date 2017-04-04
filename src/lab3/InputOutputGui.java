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

    public void startConversation() throws ImproperFullNameFormatException {

        try {
            String fullName = JOptionPane.showInputDialog("Enter full name:");
            String lastName = nameService.extractLastName(fullName);
            String msg = "Your last name is: " + lastName;
            JOptionPane.showMessageDialog(null, msg);
        } catch (ImproperFullNameFormatException customException) {
            throw new ImproperFullNameFormatException();
        }

    }

    //method added for output
    public final void displayGui(String message) throws IllegalArgumentException {
        if (message == null || message.isEmpty()) {
            throw new IllegalArgumentException("Value must not be null or empty.");
        } else {
            JOptionPane.showMessageDialog(null, message);
        }
    }

}
