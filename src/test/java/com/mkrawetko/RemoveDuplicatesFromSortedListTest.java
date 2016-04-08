package com.mkrawetko;

import com.mkrawetko.RemoveDuplicatesFromSortedList.ListNode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.IntStream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class RemoveDuplicatesFromSortedListTest {


    @Parameterized.Parameter
    public ListNode head;
    @Parameterized.Parameter(value = 1)
    public ListNode expected;
    private RemoveDuplicatesFromSortedList underTest = new RemoveDuplicatesFromSortedList();

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {nodesAs(1, 1, 2), nodesAs(1, 2)},
                {nodesAs(1, 1, 2, 3, 3), nodesAs(1, 2, 3)},
        });
    }

    private static ListNode nodesAs(int head, int... values) {
        ListNode headNode = new ListNode(head);
        final ListNode[] node = {headNode};

        IntStream.of(values).forEach(v -> {
            node[0].next = new ListNode(v);
            node[0] = node[0].next;
        });
        return headNode;
    }

    @Test
    public void test() throws Exception {
        ListNode actual = underTest.deleteDuplicates(head);

        assertThat(actual, equalTo(expected));

    }
}