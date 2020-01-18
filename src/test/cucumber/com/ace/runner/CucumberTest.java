package com.ace.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/cucumber/com/ace/frature/behavior.feature")
public class CucumberTest {
	
}
