package com.ibrahimyousre.resumebuilder.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ibrahimyousre.resumebuilder.R;
import com.ibrahimyousre.resumebuilder.datamodel.ResumeEvent;

import java.util.List;

/**
 * Created by ibrahim on 1/19/18.
 */

abstract public class ResumeEventAdapter<T extends ResumeEvent>
        extends RecyclerView.Adapter<ResumeEventAdapterViewHolder> {
    private List<T> list;
    private ResumeEventOnClickListener mResumeEventOnClickListener;

    public ResumeEventAdapter(@NonNull List<T> list,
                              ResumeEventOnClickListener resumeEventOnClickListener) {
        this.list = list;
        mResumeEventOnClickListener = resumeEventOnClickListener;
    }

    public interface ResumeEventOnClickListener {
        void onClick(int position);
    }

    @Override
    public ResumeEventAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_resume_event, parent, false);
        ResumeEventAdapterViewHolder viewHolder =
                new ResumeEventAdapterViewHolder(itemView, mResumeEventOnClickListener);
        updateViewHolder(viewHolder);
        return viewHolder;
    }

    protected void updateViewHolder(ResumeEventAdapterViewHolder viewHolder) {

    }

    @Override
    public void onBindViewHolder(ResumeEventAdapterViewHolder holder, int position) {
        ResumeEvent event = list.get(position);
        holder.itemView.setTag(position);
        holder.title.setText(event.getTitle());
        holder.detail.setText(event.getDetail());
        holder.subtitle.setText(event.getSubtitle());
        holder.description.setText(event.getDescription());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
