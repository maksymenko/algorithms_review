package com.sm.algorithms.sort;

import static com.google.common.truth.Truth.assertThat;

import org.junit.Test;

public class CountingSortTest {
  @Test
  public void shouldSortArray() throws Exception {
    CountingSort countingSort = new CountingSort();
    assertThat(countingSort.sort(new char[]{'b', 'c', 'b', 'c', 'a', 'c', 'a', 'b'}, 3)).asList()
        .containsExactly('a', 'a', 'b', 'b', 'b', 'c', 'c', 'c');
  }
}
