package com.elevator;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class User {
    private String name;
    private int position;
    private Direction direction;
    private Elevator[] elevators;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public User(String name, int position, Direction direction) {
        setName(name);
        setPosition(position);
        setDirection(direction);
    }

    public void callElevator(int needFloor){
        int i = choiseElevator();
        elevators[i].move(needFloor);
    }

    private int choiseElevator() {
        List<Elevator> list = new ArrayList<>();
        if(direction == Direction.UP){
            for (Elevator el: elevators) {
                if(el.getCurrentPosition() <= position){
                    list.add(el);
                }
            }
        }else if(direction == Direction.DOWN){
            for (Elevator el: elevators) {
                if(el.getCurrentPosition() >= position){
                    list.add(el);
                }
            }
        }

        System.out.println(list);
        return 1;
    }

    public void createElevators(int elevatorsCount) {
        elevators = new  Elevator[elevatorsCount];
        for (int i = 0; i < elevatorsCount; i++){
            elevators[i] = new Elevator(1, 100);
        }
    }

}
enum Direction{
    UP,
    DOWN
}
