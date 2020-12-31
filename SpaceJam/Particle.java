import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Particle 
{
	private double x;
	private double y;
	private double vx;
	private double vy;
	private double fx;
	private double fy;
	private double mass;
	private String fileName;
	public Particle(double x, double y, double vx, double vy, double mass, String fileName)
	{
		this.x = x;
		this.y = y;
		this.vx = vx; 
		this.vy = vy; 
		this.mass = mass; 
		this.fileName = fileName;
	}
	
	public Particle buildParticleFromFile(String[] line)
	{		
		double x1 = Double.parseDouble(line[0]);
		double y1 = Double.parseDouble(line[1]);
		double vx1 = Double.parseDouble(line[2]);
		double vy1 = Double.parseDouble(line[3]);
		double mass1 =Double.parseDouble(line[4]);
		String fileName1 = line[5];
		return new Particle(x1,y1,vx1,vy1,mass1,fileName1);
	
	}


	public double getDistance(Particle other)
	{
		double deltaXSquared = Math.pow(other.getX()-getX(), 2);
		double deltaYSquared = Math.pow(other.getY()-getY(), 2);
		return Math.sqrt(deltaXSquared + deltaYSquared);
	}
	public String toString()
	{
		return (getX()+" "+getY()+" "+getVx()+" "+ getVy()+" "+ getMass()+" "+getFileName());
	}

	//all getters and setters
	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getVx() {
		return vx;
	}

	public void setVx(double vx) {
		this.vx = vx;
	}

	public double getVy() {
		return vy;
	}

	public void setVy(double vy) {
		this.vy = vy;
	}

	public double getFx() {
		return fx;
	}

	public void setFx(double fx) {
		this.fx = fx;
	}

	public double getMass() {
		return mass;
	}

	public void setMass(double mass) {
		this.mass = mass;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public double getFy() {
		return fy;
	}

	public void setFy(double fy) {
		this.fy = fy;
	}
}
