package starter.Reqres;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Utils.Constant;

import java.io.File;

public class UpdateUserStepDef {
    @Steps
    ReqresAPI reqresAPI;


    //positif
    @And("Validate update user json schema")
    public void validateUpdateUserJsonSchema() {
        File jsonSchemaRegisterUser = new File(Constant.JSON_SCHEMA+"PutUpdateUserJSONSchema.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchemaRegisterUser));

    }

    //Negatif Invalid Parameter
    @Given("Update user with invalid parameter id {string}")
    public void updateUserWithInvalidParameterId(String wrongParameter) {
        File jsonReq = new File(Constant.JSON_REQ_BODY+"UpdateUserReqBody.json");
        reqresAPI.putUpdateUserInvalidParameter(wrongParameter,jsonReq);
    }

    //Negatif Without Parameter
    @Given("Put update user without parameter")
    public void putUpdateUserWithoutParameter() {
        reqresAPI.updateUserWithoutParameter();
    }

    @When("Send request put update user without parameter")
    public void sendRequestPutUpdateUserWithoutParameter() {
        SerenityRest.when().put(ReqresAPI.PUT_UPDATE_USER_WITHOUT_PARAMETER);
    }
}
