// package bswanepo.character;

// import java.awt.Color;
// import java.awt.Graphics;
// import java.awt.Graphics2D;
// import java.awt.Paint;
// import java.awt.Container;
// import javax.swing.DefaultListModel;
// import javax.swing.JComboBox;
// import javax.swing.JComponent;
// import javax.swing.JFrame;
// import javax.swing.JLabel;
// import javax.swing.JList;
// import javax.swing.JPanel;
// import javax.swing.JScrollPane;
// import javax.swing.JSplitPane;
// import javax.swing.SwingUtilities;

// import java.awt.image.BufferStrategy;
// import java.util.ArrayList;
// import java.awt.Rectangle;
// import bswanepo.Menu;
// import bswanepo.display.Display;
// import bswanepo.mainMenu.GuiComponent;
// import bswanepo.states.State;

// import java.awt.event.ActionListener;

// public class GuiSplitPane extends JComponent {
//     private Rectangle clickBox;

//     private ArrayList<ActionListener> actionListeners;
//     private String text = "";

//     private BufferStrategy bs;
//     JList<Characters> list = new JList<>();
//     DefaultListModel<Characters> model = new DefaultListModel<>();
//     JSplitPane splitPane = new JSplitPane();
//     JPanel panel = new JPanel();
//     JPanel panel1 = new JPanel();
//     JLabel label = new JLabel("Aweeee");
//     JFrame frame = new JFrame();
//     private Display display;
//     private Color released;
//     private Color hover;
//     private Color pressed;
//     Container con =new Container();


//     public GuiSplitPane() {
//         super();
//         // clickBox = new Rectangle(x,y,width,height);
//         // clickBox = new Rectangle(x,y,width,height);
//         // actionListeners = new ArrayList<ActionListener>();
//         // released = Color.MAGENTA;
//         // hover = Color.PINK;
//         // pressed = Color.lightGray;
//         // frame.add(panel);
//         display = Menu.display;
	
      
		
	
		
//     list.setModel(model);
//     splitPane.setLeftComponent(new JScrollPane(list));
//     model.addElement(new Characters("kingKong"));
//     model.addElement(new Characters("kingKong"));
//     panel.add(label);
//     panel.setBackground(Color.white);
//     splitPane.setRightComponent(new JScrollPane(panel));
//     panel1.add(splitPane);
//     }
//     public void update(){}

//     public  void  render(Graphics2D g){
//     //    SwingUtilities.paintComponent(g, splitPane, null, 10,10,200,300);
//     // bs = display.getCanvas().getBufferStrategy();
//     // display.getFrame().add()
//     // bs.show();
//     // g.dispose();
//     // g2.setStroke(new BasicStroke(0.001f));
    
//     }
//     public JSplitPane getSplitPane(){
//         return this.splitPane;
//     }
//     // public void addComp(JSplitPane pane){
//     //     this.panel.add(pane);
//     // }
//     // public GuiComponent getpane(){
//     //     return this.splitPane;
//     // }
   
   

  




    
// }

