package com.example.npkapp.detail;

import android.content.Intent;
import android.media.AudioAttributes;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import com.example.npkapp.AlphActivity;
import com.example.npkapp.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.firestore.QueryDocumentSnapshot;


import java.io.IOException;
import java.io.ObjectStreamException;
import java.util.Map;

//implements MediaPlayer.OnPreparedListener
public class DetailFragment extends Fragment  {
    public static final String ARG_OBJECT = "btnIndex";
//    private MediaPlayer mediaPlayer;
    ConstraintLayout layoutDetail;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        layoutDetail = view.findViewById(R.id.layoutDetail);
        TextView tvDetailText = layoutDetail.findViewById(R.id.tvDetailText);
        TextView tvDetailType = layoutDetail.findViewById(R.id.tvDetailType);

        Bundle args = getArguments();
        if (args != null) {

            String name = args.getString("name");
            String type = args.getString("type");
            tvDetailText.setText(name);
            tvDetailType.setText(type);
        }

//        DetailActivity activity = (DetailActivity) getActivity();

//        String detailType = activity.getDetailType();

//        mediaPlayer = new MediaPlayer();
//        mediaPlayer.setAudioAttributes(
//                new AudioAttributes
//                        .Builder()
//                        .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
//                        .build());
//        fetchAudioUrlFromFirebase();
    }

//    private void fetchAudioUrlFromFirebase() {
//        final FirebaseStorage storage = FirebaseStorage.getInstance();
//        // Create a storage reference from our app
//        StorageReference storageRef = storage.getReferenceFromUrl("gs://npkapp-82153.appspot.com/Речь Брежнева.mp3");
//        storageRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
//                    @Override
//                    public void onSuccess(Uri uri) {
//                        try {
//                            // Download url of file
//                            final String url = uri.toString();
//                            mediaPlayer.setDataSource(url);
//                            // wait for media player to get prepare
//                            mediaPlayer.setOnPreparedListener(DetailFragment.this);
//                            mediaPlayer.prepareAsync();
//                        } catch (IOException e) {
//                            e.printStackTrace();
//                        }
//
//                    }
//                })
//                .addOnFailureListener(new OnFailureListener() {
//                    @Override
//                    public void onFailure(@NonNull Exception e) {
//                        Log.i("TAG", e.getMessage());
//                    }
//                });
//
//    }

//    @Override
//    public void onPrepared(MediaPlayer mp) {
//        ImageButton btnDetailSound = layoutDetail.findViewById(R.id.btnDetailSound);
//
//        btnDetailSound.setOnClickListener(view -> {
//            mp.reset();
//            mp.start();
//        });
//
//    }
}
