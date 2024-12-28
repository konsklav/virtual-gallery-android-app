package com.unipi.konsklav.second_android_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CategoriesMenuActivity extends AppCompatActivity {

    RadioGroup menuRadioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.categories_menu_activity);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        menuRadioGroup = findViewById(R.id.categoriesRadioGroup);
    }

    public void selectCategory(View view) {
        // Get the selected RadioButton ID from the RadioGroup
        int selectedId = menuRadioGroup.getCheckedRadioButtonId();

        Intent intent = new Intent(this, PaintingsProjectionActivity.class);

        if(selectedId == -1) {
            Toast.makeText(this, "Please choose one category to view!", Toast.LENGTH_SHORT).show();
        } else {
            // Perform navigation based on the selected RadioButton
            if (selectedId == R.id.radioButton1) {
                intent.putExtra("type", "portraits");
            } else if (selectedId == R.id.radioButton2) {
                intent.putExtra("type", "externals");
            } else if (selectedId == R.id.radioButton3) {
                intent.putExtra("type", "internals");
            } else if (selectedId == R.id.radioButton4) {
                intent.putExtra("type", "objects");
            }
        }

        startActivity(intent);
    }
}