package com.jfpay.Annotation;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface OtherName {

    public String targetClass() default "";

    public String name() default "";

    public boolean encrypt() default false;//0代表不加密，1代表加密

}
