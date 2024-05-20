package com.test.module1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

class HelloServiceImplTest {

  protected Faker faker = new Faker();

  @Test
  void checkHelloResult() {
    HelloService service = new HelloServiceImpl();
    String name = faker.ancient().hero();

    String result = service.sayHello(name);

    assertEquals("hello " + name, result);
  }

}
