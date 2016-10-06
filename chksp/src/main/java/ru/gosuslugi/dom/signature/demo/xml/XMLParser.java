package ru.gosuslugi.dom.signature.demo.xml;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;

/**
 * Вспомогательный класс для загрузки XML-документа в память.
 */
public class XMLParser {
    private XMLParser() {
    }

    public static Document parseXml(byte[] xml) throws SAXException {
        try {
            DocumentBuilder db = newDocumentBuilder();
            return db.parse(new ByteArrayInputStream(xml));
        } catch (ParserConfigurationException | IOException e) {
            throw new IllegalStateException("Internal error", e);
        }
    }

    public static Document parseXml(String xml) throws SAXException {
        try {
            DocumentBuilder db = newDocumentBuilder();
            return db.parse(new InputSource(new StringReader(xml)));
        } catch (ParserConfigurationException | IOException e) {
            throw new IllegalStateException("Internal error", e);
        }
    }

    public static Document parseXml(File file) throws SAXException, IOException {
        try {
            DocumentBuilder db = newDocumentBuilder();
            return db.parse(file);
        } catch (ParserConfigurationException e) {
            throw new IllegalStateException("Internal error", e);
        }
    }

    private static DocumentBuilder newDocumentBuilder() throws ParserConfigurationException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, Boolean.TRUE);
        dbf.setFeature("http://apache.org/xml/features/disallow-doctype-decl", Boolean.TRUE);
        dbf.setNamespaceAware(true);

        return dbf.newDocumentBuilder();
    }
}
