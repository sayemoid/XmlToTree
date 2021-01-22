package dev.sayem.xmltotree.models.xmltotree.models;

import java.util.List;

public class XMLNode {
    private String name;
    private String label;

    private String value;
    private List<XMLNode> children;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLabel() {
        String text = label != null && !label.isEmpty() ? label : name;
        if (children == null || children.isEmpty())
            text += " : " + value;
        return text;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public List<XMLNode> getChildren() {
        return children;
    }

    public void setChildren(List<XMLNode> children) {
        this.children = children;
    }
}
