package com.mercari.mercaritest.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mercari.mercaritest.R;
import com.mercari.mercaritest.adapters.MainAdapter;
import com.mercari.mercaritest.base.BaseView;
import com.mercari.mercaritest.data.model.Item;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * The Fragment class of the Main section of this app. Acts as the "dumb view" in the provided
 * MVP architecture.
 */
public class MainFragment extends Fragment implements BaseView {

    private static final String TAG = MainFragment.class.getSimpleName();

    // Argument strings for retrieving passed data from the MainActivity.
    private static final String ARGUMENT_JSON_DATA = "ARGUMENT_JSON_DATA";

    // Number of columns the RecyclerView's LayoutManager should display.
    private static final int GRID_SPAN_COUNT = 3;

    @BindView(R.id.data_recycler_view) RecyclerView mRecyclerView;

    private Unbinder mUnbinder;
    private MainPresenter mPresenter;
    private MainAdapter mAdapter;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = new MainPresenter();
        mPresenter.setItemsResponse(getContext());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        mUnbinder = ButterKnife.bind(this, view);
        mPresenter.attachView(this);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), GRID_SPAN_COUNT);
        mRecyclerView.setLayoutManager(gridLayoutManager);

        mPresenter.updateUI();

        return view;
    }

    @Override
    public void onDestroyView() {
        mPresenter.detachView();
        mUnbinder.unbind();
        super.onDestroyView();
    }

    /**
     * Displays the given list of Items.
     *
     * @param data List of Items to display in the RecyclerView.
     */
    @Override
    public void showItems(List<Item> data) {
        mAdapter = new MainAdapter(getContext(), data);
        mRecyclerView.setAdapter(mAdapter);
    }
}
