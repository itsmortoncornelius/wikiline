package de.handler.mobile.wikiline;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import java.util.List;

public class WikiSlider extends FrameLayout {
    private RecyclerView recyclerView;

    public WikiSlider(Context context) {
        this(context, null);
    }

    public WikiSlider(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public WikiSlider(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public void updateDataSet(List<WikiLineItem> wikiLineItems) {
        ((WikiLineAdapter) recyclerView.getAdapter()).updateDataSet(wikiLineItems);
    }

    private void init() {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.view_wiki_slider, this, false);
        recyclerView = view.findViewById(R.id.view_wiki_slider_recycler_view);
        recyclerView.setAdapter(new WikiLineAdapter());
        recyclerView.setLayoutManager(new WikiSliderLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);
    }
}
