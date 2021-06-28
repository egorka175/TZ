package com.tms.TZ;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        Scanner sc2= new Scanner(System.in);
        Scanner sc3= new Scanner(System.in);
        Scanner sc4= new Scanner(System.in);
        System.out.println("___________________________________________________________________________");
        System.out.println("Введите количество пассажиров: ");
        System.out.println("___________________________________________________________________________");
        int  numberOfPassengers=sc.nextInt();
        System.out.println("___________________________________________________________________________");
        System.out.println("Введите массу груза: ");
        int weightOfCargo=sc2.nextInt();
        System.out.println("___________________________________________________________________________");
        System.out.println("Введите  город , из которого  желаете произвести доставку.");
        String cityFrom = sc3.nextLine();
        System.out.println("___________________________________________________________________________");
        System.out.println("Введите город ,в который желаете произвести доставку.");
        String cityWhereTo=sc4.nextLine();
        Test t=new Test();
        System.out.println("Расстояние между городами: "+t.distanceCalculate(cityFrom,cityWhereTo)+"(км)");
        System.out.println(t.bestTypeTransport(cityFrom,cityWhereTo,numberOfPassengers,weightOfCargo));
        System.out.println();
    }
}
