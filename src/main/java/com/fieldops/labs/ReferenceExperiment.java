package com.fieldops.labs;

import java.util.ArrayList;
import java.util.List;

public class ReferenceExperiment {

    public static void main(String[] args) {
        StringBuilder serial = new StringBuilder("EQ-A");

        List<StringBuilder> original = new ArrayList<>();
        original.add(serial);

        List<StringBuilder> snapshot = List.copyOf(original);

        serial.append("-X");

        System.out.println("A = " + serial);
        System.out.println("B = " + snapshot.get(0));

        serial = new StringBuilder("EQ-B");

        System.out.println("C = " + serial);
        System.out.println("D = " + snapshot.get(0));

        original.clear();

        System.out.println("E = " + original.size());
        System.out.println("F = " + snapshot.size());

        
        StringBuilder equipmentStatus = new StringBuilder("EQ-007");
        StringBuilder auditStatus = equipmentStatus;
        
        review(equipmentStatus);
        
        System.out.println("G = " + equipmentStatus);
        System.out.println("H = " + auditStatus);
    }


    static void review(StringBuilder status) {
        status.append("-CHECKED");
        status.replace(0, status.length(), "RESET");
        status.append("-LOCAL");
    }
}