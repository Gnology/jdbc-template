package com.gnology.spring.dataaccess;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Collections;
import java.util.List;
import java.util.Map;


public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("app-config.xml");
        ProductsRepository productsRepository = context.getBean("productsRepository", ProductsRepository.class);
        OfficesRepository officesRepository = context.getBean("officesRepository", OfficesRepository.class);
        EmployeesRepository employeesRepository = context.getBean("employeesRepository", EmployeesRepository.class);

        List<String> productLines = Collections.singletonList("Motorcycles");
        List<Map<String, Object>> productsWithProductLine = productsRepository.getProductsWithProductLine(productLines);

        for (Map<String, Object> product : productsWithProductLine) {
            System.out.println(product);
        }

        List<String> officeCode = Collections.singletonList("3");
        List<Map<String, Object>> employeesWithOfficeCode = employeesRepository.getEmployeesWithOfficeCode(officeCode);
        for (Map<String, Object> employees : employeesWithOfficeCode) {
            System.out.println(employees);
        }

    }
}
