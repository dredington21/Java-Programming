
public class Navy_Sailor extends Person {
String status = "Active Duty", ship = "Submarine", rank = "Swashbuckler";

	

@Override
  public String toString() {
        return "\n Status: " + status +
               "\n Ship Location: " + ship +
               "\n Rank: " + rank;
}
}
