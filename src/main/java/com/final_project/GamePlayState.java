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
    PImage waveImg = main.loadImage("./images/wave_2.png");
    PImage coinImg = main.loadImage("./images/coin.png");
    PImage powerUpImage = main.loadImage("./images/powerUp_1.png");
    PImage healthImage = main.loadImage("./images/heart_1.png");
    PImage pauseImage = main.loadImage("./images/pause.png");

    ArrayList<NPC> npc;

    ArrayList<Loot> loot;
    int loot_count = 3;

    ArrayList<Enemy> enemies;
    int enemy_count = 7;

    ArrayList<Power_Up> PowerUp;
    int PowerUpCount = 2;
    
    ArrayList<Wave> waves;
    int waveCount = 3;
    
    ArrayList<Particle_Object> particle_Objects;

    LinkedList list;
    
    public GamePlayState(PApplet main_, LinkedList list_) 
    {
        super(main_);
        init(); //initialize all the objects
        this.list = list_;
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

            // list = new LinkedList();
    
            for(int i = 0; i < waveCount; i++)
            {
                waves.add( new Wave(main, waveImg) );
            }

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
            npc.addAll(waves);
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
            collisions(); //check collisions btwn objects. //// ???
            text(); //add the text onto the screen.
            addButtons();
            
            //check to see if we need to end the game
            nextController = GameController.DO_NOT_CHANGE;
    
            if( ship.getHealth() <= 0)//if the player dies, player loses
            {
                nextController = GameController.GAME_END; //draws the end game screen
                list.insertAtStart( new Node( (int)ship.getCoins() ) ); //  !!!!
            }
    
            if( ship.getCoins() >= 1000) //if the player has more than 15 coins, player wins
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
            main.textSize(22);
            main.fill(0);
            // main.text("Health: " + (int)ship.getHealth(), 35, 35);
            int healthCount = (int)ship.getHealth();
            int x = 15;
            for(int i = 0; i <  healthCount; i++)
            {
                main.image(healthImage, 0 + x, 15, 32, 32);
                x += 40;
            }
            main.text("Coins: " + (int)ship.getCoins(), 15, 75);
            main.text("" + ship.getMessage(), 35, 95);
        }

        // public int updateCoins()
        // {
        //     int coins = (int)ship.getCoins();
        //     return coins;
        // }

        public void addButtons()
        {
            //below is the pause game button:
            main.fill(255);
            main.rect(main.width - 175, 65,125, 55);
            main.fill(0);
            main.image(pauseImage, main.width - 206, 35, 64, 64);
        }

        public void mousePressed()
        {
            System.out.println("X: " + main.mouseX + " Y: " + main.mouseY);
            //Rect Mode: 3 (CENTER), so had to do some math to figure this part out!
            if( (main.mouseX >= 1163) && (main.mouseX <= 1287) && (main.mouseY >= 38 ) && (main.mouseY <= 92) )
            {
                for(int i = 0; i < particle_Objects.size(); i++)
            {
                particle_Objects.get(i).isPaused(true);
                // System.out.println("e: " + particle_Objects.get(i).isPaused(true));
            }
            }
        }
}
