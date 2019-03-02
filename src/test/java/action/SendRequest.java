package action;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import java.util.logging.Logger;

@RunWith(Cucumber.class)
@CucumberOptions(format = {"pretty", "json:report/report.json"},
        tags = {"@test"},
        features = { "src/test/resources/" }
)

public class SendRequest {
    private static final Logger LOGGER = Logger.getLogger(SendRequest.class.getName());
    @BeforeClass
    public static void start(){
        LOGGER.fine("Test start...");
    }

}
