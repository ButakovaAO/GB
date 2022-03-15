Feature: How many apples are on a birch?
  Twenty apples hung on the birch, eight fell, how many remained on the birch?

  Scenario: Apples do not grow on a birch
    Given that apples do not grow on a birch
    When I ask how many apples are left on the birch
    Then I should be told "Apples don't grow on a birch"