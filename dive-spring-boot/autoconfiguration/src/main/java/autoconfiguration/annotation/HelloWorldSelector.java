package autoconfiguration.annotation;

import autoconfiguration.configuration.HelloWorldConfiguration;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class HelloWorldSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        System.out.println(importingClassMetadata.toString());
        return new String[]{HelloWorldConfiguration.class.getName()};
    }
}
