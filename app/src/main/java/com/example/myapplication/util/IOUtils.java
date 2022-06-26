package com.example.myapplication.util;

public final class IOUtils {
    public static void closeQuietly(AutoCloseable... acs) {
        for (AutoCloseable ac : acs) {
            if (ac != null) {
                try {
                    ac.close();
                } catch (Exception ignored) {
                }
            }
        }
    }

    private IOUtils() {
    }
}
