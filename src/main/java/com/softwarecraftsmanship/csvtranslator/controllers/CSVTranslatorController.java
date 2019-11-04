package com.softwarecraftsmanship.csvtranslator.controllers;

import com.softwarecraftsmanship.csvtranslator.services.CSVTranslatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CSVTranslatorController {

    @Autowired
    CSVTranslatorService csvTranslatorService;

    @RequestMapping("/translate")
    public String translate(@RequestParam (value="csv") String csv){
        return csvTranslatorService.translate(csv);
    }
}
