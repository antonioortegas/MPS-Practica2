package org.example;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

/*
    TESTS:
    1- Node with neither next node nor previous node
        1.1 - Node returns the same item value
        1.2 - Node is first node
        1.3 - Node is last node
        1.4 - Node returns the changed item value
        1.5 - Node is terminal (No previos nor next node)
        2- Node with next or previous node
            2.1 - Node with next Node returns next node (Getter)
            2.2 - Node with previous Node returns previous node (Getter)
            2.3 - Node is not terminal with previous node
            2.4 - Node is not terminal with next node
            3- Node with both next and previous node
                3.1 - Node next node setter changes next node, not previous node (Setter)
                3.2 - Node previous node setter changes previous node, not next node (Setter)
                3.3 - Node is not terminal (Has both next and previous node)

 */

/**
 * @author Antonio Ortega Santaolalla
 * @author Teodoro Hidalgo Guerrero
 */
class DequeNodeTest {

    DequeNode<String> node;

    @BeforeEach
    void setUp() {
        node = new DequeNode<>("test", null, null);
    }

    @AfterEach
    void tearDown() {
        node = null;
    }

    @Nested
    @DisplayName("Neither with next node nor previous node")
    class EmptyNode {

        @Test
        void checkNodeReturnsSameItem() {
            assertEquals("test", node.getItem());
        }

        @Test
        void checkFirstNodeReturnsTrueIfFirst() {
            assertTrue(node.isFirstNode());
        }

        @Test
        void checkLastNodeReturnsTrueIfLast() {
            assertTrue(node.isLastNode());
        }

        @Test
        void checkNodeRefreshItemValue() {
            node.setItem("changedItemValue");

            assertEquals("changedItemValue", node.getItem());
        }

        @Test
        void checkTerminalIfHasntPreviousNorNextNode() {
            DequeNode<String> nextNode = new DequeNode<>("next", null, null);

            assertFalse(nextNode.isNotATerminalNode());
        }


        @Nested
        @DisplayName("With previous node or next node")
        class NodeWithNeighbour {

            @Test
            void checkNextNodeGetterReturnsNextNode() {
                DequeNode<String> previousnode = new DequeNode<>("previous", null, node);

                assertEquals(node, previousnode.getNext());
            }

            @Test
            void checkPreviousNodeGetterReturnsPreviousNode() {
                DequeNode<String> nextnode = new DequeNode<>("next", node, null);

                assertEquals(node, nextnode.getPrevious());
            }

            @Test
            void checkTerminalIfHasNextNode() {
                DequeNode<String> previousNode = new DequeNode<>("previous", null, node);

                assertFalse(previousNode.isNotATerminalNode());
            }

            @Test
            void checkTerminalIfHasPreviousNode() {
                DequeNode<String> nextNode = new DequeNode<>("next", node, null);

                assertFalse(nextNode.isNotATerminalNode());
            }


            @Nested
            @DisplayName("With both next and previous nodes")
            class FullNeighbourNode {

                @Test
                void checkSetterChangesNextNode() {
                    DequeNode<String> newNode = new DequeNode<>("middle", node, node);
                    DequeNode<String> nextNode = new DequeNode<>("next", null, null);

                    assertEquals(newNode.getNext(), node);

                    newNode.setNext(nextNode);

                    assertEquals(nextNode, newNode.getNext());
                    assertEquals(node, newNode.getPrevious());
                }

                @Test
                void checkSetterChangesPreviousNode() {
                    DequeNode<String> newNode = new DequeNode<>("middle", node, node);
                    DequeNode<String> previousNode = new DequeNode<>("previous", null, null);

                    assertEquals(newNode.getPrevious(), node);

                    newNode.setPrevious(previousNode);

                    assertEquals(previousNode, newNode.getPrevious());
                    assertEquals(node, newNode.getNext());
                }

                @Test
                void checkNotTerminalIfHasPreviousAndNextNode() {
                    DequeNode<String> nextNode = new DequeNode<>("middle", node, node);

                    assertTrue(nextNode.isNotATerminalNode());
                }

            }
        }

    }

}