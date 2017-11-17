package com.sm.algorithms.sort;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class MergeSortBottomUpTest {
  private MergeSortBottomUp mergeSortBottomUp = new MergeSortBottomUp();

  @Test
  public void shouldSortArray() throws Exception {
    assertThat("abcefhpqr", equalTo(mergeSortBottomUp.sort("ahbeprfcq")));
    assertThat("abefhpqr", equalTo(mergeSortBottomUp.sort("ahbeprfq")));
    assertThat("abcefhnpqr", equalTo(mergeSortBottomUp.sort("ahbeprfcqn")));
    assertThat("abcefhnpqrz", equalTo(mergeSortBottomUp.sort("ahbepzrfcqn")));
  }
}
