package com.acme.elegant;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(Cucumber.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
@CucumberContextConfiguration
//@SpringBootTest(classes= ElegantApplicationTests.class)
@CucumberOptions(features="src/test")
public class prueba {
}
