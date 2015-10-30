import java.util.*;

public class MyLinkedList {

    private MyNode firstNode;
    private MyNode lastNode;
    private int numberOfNodes;

    public MyLinkedList (int... args) {
        this.firstNode = null;
        this.lastNode = null;
        this.numberOfNodes = 0;
        MyNode currentNode = new MyNode(0);
        for (int arg : args) {
            if (this.firstNode == null) {
                this.firstNode = new MyNode(arg);
                currentNode = this.firstNode;
            } else {
                currentNode.linkNode(new MyNode(arg));
                currentNode = currentNode.getLinkedNode();
                this.lastNode = currentNode;
            }
            this.numberOfNodes++;
        }
    }

    public boolean add (MyNode node) { // add(E e)
        return this.addAtEnd(node);
    }

    public boolean addAtIndex (MyNode node, int index) { // add(int index, E element)
        if (this.numberOfNodes < index) { 
            return false;
        } else if (this.numberOfNodes == index) {
            return this.addAtEnd(node);
        } else if (index == 0) {
            return this.addAtHead(node);
        } else {
            int currentNodeNumber = 0;
            MyNode currentNode = this.firstNode;
            while (currentNodeNumber < index) {
                currentNode = currentNode.getLinkedNode();
                currentNodeNumber++;
            }
            MyNode linkedNode = currentNode.getLinkedNode();
            currentNode.linkNode(node);
            MyNode newNode = currentNode.getLinkedNode();
            newNode.linkNode(linkedNode);
            return true; 
        }
    }

    public boolean addAtHead (MyNode node) { // addFirst(E e)
        node.linkNode(this.firstNode);
        this.firstNode = node;
        return true;
    }

    public boolean addAtEnd (MyNode node) { // addLast(E e)
        if(this.firstNode == null) {
            this.firstNode = node;
        } else {
            this.lastNode.linkNode(node);
        }
        this.lastNode = node;
        this.numberOfNodes++;
        return true;
    }

    public void clearList () { // clear()
        this.numberOfNodes = 0;
        this.firstNode = null;
        this.lastNode = null;
    }

    public MyLinkedList cloneList () { // clone()
        return this;
    }

    public boolean contains (MyNode node) { // contains(Object o)
        MyNode currentNode = this.firstNode;
        int numberIterations = 0;
        boolean nodeFound = false;
        while (!nodeFound && numberIterations < this.numberOfNodes) {
            if (currentNode.getValue() == node.getValue()) {
                nodeFound = true;
            } else {
                currentNode = currentNode.getLinkedNode();
            }
            numberIterations++;
        }
        return nodeFound;
    }

    public MyNode getHead () { // element()
        return this.firstNode;
    }

    //public Iterator<int> getDescendingIterator() // descendingIterator()

    public MyNode getNodeAt (int index) { // get(int index)
        if (index >= this.numberOfNodes) {
            throw new IndexOutOfBoundsException ("Specified index is out of bounds.");
        }
        MyNode currentNode = this.firstNode;
        for(int i = 0; i < index; i++) {
            currentNode = currentNode.getLinkedNode();
        }
        return currentNode;
    }

    public MyNode getFirst () { // getFirst()
        return this.getHead();
    }

    public MyNode getLast () { // getLast()
        return this.lastNode;
    }

    public int indexOf (MyNode node) { // indexOf(Object o)
        int index = 0;
        boolean nodeNotFound = true;
        MyNode currentNode = this.firstNode;
        while (index < this.numberOfNodes && nodeNotFound) {
            if (currentNode.equals(node)) {
                nodeNotFound = false;
            } else {
                index++;
                currentNode = currentNode.getLinkedNode();
            }
        }
        if (nodeNotFound) {
            index = -1;
        }
        return index;
    }

    public int lastIndexOf (MyNode node) { // lastIndexOf(Object o)
        int foundIndex = -1;
        MyNode currentNode = this.firstNode;
        for(int i = 0; i < this.numberOfNodes; i++) {
            if (currentNode.equals(node)) {
                foundIndex = i;
            } 
            currentNode = currentNode.getLinkedNode();
        }
        return foundIndex;
    }

    // public ListIterator<int> listIterator(int index) // listIterator(int index)

    public MyNode pop () {
        if (this.numberOfNodes == 0) {
            throw new NoSuchElementException("List is empty.");
        }
        MyNode poppedNode = this.firstNode;
        this.firstNode = this.firstNode.getLinkedNode();
        this.numberOfNodes--;
        return poppedNode;
    }

    public void push (MyNode node) {
        node.linkNode(this.firstNode);
        this.firstNode = node;
        this.numberOfNodes++;
    }

    public MyNode removeHead () {
        if (this.numberOfNodes == 0) {
            throw new NoSuchElementException("No head to remove.");
        }
        MyNode removedHead = this.firstNode;
        this.firstNode = this.firstNode.getLinkedNode();
        this.numberOfNodes--;
        return removedHead;
    }

    public MyNode removeFromIndex (int index) {
        if (this.numberOfNodes == 0 || this.numberOfNodes <= index) {
            throw new NoSuchElementException("List does not have a node at the given index.");
        }
        MyNode currentNode = this.firstNode;
        if (index == 0) {
            this.firstNode = currentNode.getLinkedNode();
            return currentNode;
        } else {
            for(int i = 0; i < index - 1; i++) {
                currentNode = currentNode.getLinkedNode();
            }
            MyNode nextNode = currentNode.getLinkedNode();
            currentNode.linkNode(nextNode.getLinkedNode());
            return nextNode;
        }
    }

    public void replace (int index, MyNode node) {
        if (this.numberOfNodes == 0 || this.numberOfNodes <= index) {
            throw new NoSuchElementException("Nodes out of bounds cannot be replaced.");
        }
        MyNode currentNode = this.firstNode;
        if (index == 0) {
            this.firstNode = node;
            this.firstNode.linkNode(currentNode.getLinkedNode());
        } else {
            for (int i = 0; i < index - 1; i++) {
                currentNode = currentNode.getLinkedNode();
            }
            MyNode nodeToReplace = currentNode.getLinkedNode();
            currentNode.linkNode(node);
            node.linkNode(nodeToReplace.getLinkedNode());
        }
    }

    public String toString () {
        String result = "[";
        MyNode currentNode = this.firstNode;
        while (currentNode != null) {
            result += Integer.toString(currentNode.getValue()) + " | -> ";
            currentNode = currentNode.getLinkedNode();
        }
        result += "null]";
        return result;
    }

    public int[] toArray () {
        int[] listToArray = new int[this.numberOfNodes];
        MyNode currentNode = this.firstNode;
        for(int i = 0; i < this.numberOfNodes; i++) {
            listToArray[i] = currentNode.getValue();
            currentNode = currentNode.getLinkedNode();
        }
        return listToArray;
    }

    public boolean equals (MyLinkedList linkedList) {
        if (this.numberOfNodes != linkedList.numberOfNodes) {
            return false;
        } else if (this.firstNode == null && linkedList.getHead() == null) {
            return true;
        } else if (!this.firstNode.equals(linkedList.getHead()) || !this.lastNode.equals(linkedList.getLast())) {
            return false;
        } else {
            MyNode currentNodeFirstList = this.firstNode;
            MyNode currentNodeSecondList = linkedList.getHead();
            for (int i = 0; i < this.numberOfNodes; i++) {
                if (!currentNodeFirstList.equals(currentNodeSecondList)) {
                    return false;
                }
                currentNodeFirstList = currentNodeFirstList.getLinkedNode();
                currentNodeSecondList = currentNodeSecondList.getLinkedNode();
            }
            return true;
        }
    }

    public int getListSize () {
        return this.numberOfNodes;
    }




}