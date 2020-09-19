package com.johnmsaylor.sportsradar;

import java.time.Instant;

public class Utility {

    public static Instant instant;

    public static Instant formatDate(String input) {
        input = input.substring(0,(input.length() - 6));
        input = input.concat(".00Z");

        instant = Instant.parse(input);

        return instant;
    }
}
