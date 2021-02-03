package com.elevator;

public class Elevator {
    private int currentPosition;
    private MoveTo moveTO;
    private int firstFloor;
    private int topFloor;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }

    public MoveTo getMoveTO() {
        return moveTO;
    }

    public void setMoveTO(MoveTo moveTO) {
        this.moveTO = moveTO;
    }

    public int getFirstFloor() {
        return firstFloor;
    }

    public void setFirstFloor(int firstFloor) {
        this.firstFloor = firstFloor;
    }

    public int getTopFloor() {
        return topFloor;
    }

    public void setTopFloor(int topFloor)  {
        if (getFirstFloor() < topFloor) {
            this.topFloor = topFloor;
        } else System.out.println("First floor can not be bigger then top floor.");
    }

    public Elevator(int firstFloor, int topFloor) {
        setFirstFloor(firstFloor);
        setTopFloor(topFloor);
        setCurrentPosition(getFirstFloor());
        setMoveTO(MoveTo.STOP);
    }

    public void move(int floor)  {
        if (floor > topFloor || floor < firstFloor) System.out.println("incorrect floor");
        if (currentPosition < floor) {
            moveUp(floor);
        } else if (currentPosition > floor) {
            moveDown(floor);
        }
        openTheDoor();

    }

    protected void moveUp(int floor) {
        while (currentPosition < floor) {
            currentPosition++;
        }
    }

    protected void moveDown(int floor) {
        while (currentPosition > floor) {
            currentPosition--;
        }
    }

    protected void openTheDoor() {
        System.out.println("Elevator on the floor");
    }

    @Override
    public String toString() {
        return "Elevator is located on " + currentPosition + " floor.";
    }
}

enum MoveTo {
    UP,
    DOWN,
    STOP
}
