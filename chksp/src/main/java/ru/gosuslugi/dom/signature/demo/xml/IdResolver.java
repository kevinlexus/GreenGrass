package ru.gosuslugi.dom.signature.demo.xml;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import xades4j.utils.DOMHelper;

/**
 * Вспомогательный класс, ответственный за объявление атрибута Id в качестве идентифицирующего
 */
public class IdResolver {
    private IdResolver() {
    }

    /**
     * Объявить атрибут Id в качестве идентифицирующего для поддерева указанного элемента.
     *
     * @param element элемент - корень поддерева
     */
    public static void resolveIds(Element element) {
        DOMHelper.useIdAsXmlId(element);
        for (int i = 0, count = element.getChildNodes().getLength(); i < count; i++) {
            Node node = element.getChildNodes().item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element child = (Element) node;
                resolveIds(child);
            }
        }
    }
}
