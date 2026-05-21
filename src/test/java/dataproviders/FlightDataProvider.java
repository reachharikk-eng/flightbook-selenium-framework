package dataproviders;

import org.testng.annotations.DataProvider;

public class FlightDataProvider {

    @DataProvider(name = "flightSearchData")
    public Object[][] getFlightSearchData() {

        return new Object[][]{

                {"Boston", "London"},

                {"Paris", "Berlin"},

                {"Mexico City", "Rome"}
        };
    }
}
