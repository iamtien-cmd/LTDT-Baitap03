package vn.iostar.tuan4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
        private EditText edtEmail, edtPassword;
        private ImageView btnLogin;
        private Button btnFacebook, btnGoogle;
        private TextView tvRegister;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_login);

            // Ánh xạ các View
            edtEmail = findViewById(R.id.edtEmail);
            edtPassword = findViewById(R.id.edtPassword);
            btnLogin = findViewById(R.id.btnLogin);
            btnFacebook = findViewById(R.id.btnFacebook);
            btnGoogle = findViewById(R.id.btnGoogle);
            tvRegister = findViewById(R.id.tvRegister);

            // Sự kiện đăng nhập
            btnLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String email = edtEmail.getText().toString().trim();
                    String password = edtPassword.getText().toString().trim();

                    if (email.isEmpty() || password.isEmpty()) {
                        Toast.makeText(LoginActivity.this, "Please enter email and password", Toast.LENGTH_SHORT).show();
                    } else if (email.equals("test@example.com") && password.equals("123456")) {
                        Toast.makeText(LoginActivity.this, "Login successful", Toast.LENGTH_SHORT).show();
                        // Chuyển đến màn hình chính sau khi đăng nhập thành công
                        Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(LoginActivity.this, "Invalid email or password", Toast.LENGTH_SHORT).show();
                    }
                }
            });

            // Chuyển sang màn hình đăng ký
            tvRegister.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
                    startActivity(intent);
                }
            });

            // Đăng nhập bằng Facebook
            btnFacebook.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(LoginActivity.this, "Login with Facebook", Toast.LENGTH_SHORT).show();
                }
            });

            // Đăng nhập bằng Google
            btnGoogle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(LoginActivity.this, "Login with Google", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

