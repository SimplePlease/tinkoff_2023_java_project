package ru.tinkoff.edu.java.parser;

import java.net.URI;

public class StackOverflowLinkParser extends LinkParser {

    public StackOverflowLinkParser(LinkParser nextParser) {
        super(nextParser);
    }

    @Override
    public Object parse(URI link) {
        if (link.getHost().equals("stackoverflow.com")) {
            String path = link.getPath();
            String[] tokens = path.split("/");
            Long id;
            if (tokens.length >= 3 && tokens[0].isEmpty() && tokens[1].equals("questions") && (id = parse(tokens[2])) != null) {
                return id;
            }

        } else if (nextParser != null) {
            return nextParser.parse(link);
        }
        return null;
    }

    private Long parse(String n) {
        try {
            return Long.parseLong(n);
        } catch (NumberFormatException ex) {
            return null;
        }
    }
}