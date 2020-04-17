package com.example.android.gettingfatterinfresno;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class DetailActivity extends AppCompatActivity {

    TextView displayName;
    TextView displayAddress;
    TextView displayPhone;
    TextView displayUrl;
    TextView displayDescription;
    LinearLayout detailsLayout;
    ImageView picHolder;
    CardView imageCard;
    LinearLayout detailsPicHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String description = intent.getStringExtra("description");
        final String address = intent.getStringExtra("address");
        final String phone = intent.getStringExtra("phone");
        final String url = intent.getStringExtra("url");
        int bgColor = intent.getExtras().getInt("bgColor");
        int imageId = intent.getExtras().getInt("imageId");

        displayName = findViewById(R.id.deets_name);
        displayDescription = findViewById(R.id.deets_description);
        displayAddress = findViewById(R.id.deets_address);
        displayPhone = findViewById(R.id.deets_phone);
        displayUrl = findViewById(R.id.deets_url);
        detailsLayout = findViewById(R.id.detail_layout);
        picHolder = findViewById(R.id.iv_details_pic);
        imageCard = findViewById(R.id.cardview_details_pics);
        detailsPicHolder = findViewById(R.id.details_layout);


        displayName.setText(name);
        displayDescription.setText(description);
        displayAddress.setText(address);
        displayPhone.setText(phone);
        detailsLayout.setBackgroundColor(bgColor);


        //if url == none, remove the link icon and url textview
        if (url.equals("none")) {
            displayUrl.setVisibility(View.GONE);
        } else {
            displayUrl.setText(url);
        }

        //if there is no image in the FoodSpot, remove the second cardview
        if(imageId == -1) {
            detailsPicHolder.removeView(imageCard);
        } else {
            picHolder.setImageResource(imageId);
        }

        // open maps with address on displayAddress click
        if (!address.equals("call ahead")){
            displayAddress.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Uri mapUri = Uri.parse("geo:0,0?q=" + Uri.encode(address));
                    startActivity(new Intent(Intent.ACTION_VIEW, mapUri));
                }
            });
        } else {
            displayAddress.setText(R.string.call_for_location);
        }

        // open phone dialer on displayPhone click
        displayPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null)));
            }
        });

        //set onclicklistener on url textview, start new web search activity
        displayUrl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String prefix = "http://www.";
                String newUrl = prefix + url;
                Uri site = Uri.parse(newUrl);
                Intent intent = new Intent(Intent.ACTION_VIEW, site);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });
    }
}

