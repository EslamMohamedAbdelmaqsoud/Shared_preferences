package com.example.sharedpreferences;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private EditText editText1, editText2, editText3;
    private Button button1, button2;
    private SharedPreferences sharedPreferences;
    private static final String Mykey = "secret";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textview);
        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
        editText3 = findViewById(R.id.editText3);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);

        button1.setOnClickListener(view -> {
            {
                sharedPreferences = getSharedPreferences(Mykey, 0);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("msg", editText1.getText() + editText2.getText().toString());
                editor.commit();

            }
        });
        SharedPreferences preferences = getSharedPreferences(Mykey, 0);
        if (preferences.contains("msg")) {
            String mymsg = preferences.getString("msg", "notFound");
            textView.setText(mymsg);

        }


        button2.setOnClickListener(view -> {
            sharedPreferences = getSharedPreferences(Mykey, 0);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("msg", editText3.getText().toString());
            Toast.makeText(this, editText3.getText(), Toast.LENGTH_SHORT).show();
            editor.apply();

        });


    }
}