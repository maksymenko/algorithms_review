package com.sm.algorithms.sort;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

import org.junit.Test;

public class InsertionSortTest {
  private InsertionSort insertionSort = new InsertionSort();

  @Test
  public void shouldSortArray() throws Exception {
    String sortedStr = insertionSort.sort("ahbeprfw");
    assertThat(sortedStr, equalTo("abefhprw"));
  }
}
