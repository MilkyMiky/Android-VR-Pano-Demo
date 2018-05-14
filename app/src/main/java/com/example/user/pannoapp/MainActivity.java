package com.example.user.pannoapp;

import android.app.Activity;
import android.content.res.AssetManager;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import com.google.vr.sdk.widgets.pano.VrPanoramaView;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends Activity {
    private VrPanoramaView panoWidgetView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        panoWidgetView = findViewById(R.id.pano_view);
        VrPanoramaView.Options panoOptions = new VrPanoramaView.Options();
        panoOptions.inputType = VrPanoramaView.Options.TYPE_STEREO_OVER_UNDER;

        InputStream istr = null;
        AssetManager assetManager = getAssets();
        try {
            istr = assetManager.open("andes.jpg");
            panoOptions = new VrPanoramaView.Options();
            panoOptions.inputType = VrPanoramaView.Options.TY
        } catch (IOException ignored) {

        }
        panoWidgetView.loadImageFromBitmap(BitmapFactory.decodeStream(istr), panoOptions);
    }

    @Override
    protected void onPause() {
        panoWidgetView.pauseRendering();
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        panoWidgetView.resumeRendering();
    }

    @Override
    protected void onDestroy() {
        panoWidgetView.shutdown();
        super.onDestroy();
    }


}
