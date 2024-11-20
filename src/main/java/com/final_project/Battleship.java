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

    int health = 5; //health, determines when the game ends (loses).
    int coins = 50; //coins - determines when the game ends (wins!)
    float  random_number = (int)main.random(0,4);
    String message = ""; // prints out a message for power up object.
    PImage battleshipImg_ = main.loadImage("./images/battleship.png");

    Battleship(PApplet main_, PImage battleshipImg_)
    {
        super(main_, battleshipImg_, 128, 128, 255);
        x = main.width/7;
        y = main_.height/2;
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
                main.rect(0,0,main.width,main.height);
                health--;
                System.out.println("Health = " + health);
            }

            if(object instanceof Loot)
            {
                coins++;
                System.out.println("Coins = " + coins);
            }

            if(object instanceof Power_Up) //randomly will do something interesting, 
            {                              //look @ power_up class for more information!
                random_number = (int)main.random(0,7);
                if(random_number == 0)
                {
                    health += 2;
                    message = "Gave you 2 extra Lives!";
                    System.out.println("Health = " + health);
                }
                else if(random_number == 1)
                {
                    coins += 3;
                    message = "Gave you 3 extra Coins!";
                    System.out.println("Coins = " + coins);
                }
                else if(random_number == 2)
                {
                    main.fill(255,0,0, 190); //code to display a red box on the screen when you lose health
                    main.rectMode(0);
                    main.rect(0,0,800,800);
                    health -= 2;
                    message = "Took away 2 Lives!";
                    System.out.println("Health = " + health);
                }
                else if(random_number == 3)
                {
                    coins -= 3;
                    message = "Took away 3 Coins!";
                    System.out.println("Coins = " + coins);
                }
                else if(random_number == 4 || random_number == 5  || random_number == 6  || random_number == 7)
                {
                    message = "";
                    System.out.println("Nothing happened...");
                }
                System.out.println("Message = " + message);
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

    //getter for coins!
    float getCoins()
    {
        return coins;
    }
    
    //getter for message!
    String getMessage()
    {
        return message;
    }
}
