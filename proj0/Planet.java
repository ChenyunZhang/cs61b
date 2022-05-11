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

    public double calcForceExertedByX(Planet p){
        double f = this.calcForceExertedBy(p);
        boolean flag = false;
        if(this.xxPos > p.xxPos){flag = true;}
        double dx = 0;
        if(flag){
            dx = this.xxPos - p.xxPos;
        }else{
            dx = p.xxPos - this.xxPos;
        }
        double r = this.calcDistance(p);
        double result = (f*dx)/r;
        return result;
    }

    public double calcForceExertedByY(Planet p){
        double f = this.calcForceExertedBy(p);
        boolean flag = false;
        if(this.yyPos > p.yyPos){flag = true;}
        double dy = 0;
        if(flag){
            dy = this.yyPos - p.yyPos;
        }else{
            dy = p.yyPos - this.yyPos;
        }
        double r = this.calcDistance(p);
        double result = (f*dy)/r;
        return result;
    }

    public double calcNetForceExertedByX (Planet[] args){
        double result = 0;
        for(int i=0;i<args.length;i++){
            if(this == args[i]) continue;
            result +=this.calcForceExertedByX(args[i]);
        };
        return result;
    }
    
    public double calcNetForceExertedByY(Planet[] args){
        double result = 0;
        for(int i=0;i<args.length;i++){
            if(this == args[i]) continue;
            result +=this.calcForceExertedByY(args[i]);
        };
        return result;
    }
}