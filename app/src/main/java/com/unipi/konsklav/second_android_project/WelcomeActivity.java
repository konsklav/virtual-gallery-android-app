package com.unipi.konsklav.second_android_project;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class WelcomeActivity extends AppCompatActivity {

    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.welcome_activity);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        db = openOrCreateDatabase("GalleryAppDB", MODE_PRIVATE, null);

        db.execSQL("Create table if not exists VVGPaintings(" +
                "Id Text primary key," +
                "Title Text," +
                "Image Text," +
                "Description Text)");

        db.execSQL("Insert into VVGPaintings(Id, Title, Image, Description) values('p1', 'Self-Portrait with Straw Hat (1887-88)', 'portrait1', 'In `Self-portrait with Straw Hat`, we get a front-row seat to Van Gogh’s evolving style during his Parisian days. This isn’t just any selfie; it’s a dazzling display of brushwork and color that would give modern filters a run for their money. With a dash of sun in his hat and a twinkle in his eye, this self-portrait reminds us why Van Gogh’s place at the top of the Van Gogh famous paintings list is well-deserved.')");
        db.execSQL("Insert into VVGPaintings(Id, Title, Image, Description) values('p2', 'Self-Portrait with Bandaged Ear (1889)', 'portrait2', 'This isn’t merely a portrait, but a raw and unfiltered look into the artist’s soul during a turbulent time. Fresh from a self-inflicted wound after a row with fellow artist Gauguin, Van Gogh presents himself with a bandaged ear and a forlorn expression.')");
        db.execSQL("Insert into VVGPaintings(Id, Title, Image, Description) values('p3', 'Self-Portrait (1889)', 'portrait3', 'The work, which may have been Van Goghs last self-portrait, was painted shortly before he left Saint-Rémy-de-Provence in southern France. The painting is now at the Musée dOrsay in Paris.')");

        db.execSQL("Insert into VVGPaintings(Id, Title, Image, Description) values('e1', 'The Café  Terrace at Night (1888)', 'external1', 'Painted during his stay in Arles, this masterpiece, characteristic of Van Gogh’s paintings, serves up a nightly escape in dashing blues and warm yellows. The scene? A quaint café, where patrons laugh, clink glasses, and bask under a sky that’s both dreamy and electric.')");
        db.execSQL("Insert into VVGPaintings(Id, Title, Image, Description) values('e2', 'The Starry Night (1889)', 'external2', 'Van Gogh’s brush sweeps us into a night sky ablaze with swirling stars, while a sleepy town nestles below, bathed in moonlight. This isn’t merely a night scene; it’s a passionate depiction of the vast, pulsating universe that perhaps mirrors the whirl of emotions inside the artist’s mind.')");
        db.execSQL("Insert into VVGPaintings(Id, Title, Image, Description) values('e3', 'The Red Vineyard (1888)', 'external3', 'This is the only painting he sold during his lifetime, and once you soak in its fiery reds and moody purples, you can see why. A scene of workers tending to grapevines becomes a visual feast, reflecting both the labor and the fruit of their efforts, a testament to Van Gogh famous paintings.')");

        db.execSQL("Insert into VVGPaintings(Id, Title, Image, Description) values('i1', 'The Potato Eaters (1885)', 'internal1', 'With its moody tones and earnest faces, this painting might not be the glitzy dinner party we’re used to, but it’s a hearty serving of reality. Among the banquet of Van Gogh famous paintings, this one might be the most “down-to-earth.”')");
        db.execSQL("Insert into VVGPaintings(Id, Title, Image, Description) values('i2', 'The Bedroom (1888)', 'internal2', 'No need to tiptoe; this room is alive with bold colors and emotion. Painted during his time in the Yellow House in Arles, this isn’t just any bedroom; it’s a portrayal of Vincent’s sanctuary in the realm of Van Gogh’s paintings.')");
        db.execSQL("Insert into VVGPaintings(Id, Title, Image, Description) values('i3', 'The Night Café (1888)', 'internal3', 'Drenched in deep reds and contrasting greens, Van Gogh gives us a late-night dive where the atmosphere buzzes with stories untold and where every pool table and chair seems to whisper tales of nocturnal escapades. This, like many of Van Gogh famous paintings, captures more than the mere visual.')");

        db.execSQL("Insert into VVGPaintings(Id, Title, Image, Description) values('o1', 'Sunflowers (1888)', 'object1', 'This isn’t just a painting; it’s one of Van Gogh’s famous paintings that serve as an emblem of artistic fervor. Bursting with gleaming yellows and deep golden hues, this series stands prominently in the realm of post-impressionism. Created during Van Gogh’s time in Arles, these aren’t your everyday garden sunflowers.')");
        db.execSQL("Insert into VVGPaintings(Id, Title, Image, Description) values('o2', 'Van Gogh’s Chair (1888)', 'object2', 'This seemingly straightforward portrayal of a chair becomes a personal statement, a portrait without a face. With its straw seat, wooden frame, and pipe resting upon it, the chair seems to exude the essence of the artist himself, akin to the depth observed in Van Gogh’s famous artworks.')");
        db.execSQL("Insert into VVGPaintings(Id, Title, Image, Description) values('o3', 'Shoes (1886)', 'object3', 'Worn-out shoes were an unusual choice of subject for a painting. An acquaintance of Van Goghs in Paris described how he bought old work shoes at a flea market. Then he walked through the mud in them until they were filthy. Only then did he feel they were interesting enough to paint. Van Gogh made a number of still lifes of this subject.')");

        db.close();
    }

    public void goToCategories(View view) {
        Intent intent = new Intent(this, CategoriesMenuActivity.class);
        startActivity(intent);
    }
}