package com.example.heekyungyeom_resume.ui.main;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.heekyungyeom_resume.R;
import com.example.heekyungyeom_resume.ui.main.dummy.EducationContent;
import com.example.heekyungyeom_resume.ui.main.dummy.EducationContent.EducationItem;
import com.example.heekyungyeom_resume.ui.main.dummy.ExperienceContent;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class SkillsFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private OnListFragmentInteractionListener mListener;

    private final FirebaseFirestore db = FirebaseFirestore.getInstance();
    private final FirebaseStorage storage = FirebaseStorage.getInstance();

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public SkillsFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static SkillsFragment newInstance(int columnCount) {
        SkillsFragment fragment = new SkillsFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_skills, container, false);

        load_database();
        load_storage();

        return view;
    }

    private void load_database() {
        db.collection("education")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                EducationContent.addItem(EducationContent.createDummyItem(document.getId(),
                                        document.getString("period"),
                                        document.getString("school_name"),
                                        document.getString("major"),
                                        document.getString("gpa"),
                                        document.getString("remark")));
                            }

                            setEduAdapter(getView().findViewById(R.id.education_list));

                        } else {
                            Log.w("hkyeom", "Error getting documents.", task.getException());
                        }
                    }
                });
    }

    private void load_storage() {

        StorageReference storageRef = storage.getReference();
        StorageReference csvRef = storageRef.child("resueme_experience.csv");

        try {
            File localFile = File.createTempFile("resume_experience", ".csv");
            final String filePath = localFile.getAbsolutePath();
            csvRef.getFile(localFile).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                    try {
                        InputStream inStream = new FileInputStream(filePath);
                        BufferedReader reader = new BufferedReader(new InputStreamReader(inStream, "MS949"));
                        String csvLine;
                        int i=0;
                        while((csvLine = reader.readLine()) != null) {
                            String[] row = csvLine.split(",");
                            ExperienceContent.addItem(ExperienceContent.createDummyItem(String.valueOf(i++), row[0], row[1], row[2], (row.length > 3? row[3] : "")));
                        }

                        setExpAdapter(getView().findViewById(R.id.expereance_list));

                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    e.printStackTrace();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    private void setEduAdapter(View view) {
        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
            recyclerView.setAdapter(new EduRecyclerViewAdapter(EducationContent.ITEMS, mListener));
        }
    }

    private void setExpAdapter(View view) {
        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
            recyclerView.setAdapter(new ExpRecyclerViewAdapter(ExperienceContent.ITEMS, mListener));
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        void onListFragmentInteraction(EducationItem item);
    }
}
