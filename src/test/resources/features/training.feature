Feature: Second Task

  Scenario: Private user registration process
    Given browser displays registration page
    When user clicks registration button
    Then user opens registration site
    When user fills fields up with values:
      | first_name | Wldimir                       |

      | last_name  | Putin                         |

      | email      |Pucio@pucio.com                |

      | user_name  | BloodyWlad                    |

      | address1   | Prosta	51                     |

      | city       | Warsaw                        |

      | prov       | oleoleolew                    |

      | zip        | 00-020                        |

      | password   | Pass123                       |
    And user is logged in
    Then close page







