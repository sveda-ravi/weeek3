public class TextEditor {
    class TextNode {
        String text;
        TextNode next;
        TextNode prev;

        TextNode(String text) {
            this.text = text;
            this.next = null;
            this.prev = null;
        }
    }

    private TextNode head;
    private TextNode current;
    private int historySize;
    private int count;

    public TextEditor(int historySize) {
        this.historySize = historySize;
        this.head = null;
        this.current = null;
        this.count = 0;
    }

    public void addTextState(String text) {
        TextNode newNode = new TextNode(text);
        if (count == historySize) {
            head = head.next;
            count--;
        }
        if (head == null) {
            head = newNode;
            current = head;
        } else {
            current.next = newNode;
            newNode.prev = current;
            current = newNode;
        }
        count++;
    }

    public void undo() {
        if (current != null && current.prev != null) {
            current = current.prev;
            System.out.println("Undo: " + current.text);
        } else {
            System.out.println("No previous state.");
        }
    }

    public void redo() {
        if (current != null && current.next != null) {
            current = current.next;
            System.out.println("Redo: " + current.text);
        } else {
            System.out.println("No next state.");
        }
    }

    public void displayCurrentState() {
        if (current != null) {
            System.out.println("Current State: " + current.text);
        } else {
            System.out.println("No current state.");
        }
    }

    public static void main(String[] args) {
        TextEditor editor = new TextEditor(10);

        editor.addTextState("Hello");
        editor.addTextState("Hello, World!");
        editor.addTextState("Hello, World! How are you?");

        editor.displayCurrentState();

        editor.undo();
        editor.undo();

        editor.redo();

        editor.addTextState("Hello, World! How are you today?");
        editor.displayCurrentState();
    }
}
