package com.example.myapplication;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.data.Item;
import com.example.myapplication.databinding.FragmentItemDetailsBinding;

public class ItemDetailsFragment extends Fragment {

    private Item item;
    private FragmentItemDetailsBinding binding = null;

    public ItemDetailsFragment(Item item) {
        // Required empty public constructor
        this.item = item;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentItemDetailsBinding.inflate(getLayoutInflater(), container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initListener();
        removeBottomView();
    }

    private void attachBottomView() {
        ((MainActivity)getActivity()).getNav().setVisibility(View.VISIBLE);
    }

    private void removeBottomView() {
        ((MainActivity)getActivity()).getNav().setVisibility(View.GONE);
    }

    private void initListener() {
        binding.backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });
        binding.homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).fragmentTranslation(
                        new HomeFragment(), false
                );
            }
        });
    }

    private void initData() {
        binding.title.setText(item.getTitle());
        binding.price.setText(item.getPrice());
        binding.rating.setText(String.valueOf(item.getRating()));
        binding.imageView.setImageDrawable(item.getImage());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        attachBottomView();
        binding = null;
    }
}