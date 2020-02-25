package com.jagex.rs2;// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

import java.awt.*;
import java.awt.image.BufferedImage;
import java.lang.reflect.Method;
import java.net.URI;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JMenu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.UIManager;

import org.jvnet.substance.SubstanceDefaultLookAndFeel;
import org.jvnet.substance.SubstanceLookAndFeel;
import org.jvnet.substance.skin.SubstanceMistSilverLookAndFeel;
import org.jvnet.substance.skin.SubstanceModerateLookAndFeel;
import org.jvnet.substance.skin.SubstanceNebulaLookAndFeel;
import org.jvnet.substance.skin.SubstanceOfficeBlue2007LookAndFeel;
import org.jvnet.substance.skin.SubstanceRavenGraphiteGlassLookAndFeel;
import org.jvnet.substance.skin.SubstanceRavenGraphiteLookAndFeel;
import org.jvnet.substance.skin.SubstanceSaharaLookAndFeel;

public final class ClientFrame extends Client implements ActionListener {

	

	public ClientFrame() {
		 try {
	            JFrame.setDefaultLookAndFeelDecorated(false);
	            UIManager.setLookAndFeel(new SubstanceRavenGraphiteGlassLookAndFeel());
	            JFrame jFrame = new JFrame("RuneScape - the massive online adventure game");
	 
	            JPanel jPanel = new JPanel();
	            jPanel.setPreferredSize(new Dimension(765, 503));
	            jPanel.setLayout(new BorderLayout());
	            jPanel.add(this); // Client
	 
	            JMenuBar jMenuBar = new JMenuBar() {
	                @Override
	                public void paintComponent(Graphics graphics) {
	                    Dimension dim = this.getSize();
	                    graphics.drawImage(openImage("/com/jagex/rs2/images/MENU_BAR.gif"), 0, 0, dim.width, dim.height,
	                            this);
	                }
	            };
	            jMenuBar.setPreferredSize(new Dimension(765, 25));
	 
	            JButton logoImageButton = new JButton("LOGO_BUTTON") {
	                @Override
	                public void paintComponent(Graphics graphics) {
	                    graphics.drawImage(openImage("/com/jagex/rs2/images/JAGEX_LOGO.gif"), 2, -4, null);
	                }
	            };
	 
	            JButton toolsMenu = new JButton("MAIN_MENU_BUT") {
	                @Override
	                public void paintComponent(Graphics graphics) {
	                    graphics.drawImage(openImage("/com/jagex/rs2/images/MAIN_MENU_WORLD_SELECT.gif"), 12, -2, null);
	                    drawUnderlinedString(graphics, "Settings", 39, 14);
	                }
	            };
	            toolsMenu.addActionListener(this);
	          
	 
	            JButton worldSelectButton = new JButton("WORLD_SELECT_B") {
	                @Override
	                public void paintComponent(Graphics graphics) {
	                    graphics.drawImage(openImage("/com/jagex/rs2/images/MAIN_MENU_WORLD_SELECT.gif"), 4, -2, null);
	                    drawUnderlinedString(graphics, "High Scores", 30, 14);
	                }
	            };
	            worldSelectButton.addActionListener(this);
	 
	            JButton worldMapButton = new JButton("WORLD_MAP_BUT") {
	                @Override
	                public void paintComponent(Graphics graphics) {
	                    graphics.drawImage(openImage("/com/jagex/rs2/images/WORLD_MAP.gif"), 6, -4, null);
	                    drawUnderlinedString(graphics, "World Map", 34, 14);
	                }
	            };
	            worldMapButton.addActionListener(this);
	 
	            JButton manualButton = new JButton("MANUAL_BUTT") {
	                @Override
	                public void paintComponent(Graphics graphics) {
	                    graphics.drawImage(openImage("/com/jagex/rs2/images/MANUAL.gif"), 2, -2, null);
	                    drawUnderlinedString(graphics, "Forums", 42, 14);
	                }
	            };
	            manualButton.addActionListener(this);
	 
	            JButton rulesAndSecurityButton = new JButton("RULES_AND_SECURITY") {
	                @Override
	                public void paintComponent(Graphics graphics) {
	                    graphics.drawImage(openImage("/com/jagex/rs2/images/RULES_AND_SECURITY.gif"), 6, -2, null);
	                    drawUnderlinedString(graphics, "Rules & Security", 30, 14);
	                }
	            };
	            rulesAndSecurityButton.addActionListener(this);
	 
	            JButton upgradeToMembersButton = new JButton("UPGRADE_TO_MEMBERS") {
	                @Override
	                public void paintComponent(Graphics graphics) {
	                    graphics.drawImage(openImage("/com/jagex/rs2/images/UPGRADE_TO_MEMBERS.gif"), 4, -2, null);
	                    drawUnderlinedString(graphics, "Vote For Points", 22, 14);
	                }
	            };
	            upgradeToMembersButton.addActionListener(this);
	 
	            jMenuBar.add(logoImageButton);
	            jMenuBar.add(toolsMenu);
	            jMenuBar.add(worldSelectButton);
	            jMenuBar.add(worldMapButton);
	            jMenuBar.add(manualButton);
	            jMenuBar.add(rulesAndSecurityButton);
	            jMenuBar.add(upgradeToMembersButton);
	 
	            jFrame.add(jPanel, "Center");
	            jFrame.add(jMenuBar, "North");
	            jFrame.pack();
	 
	            setJFrameIcon(jFrame);
	 
	            jFrame.setVisible(true);
	            jFrame.setResizable(false);
	            jFrame.setLocationRelativeTo(null);
	            jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	            jFrame.toFront();
	            init();
	 
	        } catch (Exception e) {
	            // ignored.
	        }
       
    }
	
	 @Override
	    public void actionPerformed(ActionEvent event) {
	        String actionCommand = event.getActionCommand();
	        try {
	 
	            if (actionCommand.equalsIgnoreCase("World Map")) {
	                openURI("http://miscellania-ps.com");
	            }
	 
	            if (actionCommand.equalsIgnoreCase("WORLD_SELECT_B")) {
	                openURI("http://miscellania-ps.com");
	            }
	 
	            if (actionCommand.equalsIgnoreCase("WORLD_MAP_BUT")) {
	                openURI("http://miscellania-ps.com");
	            }
	 
	            if (actionCommand.equalsIgnoreCase("MANUAL_BUTT")) {
	                openURI("http://miscellania-ps.com/forum/");
	            }
	 
	            if (actionCommand.equalsIgnoreCase("RULES_AND_SECURITY")) {
	                openURI("http://miscellania-ps.com");
	            }
	 
	            if (actionCommand.equalsIgnoreCase("UPGRADE_TO_MEMBERS")) {
	                openURI("http://miscellania-ps.com");
	            }
	 
	            // System.out.println(actionCommand + " clicked.");
	 
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	 
	    private static void openURI(String uri) {
	        Desktop desktop = Desktop.getDesktop();
	        try {
	            desktop.browse(new URI(uri));
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	 
	    public static BufferedImage openImage(String imagePath) {
	        final HashMap<String, BufferedImage> IMAGE_CACHE = new HashMap<>();
	        if (IMAGE_CACHE.containsKey(imagePath))
	            return IMAGE_CACHE.get(imagePath);
	        try {
	            final BufferedImage srcImage = ImageIO.read(ClientFrame.class.getResourceAsStream(imagePath));
	            IMAGE_CACHE.put(imagePath, srcImage);
	            return srcImage;
	        } catch (Throwable t) {
	            throw new RuntimeException("Error opening Image: " + t.getMessage());
	        }
	    }
	 
	    public void drawUnderlinedString(Graphics graphics, String string, int x, int y) {
	        Font currentFont = graphics.getFont();
	        Font newFont = currentFont.deriveFont(currentFont.getSize() * .89F);
	        graphics.setFont(newFont);
	        graphics.drawString(string, x, y);
	        graphics.drawLine(x, y + 1, x + getFontMetrics(newFont).stringWidth(string), y + 1);
	        graphics.setColor(Color.WHITE);
	    }
	
	 public static void setJFrameIcon(JFrame jFrame) {
	        try {
	            jFrame.setIconImage(openImage("/com/jagex/rs2/images/ICON.gif"));
	            if (System.getProperty("os.name").contains("mac")) {
	                    Class<?> util = Class.forName("com.apple.eawt.Application");
	                    Object application = util.getMethod("getApplication", new Class[] {}).invoke(null);
	                    Method setDockIconImage = util.getMethod("setDockIconImage", new Class[] { Image.class });
	                    setDockIconImage.invoke(application, openImage("/com/jagex/rs2/images/ICON.gif"));
	            }
	        } catch (Exception e) {
	            // ignored.
	        }
	    }
	 
	 

}
