package starter.Reqres;

import com.sun.xml.bind.v2.runtime.reflect.opt.Const;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.eo.Se;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Utils.Constant;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;

public class RegitsterUserStepDef {

    @Steps
    ReqresAPI reqresAPI;

    //Positif
    @Given("Register new user with valid email and valid password")
    public void registerNewUserWithValidJsonInput() {
        File jsonReq = new File(Constant.JSON_REQ_BODY+"RegisterUserReqBody.json");
        reqresAPI.registerNewUser(jsonReq);
    }

    @When("Send request post register user")
    public void sendRequestPostRegisterUser() {
        SerenityRest.when().post(ReqresAPI.REGISTER_USER);
    }

    @And("Validate register user json schema")
    public void validateRegisterUserJsonSchema() {
        File jsonSchemaRegisterUser = new File(Constant.JSON_SCHEMA+"PostRegisterUserJSONSchema.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchemaRegisterUser));
    }


    //Negatif No Password
    @Given("Register new user without password")
    public void registerNewUserWithoutPassword() {
        File jsonReq = new File(Constant.JSON_REQ_BODY+"RegisterUserNoPasswordReqBody.json");
        reqresAPI.registerNewUser(jsonReq);
    }

    @Then("Status code should be {int} Bad Request")
    public void statusCodeShouldBeBadRequest(int badRequest) {
        SerenityRest.then().statusCode(badRequest);
    }

    @And("Respon body error should be {string}")
    public void responBodyErrorShouldBe(String bodyError) {
        SerenityRest.then()
                .body(ReqresResponse.ERROR, equalTo(bodyError));
    }

    @And("Validate register user json schema no password")
    public void validateRegisterUserJsonSchemaNoPassword() {
        File jsonSchemaRegisterUser = new File(Constant.JSON_SCHEMA + "PostRegisterUserNoPasswordJSONSchema.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchemaRegisterUser));
    }

    //Negatif no email
    @Given("Register new user without email")
    public void registerNewUserWithoutEmail() {
        File jsonReq = new File(Constant.JSON_REQ_BODY+"RegisterUserNoEmailReqBody.json");
        reqresAPI.registerNewUser(jsonReq);
    }

    @And("Validate register user json schema no email")
    public void validateRegisterUserJsonSchemaNoEmail() {
        File jsonSchemaRegisterUser = new File(Constant.JSON_SCHEMA + "PostRegisterUserNoEmailJSONSchema.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchemaRegisterUser));
    }


    //Negatif invalid email and password
    @Given("Register new user with invalid email and invalid password")
    public void registerNewUserWithInvalidEmailAndInvalidPassword() {
        File jsonReq = new File(Constant.JSON_REQ_BODY+"RegisterUserInvalidEmailPasswordReqBody.json");
        reqresAPI.registerNewUser(jsonReq);
    }

    @And("Validate register user json schema invalid data")
    public void validateRegisterUserJsonSchemaInvalidData() {
        File jsonSchemaRegisterUser = new File(Constant.JSON_SCHEMA + "PostRegisterUserInvalidEmailPasswordJSONSchema.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchemaRegisterUser));
    }


}
