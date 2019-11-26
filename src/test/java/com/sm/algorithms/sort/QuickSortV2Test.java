package com.sm.algorithms.sort;

import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

public class QuickSortV2Test {
    private QuickSortV2 quickSort = new QuickSortV2();

    @Test
    public void shouldSortArray() throws Exception {
        assertThat(quickSort.sort("")).isEqualTo("");
        assertThat(quickSort.sort("ahbeprfcq")).isEqualTo("abcefhpqr");
        assertThat(quickSort.sort("ahbeprfq")).isEqualTo("abefhpqr");
        assertThat(quickSort.sort("ahbeprfcqn")).isEqualTo("abcefhnpqr");
        assertThat(quickSort.sort("ahbepzrfcqn")).isEqualTo("abcefhnpqrz");
        assertThat(quickSort.sort("abcdefg")).isEqualTo("abcdefg");
        assertThat(quickSort.sort("zyx")).isEqualTo("xyz");
        assertThat(quickSort.sort("zyxwvut")).isEqualTo("tuvwxyz");
        assertThat(quickSort.sort("zyxwvu")).isEqualTo("uvwxyz");
    }
}
