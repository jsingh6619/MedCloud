package abstractClasses;

import java.awt.*;
import java.io.*;
import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.ScrollablePane;
import guiTeacher.components.TextArea;
import guiTeacher.interfaces.*;
import guiTeacher.userInterfaces.*;
import main.Main;
import patient.PatientInfoScreen;
import user.UserInfoScreen;

public abstract class AbstractScreen extends FullFunctionScreen {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Color a = new Color(47, 48, 66);			//background color
	private static Color b = new Color(250, 109, 109);
	private static Color c = new Color(11, 156, 250);
	private static Color d = new Color(250, 235, 229);
	private static Color e = new Color(178, 250, 241);
	private static Color f = new Color(176, 140, 238);
	private static Color g = new Color(255, 174, 232);
	private static Color h = new Color(255, 170, 170);		//button
	private static Color i = new Color(186, 195, 200);		//loading background color
	private static Color j = new Color(252, 255, 184);
	
	public AbstractScreen(int width, int height) {
		super(width, height);
	}

	//add other components I want displayed on most screens (call using super.initAllObjects)
	public void initAllObjects(List<Visible> viewObjects) {
		setBackground(getA());
		
		Button home = new Button(10, 360, 35, 35, "H", Color.WHITE, new Action() {
			public void act() {
				Main.main.setScreen(new UserInfoScreen(getWidth(), getHeight()));
			}
		});
		
		
		
		viewObjects.add(home);
	}

	public static Color getA() {
		return a;
	}

	public static Color getB() {
		return b;
	}

	public static Color getC() {
		return c;
	}

	public static Color getD() {
		return d;
	}

	public static Color getE() {
		return e;
	}

	public static Color getF() {
		return f;
	}

	public static Color getG() {
		return g;
	}
	
	public static Color getH() {
		return h;
	}
	
	public static Color getI() {
		return i;
	}
	
	public static Color getJ() {
		return j;
	}
	
	@SuppressWarnings("resource")
	public String readLine(int x, String a) {
		String line = "";
		try {
			FileInputStream fs= new FileInputStream(a);
			BufferedReader br = new BufferedReader(new InputStreamReader(fs));
			for(int i = 1; i < x; i++) {
				br.readLine();
			}
			line = br.readLine();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return line;
	}
	
	@SuppressWarnings("resource")
	public int maxLines(String a) {
		int x = 0;
		try {
			FileInputStream fs= new FileInputStream(a);
			BufferedReader br = new BufferedReader(new InputStreamReader(fs));
			while(br.readLine()!=null) {
				x++;
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return x;
	}
	
	public void drawTextArea(TextArea text, int size) {
		text.setSize(size);
		getViewObjects().add(text);
	}
	
	public void drawTextArea(TextArea text, int size, ScrollablePane x) {
		text.setSize(size);
		x.addObject(text);
	}
	
	public void drawTextArea(TextArea text, int size, Color col) {
		text.setSize(size);
		text.setCustomTextColor(col);
		getViewObjects().add(text);
	}
	
	public void backButton(Button x) {
		x.setEnabled(false);
		getViewObjects().add(x);
	}
}
