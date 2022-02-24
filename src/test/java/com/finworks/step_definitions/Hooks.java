package com.finworks.step_definitions;

import com.finworks.utilities.ConfigurationReader;
import com.finworks.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.time.Duration;

/**
 * @author ybilgin
 * @project FinworksErp
 */


public class Hooks {

    @Before
    public void setUp(){
        Driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        Driver.get().get(ConfigurationReader.get("url"));
        Driver.get().manage().window().maximize();
    }

    @After
    public void tearDown(Scenario scenario){
        if(scenario.isFailed()){
            final byte[] screenshot = ((TakesScreenshot) Driver.get()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png","screenshot");
        }

        Driver.closeDriver();

    }
}
