package com.example.khizzipool.assignment3;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class StudentInfoAdapter extends ArrayAdapter<Student> {
    private Activity context;
    private List<Student> studentList;

    public StudentInfoAdapter(Activity context, List<Student> studentList) {
        super(context, R.layout.list,studentList);
        this.context = context;
        this.studentList = studentList;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listView = inflater.inflate(R.layout.list,null,true);

        TextView studentName = (TextView) listView.findViewById(R.id.ShowName);
        TextView studentClass = (TextView) listView.findViewById(R.id.ShowClass);
        TextView studentReg = (TextView) listView.findViewById(R.id.ShowReg);

        Student student = studentList.get(position);
        studentName.setText(student.getStudentName());
        studentClass.setText(student.getStudentClass());
        studentReg.setText(student.getStudentReg());
        return listView;
    }
}
