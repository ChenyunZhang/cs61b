import java.math.*;

public class Planet {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;

    public Planet(double xxPos, double yyPos, double xxVel,
    double yyVel, double mass, String imgFileName){
        this.xxPos = xxPos;
        this.yyPos = yyPos; 
        this.xxVel = xxVel; 
        this.yyVel = yyVel;
        this.mass = mass; 
        this.imgFileName = imgFileName;
    };

    public Planet(Planet p){};

    public double calcDistance(Planet p){
        double x = Math.pow(this.xxPos - p.xxPos, 2);
        double y = Math.pow(this.xxPos - p.yyPos, 2);
        double r = Math.sqrt(x+y);
        return r;
    };

    public double calcForceExertedBy(Planet p){
        final double G = 6.67e-11;
        double distance = this.calcDistance(p);
        double F = (G * this.mass * p.mass)/ Math.pow(distance,2);
        return F;
    }
}