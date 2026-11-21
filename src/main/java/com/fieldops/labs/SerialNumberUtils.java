package com.fieldops.labs;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

class SerialNumberUtils {

    public static List<String> removeDuplicates(List<String> serials) {
        Set<String> serialsWithoutDuplicates = new LinkedHashSet<>();

        for (String serial : serials) {
            serialsWithoutDuplicates.add(serial);
        }

        List<String> result = List.copyOf(serialsWithoutDuplicates);

        return result;
    }
}