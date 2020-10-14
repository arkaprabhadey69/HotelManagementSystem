package com.hotel;


import org.junit.Assert;
import org.junit.Test;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;


public class HotelTest {
    public static HashMap<String, Integer> HotelNameAndRatingMap = new HashMap<>();
    public static HashMap<String, Integer> HotelNameAndCostMap = new HashMap<>();
    Hotel hotel1 = new Hotel(3, "Lakewood", 110, 90, 80, 80);
    Hotel hotel2 = new Hotel(4, "Bridgewood", 150, 50, 110, 50);
    Hotel hotel3 = new Hotel(5, "Ridgewood", 220, 150, 100, 40);


    @Test
    public void given_all_hotel_rates_should_return_true() throws ParseException {

        ArrayList<String> dates = new ArrayList<>();
        dates.add("3/10/2020");
        dates.add("4/10/2020");
        hotel1.calculatePrice(dates, 1);
        hotel2.calculatePrice(dates, 1);
        hotel3.calculatePrice(dates, 1);
        String name = hotel1.findCheapestHotel();
        Assert.assertEquals("Ridgewood", name);


    }

    @Test
    public void given_both_weekend_dates_should_return_true() throws ParseException {

        ArrayList<String> dates = new ArrayList<>();

        dates.add("3/10/2020");
        dates.add("4/10/2020");
        int result = hotel1.calculatePrice(dates, 1);

        Assert.assertEquals(160, result);
    }

    @Test
    public void given_one_weekend_one_weekday_dates_should_return_true() throws ParseException {

        ArrayList<String> dates = new ArrayList<>();

        dates.add("5/10/2020");
        dates.add("4/10/2020");
        int result = hotel2.calculatePrice(dates, 0);

        Assert.assertEquals(200, result);
    }

    @Test
    public void given_one_weekend_one_weekday_dates_should_return_true_rewardee() throws ParseException {

        ArrayList<String> dates = new ArrayList<>();

        dates.add("5/10/2020");
        dates.add("4/10/2020");
        int result = hotel2.calculatePrice(dates, 1);

        Assert.assertEquals(160, result);
    }

    @Test
    public void given_all_hotel_rates_should_return_true_for_weekdays_rewardee() throws ParseException {

        ArrayList<String> dates = new ArrayList<>();
        dates.add("5/10/2020");
        dates.add("6/10/2020");
        hotel1.calculatePrice(dates, 1);
        hotel2.calculatePrice(dates, 1);
        hotel3.calculatePrice(dates, 1);
        String name = hotel1.findCheapestHotel();
        Assert.assertEquals("Lakewood", name);


    }

    @Test
    public void given_all_hotel_rates_should_return_true_for_weekdays_non_rewardee() throws ParseException {

        ArrayList<String> dates = new ArrayList<>();
        dates.add("5/10/2020");
        dates.add("6/10/2020");
        hotel1.calculatePrice(dates, 0);
        hotel2.calculatePrice(dates, 0);
        hotel3.calculatePrice(dates, 0);
        String name = hotel1.findCheapestHotel();
        Assert.assertEquals("Lakewood", name);


    }

    @Test
    public void given_all_hotel_rates_should_return_highest_rating_for_tie() throws ParseException {

        ArrayList<String> dates = new ArrayList<>();
        dates.add("4/10/2020");
        dates.add("5/10/2020");
        hotel1.calculatePrice(dates, 0);
        hotel2.calculatePrice(dates, 0);
        hotel3.calculatePrice(dates, 0);
        String name = hotel1.findCheapestHotel();
        Assert.assertEquals("Bridgewood", name);


    }

    @Test
    public void given_two_or_more_dates_should_return_correct_name() throws ParseException {

        ArrayList<String> dates = new ArrayList<>();
        dates.add("4/10/2020");
        dates.add("5/10/2020");
        dates.add("6/10/2020");
        hotel1.calculatePrice(dates, 0);
        hotel2.calculatePrice(dates, 0);
        hotel3.calculatePrice(dates, 0);
        String name = hotel1.findCheapestHotel();
        Assert.assertEquals("Lakewood", name);


    }


}