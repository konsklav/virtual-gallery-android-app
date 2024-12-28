package com.unipi.konsklav.second_android_project;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Objects;

public class PaintingsProjectionActivity extends AppCompatActivity {

    TextView vvgPaintingsTextView, titleTextView1, titleTextView2, titleTextView3, descriptionTextView1, descriptionTextView2, descriptionTextView3;

    ImageView paintingImageView1, paintingImageView2, paintingImageView3;

    String title1, title2, title3, image1, image2, image3, description1, description2, description3;

    SQLiteDatabase db;

    Cursor cursor;

    ArrayList<String[]> paintings;

    MyTtS myTtS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.paintings_projection_activity);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        db = openOrCreateDatabase("GalleryAppDB", MODE_PRIVATE, null);

        switch (getIntent().getStringExtra("type")) {
            case "portraits":
                getPaintingsData("Select * from VVGPaintings where Id like 'p%'");

                vvgPaintingsTextView = findViewById(R.id.vvgPaintingsTextView);
                vvgPaintingsTextView.setText("Vincent Van Gogh's: Self-Portraits!");

                break;
            case "externals":
                getPaintingsData("Select * from VVGPaintings where Id like 'e%'");

                vvgPaintingsTextView = findViewById(R.id.vvgPaintingsTextView);
                vvgPaintingsTextView.setText("Vincent Van Gogh's: External Spaces!");

                break;
            case "internals":
                getPaintingsData("Select * from VVGPaintings where Id like 'i%'");

                vvgPaintingsTextView = findViewById(R.id.vvgPaintingsTextView);
                vvgPaintingsTextView.setText("Vincent Van Gogh's: Internal Spaces!");

                break;
            case "objects":
                getPaintingsData("Select * from VVGPaintings where Id like 'o%'");

                vvgPaintingsTextView = findViewById(R.id.vvgPaintingsTextView);
                vvgPaintingsTextView.setText("Vincent Van Gogh's: Objects!");

                break;
        }

        titleTextView1 = findViewById(R.id.titleTextView1);
        titleTextView2 = findViewById(R.id.titleTextView2);
        titleTextView3 = findViewById(R.id.titleTextView3);

        titleTextView1.setText(title1);
        titleTextView2.setText(title2);
        titleTextView3.setText(title3);

        paintingImageView1 = findViewById(R.id.paintingImageView1);
        paintingImageView2 = findViewById(R.id.paintingImageView2);
        paintingImageView3 = findViewById(R.id.paintingImageView3);

        setPaintingsImages(image1);

        descriptionTextView1 = findViewById(R.id.descriptionTextView1);
        descriptionTextView2 = findViewById(R.id.descriptionTextView2);
        descriptionTextView3 = findViewById(R.id.descriptionTextView3);

        descriptionTextView1.setText(description1);
        descriptionTextView2.setText(description2);
        descriptionTextView3.setText(description3);

        myTtS = new MyTtS(this);
    }

    public void getPaintingsData(String sql){
        cursor = db.rawQuery(sql,null);

        paintings = new ArrayList<>();

        // Iterate through the results
        if (cursor.moveToFirst()) {
            do {
                String title = cursor.getString(1);
                String image = cursor.getString(2);
                String description = cursor.getString(3);

                paintings.add(new String[]{title, image, description});
            } while (cursor.moveToNext());
        }

        cursor.close();

        title1 = paintings.get(0)[0];
        image1 = paintings.get(0)[1];
        description1 = paintings.get(0)[2];

        title2 = paintings.get(1)[0];
        image2 = paintings.get(1)[1];
        description2 = paintings.get(1)[2];

        title3 = paintings.get(2)[0];
        image3 = paintings.get(2)[1];
        description3 = paintings.get(2)[2];
    }

    public void setPaintingsImages(String image1){
        if(Objects.equals(image1, "portrait1")){
            paintingImageView1.setImageResource(R.drawable.portrait1);
            paintingImageView2.setImageResource(R.drawable.portrait2);
            paintingImageView3.setImageResource(R.drawable.portrait3);
        } else if (Objects.equals(image1, "external1")) {
            paintingImageView1.setImageResource(R.drawable.external1);
            paintingImageView2.setImageResource(R.drawable.external2);
            paintingImageView3.setImageResource(R.drawable.external3);
        } else if (Objects.equals(image1, "internal1")) {
            paintingImageView1.setImageResource(R.drawable.internal1);
            paintingImageView2.setImageResource(R.drawable.internal2);
            paintingImageView3.setImageResource(R.drawable.internal3);
        } else {
            paintingImageView1.setImageResource(R.drawable.object1);
            paintingImageView2.setImageResource(R.drawable.object2);
            paintingImageView3.setImageResource(R.drawable.object3);
        }
    }

    public void speak(View view){
        String description = "";

        if (view.getId() == R.id.speakerImageButton1) {
            description = description1;
        } else if (view.getId() == R.id.speakerImageButton2) {
            description = description2;
        } else if (view.getId() == R.id.speakerImageButton3) {
            description = description3;
        }

        myTtS.speak(description);
    }

    public void backToCategoriesMenu(View view) {
        Intent intent = new Intent(this, CategoriesMenuActivity.class);
        startActivity(intent);
    }
}