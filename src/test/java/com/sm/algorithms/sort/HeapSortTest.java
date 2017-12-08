package com.sm.algorithms.sort;

import static com.google.common.truth.Truth.assertThat;

import org.junit.Test;

public class HeapSortTest {
  @Test
  public void shouldSortArray() throws Exception {
    HeapSort heapSort = new HeapSort();

    assertThat(heapSort.sort(new int[]{})).asList().isEmpty();

    assertThat(heapSort.sort(new int[]{2, 7, 6, 15, 10, 4, 5, 1, 3, 8})).asList()
        .containsExactly(1, 2, 3, 4, 5, 6, 7, 8, 10, 15);

    assertThat(heapSort.sort(new int[]{7, 6, 15, 10, 4, 5, 1, 8})).asList()
        .containsExactly(1, 4, 5, 6, 7, 8, 10, 15);
  }
}
