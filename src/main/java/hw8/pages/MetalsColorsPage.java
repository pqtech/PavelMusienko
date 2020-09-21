package hw8.pages;

import com.epam.jdi.light.elements.complex.Checklist;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.ui.html.elements.common.Button;
import hw8.beans.MetalsColorsData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class MetalsColorsPage extends WebPage {

    @FindBy(id = "odds-selector")
    private WebElement oddRow;

    @FindBy(id = "even-selector")
    private WebElement evenRow;

    @FindBy(id = "submit-button")
    private Button submitBtn;

    @JDropdown(root = "#colors",
            value = ".filter-option",
            list = "li",
            expand = ".caret")
    private Dropdown colors;

    @JDropdown(root = "#metals",
            value = ".filter-option",
            list = "li",
            expand = ".caret")
    private Dropdown metals;

    @JDropdown(root = "#salad-dropdown",
            value = ".btn",
            list = "li",
            expand = ".caret")
    private Dropdown vegetables;

    @FindBy(css = "#elements-checklist input")
    private Checklist elements;

    @FindBy(css = "ul.results > li")
    private WebList results;

    public void performActions(MetalsColorsData data) {
        this.setSummary(data.getSummary());
        this.setElements(data.getElements());
        this.setColor(data.getColor());
        this.setMetal(data.getMetals());
        this.setVegetables(data.getVegetables());
        submitBtn.click();
    }

    private void setColor(String color) {
        colors.select(color);
    }

    private void setMetal(String metal) {
        metals.select(metal);
    }

    private void setVegetables(List<String> newVegetables) {
        vegetables.select("Vegetables");
        for (String vegetable : newVegetables) {
            vegetables.select(vegetable);
        }
    }

    private void setSummary(List<String> values) {
        for (String value : values) {
            int intValue = Integer.valueOf(value);
            if (intValue % 2 == 1) {
                setValue(value, oddRow);
            } else {
                setValue(value, evenRow);
            }
        }
    }

    private void setValue(String value, WebElement row) {
        List<WebElement> list = row.findElements(By.cssSelector("p.radio"));
        for (WebElement element : list) {
            if (element.getText().equals(value)) {
                element.click();
            }
        }
    }

    private void setElements(List<String> newElements) {
        for (String element : newElements) {
            elements.select(element);
        }
    }

    public void assertResults(MetalsColorsData expected) {
        String summaryResult = "";
        List<String> elementsResult = null;
        String colorResult = "";
        String metalResult = "";
        List<String> vegetablesResult = null;

        for (WebElement element : results) {
            String string = element.getText();
            String[] part = string.split(": |, ");
            if (part[0].equals("Summary")) {
                summaryResult = part[1];
            } else if (part[0].equals("Color")) {
                colorResult = part[1];
            } else if (part[0].equals("Metal")) {
                metalResult = part[1];
            } else if (part[0].equals("Elements")) {
                elementsResult = Arrays.asList(Arrays.copyOfRange(part, 1, part.length));
            } else {
                vegetablesResult = Arrays.asList(Arrays.copyOfRange(part, 1, part.length));
            }
        }

        String expectedSummary = Integer.valueOf(expected.getSummary()
                .get(0)) + Integer.valueOf(expected.getSummary().get(1)) + "";
        assertTrue(summaryResult.equals(expectedSummary));
        assertTrue(elementsResult.containsAll(expected
                .getElements()) && expected.getElements().containsAll(elementsResult));
        assertTrue(colorResult.equals(expected.getColor()));
        assertTrue(metalResult.equals(expected.getMetals()));
        assertTrue(vegetablesResult.containsAll(expected
                .getVegetables()) && expected.getVegetables().containsAll(vegetablesResult));
    }

}
