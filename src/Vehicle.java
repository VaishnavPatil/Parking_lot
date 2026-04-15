import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class Vehicle
{
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private final String licensPlate;
    private final VehicleType type;
    private final String ownerName;
    private final LocalDateTime entryTime;
    private LocalDateTime exitTime;
    public Vehicle(String licensPlate, VehicleType type, String ownerName)
    {
        if(licensPlate == null || licensPlate.trim().isEmpty())
        {
            throw new IllegalArgumentException("License plate can't be empty.");
        }
        if(type == null)
        {
            throw new IllegalArgumentException("Vehicle type can't be null.");
        }
        this.licensPlate = licensPlate;
        this.type = type;
        this.ownerName = (ownerName != null && !ownerName.trim().isEmpty()) ? ownerName.trim() : "Unknown";
        this.entryTime = LocalDateTime.now();
    }
    public void setExitTime(LocalDateTime exitTime)
    {
        this.exitTime = exitTime;
    }
    public long getParkedMinutes()
    {
        LocalDateTime end = (exitTime != null) ? exitTime : LocalDateTime.now();
        return java.time.Duration.between(entryTime, end).toMinutes();
    }
    public double getParkedHours()
    {
        return Math.max(getParkedMinutes() / 60.0, 0.0);
    }
    @Override
    public String toString()
    {
        return String.format("[%s] %s | Owner: %s | Entered: %s", licensPlate, type.getDisplayName(), ownerName, entryTime.format(FORMATTER));
    }
}
