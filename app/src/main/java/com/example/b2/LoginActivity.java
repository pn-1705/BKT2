package com.example.b2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.b2.dao.DBHelper;
import com.example.b2.dao.UserDao;
import com.example.b2.model.User;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {

    Button callSignUp, login_btn, btn_ForgetPassword;
    ImageView img;
    TextView logoText, slgText;
    TextInputLayout til_phone, til_password;
    TextInputEditText edt_phone, edt_password;
    SharedPreferences sharedPreferences;
    CheckBox checkBox_rememberUP;
    User user;

    SharedPreferences saveLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);

        DBHelper dbHelper = new DBHelper(this, "B2.sqlite", null, 1);

        dbHelper.QueryData("create table if not exists USERS("
                + "id text primary key, "
                + "phone text not null, "
                + "name text not null, "
                + "email text not null, "
                + "password text not null,"
                + "rule text not null)");

        dbHelper.QueryData("create table if not exists trees("
                + "id text primary key, "
                + "tenkhoahoc text not null, "
                + "tenthuonggoi text not null, "
                + "dactinh text not null, "
                + "congdung text not null, "
                + "lieudung text not null, "
                + "luuy text not null, "
                + "resoureId int)");

//        dbHelper.QueryData("insert into USERS values('001', '0339354373', 'Nha', 'nvp@gmail.com', '123', '1')");
//
//        dbHelper.QueryData("insert into trees values('001', 'Zamioculcas zamiifolia', 'Kim tiền', 'd', 'f', 'nh', 'd', '1')");
        //dbHelper.QueryData("insert into trees values('003', 'Zamioculcas zamiifolia', 'Kim tiền', 'd', 'f', 'nh', 'd', 'p1')");

        edt_phone = findViewById(R.id.edt_phone);
        edt_password = findViewById(R.id.edt_password);

        checkBox_rememberUP = findViewById(R.id.cb_savePassword);

        edt_phone.setText(getIntent().getStringExtra("phone"));
        edt_password.setText(getIntent().getStringExtra("password"));

        //Hiển thị tài khoản đã lưu
        sharedPreferences = getSharedPreferences("dataLogin", MODE_PRIVATE);
        if (sharedPreferences.getBoolean("REMEMBER", false) == true) {
            edt_phone.setText(sharedPreferences.getString("PHONE", ""));
            edt_password.setText(sharedPreferences.getString("PASSWORD", ""));
        }

        img = findViewById(R.id.logoImage);
        logoText = findViewById(R.id.logoName);
        slgText = findViewById(R.id.logoSlogan);
        til_phone = findViewById(R.id.til_phone);
        til_password = findViewById(R.id.til_password);

        login_btn = findViewById(R.id.login_btn);
        callSignUp = findViewById(R.id.signUp_btn);

//        btn_ForgetPassword = findViewById(R.id.btn_ForgetPassword);
//        btn_ForgetPassword.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                callForgetPassword(view);
//            }
//        });


        //Đăng nhập
        callSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
//
//                Pair[] pairs = new Pair[7];
//
//                pairs[0] = new Pair<View, String>(img, "logo_img");
//                pairs[1] = new Pair<View, String>(logoText, "logo_Name_Tran");
//                pairs[2] = new Pair<View, String>(slgText, "logo_Slg_Tran");
//                pairs[3] = new Pair<View, String>(til_phone, "username_Tran");
//                pairs[4] = new Pair<View, String>(til_password, "password_Tran");
//                pairs[5] = new Pair<View, String>(login_btn, "btn_LogIn_Tran");
//                pairs[6] = new Pair<View, String>(callSignUp, "btn_callSignUp_Tran");
//
//                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(LoginActivity.this, pairs);

                startActivity(intent/*, options.toBundle()*/);
            }
        });
    }

    public void rememberUP(String phone, String pass, boolean status) {
        SharedPreferences sharedPreferences = getSharedPreferences("dataLogin", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        if (status == false) {
            editor.clear();
        } else {
            editor.putString("PHONE", phone);
            editor.putString("PASSWORD", pass);
            editor.putBoolean("REMEMBER", status);
        }
        editor.commit();
    }

    public void checkLogin(View view) {
//        String phone = edt_phone.getText().toString();
//        String password = edt_password.getText().toString();
//        if (phone.isEmpty() || password.isEmpty()) {
//            Toast.makeText(getApplicationContext(), "Vui lòng không để trống!",
//                    Toast.LENGTH_LONG).show();
//        } else {
//            UserDao dao = new UserDao(this);
//            Boolean ckUP = dao.checkPhonePassword(phone, password);
//            if (ckUP == true) {
//                Toast.makeText(getApplicationContext(), "Đăng nhập thành công",
//                        Toast.LENGTH_SHORT).show();
//
//                if (checkBox_rememberUP.isChecked()) {
//                    SharedPreferences.Editor editor = sharedPreferences.edit();
//
//                    editor.putString("PHONE", phone);
//                    editor.putString("PASSWORD", password);
//                    editor.putBoolean("REMEMBER", true);
//
//                    editor.commit();
//
//                } else {
//                    SharedPreferences.Editor editor = sharedPreferences.edit();
//
//                    editor.putString("PHONE", phone);
//                    editor.putString("PASSWORD", password);
//                    editor.putBoolean("REMEMBER", false);
//
//                    editor.commit();
//
//                }
//
//                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
//                intent.putExtra("phone", phone);
//                startActivity(intent);
//            } else {
//                Toast.makeText(getApplicationContext(), "Tài khoản hoặc mật khẩu không đúng!",
//                        Toast.LENGTH_LONG).show();
//            }
//        }
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);

    }

    public void saveUP(View view) {
        String phone = edt_phone.getText().toString();
        String pass = edt_password.getText().toString();
        boolean status = checkBox_rememberUP.isChecked();
        // rememberUP(phone, pass, status);
    }
//
//    public void callForgetPassword(View view) {
//        Intent intent = new Intent(getApplicationContext(), ForgetPasswordActivity.class);
//        startActivity(intent);
//    }
}