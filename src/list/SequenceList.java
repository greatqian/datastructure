package list;

import java.util.Arrays;

/**
 * @author greatqian
 * @description 顺序存储结构的线性表
 * @date 2020/12/22
 */

public class SequenceList<T> {

    private static int MAX_SIZE = 20;

    T[] data;
    private int length;

    public SequenceList() {
        data = (T[]) new Object[MAX_SIZE];
        length = 0;
    }

    public T getElemntByIndex(int index) {
        if (length == 0 || index >= length) {
            return null;
        }
        return data[index];
    }

    public boolean insertByPosition(T element, int position) {
        if (length == MAX_SIZE) {
            return false;
        }
        if (position >= MAX_SIZE || position < 0) {
            return false;
        }
        for (int i = length-1; i >= position; i--) {
            data[i+1] = data[i];
        }
        data[position] = element;
        length++;
        return true;
    }

    public boolean insert(T element) {
        if (length == MAX_SIZE) {
            return false;
        }
        data[length] = element;
        length++;
        return true;
    }

    public boolean delete(int position) {
        if (length == 0 || position >= length || position < 0) {
            return false;
        }
        for (int i = position; i < length; i++) {
            data[i] = data[i+1];
        }
        length--;
        return true;
    }

    @Override
    public String toString() {
        return "SequenceList{" +
                "data=" + Arrays.toString(data) +
                ", length=" + length +
                '}';
    }

    public static void main(String[] args) {
        SequenceList<String> strList = new SequenceList<>();
        strList.insert("hello");
        strList.insert("world");
        strList.insert("greatqian");
        strList.delete(1);
        System.out.println(strList);
    }

}
