package list;

/**
 * @author greatqian
 * @description 链表
 * @date 2020/12/28
 */
public class LinkList<T> {

    //头结点
    private Node head;

    private int length;

    private class Node {
        T data;
        Node next;
    }

    public LinkList() {
        head = new Node();
        head.data = null;
        head.next = null;
        length = 0;
    }

    public T get(int index) {
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

    public boolean insert(T data, int position) {
        if (position <= 0 || position > length+1) {
            return false;
        }
        Node pre = head;
        int i = 1;
        while (i++ < position) {
            pre = pre.next;
        }
        Node newNode = new Node();
        newNode.data = data;
        newNode.next = pre.next;
        pre.next = newNode;
        length++;
        return true;
    }

    public int length() {
        return length;
    }

    public boolean delete(int position) {
        if (position <= 0 || position > length) {
            return false;
        }
        Node pre = head;
        int i = 1;
        while (i++ < position) {
            pre = pre.next;
        }
        pre.next = pre.next.next;
        length--;
        return true;
    }


    public void printList() {
        Node node = head;
        while (node.next != null) {
            System.out.println(node.next.data);
            node = node.next;
        }
    }


    public static void main(String[] args) {
        LinkList<Integer> list = new LinkList<>();
        list.insert(6, 1);
        list.insert(2, 5);
        list.insert(8, 1);
        list.insert(11, 2);
        list.delete(1);
        list.printList();
    }

}
