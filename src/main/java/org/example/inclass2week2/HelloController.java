package org.example.inclass2week2;

import java.util.Locale;
import java.util.ResourceBundle;
import java.text.MessageFormat;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;

public class HelloController {

    @FXML private Label lblDistance;
    @FXML private Label lblFuel;
    @FXML private Label lblResult;
    @FXML private TextField txtDistance;
    @FXML private TextField txtFuel;
    @FXML private Button btnCalculate;

    private ResourceBundle bundle;
    private Double lastConsumption = null;

    @FXML
    public void initialize() {
        setLanguage(new Locale("en", "US"));
    }

    private void setLanguage(Locale locale) {
        try {
            bundle = ResourceBundle.getBundle("messages", locale);
            lblDistance.setText(bundle.getString("distance.label"));
            lblFuel.setText(bundle.getString("fuel.label"));
            btnCalculate.setText(bundle.getString("calculate.button"));
            if (lastConsumption != null) {
                lblResult.setText(
                        MessageFormat.format(
                                bundle.getString("result.label"),
                                String.format("%.2f", lastConsumption)
                        )
                );
            } else {
                lblResult.setText(bundle.getString("result.label"));
            }
        } catch (Exception e) {
            lblResult.setText("Error loading language resources.");
        }
    }

    @FXML
    public void onCalculateClick() {
        try {
            double distance = Double.parseDouble(txtDistance.getText());
            double fuel = Double.parseDouble(txtFuel.getText());
            if (distance == 0) {
                lblResult.setText(bundle.getString("invalid.input"));
                lastConsumption = null;
                return;
            }
            lastConsumption = (fuel / distance) * 100;
            lblResult.setText(
                    MessageFormat.format(
                            bundle.getString("result.label"),
                            String.format("%.2f", lastConsumption)
                    )
            );
        } catch (Exception ex) {
            lblResult.setText(bundle.getString("invalid.input"));
            lastConsumption = null;
        }
    }

    @FXML
    public void onENClick() {
        setLanguage(new Locale("en", "US"));
    }

    @FXML
    public void onFRClick() {
        setLanguage(new Locale("fr", "FR"));
    }

    @FXML
    public void onJPClick() {
        setLanguage(new Locale("ja", "JP"));
    }

    @FXML
    public void onIRClick() {
        setLanguage(new Locale("fa", "IR"));
    }
}