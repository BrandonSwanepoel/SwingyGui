package bswanepo.mainMenu;

import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.Graphics2D;

public class GuiPanel {

    private ArrayList<GuiComponent> buttons;

    public GuiPanel() {
        buttons = new ArrayList<GuiComponent>();
    }

    public void update() {
        for(GuiComponent b : buttons){
            b.update();
        }
    }

    public void render(Graphics2D g) {
        for(GuiComponent b : buttons){
            b.render(g);
        }
    }
    public void add(GuiComponent button){
        buttons.add(button);
    }
    public void remove(GuiComponent button){
        buttons.remove(button);
    }

    public void mousePressed(MouseEvent e) {
        for(int i = 0 ;i<buttons.size();i++){
            buttons.get(i).mousePressed(e);
        }
    }

    public void mouseReleased(MouseEvent e) {
        for(int i = 0 ;i<buttons.size();i++){
            buttons.get(i).mouseReleased(e);
        }
    }

    public void mouseDragged(MouseEvent e) {
        for(int i = 0 ;i<buttons.size();i++){
            buttons.get(i).mouseDragged(e);
        }
    }

    public void mouseMoved(MouseEvent e) {
        for(int i = 0 ;i<buttons.size();i++){
            buttons.get(i).mouseMoved(e);
        }
    }
}