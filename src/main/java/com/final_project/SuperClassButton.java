/*
 * Prescott Lau --based off of Courtney Brown's vimeo videos.
 * November 19th 2024
 * 
 * Description: This class contains all the buttons for the MelodyLinkedList!
 * 
 * Classes included in this Class:
 * SuperClassButton: Super Class button for all buttons in the game.
 * ShopButton: XX
 * PauseButton: XX
 */
package com.final_project;

import processing.core.PApplet;

/*
 * --------
 * SuperClassButton: the super class for all the buttons that are in the Game.
 * --------
 */
public abstract class SuperClassButton extends Button{

    // GameController cont = new GameController(main);

    //overload the constructor for the SuperClassButton -- use the default size for height & width & color.
    SuperClassButton(PApplet main_, String label_, float x_, float y_)
    {
        super(main_, label_, x_, y_); 
    }

}


/*
 * --------
 * ShopButton: takes the user to the shop page.
 * --------
 */
class ShopButton extends SuperClassButton{

    //overload the constructor for the SuperClassButton -- use the default size for height & width & color.
    ShopButton(PApplet main_, float x_, float y_)
    {
        super(main_, "Shop", x_, y_); 
    }

    //Start playing the Melody
    public void onPress()
    {
        // controller.nextController = GameController.SHOP; //go to the shop page.
    }

}



/*
 * --------
 * PauseButton: pauses the game when clicked. 
 * --------
 */
class PauseButton extends SuperClassButton{

    //overload the constructor for the SuperClassButton -- use the default size for height & width & color.
    PauseButton(PApplet main_, float x_, float y_)
    {
        super(main_, "Pause", x_, y_); 
    }

    //Start playing the Melody
    public void onPress()
    {
        //game.pause();
    }

}