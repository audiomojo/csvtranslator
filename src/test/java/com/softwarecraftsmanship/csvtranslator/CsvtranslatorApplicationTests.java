package com.softwarecraftsmanship.csvtranslator;

import com.softwarecraftsmanship.csvtranslator.services.CSVTranslatorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.Arrays;
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
        List<List<String>> param = new ArrayList();
        param.add(fillLine("Hello"));

        String expectedResult = "[Hello]";
        String result = csvTranslatorService.translate(param);
        Assert.isTrue(expectedResult.compareTo(result)==0, "Result is: " + result + "; Result should equal " + expectedResult);
    }

    @Test
    public void translatorTest_oneComma() {
        List<List<String>> param = new ArrayList();
        param.add(fillLine("Hello,World"));
        String expectedResult = "[Hello] [World]";
        String result = csvTranslatorService.translate(param);
        Assert.isTrue(expectedResult.compareTo(result)==0, "Result is: " + result + "; Result should equal " + expectedResult);
    }
    @Test
    public void translatorTest_twoCommas() {
        List<List<String>> paramList = new ArrayList();
        List<String> param = fillLine("One,Two,Three");
        paramList.add(param);
        String expectedResult = "[One] [Two] [Three]";
        String result = csvTranslatorService.translate(paramList);
        Assert.isTrue(expectedResult.compareTo(result)==0, "Result is: " + result + "; Result should equal " + expectedResult);
    }

    @Test
    public void translatorTest_twoLinesTwoCommas() {
        List<List<String>> paramList = new ArrayList();
        List<String> row1 = fillLine("One,Two,Three");
        paramList.add(row1);
        List<String> row2 = fillLine("Uno,Dos,Tres");
        paramList.add(row2);
        String expectedResult = "[One] [Two] [Three]\n[Uno] [Dos] [Tres]";
        String result = csvTranslatorService.translate(paramList);
        Assert.isTrue(expectedResult.compareTo(result)==0, "Result is: " + result + "; Result should equal " + expectedResult);
    }
    private List<String> fillLine(String line) {
        String[] words = line.split(",");
        return Arrays.asList(words);
    }
}
