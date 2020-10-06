package com.hotel;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.*;

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
    static  int i=0;
    public int rewardweekday;
    public int rewardweekend;
    public static HashMap<String,Integer> HotelNameAndRatingMap;

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

    public Hotel(int rating, String hotelName, int weekDayRate, int weekEndRate,int rewardweekday,int rewardweekend) {
        this.rating = rating;
        this.hotelName = hotelName;
        this.weekDayRate = weekDayRate;
        this.weekEndRate = weekEndRate;
        this.rewardweekday=rewardweekday;
        this.rewardweekend=rewardweekend;
        HotelNameAndCostMap = new HashMap<String, Integer>();
        HotelNameAndRatingMap= new HashMap<>();
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
        HotelNameAndRatingMap.put(hotelName,rating);
        return totalCost;
    }
    //Method to Display hotelnames along with their cost
    public static void DisplayDetails()
    {
        for (Map.Entry<String, Integer> entry : HotelNameAndCostMap.entrySet()) {
            System.out.println(i);
            i++;
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

    }
//Method For Finding cheapest hotel and with best rating in case of a tie
    public static String findCheapestHotel() throws ParseException{



        Integer minCost= HotelNameAndCostMap.entrySet().stream().min(Map.Entry.comparingByValue()).get().getValue();

        ArrayList<String>cheapHotels = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : HotelNameAndCostMap.entrySet()) {
            if (minCost >= entry.getValue()) {

                minCost = entry.getValue();
                cheapHotels.add(entry.getKey());
            }
        }
        System.out.println(cheapHotels);
        int maxRating = -1;
        String cheapestMostRatedHotelName = "";
        for (int i = 0; i < cheapHotels.size(); i++){

            if(HotelNameAndRatingMap.get(cheapHotels.get(i))>maxRating) {
                maxRating = HotelNameAndRatingMap.get(cheapHotels.get(i));
                cheapestMostRatedHotelName = cheapHotels.get(i);
                // System.out.println(maxRating+" "+cheapestMostRatedHotelName);
            }
        }
        System.out.println("Cheapest and best rated hotel is: "+cheapestMostRatedHotelName+" with rating : "+maxRating);

        return cheapestMostRatedHotelName;

    }


    public static void main(String[] args) throws ParseException {

        Hotel h1 = new Hotel(3, "Lakewood", 110, 90,80,80);
        Hotel h2 = new Hotel(4, "Bridgewood", 150, 50,110,50);
        Hotel h3 = new Hotel(5, "Ridgewood", 220, 150,100,40);
        ArrayList<String> dates = new ArrayList<>();
        dates.add("6/10/2020");

        dates.add("5/10/2020");
        dates.add("4/10/2020");
        int rewardCustomerOrRegular;

        System.out.println("Enter whether a Loyalty Customer or Not\n 0 for NO 1 for YES: ");
        Scanner s = new Scanner(System.in);
        rewardCustomerOrRegular = s.nextInt();

        h1.calculatePrice(dates, rewardCustomerOrRegular);
        h2.calculatePrice(dates, rewardCustomerOrRegular);
        h3.calculatePrice(dates, rewardCustomerOrRegular);
        DisplayDetails();




       findCheapestHotel();



        }
    }
