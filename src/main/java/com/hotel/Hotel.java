package com.hotel;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

public class Hotel {
    public  String hotelname;
    public  int weekdayrate;
    public  int weekendrate;
    static  int costofLake;
    static  int costofBridge;
    static int  getCostofRidge;
    int rating;

    public static void Display()
    {
        System.out.println("Welcome to Hostel Reservation System");
    }
  public static String getDayofWeek(String date) throws ParseException {

      SimpleDateFormat format1=new SimpleDateFormat("dd/MM/yyyy");
      Date dt1=format1.parse(date);
      DateFormat format2=new SimpleDateFormat("EE");
      String finalDay=format2.format(dt1);
      return  finalDay;
  }
    public Hotel(int rating,String hotelname,int weekdayrate, int weekendrate) {
        this.rating=rating;
        this.hotelname = hotelname;
        this.weekdayrate=weekdayrate;
        this.weekendrate=weekendrate;
    }
    public static int min(int cost1,int cost2,int cost3)
    {
        if(cost1<cost2&&cost1<cost3) {


            return cost1;
        }
        else if(cost2<cost1&&cost2<cost3) {

            return cost2;
        }
        else if(cost3<cost1&&cost3<cost2)
        {

            return cost3;
        }
        else if(cost1==cost2) {

            return cost2;
        }
        else if(cost2==cost3) {

            return cost3;


        }
        else

            return cost3;

    }
    public String calculateprice(ArrayList<String> list, int flag) throws ParseException {
        Iterator<String > it= list.iterator();
        if(flag==0) {
            while (it.hasNext()) {
                String day = getDayofWeek(it.next());
                if (day.equals("Sun") || day.equals("Sat")) {
                    costofLake += 90;
                    costofBridge += 50;
                    getCostofRidge += 150;
                } else {
                    costofLake += 110;
                    costofBridge += 150;
                    getCostofRidge += 220;
                }
            }
        }
        else
        {
            while (it.hasNext()) {
                String day = getDayofWeek(it.next());
                if (day.equals("Sun") || day.equals("Sat")) {
                    costofLake += 80;
                    costofBridge += 50;
                    getCostofRidge += 40;
                } else {
                    costofLake += 80;
                    costofBridge += 110;
                    getCostofRidge += 100;
                }
            }
        }
        int result=min(costofLake,costofBridge,getCostofRidge);
        if(result==costofLake) {
            System.out.println("Cost is: " + result);
            return "Lakewood";
        }
        else if(result==costofBridge) {
            System.out.println("Cost is: " + result);
            return "Bridgewood";
        }
        else {
            System.out.println("Cost is: " + result);
            return "Ridgewood";
        }


    }


    public static void main(String[] args) throws ParseException {
      Hotel h1= new Hotel(3,"Lakewood",110,90);
        Hotel h2= new Hotel(4,"Bridgewood",150,50);
        Hotel h3= new Hotel(5,"Ridgewood",220,150);
        ArrayList<String> dates=new ArrayList<>();

        dates.add("3/10/2020");
        dates.add("4/10/2020");


        int rewardee;
        System.out.println("Enter whether rewardee or not: ");
        Scanner s= new Scanner(System.in);
        rewardee=s.nextInt();
        String result=h1.calculateprice(dates,rewardee);



        System.out.println("Cheapest hotel: "+result);


    }
}
