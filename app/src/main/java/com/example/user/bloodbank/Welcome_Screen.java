package com.example.user.bloodbank;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class Welcome_Screen extends AppCompatActivity {

    private static int Splash_Time_Out = 5000;

    public TextView bannerText,giveBloodText,saveLifeText,findBlood,welcomeText;
    public ImageView logoBD,imageViewBloodLogo,imageViewBannerBloodBankBD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome__screen);

        //logoBD = (ImageView)findViewById(R.id.imageViewMyLogo);
       // imageViewBloodLogo = (ImageView)findViewById(R.id.imageViewBloodLogo);
        //imageViewBannerBloodBankBD = (ImageView)findViewById(R.id.imageViewBannerBloodBankBD);
        //bannerText = (TextView)findViewById(R.id.textViewBannerPart1);
        //Typeface custom_font = Typeface.createFromAsset(getAssets(),"fonts/ALGER.TTF");
        //bannerText.setTypeface(custom_font);
       // findBlood = (TextView)findViewById(R.id.textViewFindBlood);
        Typeface custom_font1 = Typeface.createFromAsset(getAssets(),"fonts/FTLTLT.TTF");
        //findBlood.setTypeface(custom_font1);
        //welcomeText = (TextView)findViewById(R.id.textViewBD);
        //welcomeText.setTypeface(Typeface.SANS_SERIF);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent ii = new Intent(Welcome_Screen.this, LoginActivity.class);
                Welcome_Screen.this.startActivity(ii);
                Welcome_Screen.this.finish();

            }
        }, Splash_Time_Out);
    }
}
