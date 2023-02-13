package starter.Reqres;

import java.io.File;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.Utils.Constant;

public class ReqresAPI {
    public static String GET_LIST_USERS = Constant.BASE_URL+"/api/users?page={page}";
    public static String POST_CREATE_USER = Constant.BASE_URL+"/api/users";
    public static String PUT_UPDATE_USER = Constant.BASE_URL+"/api/users/{id}";
    public static String DELETE_USER = Constant.BASE_URL+"/api/users/{id}";
    public static String GET_SINGLE_USER = Constant.BASE_URL+"/api/users/{id}";
    public static String REGISTER_USER = Constant.BASE_URL+"/api/register";
    public static String PUT_UPDATE_USER_WITHOUT_PARAMETER = Constant.BASE_URL+"/api/users";
    public static String DELETE_USER_INVALID_PARAMETER = Constant.BASE_URL+"/api/users/{id}";
    public static String DELETE_USER_WITHOUT_PARAMETER = Constant.BASE_URL+"/api/users";


    //Step Scenario 1
    @Step("Get list users")
    public void getListUsers(int page){
        SerenityRest.given()
                .pathParam("page", page);
    }

    //Step Scenario 2
    @Step("Post create new user")
    public void createNewUser(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    //Step Scenario 3
    @Step("Put update user")
    public void putUpdateUser(int id, File json){
        SerenityRest.given()
                .pathParam("id", id)
                .contentType(ContentType.JSON)
                .body(json);
    }

    //Step Scenario 4
    @Step("Delete user")
    public void deleteUser(int id){
        SerenityRest.given()
                .pathParam("id", id);
    }

    //Get single user
    @Step("Get single user")
    public void getSingleUser(int id){
        SerenityRest.given()
                .pathParam("id",id);
    }

    //Post Register user
    @Step("Register new user")
    public void registerNewUser(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    //Update user invalid parameter
    @Step("Put update user with invalid parameter")
    public void putUpdateUserInvalidParameter(String id, File json){
        SerenityRest.given()
                .pathParam("id", id)
                .contentType(ContentType.JSON)
                .body(json);
    }

    //Update user without parameter
    @Step("Put update user with without parameter")
    public void updateUserWithoutParameter(){
        SerenityRest.given();
    }

    //Delete user with invalid parameter
    @Step("Delete user with invalid parameter")
    public void deleteUserInvalidParameter(String id) {
        SerenityRest.given()
                .pathParam("id", id);
    }

    //Delete user without paramater id
    @Step("Delete user with invalid parameter")
    public void deleteUserWithoutParameter() {
        SerenityRest.given();
    }


}
