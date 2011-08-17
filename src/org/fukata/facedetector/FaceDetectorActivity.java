package org.fukata.facedetector;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class FaceDetectorActivity extends Activity implements OnClickListener {
	
	Button camera;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        camera = (Button) findViewById(R.id.camera);
        camera.setOnClickListener(this);
    }

	@Override
	public void onClick(View v) {
		if (v == camera) {
			Intent intent = new Intent(this, CameraActivity.class);
			startActivity(intent);
		}
	}
}