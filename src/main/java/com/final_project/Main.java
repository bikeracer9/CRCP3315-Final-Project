/*
 * Prescott Lau
 * November 11th 2024
 * This is the Main file.
 */

package com.final_project;

import java.util.ArrayList;

import processing.core.PApplet;


public class Main extends PApplet {

    ArrayList<GameController> controllers = new ArrayList<>();
    
    int curController = GameController.INTRO;

    public static void main(String[] args) { //sets up processing
        PApplet.main("com.final_project.Main");
    }

    //sets up the size of the window
    public void settings()
    {
        size(1000, 800);
        
        controllers.add(new GamePlayState(this) );
        controllers.add(new GameEndController(this) );
        controllers.add(new GameWinController(this) );
        controllers.add(new GameIntro(this) );
    }
    
    /*
     * This is the setup function
     */
    public void setup()
    {               
        
    } 

    /*
    * This is the main draw function.
    * Draws everything on the screen.
    */
    public void draw()
    {
        controllers.get(curController).draw();

        if(controllers.get(curController).switchController() > GameController.DO_NOT_CHANGE)
        {
            int nextControl = controllers.get(curController).switchController();
            controllers.get(curController).reset();
            curController = nextControl;
        }
    }

    /*
     * This is the mousePressed method. 
     * When the mouse is pressed, the objects move in the opposite direction.
     */
    public void mousePressed()
    {
        controllers.get(curController).mousePressed();
    }

    public void keyPressed()
    {
        controllers.get(curController).keyPressed();
    }

    public void mouseDragged()
    {
        controllers.get(curController).mouseDragged();
    }
}