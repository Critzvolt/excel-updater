package com.excelupdater.controller;

import com.excelupdater.entity.FileData;
import com.excelupdater.entity.Substance;
import com.excelupdater.service.SubstanceService;
import com.excelupdater.service.SubstanceServiceImpl;
import com.excelupdater.service.XlsxReader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

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

    @GetMapping("/upload")
    public String showUploadForm() {return "uploadForm";}

    @PostMapping("/upload")
    public String handleFileUpload(@RequestParam("file") MultipartFile file, Model model) {
        //FileData fileData = new FileData();

        try {
            //InputStream inputStream = new BufferedInputStream(file.getInputStream());
            List<Substance> listToSave = XlsxReader.getFileContents(file.getInputStream());
            substanceService.saveSubstance(listToSave.get(1));

            /*Iterator<Substance> it = listToSave.iterator();
            while (it.hasNext()) { substanceService.saveSubstance(it.next()); }*/

            return "redirect:/substances";
            //String content = new String(file.getBytes());
            //fileData.setContent(content);
        } catch (IOException e) {
            e.printStackTrace();
            return "redirect:/substances";
        }
    }
}