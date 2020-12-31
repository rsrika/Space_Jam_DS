package src;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException; 
import java.io.PrintWriter;
public class Simulation
{
	
	

    public static void main(String[] args)
    {
    	double T = Double.parseDouble(args[0]);
    	double dt =Double.parseDouble(args[1]);

    	StdDraw.enableDoubleBuffering();
    	Universe u = new Universe("planets.txt","starfield.jpg",dt);
    	StdDraw.setScale(-1*u.getRadius(),u.getRadius());
    	
    	Particle[] particles = u.getParticles();
    	while(T>0)
    	{
    		
    		drawParticles(particles, u);
    		u.calculateForces();
    		u.updateVelocityAndPos();
    		T-= dt;
    		StdDraw.pause(10);
    		
    	}
    	writeToFile(u.toString());
    	
    }
    public static void drawParticles(Particle[] particles, Universe u)
    {
    	StdDraw.clear();
    	StdDraw.picture(0,0,"./input/"+u.getUniverseFileName());
    	for(int i = 0; i< particles.length; i++)
    	{
    		StdDraw.picture(particles[i].getX(), particles[i].getY(), "./input/"+particles[i].getFileName());
    	}
    	StdDraw.show();
    	
    }
    public static void writeToFile(String text)
    {
    	try
    	{
    		FileWriter fw = new FileWriter(new File("planetsOutput.txt"));
    		PrintWriter pw = new PrintWriter(fw);
    		pw.print(text);
    		pw.close();
    	}
    	catch(Exception e)
    	{
    		System.out.println(e.toString());
    	}
    }
   
}
