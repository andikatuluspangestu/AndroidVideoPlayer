package com.adhistya.video;

import android.app.*;
import android.os.*;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;
import android.net.Uri;

public class MainActivity extends Activity 
{
	//Deklarasi Variable
    private VideoView videoView;
    private MediaController mediaController;
    private Button playVideo;
	
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
		
		//Inisialisasi VideoView, MediaController dan Button
        videoView = findViewById(R.id.video);
        playVideo = findViewById(R.id.play);
        mediaController = new MediaController(this);
		
		//Menjalankan Video saat tombol Play di Klik
        playVideo.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {

					//Variable Uri untuk menentukan lokasi Resource Video yang akan ditampilkan
					Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.video);

					videoView.setVideoURI(uri);

					//Memasang MediaController untuk menampilkan tombol play, pause, dsb
					videoView.setMediaController(mediaController);
					mediaController.setAnchorView(videoView);

					//Menjalankan Video
					videoView.start();
				}
			});
    }
}
		
    

