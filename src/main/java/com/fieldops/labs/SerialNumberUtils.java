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

    public static List<String> findNewSerials(
            List<String> importedSerials,
            List<String> registeredSerials) {

        Set<String> newSerialsWithoutDuplicates = new LinkedHashSet<>();

        for (String serial : importedSerials) {
            if (!registeredSerials.contains(serial)) {
                newSerialsWithoutDuplicates.add(serial);
            }
        }

        return List.copyOf(newSerialsWithoutDuplicates);

    }
}