package starter.Reqres;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import starter.Utils.Constant;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;

public class SingleUserStepDef {
    @Steps
    ReqresAPI reqresAPI;
    //Positif
    @Given("Get single user with valid parameter id {int}")
    public void getSingleUserWithValidParameterIdId(int id) {
        reqresAPI.getSingleUser(id);
    }

    @When("Send request get single user")
    public void sendRequestGetSingleUser() {
        SerenityRest.when().get(ReqresAPI.GET_SINGLE_USER);
    }

    @And("Get single user json schema validator")
    public void getSingleUserJsonSchemaValidator() {
        File jsonReq = new File(Constant.JSON_SCHEMA+"GetSingleUserJSONSchema.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonReq));
    }


    //Negatif
    @Given("Get single user with invalid parameter id {int}")
    public void getSingleUserWithInvalidParameterIdId(int id) {
        reqresAPI.getSingleUser(id);
    }

    @Then("Status code should be {int} Not Found")
    public void statusCodeShouldBeNotFound(int notFound) {
        SerenityRest.then().statusCode(notFound);
    }

}
