import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
/**
 * Client App
 * 
 */
public class GeoApp
{
    private JTextArea text; 
    
    /**
     * Constructor for objects of class GPSApp
     */
    public GeoApp()
    {
        JFrame win = new JFrame("142 GEO App");
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        win.setSize(500, 400);
        
        // Create the button 
        JButton button = new JButton("Load Data");
        
        // put button in a panel and then into the frame
        JPanel back = new JPanel();
        back.setBackground(Color.blue);
        back.add(button);
        win.add(back,BorderLayout.SOUTH );
        
        // now set up the event handler
        button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                process();
            }
            
        });
        
        // create the display area and place it
        text = new JTextArea();
        JScrollPane scrolltxt = new JScrollPane(text);
        win.add(scrolltxt, BorderLayout.CENTER);
        
        // get the frame ready to show
        win.validate();
        win.setVisible(true);
        win.toFront();
    }
    
    // processing the button click
    private void process(){
        
        // get filename from user
        JFileChooser fc = new JFileChooser();
        int returnVal = fc.showOpenDialog(null);
        
        if (returnVal == JFileChooser.APPROVE_OPTION){
            String filename = fc.getSelectedFile().getPath();
            
            // create a LocationSet and display results
            try {
                GeoSet gs = new GeoSet(filename);
                String results = buildDisplay(gs);
                text.setText("File:\t" + filename + "\n\n");
                text.append(results);
            } catch (FileNotFoundException e){
                text.setText("Sorry, file not found\nPlease try again");
            }catch (IllegalArgumentException e) {
                text.setText("Sorry, file must have at least 2 locations\nPlease try again");
            }
        } 
    }
    
    // build & return String for display using information from ls
    private String buildDisplay(GeoSet gs)throws FileNotFoundException {
        StringBuilder output = new StringBuilder();
        Location lookUp = gs.find("Seattle");
        Location[] furthest = gs.farthest();
        double minD = gs.findMinDistance();
        
        output.append("Number of locations =  " + gs.getCount() + '\n');
        output.append("Min distance (mi)    =  " + minD + "\n\n");
        
        output.append("Farthest Locations\n\t" + furthest[0] + "\n\t" + furthest[1] +"\n");
        output.append("\tdistance (mi) \t=  " + furthest[0].distance(furthest[1]) + "\n\n");
        
        if (lookUp !=null){
            output.append("Seattle found:\n\t" + lookUp);
        }
        else {
            output.append("Seattle not found");
        }
        
        output.append("\n==========================\n\n"+ gs);
        return output.toString();
        
    }
    

    public static void main(String [] args) {
         //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                GeoApp b = new GeoApp();
            }
        });
    }
}
