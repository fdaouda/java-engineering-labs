package com.fieldops.labs;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

class SerialNumberUtils {

    public static List<String> removeDuplicates(List<String> serials) {
        Set<String> listWithoutDuplicates = new LinkedHashSet<>();

        for (String serial : serials) {
            listWithoutDuplicates.add(serial);
        }
        List<String> result = new ArrayList<>(listWithoutDuplicates);
        return result;  
    }
}