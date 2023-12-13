
public class Elevator {
int currentFloor =1;

void goUp() {
	if (currentFloor == 3) {
	System.out.println("You can't go any higher");
	} else {
	currentFloor +=1;
	System.out.println("you are now on floor " +currentFloor);
	}
}
void goDown() {
	if (currentFloor!=1) {
	currentFloor-=1;
	System.out.println("you are now on floor " +currentFloor);
	}else {
	System.out.println("You can't go any lower");
	}
}
void displayCurrentFloor() {
	System.out.println("you are on floor "+ currentFloor);
}
}
