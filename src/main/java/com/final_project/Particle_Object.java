/*
 * Prescott Lau
 * Final Project
 * November 11th 2024
 * This file is Superclass for all the objects: 
 *                                          NPC (super class for enemies, coins & power ups).
 *                                          Battleship (user controlled).
 */

package com.final_project;

import processing.core.PApplet;
import processing.core.PImage;

public class Particle_Object {
    PApplet main; //processing functionality

    float x,y; //location
    // int color; //color of the Particle Object
    float xVel, yVel; //velocity of the Particle Object
    float prevVel_X, prevVel_Y; //used for the pause button!
    // float size; //size of the Particle Object
    int alphaValue; //value that changes the Particle Objects opacity. 
    boolean hit; //if the game object has been hit.
    boolean paused = true; //if the game is paused, then returns true.
    PImage img;
    int img_width, img_height;
    

    //initializes everything
    Particle_Object(PApplet main_, PImage img_, int img_width_, int img_height_, int a) 
    {
        main = main_;
        // size = size_;
        // color = color_;
        img = img_;
        img_width = img_width_;
        img_height = img_height_;
        alphaValue = a;
    }    

    /*
    *  This method gives each particle an x,y, and velocity.
    */
    // void spawn()
    // {
    //     x = main.random(main.width);
    //     y = main.random(main.height);

    //     xVel = main.random(-1,10);
    //     yVel = main.random(-1,10);
    // }

    void display()
    {
        main.image(img, x, y, img_width, img_height);
        //main.fill(color, alphaValue);
        //main.ellipse(x, y, size, size);
        //main.image(bomb, x, y);
    }

    /*
    *  This method makes the object move, and checks to see if the object goes off the screen.
    */
    void move()
    {
        x += xVel; // equation to make the ball move in the X axis and in the correct direction.
        // prevVel_X = xVel;

        // if(y > (main.height - size/2)) //if the value of the ball on the Y axis is greater than
        // {                   //the bottom of the screen value, then the ball will change directions.
        //     yVel = yVel * -1;
        // }

        // if(y < 0) //if the value of the ball on the Y axis is greater than
        // {        //the top of the screen value then, the ball will change directions.
        //     yVel = yVel * -1;
        // }

        // if(x > (main.width - size/2)) //if the value of the ball on the X axis is greater than
        // {                   //the right of the screen value, then the ball will change directions.
        //     xVel = xVel * -1;
        // }

        if(x < (0 + img_width/2)) //if the value of the ball on the X axis is greater than
        {        //the left of the screen value then, the ball will change directions.
            //spawn();
        }
    }

    /*
    *  This is the getter method to get the value of an object's X value 
    */
    float getX()
    {
        return x;
    }

    /*
    *  This is the getter method to get the value of an object's Y value 
    */
    float getY()
    {
        return y;
    }

    /*
    *  This is the getter method to get the value of an object's size. 
    */
    float getSize()
    {
        return img_width;
    }

    /*
    *  Method to see if objects touch each other.
    */
    boolean isHit(Particle_Object object)
    {
        float distance = PApplet.dist(x, y, object.getX(), object.getY());
        return (distance < (img_width/2 + object.getSize()/2));
    }

    boolean isPaused(boolean p)
    {
        return p;
    }
    
    void pauseGame()
    {
        if(isPaused(paused) == true)
        {
            this.xVel = 0;
            System.out.println("Paused = " + paused);
        }
        else
        {
            this.xVel = this.prevVel_X;
        }
    }

}
