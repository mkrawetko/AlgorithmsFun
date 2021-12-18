package com.mkrawetko;

import com.mkrawetko.RemoveDuplicatesFromSortedList.ListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.params.provider.Arguments.of;

public class RemoveDuplicatesFromSortedListTest {

    private final RemoveDuplicatesFromSortedList underTest = new RemoveDuplicatesFromSortedList();


    public static Stream<Arguments> data() {
        return Stream.of(of(nodesAs(1, 1, 2), nodesAs(1, 2)),
                of(nodesAs(1, 1, 2, 3, 3), nodesAs(1, 2, 3)),
                of(nodesAs(1, 1, 1, 2, 3, 3), nodesAs(1, 2, 3)),
                of(nodesAs(10, 8, 8, 8, 3, 3), nodesAs(10, 8, 3))
        );
    }

    private static ListNode nodesAs(Integer head, Integer... values) {
        List<Integer> valuesList = asList(values);
        Collections.reverse(valuesList);
        return Stream.concat(valuesList.stream(), Stream.of(head))
                .map(ListNode::new)
                .reduce((ln1, ln2) -> new ListNode(ln2.val, ln1)).orElseThrow();
    }

    @ParameterizedTest
    @MethodSource("data")
    public void shouldRemoveDuplicates(ListNode head, ListNode expected) {
        ListNode actual = underTest.deleteDuplicates(head);

        while (actual != null) {
            assertEquals(expected.val, actual.val);
            actual.val = expected.val;
            actual = actual.next;
            expected = expected.next;
        }
        assertNull(expected);
    }
}