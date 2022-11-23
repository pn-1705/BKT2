package com.example.b2;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.b2.dao.TreeDao;

import java.util.List;
import java.util.Timer;


public class MainActivity extends AppCompatActivity {

    private RecyclerView rcv_tree;
    private TreeAdapter treeAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        rcv_tree = findViewById(R.id.rcv_tree);
        treeAdapter = new TreeAdapter(this);
        TreeDao dao = new TreeDao(this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        rcv_tree.setLayoutManager(linearLayoutManager);

        treeAdapter.setData(dao.getAll());
        rcv_tree.setAdapter(treeAdapter);
    }
}
