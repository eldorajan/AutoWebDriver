package com.framework.qa.pageobjects;

import java.util.List;

import org.openqa.selenium.support.FindBy;

import com.framework.qa.webelement.CheckBox;
import com.framework.qa.webelement.HyperLink;

/**
 * @author eldo_rajan
 */
public class SearchPage extends BasePage {

    @FindBy(name = "q")
    public CheckBox searchElement;

    @FindBy(xpath = "//a/h3")
    public List<HyperLink> searchResults;

}
