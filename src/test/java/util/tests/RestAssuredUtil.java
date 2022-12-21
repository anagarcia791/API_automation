package util.tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import model.BankUserModel;

import static io.restassured.RestAssured.given;

/**
 * Base class for manage RestAssured.
 *
 * @author am.garcia
 */
public class RestAssuredUtil {
    /**
     * Set base URI for specification.
     *
     * @param baseUri : base uri - endpoint
     */
    public static void setBaseURI(String baseUri) {
        RestAssured.baseURI = baseUri;
    }

    /**
     * Reset base URI.
     */
    public static void resetBaseURI() {
        RestAssured.baseURI = null;
    }

    /**
     * Set base path for specification.
     *
     * @param basePath : path
     */
    public static void setBasePath(String basePath) {
        RestAssured.basePath = basePath;
    }

    /**
     * Reset base path.
     */
    public static void resetBasePath() {
        RestAssured.basePath = null;
    }

    /**
     * Get response given specifications.
     *
     * @return : response given conditions
     */
    public static Response getResponse() {
        return given().get();
    }

    /**
     * Get response for specific id given specifications.
     *
     * @param path : path
     * @return : response given conditions
     */
    public static Response getResponse(String path) {
        return given().get(path);
    }

    /**
     * Delete response given specifications.
     *
     * @param path : path
     * @return : response given conditions
     */
    public static Response deleteResponse(String path) {
        return given().delete(path);
    }

    /**
     * Post response given specifications.
     *
     * @param newUserBank : object to sent
     * @return : response given conditions
     */
    public static Response postResponse(BankUserModel newUserBank) {
        return given().contentType("application/json").body(newUserBank).post();
    }

    /**
     * Put response given specifications.
     *
     * @param userUpdated : object to sent
     * @param path        : user id to update
     * @return : response given conditions
     */
    public static Response putResponse(BankUserModel userUpdated, String path) {
        return given().contentType("application/json").body(userUpdated).put(path);
    }

}
