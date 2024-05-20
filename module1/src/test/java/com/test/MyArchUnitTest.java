package com.test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.jupiter.api.Test;

class MyArchUnitTest {
    private JavaClasses classesToCheck = new ClassFileImporter()
      .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
      .importPackages("com.test");

  @Test
  void module1SouldBeStandalone() {
    ArchRule rule = classes()
      .that()
      .resideInAPackage("com.test.module1..")
      .should()
      .onlyAccessClassesThat()
      .resideInAnyPackage("java..", "com.test.module1..");

    rule.check(classesToCheck);
  }

  @Test
  void module2SouldBeStandalone() {
    ArchRule rule = classes()
      .that()
      .resideInAnyPackage("com.test.module2..")
      .should()
      .onlyAccessClassesThat()
      .resideInAnyPackage("java..", "com.test.module2..");

    rule.check(classesToCheck);
  }
}
