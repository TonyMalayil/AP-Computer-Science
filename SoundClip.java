
public class SoundClip
{
    double [] clip;

    public SoundClip()
    {
        clip = new double[1600];
    }

    public  SoundClip ( double[] tone)
    {
        clip = tone;
    }

    void adjustVolume(double factor)
    {
        for(int i = 0; i < clip.length; i++)
        {
            clip[i] *= factor;
        }
    }

    void mix ( double[] clip1, double[] clip2)
    {
        int maxSize = Math.max( clip1.length, clip2.length);
        clip = new double [maxSize];
        for( int g = 0; g < Math.min( clip1.length, clip2.length); g++)
        {
            clip[g] = clip1[g] + clip2[g];
        }


        if( clip1.length > clip2.length)
        {
            for( int g = Math.min( clip1.length, clip2.length); g < maxSize; g++)
            {
                clip[g] = clip1[g];
            }
        }
        else if( clip2.length > clip1.length)
        {
            for( int g = Math.min( clip1.length, clip2.length); g < maxSize; g++)
            {
                clip[g] = clip2[g];
            }
        }
    }

    void append(double[] other)
    {
        double [] result = new double[clip.length + other.length];
        int o = 0;
        for( int h = 0; h < result.length; h++)
        {
            if( h < clip.length)
            {
                result[h] = clip[h];
                o = h;
            }
            else if ( h > clip.length)
            {
                result[h] = other[ h - (o+1) ];
            }
        }

        this.clip = new double[result.length];
        this.clip = result;
    }

    void fadeIn(double seconds)
    {
        int time = Sound.toNumSamples(seconds);
        double mult;
        for( int g = 0; g < time; g++)
        {
            mult = g /( (double) time);
            clip [g] *= mult;
        }
    }

    void fadeOut( double seconds)
    {
        int time = Sound.toNumSamples(seconds);
        int startTime = clip.length - time;
        double mult;
        for( int g = startTime; g < clip.length; g++)
        {
            mult = 1- (g - startTime )/( (double) time);
            clip [g] = clip[g] * mult;
        }
    }

    void reverse()
    {
        double [] result = new double[clip.length];
        for( int g = 0; g < clip.length; g++)
        {
            result[g] = clip[(clip.length-1 )- g];
        }
        this.clip = new double[result.length];
        this.clip = result;
    }

    void speedUp(double factor)
    {
        double [] result = new double[(int) (clip.length / factor)];

        for( int g = 0; g < result.length -1; g++)
        {
            result[g] = clip[(int) (g*factor) ];
        }

        this.clip = new double[result.length];
        this.clip = result;
    }
}
