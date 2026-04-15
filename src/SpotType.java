public enum SpotType
{
    COMPACT("Compact"),
    REGULAR("Regular"),
    LARGE("Large"),
    DISABLED("Disabled");
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
