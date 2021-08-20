package com.example.myapplication;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.adapter.FilterAdapter;
import com.example.myapplication.adapter.ItemAdapter;
import com.example.myapplication.data.Item;
import com.example.myapplication.databinding.FragmentItemBinding;

public class ItemFragment extends Fragment {
    private FragmentItemBinding binding = null;

    public ItemFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentItemBinding.inflate(getLayoutInflater(), container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initFilterRecyclerView();
        initItemRecyclerView();
    }

    private void initItemRecyclerView() {
        GridLayoutManager gridLayoutManager
                = new GridLayoutManager(requireContext(), 2);
        binding.recyclerItem.setLayoutManager(gridLayoutManager);
        ItemAdapter itemAdapter = new ItemAdapter();
        itemAdapter.addItem(new Item(
                "삼다수/2L/12개", "10,000", 4.8f, "(9999+)",
                getResources().getDrawable(R.drawable.water1)
        ));
        itemAdapter.addItem(new Item(
                "아워홈 지리산수 핑크/2L/12개", "10,000", 4.7f, "(9999+)",
                getResources().getDrawable(R.drawable.water2)
        ));
        itemAdapter.addItem(new Item(
                "삼다수/500ml/12개", "5,000", 4.8f, "(9999+)",
                getResources().getDrawable(R.drawable.water1)
        ));
        itemAdapter.addItem(new Item(
                "아워홈 지리산수 핑크/500ml/30개", "6,500", 4.9f, "(9999+)",
                getResources().getDrawable(R.drawable.water2)
        ));
        binding.recyclerItem.setAdapter(itemAdapter);
    }

    private void initFilterRecyclerView() {
        // 1 종류
        LinearLayoutManager layoutManager1
                = new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false);
        binding.recyclerType.setLayoutManager(layoutManager1);
        FilterAdapter typeAdapter = new FilterAdapter();
        typeAdapter.addItem("생수");
        typeAdapter.addItem("해양 심층수");
        binding.recyclerType.setAdapter(typeAdapter);


        // 2 개당 용량
        LinearLayoutManager layoutManager2
                = new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false);
        binding.recyclerCapacity.setLayoutManager(layoutManager2);
        FilterAdapter capacityAdapter = new FilterAdapter();
        capacityAdapter.addItem("500ml");
        capacityAdapter.addItem("2L");
        binding.recyclerCapacity.setAdapter(capacityAdapter);

        // 3 총 수량
        LinearLayoutManager layoutManager3
                = new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false);
        binding.recyclerAmount.setLayoutManager(layoutManager3);
        FilterAdapter amountAdapter = new FilterAdapter();
        amountAdapter.addItem("6개 이하");
        amountAdapter.addItem("6~12개");
        amountAdapter.addItem("12~18개");
        amountAdapter.addItem("18~24개");
        amountAdapter.addItem("24~40개");
        binding.recyclerAmount.setAdapter(amountAdapter);

        // 4 도몰 랭킹 순
        LinearLayoutManager layoutManager4
                = new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false);
        binding.recyclerSort.setLayoutManager(layoutManager4);
        FilterAdapter sortAdapter = new FilterAdapter();
        sortAdapter.addItem("낮은 가격 순");
        sortAdapter.addItem("높은 가격 순");
        sortAdapter.addItem("판매량 순");
        sortAdapter.addItem("최신 순");
        binding.recyclerSort.setAdapter(sortAdapter);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}