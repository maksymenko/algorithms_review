package com.sm.algorithms.sort;

import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

public class SmallestKthElementTest {
    private SmallestKthElement finder = new SmallestKthElement();

    @Test
    public void shouldFindKthSmallest() throws Exception {
        assertThat(finder.find(new int[] {1}, 1)).isEqualTo(1);
        assertThat(finder.find(new int[] {1, 2, 3, 4, 5}, 2)).isEqualTo(2);
        assertThat(finder.find(new int[] {1, 2, 3, 4}, 3)).isEqualTo(3);
        assertThat(finder.find(new int[] {6, 2, 4, 9, 3}, 4)).isEqualTo(6);
        assertThat(finder.find(new int[] {6, 2, 4, 9, 3, 5}, 3)).isEqualTo(4);

    }
}
