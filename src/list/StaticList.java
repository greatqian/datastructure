package list;

/**
 * @author greatqian
 * @description 静态链表
 * @date 2021/1/5
 */
public class StaticList<T> {

    private static int MAX_SIZE = 100;

    private Node<T>[] list;

    private int length;

    //list[MAX_SIZE].next表示链表头结点
    //list[0].next表示备用链表头结点
    public StaticList() {
        length = 0;
        list = new Node[MAX_SIZE];
        for (int i = 0; i < MAX_SIZE; i++) {
            Node<T> node = new Node();
            node.next = i+1;
            list[i] = node;
        }
        list[MAX_SIZE-1].next = 0;
    }

    private class Node<T> {
        public T data;
        public int next;
    }

    public boolean insert(T data, int position) {
        if (length >= MAX_SIZE-2 || position <= 0 || position > getLength()+1) {
            return false;
        }
        int pre = MAX_SIZE-1;
        //找到插入位置的前一个节点
        for (int i = 1; i < position; i++) {
            pre = list[pre].next;
        }
        int insertPosition = malloc();
        if (insertPosition < 0) {
            return false;
        }
        list[insertPosition].data = data;
        list[insertPosition].next = list[pre].next;
        list[pre].next = insertPosition;
        length++;
        return true;
    }

    public boolean delete(int position) {
        if (position <= 0 || position > length) {
            return false;
        }
        int pre = MAX_SIZE-1;
        for (int i = 1; i < position; i++) {
            pre = list[pre].next;
        }
        int currentPosition = list[pre].next;
        list[pre].next = list[currentPosition].next;
        free(currentPosition);
        length--;
        return true;
    }

    //找到可以可以分配的一个位置
    private int malloc() {
        if (length >= MAX_SIZE-2) {
            return -1;
        }
        int position = list[0].next;
        list[0].next = list[position].next;
        return position;
    }

    //回收一个位置
    private void free(int position) {
        list[position].next = list[0].next;
        list[0].next = position;
    }

    public int getLength() {
        return length;
    }

    public void printList() {
        int currentPosition = list[MAX_SIZE-1].next;
        for (int i = 0; i < length; i++) {
            System.out.println(list[currentPosition].data);
            currentPosition = list[currentPosition].next;
        }
    }

    public static void main(String[] args) {
        StaticList<Integer> list = new StaticList<>();
        list.insert(10, 1);
        list.insert(11, 1);
        list.insert(13, 3);
        list.delete(1);
        list.printList();
    }

}
