package Tank;

import javax.swing.*;
import javax.swing.Timer;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.*;
import java.awt.*;
import java.text.DecimalFormat;
import java.util.List;

@SuppressWarnings("serial")
public class Gameplay extends JPanel implements Runnable {

	//Private
	private ImageIcon armor;
	private ImageIcon lives;
	private ImageIcon explosion;
	private final int gameWidth = 1095;
	private final int gameHeight = 759;
	private final String startTime = "02:00";
	private final DecimalFormat dFormat = new DecimalFormat("00");
	private int minutes;
	private int seconds;
	private String ddSecond, ddMinute;
	private int timerStartflag = 0;
	private final String menuSound = "src/audio/menu.wav";
	private final String gameplay = "src/audio/gameplay.wav";
	private final String click = "src/audio/click.wav";
	private final String exSoundFile = "src/audio/explosion.wav";
	private final String diedSoundFile = "src/audio/liveminus.wav";
	private final String shoot = "src/audio/bullet.wav";
	private int usernameCheck;
	private JLabel label;
	private JTextField tf;
	private JButton button;
	private Thread thread;
	private boolean running = false;
	private boolean isClicked = false;

	//Private Static
	private static Texture tex;
	private static Timer countdown;
	private static boolean soundPlaying = false;
	private static boolean mute = false;
	private static Sound se;
	private static Sound diedSound;
	private static Sound explode;
	private static Sound shooting;
	private static Music menuMusic;
	private static Music gameMusic;
	private static STATE State = STATE.MENU;
	private static EntityController et;


	//Protected Static
	protected static String saveDataPath = System.getProperty("user.home") + "\\Documents" + "\\matchHistory.txt";

	//Public
	public static int HEALTH1;
	public static int Lives1;
	public static int Armor1;
	public static int HEALTH2;
	public static int Lives2;
	public static int Armor2;

	//Menu Enumeration for States
	enum STATE{
		MENU,
		GAME,
		SCORE,
		END,
		PAUSED
	}

	public class MouseInput extends MouseAdapter {
		@Override
		public void mouseReleased(MouseEvent e) {
			isClicked = false;
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			int mx = e.getX();
			int my = e.getY();

			if(State == STATE.END){ //play again button
				//g.drawImage(pagan.getImage(), 300, 370, this);
				if(mx>= 300 && mx<= 300 + 250) {
					if (my >= 370 && my <= 370 + 50) {
						se.play();
						gameMusic.reStart();
						gameMusic.loop();
						resetGame(et);
						seconds = 00;
						minutes = 02;
						ddMinute = null;
						usernameCheck = 0;
						State = STATE.GAME;
					}
				}
			}

			if(State == STATE.PAUSED){ //resume button
				//g.drawImage(pagan.getImage(), 300, 370, this);
				if(mx>= 300 && mx<= 300 + 250) {
					if (my >= 370 && my <= 370 + 50) {
						se.play();
						gameMusic.loop();
						State = STATE.GAME;
						countdown.start();
					}
				}
			}


			if(State == STATE.END || State == STATE.PAUSED){ //leave button
				if(mx>= 300 && mx<= 300 + 250) {
					if (my >= 430 && my <= 430 + 50) {
						isClicked = true;
						se.play();
						gameMusic.stop();
						resetGame(et);
						seconds = 00;
						minutes = 02;
						ddMinute = null;
						usernameCheck = 0;
						State = STATE.MENU;
					}
				}
			}

			if(State == STATE.END || State == STATE.PAUSED){
				if(mx>= 300 && mx<= 300 + 250) {
					if (my >= 490 && my <= 490 + 50) {
						se.play();
						System.exit(1);
					}
				}
			}

			if(State == STATE.SCORE){ //exit button
				if(mx>= 950 && mx<= 950 + 50){
					if(my >= 80 && my <= 80 +50){
						se.play();
						State = STATE.MENU;
						if(!mute){
						}

					}
				}
			}

			if(State == STATE.MENU) {
				//mute button
				if(mx>= 20 && mx<= 20 + 50){
					if(my >= 40 && my <= 40 +50){
						se.play();
						mute = !mute;

					}
				}

				if(mx>= 20 && mx<= 20 + 50){ // Match history buton
					if(my >= 110 && my <= 110 +50){
						se.play();
						State = STATE.SCORE;
						if(!mute){
						}
					}
				}

				//Play button
				if(mx >= 410 && mx <= 410 + 275) {
					if(my>= 280 && my <= 280 + 98) {
						se.play();
						gameMusic.reStart();
						gameMusic.loop();
						State = STATE.GAME;
						soundPlaying = false;
					}
				}
				
				//Controls button
				if(mx >= 410 && mx <= 410 + 275) {
					if(my>= 398 && my <= 398 + 98) {
						if(!isClicked){
							se.play();

							JOptionPane.showMessageDialog(null,  """
								Eliminate your opponent by depleting their health to 0!
								Shoot the different walls to get power-ups!
								
								Player 1: Use WASD to move and Space to shoot.
								Player 2: Use Arrow Keys to move and Enter to shoot.
								ESC - Pause the game.
							
								""", "How to play", JOptionPane.INFORMATION_MESSAGE);
						}
					}
				}
				
				//Exit button
				if(mx >= 410 && mx <= 410 + 275) {
					if(my>= 520 && my <= 520 + 98) {
						se.play();
						System.exit(1);
					}
				}
			}
			
		}
	}
	
	public Gameplay() {
		this.addMouseListener(new MouseInput());
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		initTextures();
		initSounds();
		soundSettings();
		initController();
		initTanks();
		initWalls();
		initMatchHistory();
		addKeyListener(new Movement(et));

		start();		
	}
	private void initMatchHistory(){
		matchHistory m = new matchHistory();
		try {
			m.loadScore(saveDataPath);
		}catch(Exception e){
			e.printStackTrace();
		}

	}
	private void timerStart() {
		
		if (timerStartflag == 0){
			simpleTimer();
			countdown.start();
			timerStartflag+= 1;
		} else if (State == STATE.MENU || State == STATE.END) {
			countdown.stop();
			timerStartflag = 0;
			//System.out.print("hit");
		}
		
	}

	@Override //Game Loop here
	public void run() {
		
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000_000_000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			
			while(delta >= 1) {
				update();
				repaint();
				delta--;
				frames++;
			}
				
			if(System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				System.out.println("FPS" + frames);
				frames = 0;
			}
		}
		stop();
		
	}
	
	public synchronized void start() {
		if(running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public synchronized void stop() {
		if(!running)
			return;
		running = false;
		try {
			thread.join();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void resetGame(EntityController et) {
		soundPlaying = false;
		et.clear();
		initTanks();
		initWalls();

	}
	
	private void update() {
		et.tick();

	}
	
	public void initController() {
		et = new EntityController();
		
	}
	public static void initSounds(){
		se = new Sound();
		explode = new Sound();
		diedSound = new Sound();
		shooting = new Sound();
		menuMusic = new Music();
		gameMusic = new Music();

	}
	public void soundSettings(){
		se.setFile(click);
		explode.setFile(exSoundFile);
		diedSound.setFile(diedSoundFile);
		shooting.setFile(shoot);
		menuMusic.setFile(menuSound);
		gameMusic.setFile(gameplay);
	}
	
	public static void initWalls() {

		ImageIcon diamondWallImg = new ImageIcon("src/Images/diamond.png"); // 40px by 40px
		ImageIcon moissaniteWallImg = new ImageIcon("src/Images/moi.png"); // 40px by 40px
		ImageIcon carbonWallImg = new ImageIcon("src/Images/carbon.png"); // 40px by 40px
		ImageIcon goldWallImg = new ImageIcon("src/Images/gold.png"); // 40px by 40px
		ImageIcon steelWallImg = new ImageIcon("src/Images/wall.png"); // 40px by 40px
		ImageIcon aluminumWallImg = new ImageIcon("src/Images/alu.png"); // 40px by 40px

		//Start of Code for Walls

		for (int i = 0; i < 840; i += 40) {
			//Initialize top row of walls
			et.addObject(new SteelWall(4, i, 0, steelWallImg, et));

			//Initialize bottom row of walls
			et.addObject(new SteelWall(4, i, 560, steelWallImg, et));
		}

		for (int i = 40; i < 560; i += 40) {
			//Initialize left column of walls
			et.addObject(new SteelWall(4, 0, i, steelWallImg, et));

			//Initialize right column of walls
			et.addObject(new SteelWall(4, 800, i, steelWallImg, et));
		}

		//Center Walls
		et.addObject(new CarbonWall(4, 220, 280, carbonWallImg, et));
		et.addObject(new AluminumWall(4, 400, 280, aluminumWallImg, et));
		et.addObject(new CarbonWall(4, 580, 280, carbonWallImg, et));

		et.addObject(new MoissaniteWall(4, 300, 200, moissaniteWallImg, et));
		et.addObject(new GoldWall(4, 500, 200, goldWallImg, et));

		et.addObject(new GoldWall(4, 300, 360, goldWallImg, et));
		et.addObject(new MoissaniteWall(4, 500, 360, moissaniteWallImg, et));

		et.addObject(new CarbonWall(4, 400, 440, carbonWallImg, et));
		et.addObject(new CarbonWall(4, 400, 120, carbonWallImg, et));


		//Bottom Left Corner Walls
		for(int i = 400; i < 560; i += 40) {
			et.addObject(new SteelWall(4, 160, i, steelWallImg, et));
		}
		et.addObject(new CarbonWall(4, 120, 400, carbonWallImg, et));
		et.addObject(new GoldWall(4, 120, 440, goldWallImg, et));
		for(int i = 400; i < 520; i += 40) {
			et.addObject(new SteelWall(4, 80, i, steelWallImg, et));
		}

		//Top Right Corner Walls
		for(int i = 40; i < 200; i += 40) {
			et.addObject(new SteelWall(4, 640, i, steelWallImg, et));
		}
		et.addObject(new CarbonWall(4, 680, 160, carbonWallImg, et));
		et.addObject(new GoldWall(4, 680, 120, goldWallImg, et));
		for(int i = 80; i < 200; i += 40) {
			et.addObject(new SteelWall(4, 720, i, steelWallImg, et));
		}

		//Player 1 Spawn Walls
		et.addObject(new SteelWall(4, 120, 40, steelWallImg, et));
		et.addObject(new DiamondWall(4, 120, 120, diamondWallImg, et));
		et.addObject(new SteelWall(4, 40, 120, steelWallImg, et));

		//Player 2 Spawn Walls
		et.addObject(new SteelWall(4, 680, 520, steelWallImg, et));
		et.addObject(new DiamondWall(4, 680, 440, diamondWallImg, et));
		et.addObject(new SteelWall(4, 760, 440, steelWallImg, et));

		//End of Code for Walls
		
	}	//End of Code for Initializing Walls
	public static void initTanks() {
		ImageIcon tank1Img = new ImageIcon("src/Images/p1TankS.png");
		ImageIcon tank2Img = new ImageIcon("src/Images/p2TankW.png");

		Tank tank1 = new Tank(1, 40, 40, tank1Img, "S", et);
		Lives1 = tank1.getLives();
		HEALTH1 = tank1.getHealth();
		Armor1 = tank1.getArmor();
		et.addObject(tank1);

		Tank tank2 = new Tank(2, 760, 520, tank2Img, "W", et);
		Lives2 = tank2.getLives();
		HEALTH2 = tank2.getHealth();
		Armor2 = tank2.getArmor();
		et.addObject(tank2);
	}
	
	public void simpleTimer() {
		countdown = new Timer(1000, new ActionListener() {//updates timer every one second (1000)	
			
			@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						seconds--;
						ddSecond = dFormat.format(seconds);
						ddMinute = dFormat.format(minutes);
						
						if( seconds == -1) {
							seconds = 59;
							minutes--;
							ddSecond = dFormat.format(seconds);
							ddMinute = dFormat.format(minutes);
						}
						if (minutes == 0 && seconds == 0) {
							countdown.stop();
								JOptionPane.showMessageDialog(null,  """
										Time's Up!
										
										IT'S A DRAW!
										
									
										""", "Time's up", JOptionPane.INFORMATION_MESSAGE);
								State = STATE.END;
							
						}
						
					}
				}); 
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		timerStart();
		if(State == STATE.SCORE){
			ImageIcon historyPage = new ImageIcon("src/Images/historyPage.png");
			g.drawImage(historyPage.getImage(), 0, 0, this);

			ImageIcon exit = new ImageIcon("src/Images/exit.png");
			g.drawImage(exit.getImage(), 950, 80, this);
			g.setColor(Color.BLACK);
			g.setFont(new Font("Arial", Font.BOLD, 52));
			int z = 50, i = 0;
			try{
				List<String> data = new matchHistory().getList(saveDataPath);
				ListIterator li = data.listIterator(data.size());
				while(li.hasPrevious()){
					if(i > 3){
						break;
					}
					g.drawString((String) li.previous(), 80, 450 + z);
					z += 50;
					i++;
				}
			} catch(Exception e){
				g.drawString(new matchHistory().loadScore(saveDataPath), 80, 450 + z);
			}


		}
		if(State == STATE.MENU) {
			ImageIcon menu = new ImageIcon("src/Images/menu.png");
			g.drawImage(menu.getImage(), 0, 0, this);

			if(mute){
				ImageIcon mute = new ImageIcon("src/Images/mute.png");
				g.drawImage(mute.getImage(),20,40,this);
			} else{
				ImageIcon mute = new ImageIcon("src/Images/unmute.png");
				g.drawImage(mute.getImage(),20,40,this);
			}

			ImageIcon matchHistory = new ImageIcon("src/Images/history.png");
			g.drawImage(matchHistory.getImage(), 20, 110, this);

			seconds = 00;
			minutes = 02;
			ddMinute = null;
			if(!mute){
				if(!soundPlaying){
					menuMusic.loop();
					soundPlaying = true;
				}
			} else {
				menuMusic.stop();
				soundPlaying = false;
			}

		} else if(State == STATE.GAME || State == STATE.END || State == STATE.PAUSED) {

			if(!mute){
				if(!soundPlaying){
					menuMusic.stop();
					gameMusic.loop();
					soundPlaying = true;
				}
			} else {
				gameMusic.stop();
				soundPlaying = false;
			}

			//Arena
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, gameWidth, gameHeight);

			ImageIcon arena = new ImageIcon("src/Images/arena.png");
			g.drawImage(arena.getImage(), 0 , 0, this);
			
			// Information Board (To Expand)
			g.setColor(Color.LIGHT_GRAY); // temp color
			g.fillRect(0, 601, 850, 98);

			ImageIcon htp = new ImageIcon("src/Images/howtopla.png");
			g.drawImage(htp.getImage(), 0, 601, this);	
			

			// Score/Live Board (To Expand)
			g.setColor(Color.BLUE); // temp color
			g.fillRect(840, 0, 241, 600);
			
			ImageIcon sb = new ImageIcon("src/Images/sb.png");
			g.drawImage(sb.getImage(), 840, 0, this);	
			

			// Game Information (Name of Game, etc)
			g.setColor(Color.BLACK); // temp color
			g.fillRect(840, 601, 255, 98);
			
			ImageIcon tankedLogo = new ImageIcon("src/Images/TANKED.png");
			g.drawImage(tankedLogo.getImage(), 840, 600, this);

			
			// Health Bar1 
			g.setColor(Color.GRAY);
			g.fillRect(870, 340, 180, 20); //(first: x, second: y, third: Length, fourth: height)
			
			g.setColor(Color.GREEN);
			g.fillRect(870, 340, HEALTH1, 20); //(first: x, second: y, third: Length, fourth: height)
			
			g.setColor(Color.WHITE);
			g.drawRect(870, 340, 180, 20); //(first: x, second: y, third: Length, fourth: height)
			
			
			// Health Bar2
			g.setColor(Color.GRAY);
			g.fillRect(870, 500, 180, 20); //(first: x, second: y, third: Length, fourth: height)
			
			g.setColor(Color.GREEN);
			g.fillRect(870, 500, HEALTH2, 20); //(first: x, second: y, third: Length, fourth: height)
			
			g.setColor(Color.WHITE);
			g.drawRect(870, 500, 180, 20); //(first: x, second: y, third: Length, fourth: height)
			
			
			// Lives 1
			lives = new ImageIcon("src/Images/lives.png");
			int startingx1 = 835;
			for(int i = 0; i < Lives1 ; i++) {
				g.drawImage(lives.getImage(), startingx1 += 30, 300, this);
			}

			// Lives 2
			int startingx2 = 835;
			for(int i = 0; i < Lives2 ; i++) {
				g.drawImage(lives.getImage(), startingx2 += 30, 460, this);
			}

			// Armor 1
			armor = new ImageIcon("src/Images/armor.png");
			int startingx3 = 925;
			for(int i = 0; i < Armor1 ; i++) {
				g.drawImage(armor.getImage(), startingx3 += 30, 300, this);
			}

			// Armor 2
			int startingx4 = 925;
			for(int i = 0; i < Armor2 ; i++) {
				g.drawImage(armor.getImage(), startingx4 += 30, 460, this);
			}

			// Timer
			String time;
			Font timeFont = new Font("Arial", Font.PLAIN,45);
			if (ddMinute == null) {
				time = startTime;
			} else {
				time = ("" + ddMinute + ":" + ddSecond);
			}



			
			g.setFont(timeFont);
			g.setColor(Color.white);
			g.drawString(time, 905, 120);


			
			
			
		    //Render Entities
			et.render(g);

			//game paused
			if(State == STATE.PAUSED){
				gameMusic.stop();
				countdown.stop();
				g.setColor(Color.BLACK);
				ImageIcon pause = new ImageIcon("src/Images/paused.png");
				g.drawImage(pause.getImage(), 200, 100, this);
//				g.fillRect(200,100,450,100);

				g.setColor(Color.BLACK);
				ImageIcon resume = new ImageIcon("src/Images/resume.png");
				g.drawImage(resume.getImage(), 300, 370, this);
//				g.fillRect(320,370,200,50);

				ImageIcon leaveGame = new ImageIcon("src/Images/leave.png");
				g.drawImage(leaveGame.getImage(), 300, 430, this);

				ImageIcon exitGame = new ImageIcon("src/Images/exitgame.png");
				g.drawImage(exitGame.getImage(), 300, 490, this);
			}

			if(State == STATE.END){

				g.setColor(Color.BLACK);
				ImageIcon gameover = new ImageIcon("src/Images/gameover.png");
				g.drawImage(gameover.getImage(), 200, 100, this);
//				g.fillRect(200,100,450,100);

				g.setColor(Color.BLACK);
				ImageIcon pagan = new ImageIcon("src/Images/pagain.png");
				g.drawImage(pagan.getImage(), 300, 370, this);
//				g.fillRect(320,370,200,50);

				ImageIcon leaveGame = new ImageIcon("src/Images/leave.png");
				g.drawImage(leaveGame.getImage(), 300, 430, this);

				ImageIcon exitGame = new ImageIcon("src/Images/exitgame.png");
				g.drawImage(exitGame.getImage(), 300, 490, this);
			}



			//game end

			if (Lives1 == 0){
				State = STATE.END;
				g.setColor(Color.BLACK);
				g.drawString("PLAYER 2 WINS!",250,250);
				if(usernameCheck == 0){
					usernameCheck = 1;
					setLayout(new FlowLayout());
					JFrame f = new JFrame("PLAYER 2 WINS!");
					JPanel p = new JPanel();
					label = new JLabel("ENTER WINNER'S NAME: ");
					p.add(label);

					tf = new JTextField("",10);
					p.add(tf);

					button = new JButton("SAVE TO MATCH HISTORY");
					p.add(button);
					matchHistory mH = new matchHistory();
					f.setLocationRelativeTo(null);
					button.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {

							try(FileWriter fw = new FileWriter(saveDataPath,true);
								BufferedWriter bw = new BufferedWriter(fw);
								PrintWriter out = new PrintWriter(bw))
							{
								String word = mH.setScore(tf.getText(), String.valueOf(Lives2));
								out.println(word);
								f.dispose();
//								out.println(word);
							}catch (Exception g) {
								g.printStackTrace();
							}
						}
					});

					f.add(p);
					f.setSize(250,200);
					f.setLocationRelativeTo(null);
					f.setVisible(true);


				}


			}

			if (Lives2 == 0){
				State = STATE.END;
				g.setColor(Color.BLACK);
				g.drawString("PLAYER 2 WINS!",250,200);
				g.setColor(Color.BLACK);
				if(usernameCheck == 0){
					usernameCheck = 1;
					setLayout(new FlowLayout());
					JFrame f = new JFrame("PLAYER 1 WINS!");
					JPanel p = new JPanel();
					label = new JLabel("ENTER WINNER'S NAME: ");
					p.add(label);

					tf = new JTextField("",10);
					p.add(tf);

					button = new JButton("SAVE TO MATCH HISTORY");
					p.add(button);
					matchHistory mH = new matchHistory();
					f.setLocationRelativeTo(null);
					button.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							try(FileWriter fw = new FileWriter(saveDataPath,true);
								BufferedWriter bw = new BufferedWriter(fw);
								PrintWriter out = new PrintWriter(bw))
							{
								String word = mH.setScore(tf.getText(), String.valueOf(Lives1));
								out.println(word);
								f.dispose();
//								out.println(word);
							}catch (Exception g) {
								g.printStackTrace();
							}
						}
					});

					f.add(p);
					f.setSize(400,100);
					f.setLocationRelativeTo(null);
					f.setVisible(true);


				}


			}
		}


		
	}



	//Pass Sounds to other class
	public static Sound getClickSound(){return se;}
	public static Sound getDiedSound(){return diedSound;}
	public static Sound getExplosionSound(){ return explode;}
	public static Sound getShooting(){return shooting;}

	public static void initTextures(){
		tex = new Texture();
	}
	public static Texture getInstance(){
		return tex;
	}
	public static STATE getState() {
		return State;
	}
	public static void setState(int j) {
		if (j == 1) {
			State = STATE.MENU;
		}
		if (j == 2){
			State = STATE.PAUSED;
		}
		if (j == 3){
			State = STATE.GAME;
			gameMusic.loop();
			countdown.start();

		}
	}


}