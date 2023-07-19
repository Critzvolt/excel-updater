package com.excelupdater;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.List;

@RestController
public class Controller {

    @GetMapping("/")
    public List<Substance> ReturnList() throws URISyntaxException {
        URL res = getClass().getClassLoader().getResource("annex_vi_clp_table_atp18_en.xlsx");
        File file = Paths.get(res.toURI()).toFile();
        String absolutePath = file.getAbsolutePath();

        return XlsxReader.getFileContents(absolutePath);
    }
}