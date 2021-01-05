package stack;

import list.SequenceList;

/**
 * @author greatqian
 * @description 顺序栈
 * @date 2021/1/5
 */
public class SequenceStack<T> {

    private static int MAX_SIZE = 10;

    private T[] stack;

    private int length;

    public SequenceStack() {
        stack = (T[]) new Object[MAX_SIZE];
        length = 0;
    }

    public boolean push(T data) {
        if (length >= MAX_SIZE) {
            return false;
        }
        stack[length++] = data;
        return true;
    }

    public T pop() {
        if (length == 0) {
            return null;
        }
        return stack[--length];
    }

}
