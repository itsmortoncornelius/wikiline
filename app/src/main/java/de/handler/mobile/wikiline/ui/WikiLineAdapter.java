package de.handler.mobile.wikiline.ui;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import de.handler.mobile.wikiline.R;

class WikiLineAdapter extends RecyclerView.Adapter {
    private final List<WikiLineItem> wikiLineItems = new ArrayList<>();

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new WikiLineViewHolder(inflater.inflate(R.layout.item_wikiline, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof WikiLineViewHolder) {
            ((WikiLineViewHolder) holder).bind(wikiLineItems.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return wikiLineItems.size();
    }

    /**
     * Call this to add or update data in the list.
     * @param wikiLineItems A list of {@link WikiLineItem}s the adapter's view model
     */
    public void updateDataSet(List<WikiLineItem> wikiLineItems) {
        this.wikiLineItems.clear();
        this.wikiLineItems.addAll(wikiLineItems);
        notifyDataSetChanged();
    }


    /**
     * Defines the list element and how it looks.
     */
    private static class WikiLineViewHolder extends RecyclerView.ViewHolder {
        private final TextView titleTextView;
        private final TextView contentTextView;

        WikiLineViewHolder(View itemView) {
            super(itemView);

            titleTextView = itemView.findViewById(R.id.item_wikiline_title_text_view);
            contentTextView = itemView.findViewById(R.id.item_wikiline_content_text_view);
        }

        void bind(WikiLineItem wikiLineItem) {
            titleTextView.setText(wikiLineItem.title);
            contentTextView.setText(wikiLineItem.content);
        }
    }
}
