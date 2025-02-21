package vn.iostar.tuan4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class Example1 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); // Correct place for super.onCreate
        setContentView(R.layout.example1); // Ensure the XML file has the correct name

        // Binding the startBtn
        ConstraintLayout startBtn = findViewById(R.id.startBtn);
        startBtn.setOnClickListener(new View.OnClickListener() {
            // Handle button click
            @Override
            public void onClick(View v) {
                // Move to the next screen (Example2.class)
                Intent intent = new Intent(Example1.this, LoginActivity.class); // Change Example2.class to your target activity
                startActivity(intent);
            }
        });
    }
}
