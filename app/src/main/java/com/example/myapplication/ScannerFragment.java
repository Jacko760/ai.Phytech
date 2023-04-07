package com.example.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.widget.ImageButton;
import android.widget.Toast;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ScannerFragment extends Fragment {
    FirebaseAuth auth;
    FirebaseUser user ;
    AlertDialog.Builder alertDialog;
    public ScannerFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_scanner, container, false);
        ImageButton imageButton =view.findViewById(R.id.ibLogout);
        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                alertDialog=new AlertDialog.Builder(getContext());
                alertDialog.setTitle("Log Out ");
                alertDialog.setMessage("Are you sure want to logout ?").setCancelable(false);
                alertDialog.setIcon(R.drawable.baseline_exit_to_app_24);
                alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        FirebaseAuth.getInstance().signOut();
                        Intent intent = new Intent(getContext(),LoginActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_NO_USER_ACTION);
                        startActivity(intent);
                        getActivity().finish();


                    }
                });
                alertDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();

                    }
                });
                alertDialog.create().show();





            }

        });

        return view;

    }





}