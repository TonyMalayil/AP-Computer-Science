public class Lock
{
    private boolean locked;

    void open()
    {
        locked = false;
    }
    void close()
    {
        locked = true;
    }

    boolean isLocked()
    {
        return locked;
    }

    public String toString()
    {
        String str = "";
        if( locked)
            str = "Lock is closed";
        else if( !locked)
            str = "Lock is open";

        return str;
    }

    public Lock()
    {
        locked = true;
    }
}
