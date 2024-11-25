
package com.example.paytrack;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;
import java.util.List;

public class StatsFragment extends Fragment {


    PieChart pieChart;
    BarChart barChart;
    public StatsFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_stats, container, false);

        // Initialize PieChart and BarChart
        pieChart = view.findViewById(R.id.pieChart);
        barChart = view.findViewById(R.id.barChart);

        // Setup Pie Chart
        setupPieChart();

        // Setup Bar Chart
        setupBarChart();

        return view;
    }

    private void setupPieChart() {
        List<PieEntry> pieEntries = new ArrayList<>();
        pieEntries.add(new PieEntry(40, "Food"));
        pieEntries.add(new PieEntry(20, "Transport"));
        pieEntries.add(new PieEntry(15, "Shopping"));
        pieEntries.add(new PieEntry(25, "Utilities"));

        PieDataSet dataSet = new PieDataSet(pieEntries, "Expense Categories");
        dataSet.setColors(new int[]{Color.BLUE, Color.RED, Color.GREEN, Color.YELLOW});
        dataSet.setValueTextColor(Color.WHITE);
        dataSet.setValueTextSize(12f);

        PieData data = new PieData(dataSet);

        pieChart.setData(data);
        pieChart.setUsePercentValues(true);
        pieChart.setDrawHoleEnabled(true);
        pieChart.setHoleColor(Color.TRANSPARENT);
        pieChart.setTransparentCircleRadius(50f);
        pieChart.animateY(1000);

        Description description = new Description();
        description.setText("Expense Breakdown");
        pieChart.setDescription(description);

        pieChart.invalidate(); // Refresh the chart
    }

    private void setupBarChart() {
        List<BarEntry> barEntries = new ArrayList<>();
        barEntries.add(new BarEntry(1, 5000)); // January
        barEntries.add(new BarEntry(2, 7000)); // February
        barEntries.add(new BarEntry(3, 6000)); // March
        barEntries.add(new BarEntry(4, 8000)); // April

        BarDataSet dataSet = new BarDataSet(barEntries, "Monthly Expenses");
        dataSet.setColors(Color.CYAN);
        dataSet.setValueTextColor(Color.BLACK);
        dataSet.setValueTextSize(12f);

        BarData data = new BarData(dataSet);
        barChart.setData(data);

        Description description = new Description();
        description.setText("Monthly Expense Comparison");
        barChart.setDescription(description);

        barChart.setFitBars(true); // Make the bars fit into the chart
        barChart.animateY(1000);

        barChart.invalidate(); // Refresh the chart
    }
}