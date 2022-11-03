package com.vitsed.project.ui.pages;


import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$;

public class SearchResults {

  // Elements
  public ElementsCollection found = $$("#ires .g");

  // Actions
  public SelenideElement getResult(int index) {
    return found.get(index);
  }

}
