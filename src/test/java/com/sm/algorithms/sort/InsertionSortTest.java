package com.sm.algorithms.sort;

import static com.google.common.truth.Truth.assertThat;

import org.junit.Test;

public class InsertionSortTest {
  private InsertionSort insertionSort = new InsertionSort();

  @Test
  public void shouldSortArray() throws Exception {
    String sortedStr = insertionSort.sort("ahbeprfw");
    assertThat(sortedStr).isEqualTo("abefhprw");
  }
}
