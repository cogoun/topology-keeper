Feature: Managing virtual machines in an environment

  Scenario: Add a new VM in an existing environment with no virtual machines
    Given an environment with 0 virtual machines
    When I add 1 virtual machines to the environment
    Then the environment has 1 virtual machines

  Scenario: Decommissioning a VM from an existing environment
    Given an environment with 1 virtual machines
    When I decommission 1 virtual machines
    Then the environment has 0 virtual machines

