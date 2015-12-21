package com.devs.demosafecam;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.TelephonyManager;
import android.widget.ImageView;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.SaveCallback;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    Bitmap bmp;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img = (ImageView) findViewById(R.id.imageView);

        getPhoto();

    }

    private void getPhoto() {

        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                try {
                    InputStream in = new URL("http://www.elandroidelibre.com/wp-content/uploads/2013/01/hello-android_thumb.png").openStream();
                    bmp = BitmapFactory.decodeStream(in);
                } catch (Exception e) {
                    // log error
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void result) {
                if (bmp != null) {
                    img.setImageBitmap(bmp);
                    saveData();
                }

            }

        }.execute();
    }

    private void saveData() {


        TelephonyManager telephonyManager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);

        //bitmap to byte
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.JPEG, 100, stream);
        byte[] byteArray = stream.toByteArray();
        ParseFile file = new ParseFile("capture.jpeg", byteArray);

        Photo photo = new Photo();
        photo.setImei(telephonyManager.getDeviceId());
        photo.setName("Name_Photo");
        photo.setQuality("Low");
        photo.setImageFile(file);


        photo.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                if (e == null) {
                    Toast.makeText(MainActivity.this, "Succeess",
                            Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(MainActivity.this, "Error saving",
                            Toast.LENGTH_LONG).show();
                }
            }
        });
    }


}
