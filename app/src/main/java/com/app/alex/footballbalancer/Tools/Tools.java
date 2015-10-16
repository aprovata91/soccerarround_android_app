package com.app.alex.footballbalancer.Tools;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by alex on 10/16/15.
 */
public class Tools {

    public static void makeToast(Context ctx, String message){
        Toast toast = Toast.makeText(ctx, message, Toast.LENGTH_SHORT);
        toast.show();
    }
}
