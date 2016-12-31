package com.example.mhtkarakose.edittext;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class MainActivity extends AppCompatActivity {

    Button kaydet;
    CheckBox cb;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        kaydet= (Button) findViewById(R.id.button);
        cb= (CheckBox) findViewById(R.id.checkBox );


        cb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean durum= cb.isChecked(); // is ile başlayanlar boolean çevirir

                if(durum==true) {
                    kaydet.setEnabled(true);
                }else {
                    kaydet.setEnabled(false);
                }
            }
        });

        kaydet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kaydet.setEnabled(false);
                cb.setChecked(false);

            }
        });

    }
}
