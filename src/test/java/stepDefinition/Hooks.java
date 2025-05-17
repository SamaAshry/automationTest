package stepDefinition;

import Utilities.InitializeDriver;
import io.cucumber.java.*;

public class Hooks {

    @Before
    public static void setup() throws Exception {

        System.out.println("Initializing driver...");
        InitializeDriver.initializeDriver();
        System.out.println("Driver initialized.");
    }


    @After
    public static void tearDown(Scenario scenario) {
        InitializeDriver.quitDriver();
    }

}