package jswing.pkgboolean.model;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class JSwingBooleanModel extends JApplet {
    private static final int JFXPANEL_WIDTH_INT = 640;
    private static final int JFXPANEL_HEIGHT_INT = 640;
    private static JFXPanel fxContainer;
    
    private static BooleanModel bm = new BooleanModel();
    private static InvertedIndex ii = new InvertedIndex();
    private static PositionalIndex pi = new PositionalIndex();
    private static ArrayList<String> collectionInverted = new ArrayList<String>();
    private static ArrayList<String> collectionPositional = new ArrayList<String>();

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
                } catch (Exception e) {
                }
                
                JFrame frame = new JFrame("Boolean Retrieval Model");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
                JApplet applet = new JSwingBooleanModel();
                applet.init();
                
                frame.setContentPane(applet.getContentPane());
                
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
                
                applet.start();
            }
        });
    }
    
    @Override
    public void init() {
        fxContainer = new JFXPanel();
        fxContainer.setPreferredSize(new Dimension(JFXPANEL_WIDTH_INT, JFXPANEL_HEIGHT_INT));
        add(fxContainer, BorderLayout.NORTH);
        // create JavaFX scene
        Platform.runLater(new Runnable() {
            
            @Override
            public void run() {
                createScene();
            }
        });
    }
    
    private void createScene() {
        Button fetch = new Button();
        fetch.setText("Fetch Documents From Corpus!");
        fetch.setTranslateX(-200);
        fetch.setTranslateY(-200);
        
        Button construct = new Button();
        construct.setText("Construct Inverted/Positional Index!");
        
        Button openII = new Button();
        Button openPI = new Button();
        
        openII.setText("Open Inverted Index File!");
        openPI.setText("Open Positional Index File!");
        
        openII.setTranslateX(-200);
        openPI.setTranslateX(200);
        
        // Fetching Documents
        fetch.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                if ( collectionInverted.isEmpty() ) {
                    try {
                        collectionInverted = bm.fetchDocuments();
                        collectionPositional = collectionInverted;
                        JOptionPane.showMessageDialog(null, collectionInverted.size() + " Documents Retrieved!");
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(JSwingBooleanModel.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else JOptionPane.showMessageDialog(null, "Document Collection Already Exists!");
            }
        });
        
        
        // Constructing Inverted Index
        construct.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                if ( !collectionInverted.isEmpty() ) {
                    Tokenizer t = new Tokenizer();
                    try {
                        // ii = ii.constructIndex(bm, collectionInverted, t);
                        // ii.printIndex();
                        // ii.writeIndexToFile();
                        
                        pi = pi.constructIndex(bm, collectionPositional, t);
                        pi.writeIndexToFile();
                        // pi.printIndex();
                        
                        JOptionPane.showMessageDialog(null, "Inverted and Positional Index Created!");
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(JSwingBooleanModel.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(JSwingBooleanModel.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else JOptionPane.showMessageDialog(null, "No Document Collection Detected!");
            }
        });
        
        // Open Inverted Index
        openII.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                try {
                    ii.OpenFile();
                } catch (IOException ex) {
                    Logger.getLogger(JSwingBooleanModel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        // Open Positional Index
        openPI.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                try {
                    pi.OpenFile();
                } catch (IOException ex) {
                    Logger.getLogger(JSwingBooleanModel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        StackPane root = new StackPane();
        root.getChildren().add(fetch);
        root.getChildren().add(construct);
        root.getChildren().add(openII);
        root.getChildren().add(openPI);
        fxContainer.setScene(new Scene(root));
    }
    
}
