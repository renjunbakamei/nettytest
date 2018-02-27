package com.jfpay.core.support.schema;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.beans.factory.xml.BeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;

public class testParse implements BeanDefinitionParser {

    private static final Logger logger = LoggerFactory.getLogger(BeanDefinitionParser.class);

    private final Class<?> beanClass;

    private final boolean required;

    public testParse(Class<?> beanClass,boolean required){
        this.beanClass=beanClass;
        this.required=required;
    }

    public BeanDefinition parse(Element element, ParserContext parserContext, Class<?> beanClass, boolean required) {
        RootBeanDefinition beanDefinition = new RootBeanDefinition();
        beanDefinition.setBeanClass(beanClass);
        beanDefinition.setLazyInit(false);
        String name=element.getAttribute("className");
        beanDefinition.getPropertyValues().addPropertyValue("className",name);
        String method=element.getAttribute("methodName");
        beanDefinition.getPropertyValues().addPropertyValue("className",method);
        return beanDefinition;
    }

    @Override
    public BeanDefinition parse(Element element, ParserContext parserContext) {
        return null;
    }
}
