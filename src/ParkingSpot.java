public class ParkingSpot
{
    private final String spotId;
    private final SpotType spotType;
    private final int floor;
    private final int spotNumber;
    private boolean isOccupied;
    private Vehicle currentVehicle;
    public ParkingSpot(int floor, int spotNumber, SpotType spotType)
    {
        this.floor = floor;
        this.spotNumber = spotNumber;
        this.spotType = spotType;
        this.spotId = String.format("F%d-S%02d", floor, spotNumber);
        this.isOccupied = false;
        this.currentVehicle = null;
    }
    public String getSpotId()
    {
        return spotId;
    }
    public SpotType getSpotType()
    {
        return spotType;
    }
    public int getFloor()
    {
        return floor;
    }
    public int getSpotNumber()
    {
        return spotNumber;
    }
    public boolean isOccupied()
    {
        return isOccupied;
    }
    public Vehicle getCurrentVehicle()
    {
        return currentVehicle;
    }
    public boolean park(Vehicle vehicle)
    {
        if(isOccupied || vehicle == null)
        {
            return false;
        }
        this.currentVehicle = vehicle;
        this.isOccupied = true;
        return true;
    }
    public Vehicle release()
    {
        if(!isOccupied)
        {
            return null;
        }
        Vehicle v = this.currentVehicle;
        this.currentVehicle = null;
        this.isOccupied = false;
        return v;
    }
    public boolean canAccomodate(VehicleType vehicleType)
    {
        if(vehicleType == VehicleType.DISABLED)
        {
            return spotType == SpotType.DISABLED;
        }
        if(spotType == SpotType.DISABLED)
        {
            return false;
        }
        switch(vehicleType)
        {
            case MOTORCYCLE: return true;
            case CAR: return spotType == SpotType.REGULAR || spotType == spotType.LARGE;
            case TRUCK: return spotType == SpotType.LARGE;
            default: return false;
        }
    }
    @Override
    public String toString()
    {
        String status = isOccupied ? "OCCUPIED [" + currentVehicle.getLicensePlate() + "]" : "AVAILABLE";
        return String.format("%-8s | %-10s | Floor %d | %s", spotId, spotType.getDisplayName(), floor, status);
    }
}
