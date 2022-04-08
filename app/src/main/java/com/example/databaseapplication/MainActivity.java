package com.example.databaseapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etName,etPhone;
    MyDBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = (EditText)findViewById(R.id.edtName);
        etPhone = (EditText)findViewById(R.id.edtPhone);

        dbHandler = new MyDBHandler(this);
    }

    public void addButtonClicked(View v){
        // Read from input fields name and phone
        String naStr = etName.getText().toString();
        String phStr = etPhone.getText().toString();

        //Call add record method from handler class
        dbHandler.addRecord(naStr,phStr);

        // Cleat input fields
        etName.setText("");
        etPhone.setText("");
    }

    public void printDatabaseData(View V){

        String dbString = dbHandler.databaseToString();
        Toast.makeText(getApplicationContext(),dbString,Toast.LENGTH_LONG).show();
    }
}