package com.sarjh.tender;

import android.app.Fragment;
//import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class Login extends Fragment {

    View v;
    FirebaseAuth auth;
//    ProgressDialog progressDialog;
    EditText email, pass;
    // mref;
    Button login;
    Button btn2;
    TextView tv;
    String eval,passval;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_login, container, false);
      //  databaseReference = FirebaseDatabase.getInstance().getReference();
        email =  v.findViewById(R.id.email);
        pass =  v.findViewById(R.id.pass);
        login =  v.findViewById(R.id.login);
        tv= v.findViewById(R.id.textview);
        auth = FirebaseAuth.getInstance();
//      //  progressDialog = new ProgressDialog(this);
      //  mref = FirebaseDatabase.getInstance().getReference();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                /*progressDialog.setTitle("please wait");
//                progressDialog.setMessage("LoggingIn");
//                progressDialog.show();*/
                loginfun();
            }
        });
        return v;
    }


    void loginfun() {
////        progressDialog.setMessage("Please Wait");

        eval = email.getText().toString().trim();
        passval = pass.getText().toString().trim();
        if (!Patterns.EMAIL_ADDRESS.matcher(eval).matches()) {
//            progressDialog.dismiss();
            email.setError("invalid email id");
            return;
        }
        if (passval.length() < 6) {
//            progressDialog.dismiss();
            pass.setError("Password should contain atleast 6 character");
            return;
        }

        auth.signInWithEmailAndPassword(eval, passval).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
//                progressDialog.dismiss();
                if (task.isSuccessful()) {
//                    finish();
                    Toast.makeText(getActivity(),"success",Toast.LENGTH_LONG);
//                  Intent intent = new Intent(getActivity(), MainPage.class);
//                    progressDialog.dismiss();
                   // intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    //startActivity(intent);
                } else {
//                    progressDialog.dismiss();
                    Toast.makeText(getActivity(), task.getException().getMessage(), Toast.LENGTH_LONG).show();
                }
            }

        });


    }

}
