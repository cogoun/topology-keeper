package com.cogoun.cucumber.steps;

import com.cogoun.cucumber.util.DomainHelper;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.*;

public class StepDefinitions {

    private DomainHelper domainHelper = new DomainHelper();

    @Given("an environment with {int} virtual machines")
    public void an_environment_with_virtual_machines(Integer int1) {
        for (int i = 0; i<int1; i++) {
            domainHelper.environment().add(domainHelper.newVirtualMachine(DomainHelper.HOST_NAME+i));
        }
    }

    @When("I add {int} virtual machines to the environment")
    public void i_add_virtual_machines_to_the_environment(Integer int1) {
        for (int i = 0; i<int1; i++) {
            domainHelper.environment().add(domainHelper.newVirtualMachine(DomainHelper.HOST_NAME+i));
        }
    }

    @Then("the environment has {int} virtual machines")
    public void the_environment_has_virtual_machines(Integer vmCount) {
        assertEquals(vmCount.intValue(), domainHelper.environment().virtualMachineCount());
    }

    @When("I decommission {int} virtual machines")
    public void i_decommission_virtual_machines(Integer vmToDecommission) {
        for (int i = 0; i<vmToDecommission; i++) {
            domainHelper.environment().remove(domainHelper.newVirtualMachine(DomainHelper.HOST_NAME+i));
        }
    }

    @When("I request a new virtual machine with {int} vCPUs and {int} GB RAM and {int} GB Hard disk")
    public void i_request_a_new_virtual_machine_with_vCPUs_and_GB_RAM_and_GB_Hard_disk(Integer int1, Integer int2, Integer int3) {
        domainHelper.virtualizationRequirements(int1, int2, int3);
    }

    @Then("the virtual machine should be provisioned")
    public void the_virtual_machine_should_be_provisioned() {
        assertTrue(domainHelper.infrastructureControl().provision("test", domainHelper.virtualizationRequirements()).isPresent());
    }

    @Then("the virtual machine should be not provisioned")
    public void the_virtual_machine_should_be_not_provisioned() {
        assertFalse(domainHelper.infrastructureControl().provision("test", domainHelper.virtualizationRequirements()).isPresent());
    }

}
