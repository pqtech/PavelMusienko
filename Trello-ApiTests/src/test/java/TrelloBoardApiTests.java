import beans.TrelloBoardCreationAnswer;
import beans.TrelloBoardDeletionAnswer;
import core.DataProvidersForTrelloBoard;
import io.restassured.http.Method;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.util.List;

import static core.TrelloBoardServiceObj.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class TrelloBoardApiTests {

    public static String boardId = null;
    public static String boardFirstName = "My New Board Name";

    @AfterClass
    public void tearDown() {
        if (boardId != null) {
            TrelloBoardDeletionAnswer deletionResult = getBoardDeletionResult(
                    requestBuilder()
                            .setApiKey()
                            .setApiToken()
                            .setMethod(Method.DELETE)
                            .buildRequest()
                            .sendDeleteRequest(boardId));
            assertThat("Deletion result is not correct!", deletionResult.getValue() == null);
        }
    }

    @Test(priority = 0)
    public void checkBoardListIsEmpty() {
        List<String> result = getStringResult2(
                requestBuilder()
                        .setApiKey()
                        .setApiToken()
                        .buildRequest()
                        .sendGetRequest2());
        assertThat("Boards list is not empty: " + result, result.isEmpty());
    }

    @Test(priority = 1)
    public void checkBoardCreation() {
        TrelloBoardCreationAnswer result = getBoardActionResult(
                requestBuilder()
                        .setBoardName(boardFirstName)
                        .setApiKey()
                        .setApiToken()
                        .setMethod(Method.POST)
                        .buildRequest()
                        .sendPostRequest());
        System.out.println("Result: " + result.getName());
        boardId = result.getId();
        assertThat("Created board is not correct!",
                result.getName().equals(boardFirstName));
    }

    @Test(priority = 2, dataProvider = "boardDescriptionsProvider",
            dataProviderClass = DataProvidersForTrelloBoard.class)
    public void checkBoardDescriptionUpdate(String description) {
        TrelloBoardCreationAnswer result = getBoardActionResult(
                requestBuilder()
                        .setBoardDescription(description)
                        .setApiKey()
                        .setApiToken()
                        .setMethod(Method.PUT)
                        .buildRequest()
                        .sendUpdateRequest(boardId));
        assertThat("Board description is not correct!",
                result.getDesc().equals(description));
    }

    @Test(priority = 3, dataProvider = "boardNamesProvider",
            dataProviderClass = DataProvidersForTrelloBoard.class)
    public void checkBoardNameUpdate(String name) {
        TrelloBoardCreationAnswer result = getBoardActionResult(
                requestBuilder()
                        .setBoardName(name)
                        .setApiKey()
                        .setApiToken()
                        .setMethod(Method.PUT)
                        .buildRequest()
                        .sendUpdateRequest(boardId));
        assertThat("Board name is not correct!",
                result.getName().equals(name));
    }

    @Test(priority = 4)
    public void checkBoardClosedSet() {
        TrelloBoardCreationAnswer result = getBoardActionResult(
                requestBuilder()
                        .setBoardClosedStatus("true")
                        .setApiKey()
                        .setApiToken()
                        .setMethod(Method.PUT)
                        .buildRequest()
                        .sendUpdateRequest(boardId));
        assertThat("Board Closed Status is not correct!",
                result.getClosed().equals(true));
    }

    @Test(priority = 5)
    public void checkBoardClosedUnset() {
        TrelloBoardCreationAnswer result = getBoardActionResult(
                requestBuilder()
                        .setBoardClosedStatus("false")
                        .setApiKey()
                        .setApiToken()
                        .setMethod(Method.PUT)
                        .buildRequest()
                        .sendUpdateRequest(boardId));
        assertThat("Board Closed Status is not correct!",
                result.getClosed().equals(false));
    }
}