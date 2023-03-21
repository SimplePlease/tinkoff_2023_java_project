package ru.tinkoff.edu.java.parser;

import java.net.URI;
import java.util.Map;

public class GitHubLinkParser extends LinkParser {

    public GitHubLinkParser(LinkParser nextParser) {
        super(nextParser);
    }

    @Override
    public Object parse(URI link) {
        if (link.getHost().equals("github.com")) {
            String path = link.getPath();
            String[] tokens = path.split("/");
            if (tokens.length >= 3 && tokens[0].isEmpty() && !tokens[1].isEmpty() && !tokens[2].isEmpty()) {
                String user = tokens[1];
                String repo = tokens[2];
                return Map.entry(user, repo);
            }

        } else if (nextParser != null) {
            return nextParser.parse(link);
        }
        return null;
    }
}