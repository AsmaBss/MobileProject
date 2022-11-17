package com.example.mobileproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.mobileproject.Database.AppDatabase;
import com.example.mobileproject.Entities.DataConvertor;
import com.example.mobileproject.Entities.User;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;

public class RegisterActivity extends AppCompatActivity {
    private ConstraintLayout registerBtn;
    private EditText firstname, lastname, email, password, address, phone;
    private ImageView pic;
    private Button addImage;
    private AppDatabase database;
    private final int RESULT_LOAD_IMAGE = 1;
    Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        database = AppDatabase.getAppDatabase(getApplicationContext());
        firstname=findViewById(R.id.firstname);
        lastname=findViewById(R.id.lastname);
        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
        address=findViewById(R.id.address);
        phone=findViewById(R.id.phone);
        pic=findViewById(R.id.pic);
        bitmap = null;

        addImage=findViewById(R.id.addImage);
        addImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getImageFromAlbum();
            }
        });

        registerBtn=findViewById(R.id.registerBtn);
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(firstname.getText().toString().isEmpty() || lastname.getText().toString().isEmpty() ||
                        email.getText().toString().isEmpty() || password.getText().toString().isEmpty() ||
                        address.getText().toString().isEmpty() || phone.getText().toString().isEmpty() ||
                        bitmap == null){
                    Toast.makeText(RegisterActivity.this, "Data is missing", Toast.LENGTH_LONG).show();
                }else {
                    database.userDao().insertOne(new User(firstname.getText().toString(), lastname.getText().toString(),
                            email.getText().toString(), password.getText().toString(),
                            address.getText().toString(), Integer.parseInt(phone.getText().toString()),
                            DataConvertor.convertImageToByteArray(bitmap)));
                    startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                }
            }
        });
    }

    private void getImageFromAlbum(){
        try{
            Intent i = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            if(i.resolveActivity(getPackageManager()) != null) {
                startActivityForResult(i, RESULT_LOAD_IMAGE);
            }
        }catch(Exception exp){
            Log.i("Error",exp.toString());
        }
    }

    @Override
    protected void onActivityResult(int reqCode, int resultCode, Intent data) {
        super.onActivityResult(reqCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            try {
                final Uri imageUri = data.getData();
                final InputStream imageStream = getContentResolver().openInputStream(imageUri);
                bitmap = BitmapFactory.decodeStream(imageStream);
                pic.setImageBitmap(bitmap);
            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(RegisterActivity.this, "Something went wrong", Toast.LENGTH_LONG).show();
            }
        }else {
            Toast.makeText(RegisterActivity.this, "You haven't picked Image",Toast.LENGTH_LONG).show();
        }
    }

}