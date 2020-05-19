import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends Objects
{
    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public int velocity = 2;
    public boolean rightDirection = true;
    public void act() 
    {
        Movement();
    } 
    public void Movement(){
        
        if (getX() < 370 && rightDirection){
            rightDirection = true;
            setLocation(getX() + velocity, getY());
        }
        else if (getX() > 190){
            rightDirection = false;
            setLocation(getX() - velocity, getY());
        }
        if (getX() > 190 && getX() < 195){
            rightDirection = true;
        }
    }
    
}
