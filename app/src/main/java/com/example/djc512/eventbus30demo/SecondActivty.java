package com.example.djc512.eventbus30demo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

/**
 * Created by DjC512 on 2017-7-3.
 */

public class SecondActivty extends AppCompatActivity implements View.OnClickListener {
    private Button btn;
    private EditText et;

    @Subscribe
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        EventBus.getDefault().register(this);
        initView();
    }

    private void initView() {
        btn = (Button) findViewById(R.id.btn);

        btn.setOnClickListener(this);
        et = (EditText) findViewById(R.id.et);
        et.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn:
                String etString = et.getText().toString().trim();
                MsgBean bean = new MsgBean();
                bean.setMsg(etString);
                bean.setTag("second");
                EventBus.getDefault().post(bean);
                finish();
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
