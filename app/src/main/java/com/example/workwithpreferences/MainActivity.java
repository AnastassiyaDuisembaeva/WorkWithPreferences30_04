package com.example.workwithpreferences;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    SharedPreferences prefs;
    EditText editTextKey;
    EditText editTextValue;
    String key, value;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        prefs = getSharedPreferences("prefs", MODE_PRIVATE);
        editTextKey = (EditText) findViewById(R.id.edittextkey);
        editTextValue = (EditText) findViewById(R.id.edittextvalue);
        result = findViewById(R.id.result);

    }
    public void sendMessage(View view) {
        key = editTextKey.getText().toString();
        value = editTextValue.getText().toString();
        writePref(key,value);
        result.setText(readPref(key));
    }
    public String readPref (String key){
        return prefs.getString(key, value);
    }
    public void writePref(String key, String value){
        prefs.edit().putString(key, value).apply();
    }
}
