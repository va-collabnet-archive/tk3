package org.ihtsdo.uuidtrie;

import java.io.IOException;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {
        try {
            for (int testNid = -1; testNid > -1000; testNid--) {
                UUID test = UUID.randomUUID();
                UuidNidTrieMap uuidNidTrieMap = new UuidNidTrieMap();

                uuidNidTrieMap.add(test, testNid);
                int resultNid = uuidNidTrieMap.get(test);
                if (resultNid == testNid) {
                    System.out.println("Found nid for: " + test + " nid: " + resultNid);
                } else {
                    System.out.println("! Failed to find nid for: " + test + " nid: " + resultNid);
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
