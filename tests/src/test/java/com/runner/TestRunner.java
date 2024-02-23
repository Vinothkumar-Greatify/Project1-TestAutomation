package com.runner;

import java.io.*;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.base.BaseClass;
import com.pages.EmailReport;
import org.junit.jupiter.api.Test;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(tags = "@SchoolOnboard or @TimetableConfiguration or @FeeManage", stepNotifications = true, dryRun = (false), monochrome = true, snippets = SnippetType.CAMELCASE, plugin = {
		"pretty", "html:target//output.html",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" }, features = "src/test/resources", glue = "com.stepdefinition")


public class TestRunner extends BaseClass{
	@AfterClass
	@Test
	public static void afterClass() throws FileNotFoundException, IOException {

		EmailReport.main(null);
		System.clearProperty("javax.net.debug");
		
		closeAllWind();
	}

}

/*
 * Allure Report Plugin: io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm Extent
 * Report Plugin:
 * com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter: Extent
 * Report Plugin:
 * com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.
 * html target/cucumber-reports/report.html
 * 
 */