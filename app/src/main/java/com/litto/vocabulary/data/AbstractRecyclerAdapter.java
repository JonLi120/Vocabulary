package com.litto.vocabulary.data;

import android.support.v7.widget.RecyclerView;

public abstract class AbstractRecyclerAdapter<VH extends RecyclerView.ViewHolder>
        extends RecyclerView.Adapter<VH> {
    /**
     * Return a {@link Vocabulary} represented by this item in the adapter.
     *
     * @param position Adapter item position
     *
     * @return A new {@link Vocabulary} filled with this position's attributes.
     *
     * @throws IllegalArgumentException if position is out of the adapter's bounds.
     */
    public abstract Vocabulary getItem(int position);
}
