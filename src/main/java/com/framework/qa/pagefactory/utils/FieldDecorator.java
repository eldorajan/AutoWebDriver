package com.framework.qa.pagefactory.utils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Locatable;
import org.openqa.selenium.WrapsElement;
import org.openqa.selenium.support.pagefactory.DefaultFieldDecorator;
import org.openqa.selenium.support.pagefactory.ElementLocator;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

import com.framework.qa.webelement.BaseElement;
import com.framework.qa.webelement.Button;
import com.framework.qa.webelement.CheckBox;
import com.framework.qa.webelement.HyperLink;
import com.framework.qa.webelement.RadioButton;
import com.framework.qa.webelement.SelectList;
import com.framework.qa.webelement.TextArea;
import com.framework.qa.webelement.TextBox;
import com.framework.qa.webelement.proxy.BaseElementListProxyHandler;
import com.framework.qa.webelement.proxy.BaseElementProxyHandler;

/**
 * @author eldo_rajan
 */
public class FieldDecorator extends DefaultFieldDecorator {

    public FieldDecorator(ElementLocatorFactory factory) {
        super(factory);
    }

    @SuppressWarnings("unchecked")
    public static <T extends WebElement> T createBaseElementProxy(ClassLoader loader, InvocationHandler handler) {
        Class<?>[] interfaces = new Class[]{WebElement.class, WrapsElement.class, Locatable.class};
        return (T) Proxy.newProxyInstance(loader, interfaces, handler);
    }

    @SuppressWarnings("unchecked")
    public static <T extends BaseElement> List<T> createBaseElementListProxy(ClassLoader loader,
                                                                             InvocationHandler handler) {
        return (List<T>) Proxy.newProxyInstance(loader, new Class[]{List.class}, handler);
    }

    @Override
    public Object decorate(ClassLoader loader, Field field) {
        if (field.getType().isAssignableFrom(BaseElement.class)) {
            return decorateBaseElement(loader, field);
        } else if (field.getType().isAssignableFrom(Button.class)) {
            return decorateButtonElement(loader, field);
        } else if (field.getType().isAssignableFrom(CheckBox.class)) {
            return decorateCheckBoxElement(loader, field);
        } else if (field.getType().isAssignableFrom(HyperLink.class)) {
            return decorateHyperLinkElement(loader, field);
        } else if (field.getType().isAssignableFrom(RadioButton.class)) {
            return decorateRadioButtonElement(loader, field);
        } else if (field.getType().isAssignableFrom(SelectList.class)) {
            return decorateSelectListElement(loader, field);
        } else if (field.getType().isAssignableFrom(TextArea.class)) {
            return decorateTextAreaElement(loader, field);
        } else if (field.getType().isAssignableFrom(TextBox.class)) {
            return decorateTextBoxElement(loader, field);
        } else if (field.getType().isAssignableFrom(List.class)) {
            return decorateBaseElementList(loader, field);
        }

        /*
         * ElementLocator createLocator = this.factory.createLocator(field);
         * if(field.getType().isAssignableFrom(BaseElement.class)){ WebElement
         * proxyForLocator = super.proxyForLocator(loader, createLocator); return new
         * BaseElement(proxyForLocator); }else
         * if(field.getType().isAssignableFrom(List.class)){ List<WebElement>
         * proxyForListLocator = proxyForListLocator(loader, createLocator);
         * if(proxyForListLocator!=null && proxyForListLocator.size()>0){
         * List<BaseElement> BaseElementList = new ArrayList<BaseElement>();
         * for(WebElement e : proxyForListLocator){ BaseElementList.add(new
         * BaseElement(e)); } return BaseElementList; } }
         */
        return null;
    }

    protected BaseElement decorateBaseElement(ClassLoader loader, Field field) {
        ElementLocator locator = factory.createLocator(field);
        InvocationHandler handler = new BaseElementProxyHandler(locator);

        return new BaseElement(createBaseElementProxy(loader, handler));
    }

    protected List<BaseElement> decorateBaseElementList(ClassLoader loader, Field field) {
        ElementLocator locator = factory.createLocator(field);
        InvocationHandler handler = new BaseElementListProxyHandler(locator);

        return createBaseElementListProxy(loader, handler);
    }

    protected Button decorateButtonElement(ClassLoader loader, Field field) {
        ElementLocator locator = factory.createLocator(field);
        InvocationHandler handler = new BaseElementProxyHandler(locator);

        return new Button(createBaseElementProxy(loader, handler));
    }

    protected CheckBox decorateCheckBoxElement(ClassLoader loader, Field field) {
        ElementLocator locator = factory.createLocator(field);
        InvocationHandler handler = new BaseElementProxyHandler(locator);

        return new CheckBox(createBaseElementProxy(loader, handler));
    }

    protected HyperLink decorateHyperLinkElement(ClassLoader loader, Field field) {
        ElementLocator locator = factory.createLocator(field);
        InvocationHandler handler = new BaseElementProxyHandler(locator);

        return new HyperLink(createBaseElementProxy(loader, handler));
    }

    protected RadioButton decorateRadioButtonElement(ClassLoader loader, Field field) {
        ElementLocator locator = factory.createLocator(field);
        InvocationHandler handler = new BaseElementProxyHandler(locator);

        return new RadioButton(createBaseElementProxy(loader, handler));
    }

    protected SelectList decorateSelectListElement(ClassLoader loader, Field field) {
        ElementLocator locator = factory.createLocator(field);
        InvocationHandler handler = new BaseElementProxyHandler(locator);

        return new SelectList(createBaseElementProxy(loader, handler));
    }

    protected TextArea decorateTextAreaElement(ClassLoader loader, Field field) {
        ElementLocator locator = factory.createLocator(field);
        InvocationHandler handler = new BaseElementProxyHandler(locator);

        return new TextArea(createBaseElementProxy(loader, handler));
    }

    protected TextBox decorateTextBoxElement(ClassLoader loader, Field field) {
        ElementLocator locator = factory.createLocator(field);
        InvocationHandler handler = new BaseElementProxyHandler(locator);

        return new TextBox(createBaseElementProxy(loader, handler));
    }

    protected List<Button> decorateButtonElementList(ClassLoader loader, Field field) {
        ElementLocator locator = factory.createLocator(field);
        InvocationHandler handler = new BaseElementListProxyHandler(locator);

        return createBaseElementListProxy(loader, handler);
    }
}