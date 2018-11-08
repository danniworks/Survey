package UserInterfaceLib;

public class TextComponent extends DisplayComponent {

    public TextComponent() {
        setEditable(false);
    }

    public TextComponent(String text) {
        setEditable(false);
        setConsoleText(text);
    }
}
