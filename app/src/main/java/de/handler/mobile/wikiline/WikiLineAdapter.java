package de.handler.mobile.wikiline;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

class WikiLineAdapter extends RecyclerView.Adapter {
    private final List<WikiLineItem> wikiLineItems = new ArrayList<>();

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new WikiLineViewHolder(inflater.inflate(R.layout.item_wikiline, parent));
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
        WikiLineViewHolder(View itemView) {
            super(itemView);
        }

        void bind(WikiLineItem wikiLineItem) {
            // TODO bind views
        }
    }
}
