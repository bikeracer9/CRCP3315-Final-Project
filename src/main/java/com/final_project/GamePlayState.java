/*
 * Prescott Lau
 * Final Project
 * November 11th 2024
 * This file controls the particles!
 */

package com.final_project;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PImage;

public class GamePlayState extends GameController {
    //PApplet main; //the main class, which has all the processing functionality.

    /*
     * Below are all the ArrayLists for each of the different objects.
     */

    Battleship ship;
    PImage bombImg = main.loadImage("./images/bomb_3.png"); //bomb_2.png
    PImage battleshipImg = main.loadImage("./images/battleship.png");
    PImage waveImg = main.loadImage("./images/wave.png");
    PImage coinImg = main.loadImage("./images/coin.png");
    PImage powerUpImage = main.loadImage("./images/powerUp_1.png");

    ArrayList<NPC> npc;

    ArrayList<Loot> loot;
    int loot_count = 3;

    ArrayList<Enemy> enemies;
    int enemy_count = 7;

    ArrayList<Power_Up> PowerUp;
    int PowerUpCount = 2;
    
    ArrayList<Wave> waves;
    int waveCount = 0;
    
    ArrayList<Particle_Object> particle_Objects;

    LinkedList list;
    
        public GamePlayState(PApplet main_) 
        {
            super(main_);
            init(); //initialize all the objects
        }
    
    /*
     * This function initializes all the objects in the code.
     */
        public void init()
        {    
            ship = new Battleship(main, battleshipImg);
            npc = new ArrayList();
            loot = new ArrayList();
            waves = new ArrayList();
            enemies = new ArrayList();
            PowerUp = new ArrayList();
    
            // for(int i = 0; i < waveCount; i++)
            // {
            //     waves.add( new Wave(main, waveImg) );
            // }

            for(int i = 0; i < loot_count; i++)
            {
                loot.add( new Loot(main, coinImg) );
            }
    
            for(int i = 0; i < PowerUpCount; i++)
            {
                PowerUp.add( new Power_Up(main, powerUpImage) );
            }
           
            for(int i = 0; i < enemy_count; i++)
            {
                enemies.add( new Enemy(main, bombImg) );
            }
    
            //add all the NPC
            npc.addAll(loot);
            // npc.addAll(waves);
            npc.addAll(enemies);
            npc.addAll(PowerUp);
            
            //add all the small particles to the big particle object ArrayList
            particle_Objects = new ArrayList();
            particle_Objects.add(ship);
            particle_Objects.addAll(npc);
        }
    
        /*
         * This is the draw function, it calls other functions to make the code cleaner and easier to read.
         */
        public void draw()
        {
            main.background(0,128,255); //draw the background
            display(); //display all objects
            move(); //move the objects
            collisions(); //check collisions btwn circles
            text(); //add the text onto the screen.
            
            //check to see if we need to end the game
            nextController = GameController.DO_NOT_CHANGE;
    
            if( ship.getHealth() <= 0)//if the player dies, player loses
            {
                nextController = GameController.GAME_END; //draws the end game screen
            }
    
            if( ship.getCoins() >= 25) //if the player has more than 15 coins, player wins
            {
                nextController = GameController.GAME_WIN; //draws the win game screen
            }
        }
    
        /*
         * This is the function that draws (displays) all the objects.
         */
        public void display()
        {
            main.rectMode(3);
            main.noStroke();
            for(int i = 0; i < particle_Objects.size(); i++)
            {
                particle_Objects.get(i).display();
            }
        }
        
        /*
         * This is the collision function for the avatar & npc objects & for the enemies to bounce off each other.
         */
        public void collisions()
        {
            for(int i = 0; i < npc.size(); i++)
            {
                ship.collisions(npc.get(i));
                npc.get(i).collision(ship);
                
            }
    
        }
    
        public void move()
        {
            for(int i = 0; i < particle_Objects.size(); i++)
            {
                particle_Objects.get(i).move();
            }
        }
    
        public void keyPressed()
        {
            ship.keyPressed();
        }

        // public void keyReleased()
        // {
        //     ship.keyReleased();
        // }
        // //change the location of the avatar, hooked up w mouseDragged in main.
        // public void setAvatarLocation(float x, float y)
        // {
        //     ship.setLocation(x, y);
        // }
       
        //move avatar when mouse is dragged.
        // public void mouseDragged()
        // {
        //     setAvatarLocation(main.mouseX, main.mouseY);
        // }
    
        /*
         * Resets the game!
         */
        public void reset()
        {
            super.reset();
            init();
        }
        
        /*
         * Function to add text onto the screen.
         */
        public void text()
        {
            main.textSize(15);
            main.fill(0);
            main.text("Health: " + (int)ship.getHealth(), 35, 35);
            main.text("Coins: " + (int)ship.getCoins(), 35, 65);
            main.text("" + ship.getMessage(), 35, 95);
        }

}
