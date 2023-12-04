package org.kalbeka;

import java.util.*;

public class Array {
    private final List<String> groups = new ArrayList<>();

    public void add(String group) {
        groups.add(group);
    }

    public void get() {

        Set<String> set = new LinkedHashSet<>(groups);

        System.out.println(set);

        HashMap<String, Integer> countGroups = new HashMap<String, Integer>();

        for (int i = 0; i <= groups.size() - 1; i++) {

            if (countGroups.containsKey(groups.get(i))) {
                int counter = countGroups.get(groups.get(i));
                countGroups.put(groups.get(i), counter + 1);

            } else {

                countGroups.put(groups.get(i), 1);
            }
        }
        System.out.println(countGroups);
    }
}
