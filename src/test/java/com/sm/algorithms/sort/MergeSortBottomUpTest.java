package com.sm.algorithms.sort;

import static com.google.common.truth.Truth.assertThat;

import org.junit.Test;


public class MergeSortBottomUpTest {
  private MergeSortBottomUp mergeSortBottomUp = new MergeSortBottomUp();

  @Test
  public void shouldSortArray() throws Exception {
    assertThat(mergeSortBottomUp.sort("ahbeprfcq")).isEqualTo("abcefhpqr");
    assertThat(mergeSortBottomUp.sort("ahbeprfq")).isEqualTo("abefhpqr");
    assertThat(mergeSortBottomUp.sort("ahbeprfcqn")).isEqualTo("abcefhnpqr");
    assertThat(mergeSortBottomUp.sort("ahbepzrfcqn")).isEqualTo("abcefhnpqrz");
  }
}
