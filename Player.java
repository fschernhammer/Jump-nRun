import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Player extends Objects
{
    public int speed = 4;
    public int lvlCounter = 1;
    public int Coins = 0;
    public int velocity = 0;
    public int Gravity = 1;
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        isOnJumppad();
        Movement();
        Fall();
        if (Greenfoot.isKeyDown("space") && onPlattform()){
            Jump();
        }
        switch (lvlCounter){
            case 1:
                if (Coins == 11){
                    lvlCounter++;
                }
                break;
            default:
                break;
        }
        getsCoin();
        collisionWithEnemy();
    }
    public void Movement(){
        if (Greenfoot.isKeyDown("A") && getX() > 30){
            setLocation(getX() - speed, getY());
            setImage("MainCharacterLeft.png");
        }
        else if (Greenfoot.isKeyDown("D") && getX() < 530){
            setLocation(getX() + speed, getY());
            setImage("MainCharacter.png");
        }
    }
    public void Jump(){
        velocity -= 15;
    }
    public boolean onPlattform(){
        boolean isOnGround = false;
        int width = getImage().getWidth();
        int height = getImage().getHeight();
        if (getY() > getWorld().getHeight() - 50){
            isOnGround = true;
        }
        if (getOneObjectAtOffset(width / -2, height / 2, Block.class) != null || 
            getOneObjectAtOffset(width / 2, height / 2, Block.class) != null ){
            isOnGround = true;
        }
        
        if (!getObjectsInRange(25, Block.class).isEmpty()){
            isOnGround = true;
        }
        return isOnGround;
    }
    public void isOnJumppad(){
        if (!getObjectsInRange(20, Jumppad.class).isEmpty()){
            velocity -= 20;
        }
        if (!getObjectsInRange(20, Blockv2.class).isEmpty()){
            velocity++;
        }
    }
    public void Fall(){
        setLocation(getX(), getY() + velocity);
        if (onPlattform()){
            velocity = 0;
        } else{
            velocity += Gravity;
        }
    }
    public void getsCoin(){
        if (!getObjectsInRange(10, Coin.class).isEmpty()){
            Actor coin = 
            getWorld().getObjectsAt(getX(), getY(),Coin.class).get(0);
            ((MyWorld)getWorld()).deleteCoin(coin);
            Coins++;
        }
    }
    public void collisionWithEnemy(){
        if (!getObjectsInRange(20, Enemy.class).isEmpty()){
            ((MyWorld)getWorld()).gameOver();
        }
    }
    public int lvl_Counter(){
        return lvlCounter;
    }
}
