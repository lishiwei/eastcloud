package com.orientalfinance.eastcloud.adapter;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.orientalfinance.BR;
import com.orientalfinance.R;
import com.orientalfinance.databinding.ItemSearchResultBinding;
import com.orientalfinance.eastcloud.module.javabean.SearchResult;

import java.util.List;

/**
 * Created by 29435 on 2017/6/23.
 */

public class SearchResultRvAdapter extends RecyclerView.Adapter<SearchResultRvAdapter.SearchedResultViewHolder> {
    List<SearchResult> mSearchResults;

    public SearchResultRvAdapter(List<SearchResult> SearchResults) {
        mSearchResults = SearchResults;
    }

    @Override
    public SearchedResultViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemSearchResultBinding itemSearchBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_search_result, null, false);
        SearchedResultViewHolder searchedResultViewHolder = new SearchedResultViewHolder(itemSearchBinding.getRoot());
        searchedResultViewHolder.setItemSearchBinding(itemSearchBinding);
        return searchedResultViewHolder;
    }

    public void setSearchResults(List<SearchResult> SearchResults) {
        mSearchResults = SearchResults;
    }

    @Override
    public void onBindViewHolder(SearchedResultViewHolder holder, int position) {
        holder.mItemSearchBinding.setVariable(BR.searchResult, mSearchResults.get(position));
    }

    @Override
    public int getItemCount() {
        return mSearchResults.size();
    }

    public static class SearchedResultViewHolder extends RecyclerView.ViewHolder {
        public SearchedResultViewHolder(View itemView) {
            super(itemView);
        }

        ItemSearchResultBinding mItemSearchBinding;

        public void setItemSearchBinding(ItemSearchResultBinding itemSearchBinding) {
            mItemSearchBinding = itemSearchBinding;
        }
    }
}
