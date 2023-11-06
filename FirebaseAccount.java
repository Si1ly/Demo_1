package com.example.nmta.data.Account;

import android.app.Activity;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class FirebaseAccount {
    public void LoginWithEmailandPassword(String email, String passWord, Activity activity){
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        firebaseAuth.signInWithEmailAndPassword(email,passWord).addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                Toast.makeText(activity, "Login is Successfully", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(activity, "Failed to Login", Toast.LENGTH_SHORT).show();}
        });
    }

    public void CreateAccountwithEmailandPassword(String email, String passWord, Activity activity){
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        firebaseAuth.createUserWithEmailAndPassword(email,passWord).addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
               firebaseAuth.getCurrentUser().sendEmailVerification().addOnCompleteListener(task1 -> {
                   Toast.makeText(activity, "Welcome to NmtA!", Toast.LENGTH_SHORT).show();
               });
            }else{
                Toast.makeText(activity, "Register failed!", Toast.LENGTH_SHORT).show();}
        });
    }
}
