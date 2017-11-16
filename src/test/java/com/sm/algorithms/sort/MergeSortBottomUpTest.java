package com.sm.algorithms.sort;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class MergeSortBottomUpTest {
  private MergeSortBottomUp mergeSortBottomUp = new MergeSortBottomUp();

  @Test
  public void shouldSortArray() throws Exception {
    String sortedStr = mergeSortBottomUp.sort("ahbeprfw");
    assertThat(sortedStr, equalTo("abefhprw"));
  }
}
