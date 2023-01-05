package com.example.npkapp.detail;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class DetailAdapter extends FragmentStateAdapter {
    private int typeCount;
    FirebaseConnection fireCon;

    public DetailAdapter(Context context, @NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
        fireCon = FirebaseConnection.getInstance();

        DetailActivity activity = (DetailActivity) context;
        typeCount = activity.getItemTypeCount();
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Fragment fragment = new DetailFragment();
        Bundle args = new Bundle();

        Detail obj = fireCon.getByIndex(position);

        String name = "Err";
        String type = "Error";
        if(obj !=null){
            name = obj.getName();
            type = obj.getType();
        }

        args.putString("name", name);
        args.putString("type", type);

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getItemCount() {
        return typeCount;
    }
}
