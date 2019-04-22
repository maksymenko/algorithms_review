package com.sm.misc_3;

public class SentenceReverser {

  public String reverse(String str) {
    if (str == null || str.length() < 1) {
      return str;
    }
    String[] arr = str.split(" ");
    int start = 0;
    int end = arr.length - 1;

    while(start < end) {
      String tmp = arr[end];
      arr[end] = arr[start];
      arr[start] = tmp;
      start++;
      end--;
    }

    return String.join(" ",  arr);
  }

  public static void main(String[] args) {
    SentenceReverser sr = new SentenceReverser();
    System.out.println(">>>>> " + sr.reverse("one"));
    System.out.println(">>>>> " + sr.reverse("first  ,  second    third"));
    System.out.println(">>>>> " + sr.reverse("first second third fourth"));
  }
}
