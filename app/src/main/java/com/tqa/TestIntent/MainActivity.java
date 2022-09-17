package com.tqa.TestIntent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.tqa.TestIntent.model.HocSinh;

public class MainActivity extends AppCompatActivity {
    FragmentManager fragmentManager = getSupportFragmentManager();
    private Button btn_add;
    private TextView txt_data_string;
    private TextView txt_data_stringArray;
    private TextView txt_data_obj;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setWiget();
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//                FragmentA fragmentA = new FragmentA();
//                fragmentTransaction.add(R.id.main_activity, fragmentA);
                fragmentTransaction.add(R.id.main_activity, new FragmentA(), "FragmentA");
                fragmentTransaction.addToBackStack("add");
                fragmentTransaction.commit();
            }
        });
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("data");
//        Bundle bundle = getIntent().getExtras();
        String string_intent = bundle.getString("string_bundle");
        txt_data_string.setText(string_intent);
//        txt_data_stringArray.setText(bundle.getStringArray("string_array_bundle"));
        HocSinh hocSinh = (HocSinh) bundle.getSerializable("obj_bundle");
//        txt_data_obj.setText("Tên: " + hocSinh.getName() + "; Tuổi: " + hocSinh.getAge());
    }

    private void setWiget() {
        btn_add = findViewById(R.id.btn_add);
        txt_data_string = findViewById(R.id.txt_data_string);
        txt_data_stringArray = findViewById(R.id.txt_data_stringArray);
        txt_data_obj = findViewById(R.id.txt_data_obj);
    }
}