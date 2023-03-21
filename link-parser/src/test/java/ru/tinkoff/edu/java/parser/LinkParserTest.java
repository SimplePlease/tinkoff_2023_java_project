package ru.tinkoff.edu.java.parser;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.net.URI;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class LinkParserTest {

    private static LinkParser linkParser;

    @BeforeAll
    static void initLinkParser() {
        LinkParser stackOverflowLinkParser = new StackOverflowLinkParser(null);
        linkParser = new GitHubLinkParser(stackOverflowLinkParser);
    }

    @Test
    void testStackOverflowLink() {
        String link = "https://stackoverflow.com/questions/2619598/differences-between-dependencymanagement-and-dependencies-in-maven";

        assertEquals(2619598L,
                linkParser.parse(URI.create(link)));
    }

    @Test
    void testGitHubLink() {
        String link = "https://github.com/SimplePlease/mega_market/blob/main/README.md";

        assertEquals(Map.entry("SimplePlease", "mega_market"),
                linkParser.parse(URI.create(link)));
    }

    @Test
    void testOtherLink() {
        String link = "https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-api/5.9.2";

        assertNull(linkParser.parse(URI.create(link)));
    }
}