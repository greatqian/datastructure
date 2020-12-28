package list;

/**
 * @author greatqian
 * @description 链表
 * @date 2020/12/28
 */
public class LinkList<T> {

    private Node head;

    private class Node {
        T data;
        Node next;
    }

    public LinkList() {
        head = new Node();
        head.data = null;
        head.next = null;
    }

    public T getElementByIndex(int index) {
        if (index <= 0) {
            return null;
        }
        Node currentNode = head;
        int count = 0;
        while (currentNode.next != null && count++ < index) {
            currentNode = currentNode.next;
        }
        if (count == index) {
            return currentNode.data;
        }
        return null;
    }

    public boolean insertElementToPosition(T data, int position) {
        if (position <= 0) {
            return false;
        }
        Node frontNode = head;
        int count = 1;
        while (frontNode.next != null && count++ < position) {
            frontNode = frontNode.next;
        }
        if (count == position) {
            Node newNode = new Node();
            newNode.data = data;
            newNode.next = frontNode.next;
            frontNode.next = newNode;
            return true;
        }
        return false;
    }


    public void printList() {
        Node node = head;
        while (node.next != null) {
            System.out.print(node.next.data + " ");
            node = node.next;
        }
    }


    public static void main(String[] args) {
        LinkList<Integer> list = new LinkList<>();
        list.insertElementToPosition(6, 1);
        list.insertElementToPosition(2, 5);
        list.printList();
    }

}
