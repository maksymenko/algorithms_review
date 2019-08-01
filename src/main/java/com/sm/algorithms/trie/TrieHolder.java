package com.sm.algorithms.trie;

import java.util.HashMap;
import java.util.Map;

public class TrieHolder {
    private TrieNode root = new TrieNode('*');

    public int addPhrase(String phrase) {
        if (phrase == null || phrase.length() == 0) {
            return 0;
        }
        TrieNode trie = root;
        for (char ch : phrase.toCharArray()) {
            TrieNode node = trie.next.getOrDefault(ch, new TrieNode(ch));
            trie.next.put(ch, node);
            trie = node;
        }
        trie.frq++;

        return trie.frq;
    }

    public int find(String phrase) {
        TrieNode trie = root;
        for (char ch : phrase.toCharArray()) {
            TrieNode node = trie.next.get(ch);
            if (node == null) {
                return 0;
            }
            trie.next.put(ch, node);
            trie = node;
        }
        return trie.frq;
    }


    private static class TrieNode {
        int frq;
        char ch;
        Map<Character, TrieNode> next;

        TrieNode(char ch) {
            this.ch = ch;
            this.next = new HashMap<>();
        }
    }

    public static void main(String[] args) {
        TrieHolder trieHolder = new TrieHolder();
        System.out.println(">>>find abc " + trieHolder.find("abc"));
        System.out.println(">>> add abs " + trieHolder.addPhrase("abc"));
        System.out.println(">>>find abc " + trieHolder.find("abc"));

        System.out.println(">>>find adc " + trieHolder.find("adc"));
        System.out.println(">>> add " + trieHolder.addPhrase("adc"));
        System.out.println(">>>find adc " + trieHolder.find("adc"));

        System.out.println(">>>find abc " + trieHolder.find("abc"));
        System.out.println(">>>add " + trieHolder.addPhrase("abc"));
        System.out.println(">>>find abc " + trieHolder.find("abc"));
    }


}
