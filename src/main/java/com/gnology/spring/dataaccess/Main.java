package com.gnology.spring.dataaccess;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);
        ProductsRepository productsRepository = context.getBean("productsRepository", ProductsRepository.class);
        System.out.println( productsRepository.getNumberOfProducts());

    }
}
