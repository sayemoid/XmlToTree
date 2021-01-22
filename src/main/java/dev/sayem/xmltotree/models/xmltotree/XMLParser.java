package dev.sayem.xmltotree.models.xmltotree;

import dev.sayem.xmltotree.models.xmltotree.models.XMLNode;
import org.apache.commons.io.FileUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class XMLParser {
    private XMLParser() {
    }

    public static List<XMLNode> parse(String xml, Map<String, String> labels) throws IOException, ParserConfigurationException, SAXException {
        File file = File.createTempFile("xmltree", ".xml");
        FileUtils.writeStringToFile(file, xml, StandardCharsets.UTF_8);
        return XMLParser.parse(file, labels);
    }

    public static List<XMLNode> parse(File file, Map<String, String> labels) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory
                .newInstance();
        DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
        Document document = docBuilder.parse(file);

        List<XMLNode> xmlNodes = new ArrayList<>();

        NodeList nodeList = document.getChildNodes();

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            XMLNode xmlNode = new XMLNode();
            xmlNode.setName(node.getNodeName());
            if (labels != null)
                xmlNode.setLabel(labels.get(node.getNodeName()));
            xmlNode.setValue(node.getTextContent());
            xmlNode.setChildren(XMLParser.childNodes(node, labels));
            xmlNodes.add(xmlNode);
        }

        return xmlNodes;
    }

    private static List<XMLNode> childNodes(Node node, Map<String, String> labels) {

        List<XMLNode> xmlNodes = new ArrayList<>();

        for (int i = 0; i < node.getChildNodes().getLength(); i++) {
            Node cNode = node.getChildNodes().item(i);
            if (cNode.getNodeType() == Node.ELEMENT_NODE) {
                XMLNode xmlNode = new XMLNode();
                xmlNode.setName(cNode.getNodeName());
                if (labels != null)
                    xmlNode.setLabel(labels.get(cNode.getNodeName()));
                xmlNode.setValue(cNode.getTextContent());
                xmlNode.setChildren(XMLParser.childNodes(cNode, labels));
                xmlNodes.add(xmlNode);
            }
        }

        return xmlNodes;
    }

}
