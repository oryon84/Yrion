package fr.yrion.yrion;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by oisn on 05/11/2015.
 */
public class RVAdapter extends RecyclerView.Adapter{
    private List<task> mTasks;
    public RVAdapter(List<task> tasks) {
        mTasks= tasks;
    }
    public class myView extends RecyclerView.ViewHolder {
        public View mMainView;
        public TextView mTache;

        public myView(View view) {
            super();
            mMainView = view;

        }

        public TextView getmDate() {
            return mDate;
        }

        public void setmDate(TextView mDate) {
            this.mDate = mDate;
        }

        public TextView getmDesc() {
            return mDesc;
        }

        public void setmDesc(TextView mDesc) {
            this.mDesc = mDesc;
        }

        public TextView getmTache() {
            return mTache;
        }

        public void setmTache(TextView mTache) {
            this.mTache = mTache;
        }

        public TextView mDate;
        public TextView mDesc;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(parent.getContext()).inflate(R.layout.row,parent,false);
        TextView txtName = row.findViewById(R.id.mNom);

        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
