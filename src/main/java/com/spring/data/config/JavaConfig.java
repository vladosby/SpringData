package com.spring.data.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by vlados on 9/5/2016.
 */

@Configuration
@Import(PostgreJavaConfig.class)
public class JavaConfig {

}
