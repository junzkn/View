package com.jun.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI() ;
    }


    private void initUI() {
        JunView jun = findViewById(R.id.jun);
        jun.setOnSwitchListener(new JunView.onSwitchListener() {
            @Override
            public void onStatueUpdate(boolean state) {
                if(state==true){
                    Toast.makeText(getApplicationContext(),"open",Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(getApplicationContext(),"close",Toast.LENGTH_LONG).show();
                }
            }
        }) ;
    }
}
