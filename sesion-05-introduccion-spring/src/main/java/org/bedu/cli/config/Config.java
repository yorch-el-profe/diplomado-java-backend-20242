package org.bedu.cli.config;

import java.util.Scanner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    
    // Los Beans son objetos reutilizables, similares a los componentes
    @Bean
    public Scanner createScanner() {
        return new Scanner(System.in);
    }
}
