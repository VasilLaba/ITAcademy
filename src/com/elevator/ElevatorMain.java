package com.elevator;

import java.util.LinkedList;

public class ElevatorMain {
    public static void main(String[] args) {
        BuildingWithElevator build = new BuildingWithElevator(4,25);
        User vasil = build.addNewUser("Vasil",10,Direction.UP);
        User ivan = build.addNewUser("Ivan",34,Direction.UP);
        User pol = build.addNewUser("Pol",55,Direction.DOWN);
        build.print();
        build.callElevator(vasil,Direction.UP,22);
        build.print();
        build.callElevator(ivan,Direction.UP,50);
        build.callElevator(pol,Direction.DOWN,22);
    }

}
