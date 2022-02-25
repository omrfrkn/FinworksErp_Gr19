package com.finworks.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

/**
 * @author ybilgin
 * @project FinworksErp
 */


@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty",
                "json:target/cucumber.json",
                "html:target/default-html-reports"
        },
        features = "src/test/resources/features",
        glue = "com/finworks/step_definitions",
        dryRun = false,
        tags = "@smoke"
)
public class CukesRunner {
}
