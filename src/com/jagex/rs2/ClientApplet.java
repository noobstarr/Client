package com.jagex.rs2;// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 


import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

import javax.swing.SwingUtilities;

import com.jagex.rs2.model.J_ImageProducer;
import com.jagex.rs2.model.inter.InterfaceListener;

public class ClientApplet extends Applet
        implements Runnable, MouseListener, MouseMotionListener, KeyListener, FocusListener, WindowListener, MouseWheelListener {

	private static final long serialVersionUID = 1L;
	static Client Game;
	
	public final void createClientFrame(int i, int j) {
        myWidth = j;
        myHeight = i;
        gameFrame = new ClientFrame();
        graphics = getGameComponent().getGraphics();
        fullGameScreen = new J_ImageProducer(myWidth, myHeight, getGameComponent());
        startRunnable(this, 1);
    }

    public final void initClientFrame(int i, int j) {
        myWidth = j;
        myHeight = i;
        graphics = getGameComponent().getGraphics();
        fullGameScreen = new J_ImageProducer(myWidth, myHeight, getGameComponent());
        startRunnable(this, 1);
    }

    public void run() {
        getGameComponent().addMouseListener(this);
        getGameComponent().addMouseMotionListener(this);
        getGameComponent().addMouseWheelListener(this);
        getGameComponent().addKeyListener(this);
        getGameComponent().addFocusListener(this);
        
        drawLoadingText(0, "Loading...");
        startUp();
        int i = 0;
        int j = 256;
        int k = 1;
        int i1 = 0;
        int j1 = 0;
        for (int k1 = 0; k1 < 10; k1++)
            aLongArray7[k1] = System.currentTimeMillis();

        while (anInt4 >= 0) {
            if (anInt4 > 0) {
                anInt4--;
                if (anInt4 == 0) {
                    exit();
                    return;
                }
            }
            int i2 = j;
            int j2 = k;
            j = 300;
            k = 1;
            long l1 = System.currentTimeMillis();
            if (aLongArray7[i] == 0L) {
                j = i2;
                k = j2;
            } else if (l1 > aLongArray7[i])
                j = (int) ((long) (2560 * delayTime) / (l1 - aLongArray7[i]));
            if (j < 25)
                j = 25;
            if (j > 256) {
                j = 256;
                k = (int) ((long) delayTime - (l1 - aLongArray7[i]) / 10L);
            }
            if (k > delayTime)
                k = delayTime;
            aLongArray7[i] = l1;
            i = (i + 1) % 10;
            if (k > 1) {
                for (int k2 = 0; k2 < 10; k2++)
                    if (aLongArray7[k2] != 0L)
                        aLongArray7[k2] += k;

            }
            if (k < minDelay)
                k = minDelay;
            try {
                Thread.sleep(k);
            }
            catch (InterruptedException _ex) {
                j1++;
            }
            for (; i1 < 256; i1 += j) {
                clickMode3 = clickMode1;
                saveClickX = clickX;
                saveClickY = clickY;
                aLong29 = clickTime;
                clickMode1 = 0;
                processGameLoop();
                readIndex = writeIndex;
            }

            i1 &= 0xff;
            if (delayTime > 0)
                fps = (1000 * j) / (delayTime * 256);
            processDrawing();
            if (shouldDebug) {
                System.out.println("ntime:" + l1);
                for (int l2 = 0; l2 < 10; l2++) {
                    int i3 = ((i - l2 - 1) + 20) % 10;
                    System.out.println("otim" + i3 + ":" + aLongArray7[i3]);
                }

                System.out.println("fps:" + fps + " ratio:" + j + " count:" + i1);
                System.out.println("del:" + k + " deltime:" + delayTime + " mindel:" + minDelay);
                System.out.println("intex:" + j1 + " opos:" + i);
                shouldDebug = false;
                j1 = 0;
            }
        }
        if (anInt4 == -1)
            exit();
    }

    private void exit() {
        anInt4 = -2;
        cleanUpForQuit();
        if (gameFrame != null) {
            try {
                Thread.sleep(1000L);
            }
            catch (Exception _ex) {
            }
            try {
                System.exit(0);
            }
            catch (Throwable _ex) {
            }
        }
    }

    public final void method4(int i) {
        delayTime = 1000 / i;
    }

    public final void start() {
        if (anInt4 >= 0)
            anInt4 = 0;
    }

    public final void stop() {
        if (anInt4 >= 0)
            anInt4 = 4000 / delayTime;
    }

    public final void destroy() {
        anInt4 = -1;
        try {
            Thread.sleep(5000L);
        }
        catch (Exception _ex) {
        }
        if (anInt4 == -1)
            exit();
    }

    public void update(Graphics g) {
        if (graphics == null)
            graphics = g;
        shouldClearScreen = true;
        raiseWelcomeScreen();
    }

    public void paint(Graphics g) {
        if (graphics == null)
            graphics = g;
        shouldClearScreen = true;
        raiseWelcomeScreen();
    }

    public final void mousePressed(MouseEvent mouseevent) {
        int i = mouseevent.getX();
        int j = mouseevent.getY();
        if (gameFrame != null) {
            i -= 4;
            j -= 22;
        }
        idleTime = 0;
        clickX = i;
        clickY = j;
        clickTime = System.currentTimeMillis();
        if (SwingUtilities.isRightMouseButton(mouseevent)) {
            clickMode1 = 2;
            clickMode2 = 2;
        } else if(SwingUtilities.isLeftMouseButton(mouseevent)){
            clickMode1 = 1;
            clickMode2 = 1;
        }
    }
    
    public void mouseWheelMoved(MouseWheelEvent event) {
		int rotation = event.getWheelRotation();
		handleInterfaceScrolling(event);
	
	}
    
    public void handleInterfaceScrolling(MouseWheelEvent event) {
		int rotation = event.getWheelRotation();
		int positionX = 0;
		int positionY = 0;
		int width = 0;
		int height = 0;
		int offsetX = 0;
		int offsetY = 0;
		int childID = 0;
		/* Tab interface scrolling */
		int tabInterfaceID = Client.tabInterfaceIDs[Client.tabID];
		if (tabInterfaceID != -1) {
			InterfaceListener tab = InterfaceListener.interfaceCache[tabInterfaceID];
			offsetX = 765 - 218;
			offsetY = 503 - 298;
			for (int index = 0; index < tab.children.length; index++) {
				if (InterfaceListener.interfaceCache[tab.children[index]].scrollMax > 0) {
					childID = index;
					positionX = tab.childX[index];
					positionY = tab.childY[index];
					width = InterfaceListener.interfaceCache[tab.children[index]].width;
					height = InterfaceListener.interfaceCache[tab.children[index]].height;
					break;
				}
			}
			if (mouseX > offsetX + positionX && mouseY > offsetY + positionY && mouseX < offsetX + positionX + width && mouseY < offsetY + positionY + height) {
				InterfaceListener.interfaceCache[tab.children[childID]].scrollPosition += rotation * 30;
				Client.tabAreaAltered = true;
				Client.needDrawTabArea = true;
			}
		}
		/* Main interface scrolling */
		if (Client.openInterfaceID != -1) {
			InterfaceListener rsi = InterfaceListener.interfaceCache[Client.openInterfaceID];
			offsetX = 4;
			offsetY = 4;
			for (int index = 0; index < rsi.children.length; index++) {
				if (InterfaceListener.interfaceCache[rsi.children[index]].scrollMax > 0) {
					childID = index;
					positionX = rsi.childX[index];
					positionY = rsi.childY[index];
					width = InterfaceListener.interfaceCache[rsi.children[index]].width;
					height = InterfaceListener.interfaceCache[rsi.children[index]].height;
					break;
				}
			}
			if (mouseX > offsetX + positionX && mouseY > offsetY + positionY && mouseX < offsetX + positionX + width && mouseY < offsetY + positionY + height) {
				InterfaceListener.interfaceCache[rsi.children[childID]].scrollPosition += rotation * 30;
			}
		}
		
		if(mouseX > 0 && mouseX < 512 && mouseY > 503 - 165 && mouseY < 503 - 25) {
			int scrollPos = Client.anInt1089;
			scrollPos -= rotation * 30;		
			if(scrollPos < 0)
				scrollPos = 0;
			if(scrollPos > Client.anInt1211 - 110)
				scrollPos = Client.anInt1211 - 110;
			if(Client.anInt1089 != scrollPos) {
				Client.anInt1089 = scrollPos;
				Client.inputTaken = true;
			}
		}
		

		if ((mouseX < 518 && mouseY < 340) &&(Client.openInterfaceID == -1)) {
		if (rotation > 0) {
			if (Client.clientZoom == 1300) 
				return;
			Client.clientZoom = Client.clientZoom + 50;
		}
		else {
			if (Client.clientZoom == 150)
				return;
			Client.clientZoom = Client.clientZoom - 50;
		}
		}
	}
    
    public void interfaceScrollCheck(MouseWheelEvent e) {
		try {
			int Rotation = e.getWheelRotation();

			int TAB = 0, WINDOW = 1;

			int POSX = 0, POSY = 1, WIDTH = 2, HEIGHT = 3, OFFX = 4, OFFY = 5, CHILD = 6, SENSITIVITY = 7;

			int[] InterfaceID = { Game.getTabInterfaceIDs()[Game.getTabID()],
					Game.getOpenInterfaceID() };

			int[] InterfaceSetting = { 0, 0, /* positionX, positionY */
			0, 0, /* Width, Height */
			0, 0, /* offsetX, offsetY */
			0, 15 /* Child ID, Sensitivity */
			};

			int[] IS = InterfaceSetting;

			if (InterfaceID[TAB] != -1) {
				InterfaceListener Tab = InterfaceListener.interfaceCache[InterfaceID[TAB]];
				InterfaceSetting[OFFX] = 547;
				InterfaceSetting[OFFY] = 205;
				for (int Index = 0; Index < Tab.children.length; Index++) {
					if (InterfaceListener.interfaceCache[Tab.children[Index]].scrollMax > 0) {
						InterfaceSetting[CHILD] = Index;
						InterfaceSetting[POSX] = Tab.childX[Index];
						InterfaceSetting[POSY] = Tab.childY[Index];
						InterfaceSetting[WIDTH] = getChildWidth(Tab, Index);
						InterfaceSetting[HEIGHT] = getChildHeight(Tab, Index);
						break;
					}
				}

				if (mouseX > IS[OFFX] + IS[POSX]
						&& mouseY > IS[OFFY] + IS[POSY]
						&& mouseX < IS[OFFX] + IS[POSX] + IS[WIDTH]
						&& mouseY < IS[OFFY] + IS[POSY] + IS[HEIGHT]) {
					switch (InterfaceID[TAB]) {
					case 962: /* Music Tab */
						IS[SENSITIVITY] = 30;
						break;

					case 638: /* Quest Tab */
						IS[SENSITIVITY] = 30;
						break;

					case 1151: /* Magic Tab */
						IS[SENSITIVITY] = 7;
						break;

					case 147: /* Emote Tab */
						IS[SENSITIVITY] = 15;
						break;

					default:
						IS[SENSITIVITY] = 15;
						break;
					}
					;

					switch (Rotation) {
					case -1:
						if (InterfaceListener.interfaceCache[Tab.children[IS[CHILD]]].scrollPosition != 0) {
							InterfaceListener.interfaceCache[Tab.children[IS[CHILD]]].scrollPosition += Rotation
									* IS[SENSITIVITY];
							Game.setNeedDrawTabArea(true);
							Game.setTabAreaAltered(true);
						}
						break;

					case 1:
						if (InterfaceListener.interfaceCache[Tab.children[IS[CHILD]]].scrollPosition != InterfaceListener.interfaceCache[Tab.children[IS[CHILD]]].scrollMax
								- InterfaceListener.interfaceCache[Tab.children[IS[CHILD]]].height) {
							InterfaceListener.interfaceCache[Tab.children[IS[CHILD]]].scrollPosition += Rotation
									* IS[SENSITIVITY];
							Game.setNeedDrawTabArea(true);
							Game.setTabAreaAltered(true);
						}
						break;
					}
				}
			}

			if (InterfaceID[WINDOW] != -1) {
				InterfaceListener Window = InterfaceListener.interfaceCache[InterfaceID[WINDOW]];
				InterfaceSetting[OFFX] = 4;
				InterfaceSetting[OFFY] = 4;
				for (int Index = 0; Index < Window.children.length; Index++) {
					if (InterfaceListener.interfaceCache[Window.children[Index]].scrollMax > 0) {
						InterfaceSetting[CHILD] = Index;
						InterfaceSetting[POSX] = Window.childX[Index];
						InterfaceSetting[POSY] = Window.childY[Index];
						InterfaceSetting[WIDTH] = getChildWidth(Window, Index);
						InterfaceSetting[HEIGHT] = getChildHeight(Window, Index);
						break;
					}
				}

				if (mouseX > IS[OFFX] + IS[POSX]
						&& mouseY > IS[OFFY] + IS[POSY]
						&& mouseX < IS[OFFX] + IS[POSX] + IS[WIDTH]
						&& mouseY < IS[OFFY] + IS[POSY] + IS[HEIGHT]) {

					switch (InterfaceID[WINDOW]) {
					default:
						IS[SENSITIVITY] = 30;
						break;
					}
					;

					switch (Rotation) {
					case -1:
						if (InterfaceListener.interfaceCache[Window.children[IS[CHILD]]].scrollPosition != 0) {
							InterfaceListener.interfaceCache[Window.children[IS[CHILD]]].scrollPosition += Rotation
									* IS[SENSITIVITY];
							Game.setNeedDrawTabArea(true);
							Game.setTabAreaAltered(true);
						}
						break;

					case 1:
						if (InterfaceListener.interfaceCache[Window.children[IS[CHILD]]].scrollPosition != InterfaceListener.interfaceCache[Window.children[IS[CHILD]]].scrollMax
								- InterfaceListener.interfaceCache[Window.children[IS[CHILD]]].height) {
							InterfaceListener.interfaceCache[Window.children[IS[CHILD]]].scrollPosition += Rotation
									* IS[SENSITIVITY];
						}
						break;
					}
					InterfaceListener.interfaceCache[Window.children[InterfaceSetting[CHILD]]].scrollPosition += Rotation * 30;
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public int getScrollPosition(InterfaceListener Interface, int Child) {
		return InterfaceListener.interfaceCache[Interface.children[Child]].scrollPosition;
	}

	public int getChildWidth(InterfaceListener Interface, int Index) {
		return InterfaceListener.interfaceCache[Interface.children[Index]].width;
	}

	public int getChildHeight(InterfaceListener Interface, int Index) {
		return InterfaceListener.interfaceCache[Interface.children[Index]].height;
	}

    public final void mouseReleased(MouseEvent mouseevent) {
        idleTime = 0;
        clickMode2 = 0;
    }

    public final void mouseClicked(MouseEvent mouseevent) {
    }

    public final void mouseEntered(MouseEvent mouseevent) {
    }

    public final void mouseExited(MouseEvent mouseevent) {
        idleTime = 0;
        mouseX = -1;
        mouseY = -1;
    }

    public final void mouseDragged(MouseEvent mouseevent) {
        int i = mouseevent.getX();
        int j = mouseevent.getY();
        if (gameFrame != null) {
            i -= 4;
            j -= 22;
        }
        idleTime = 0;
        mouseX = i;
        mouseY = j;
    }

    public final void mouseMoved(MouseEvent mouseevent) {
        int i = mouseevent.getX();
        int j = mouseevent.getY();
        if (gameFrame != null) {
            i -= 4;
            j -= 22;
        }
        idleTime = 0;
        mouseX = i;
        mouseY = j;
    }

    public final void keyPressed(KeyEvent keyevent) {
        idleTime = 0;
        int i = keyevent.getKeyCode();
        int j = keyevent.getKeyChar();
        if (j < 30)
            j = 0;
        if (i == 37)
            j = 1;
        if (i == 39)
            j = 2;
        if (i == 38)
            j = 3;
        if (i == 40)
            j = 4;
        if (i == 17)
            j = 5;
        if (i == 8)
            j = 8;
        if (i == 127)
            j = 8;
        if (i == 9)
            j = 9;
        if (i == 10)
            j = 10;
        if (i >= 112 && i <= 123)
            j = (1008 + i) - 112;
        if (i == 36)
            j = 1000;
        if (i == 35)
            j = 1001;
        if (i == 33)
            j = 1002;
        if (i == 34)
            j = 1003;
        if (j > 0 && j < 128)
            keyArray[j] = 1;
        if (j > 4) {
            charQueue[writeIndex] = j;
            writeIndex = writeIndex + 1 & 0x7f;
        }
    }

    public final void keyReleased(KeyEvent keyevent) {
        idleTime = 0;
        int i = keyevent.getKeyCode();
        char c = keyevent.getKeyChar();
        if (c < '\036')
            c = '\0';
        if (i == 37)
            c = '\001';
        if (i == 39)
            c = '\002';
        if (i == 38)
            c = '\003';
        if (i == 40)
            c = '\004';
        if (i == 17)
            c = '\005';
        if (i == 8)
            c = '\b';
        if (i == 127)
            c = '\b';
        if (i == 9)
            c = '\t';
        if (i == 10)
            c = '\n';
        if (c > 0 && c < '\200')
            keyArray[c] = 0;
    }

    public final void keyTyped(KeyEvent keyevent) {
    }

    public final int readChar(int dummy) {
        while (dummy >= 0) {
            for (int j = 1; j > 0; j++) ;
        }
        int k = -1;
        if (writeIndex != readIndex) {
            k = charQueue[readIndex];
            readIndex = readIndex + 1 & 0x7f;
        }
        return k;
    }

    public final void focusGained(FocusEvent focusevent) {
        awtFocus = true;
        shouldClearScreen = true;
        raiseWelcomeScreen();
    }

    public final void focusLost(FocusEvent focusevent) {
        awtFocus = false;
        for (int i = 0; i < 128; i++)
            keyArray[i] = 0;

    }

    public final void windowActivated(WindowEvent windowevent) {
    }

    public final void windowClosed(WindowEvent windowevent) {
    }

    public final void windowClosing(WindowEvent windowevent) {
        destroy();
    }

    public final void windowDeactivated(WindowEvent windowevent) {
    }

    public final void windowDeiconified(WindowEvent windowevent) {
    }

    public final void windowIconified(WindowEvent windowevent) {
    }

    public final void windowOpened(WindowEvent windowevent) {
    }

    void startUp() {
    }

    void processGameLoop() {
    }

    void cleanUpForQuit() {
    }

    void processDrawing() {
    }

    void raiseWelcomeScreen() {
    }

    Component getGameComponent() {
       
            return this;
    }

    public void startRunnable(Runnable runnable, int priority) {
        Thread thread = new Thread(runnable);
        thread.start();
        thread.setPriority(priority);
    }

    void drawLoadingText(int i, String s) {
        while (graphics == null) {
            graphics = getGameComponent().getGraphics();
            try {
               getGameComponent().repaint();
            }
            catch (Exception _ex) {
            }
            try {
                Thread.sleep(1000L);
            }
            catch (Exception _ex) {
            }
        }
        Font font = new Font("Helvetica", 1, 13);
        FontMetrics fontmetrics = getGameComponent().getFontMetrics(font);
        Font font1 = new Font("Helvetica", 0, 13);
        getGameComponent().getFontMetrics(font1);
        if (shouldClearScreen) {
            graphics.setColor(Color.black);
            graphics.fillRect(0, 0, myWidth, myHeight);
            shouldClearScreen = false;
        }
        Color color = new Color(140, 17, 17);
        int j = myHeight / 2 - 18;
        graphics.setColor(color);
        graphics.drawRect(myWidth / 2 - 152, j, 304, 34);
        graphics.fillRect(myWidth / 2 - 150, j + 2, i * 3, 30);
        graphics.setColor(Color.black);
        graphics.fillRect((myWidth / 2 - 150) + i * 3, j + 2, 300 - i * 3, 30);
        graphics.setFont(font);
        graphics.setColor(Color.white);
        graphics.drawString(s, (myWidth - fontmetrics.stringWidth(s)) / 2, j + 22);
    }

    ClientApplet() {
        delayTime = 20;
        minDelay = 1;
        aLongArray7 = new long[10];
        shouldDebug = false;
        shouldClearScreen = true;
        awtFocus = true;
        keyArray = new int[128];
        charQueue = new int[128];
    }

    private int anInt4;
    private int delayTime;
    int minDelay;
    private final long[] aLongArray7;
    int fps;
    boolean shouldDebug;
    int myWidth;
    int myHeight;
    Graphics graphics;
    J_ImageProducer fullGameScreen;
    ClientFrame gameFrame;
    private boolean shouldClearScreen;
    boolean awtFocus;
    int idleTime;
    int clickMode2;
    public int mouseX;
    public int mouseY;
    private int clickMode1;
    private int clickX;
    private int clickY;
    private long clickTime;
    int clickMode3;
    int saveClickX;
    int saveClickY;
    long aLong29;
    public final int[] keyArray;
    private final int[] charQueue;
    private int readIndex;
    private int writeIndex;
    public static int anInt34;
}
