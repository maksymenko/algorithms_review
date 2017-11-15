package com.sm.algorithms.sort;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class MergeSortTopDownTest {
  private MergeSortTopDown mergeSortTopDown = new MergeSortTopDown();

  @Test
  public void shouldSortArray() throws Exception {
    String sortedStr = mergeSortTopDown.sort("ahbeprfw");
    assertThat(sortedStr, equalTo("abefhprw"));
  }
}
