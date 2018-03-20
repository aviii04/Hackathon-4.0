package com.example.bhrugvishvakil.tour;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class fair extends AppCompatActivity {
TextView Jan,Feb,Mar,Apr,Ma,Jun,July,Aug,Sept,Oct,Nov,Dec;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fair);
        Jan=(TextView) findViewById(R.id.editText3);
        Feb=(TextView) findViewById(R.id.editText4);
        Mar=(TextView) findViewById(R.id.editText8);
        Apr=(TextView) findViewById(R.id.editText10);
        Ma=(TextView) findViewById(R.id.textView3);
        Jun=(TextView) findViewById(R.id.textView5);
        July=(TextView) findViewById(R.id.textView7);
        Aug=(TextView) findViewById(R.id.textView8);
        Sept=(TextView) findViewById(R.id.textView10);
        Oct=(TextView) findViewById(R.id.textView14);
        Nov=(TextView) findViewById(R.id.textView15);
        Dec=(TextView) findViewById(R.id.textView17);
        Jan.setText("Apple");//query

        Feb.setText("Apple");//query
        Mar.setText("Apple");//query
        Apr.setText("Apple");//query
        Ma.setText("Apple");//query
        Jun.setText("Apple");//query
        July.setText("Apple");//query
        Aug.setText("Apple");//query
        Sept.setText("Apple");//query
        Oct.setText("Apple");//query
        Nov.setText("Apple");//query
        Dec.setText("Apple");//query

    }
}
