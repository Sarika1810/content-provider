package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    EditText editTextName;
    Button buttonSave;
    TextView textViewDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextName = findViewById(R.id.editTextName);
        buttonSave = findViewById(R.id.buttonSave);
        textViewDisplay = findViewById(R.id.textViewDisplay);

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editTextName.getText().toString();
                // Save the name to SharedPreferences
                getSharedPreferences("MyPrefs", MODE_PRIVATE)
                        .edit()
                        .putString("userName", name)
                        .apply();
            }
        });

        // Retrieve the name from SharedPreferences
        String savedName = getSharedPreferences("MyPrefs", MODE_PRIVATE)
                .getString("userName", "");
        textViewDisplay.setText("Welcome, " + savedName);
    }
}
