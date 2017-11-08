package app.google.shahshail.jokeandoidlibrary;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class DisplayJokeActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_joke);
        String joke = getIntent().getStringExtra("joke_service");
        TextView textViewJoke = (TextView) findViewById(R.id.tv_joke_display);
        textViewJoke.setText(joke);
}
}