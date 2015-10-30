public class MyNode {

    private int value;
    private MyNode next;
    
    public MyNode (int value, MyNode next) {
        this.value = value;
        this.next = next;
    }

    public MyNode (int value) {
        this.value = value;
        this.next = null;
    }

    public void linkNode (MyNode node) {
        this.next = node;
    }

    public MyNode getLinkedNode () {
        return this.next;
    }

    public int getValue () {
        return this.value;
    }

    public boolean equals (MyNode node) {
        return (this.value == node.getValue());
    }

    public String toString () {
        return "[" + Integer.toString(this.value) + " | -> " + ((this.next == null) ? "null" : "Node") + "]";
    }

}