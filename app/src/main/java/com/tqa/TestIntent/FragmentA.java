package com.tqa.TestIntent;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.tqa.TestIntent.model.HocSinh;


public class FragmentA extends Fragment {
    private Button btn_fragment;
    private String[] arrayName = {"QA", "Tuan", "Anh"};
    private HocSinh hanQi = new HocSinh("hAnQi",23);

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_a, container, false);
        setWiget(view);
        sendData();
        return view;
    }

    private void sendData() {
        Intent intent = new Intent(getActivity(), MainActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("string_bundle", "Quang Anh");
        bundle.putStringArray("string_array_bundle", arrayName);
        bundle.putSerializable("obj_bundle", hanQi);
        intent.putExtra("data", bundle);
//        intent.putExtras(bundle);
        startActivity(intent);
    }

    private void setWiget(View view) {
        btn_fragment = view.findViewById(R.id.btn_fragment);
    }
}