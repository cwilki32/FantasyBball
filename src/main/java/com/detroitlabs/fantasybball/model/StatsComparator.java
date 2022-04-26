package com.detroitlabs.fantasybball.model;

import com.detroitlabs.fantasybball.data.DailyStatRepository;

import java.util.Comparator;

public class StatsComparator implements Comparator<DailyStatsObject> {

    public int compare(DailyStatsObject o1, DailyStatsObject o2) {
        if (o1.getPts() == o1.getPts())
            return 0;
        else if (o1.getPts() > o2.getPts())
            return 1;
        else
            return -1;
        }
    }
