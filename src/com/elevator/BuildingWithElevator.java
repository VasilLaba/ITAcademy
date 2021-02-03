package com.elevator;

import java.util.Arrays;
import java.util.LinkedList;

public class BuildingWithElevator {
    private int elevatorsCount;
    private int floor;
    private Elevator[] elevators;
    LinkedList<User> userCount = new LinkedList<User>();

    public int getElevatorsCount() {
        return elevatorsCount;
    }

    public void setElevatorsCount(int elevatorsCount) {
        if(elevatorsCount > 0){
            this.elevatorsCount = elevatorsCount;
        }
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public BuildingWithElevator(int elevatorsCount, int floor) {
        setElevatorsCount(elevatorsCount);
        setFloor(floor);
        createElevators(elevatorsCount);
    }

    public void createElevators(int elevatorsCount) {
        elevators = new  Elevator[elevatorsCount];
        for (int i = 0; i < elevatorsCount; i++){
            elevators[i] = new Elevator(1, floor);
            elevators[i].setId(i);
        }
    }

    public User addNewUser(String name, int position, Direction direction){
        User user = new User(name, position, direction);
        userCount.add(user);
        return user;
    }

    public void print(){
        System.out.println("Build have " + elevatorsCount + " elevators.");
        for (int i = 0; i < elevatorsCount; i++){
            System.out.println("\tElevator № " + (i+1) + " is located on " + elevators[i].getCurrentPosition() );
        }
        System.out.println("In the building is " + userCount.size() + " user.");
        for (User user: userCount) {
            System.out.println("\tUser " + user.getName() + " is located on " + user.getPosition());
        }
    }

    public void callElevator(User user,Direction direction, int floor){
        user.setDirection(direction);
        int elevatorNumber = chooseElevator(user.getPosition(),floor, direction);
        elevators[elevatorNumber].move(user.getPosition());
        elevators[elevatorNumber].move(floor);
        user.setPosition(floor);
        System.out.println("User " + user.getName() + " call elevator № " + (elevatorNumber + 1) + ", and go to " + floor + " floor." );
    }

    private int chooseElevator(int userPosition, int floor, Direction direction) {
        LinkedList<Elevator> elevatorLinkedList = new LinkedList<Elevator>();
        if (direction == Direction.UP){
            for (Elevator elevator: elevators){
                if (elevator.getCurrentPosition() < userPosition){
                    elevatorLinkedList.add(elevator);
                }
            }
            if (!elevatorLinkedList.isEmpty()){
                if (elevatorLinkedList.size() == 1){
                    return elevatorLinkedList.getFirst().getId();
                }else{

                    /*
                    додавати в дерево і створити компаратор по user.position - elevator.position
                    чим менше тим краще
                     */
                    return elevatorLinkedList.getFirst().getId();
                }
            }else{ //if Empty
                return 0;
            }

        }else if (direction == Direction.DOWN){
            for (Elevator elevator: elevators){
                if (elevator.getCurrentPosition() > userPosition){
                    elevatorLinkedList.add(elevator);
                }
            }
            if (!elevatorLinkedList.isEmpty()){
                if (elevatorLinkedList.size() == 1){
                    return elevatorLinkedList.getFirst().getId();
                }else{

                    /*
                    додавати в дерево і створити компаратор по user.position - elevator.position
                    чим менше тим краще
                     */
                    return elevatorLinkedList.getFirst().getId();
                }
            }else{ //if Empty
                return 0;
            }
        }
        return 0;
    }


}
