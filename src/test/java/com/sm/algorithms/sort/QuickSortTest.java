package com.sm.algorithms.sort;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class QuickSortTest {

  private QuickSort quickSort = new QuickSort();

  @Test
  public void shouldSortArray() throws Exception {
    assertThat(quickSort.sort("ahbeprfcq"), equalTo("abcefhpqr"));
    assertThat(quickSort.sort("ahbeprfq"), equalTo("abefhpqr"));
    assertThat(quickSort.sort("ahbeprfcqn"), equalTo("abcefhnpqr"));
    assertThat(quickSort.sort("ahbepzrfcqn"), equalTo("abcefhnpqrz"));
    assertThat(quickSort.sort("abcdefg"), equalTo("abcdefg"));
    assertThat(quickSort.sort("zyx"), equalTo("xyz"));
  }
}
