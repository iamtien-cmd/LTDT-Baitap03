package vn.iostar.tuan4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class SignupActivity extends AppCompatActivity {

    private EditText edtName, edtEmail, edtPassword;
    private ImageView btnSignup;
    private TextView tvForgotPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sigup);

        // Ánh xạ các View
        edtName = findViewById(R.id.edtName);
        edtEmail = findViewById(R.id.edtEmail);
        edtPassword = findViewById(R.id.edtPassword);
        btnSignup = findViewById(R.id.btnRegister);


        // Xử lý đăng ký
        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edtName.getText().toString().trim();
                String email = edtEmail.getText().toString().trim();
                String password = edtPassword.getText().toString().trim();

                if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
                    Toast.makeText(SignupActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(SignupActivity.this, "Signup successful!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(SignupActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });

    }
}

