package com.softwarecraftsmanship.csvtranslator;

import com.softwarecraftsmanship.csvtranslator.services.CSVTranslatorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
class CsvtranslatorApplicationTests {

   @Autowired
   CSVTranslatorService csvTranslatorService;

    @Test
    void contextLoads() {
    }

    @Test
    public void test_noCommas() {
        String param = "Hello";
        String expectedResult = "[Hello]";
        String result = csvTranslatorService.translate(param);
        Assert.isTrue(expectedResult.compareTo(result)==0, "result should equal " + param);
    }

//    @Test
//    public void test_oneComma() {
//        String param = "Hello,World";
//        String result = csvTranslatorService.translate(param);
//        Assert.isTrue(param.compareTo(result)==0, "result should equal " + param);
//    }
}
