package ru.tinkoff.edu.java.parser;

import java.net.URI;

public abstract class LinkParser {

    protected LinkParser nextParser;

    public LinkParser(LinkParser nextParser) {
        this.nextParser = nextParser;
    }

    public abstract Object parse(URI link);
}