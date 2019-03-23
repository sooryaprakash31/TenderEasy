package com.sarjh.tender;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.firebase.client.core.Context;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class SignUp extends Fragment  {

    public FirebaseAuth auth;
    Button btnSignUp;
    EditText inputEmail, inputPassword;

    View v;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //Firebase.setAndroidContext(getActivity());

        FirebaseApp.initializeApp(getActivity());
        auth = FirebaseAuth.getInstance();

        v = inflater.inflate(R.layout.fragment_sign, container, false);
        btnSignUp = v.findViewById(R.id.sign_up_button);
        inputEmail = v.findViewById(R.id.inputEmail);
        inputPassword = v.findViewById(R.id.inputPassword);

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"Successss",Toast.LENGTH_LONG).show();
                auth.createUserWithEmailAndPassword("s@gmail.com", "typerracer").addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Toast.makeText(getActivity(), "SignUp Complete", Toast.LENGTH_SHORT).show();

                        // If sign in fails, display a message to the user. If sign in succeeds
                        // the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in the listener.
                        if (!task.isSuccessful()) {
                            Toast.makeText(getActivity(), "Authentication failed.", Toast.LENGTH_SHORT).show();
                        } else {

                        }
                    }
                });

            }

        });

     /*  btnSignUp.setOnClickListener(new View.OnClickListener() {
                                         @Override
                                         public void onClick(View v) {
                                             String email = inputEmail.getText().toString().trim();
                                             String password = inputPassword.getText().toString().trim();
                                             Toast.makeText(getActivity(),email,Toast.LENGTH_LONG).show();
                                          /*   if (TextUtils.isEmpty(email)) {
                                                 Toast.makeText(getContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
                                                 return;
                                             }

                                             if (TextUtils.isEmpty(password)) {
                                                 Toast.makeText(getContext(), "Enter password!", Toast.LENGTH_SHORT).show();
                                                 return;
                                             }

                                             if (password.length() < 6)
                                             {
                                                 Toast.makeText(getActivity(), "Password too short, enter minimum 6 characters!", Toast.LENGTH_SHORT).show();
                                             return;
                                             }
                                             auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
                                                 @Override
                                                 public void onComplete(@NonNull Task<AuthResult> task) {
                                                     Toast.makeText(getActivity(), "SignUp Complete", Toast.LENGTH_SHORT).show();

                                                     // If sign in fails, display a message to the user. If sign in succeeds
                                                     // the auth state listener will be notified and logic to handle the
                                                     // signed in user can be handled in the listener.
                                                     if (!task.isSuccessful()) {
                                                         Toast.makeText(getActivity(), "Authentication failed.", Toast.LENGTH_SHORT).show();
                                                     } else {

                                                     }
                                                 }
                                             });

                                             }

                                     }); */

        // Inflate the layout for this fragment
        return v;
    }

}