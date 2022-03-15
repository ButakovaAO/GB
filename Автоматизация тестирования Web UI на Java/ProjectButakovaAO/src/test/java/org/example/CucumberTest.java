package org.example;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CucumberTest {
    private String answer;
    private String actualAnswer;

    @Given("that apples do not grow on a birch")
    public void thatApplesDoNotGrowOnABirch() {
        actualAnswer = "Apples don't grow on a birch";
    }

    @When("I ask how many apples are left on the birch")
    public void iAskHowManyApplesAreLeftOnTheBirch() {
        answer = "twelve";
    }

    @Then("I should be told {string}")
    public void iShouldBeTold(String expectedAnswer) {
        assertEquals(expectedAnswer, actualAnswer);
    }
}
 