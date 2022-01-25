package com.cybertek.tests.day10_file_upload;

import org.testng.annotations.Test;

public class FilePathExample {
    @Test
    public void test1() {

        // /Users/jamaldemir/IdeaProjects/fromgit/EU3TestNGSelenium src/test/resources/textfile.txt;
        //C:\Users\HP\IdeaProjects\EU7TestNGSelenium\src\test\resources\textfile.txt     *benimki

      //  System.out.println(System.getProperty("user.dir"));
       // C:\Users\HP\IdeaProjects\EU7TestNGSelenium

      //  System.out.println(System.getProperty("os.name"));
        //windows 10
      //  System.out.println(System.getProperty("user.home"));
        //C:\Users\HP

        String projePath=System.getProperty("user.dir");
        String filePath="src/test/resources/textfile.txt";
        String fullPath=projePath+"/"+filePath;

        System.out.println(fullPath);



    }
}