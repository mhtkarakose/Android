package mhtkarakose.com.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends Activity {
    private final int VIDEO_REQUEST_CODE =100;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void captureVideo(View view){
        Intent camera_intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
        File video_file = getFilepath();
        Uri video_uri = Uri.fromFile(video_file);
        camera_intent.putExtra(MediaStore.EXTRA_OUTPUT, video_uri);
        camera_intent.putExtra(MediaStore.EXTRA_VIDEO_QUALITY,1);
        startActivityForResult(camera_intent,VIDEO_REQUEST_CODE);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == VIDEO_REQUEST_CODE){
            if(requestCode==RESULT_OK){
                Toast.makeText(getApplicationContext(),"Video çektin",Toast.LENGTH_LONG).show();

            }else {
                Toast.makeText(getApplicationContext(), "Video çekemedin", Toast.LENGTH_LONG).show();

            }
        }

    }

    public File getFilepath(){

        File folder = new File("cddar/videe_app");
        if(folder.exists()){
            folder.mkdir();
        }
        File video_file = new File(folder,"sample_video.mp4");

        return video_file;
    }
}
