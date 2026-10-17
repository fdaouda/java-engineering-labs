package com.fieldops.labs;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class HashSetLab {

    static class Equipment {
        private final String serialNumber;

        Equipment(String serialNumber) {
            this.serialNumber = serialNumber;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Equipment other)) return false;
            return Objects.equals(serialNumber, other.serialNumber);
        }

        @Override
        public int hashCode() {
            return 42;
        }
    }

    public static void main(String[] args) {
        Set<Equipment> equipments = new HashSet<>();

        equipments.add(new Equipment("ABC"));
        equipments.add(new Equipment("XYZ"));
        equipments.add(new Equipment("ABC"));

        System.out.println(equipments.size());
    }
}