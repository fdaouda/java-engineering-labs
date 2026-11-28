package com.fieldops.labs;

public class Intervention {

    private String status = "CREATED";

    public void start() {
        status = "IN_PROGRESS";
    }

    public void complete() {
        if (!"IN_PROGRESS".equals(status)) {
            throw new IllegalStateException(
                "Cannot complete intervention");
        }

        status = "COMPLETED";
    }

    public String getStatus() {
        return status;
    }
}