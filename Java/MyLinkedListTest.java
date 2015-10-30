import java.util.*;

public class MyLinkedListTest {
    
    public static void main (String[] args) {
        //testAdd();
        testEquals();
        testAddAtEnd();
        testAddAtIndex();
        testAddAtHead();
        testClearList();
        testCloneList();
        testToString();
        testContains();
        testToArray();
        testGetNodeAt();
        testIndexOf();
        testLastIndexOf();
        testPop();
        testPush();
        testRemoveHead();
        testRemoveFromIndex();
        testReplace();
        testToArray();
    }

    public static void testEquals () {
        MyLinkedList list = new MyLinkedList();
        assert (list.equals(list));

        MyLinkedList sameHeadOne = new MyLinkedList(1, 2, 3, 4);
        MyLinkedList sameHeadTwo = new MyLinkedList(1, 6, 6, 6);
        assert (!sameHeadTwo.equals(sameHeadOne));

        MyLinkedList sameEndOne = new MyLinkedList(3, 2, 1);
        MyLinkedList sameEndTwo = new MyLinkedList(5, 6, 1);
        assert (!sameEndTwo.equals(sameEndOne));

        MyLinkedList sameHeadAndEndOne = new MyLinkedList(1, 2, 3, 4, 5, 6);
        MyLinkedList sameHeadAndEndTwo = new MyLinkedList(1, 5, 5, 5, 2, 6);
        assert (!sameHeadAndEndOne.equals(sameHeadAndEndTwo));

        MyLinkedList midElemDifferent = new MyLinkedList(1, 2, 3, 5, 3, 2, 1);
        MyLinkedList midElemDifferentTwo = new MyLinkedList(1, 2, 3, 6, 3, 2, 1);
        assert (!midElemDifferent.equals(midElemDifferentTwo));

        MyLinkedList tooSmall = new MyLinkedList(1);
        MyLinkedList tooLarge = new MyLinkedList(1, 1, 1, 1);
        assert (!tooLarge.equals(tooSmall));

        System.out.println("Equals tests passed.");
    }

    public static void testAddAtEnd () {
        MyLinkedList testList = new MyLinkedList();
        boolean addedFirstNode = testList.addAtEnd(new MyNode(10));
        assert (addedFirstNode);

        boolean addAnotherNode = testList.addAtEnd(new MyNode(11));
        assert (addAnotherNode);

        System.out.println("Add at tail tests passed.");
    }

    public static void testAddAtIndex () {
        MyLinkedList testList = new MyLinkedList(1, 2, 3, 4, 5, 6, 7);
        boolean addedAtThird = testList.addAtIndex(new MyNode(8), 3);
        assert (addedAtThird);

        boolean addAtEnd = testList.addAtIndex(new MyNode(9), testList.getListSize());
        assert (addAtEnd);

        boolean addAtFront = testList.addAtIndex(new MyNode(10), 0);
        assert (addAtFront);

        boolean addOutOfBounds = testList.addAtIndex(new MyNode(11), 1000);
        assert (!addOutOfBounds);

        System.out.println("Add at index tests passed.");
    }

    public static void testAddAtHead () {
        MyLinkedList testList = new MyLinkedList();
        boolean addFirst = testList.addAtHead(new MyNode(0));
        assert (addFirst);
        boolean addAnother = testList.addAtHead(new MyNode(1));
        assert (addAnother);

        System.out.println("Add at head tests passed.");
    }

    public static void testClearList () {
        MyLinkedList test1 = new MyLinkedList();
        MyLinkedList test2 = new MyLinkedList(1, 2, 3, 4, 5, 6, 7);
        test2.clearList();

        assert (test1.equals(test2));
        System.out.println("Clear list tests passed.");
    }

    public static void testCloneList () {
        MyLinkedList test1 = new MyLinkedList(1, 2, 3);
        MyLinkedList clone = test1.cloneList();
        assert (test1.equals(clone));

        clone.addAtHead(new MyNode(2));
        assert (test1.equals(clone));

        System.out.println("Clone list tests passed.");
    }

    public static void testToString () {
        MyLinkedList emptyList = new MyLinkedList();
        assert (emptyList.toString().equals("[null]"));

        MyLinkedList listWithOneArg = new MyLinkedList(1);
        assert (listWithOneArg.toString().equals("[1 | -> null]"));

        MyLinkedList listWithManyArgs = new MyLinkedList(2, 3, 4, 5);
        assert (listWithManyArgs.toString().equals("[2 | -> 3 | -> 4 | -> 5 | -> null]"));

        int[] intArray = {1, 2, 3, 4};
        MyLinkedList listFromArray = new MyLinkedList(intArray);
        assert (listFromArray.toString().equals("[1 | -> 2 | -> 3 | -> 4 | -> null]"));

        System.out.println("ToString tests passed.");
    }

    public static void testContains () {
        MyNode nodeToCheck = new MyNode(10);
        MyLinkedList listToSearch = new MyLinkedList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        assert (!listToSearch.contains(nodeToCheck));

        listToSearch.addAtEnd(nodeToCheck);
        assert (listToSearch.contains(nodeToCheck));

        MyLinkedList listWithMultiples = new MyLinkedList(10, 1, 2, 2, 2, 1, 1, 10, 10);
        assert (listToSearch.contains(nodeToCheck));

        System.out.println("Contains tests passed.");
    }

    public static void testToArray () {
        MyLinkedList list = new MyLinkedList(1, 2, 3, 4, 5, 6, 7);
        int[] listToArray = list.toArray();
        int[] array = {1, 2, 3, 4, 5, 6, 7};

        assert (Arrays.equals(listToArray, array));

        System.out.println("ToArray tests passed.");
    }

    public static void testGetNodeAt () {
        MyLinkedList list = new MyLinkedList(1, 2, 3, 4, 5);
        MyNode secondNode = new MyNode(3);

        assert (list.getNodeAt(2).equals(secondNode));

        try {
            MyNode shouldFail = list.getNodeAt(5);
        } catch (IndexOutOfBoundsException e) {
            System.out.print("Out Of Bounds Exception caught successfully. ");
        }

        System.out.println("Get Node At Tests passed.");
    }

    public static void testIndexOf () {
        MyLinkedList list = new MyLinkedList(1, 2, 3, 4, 5);
        assert (list.indexOf(new MyNode(2)) == 1);
        assert (list.indexOf(new MyNode(6)) == -1);

        System.out.println("IndexOf tests passed.");
    }

    public static void testLastIndexOf () {
        MyLinkedList list = new MyLinkedList(1, 2, 3, 3, 4, 5, 6, 4, 3, 2, 1);
        assert (list.lastIndexOf(new MyNode(1)) == 10);
        assert (list.lastIndexOf(new MyNode(5)) == 5);
        assert (list.lastIndexOf(new MyNode(4)) == 7);
        assert (list.lastIndexOf(new MyNode(7)) == -1);

        System.out.println("LastIndexOf tests passed.");
    }

    public static void testPop () {
        MyLinkedList list = new MyLinkedList (1, 2, 3);
        assert (list.pop().equals(new MyNode(1)));
        assert (list.pop().equals(new MyNode(2)));
        assert (list.pop().equals(new MyNode(3)));
        try {
            MyNode willFail = list.pop();
        } catch (NoSuchElementException e) {
            System.out.print("No Such Element Exception caught successfully. ");
        }

        System.out.println("Pop tests passed.");
    }

    public static void testPush () {
        MyLinkedList list = new MyLinkedList(1, 2, 3, 4, 5);
        MyLinkedList listWithHeadElement = new MyLinkedList(0, 1, 2, 3, 4, 5);
        list.push(new MyNode(0));
        assert (list.equals(listWithHeadElement));

        System.out.println("Push tests passed.");
    }

    public static void testRemoveHead () {
        MyLinkedList list = new MyLinkedList(1, 2, 3);
        assert (list.removeHead().equals(new MyNode(1)));
        assert (list.removeHead().equals(new MyNode(2)));
        assert (list.removeHead().equals(new MyNode(3)));
        try {
            MyNode shouldFail = list.removeHead();
        } catch (NoSuchElementException e) {
            System.out.print("No Such Element Exception caught successfully. ");
        }

        System.out.println("Remove head tests passed.");
    }

    public static void testRemoveFromIndex () {
        MyLinkedList list = new MyLinkedList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        assert (list.removeFromIndex(0).equals(new MyNode(1)));
        assert (list.removeFromIndex(3).equals(new MyNode(5)));

        try {
            MyNode shouldFail = list.removeFromIndex(10);
        } catch (NoSuchElementException e) {
            System.out.print("No Such Element Exception caught successfully. ");
        }

        try {
            MyLinkedList emptyList = new MyLinkedList();
            MyNode shouldAlsoFail = emptyList.removeFromIndex(0);
        } catch (NoSuchElementException e) {
            System.out.print("Twice. ");
        }
        System.out.println("Remove from index tests passed.");
    }

    public static void testReplace () {
        MyLinkedList listBeforeReplace = new MyLinkedList(1, 2, 3, 4, 5);
        MyLinkedList listAfterReplace = new MyLinkedList(1, 2, 6, 4, 5);
        listBeforeReplace.replace(2, new MyNode(6));

        System.out.println(listBeforeReplace.toString());
        System.out.println(listAfterReplace.toString());

        assert (listBeforeReplace.equals(listAfterReplace));

        try {
            listBeforeReplace.replace(10, new MyNode(10));
        } catch (NoSuchElementException e) {
            System.out.print("No Such Element Exception caught successfully. ");
        }

        try {
            MyLinkedList emptyList = new MyLinkedList();
            emptyList.replace(1, new MyNode(11));
        } catch (NoSuchElementException e) {
            System.out.print("Twice. ");
        }

        System.out.println("Replace tests passed.");
    }

}