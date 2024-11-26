/*
 * Prescott Lau
 * November 11th 2024
 * This class is the Battleship class. 
 * It represents the user & moves using the WASD keys.
 */

package com.final_project;

import processing.core.PApplet;
import processing.core.PImage;

public class Battleship extends Particle_Object{

    
    int health; //health, determines when the game ends (loses).
    int extraLivesCount; 
    int shopLivesBought;
    int coins; //coins - determines when the game ends (wins!)
    float  random_number = (int)main.random(0,4);
    String message = ""; // prints out a message for power up object.
    PImage battleshipImg_ = main.loadImage("./images/battleship_2.png");

    Battleship(PApplet main_, PImage battleshipImg_)
    {
        super(main_, battleshipImg_, 128, 70, 255);
        x = main.width/7;
        y = main_.height/2;
        health = 5;
    }

    //display the object
    void display()
    {
        super.display();
        // main.rect(x, y, img_width * 2, img_width);
        ////?????????????????????????????????????????

    }

    void setLocation(float x_, float y_)
    {
        x = x_;
        y = y_;
    }

    //if a collision happened, deduct health!
    void collisions(Particle_Object object)
    {   
        hit = isHit(object);
        if (hit)
        {
            if(object instanceof Enemy)
            {
                main.fill(255,0,0, 100); //code to display a red box on the screen when you lose health
                main.rectMode(0);
                main.rect(0,0,main.width,main.height);
                //main.rect(0,0,main.width,main.height);
                if(health > 0 )
                {
                    health--;
                    return;
                }
                else{
                    if(extraLivesCount > 0 )
                    {
                        extraLivesCount--;
                    }
                }
                
                //System.out.println("Health = " + health);
            }

            if(object instanceof Loot)
            {
                coins++;
                //System.out.println("Coins = " + coins);
            }

            if(object instanceof Power_Up) //randomly will do something interesting, 
            {                              //look @ power_up class for more information!
                random_number = (int)main.random(0,7);
                if(random_number == 0)
                {
                    health += 2;
                    message = "Gave you 2 extra Lives!";
                    // System.out.println("Health = " + health);
                }
                else if(random_number == 1)
                {
                    coins += 3;
                    message = "Gave you 3 extra Coins!";
                    // System.out.println("Coins = " + coins);
                }
                else if(random_number == 2)
                {
                    main.fill(255,0,0, 190); //code to display a red box on the screen when you lose health
                    main.rectMode(0);
                    main.rect(0,0,800,800);
                    if(health > 0 )
                    {
                        health--;
                        return;
                    }
                    else{
                        if(extraLivesCount > 0 )
                        {
                            extraLivesCount--;
                        }
                    }
                    message = "Took away 2 Lives!";
                    // System.out.println("Health = " + health);
                }
                else if(random_number == 3)
                {
                    if(coins >= 3) //edited this function so that if the coins are greater than 3 this happens.. 
                    { //            (so the user does not end up with negative coins.)
                        coins -= 3;
                        message = "Took away 3 Coins!";
                    }   
                    // System.out.println("Coins = " + coins);
                }
                else if(random_number == 4 || random_number == 5  || random_number == 6  || random_number == 7)
                {
                    message = "";
                    // System.out.println("Nothing happened...");
                }
                // System.out.println("Message = " + message);
                random_number = (int)main.random(0,4);
            }
            if(object instanceof Wave)
            {
                //dont do anything (hopefully this works, when it collides with a wave.)
                //Adding wave objects to randomly spawn in that move accross the screen.
                
            }
        }
    }
    
    public void keyPressed()
    {
        if( main.key == 'w' || main.key == 'W' )
        {
            y -= 8 * 3;
        }

        if( main.key == 's' || main.key == 'S' )
        {
            y += 8 * 3;
        }


        if( main.key == 'a' || main.key == 'A' )
        {
            x -= 8 * 3;
        }

        if( main.key == 'd' || main.key == 'D' )
        {
            x += 8 * 3;
        }

    }  

    //getter for the health variable
    float getHealth()
    {
        return health;
    }

    void resetHealth(int h)
    {
        this.health = h;
    }

    //getter for coins!
    float getCoins()
    {
        return coins;
    }

    //setter for coins!
    public void resetCoinCount(int c)
    {
        this.coins = c;
    }
    
    //getter for message!
    String getMessage()
    {
        return message;
    }
    
    public void addExtraLives(int amount)
    {
        if((extraLivesCount < 3) && (shopLivesBought < 3))
        {
            this.extraLivesCount += amount;
            this.shopLivesBought += amount;
        }
        else
        {
            //DO NOTHING if the user already has 3 Extra Lives!
        }
    }

    /*
     * Getters and setters for Extra Lives:
     */
    public int getExtraLivesCount()
    {
        return this.extraLivesCount;
    }

    public void setExtraLivesCount(int a)
    {
        this.extraLivesCount = a;
    }

    float getTotalHealth()
    {
        return this.health + this.extraLivesCount;
    }

    /*
     * This function resets the Extra Lives that have been bought (after dying.) 
     * 
     */
    void resetExtraLivesAfterDeath() 
    {   
        this.extraLivesCount = this.shopLivesBought;
    }
}
