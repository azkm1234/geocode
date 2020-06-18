package com.bestcode.geocode;

/**
 * 词典，保存前缀树
 */
public class Dictionary {
    private static AstSegment astSegment = null;
    private static final Object lock = new Object();

    private static void loadAstSegment() {
        if (astSegment == null) {
            synchronized (lock) {
                if (astSegment == null) {

                }
            }
        }
    }

    public static void doLoadAstSegment() {

    }
}
