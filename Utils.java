package com.hms;



import java.util.concurrent.atomic.AtomicInteger;

public class Utils {
    private static final AtomicInteger idGenerator = new AtomicInteger(1000);

    public static int nextId() {
        return idGenerator.getAndIncrement();
}
}

