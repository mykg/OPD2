package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

//import android.widget.Toolbar;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

public class HomeActivity extends AppCompatActivity {

    Toolbar toolbar;
    //Button samplebutton;
    //RelativeLayout myLayout;
    //CardView cardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        toolbar = findViewById(R.id.toolbar4);
        toolbar.setTitle("Home");
        /*
       // Button samplebutton = (Button) findViewById(R.id.samplebutton);
        //samplebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Button secondBtn = new Button(HomeActivity.this);
                //myLayout = (RelativeLayout) findViewById(R.id.myLayout);
                cardView = findViewById(R.id.card1);

                //secondBtn.setLayoutParams(new RelativeLayout.LayoutParams(
                //        RelativeLayout.LayoutParams.WRAP_CONTENT,
                //        RelativeLayout.LayoutParams.WRAP_CONTENT
                //));
                secondBtn.setLayoutParams(new CardView.LayoutParams(
                        CardView.LayoutParams.MATCH_PARENT,
                        CardView.LayoutParams.MATCH_PARENT
                ));

                //myLayout.addView(secondBtn);
                cardView.addView(secondBtn);

            }


        });
        */

    }
}
