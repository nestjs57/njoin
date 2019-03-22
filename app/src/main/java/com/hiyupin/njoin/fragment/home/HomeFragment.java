package com.hiyupin.njoin.fragment.home;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.agrawalsuneet.dotsloader.loaders.LazyLoader;
import com.hiyupin.njoin.R;
import com.hiyupin.njoin.pojo.home.ProductModel;
import com.hiyupin.njoin.pojo.home.RootProductModel;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements HomeContract.homeView {

    private RecyclerView recyclerView;
    private LazyLoader progress;
    private ArrayList<ProductModel> dataSet;
    private HomeAdapter adapter;
    private LinearLayoutManager mLayoutManager;

    private HomePresenter homePresenter;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        homePresenter = new HomePresenter(this);
        homePresenter.getItem();

        recyclerView = (RecyclerView) view.findViewById(R.id.rvProduct);
        progress = (LazyLoader) view.findViewById(R.id.progress);
//        dataSet = new ArrayList<ProductModel>();

        return view;
    }

    @Override
    public void showLoading() {

//        progress.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        progress.setVisibility(View.GONE);
    }

    @Override
    public void sendDataToRecyclerview(@NotNull ArrayList<RootProductModel> mData) {
        adapter = new HomeAdapter(mData);

        mLayoutManager = new LinearLayoutManager(getActivity());

//        mLayoutManager.setReverseLayout(true);
//        mLayoutManager.scrollToPositionWithOffset(0, 0);

//        mLayoutManager.setStackFromEnd(true);
        recyclerView.setLayoutManager(mLayoutManager);

        recyclerView.setAdapter(adapter);

    }
}
