package core;

import beans.TrelloBoardCreationAnswer;
import beans.TrelloBoardDeletionAnswer;
import beans.TrelloBoardsAnswer;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TrelloBoardServiceObj {

    public static final URI SPELLER_URI = URI.create("https://speller.yandex.net/services/spellservice.json/checkText");
    public static final URI TRELLO_URI = URI.create("https://api.trello.com/1/members/me/boards");
    public static final URI TRELLO_URI2 = URI.create("https://api.trello.com/1/boards/");
    public static final String API_KEY = "9427dd11c3d6809e0eec61df852525c9";
    public static final String API_TOKEN = "37f3abb63045e23da3158786cf841256c2473b758a76ed00b5f0dff264e1793a";
    private static long requestNumber = 0L;
    private Method requestMethod;

    private Map<String, String> parameters;

    private TrelloBoardServiceObj(Map<String, String> parameters, Method method) {
        this.parameters = parameters;
        this.requestMethod = method;
    }

    public static ApiRequestBuilder requestBuilder() {
        return new ApiRequestBuilder();
    }

    public static class ApiRequestBuilder {
        private Map<String, String> parameters = new HashMap<>();
        private Method requestMethod = Method.GET;

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

        public ApiRequestBuilder setMethod(Method method){
            requestMethod = method;
            return this;
        }

        public TrelloBoardServiceObj buildRequest() {
            return new TrelloBoardServiceObj(parameters, requestMethod);
        }
    }

    public Response sendGetRequest2() {
        return RestAssured
                .given(requestSpecification()).log().all()
                .queryParams(parameters)
                .request(requestMethod ,TRELLO_URI)
                .prettyPeek();
    }

    public Response sendPostRequest() {
        return RestAssured
                .given(requestSpecification2()).log().all()
                .queryParams(parameters)
                .request(requestMethod ,TRELLO_URI2)
                .prettyPeek();
    }

    public Response sendDeleteRequest(String brdId) {
        return RestAssured
                .given(requestSpecification2()).log().all()
                .queryParams(parameters)
                .request(requestMethod ,TRELLO_URI2+brdId)
                .prettyPeek();
    }

    public Response sendUpdateRequest(String brdId) {
        return RestAssured
                .given(requestSpecification2()).log().all()
                .queryParams(parameters)
                .request(requestMethod ,TRELLO_URI2+brdId)
                .prettyPeek();
    }

    public static List<TrelloBoardsAnswer> getAnswers2(Response response) {
        List<TrelloBoardsAnswer> answers = new Gson()
                .fromJson(response.asString().trim(), new TypeToken<List<TrelloBoardsAnswer>>() {
                }.getType());
        return answers;
    }

    public static List<String> getStringResult2(Response response) {
        return getAnswers2(response).stream().map(trelloBoardsAnswer -> trelloBoardsAnswer.getName()).collect(Collectors.toList());
    }


    public static TrelloBoardCreationAnswer getBoardActionResult(Response response) {
        TrelloBoardCreationAnswer answers = new Gson()
                .fromJson(response.asString().trim(), new TypeToken<TrelloBoardCreationAnswer>() {
                }.getType());
        return answers;
    }

    public static TrelloBoardDeletionAnswer getBoardDeletionResult(Response response) {
        TrelloBoardDeletionAnswer answers = new Gson()
                .fromJson(response.asString().trim(), new TypeToken<TrelloBoardDeletionAnswer>() {
                }.getType());
        return answers;
    }

    public static RequestSpecification requestSpecification() {
        return new RequestSpecBuilder()
                .setAccept(ContentType.JSON)
                .setBaseUri(SPELLER_URI)
                .build();
    }

    public static RequestSpecification requestSpecification2() {
        return new RequestSpecBuilder()
                .addHeader("Content-Type", "application/json")
                .setBaseUri(TRELLO_URI2)
                .build();
    }
}
