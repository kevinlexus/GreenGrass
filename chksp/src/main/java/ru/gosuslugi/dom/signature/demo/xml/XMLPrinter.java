package ru.gosuslugi.dom.signature.demo.xml;

import org.w3c.dom.Node;
import org.w3c.dom.bootstrap.DOMImplementationRegistry;
import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSOutput;
import org.w3c.dom.ls.LSSerializer;

import java.io.ByteArrayOutputStream;
import java.io.StringWriter;

/**
 * Вспомогательный класс для сохранения XML-документа.
 */
public class XMLPrinter {
    private XMLPrinter() {
    }

    public static String toString(Node root) {
        DOMImplementationLS impl = getDomImplementationLS();
        LSSerializer serializer = impl.createLSSerializer();
        configureSerializer(serializer, root);
        LSOutput output = impl.createLSOutput();
        StringWriter sw = new StringWriter(4096);
        output.setCharacterStream(sw);
        configureOutput(output, root);
        if (!serializer.write(root, output)) {
            throw new IllegalArgumentException("Cannot serialize XML");
        }
        return sw.toString();
    }

    public static byte[] toBytes(Node root) {
        DOMImplementationLS impl = getDomImplementationLS();
        LSSerializer serializer = impl.createLSSerializer();
        configureSerializer(serializer, root);
        LSOutput output = impl.createLSOutput();
        ByteArrayOutputStream buffer = new ByteArrayOutputStream(4096);
        output.setByteStream(buffer);
        configureOutput(output, root);
        if (!serializer.write(root, output)) {
            throw new IllegalArgumentException("Cannot serialize XML");
        }
        return buffer.toByteArray();
    }

    private static void configureSerializer(LSSerializer serializer, Node root) {
        boolean omitDeclaration = root.getOwnerDocument() != null && root.getOwnerDocument().getXmlEncoding() == null;
        serializer.getDomConfig().setParameter("xml-declaration", !omitDeclaration);
    }

    private static void configureOutput(LSOutput output, Node root) {
        if (root.getOwnerDocument() != null && root.getOwnerDocument().getXmlEncoding() != null)
            output.setEncoding(root.getOwnerDocument().getXmlEncoding());
    }

    private static DOMImplementationLS getDomImplementationLS() {
        try {
            DOMImplementationRegistry reg = DOMImplementationRegistry.newInstance();
            return (DOMImplementationLS) reg.getDOMImplementation("LS");
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }
}
