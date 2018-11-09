public class Camel
{
    private String color;
    private int pos;
    public Camel(String c)
    {
        color = c;
        pos = 0;
    }
    //add num to pos
    public int move(int num)
    {
        pos += num;
        return pos;
    }
    //get the color of the camel
    public String getCamelColor()
    {
        return color;
    }
}