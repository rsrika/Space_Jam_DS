import java.io.BufferedReader;
public class Simulation
{

    public static void main(String[] args)
    {
    	double t = 10;
    	double deltaT =1;
    	run(t,deltaT);
    	
    }
    public static void run(double T, double dt)
    {
    	Universe u = new Universe("planets.txt","starfeild.jpg",dt);
    }
}
