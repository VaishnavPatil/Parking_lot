public enum VehicleType
{
    MOTORCYCLE("Motorcycle"),
    CAR("Car"),
    TRUCK("Truck"),
    DISABLED("Disabled Vehicle");
    private final String displayName;
    VehicleType(String displayName)
    {
        this.displayName = displayName;
    }
    public String getDisplayName()
    {
        return displayName;
    }
    @Override
    public String toString()
    {
        return displayName;
    }
}
