package com.helloworld.activity;

import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.ui.StyledPlayerView;
import com.helloworld.R;

public class PlayerActivity extends AppCompatActivity {
    ExoPlayer player;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        StyledPlayerView playerView = findViewById(R.id.playerView);
        player = new ExoPlayer.Builder(PlayerActivity.this).build();
        playerView.setPlayer(player);

        String videoUriString = getIntent().getStringExtra("VIDEO_URI");
        Uri videoUri = Uri.parse(videoUriString);

        MediaItem mediaItem = MediaItem.fromUri(videoUri);
        player.setMediaItem(mediaItem);
        player.prepare();
        player.setPlayWhenReady(true);
    }

    @Override
    protected void onStop() {
        super.onStop();
        player.setPlayWhenReady(false);
        player.release();
        player = null;
    }
}