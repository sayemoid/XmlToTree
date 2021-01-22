package dev.sayem.xmltotree.models.xmltotree;

import dev.sayem.xmltotree.models.xmltotree.models.XMLNode;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        List<XMLNode> nodes = XMLParser.parse(new File("pom.xml"), null);
    }
}
