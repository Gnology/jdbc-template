package com.gnology.spring.dataaccess;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Map;


public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("app-config.xml");
        ProductsRepository productsRepository = context.getBean("productsRepository", ProductsRepository.class);
        OfficesRepository officesRepository = context.getBean("officesRepository", OfficesRepository.class);
        EmployeesRepository employeesRepository = context.getBean("employeesRepository", EmployeesRepository.class);

        List<Map<String, Object>> productsWithPriceRange = productsRepository.getProductsWithPriceRange(50.0, 60.0);
        for (Map<String, Object> product : productsWithPriceRange) {
            System.out.println(product);
        }
    }
}
