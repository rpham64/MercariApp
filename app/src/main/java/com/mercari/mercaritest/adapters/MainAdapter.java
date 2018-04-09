package com.mercari.mercaritest.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mercari.mercaritest.R;
import com.mercari.mercaritest.data.model.Item;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder> {

    private Context mContext;
    private List<Item> mItems;

    public MainAdapter(Context context, List<Item> items) {
        mContext = context;
        mItems = items;
    }

    @Override
    public MainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.view_item, parent, false);
        ButterKnife.bind(this, view);

        return new MainViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MainViewHolder holder, int position) {
        Item item = mItems.get(position);
        holder.bindItem(item);
    }

    @Override
    public int getItemCount() {
        return mItems == null ? 0 : mItems.size();
    }

    class MainViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.item_image_view) ImageView mItemImageView;
        @BindView(R.id.item_sold_out_banner) ImageView mSoldOutImageView;
        @BindView(R.id.item_price) TextView mPriceTextView;
        @BindView(R.id.item_name) TextView mNameTextView;

        public MainViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bindItem(Item item) {
            Glide.with(mContext).load(item.photo).into(mItemImageView);
            mPriceTextView.setText("$" + item.price);
            mNameTextView.setText(item.name);

            if (item.status.equals("sold_out")) {
                // Display sold.png if Item.status equals sold_out.
                mSoldOutImageView.setVisibility(View.VISIBLE);
            } else {
                mSoldOutImageView.setVisibility(View.GONE);
            }
        }
    }
}
