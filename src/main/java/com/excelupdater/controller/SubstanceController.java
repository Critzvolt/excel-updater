package com.excelupdater.controller;

import com.excelupdater.service.SubstanceService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class SubstanceController {

    private SubstanceService substanceService;

    public SubstanceController(SubstanceService substanceService) {
        super();
        this.substanceService = substanceService;
    }

    @GetMapping("/")
    //public List<Substance> ReturnList() throws URISyntaxException {
    public String listSubstances(Model model) {
        /*URL res = getClass().getClassLoader().getResource("annex_vi_clp_table_atp18_en.xlsx");
        File file = Paths.get(res.toURI()).toFile();
        String absolutePath = file.getAbsolutePath();

        return XlsxReader.getFileContents(absolutePath);*/

        model.addAttribute("substances", substanceService.getAllSubstances());
        return "substances";
    }
}