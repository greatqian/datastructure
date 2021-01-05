package queue;

/**
 * @author greatqian
 * @description 队列顺序存储结构实现
 * @date 2021/1/5
 */
public class SequenceQueue<T> {

    private static int MAX_SIZE = 10;

    private T[] queue;

    private int front, rear;

    public SequenceQueue() {
        queue = (T[]) new Object[MAX_SIZE];
        front = rear = 0;
    }

    public boolean enQueue(T data) {
        if ((rear+1)%MAX_SIZE == front) {
            return false;
        }
        queue[rear] = data;
        rear = (rear+1) % MAX_SIZE;
        return true;
    }

    public T deQueue() {
        if (rear == front) {
            return null;
        }
        T data = queue[front];
        front = (front+1)%MAX_SIZE;
        return data;
    }

    public int length() {
        return (rear+MAX_SIZE-front)%MAX_SIZE;
    }

}
