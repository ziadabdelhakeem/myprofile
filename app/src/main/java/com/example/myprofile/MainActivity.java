package com.example.myprofile;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.TextureView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnsave;
    EditText firstname,lastname;
    EditText mail,phonenmbr,adrs;
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firstname =findViewById(R.id.textInputEditTextfirstname);
        lastname = findViewById(R.id.textInputEditTextlastname);
        mail = findViewById(R.id.textInputEditTextemail);
        phonenmbr = findViewById(R.id.textInputEditTextphonenumber);
        adrs = findViewById(R.id.textInputEditTextaddress);
        btnsave  =findViewById(R.id.buttonsave);

        img=findViewById(R.id.ImageView);
        findViewById(R.id.changephoto).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent m=new Intent(Intent.ACTION_PICK,MediaStore.Images.Media.INTERNAL_CONTENT_URI);
                startActivityForResult(m,200);

            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==100 && resultCode== RESULT_OK)
        {
            img.setImageBitmap((Bitmap)data.getExtras().get("data"));
        }
        else if (requestCode==200 && resultCode==RESULT_OK)
        {
            Uri uri=data.getData();
            img.setImageURI(uri);
        }

    }
    public void go(View view) {
        String textInputEditTextaddress = adrs.getText().toString();
        String textInputEditTextemail = mail.getText().toString();
        String textInputEditTextlastname = lastname.getText().toString();
        String textInputEditTextphonenumber = phonenmbr.getText().toString();
        String textInputEditTextfirstname  = firstname.getText().toString();
        if (firstname.length()<=0)
        {
            Toast.makeText(this, "enter value", Toast.LENGTH_LONG).show();
        }
        else if (lastname.length()<=0)
        {
            Toast.makeText(this, "enter value", Toast.LENGTH_LONG).show();
        }
        else if (adrs.length()<=0)
        {
            Toast.makeText(this, "enter value", Toast.LENGTH_LONG).show();
        }
        else if (phonenmbr.length()<=0)
        {
            Toast.makeText(this, "enter value", Toast.LENGTH_LONG).show();
        }
        else if (mail.length()<=0)
        {
            Toast.makeText(this, "enter value", Toast.LENGTH_LONG).show();
        }
        else
        {
            Intent in =new Intent(MainActivity.this,Activity2.class);
            startActivity(in);
        }}}
