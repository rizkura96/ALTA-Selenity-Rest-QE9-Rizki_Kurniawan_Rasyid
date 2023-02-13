package starter.Reqres;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

public class DeleteUserStepDef {

    @Steps
    ReqresAPI reqresAPI;


    //Negatif invalid paramater id
    @Given("Delete user with invalid id {string}")
    public void deleteUserWithInvalidId(String id) {
        reqresAPI.deleteUserInvalidParameter(id);
    }

    @When("Send request delete user invalid parameter")
    public void sendRequestDeleteUserInvalidParameter() {
        SerenityRest.when().delete(ReqresAPI.DELETE_USER_INVALID_PARAMETER);
    }


    //  Negatif without parameter id
    @Given("Delete user without id")
    public void deleteUserWithoutId() {
        reqresAPI.deleteUserWithoutParameter();
    }

    @When("Send request delete user without parameter id")
    public void sendRequestDeleteUserWithoutParameterId() {
        SerenityRest.when().delete(ReqresAPI.DELETE_USER_WITHOUT_PARAMETER);
    }
}
