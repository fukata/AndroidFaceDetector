package org.fukata.facedetector;

import java.io.IOException;

import android.content.Context;
import android.hardware.Camera;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class CameraView extends SurfaceView implements SurfaceHolder.Callback {
	final static String TAG = CameraView.class.getSimpleName();
    private SurfaceHolder holder;
    protected Camera camera;
 
    CameraView(Context context) {
        super(context);
        holder = getHolder();
        holder.addCallback(this);
        holder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
    }
 
    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        camera = Camera.open();
        try {
			camera.setPreviewDisplay(holder);
		} catch (IOException e) {
			Log.e(TAG, e.getMessage());
		}
    }
 
    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        camera.stopPreview();
        Camera.Parameters params = camera.getParameters();
//        params.setPreviewFormat(format);
        params.setPreviewSize(width, height);
        camera.setParameters(params);
        camera.startPreview();
    }
    
    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        camera.stopPreview();
        camera.release();
    }
}