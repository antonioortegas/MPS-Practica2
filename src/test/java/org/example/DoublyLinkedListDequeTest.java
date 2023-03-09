package org.example;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class DoublyLinkedListDequeTest {

    private DoublyLinkedListDeque<Integer> deque;
    @BeforeEach
    void setUp() {
        deque = new DoublyLinkedListDeque<Integer>();
    }

    @AfterEach
    void tearDown() {

    }

    @Nested
    @DisplayName("When de Queue is empty")
    class EmptyDeque{
        @Test
        @DisplayName("Size should be 0")
        ///Cuando se crea una DoubleLinkedListDeque se inicializa su tamaño en 0 hasta que se haga un append
        void sizeShouldBeZero(){
            assertEquals(0,deque.size());
        }

        @Test
        @DisplayName("First and Last should be null")
        void firstAndLastShouldBeNull(){
            assertThrows(DoubleEndedQueueException.class, () -> deque.first());
            assertThrows(DoubleEndedQueueException.class, () -> deque.last());
        }
        @Test
        @DisplayName("Preppend añade el primer nodo nodo a una lista vacia")
        void prependAddsTheFirstNodeToDequeWhenDequeIsEmpty(){
         ///   DequeNode<Integer> node1 = new DequeNode<Integer>(1,null,null)
            deque.prepend(1);
            assertTrue(deque.first() == 1);
            assertTrue(deque.last() == 1);
            assertTrue(deque.size()==1);

        }
        @Test
        @DisplayName("Preppend añade un nodo")
        void prependAddsANodeAtHeadOfDequeWhenDequeIsNotEmpty(){
            Integer previousSize = deque.size();
            deque.prepend(5);
            assertTrue(deque.first() == 5);
            assertTrue(deque.last() == deque.last());
            assertTrue(deque.size()== previousSize + 1);
        }
    }

}