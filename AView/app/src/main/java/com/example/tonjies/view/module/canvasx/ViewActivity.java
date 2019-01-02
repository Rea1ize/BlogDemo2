package com.example.tonjies.view.module.canvasx;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.tonjies.view.R;
import com.example.tonjies.view.util.L;

/**
 *
 */
public class ViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        XView view = new XView(this);
    }
}
