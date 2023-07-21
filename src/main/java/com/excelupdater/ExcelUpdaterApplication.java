package com.excelupdater;

import com.excelupdater.repository.SubstanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExcelUpdaterApplication{

    public static void main(String[] args) {
        SpringApplication.run(ExcelUpdaterApplication.class, args);
    }

    @Autowired
    private SubstanceRepository substanceRepository;

}
