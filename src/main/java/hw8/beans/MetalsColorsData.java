package hw8.beans;

import java.util.Arrays;
import java.util.List;

public class MetalsColorsData {

    private List<Integer> summary;
    private List<String> elements;
    private String color;
    private String metals;
    private List<String> vegetables;

    public List<Integer> getSummary() {
        return summary;
    }

    public void setSummary(List<Integer> summary) {
        this.summary = summary;
    }

    public List<String> getElements() {
        return elements;
    }

    public void setElements(List<String> elements) {
        this.elements = elements;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMetals() {
        return metals;
    }

    public void setMetals(String metals) {
        this.metals = metals;
    }

    public List<String> getVegetables() {
        return vegetables;
    }

    public void setVegetables(List<String> vegetables) {
        this.vegetables = vegetables;
    }

    public List<String> getExpectedResults() {
        return Arrays.asList(
                "Summary: " + (summary.get(0) + summary.get(1)),
                "Elements: " + elements.toString().replace("[", "").replace("]", ""),
                "Color: " + color,
                "Metal: " + metals,
                "Vegetables: " + vegetables.toString().replace("[", "").replace("]", "")
        );
    }
}
