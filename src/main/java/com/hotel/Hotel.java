package com.hotel;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Hotel {

    public static HashMap<String, Integer> HotelNameAndCostMap;
    public static ArrayList<String> HotelName;

    public String hotelName;
    public int weekDayRate;
    public int weekEndRate;
    static int costOfLake;
    static int costOfBridge;
    static int getCostOfRidge;
    static int totalCost;
    int rating;
    static int i = 0;
    public int rewardweekday;
    public int rewardweekend;
    public static HashMap<String, Integer> HotelNameAndRatingMap;

    public static void Display() {
        System.out.println("Welcome to Hostel Reservation System");
    }

    public static String getDayOfWeek(String date) throws ParseException {

        SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy");
        Date dt1 = format1.parse(date);
        DateFormat format2 = new SimpleDateFormat("EE");
        String finalDay = format2.format(dt1);
        return finalDay;
    }

    public Hotel(int rating, String hotelName, int weekDayRate, int weekEndRate, int rewardweekday, int rewardweekend) {
        this.rating = rating;
        this.hotelName = hotelName;
        this.weekDayRate = weekDayRate;
        this.weekEndRate = weekEndRate;
        this.rewardweekday = rewardweekday;
        this.rewardweekend = rewardweekend;
        HotelNameAndCostMap = new HashMap<String, Integer>();
        HotelNameAndRatingMap = new HashMap<>();
        HotelName = new ArrayList<String>();

    }


    //Method to calculate price of each hotel
    public int calculatePrice(ArrayList<String> list, int rewardCustomerOrRegular) throws ParseException {
        Iterator<String> it = list.iterator();
        totalCost = 0;

        if (rewardCustomerOrRegular == 0) {
            while (it.hasNext()) {
                String day = getDayOfWeek(it.next());
                if (day.equals("Sun") || day.equals("Sat"))
                    totalCost += weekEndRate;
                else
                    totalCost += weekDayRate;
            }
        } else {
            while (it.hasNext()) {

                String day = getDayOfWeek(it.next());
                if (day.equals("Sun") || day.equals("Sat"))
                    totalCost += rewardweekend;
                else
                    totalCost += rewardweekday;
            }
        }
        HotelNameAndCostMap.put(hotelName, totalCost);
        HotelNameAndRatingMap.put(hotelName, rating);
        return totalCost;
    }

    //Method to Display hotelnames along with their cost
    public static void DisplayDetails() {
        for (Map.Entry<String, Integer> entry : HotelNameAndCostMap.entrySet()) {
            System.out.println(i);
            i++;
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

    }

    //
//
//Method For Finding cheapest hotel and with best rating in case of a tie
    public static String findCheapestHotel() throws ParseException {


        Integer minCost = HotelNameAndCostMap.entrySet().stream().min(Map.Entry.comparingByValue()).get().getValue();

        ArrayList<String> cheapHotels = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : HotelNameAndCostMap.entrySet()) {
            if (minCost >= entry.getValue()) {

                minCost = entry.getValue();
                cheapHotels.add(entry.getKey());
            }
        }
        System.out.println(cheapHotels);
        String cheapestMostRatedHotelName = HotelNameAndRatingMap.entrySet().stream()
                .filter(p -> cheapHotels.contains(p.getKey()))
                .max(Map.Entry.comparingByValue())
                .get().getKey();
        int maxRating = HotelNameAndRatingMap.entrySet().stream()
                .filter(p -> cheapHotels.contains(p.getKey()))
                .max(Map.Entry.comparingByValue())
                .get().getValue();
        System.out.println("Cheapest and best rated hotel is: " + cheapestMostRatedHotelName + " with rating : " + maxRating);

        return cheapestMostRatedHotelName;

    }

}
