package vn.iostar.tuan4;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SignupActivity extends AppCompatActivity {

    private EditText edtName, edtEmail, edtPassword;
    private ImageView btnRegister;
    private TextView tvLogin;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sigup); // Đảm bảo file XML đúng tên

        // Ánh xạ view từ XML
        edtName = findViewById(R.id.edtName);
        edtEmail = findViewById(R.id.edtEmail);
        edtPassword = findViewById(R.id.edtPassword);
        btnRegister = findViewById(R.id.btnRegister);
        tvLogin = findViewById(R.id.tvLogin);

        // Xử lý sự kiện khi nhấn nút "Sign Up"
        btnRegister.setOnClickListener(view -> registerUser());

        // Chuyển sang màn hình Login khi nhấn "Sign in"
        tvLogin.setOnClickListener(view -> {
            Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
            startActivity(intent);
            finish(); // Đóng màn hình đăng ký
        });
    }

    private void registerUser() {
        String name = edtName.getText().toString().trim();
        String email = edtEmail.getText().toString().trim();
        String password = edtPassword.getText().toString().trim();

        // Kiểm tra tính hợp lệ của dữ liệu nhập vào
        if (TextUtils.isEmpty(name)) {
            edtName.setError("Vui lòng nhập tên!");
            Toast.makeText(SignupActivity.this, "Please enter name", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(email)) {
            edtEmail.setError("Vui lòng nhập email!");
            Toast.makeText(SignupActivity.this, "Please enter email", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(password) || password.length() < 6) {
            edtPassword.setError("Mật khẩu phải có ít nhất 6 ký tự!");
            Toast.makeText(SignupActivity.this, "Invalid password", Toast.LENGTH_SHORT).show();
            return;
        }

        // Giả lập đăng ký thành công (Bạn có thể thêm Firebase Auth hoặc database)
        Toast.makeText(SignupActivity.this, "Đăng ký thành công!", Toast.LENGTH_SHORT).show();

        // Chuyển sang màn hình đăng nhập sau khi đăng ký
        Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}
