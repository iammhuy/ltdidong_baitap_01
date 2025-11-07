package com.example.baitap01;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText edtArrayInput, edtInput;
    Button btnXuLyCau4, btnProcess;
    TextView tvKetQuaCau4, tvResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Ẩn thanh tiêu đề
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

        // Ánh xạ View
        edtArrayInput = findViewById(R.id.edtArrayInput);
        btnXuLyCau4 = findViewById(R.id.btnXuLyCau4);
        tvKetQuaCau4 = findViewById(R.id.tvKetQuaCau4);

        edtInput = findViewById(R.id.edtInput);
        btnProcess = findViewById(R.id.btnProcess);
        tvResult = findViewById(R.id.tvResult);

        // ===== CÂU 4 =====
        btnXuLyCau4.setOnClickListener(v -> {
            String input = edtArrayInput.getText().toString().trim();
            if (input.isEmpty()) {
                Toast.makeText(this, "Vui lòng nhập ít nhất một số!", Toast.LENGTH_SHORT).show();
                return;
            }

            String[] parts = input.split(",");
            ArrayList<Integer> soChan = new ArrayList<>();
            ArrayList<Integer> soLe = new ArrayList<>();

            try {
                for (String s : parts) {
                    int n = Integer.parseInt(s.trim());
                    if (n % 2 == 0) soChan.add(n);
                    else soLe.add(n);
                }
            } catch (Exception e) {
                Toast.makeText(this, "Sai định dạng! Nhập số cách nhau bằng dấu phẩy (,)", Toast.LENGTH_LONG).show();
                return;
            }

            // In ra Logcat
            Log.d("Baitap01", "Số chẵn: " + soChan);
            Log.d("Baitap01", "Số lẻ: " + soLe);

            // Hiển thị ra màn hình app
            String result = " Số chẵn: " + soChan + "\n Số lẻ: " + soLe;
            tvKetQuaCau4.setText(result);

            // Thông báo Toast
            Toast.makeText(this, "Đã xử lý mảng thành công!", Toast.LENGTH_SHORT).show();
        });

        // ===== CÂU 5 ====

        btnProcess.setOnClickListener(v -> {
            String s = edtInput.getText().toString().trim();
            if (s.isEmpty()) {
                Toast.makeText(this, "Vui lòng nhập chuỗi!", Toast.LENGTH_SHORT).show();
                return;
            }

            // Bước 1: Tách chuỗi thành mảng các từ
            String[] words = s.split("\\s+");

            // Bước 2: Đảo ngược thứ tự các từ
            StringBuilder reversedBuilder = new StringBuilder();
            for (int i = words.length - 1; i >= 0; i--) {
                reversedBuilder.append(words[i].toUpperCase());
                if (i > 0) {
                    reversedBuilder.append(" ");
                }
            }

            String reversed = reversedBuilder.toString();

            // Hiển thị
            tvResult.setText("Chuỗi ban đầu: " + s + "\nChuỗi đảo ngược & in hoa: " + reversed);

            // Toast thông báo
            Toast.makeText(this, "Chuỗi sau khi xử lý: " + reversed, Toast.LENGTH_LONG).show();
        });
    }
}
