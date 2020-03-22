package com.company;

public class Main {

    public static void main(String[] args) {
        /*Car car1 = new Car(90, 1,1, 20);
        Car car2 = new Car(20, 2,2, 50);
        Road road = new Road(2, 15);
        car1.twoCarsCheck(car2, road);*/

        automateTest();
    }

    public static void automateTest() {
        Road road;
        Car car;

        for(int v0 = 20; v0 <=80; v0+=10)
        {
            for(int x0 = 10; x0<=150; x0+=10)
            {
                for(int t=2; t<=5; t++)
                {
                    for(int dS =5; dS <=20; dS+=5)
                    {
                        for(int ap=1; ap<=3; ap++)
                        {
                            for(int an=1; an<=3; an++)
                            {
                                road = new Road(t,dS);
                                car = new Car(v0, ap, an, x0);
                                test(car, road);
                                // testSpeed50to100(car, road);
                                // Task 5
                            }
                        }
                    }
                }
            }
        }
    }

    public static boolean test(Car car, Road road) {
        int dt = road.getDt();
        int ds = road.getDs();

        if (dt * car.getV0() * 1000 / 3600 >= car.getX0() + ds) {
            System.out.println("v0:" + car.getV0() + " x0:" + car.getX0() + " t:" + dt + " s:" + ds + " ap:" + car.getAp() + " na:" + car.getAn() + " Car should not accelerate, it will cross the line");
            return true;
        }else if (dt * car.getV0() * 1000 / 3600 + car.getAp() * dt * dt / 2 >= car.getX0() + ds) {
            System.out.println("v0:" + car.getV0() + " x0:" + car.getX0() + " t:" + dt + " s:" + ds + " ap:" + car.getAp() + " na:" + car.getAn() + " Car should accelerate");
            return true;
        }else if (dt * car.getV0() * 1000 / 3600 - car.getAn() * dt * dt / 2 <= car.getX0()) {
            System.out.println("v0:" + car.getV0() + " x0:" + car.getX0() + " t:" + dt + " s:" + ds + " ap:" + car.getAp() + " na:" + car.getAn() + " Car should stop");
            return false;
        }else {
            System.out.println("v0:" + car.getV0() + " x0:" + car.getX0() + " t:" + dt + " s:" + ds + " ap:" + car.getAp() + " na:" + car.getAn() + " No solution!");
            return false;
        }
    }

    public static boolean testSpeed50to100(Car car, Road road){
        int dt = road.getDt();
        int ds = road.getDs();



        if(dt*car.getV0()*1000/3600 >= car.getX0() +ds && 50*1000/3600 < car.getV0() *1000/3600 && car.getV0() *1000/3600 < 100*1000/3600)
        {
            System.out.println("v0:" + car.getV0() + " x0:" + car.getV0() + " t:" + dt + " s:" + ds + " ap:" + car.getAp() + " na:" + car.getAn() + " Car should accelerate");
            return true;
        }else if (dt*car.getV0() *1000/3600 + car.getAp() *dt*dt/2 >= car.getX0() +ds && 50*1000/3600 < car.getV0() *1000/3600+ car.getAp() *dt/2 && car.getV0() *1000/3600+ car.getV0() *dt/2 < 100*1000/3600)
        {
            System.out.println("v0:" + car.getV0() + " x0:" + car.getX0() + " t:" + dt + " s:" + ds + " ap:" + car.getAp() + " na:" + car.getAn() + " Car should not accelerate, it will cross the line");
            return true;
        }else if (dt*car.getV0() *1000/3600 - car.getAn() *dt*dt/2 <= car.getX0())
        {
            System.out.println("v0:" + car.getV0() + " x0:" + car.getX0() + " t:" + dt + " s:" + ds + " ap:" + car.getAp() + " na:" + car.getAn() + " Car should stop");
            return false;
        }
        else
        {
            System.out.println("v0:" + car.getV0() + " x0:" + car.getX0() + " t:" + dt + " s:" + ds + " ap:" + car.getAp() + " na:" + car.getAn() + " No solution!");
            return false;
        }
    }

    public void testTwoCars(Car car1, Car car2, Road road) {
        int t = road.getDt();
        int s = road.getDs();
        int an1 = car1.getAn();
        int ap1 = car2.getAp();
        int an2 = car2.getAn();
        int ap2 = car2.getAp();
        int x0 = car1.getX0();
        int d = car2.getX0() - x0;

        if (t * car1.getV0() * 1000 / 3600 >= x0 + s) {
            if (t * car2.getV0() * 1000 / 3600 >= d + x0 + s && t * car2.getV0() * 1000 / 3600 < t * car1.getV0() * 1000 / 3600 + d)
                System.out.println("Both cars should not accelerate");
            else if (t * car2.getV0() * 1000 / 3600 - an2 * t * t / 2 <= d + x0 && t * car2.getV0() * 1000 / 3600 - an2 * t * t / 2 < t * car1.getV0() * 1000 / 3600 + d)
                System.out.println("First car should not accelerate, it will cross the line. Second car should stop");
            else if (t * car2.getV0() * 1000 / 3600 + ap2 * t * t / 2 >= d + x0 + s && t * car2.getV0() * 1000 / 3600 + ap2 * t * t / 2 < t * car1.getV0() * 1000 / 3600 + d)
                System.out.println("First car should not accelerate, it will cross the line. Second car should accelerate, it will cross the line");
            else
                System.out.println("No solution");
        } else if (t * car1.getV0() * 1000 / 3600 + ap1 * t * t / 2 >= x0 + s) {
            if (t * car2.getV0() * 1000 / 3600 >= d + x0 + s && t * car2.getV0() * 1000 / 3600 < t * car1.getV0() * 1000 / 3600 + ap1 * t * t / 2 + d)
                System.out.println("First car should accelerate. Second car should not accelerate, it will cross the line.");
            else if (t * car2.getV0() * 1000 / 3600 - an2 * t * t / 2 <= d + x0 && t * car2.getV0() * 1000 / 3600 - an2 * t * t / 2 < t * car1.getV0() * 1000 / 3600 + ap1 * t * t / 2 + d)
                System.out.println("First car should accelerate, it will cross the line. Second car should stop");
            else if (t * car2.getV0() * 1000 / 3600 + ap2 * t * t / 2 >= d + x0 + s && t * car2.getV0() * 1000 / 3600 + ap2 * t * t / 2 < t * car1.getV0() * 1000 / 3600 + ap1 * t * t / 2 + d)
                System.out.println("First car should accelerate, it will cross the line. Second car should accelerate");
            else
                System.out.println("No solution");
        } else if (t * car1.getV0() * 1000 / 3600 - an1 * t * t / 2 <= x0) {
            if (t * car2.getV0() * 1000 / 3600 - an2 * t * t / 2 <= d + x0 && t * car2.getV0() * 1000 / 3600 - an2 * t * t / 2 < t * car1.getV0() * 1000 / 3600 - an1 * t * t / 2 + d)
                System.out.println("Both cars should stop");
            else
                System.out.println("No solution.");
        }
    }




}