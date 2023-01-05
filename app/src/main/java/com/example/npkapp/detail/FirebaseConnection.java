package com.example.npkapp.detail;

import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FieldPath;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FirebaseConnection {
    private static FirebaseConnection instance;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private ArrayList<Detail> arrayVallues = new ArrayList<>();

    private FirebaseConnection(){
        db.collection("alphabet")
                .orderBy(FieldPath.documentId(), Query.Direction.ASCENDING)
                .get()
                .addOnSuccessListener(documentSnapshots -> {
                    if (documentSnapshots.isEmpty()) {
                        Log.d("npkapp", "onSuccess: LIST EMPTY");
                        return;
                    } else {
                        List<Detail> types = documentSnapshots.toObjects(Detail.class);
                        arrayVallues.addAll(types);
                        Log.d("npkapp", "onSuccess: " + arrayVallues);
                    }
                })
               .addOnFailureListener(e -> Log.d("npkapp", "onFailure: error getting data"));

        Log.d("npkappp", db.toString());
    }

    public static FirebaseConnection getInstance(){
        if(instance == null){
            instance = new FirebaseConnection();
        }
        return instance;
    }

    public Detail getByIndex(int index){
        if(index >= 0 && arrayVallues.size() > (index)){
            return arrayVallues.get(index);
        }
        return null;
    }
}
