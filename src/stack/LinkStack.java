package stack;

/**
 * @author greatqian
 * @description 栈的链表实现
 * @date 2021/1/5
 */
public class LinkStack<T> {

    private Node head;

    private int length;

    private class Node<T> {
        T data;
        Node next;
    }

    public LinkStack() {
        head = new Node();
        head.data = null;
        head.next = null;
        length = 0;
    }

    public boolean push(T data) {
        Node node = new Node();
        node.data = data;
        node.next = head.next;
        head.next = node;
        length++;
        return true;
    }

    public T pop() {
        if (head.next == null) {
            return null;
        }
        T data = (T) head.next.data;
        head.next = head.next.next;
        length--;
        return data;
    }

    public int length() {
        return length;
    }

}
