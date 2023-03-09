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
        if(first == null) {
            last = newNode;
        } else {
            last.setNext(newNode);
            first.setPrevious(newNode);
        }

        newNode.setPrevious(last);
        newNode.setNext(first);
        first = newNode;
        size++;
    }

    @Override
    public void append(T value) {
        // TODO
        DequeNode<T> newNode = new DequeNode<>(value, null, null);
        if(first == null) {
            last = newNode;
        } else {
            last.setNext(newNode);
            first.setPrevious(newNode);
        }

        newNode.setPrevious(last);
        newNode.setNext(first);
        last = newNode;
        size++;
    }

    @Override
    public void deleteFirst() {
        // TODO
        if(first == null)
            return;

        if(first == last) {
            first = null;
            last = null;
        } else {
            first.getNext().setPrevious(last);
            first = first.getNext();
            last.setNext(first);
        }
        size--;
    }

    @Override
    public void deleteLast() {
        // TODO
        if(last == null)
            return;

        if(first == last) {
            first = null;
            last = null;
        } else {
            last.getPrevious().setNext(first);
            last = last.getPrevious();
            first.setPrevious(last);
        }

        size--;
    }

    @Override
    public T first() {
        // TODO
        return first.getItem();
    }

    @Override
    public T last() {
        // TODO
        return last.getItem();
    }

    @Override
    public int size() {
        // TODO
        return size;
    }
}
