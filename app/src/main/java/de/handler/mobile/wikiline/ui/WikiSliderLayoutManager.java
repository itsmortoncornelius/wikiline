package de.handler.mobile.wikiline.ui;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSmoothScroller;
import android.support.v7.widget.RecyclerView;

public class WikiSliderLayoutManager extends LinearLayoutManager {
    private final CenterSmoothScroller smoothScroller;

    WikiSliderLayoutManager(Context context) {
        super(context, LinearLayoutManager.HORIZONTAL, false);

        smoothScroller = new CenterSmoothScroller(context);
    }

    @Override
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int position) {
        smoothScroller.setTargetPosition(position);
        startSmoothScroll(smoothScroller);
    }


    private static class CenterSmoothScroller extends LinearSmoothScroller {
        CenterSmoothScroller(Context context) {
            super(context);
        }

        @Override
        public int calculateDtToFit(int viewStart, int viewEnd, int boxStart, int boxEnd, int snapPreference) {
            return boxStart + (boxEnd - boxStart) / 2 - (viewStart + (viewEnd - viewStart) / 2);
        }
    }
}
