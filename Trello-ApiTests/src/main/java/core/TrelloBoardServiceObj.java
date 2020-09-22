package core;

import beans.TrelloBoardCreationAnswer;
import beans.TrelloBoardsAnswer;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TrelloBoardServiceObj {

    public static final URI TRELLO_BOARDS_URI = URI.create("https://api.trello.com/1/members/me/boards");
    public static final URI TRELLO_ACTIONS_URI = URI.create("https://api.trello.com/1/boards/");
    public static final String API_KEY = "9427dd11c3d6809e0eec61df852525c9";
    public static final String API_TOKEN = "37f3abb63045e23da3158786cf841256c2473b758a76ed00b5f0dff264e1793a";
    private static long requestNumber = 0L;

    private Map<String, String> parameters;

    private TrelloBoardServiceObj(Map<String, String> parameters) {
        this.parameters = parameters;
    }

    public static ApiRequestBuilder requestBuilder() {
        return new ApiRequestBuilder();
    }

    public static class ApiRequestBuilder {
        private Map<String, String> parameters = new HashMap<>();

        public ApiRequestBuilder setApiKey() {
            parameters.put("key", API_KEY);
            return this;
        }

        public ApiRequestBuilder setApiToken() {
            parameters.put("token", API_TOKEN);
            return this;
        }

        public ApiRequestBuilder setBoardName(String boardName) {
            parameters.put("name", boardName);
            return this;
        }

        public ApiRequestBuilder setBoardClosedStatus(String boardStarStatus) {
            parameters.put("closed", boardStarStatus);
            return this;
        }

        public ApiRequestBuilder setBoardDescription(String boardDescription) {
            parameters.put("desc", boardDescription);
            return this;
        }

        public TrelloBoardServiceObj buildRequest() {
            return new TrelloBoardServiceObj(parameters);
        }
    }

    public Response sendGetRequest() {
        return RestAssured
                .given(requestSpecification()).log().all()
                .queryParams(parameters)
                .request(Method.GET , TRELLO_BOARDS_URI)
                .prettyPeek();
    }

    public Response sendPostRequest() {
        return RestAssured
                .given(requestSpecification()).log().all()
                .queryParams(parameters)
                .request(Method.POST , TRELLO_ACTIONS_URI)
                .prettyPeek();
    }

    public Response sendDeleteRequest(String brdId) {
        return RestAssured
                .given(requestSpecification()).log().all()
                .queryParams(parameters)
                .request(Method.DELETE , TRELLO_ACTIONS_URI +brdId)
                .prettyPeek();
    }

    public Response sendUpdateRequest(String brdId) {
        return RestAssured
                .given(requestSpecification()).log().all()
                .queryParams(parameters)
                .request(Method.PUT , TRELLO_ACTIONS_URI +brdId)
                .prettyPeek();
    }

    public static List<TrelloBoardsAnswer> getAnswers(Response response) {
        List<TrelloBoardsAnswer> answers = new Gson()
                .fromJson(response.asString().trim(), new TypeToken<List<TrelloBoardsAnswer>>() {
                }.getType());
        return answers;
    }

    public static List<String> getStringResult(Response response) {
        return getAnswers(response).stream().map(trelloBoardsAnswer -> trelloBoardsAnswer.getName()).collect(Collectors.toList());
    }

    public static TrelloBoardCreationAnswer getBoardActionResult(Response response) {
        TrelloBoardCreationAnswer answers = new Gson()
                .fromJson(response.asString().trim(), new TypeToken<TrelloBoardCreationAnswer>() {
                }.getType());
        return answers;
    }

    public static String getBoardDeletionResult(Response response) {
        return response.asString();
    }

    public static RequestSpecification requestSpecification() {
        return new RequestSpecBuilder()
                .addHeader("Content-Type", "application/json")
                .setBaseUri(TRELLO_ACTIONS_URI)
                .build();
    }
}
