package stepDefinitions;

import java.io.IOException;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import testBase.DriverSetup;



public class Hooks extends DriverSetup{

    @Before
    public void setUp() throws IOException {
        DriverSetup.initialize();
    }

    @After
    public void tearDown() {
        DriverSetup.quit();
    }
    

}
