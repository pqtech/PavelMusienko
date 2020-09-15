package core;

import org.testng.annotations.DataProvider;

public class DataProvidersForTrelloBoard {

    @DataProvider
    public Object[] boardNamesProvider() {
        return new Object[]{
                "My Board Name",
                "Board Name with digits: 1, 2, 30, 500",
                "UPPER CASE BOARD NAME"
        };
    }

    @DataProvider
    public Object[] boardDescriptionsProvider() {
        return new Object[]{
                "My Board Description",
                "Board Description with digits: 1, 2, 30, 500",
                "UPPER CASE BOARD DESCRIPTION"
        };
    }

}
