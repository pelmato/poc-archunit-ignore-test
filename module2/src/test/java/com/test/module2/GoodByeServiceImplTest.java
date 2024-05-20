package com.test.module2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

class GoodByeServiceImplTest {

  protected Faker faker = new Faker();

  @Test
  void checkTestResult() {
    GoodByeService service = new GoodByeServiceImpl();
    String name = faker.ancient().hero();

    String result = service.sayGoodBye(name);

    assertEquals("good bye " + name, result);
  }

}
