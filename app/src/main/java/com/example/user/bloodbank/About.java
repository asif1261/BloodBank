package com.example.user.bloodbank;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;

import mehdi.sakout.aboutpage.AboutPage;
import mehdi.sakout.aboutpage.Element;

public class About extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        Element adsElement = new Element();
        adsElement.setTitle("Advertise here");

        View aboutPage = new AboutPage(this)
                .isRTL(false)
                .setImage(R.drawable.mylogobloodbank)
                .setDescription("This application is made for donating blood and finding blood for human. This apps is built intentionally for helping people. It is a final year project which is prepared by Asif (CSE-1261) and Masud (CSE-1266) and this project is supervised by Tania Sultana (Lecturer Dept. of CSE IST). If you have any query or problem or any kind of suggestion about this application, please feel free to contact with us. Thank you.")
                .addItem(new Element().setTitle("Version 1.0"))
                .addItem(adsElement)
                .addGroup("Connect with me")
                .addItem(createContact1())
                .addEmail("asifiqbal.iqbal19@gmail.com")
                .addTwitter("sheikhasifiqbal")
                .addFacebook("asif1261")
                .addItem(createContact2())
                .addEmail("masudparves2812@yahoo.com")
                .addFacebook("masud.parves.376043")
                .addItem(createCopyright())
                .create();

        setContentView(aboutPage);
    }

    private Element createContact2() {
        Element contact = new Element();
        String contactString = new String("Click here to talk with Admin Masud Parves");
        contact.setTitle(contactString);
       // contact.setIcon(R.drawable.iicon_blood_bank);
        contact.setGravity(Gravity.LEFT);
        //contact.setValue(id);

        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sIntent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:01676657922"));


                sIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);


                if (ActivityCompat.checkSelfPermission(About.this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                startActivity(sIntent);
            }
        });

        return contact;
    }

    private Element createContact1() {
        final Element contact = new Element();
        final String contactString = new String("Click here to talk with Admin Asif Iqbal");

        contact.setTitle(contactString);
        //contact.setIcon(R.mipmap.ic_launcher);
        contact.setGravity(Gravity.LEFT);
        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sIntent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:01676299805"));


                sIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);


                if (ActivityCompat.checkSelfPermission(About.this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                startActivity(sIntent);
            }
        });

        return contact;
    }

    private Element createCopyright() {
        final Element copyright = new Element();
        final String copyrightString = String.format("Copyright© 2017 by Asif and Masud");

        copyright.setTitle(copyrightString);
       // copyright.setIcon(R.drawable.iicon_blood_bank);
        copyright.setGravity(Gravity.CENTER);

        return copyright;
    }
}
