package bswanepo.mainMenu;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.JButton;

import java.awt.Font;
import java.awt.event.ActionListener;
import bswanepo.Game;


import java.awt.event.MouseEvent;

public class GuiButton extends JButton{
    private State currentState = State.RELEASED;
    private Rectangle clickBox;
    private ArrayList<ActionListener> actionListeners;
    private String text = "";
    
    private Color released;
    private Color hover;
    private Color pressed;
    private Font font = Game.main.deriveFont(22f);

    public GuiButton(int x,int y, int width, int height){
        // super();
        clickBox = new Rectangle(x,y,width,height);
        actionListeners = new ArrayList<ActionListener>();
        released = Color.MAGENTA;
        hover = Color.PINK;
        pressed = Color.lightGray;
    }
    public void update(){}

    public void render(Graphics2D g){
        if(currentState == State.RELEASED){
            g.setColor(released);
            g.fill(clickBox);
        }else if(currentState == State.HOVER){
            g.setColor(hover);
            g.fill(clickBox);
        }
        else{
            g.setColor(pressed);
            g.fill(clickBox);
        }
        g.setColor(Color.white);
        g.setFont(font);
        // g.fill(clickBox);
        g.drawString(text, clickBox.x-22 + clickBox.width/2, clickBox.y+5 + clickBox.height/2);
        

    }
    public void addActionListener(ActionListener actionListener){
        actionListeners.add(actionListener);
    }
    public void mousePressed(MouseEvent e){
        if(clickBox.contains(e.getPoint())){
            currentState =State.PRESSED;
        }

    }
    public void mouseReleased(MouseEvent e){
        if(clickBox.contains(e.getPoint())){
            for(ActionListener al : actionListeners){
                al.actionPerformed(null);
            }
        }
    currentState = State.RELEASED;        
    }
    public void mouseDragged(MouseEvent e){
        if(clickBox.contains(e.getPoint())){
            currentState = State.PRESSED;
        }else{
            currentState = State.RELEASED;
        }
        
    }
    public void mouseMoved(MouseEvent e){
        if(clickBox.contains(e.getPoint())){
            currentState = State.HOVER;
        }else{
            currentState = State.RELEASED;
        }
        
    }

    public int getX(){
        return clickBox.x;
    }
    public int getY(){
        return clickBox.y;
    }
    public int getWidth(){
        return clickBox.width;
    }
    public int getHeight(){
        return clickBox.height;
    }
    public void setText(String text){
        this.text = text;
    }
    
    private enum State{
            RELEASED,
            HOVER,
            PRESSED
    }
}