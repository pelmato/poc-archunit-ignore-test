package com.test.module2;

public class GoodByeServiceImpl implements GoodByeService {

  @Override
  public String sayGoodBye(String name) {
    return "good bye " + name;
  }

}
