package com.jfpay.core.support.schema;

import com.jfpay.core.setting.MethodReflectInfo;
import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

public class testHandler extends NamespaceHandlerSupport {
    @Override
    public void init() {
        registerBeanDefinitionParser("testxsd",new testParse(MethodReflectInfo.class,true));
    }
}
