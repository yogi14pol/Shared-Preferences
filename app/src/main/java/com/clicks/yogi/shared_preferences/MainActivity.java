package com.clicks.yogi.shared_preferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;

public class MainActivity extends AppCompatActivity {

    CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkBox = findViewById(R.id.checkbox1);

        checkBox.setOnCheckedChangeListener(new CompoundButton
                .OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView,
                                         boolean isChecked) {

                if (isChecked){
                    checkBox.setText("Checked");
                }else {
                    checkBox.setText("Not Checked");
                }
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();

        SharedPreferences sharedPreferences = getPreferences(0);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("FIRST",checkBox.getText().toString());
        editor.putBoolean("SECOND",checkBox.isChecked());
        editor.apply();
    }

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences sharedPreferences = getPreferences(0);
        boolean checked = sharedPreferences.getBoolean("SECOND",false);
        String stringValue = sharedPreferences.getString("FIRST",
                "Display Message");

        checkBox.setChecked(checked);
        checkBox.setText(stringValue);
    }

}
