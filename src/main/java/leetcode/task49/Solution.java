package leetcode.task49;

import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        List<MyString> myStrings = new ArrayList<>();
        for (String str : strs) {
            myStrings.add(new MyString(str));
        }

        Map<MyString, List<String>> map = new HashMap<>();
        for (MyString myString : myStrings) {
            if (map.containsKey(myString)) {
                List<String> strings = map.get(myString);
                strings.add(myString.string);
            } else {
                List<String> list = new LinkedList<>();
                list.add(myString.string);
                map.put(myString, list);
            }
        }

        map.forEach((key, value) -> res.add(value));

        return res;
    }

    private Map<Character, Integer> strToCharsMap(String str) {
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = str.toCharArray();
        for (char aChar : chars) {
            Integer charsCount = map.getOrDefault(aChar, 0);
            map.put(aChar, charsCount + 1);
        }
        return map;
    }

    private class MyString {

        private final String string;
        private final Map<Character, Integer> charMap;

        public MyString(String string) {
            this.string = string;
            this.charMap = strToCharsMap(string);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            MyString myString = (MyString) o;
            return charMap.equals(myString.charMap);
        }

        @Override
        public int hashCode() {
            return Objects.hash(charMap);
        }
    }
}
