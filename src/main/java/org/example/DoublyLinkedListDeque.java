package org.example;

public class DoublyLinkedListDeque<T> implements DoubleEndedQueue<T> {

    private DequeNode<T> first;
    private DequeNode<T> last;
    private int size;

    public DoublyLinkedListDeque() {
        first = null;
        last = null;
        first = null;
    }

    @Override
    public void prepend(T value) {
        // TODO
        DequeNode<T> currentNode = 
    }

    @Override
    public void append(T value) {
        // TODO
    }

    @Override
    public void deleteFirst() {
        // TODO
    }

    @Override
    public void deleteLast() {
        // TODO
    }

    @Override
    public T first() {
        // TODO
        return null;
    }

    @Override
    public T last() {
        // TODO
        return null;
    }

    @Override
    public int size() {
        // TODO
        return 0;
    }
}