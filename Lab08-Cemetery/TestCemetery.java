
public class TestCemetery
{
    public static void main( String args[])
    {
        Cemetery cemt = new Cemetery("cemetery.txt");

        double avgAge = 0;
        int num = 0;
        for( int i = 0; i < cemt.getSize(); i++)
        {
            if( cemt.getAddress(i).contains("Little Carter Lane"))
            {
                avgAge += cemt.getAge(i);
                num++;
            }
        }
        avgAge = 10*( (avgAge/365 )/ num) ;
        avgAge = (Math.round(avgAge)) / 10.0;
        System.out.println(avgAge);
    }
}
