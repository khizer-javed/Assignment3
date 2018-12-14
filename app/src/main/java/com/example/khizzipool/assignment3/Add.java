package com.example.khizzipool.assignment3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Add extends AppCompatActivity {

    EditText mName,mClass,mReg;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        databaseReference = FirebaseDatabase.getInstance().getReference("Students");

        mName = (EditText) findViewById(R.id.Addname);
        mClass = (EditText) findViewById(R.id.Addclass);
        mReg = (EditText) findViewById(R.id.Addreg);

    }

     public void Addstudent (View v)
    {
        String studentName = mName.getText().toString();
        String studentClass = mClass.getText().toString();
        String studentReg = mReg.getText().toString();

        if(!TextUtils.isEmpty(studentName) && !TextUtils.isEmpty(studentClass) && !TextUtils.isEmpty(studentReg))
        {
            String id = databaseReference.push().getKey();
            Student student = new Student(studentName,studentClass,studentReg,id);
            databaseReference.child(id).setValue(student);
            Toast.makeText(Add.this,"Student Added",Toast.LENGTH_SHORT).show();
        }
        else
            Toast.makeText(Add.this,"Please Fill All Fields",Toast.LENGTH_SHORT).show();
    }
}
