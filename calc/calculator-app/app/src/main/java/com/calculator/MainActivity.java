package com.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText inputField;
    private StringBuilder input = new StringBuilder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputField = findViewById(R.id.inputField);

        setupButtons();
    }

    private void setupButtons() {
        int[] buttonIds = {
            R.id.button0, R.id.button1, R.id.button2, R.id.button3,
            R.id.button4, R.id.button5, R.id.button6, R.id.button7,
            R.id.button8, R.id.button9, R.id.buttonAdd, R.id.buttonSubtract,
            R.id.buttonMultiply, R.id.buttonDivide, R.id.buttonEquals, R.id.buttonClear
        };

        for (int id : buttonIds) {
            Button button = findViewById(id);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onButtonClick((Button) v);
                }
            });
        }
    }

    private void onButtonClick(Button button) {
        String buttonText = button.getText().toString();
        if (buttonText.equals("=")) {
            calculateResult();
        } else if (buttonText.equals("C")) {
            clearInput();
        } else {
            input.append(buttonText);
            inputField.setText(input.toString());
        }
    }

    private void calculateResult() {
        // Logic for calculation will be implemented here
        // For now, just clear the input
        inputField.setText("Result");
        input.setLength(0);
    }

    private void clearInput() {
        input.setLength(0);
        inputField.setText("");
    }
}