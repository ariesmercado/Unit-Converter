package com.ariestech.unitconverter;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.content.Context;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button btn;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        btn = findViewById(R.id.btn);
        textView = findViewById(R.id.textview);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Getting the user input (Kilos)
                try {
                    String inputText = editText.getText().toString();

                    // Converting a string into double
                    double kilos = Double.parseDouble(inputText);

                    // Converting kilos into pounds
                    double pounds = makeConversion(kilos);

                    // Displaying the conversion result
                    textView.setText(String.valueOf(pounds));

                    // Hiding the keyboard
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    if (imm != null) {
                        imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                    }

                } catch (Exception ignored) {
                }
            }
        });
    }

    public double makeConversion(double kilos) {
        // 1 kilo = 2.20462 pounds
        return kilos * 2.20462;
    }
}
