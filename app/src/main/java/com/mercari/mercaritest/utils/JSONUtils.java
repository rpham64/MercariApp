package com.mercari.mercaritest.utils;

import android.content.Context;

import java.io.IOException;
import java.io.InputStream;

public class JSONUtils {


    /**
     * Loads a JSON string from the given asset file.
     *
     * @param context The calling parent class.
     * @param fileName The input file containing the JSON data.
     * @return JSON string representing the given file.
     */
    public static String loadJSONFromAsset(Context context, String fileName) {
        String json = null;
        try {
            InputStream is = context.getAssets().open(fileName);

            int size = is.available();

            byte[] buffer = new byte[size];

            is.read(buffer);

            is.close();

            json = new String(buffer, "UTF-8");


        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;

    }
}
