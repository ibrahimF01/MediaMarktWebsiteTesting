Feature: Become a member

  Scenario:membership procedures

    Given Navigate to MediaMarkt

    And Click on the element in the Dialog
      | hesabım  |
      | uyeOl    |
      |pupup     |

   # When come to the top of the page

    And Click on the element in the Dialog
      | cinsiyet  |

    And User sending the keys in Dialog content
      | name        | gül           |
      | lastName    |bahar          |
      |phone        |+905874580898  |
      |eposta       |amg63@gmail.com|
      |password     |mercedesbenz   |
      |passwordAgain|mercedesbenz   |

    And Click on the element in the Dialog
      | sozlesmeOnay  |
      | submitButton  |
      | hesabım       |


    Then Success message should be displayed