package UserInterfaceLib;

public abstract class DisplayComponent {

    private String consoleText;
    private Boolean isEditable;

    public DisplayComponent() {}

    public void print() {
        System.out.println(consoleText);
    }

    public String getConsoleText() {
        return consoleText;
    }

    public void setConsoleText(String user_set) {
        consoleText = user_set;
    }

    /**
     * Was not included in UML
     * @param set
     */
    public void setEditable(Boolean set) {
        isEditable = set;
    }

}
