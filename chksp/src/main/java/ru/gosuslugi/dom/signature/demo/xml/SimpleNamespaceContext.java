package ru.gosuslugi.dom.signature.demo.xml;

import javax.xml.namespace.NamespaceContext;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Контекст пространства имен для XPath.
 */
public class SimpleNamespaceContext implements NamespaceContext {
    private final Map<String, String> ns = new HashMap<String, String>();

    public SimpleNamespaceContext(Map<String, String> ns) {
        this.ns.putAll(ns);
    }

    public String getNamespaceURI(String prefix) {
        return ns.get(prefix);
    }

    public String getPrefix(String uri) {
        throw new UnsupportedOperationException();
    }

    public Iterator getPrefixes(String uri) {
        throw new UnsupportedOperationException();
    }
}
