package com.example.heekyungyeom_resume.ui.main;

import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.heekyungyeom_resume.R;
import com.example.heekyungyeom_resume.ui.main.SkillsFragment.OnListFragmentInteractionListener;
import com.example.heekyungyeom_resume.ui.main.dummy.EducationContent.EducationItem;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link EducationItem} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class EduRecyclerViewAdapter extends RecyclerView.Adapter<EduRecyclerViewAdapter.ViewHolder> {

    private final List<EducationItem> mValues;
    private final OnListFragmentInteractionListener mListener;

    public EduRecyclerViewAdapter(List<EducationItem> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.education_listitem, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        holder.mItem = mValues.get(position);
        holder.mPeriodView.setText(mValues.get(position).period);
        holder.mSchoolNameView.setText(mValues.get(position).schoolname);
        holder.mMajorView.setText(mValues.get(position).major);
        holder.mGPAView.setText(mValues.get(position).gpa);
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
        public final TextView mSchoolNameView;
        public final TextView mMajorView;
        public final TextView mGPAView;
        //public final TextView mRemarkView;
        public EducationItem mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mPeriodView = (TextView) view.findViewById(R.id.edu_period);
            mSchoolNameView = (TextView) view.findViewById(R.id.edu_school_name);
            mMajorView = (TextView) view.findViewById(R.id.edu_major);
            mGPAView = (TextView) view.findViewById(R.id.edu_gpa);
            //mRemarkView = (TextView) view.findViewById(R.id.remark);
        }

    }
}
