package de.handler.mobile.wikiline;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private WikiSlider wikiSlider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wikiSlider = findViewById(R.id.activity_main_slider);
        wikiSlider.updateDataSet(getWikiLineItems());
    }

    private List<WikiLineItem> getWikiLineItems() {
        return Collections.emptyList();
    }
}
