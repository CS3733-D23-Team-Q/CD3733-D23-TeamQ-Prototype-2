package edu.wpi.cs3733.D23.teamQ.controllers;

import io.github.palexdev.materialfx.controls.*;
import javafx.application.*;
import javafx.collections.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.*;

public class ForgotPasswordController {
  @FXML ChoiceBox questionChoice1;
  @FXML ChoiceBox questionChoice2;

  @FXML
  public void initialize() {
    questionChoice1.getItems().add("What is your date of birth?");
    questionChoice1.getItems().add("What is your favorite color?");
    questionChoice1.getItems().add("What is your first pet's name?");
    questionChoice1.getItems().add("Where is your home town?");
    questionChoice1.getItems().add("What college did you attend?");
    questionChoice2.getItems().add("What is your date of birth?");
    questionChoice2.getItems().add("What is your favorite color?");
    questionChoice2.getItems().add("What is your first pet's name?");
    questionChoice2.getItems().add("Where is your home town?");
    questionChoice2.getItems().add("What college did you attend?");
  }
}
