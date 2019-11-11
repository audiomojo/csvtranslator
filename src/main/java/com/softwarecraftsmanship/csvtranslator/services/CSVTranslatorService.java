package com.softwarecraftsmanship.csvtranslator.services;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CSVTranslatorService {
    public String translate(List<String> parsedCSV) {
        StringBuilder builder = new StringBuilder();
        parsedCSV.forEach(element -> builder.append("["+ element +"] "));
        String result = builder.toString();
        return result.substring(0,result.length()-1);
    }
}
