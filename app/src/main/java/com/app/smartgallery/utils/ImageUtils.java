package com.app.smartgallery.utils;

import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore;
import android.util.Log;

/**
 * Created by Harsh on 23-May-15.
 */
public class ImageUtils {

    public static String[] getAllImagesFromDevice(Context context)
    {
        final String[] columns = { MediaStore.Images.Media.DATA, MediaStore.Images.Media._ID };
        final String orderBy = MediaStore.Images.Media.DATE_ADDED;
        //Stores all the images from the gallery in Cursor
        Cursor cursor = context.getContentResolver().query(
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI, columns, null,
                null, orderBy);
        //Total number of images
        int count = cursor.getCount();
        
        //Create an array to store path to all the images
        String[] arrPath = new String[count];

        for (int i = 0; i < count; i++) {
            cursor.moveToPosition(i);
            int dataColumnIndex = cursor.getColumnIndex(MediaStore.Images.Media.DATA);
            //Store the path of the image
            arrPath[i]= cursor.getString(dataColumnIndex);
            Log.i("PATH", arrPath[i]);
        }

        return columns;
    }
}
