
public class Coordinates{
    private int longitude; //Boylam
    private int latitude; //Enlem
    private int height; //Yükseklik

    Coordinates(int p_longitude, int p_latitude, int p_height)
    {
        setLongitude(p_longitude);
        setLatitude(p_latitude);
        setHeight(p_height);
    }
    
    public void increaseLongitude(int value) {
        setLongitude(longitude + value);
    }
    public void increaseLatitude(int value) {
        setLatitude(latitude + value);
    }
    public void increaseHeight(int value) {
        setHeight(height + value);
    }

    public void decreaseLongitude(int value) {
        setLongitude(longitude - value);
    }
    public void decreaseLatitude(int value) {
        setLatitude(latitude - value);
    }
    public void decreaseHeight(int value) {
        setHeight(height - value);
    }

    private void setLongitude(int value) {
        this.longitude = Math.max(0, value);
    }
    private void setLatitude(int value) {
        this.latitude = Math.max(0, value);
    }
    private void setHeight(int value) {
        this.height = Math.max(0, Math.min(100, value));
    }

    public int getLongitude() {
        return longitude;
    }
    public int getLatitude() {
        return latitude;
    }
    public int getHeight() {
        return height;
    }
}