package sn.lahi.on.demande.services;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import org.junit.jupiter.api.Test;

class ArchTest {

    @Test
    void servicesAndRepositoriesShouldNotDependOnWebLayer() {
        JavaClasses importedClasses = new ClassFileImporter()
            .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
            .importPackages("sn.lahi.on.demande.services");

        noClasses()
            .that()
            .resideInAnyPackage("sn.lahi.on.demande.services.service..")
            .or()
            .resideInAnyPackage("sn.lahi.on.demande.services.repository..")
            .should()
            .dependOnClassesThat()
            .resideInAnyPackage("..sn.lahi.on.demande.services.web..")
            .because("Services and repositories should not depend on web layer")
            .check(importedClasses);
    }
}
