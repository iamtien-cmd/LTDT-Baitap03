package vn.iostar.tuan4;
import vn.iostar.tuan4.R; // Đảm bảo package đúng với dự án của bạn

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.ArrayList;
import java.util.Random;

public class VDImageView extends AppCompatActivity {


    ImageView img1;
    ImageButton img2;
    ConstraintLayout bg;
    Switch sw;
    CheckBox ck1;
    RadioGroup radioGroup;
    ProgressBar progressBar;
    SeekBar seekBar;
    View btnButton; // Giả sử có một nút để mở menu

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vdimageview);

        // Ánh xạ view
        img1 = findViewById(R.id.imageView1);
        img2 = findViewById(R.id.imageButton1);
        bg = findViewById(R.id.constraintLayout1);
        sw = findViewById(R.id.switch1);
        ck1 = findViewById(R.id.checkBox);
        radioGroup = findViewById(R.id.radioGroup1);
        progressBar = findViewById(R.id.progressBar2);
        seekBar = findViewById(R.id.seekBar);
        btnButton = findViewById(R.id.buttonMenu); // Cần có ID tương ứng trong XML

        // Cập nhật ảnh cho ImageView
        img1.setImageResource(R.drawable.kotlin);

        // Thay đổi nền ngẫu nhiên
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(R.drawable.bg1);
        arrayList.add(R.drawable.bg2);
        arrayList.add(R.drawable.bg3);
        arrayList.add(R.drawable.bg4);

        Random random = new Random();
        int vitri = random.nextInt(arrayList.size());
        bg.setBackgroundResource(arrayList.get(vitri));

        // Xử lý sự kiện click cho ImageButton
        img2.setOnClickListener(v -> {
            img1.setImageResource(R.drawable.dart);
            img1.getLayoutParams().width = 550;
            img1.getLayoutParams().height = 550;
            img1.requestLayout();
        });

        // Xử lý sự kiện bật/tắt switch
        sw.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                Toast.makeText(VDImageView.this, "WiFi đang bật", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(VDImageView.this, "WiFi đang tắt", Toast.LENGTH_LONG).show();
            }
        });

        // Xử lý sự kiện checkbox
        ck1.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                bg.setBackgroundResource(R.drawable.bg3);
            } else {
                bg.setBackgroundResource(R.drawable.bg4);
            }
        });

        // Xử lý sự kiện RadioGroup
        radioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == R.id.radioButton) {
                bg.setBackgroundResource(R.drawable.bg3);
            } else if (checkedId == R.id.radioButton2) {
                bg.setBackgroundResource(R.drawable.bg4);
            }
        });

        // Xử lý sự kiện tăng progressBar
        img2.setOnClickListener(v -> {
            int current = progressBar.getProgress();
            progressBar.setProgress(current + 10);
        });

        // Xử lý sự kiện SeekBar
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.d("AAA", "Giá trị: " + progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Log.d("AAA", "Start");
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Log.d("AAA", "Stop");
            }
        });

        // Đăng ký context menu cho nút buttonMenu
        registerForContextMenu(btnButton);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_setting, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.menuSetting) {
            Toast.makeText(this, "Bạn đã chọn Setting", Toast.LENGTH_SHORT).show();
            return true;
        } else if (item.getItemId() == R.id.menuShare) {
            Toast.makeText(this, "Bạn đã chọn Share", Toast.LENGTH_SHORT).show();
            return true;
        } else if (item.getItemId() == R.id.menuLogout) {
            Toast.makeText(this, "Bạn đã chọn Logout", Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onOptionsItemSelected(item);

    }

    private void ShowPopupMenu() {
        PopupMenu popupMenu = new PopupMenu(this, btnButton);
        popupMenu.getMenuInflater().inflate(R.menu.menu_setting, popupMenu.getMenu());

        popupMenu.setOnMenuItemClickListener(item -> {
            int id = item.getItemId();
            if (id == R.id.menuSetting) {
                Toast.makeText(VDImageView.this, "Bạn đang chọn Setting", Toast.LENGTH_LONG).show();
                return true;
            } else if (id == R.id.menuShare) {
                Toast.makeText(VDImageView.this, "Bạn đang chọn Share", Toast.LENGTH_LONG).show();
                return true;
            } else if (id == R.id.menuLogout) {
                Toast.makeText(VDImageView.this, "Bạn đang chọn Logout", Toast.LENGTH_LONG).show();
                return true;
            }
            return false;
        });


        popupMenu.show();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.menu_setting, menu);
        menu.setHeaderTitle("Context Menu");
        menu.setHeaderIcon(R.mipmap.ic_launcher);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    private void DiaLog1() {
        Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog);
        dialog.setCanceledOnTouchOutside(false);

        EditText editText1 = dialog.findViewById(R.id.editNumber1);

        dialog.show();
    }
}
