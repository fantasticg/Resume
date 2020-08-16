package com.example.heekyungyeom_resume.ui.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.heekyungyeom_resume.R;
import com.example.heekyungyeom_resume.ui.main.SkillsFragment.OnListFragmentInteractionListener;
import com.example.heekyungyeom_resume.ui.main.dummy.EducationContent.EducationItem;
import com.example.heekyungyeom_resume.ui.main.dummy.ExperienceContent;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;


/**
 * {@link RecyclerView.Adapter} that can display a {@link EducationItem} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class ExpRecyclerViewAdapter extends RecyclerView.Adapter<ExpRecyclerViewAdapter.ViewHolder> {

    private final List<ExperienceContent.ExperienceItem> mValues;
    private final OnListFragmentInteractionListener mListener;

    public ExpRecyclerViewAdapter(List<ExperienceContent.ExperienceItem> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.experience_listitem, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        holder.mPeriodView.setText(mValues.get(position).period);
        holder.mCompany.setText(mValues.get(position).company);
        holder.mProject.setText(mValues.get(position).project);
        //holder.mRemarkView.setText(mValues.get(position).remark);


        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mPeriodView;
        public final TextView mCompany;
        public final TextView mProject;
        //public final TextView mRemarkView;
        public EducationItem mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mPeriodView = view.findViewById(R.id.exp_period);
            mCompany = view.findViewById(R.id.exp_company);
            mProject = view.findViewById(R.id.exp_project);
            //mRemarkView = (TextView) view.findViewById(R.id.exp_remark);
        }

    }
}
