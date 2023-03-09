package org.example;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class DoublyLinkedListDequeTest {

    private DoublyLinkedListDeque<Integer> deque;
    @BeforeEach
    void setUp() {
        deque = new DoublyLinkedListDeque<>();
    }

    @AfterEach
    void tearDown() {

    }

    @Nested
    @DisplayName("When de Queue is empty")
    class EmptyDeque {
        @Test
        @DisplayName("Size should be 0")

        void sizeShouldBeZero() {
            assertEquals(0, deque.size());
        }

        @Test
        @DisplayName("First and Last should be null")
        void firstAndLastShouldBeNull() {
            assertThrows(DoubleEndedQueueException.class, () -> deque.first());
            assertThrows(DoubleEndedQueueException.class, () -> deque.last());
        }

        @Test
        @DisplayName("Prepend adds the first node")
        void prependAddsTheFirstNodeToDequeWhenDequeIsEmpty() {
            ///   DequeNode<Integer> node1 = new DequeNode<Integer>(1,null,null)
            deque.prepend(1);
            assertEquals(deque.first(), 1);
            assertEquals(deque.last(), 1);
            assertEquals(deque.size(), 1);

        }

        @Test
        @DisplayName("Append adds the first node")
        void appendAddsTheFirstNodeToDequeWhenDequeIsEmpty() {
            ///   DequeNode<Integer> node1 = new DequeNode<Integer>(1,null,null)
            deque.append(1);
            assertEquals(deque.first(), 1);
            assertEquals(deque.last(), 1);
            assertEquals(deque.size(), 1);

        }

        @Test
        @DisplayName("can not delete the first element")
        void DeleteFirstRisesAnExceptionWhenDequeIsEmpty() {
            assertThrows(DoubleEndedQueueException.class, () -> deque.deleteFirst());
        }

        @Test
        @DisplayName("can not delete the last element")
        void DeleteLastRisesAnExceptionWhenDequeIsEmpty() {
            assertThrows(DoubleEndedQueueException.class, () -> deque.deleteLast());
        }
    }
        @Nested
        @DisplayName("List is not empty")
        class NotEmptyDeque{
            @Test
            @DisplayName("Prepend adds another node")
            void prependAddsANodeAtHeadOfDequeWhenDequeIsNotEmpty(){
                deque.append(1);
                deque.append(2);
                deque.append(3);

                Integer previousSize = deque.size();
                deque.prepend(5);
                assertEquals(deque.first(), 5);
                assertEquals(deque.last(), deque.last());
                assertEquals(deque.size(), previousSize + 1);
            }

            @Test
            @DisplayName("Append adds another node")
            void appendAddsANodeAtTailOfDequeWhenDequeIsNotEmpty(){
                deque.append(1);
                deque.append(2);
                deque.append(3);

                Integer previousSize = deque.size();
                deque.append(5);
                assertEquals(deque.first(), deque.first());
                assertEquals(deque.last(), 5);
                assertEquals(deque.size(), previousSize + 1);
            }

            @Test
            @DisplayName("delete the first and only element")
            void DeleteFirstDeletesTheFirstAndOnlyNodeWhenDequeIsNotEmptyAndHasOneNode() {
                deque.append(1);
                Integer previousSize = deque.size();

                deque.deleteFirst();
                Integer actualSize = deque.size();

                assertEquals(previousSize, actualSize +1);
                assertEquals(actualSize, 0);
                assertThrows(DoubleEndedQueueException.class, () -> deque.first());
                assertThrows(DoubleEndedQueueException.class, () -> deque.last());
            }

            @Test
            @DisplayName("delete the last and only element")
            void DeleteLastDeletesTheLastAndOnlyNodeWhenDequeIsNotEmptyAndHasOneNode() {
                deque.append(1);
                Integer previousSize = deque.size();

                deque.deleteLast();
                Integer actualSize = deque.size();

                assertEquals(previousSize, actualSize +1);
                assertEquals(actualSize, 0);
                assertThrows(DoubleEndedQueueException.class, () -> deque.first());
                assertThrows(DoubleEndedQueueException.class, () -> deque.last());
            }
            @Test
            @DisplayName("delete the first element")
            void DeleteFirstDeletesTheFirstNodeWhenDequeIsNotEmptyAndHasMoreThanOneNode() {
                deque.append(1);
                deque.append(2);
                deque.append(3);
                Integer previousSize = deque.size();

                deque.deleteFirst();
                Integer actualSize = deque.size();

                assertEquals(previousSize, actualSize +1);
                assertEquals(deque.first(), 2);
                assertEquals(deque.last(), 3);
            }
            @Test
            @DisplayName("delete the last element")
            void DeleteLastDeletesTheLastNodeWhenDequeIsNotEmptyAndHasMoreThanOneNode() {
                deque.append(1);
                deque.append(2);
                deque.append(3);
                Integer previousSize = deque.size();

                deque.deleteLast();
                Integer actualSize = deque.size();

                assertEquals(previousSize, actualSize +1);
                assertEquals(deque.first(), 1);
                assertEquals(deque.last(), 2);
            }

        }
}