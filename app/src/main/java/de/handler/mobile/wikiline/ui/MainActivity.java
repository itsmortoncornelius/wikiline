package de.handler.mobile.wikiline.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import de.handler.mobile.wikiline.R;
import de.handler.mobile.wikiline.data.WikiManager;
import de.handler.mobile.wikiline.network.Page;

public class MainActivity extends AppCompatActivity {
    private WikiSlider wikiSlider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wikiSlider = findViewById(R.id.activity_main_slider);
        wikiSlider.updateDataSet(getWikiLineItems());
    }

    @NonNull
    private List<WikiLineItem> getWikiLineItems() {
        // get the pagesDto for a specific search term
        List<Page> pages = WikiManager.INSTANCE.getPages("pizza");
        if (pages != null) {
            return mapToWikiLineItem(pages);
        }
        return Collections.emptyList();
    }

    private List<WikiLineItem> mapToWikiLineItem(@NonNull List<Page> pages) {
        List<WikiLineItem> wikiLineItems = new ArrayList<>();
        for (Page page : pages) {
            WikiLineItem wikiLineItem = new WikiLineItem(page.getTitle(), page.getRevisions().get(0).getContent());
            wikiLineItems.add(wikiLineItem);
        }
        return wikiLineItems;
    }
}
