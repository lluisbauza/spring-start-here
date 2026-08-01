package com.lluisbauza.main;

import com.lluisbauza.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    static void main() {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        context.close();
    }
}
