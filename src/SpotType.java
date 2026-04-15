public enum SpotType
{
    COMPACT("Compact", 1.0),
    REGULAR("Regular", 1.5),
    LARGE("Large", 2.5),
    DISABLED("Disabled", 1.0);
    private String displayName;
    private final double hourlyRate;
    SpotType(String displayName, double hourlyRate)
    {
        this.displayName = displayName;
        this.hourlyRate = hourlyRate;
    }
    public String getDisplayName()
    {
        return displayName;
    }
    public double getHourlyRate()
    {
        return hourlyRate;
    }
}
