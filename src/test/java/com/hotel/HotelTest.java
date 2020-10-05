package com.hotel;

//import static com.hotel.Hotel.calculateprice;
import static org.junit.Assert.*;
import org.junit.Assert;
import org.junit.Test;

import java.text.ParseException;
import java.util.ArrayList;


public class HotelTest {
    Hotel h= new Hotel(1,"BridgeWood",100,200);
    @Test
    public void given_both_weekend_dates_should_return_true() throws ParseException {
        Hotel h1= new Hotel(1,"BridgeWood",100,200);
        ArrayList<String> dates=new ArrayList<>();
        dates.add("4/10/2020");
        dates.add("3/10/2020");
        String result=h.calculateprice(dates,0);
        Assert.assertEquals("Bridgewood",result);

    }

    @Test
    public void given_both_weekday_dates_should_return_true() throws ParseException {
        ArrayList<String> dates=new ArrayList<>();
        dates.add("5/10/2020");
        dates.add("6/10/2020");
        String result=h.calculateprice(dates,0);
        Assert.assertEquals("Lakewood",result);

    }
    @Test
    public void given_one_weekday_one_weekend_dates_should_return_true() throws ParseException {
        ArrayList<String> dates=new ArrayList<>();
        dates.add("4/10/2020");
        dates.add("5/10/2020");
        String result=h.calculateprice(dates,0);
        Assert.assertEquals("Lakewood",result);

    }
    @Test
    public void given_rewardee_dates_should_return_true() throws ParseException {

        ArrayList<String> dates=new ArrayList<>();
        dates.add("8/10/2020");
        dates.add("9/10/2020");
        //dates.add("9/10/2020");
        String result=h.calculateprice(dates,1);
        Assert.assertEquals("Lakewood",result);

    }
    @Test
    public void given_rewardee_dates_weekend_should_return_true() throws ParseException {

        ArrayList<String> dates=new ArrayList<>();
        dates.add("10/10/2020");
        dates.add("11/10/2020");
        //dates.add("9/10/2020");
        String result=h.calculateprice(dates,1);
        Assert.assertEquals("Ridgewood",result);

    }
    @Test
    public void given_rewardee_dates_one_weekend_one_weekday_should_return_true() throws ParseException {

        ArrayList<String> dates=new ArrayList<>();
        dates.add("10/10/2020");
        dates.add("9/10/2020");
        //dates.add("9/10/2020");
        String result=h.calculateprice(dates,1);
        Assert.assertEquals("Ridgewood",result);

    }



}