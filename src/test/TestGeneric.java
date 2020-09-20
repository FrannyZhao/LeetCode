package test;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.Objects;

public class TestGeneric<E> {
    private E[] elements;
    private int size = 0;
    private static final int INITIAL_CAPACITY = 10;

    @SuppressWarnings("unchecked") // 3. 加上忽略编译警告
    public TestGeneric() {
//        elements = new E[INITIAL_CAPACITY]; // 1. 编译错误
        elements = (E[])new Objects[INITIAL_CAPACITY]; // 2. 改成创建时转换
    }

    public void push(E e) {
        ensureCapacity();
        elements[size++] = e;
    }

    public E pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        E result = elements[--size];
        elements[size] = null;
        return result;
    }

    private void ensureCapacity() {
        if (elements.length == size) {
            elements = Arrays.copyOf(elements, 2 * size + 1);
        }
    }
}
