package com.sm.algorithms.sort;

import static com.google.common.truth.Truth.assertThat;

import org.junit.Test;

public class QuickSortTest {

  private QuickSort quickSort = new QuickSort();

  @Test
  public void shouldSortArray() throws Exception {
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
