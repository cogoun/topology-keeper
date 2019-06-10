Feature:

  Scenario Outline: Hardware specification limits per virtual machine
    When I request a new virtual machine with <vCPU Count> vCPUs and <Memory Size> GB RAM and <Hard Disk Size> GB Hard disk
    Then the virtual machine should be <Outcome>

    Examples:
    | vCPU Count | Memory Size | Hard Disk Size | Outcome         |
    | 4          | 4           | 40             | provisioned     |
    | 8          | 64          | 1000           | provisioned     |
    | 1          | 1           | 40             | provisioned     |
    | 0          | 8           | 80             | not provisioned |
    | 4          | 65          | 80             | not provisioned |
    | 9          | 8           | 80             | not provisioned |

