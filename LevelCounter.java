import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LevelCounter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LevelCounter extends Objects
{
    GreenfootImage bild;
    public Player player_;
    /**
     * Act - do whatever the LevelCounter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        aktualisiere(20);
    }
    public LevelCounter(Player player){
        player_ = player;
        bild = new GreenfootImage(200,50);
        bild.clear();
        bild.setColor(Color.BLUE);
        setImage(bild);
        aktualisiere(21);
    }
    public void aktualisiere(float pSchriftg){
        float eins = 1;
        GreenfootImage bild = getImage();
        Font font = bild.getFont();
        bild.clear();
        font = font.deriveFont(pSchriftg);
        bild.setFont(font);
        bild.drawString("Level: " + player_.lvl_Counter(), 0,20);
        setImage(bild);
    }
}
