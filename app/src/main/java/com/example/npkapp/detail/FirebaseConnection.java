package com.example.npkapp.detail;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
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

    private Map<String, Detail> alphValues = new HashMap<>();
    private Map<String, Detail> numValues = new HashMap<>();

    private FirebaseConnection(){
    }

    public void initAlphabetValues() {
        db.collection("alphabet")
                .get()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        for (QueryDocumentSnapshot document : task.getResult()) {
                            alphValues.put(document.getId(), document.toObject(Detail.class));
                            Log.d("npkapp", document.getId() + " => " + document.getData());
                        }
                    } else {
                        Log.d("npkapp", "Error getting documents: ", task.getException());
                    }
                });
        Log.d("npkappp", db.toString());
    }

    public void initNumberValues(){
        db.collection("numbers")
                .get()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        for (QueryDocumentSnapshot document : task.getResult()) {
                            numValues.put(document.getId(), document.toObject(Detail.class));
                            Log.d("npkapp", document.getId() + " => " + document.getData());
                        }
                    } else {
                        Log.d("npkapp", "Error getting documents: ", task.getException());
                    }
                });
        Log.d("npkappp", db.toString());
    }

    public static FirebaseConnection getInstance(){
        if(instance == null){
            instance = new FirebaseConnection();
        }
        return instance;
    }

    public Detail alphGetByIndex(int index){
        if(alphValues.containsKey(Integer.toString(index))){
            return alphValues.get(Integer.toString(index));
        }
        return null;
    }

    public Detail numGetByIndex(int index){
        if(numValues.containsKey(Integer.toString(index))){
            return numValues.get(Integer.toString(index));
        }
        return null;
    }
}
