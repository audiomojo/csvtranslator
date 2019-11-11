package com.softwarecraftsmanship.csvtranslator;

import com.softwarecraftsmanship.csvtranslator.services.CSVTranslatorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class CsvtranslatorApplicationTests {

   @Autowired
   CSVTranslatorService csvTranslatorService;

    @Test
    void contextLoads() {
    }

    @Test
    public void translatorTest_noCommas() {
        List<String> param = new ArrayList();
        param.add("Hello");

        String expectedResult = "[Hello]";
        String result = csvTranslatorService.translate(param);
        Assert.isTrue(expectedResult.compareTo(result)==0, "Result is: " + result + "; Result should equal " + expectedResult);
    }

    @Test
    public void translatorTest_oneComma() {
        List<String> param = new ArrayList();
        param.add("Hello");
        param.add("World");
        String expectedResult = "[Hello] [World]";
        String result = csvTranslatorService.translate(param);
        Assert.isTrue(expectedResult.compareTo(result)==0, "Result is: " + result + "; Result should equal " + expectedResult);
    }
}
