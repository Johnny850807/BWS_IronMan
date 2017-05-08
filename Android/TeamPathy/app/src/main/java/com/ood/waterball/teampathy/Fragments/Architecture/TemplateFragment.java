package com.ood.waterball.teampathy.Fragments.Architecture;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



public abstract class TemplateFragment extends InsideFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(getLayoutResource(), container, false);
    }

    protected abstract int getLayoutResource();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        onFetchData(getArguments());
    }

    @Override
    public void onViewCreated(final View view, @Nullable final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        onFindViews(view);
        onControlViews();
    }

    protected abstract void onFetchData(@Nullable Bundle arguBundle);
    protected abstract void onFindViews(View parentView);
    protected abstract void onControlViews();
}
