package com.cybertek.tests.day8_windows_javaFaker;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

public class JavaFakerPractice {
    @Test
    public void test1(){
        Faker faker = new Faker();

        String fullName =  faker.name().fullName();

        System.out.println("fullName = " + fullName);

        String firsName = faker.name().firstName();

        System.out.println("firstName = " + firsName);

        String chuckNorris = faker.chuckNorris().fact();
        System.out.println("chuckNorris = " + chuckNorris);
    }
}
