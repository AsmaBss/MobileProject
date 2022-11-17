package com.example.mobileproject.Entities;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.ByteArrayOutputStream;

public class DataConvertor {

    public static byte[] convertImageToByteArray(Bitmap bitmap){
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 0, stream);
        return stream.toByteArray();
    }

    public static  Bitmap convertByteArrayToImage(byte[] array){
        return BitmapFactory.decodeByteArray(array, 0, array.length);
    }
}
