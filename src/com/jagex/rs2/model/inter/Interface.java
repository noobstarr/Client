package com.jagex.rs2.model.inter;

import com.jagex.rs2.model.chat.TextDrawingArea;
import com.jagex.rs2.net.StreamLoader;

public class Interface extends InterfaceListener {

	public static void load(StreamLoader streamLoader, TextDrawingArea[] textDrawingAreas) {
		Sidebar0(textDrawingAreas);
	}

	public static void specialBar(int id) //7599
	{
		/*addActionButton(ID, SpriteOFF, SpriteON, Width, Height, "SpriteText");*/
		addActionButton(id-12, 7587, -1, 150, 26, "Use @gre@Special Attack");
		/*removeSomething(ID);*/
		for (int i = id-11; i < id; i++)
			removeSomething(i);

		InterfaceListener rsi = interfaceCache[id-12];
		rsi.width = 150;
		rsi.height = 26;

		rsi = interfaceCache[id];
		rsi.width = 150;
		rsi.height = 26;

		rsi.child(0, id-12, 0, 0);

		rsi.child(12, id+1, 3, 7);

		rsi.child(23, id+12, 16, 8);

		for (int i = 13; i < 23; i++) {
			rsi.childY[i] -= 1;
		}

		rsi = interfaceCache[id+1];
		rsi.type = 5;
		rsi.sprite1 = customSpriteLoader(7600, "");

		for (int i = id+2; i < id+12; i++) {
			rsi = interfaceCache[i];
			rsi.type = 5;
		}

		addNewSprite(id+2, 7601);addNewSprite(id+3, 7602);
		addNewSprite(id+4, 7603);addNewSprite(id+5, 7604);
		addNewSprite(id+6, 7605);addNewSprite(id+7, 7606);
		addNewSprite(id+8, 7607);addNewSprite(id+9, 7608);
		addNewSprite(id+10, 7609);addNewSprite(id+11, 7610);
	}

	public static void Sidebar0(TextDrawingArea[] tda)
	{
		/*Sidebar0a(id, id2, id3, "text1", "text2", "text3", "text4", str1x, str1y, str2x, str2y, str3x, str3y, str4x, str4y, img1x, img1y, img2x, img2y, img3x, img3y, img4x, img4y, tda);*/
		Sidebar0a(1698, 1701, 7499, "Chop", "Hack", "Smash", "Block", 42, 75, 127, 75, 39, 128, 125, 128, 122, 103, 40, 50, 122, 50, 40, 103, tda);
		Sidebar0a(2276, 2279, 7574, "Stab", "Lunge", "Slash", "Block", 43, 75, 124, 75, 41, 128, 125, 128, 122, 103, 40, 50, 122, 50, 40, 103, tda);
		Sidebar0a(2423, 2426, 7599, "Chop", "Slash", "Lunge", "Block", 42, 75, 125, 75, 40, 128, 125, 128, 122, 103, 40, 50, 122, 50, 40, 103, tda);
		Sidebar0a(3796, 3799, 7624, "Pound", "Pummel", "Spike", "Block", 39, 75, 121, 75, 41, 128, 125, 128, 122, 103, 40, 50, 122, 50, 40, 103, tda);
		Sidebar0a(4679, 4682, 7674, "Lunge", "Swipe", "Pound", "Block", 40, 75, 124, 75, 39, 128, 125, 128, 122, 103, 40, 50, 122, 50, 40, 103, tda);
		Sidebar0a(4705, 4708, 7699, "Chop", "Slash", "Smash", "Block", 42, 75, 125, 75, 39, 128, 125, 128, 122, 103, 40, 50, 122, 50, 40, 103, tda);
		Sidebar0a(5570, 5573, 7724, "Spike", "Impale", "Smash", "Block", 41, 75, 123, 75, 39, 128, 125, 128, 122, 103, 40, 50, 122, 50, 40, 103, tda);
		Sidebar0a(7762, 7765, 7800, "Chop", "Slash", "Lunge", "Block", 42, 75, 125, 75, 40, 128, 125, 128, 122, 103, 40, 50, 122, 50, 40, 103, tda);
		/*Sidebar0b(id, id2, "text1", "text2", "text3", "text4", str1x, str1y, str2x, str2y, str3x, str3y, str4x, str4y, img1x, img1y, img2x, img2y, img3x, img3y, img4x, img4y, tda);*/
		Sidebar0b(776, 779, "Reap", "Chop", "Jab", "Block", 42, 75, 126, 75, 46, 128, 125, 128, 122, 103, 122, 50, 40, 103, 40, 50, tda);
		/*Sidebar0c(id, id2, id3, "text1", "text2", "text3", str1x, str1y, str2x, str2y, str3x, str3y, img1x, img1y, img2x, img2y, img3x, img3y, tda);*/
		Sidebar0c(425, 428, 7474, "Pound", "Pummel", "Block", 39, 75, 121, 75, 42, 128, 40, 103, 40, 50, 122, 50, tda);
		Sidebar0c(1749, 1752, 7524, "Accurate", "Rapid", "Longrange", 33, 75, 125, 75, 29, 128, 40, 103, 40, 50, 122, 50, tda);
		Sidebar0c(1764, 1767, 7549, "Accurate", "Rapid", "Longrange", 33, 75, 125, 75, 29, 128, 40, 103, 40, 50, 122, 50, tda);
		Sidebar0c(4446, 4449, 7649, "Accurate", "Rapid", "Longrange", 33, 75, 125, 75, 29, 128, 40, 103, 40, 50, 122, 50, tda);
		Sidebar0c(5855, 5857, 7749, "Punch", "Kick", "Block", 40, 75, 129, 75, 42, 128, 40, 50, 122, 50, 40, 103, tda);
		Sidebar0c(6103, 6132, 6117, "Bash", "Pound", "Block", 43, 75, 124, 75, 42, 128, 40, 103, 40, 50, 122, 50, tda);
		Sidebar0c(8460, 8463, 8493, "Jab", "Swipe", "Fend", 46, 75, 124, 75, 43, 128, 40, 103, 40, 50, 122, 50, tda);
		Sidebar0c(12290, 12293, 12323, "Flick", "Lash", "Deflect", 44, 75, 127, 75, 36, 128, 40, 50, 40, 103, 122, 50, tda);
		/*Sidebar0d(id, id2, "text1", "text2", "text3", str1x, str1y, str2x, str2y, str3x, str3y, img1x, img1y, img2x, img2y, img3x, img3y, tda);*/
		Sidebar0d(328, 331, "Bash", "Pound", "Focus", 42, 66, 39, 101, 41, 136, 40, 120, 40, 50, 40, 85, tda);

		InterfaceListener rsi = addInterface(19300);
		/*textSize(ID, wid, Size);*/
		textSize(3983, tda, 0);
		/*addToggleButton(id, sprite, config, width, height, wid);*/
		addToggleButton(150, 150, 172, 150, 44, "Auto Retaliate");

		rsi.totalChildren(2);
		rsi.child(0, 3983, 52, 25); //combat level
		rsi.child(1, 150, 21, 153); //auto retaliate

		rsi = interfaceCache[3983];
		rsi.centerText = true;
		rsi.textColor = 0xff981f;
	}

	public static void Sidebar0a(int id, int id2, int id3, String text1, String text2, String text3, String text4,
			int str1x, int str1y, int str2x, int str2y, int str3x, int str3y, int str4x, int str4y,
			int img1x, int img1y, int img2x, int img2y, int img3x, int img3y, int img4x, int img4y, TextDrawingArea[] tda) //4button spec
	{
		InterfaceListener rsi = addInterface(id); //2423
		/*addText(ID, "Text", tda, Size, Colour, Centered);*/
		addText(id2, "-2", tda, 3, 0xff981f, true, true); //2426
		addText(id2+11, text1, tda, 0, 0xff981f, false, false);
		addText(id2+12, text2, tda, 0, 0xff981f, false, false);
		addText(id2+13, text3, tda, 0, 0xff981f, false, false);
		addText(id2+14, text4, tda, 0, 0xff981f, false, false);
		/*specialBar(ID);*/
		specialBar(id3); //7599

		rsi.width = 190;
		rsi.height = 261;

		int last = 15; int frame = 0;
		rsi.totalChildren(last);

		rsi.child(frame, id2+3, 21, 46); frame++; //2429
		rsi.child(frame, id2+4, 104, 99); frame++; //2430
		rsi.child(frame, id2+5, 21, 99); frame++; //2431
		rsi.child(frame, id2+6, 105, 46); frame++; //2432

		rsi.child(frame, id2+7, img1x, img1y); frame++; //bottomright 2433
		rsi.child(frame, id2+8, img2x, img2y); frame++; //topleft 2434
		rsi.child(frame, id2+9, img3x, img3y); frame++; //bottomleft 2435
		rsi.child(frame, id2+10, img4x, img4y); frame++; //topright 2436

		rsi.child(frame, id2+11, str1x, str1y); frame++; //chop 2437
		rsi.child(frame, id2+12, str2x, str2y); frame++; //slash 2438
		rsi.child(frame, id2+13, str3x, str3y); frame++; //lunge 2439
		rsi.child(frame, id2+14, str4x, str4y); frame++; //block 2440

		rsi.child(frame, 19300, 0, 0); frame++; //stuffs
		rsi.child(frame, id2, 94, 4); frame++; //weapon 2426
		rsi.child(frame, id3, 21, 205); frame++; //special attack 7599

		for (int i = id2+3; i < id2+7; i++) { //2429 - 2433
			rsi = interfaceCache[i];
			rsi.sprite1 = customSpriteLoader(19301, ""); rsi.sprite2 = customSpriteLoader(19301, "a");
			rsi.width = 68; rsi.height = 44;
		}
	}

	public static void Sidebar0b(int id, int id2, String text1, String text2, String text3, String text4,
			int str1x, int str1y, int str2x, int str2y, int str3x, int str3y, int str4x, int str4y,
			int img1x, int img1y, int img2x, int img2y, int img3x, int img3y, int img4x, int img4y, TextDrawingArea[] tda) //4button nospec
	{
		InterfaceListener rsi = addInterface(id); //2423
		/*addText(ID, "Text", tda, Size, Colour, Centered);*/
		addText(id2, "-2", tda, 3, 0xff981f, true, true); //2426
		addText(id2+11, text1, tda, 0, 0xff981f, false, false);
		addText(id2+12, text2, tda, 0, 0xff981f, false, false);
		addText(id2+13, text3, tda, 0, 0xff981f, false, false);
		addText(id2+14, text4, tda, 0, 0xff981f, false, false);

		rsi.width = 190;
		rsi.height = 261;

		int last = 14; int frame = 0;
		rsi.totalChildren(last);

		rsi.child(frame, id2+3, 21, 46); frame++; //2429
		rsi.child(frame, id2+4, 104, 99); frame++; //2430
		rsi.child(frame, id2+5, 21, 99); frame++; //2431
		rsi.child(frame, id2+6, 105, 46); frame++; //2432

		rsi.child(frame, id2+7, img1x, img1y); frame++; //bottomright 2433
		rsi.child(frame, id2+8, img2x, img2y); frame++; //topleft 2434
		rsi.child(frame, id2+9, img3x, img3y); frame++; //bottomleft 2435
		rsi.child(frame, id2+10, img4x, img4y); frame++; //topright 2436

		rsi.child(frame, id2+11, str1x, str1y); frame++; //chop 2437
		rsi.child(frame, id2+12, str2x, str2y); frame++; //slash 2438
		rsi.child(frame, id2+13, str3x, str3y); frame++; //lunge 2439
		rsi.child(frame, id2+14, str4x, str4y); frame++; //block 2440

		rsi.child(frame, 19300, 0, 0); frame++; //stuffs
		rsi.child(frame, id2, 94, 4); frame++; //weapon 2426

		for (int i = id2+3; i < id2+7; i++) { //2429 - 2433
			rsi = interfaceCache[i];
			rsi.sprite1 = customSpriteLoader(19301, ""); rsi.sprite2 = customSpriteLoader(19301, "a");
			rsi.width = 68; rsi.height = 44;
		}
	}

	public static void Sidebar0c(int id, int id2, int id3, String text1, String text2, String text3,
			int str1x, int str1y, int str2x, int str2y, int str3x, int str3y,
			int img1x, int img1y, int img2x, int img2y, int img3x, int img3y, TextDrawingArea[] tda) //3button spec
	{
		InterfaceListener rsi = addInterface(id); //2423
		/*addText(ID, "Text", tda, Size, Colour, Centered);*/
		addText(id2, "-2", tda, 3, 0xff981f, true, true); //2426
		addText(id2+9, text1, tda, 0, 0xff981f, false, false);
		addText(id2+10, text2, tda, 0, 0xff981f, false, false);
		addText(id2+11, text3, tda, 0, 0xff981f, false, false);
		/*specialBar(ID);*/
		specialBar(id3); //7599

		rsi.width = 190;
		rsi.height = 261;

		int last = 12; int frame = 0;
		rsi.totalChildren(last);

		rsi.child(frame, id2+3, 21, 99); frame++;
		rsi.child(frame, id2+4, 105, 46); frame++;
		rsi.child(frame, id2+5, 21, 46); frame++;

		rsi.child(frame, id2+6, img1x, img1y); frame++; //topleft
		rsi.child(frame, id2+7, img2x, img2y); frame++; //bottomleft
		rsi.child(frame, id2+8, img3x, img3y); frame++; //topright

		rsi.child(frame, id2+9, str1x, str1y); frame++; //chop
		rsi.child(frame, id2+10, str2x, str2y); frame++; //slash
		rsi.child(frame, id2+11, str3x, str3y); frame++; //lunge

		rsi.child(frame, 19300, 0, 0); frame++; //stuffs
		rsi.child(frame, id2, 94, 4); frame++; //weapon
		rsi.child(frame, id3, 21, 205); frame++; //special attack 7599

		for (int i = id2+3; i < id2+6; i++) {
			rsi = interfaceCache[i];
			rsi.sprite1 = customSpriteLoader(19301, ""); rsi.sprite2 = customSpriteLoader(19301, "a");
			rsi.width = 68; rsi.height = 44;
		}
	}

	public static void Sidebar0d(int id, int id2, String text1, String text2, String text3,
			int str1x, int str1y, int str2x, int str2y, int str3x, int str3y,
			int img1x, int img1y, int img2x, int img2y, int img3x, int img3y, TextDrawingArea[] tda) //3button nospec (magic intf)
	{
		InterfaceListener rsi = addInterface(id); //2423
		/*addText(ID, "Text", tda, Size, Colour, Centered);*/
		addText(id2, "-2", tda, 3, 0xff981f, true, true); //2426
		addText(id2+9, text1, tda, 0, 0xff981f, false, false);
		addText(id2+10, text2, tda, 0, 0xff981f, false, false);
		addText(id2+11, text3, tda, 0, 0xff981f, false, false);
		//addText(353, "Spell", tda, 0, 0xff981f, false);
		removeSomething(353);
		addText(354, "Spell", tda, 0, 0xff981f, false, false);
		addCacheSprite(337, 19, 0, "combaticons");
		addCacheSprite(338, 13, 0, "combaticons2");
		addCacheSprite(339, 14, 0, "combaticons2");
		/*addToggleButton(id, sprite, config, width, height, tooltip);*/
		//addToggleButton(349, 349, 108, 68, 44, "Select");
		removeSomething(349);
		addToggleButton(350, 350, 108, 68, 44, "Select");
		rsi.width = 190;
		rsi.height = 261;
		int last = 15; int frame = 0;
		rsi.totalChildren(last);
		rsi.child(frame, id2+3, 20, 115); frame++;
		rsi.child(frame, id2+4, 20, 80); frame++;
		rsi.child(frame, id2+5, 20, 45); frame++;
		rsi.child(frame, id2+6, img1x, img1y); frame++; //topleft
		rsi.child(frame, id2+7, img2x, img2y); frame++; //bottomleft
		rsi.child(frame, id2+8, img3x, img3y); frame++; //topright
		rsi.child(frame, id2+9, str1x, str1y); frame++; //bash
		rsi.child(frame, id2+10, str2x, str2y); frame++; //pound
		rsi.child(frame, id2+11, str3x, str3y); frame++; //focus
		rsi.child(frame, 349, 105, 46); frame++; //spell1
		rsi.child(frame, 350, 104, 106); frame++; //spell2
		rsi.child(frame, 353, 125, 74); frame++; //spell
		rsi.child(frame, 354, 125, 134); frame++; //spell
		rsi.child(frame, 19300, 0, 0); frame++; //stuffs
		rsi.child(frame, id2, 94, 4); frame++; //weapon
	}

}
