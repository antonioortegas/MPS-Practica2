package org.example;

public class DoublyLinkedListDeque<T> implements DoubleEndedQueue<T> {

    private DequeNode<T> first;
    private DequeNode<T> last;
    private int size;

    public DoublyLinkedListDeque() {
        size = 0;
        last = null;
        first = null;
    }

    @Override
    public void prepend(T value) {
        // TODO - TEST
        DequeNode<T> newNode = new DequeNode<>(value, null, null);
        if (first == null) {
            last = newNode;
        } else {
            first.setPrevious(newNode);
        }

        newNode.setNext(first);
        first = newNode;
        size++;
    }

    @Override
    public void append(T value) {
        // TODO
        DequeNode<T> newNode = new DequeNode<>(value, null, null);
        if (first == null) {
            first = newNode;
        } else {
            last.setNext(newNode);
        }

        newNode.setPrevious(last);
        last = newNode;
        size++;
    }

    @Override
    public void deleteFirst() {
        // TODO
        if (first == null)
            throw new DoubleEndedQueueException("Queue is empty");

        if (first == last) {
            first = null;
            last = null;
        } else {
            first = first.getNext();
            first.setPrevious(null);
        }

        size--;
    }

    @Override
    public void deleteLast() {
        // TODO
        if (last == null)
            throw new DoubleEndedQueueException("Queue is empty");

        if (first == last) {
            first = null;
            last = null;
        } else {
            last = last.getPrevious();
            last.setNext(null);
        }

        size--;
    }

    @Override
    public T first() {
        // TODO
        if (first == null)
            throw new DoubleEndedQueueException("Queue is empty");

        return first.getItem();
    }

    @Override
    public T last() {
        // TODO
        if (last == null)
            throw new DoubleEndedQueueException("Queue is empty");

        return last.getItem();
    }

    @Override
    public int size() {
        // TODO
        return size;
    }
}
