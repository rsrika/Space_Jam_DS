package src;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Universe 
{
	private int numParticles;
	private Particle[] particles;
	private double radius;
	private String fileName;
	private double deltaT;
	private String universeFileName;
	
	public Universe(String planetsFileName, String universeFileName, double dt)
	{
		deltaT = dt;
		this.universeFileName = universeFileName;
		readAndLoadUniverse(planetsFileName);
		fileName = planetsFileName;		
		
		
	}
	public void readAndLoadUniverse(String fileName)
	{
		String file = "./input/"+fileName;
		File f = new File(file);
		try
		{
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			numParticles = Integer.parseInt(br.readLine());
			radius = Double.parseDouble(br.readLine());
			Particle[] particles1 = new Particle[numParticles];
			
			for(int i = 0; i< numParticles; i++)
			{
				if(br.ready())
				{
					String line = br.readLine();
					String[] lineSplit = line.split("  ");
					particles1[i] = Particle.buildParticleFromFile(lineSplit);
				}
			}
			particles = particles1;
			fr.close();
			br.close();
			
		}
		catch(Exception e)
		{
			e.toString();
		}
	}
	public void calculateForces()
	{
		double G = 6.67* Math.pow(10, -11);
		double fNet = 0; 
		double deltaX = 0;
		double deltaY = 0;
		double r = 0;
		for(int i = 0; i< particles.length; i++)
		{
			particles[i].setFx(0);
			particles[i].setFy(0);
			for(int j = 0; j< particles.length; j++)
			{
				if(i!=j)
				{
					r = (particles[j].getDistance(particles[i]));
					fNet += (G*particles[i].getMass()*particles[j].getMass())/Math.pow(r, 2);
					deltaX = particles[j].getX()-particles[i].getX();
					deltaY = particles[j].getY()-particles[i].getY();
				}
			}
			particles[i].setFx(fNet * (deltaX/r));
			particles[i].setFy(fNet * (deltaY/r));
		}
	}
	public void updateVelocityAndPos()
	{
		for(int i= 0; i< particles.length; i++)
		{
			double ax = particles[i].getFx()/particles[i].getMass();
			double ay = particles[i].getFy()/particles[i].getMass();
			
			particles[i].setVx(particles[i].getVx() + deltaT*ax);
			particles[i].setVy(particles[i].getVy() + deltaT*ay);
			
			particles[i].setX(particles[i].getX() + deltaT*particles[i].getVx());
			particles[i].setY(particles[i].getY() + deltaT*particles[i].getVy());
			
		}
	}
	
	public void timeStepUniverse()
	{
		calculateForces();
		updateVelocityAndPos();
	}
	public String toString()
	{
		String returnString  = "";
		returnString+= numParticles+"\n";
		returnString+= radius+"\n";
		for(int i = 0; i<particles.length; i++)
		{
			returnString+= particles[i].toString()+"\n";
		}
		StdDraw.enableDoubleBuffering();
		StdDraw.show();
		return returnString;
	}
	public int getNumParticles() {
		return numParticles;
	}
	public void setNumParticles(int numParticles) {
		this.numParticles = numParticles;
	}
	public Particle[] getParticles() {
		return particles;
	}
	public void setParticles(Particle[] particles) {
		this.particles = particles;
	}
	public double getRadius() {
		return radius;
	}
	public void setRadius(double radius) {
		this.radius = radius;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public double getDeltaT() {
		return deltaT;
	}
	public void setDeltaT(double deltaT) {
		this.deltaT = deltaT;
	}
	public String getUniverseFileName() {
		return universeFileName;
	}
	public void setUniverseFileName(String universeFileName) {
		this.universeFileName = universeFileName;
	}
	
	
}
