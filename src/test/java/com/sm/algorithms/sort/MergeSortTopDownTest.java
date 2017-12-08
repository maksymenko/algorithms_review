package com.sm.algorithms.sort;

import static com.google.common.truth.Truth.assertThat;

import org.junit.Test;

public class MergeSortTopDownTest {
  private MergeSortTopDown mergeSortTopDown = new MergeSortTopDown();

  @Test
  public void shouldSortArray() throws Exception {
    assertThat(mergeSortTopDown.sort("ahbeprfcq")).isEqualTo("abcefhpqr");
    assertThat(mergeSortTopDown.sort("ahbeprfq")).isEqualTo("abefhpqr");
    assertThat(mergeSortTopDown.sort("ahbeprfcqn")).isEqualTo("abcefhnpqr");
    assertThat(mergeSortTopDown.sort("ahbepzrfcqn")).isEqualTo("abcefhnpqrz");
  }
}
