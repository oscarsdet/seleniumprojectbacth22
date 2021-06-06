package com.cybertek.tests.day6_testing_intro_dropdowns;

import org.testng.Assert;
import org.testng.annotations.*;

public class TestNG_Intro {



    @Test (priority = 1)
    public void test1(){
        System.out.println("Running test 1...");

        String actual = "apple";
        String expected = "apples";

        Assert.assertEquals(actual,expected);


    }

    @Test (priority = 2)
    public void test2(){
        System.out.println("Running test 2...");
        String actual = "apple";
        String expected = "apples";

        Assert.assertTrue(actual.equals(expected));
        //Assert.assertFalse(false);

    }

    @BeforeClass
    public void setupClass(){
        System.out.println("-----> Before CLASS is running...");
    }

    @AfterClass
    public void tearDownClass(){
        System.out.println("-----> After CLASS is running...");
    }

    @BeforeMethod
    public void setupMethod(){
        System.out.println("---> Before method is running...");
    }

    @AfterMethod
    public void teardownMethod(){
        System.out.println("---> After method is running...");
    }


}