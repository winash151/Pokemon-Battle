package graphics;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.lang.reflect.InvocationTargetException;

import javax.swing.*;
import javax.swing.text.DefaultCaret;

import networking.PokemonClient;

import org.imgscalr.Scalr;
import org.imgscalr.Scalr.Method;
import org.imgscalr.Scalr.Mode;

import bgm.WAVPlayer;
import engine.Abilities;
import engine.Battle;
import engine.InBattlePokemon;
import engine.PartyPokemon;
import engine.Types;
import engine.moves.Move;
import graphics.hqx.Hqx_2x;

/**
 * Displays the battle
 * 
 * @author Ashwin
 *
 */
public class Display extends JComponent {

	private static final long serialVersionUID = 1L;

	// the disclaimer frame
	private JFrame disclaimerFrame;

	// the background image
	private BufferedImage backgroundImage;

	// the image for the home team and away team base
	private BufferedImage homeBase, awayBase;

	// the male symbol and female symbol
	private BufferedImage maleSymbol, femaleSymbol;

	private int homeBaseWidth = 512, homeBaseHeight = 256, awayBaseWidth = 384,
			awayBaseHeight = 192;

	// the coordinates of the home and away base of the pokemon
	private int homePokemonBaseX = 305, homePokemonBaseY = 480,
			awayPokemonBaseX = 830, awayPokemonBaseY = 344;

	// the coordinates of the home and away base
	private int homeBaseX = homePokemonBaseX - homeBaseWidth / 2,
			homeBaseY = homePokemonBaseY - homeBaseHeight * 55 / 100,
			awayBaseX = awayPokemonBaseX - awayBaseWidth / 2,
			awayBaseY = awayPokemonBaseY - awayBaseHeight * 55 / 100;

	// the panel that holds the move buttons
	private PokeBGPanel controlsPanel;

	// the four buttons for the four moves
	private MoveButton[] moveButtons = new MoveButton[4];

	// a button to switch into a new pokemon from the party
	// also the button to get out of the party screen
	private SwitchButton switchToPartyButton;
	private JButton cancelPartyButton;

	// the dimenions for the switch button
	private int switchWidth = 130, switchHeight = 46;

	// holds the buttons to choose a new pokemon to switch into
	private PartyButton[] partyButtons = new PartyButton[6];

	// the frame count
	private double homeFrame = 0, awayFrame = 0;

	// the height needed to just display the battle
	private int battleDisplayHeight = 576;

	// the height of the text area
	private int textAreaHeight = 75;

	// the dimensions of the frame
	private int frameWidth = 1024, frameHeight = battleDisplayHeight;

	// the main JFrame
	private JFrame frame;

	// the dimensions of the moves panel
	private int controlsFrameWidth = 435, controlsFrameHeight = 250;

	// the controls frame
	private JFrame controlsFrame;

	// the gap between the move buttons
	private int movesHorizontalGap = 53, movesVerticalGap = 10;

	// the dimensions of a move button
	private int moveButtonWidth = 150, moveButtonHeight = 65;
	private JTextArea textArea;

	// Gets images
	private ImageGetter imageGetter = new ImageGetter();

	// the pokeball images
	private BufferedImage pokeballClosed = imageGetter.getImage("ball00.png"),
			pokeballOpened = imageGetter.getImage("ball00_open.png");

	private BufferedImage healImage = imageGetter.getImage("heal.png"),
			increaseImage = imageGetter.getImage("increase.png"),
			decreaseImage = imageGetter.getImage("decrease.png");

	// default caret
	private DefaultCaret caret;

	// the frame width and height increments
	private double incrementFrameWidth, incrementFrameHeight;

	// the increment for the y location
	private double incrementXLocale, incrementYLocale;

	// the frames per second
	private int frameRate = 24;

	// whether the frame is full size
	private boolean isFrameFull = false,
	// whether the frame is in location at the top of the screen
			isFrameInLocation = false;

	// the colors
	private Color pokemonInfoColor = new Color(224, 226, 223, 150),
			hpBarColorGreen = new Color(0, 184, 0),
			hpBarColorYellow = new Color(248, 168, 0),
			hpBarColorRed = new Color(248, 0, 0);

	// the visible hps
	private double visibleHomeHP, visibleAwayHP;

	// whether the hps are animating
	private boolean isAnimatingHomeHP = false, isAnimatingAwayHP = false;

	// whether a move is animating
	// private boolean isAnimatingHomeMove, isAnimatingAwayMove,
	// isMovingForward = true;

	// the progress that the attack has made
	private double attackProgress;

	// the dimensions of the disclaimer frame
	private int disclaimerFrameWidth = 400, disclaimerFrameHeight = 100;

	// the flow layout of the controls panel
	private FlowLayout flowLayout;

	// the font from pokemon fire red
	private Font fireredFont = new Font("Pokemon FireLeaf", Font.TRUETYPE_FONT,
			18);

	private Color bgPartyButtonColor = new Color(0, 144, 56),
			bgPartyButtonSelectColor = new Color(48, 216, 80),
			bgPartyButtonFaintColor = new Color(208, 56, 16),
			bgPartyButtonFaintSelectColor = new Color(248, 120, 0);

	// the dimensions of the party button
	private int partyButtonWidth = 120, partyButtonHeight = 60;
	private Polygon partyButtonPolygon;

	{
		partyButtonPolygon = new Polygon();
		partyButtonPolygon.addPoint(partyButtonWidth * 2 / 25, 0);
		partyButtonPolygon.addPoint(partyButtonWidth, 0);
		partyButtonPolygon.addPoint(partyButtonWidth, partyButtonHeight);
		partyButtonPolygon.addPoint(0, partyButtonHeight);
		partyButtonPolygon.addPoint(0, partyButtonHeight * 23 / 100);
	}

	// the scroll pane for the text area
	private JScrollPane textAreaScrollPane;

	// the flow layout
	private int partyHGap = 10, partyVGap = 10;
	// the time gap after a console print
	private int timeGap = 500;

	private int awayInfoX = 760, awayInfoY = 405, awayInfoWidth = 200,
			awayInfoHeight = 50, homeInfoX = 95, homeInfoY = 70,
			homeInfoWidth = 200, homeInfoHeight = 64, infoArc = 10;
	private BasicStroke stroke = new BasicStroke(3, BasicStroke.CAP_ROUND,
			BasicStroke.JOIN_BEVEL);
	// the distance the home name is from the top of the info border
	private int homeNameBufferHeight = 11;
	// the distance of the home name from the left of the info border
	private int nameBufferWidth = 7;
	// the x coordinate of the home name
	private int homeNameBaseX = homeInfoX + nameBufferWidth;
	// the distance of the level text from the east of the info border
	private int homeLvlEastBuffer = 4;
	// the coordinate of the end of the level text
	private int homeLvlBoundaryEastX = homeInfoX + homeInfoWidth
			- homeLvlEastBuffer;
	private int maleSymbolWidth, maleSymbolHeight, symbolWidthBuffer = 4,
			femaleSymbolWidth, femaleSymbolHeight;
	// the hp text
	private String hpString = "HP";

	// the buffer between the hp bar and the horizontal edges of the backing
	private int hpHeightBuffer = 4;
	// the buffer between the hp bar and the vertical edges of the backing
	private int hpWidthBuffer = 3;
	// the buffer for the hp text
	private int hpTextBuffer = 3;
	// the total width of the actual hp bar
	private int hpBarTotalWidth = 100;
	// the height of the actual hp bar
	private int hpBarHeight = 4;
	// the height of the hp bar backing
	private int hpBarBackHeight = hpHeightBuffer + hpBarHeight + hpHeightBuffer;
	// the distance of the hp bar from the right edge
	private int hpBarBackDistanceFromEdge = 10;
	// the distance of the hp backing from the name
	private int hpBarBackDistanceFromName = 8;
	// the color of the hp text
	private Color hpTextColor = new Color(239, 132, 8);
	// the distance the home name is from the top of the info border
	private int awayNameBufferHeight = 11;
	// the x coordinate of the home name
	private int awayNameBaseX = awayInfoX + nameBufferWidth;

	// the distance of the level text from the west of the info border
	private int awayLvlEastBuffer = 5;
	// the coordinate of the end of the level text
	private int awayLvlBoundaryEastX = awayInfoX + awayInfoWidth
			- awayLvlEastBuffer;

	private Runnable repaintRunner = new Runnable() {
		public void run() {
			frame.repaint();
		}
	};

	private WAVPlayer ballHomeOpenClip, ballHomeReturnClip, ballAwayOpenClip,
			ballAwayReturnClip;

	private CubicBezierCurve homePokeballCurve, awayPokeballCurve;
	private int regainHomeHP = 0;

	private int regainAwayHP = 0;
	private double homePokeballFrame = 0, awayPokeballFrame = 0;

	private int initialFrameWidth = frameWidth * 3 / 4;
	private int initialFrameHeight = frameHeight * 3 / 4;

	private int currentWidth = initialFrameWidth,
			currentHeight = initialFrameHeight;
	private double currentFrameLocationY, currentFrameLocationX;

	private int timeToThrowInPokeball = 750;

	private int pokeballRotations = 6;

	private int pokemonResizeTime = 1500;
	private Battle battle;
	private boolean isAnimatingHomeSwitchIn = false,
			isAnimatingHomeSwitchInPokeball = false;

	private int framesHomePokeballStayed = 0, framesHomeOpenPokeballStayed = 0;

	private boolean isAnimatingHomeOpenPokeball = false,
			isAnimatingHomePokemonSwitchInResize = false;

	private double homePokemonSwitchInResizePercent = 0;
	private PokemonClient pokemonClient;
	private double homePokeballRotation = 0;
	private boolean aboutToSwitchHome = true;
	private boolean isAnimatingAwaySwitchIn = false;

	private boolean isAnimatingAwaySwitchInPokeball = false;

	private int framesAwayPokeballStayed = 0;

	private int framesAwayOpenPokeballStayed = 0;

	private boolean isAnimatingAwayOpenPokeball = false;

	private boolean isAnimatingAwayPokemonSwitchInResize = false;

	private double awayPokemonSwitchInResizePercent = 0;

	private double awayPokeballRotation = 0;
	private boolean aboutToSwitchAway = true;
	private boolean isAnimatingHomeFaint = false;

	private double homeFaintPixel = 0;
	private boolean isAnimatingAwayFaint = false;

	private double awayFaintPixel = 0;
	private boolean isAnimatingHomeSwitchOut = false;

	private int framesHomePokeballStayedOnOut = 0;

	private boolean isAnimatingHomePokemonSwitchOutResize = false;

	private double homePokemonSwitchOutResizePercent = 1;
	private boolean isAnimatingAwaySwitchOut = false;

	private int framesAwayPokeballStayedOnOut = 0;

	private boolean isAnimatingAwayPokemonSwitchOutResize = false;

	private double awayPokemonSwitchOutResizePercent = 1;
	private int totalTimeForStatChange = 1500;

	private int homeStatChange = 0;

	private boolean isAnimatingHomeStatIncrease = false;

	private boolean isAnimatingHomeStatDecrease = false;
	private int awayStatChange = 0;

	private boolean isAnimatingAwayStatIncrease = false;

	private boolean isAnimatingAwayStatDecrease = false;

	private JPanel glassPanel;

	private int textAreaFontHeight = 18;

	/**
	 * Constructor Takes in a JFrame
	 * 
	 * @param loading
	 */
	public Display(PokemonClient pokemonClient/* , JFrame loading */) {
		// loading.setVisible(false);
		this.pokemonClient = pokemonClient;
		// we will use the passed frame for this display
		frame = new JFrame();
		
		// remove everything from the frame
		// frame.getContentPane().removeAll();

		/*
		 * double secondsToLoad = 1.5;
		 * 
		 * currentWidth = frame.getWidth(); currentHeight = frame.getHeight();
		 * 
		 * // the amount we want to increment the frame width by each frame
		 * incrementFrameWidth = (1.0 * (frameWidth - frame.getWidth()) /
		 * (frameRate * secondsToLoad));
		 * 
		 * // we don't want it to be zero if (incrementFrameWidth == 0)
		 * incrementFrameWidth = 1;
		 * 
		 * // the amount we want to increment the frame height by each frame
		 * incrementFrameHeight = (1.0 * (frameHeight - frame.getHeight()) /
		 * (frameRate * secondsToLoad));
		 * 
		 * // we don't want it to be zero if (incrementFrameHeight == 0)
		 * incrementFrameHeight = 1;
		 * 
		 * int centerScreenX = (int) (frame.getToolkit().getScreenSize()
		 * .getWidth() / 2);
		 * 
		 * // the amount we want the frame to move to reach the top of the
		 * screen incrementXLocale = (1.0 *
		 * (Math.abs(frame.getLocationOnScreen().x - centerScreenX)) /
		 * (frameRate * secondsToLoad));
		 * 
		 * currentFrameLocationX = frame.getLocationOnScreen().x +
		 * frame.getWidth() / 2;
		 * 
		 * // we don't want it to be zero if (incrementXLocale == 0)
		 * incrementXLocale = 1;
		 * 
		 * // the amount we want the frame to move to reach the top of the
		 * screen incrementYLocale = (1.0 * frame.getLocationOnScreen().y /
		 * (frameRate * secondsToLoad));
		 * 
		 * currentFrameLocationY = frame.getLocationOnScreen().y;
		 * 
		 * // we don't want it to be zero if (incrementYLocale == 0)
		 * incrementYLocale = 1;
		 */

		// frame.setVisible(false);

		// The layered pane
		JLayeredPane layeredPane = new JLayeredPane();

		// revalidate and add the layered pane to the frame
		frame.getContentPane().revalidate();
		frame.getContentPane().add(layeredPane);

		// add this display which is a JComponent to the layered pane
		// in the default layer
		layeredPane.add(this, JLayeredPane.DEFAULT_LAYER);

		// the text area that will display the battle info
		// it is customized
		textArea = new JTextArea() {
			private static final long serialVersionUID = 1L;

			// fix up font stuff
			public FontMetrics getFontMetrics(Font font) {
				return new FontMetricsWrapper(super.getFontMetrics(font)) {
					private static final long serialVersionUID = 1L;
					public int getHeight() {
						return textAreaFontHeight * currentWidth / frameWidth;
					}
				};
			}
		};
		
		

		textArea.setBackground(new Color(0, 0, 0, 50));

		// set the starting number of rows to one
		textArea.setRows(1);

		// set the location to just
		textArea.setLocation(0, battleDisplayHeight - textAreaHeight);

		// The user cannot edit it
		textArea.setEditable(false);

		textArea.setForeground(Color.white);
		textArea.setHighlighter(null);

		glassPanel = new JPanel();
		layeredPane.add(glassPanel, JLayeredPane.DRAG_LAYER);
		glassPanel.setOpaque(false);

		glassPanel.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent arg0) {
			}

			public void mouseEntered(MouseEvent arg0) {
			}

			public void mouseExited(MouseEvent arg0) {
			}

			public void mousePressed(MouseEvent arg0) {
			}

			public void mouseReleased(MouseEvent arg0) {
			}
		});

		// get the caret of the text area
		caret = (DefaultCaret) textArea.getCaret();
		// have it scroll down as new info is appended
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		caret.setVisible(false);

		// create the scroll pane
		textAreaScrollPane = new JScrollPane(textArea);
		

		// set the bounds to where the text area is
		textAreaScrollPane.setBounds(0, battleDisplayHeight - textAreaHeight,
				frameWidth, textAreaHeight);
		textAreaScrollPane.setOpaque(false);
		textAreaScrollPane.setBorder(null);
		textAreaScrollPane.getVerticalScrollBar().setPreferredSize(
		 new Dimension(0, 0));

		// add the scroll pane to the layered pane
		layeredPane.add(textAreaScrollPane, JLayeredPane.PALETTE_LAYER);

		// we won't need to scroll horizontally
		textAreaScrollPane
				.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		// the program exits on the close of the window
		// and it can't be resized
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);

		// set up the disclaimer stuff
		setUpDisclaimer();

		// set the size of the battle display
		// setSize(new Dimension(frameWidth, battleDisplayHeight));

		// get the field background
		backgroundImage = imageGetter.getImage("battlebgField.png");
		// backgroundImage = Scalr.resize(backgroundImage, Method.ULTRA_QUALITY,
		// Mode.FIT_EXACT, frameWidth, frameHeight);

		// new JFrame("after scalr").setVisible(true);

		// get the bases
		homeBase = imageGetter.getImage("enemybaseFieldGrass.png");
		// homeBase = Scalr.resize(homeBase, Method.ULTRA_QUALITY,
		// Mode.FIT_EXACT,
		// homeBase.getWidth() * 2, homeBase.getHeight() * 2);

		awayBase = imageGetter.getImage("enemybaseFieldGrass.png");
		// awayBase = Scalr.resize(awayBase, Method.ULTRA_QUALITY,
		// Mode.FIT_EXACT,
		// awayBase.getWidth() * 3 / 2, awayBase.getHeight() * 3 / 2);
		// awayBase = homeBase;

		Point p1 = new Point(-pokeballClosed.getWidth(), frameHeight / 2 - 100);
		Point p2 = new Point(homePokemonBaseX / 2, frameHeight / 2 + 100);
		Point p3 = new Point(homePokemonBaseX, frameHeight / 2 + 20);
		Point p4 = new Point(homePokemonBaseX, frameHeight - homePokemonBaseY
				+ pokeballClosed.getHeight() / 2);
		System.out.println("height" + pokeballClosed.getHeight() / 2);

		Point ap1 = new Point(frameWidth + pokeballClosed.getWidth(),
				frameHeight - awayPokemonBaseY + 150);
		Point ap2 = new Point(awayPokemonBaseX
				+ (frameWidth - awayPokemonBaseX) / 2, frameHeight
				- awayPokemonBaseY + 350);
		Point ap3 = new Point(awayPokemonBaseX, frameHeight - awayPokemonBaseY
				+ 270);
		Point ap4 = new Point(awayPokemonBaseX, frameHeight - awayPokemonBaseY
				+ pokeballClosed.getHeight() / 2);

		homePokeballCurve = new CubicBezierCurve(p1, p2, p3, p4);

		awayPokeballCurve = new CubicBezierCurve(ap1, ap2, ap3, ap4);

		// get the gender symbols
		maleSymbol = imageGetter.getImage("male.png");
		maleSymbol = Scalr.resize(maleSymbol, Method.ULTRA_QUALITY,
				Mode.FIT_TO_WIDTH, 16);
		femaleSymbol = imageGetter.getImage("female.png");
		femaleSymbol = Scalr.resize(femaleSymbol, Method.ULTRA_QUALITY,
				Mode.FIT_TO_WIDTH, 16);

		maleSymbolWidth = maleSymbol.getWidth();
		maleSymbolHeight = maleSymbol.getHeight();

		femaleSymbolWidth = femaleSymbol.getWidth();
		femaleSymbolHeight = femaleSymbol.getHeight();

		// Pack the frame
		// frame.pack();
		frame.setTitle("Pokémon Battle by Ashwin Suresh");

		// the JFrame that holds the controls
		controlsFrame = new JFrame();
		// the user cannot exit out of this window
		controlsFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		// set the size
		controlsFrame.getContentPane().setPreferredSize(
				new Dimension(controlsFrameWidth, controlsFrameHeight));
		controlsFrame.getContentPane().setSize(
				new Dimension(controlsFrameWidth, controlsFrameHeight));

		// the user cannot resize this
		controlsFrame.setResizable(false);

		controlsFrame.setMinimumSize(new Dimension(controlsFrameWidth
				+ controlsFrame.getInsets().left
				+ controlsFrame.getInsets().right, controlsFrameHeight
				+ controlsFrame.getInsets().top
				+ controlsFrame.getInsets().bottom));
		controlsFrame.getContentPane().setMinimumSize(
				new Dimension(controlsFrameWidth, controlsFrameHeight));

		// the Panel will have a poke ball background
		controlsPanel = new PokeBGPanel();
		// set the size of the panel
		controlsPanel.setPreferredSize(new Dimension(controlsFrameWidth,
				controlsFrameHeight));
		controlsPanel.setSize(new Dimension(controlsFrameWidth,
				controlsFrameHeight));

		// pack the moves frame
		// controlsFrame.pack();
		controlsFrame.setTitle("Moves");

		// the width of the screen
		int screenWidth = frame.getToolkit().getScreenSize().width;

		// new JFrame("after frame toolkit").setVisible(true);

		// set the location of the controls frame
		controlsFrame.setLocation(screenWidth / 2 - controlsFrameWidth / 2,
				frameHeight + 75);

		// add the moves panel to controls frame
		controlsFrame.getContentPane().add(controlsPanel);

		// set up the layout
		flowLayout = new FlowLayout();

		flowLayout.setHgap(movesHorizontalGap);
		flowLayout.setVgap(movesVerticalGap);

		controlsPanel.setLayout(flowLayout);

		// Create the move buttons
		for (int i = 0; i < moveButtons.length; i++) {
			moveButtons[i] = new MoveButton(i);
			// controlsPanel.add(moveButtons[i]);
			moveButtons[i].addActionListener(new MoveListener());
		}

		// new JFrame("after move buttons").setVisible(true);

		for (int i = 0; i < partyButtons.length; i++) {
			partyButtons[i] = new PartyButton(i);
			partyButtons[i].addActionListener(new PartyListener());
		}

		// new JFrame("after party buttons").setVisible(true);

		// Create the button to go to the party screen
		switchToPartyButton = new SwitchButton();
		// controlsPanel.add(switchToPartyButton);

		// the cancel Button
		cancelPartyButton = new JButton("Cancel");

		// add the listeners
		switchToPartyButton.addActionListener(new SwitchListener());

		// the button to exit the party screen
		cancelPartyButton.addActionListener(new CancelListener());

		// new JFrame("before revalidate").setVisible(true);

		// revalidate the frame
		frame.getContentPane().revalidate();

		frame.addMouseWheelListener(new MouseWheelListener() {
			public void mouseWheelMoved(MouseWheelEvent e) {


				if (e.getWheelRotation() > 0) {
					if (currentWidth > 300) {
						currentWidth -= 16;
						currentHeight -= 9;
					}
				} else {
					currentWidth += 16;
					currentHeight += 9;
				}

				setSizes();
			}
		});

		ballHomeOpenClip = new WAVPlayer("ball_out.wav");

		ballAwayOpenClip = new WAVPlayer("ball_out.wav");

		ballHomeReturnClip = new WAVPlayer("ball_return.wav");

		ballAwayReturnClip = new WAVPlayer("ball_return.wav");
		
		setSizes();

		frame.revalidate();
		frame.pack();
		frame.setLocationByPlatform(true);
	}

	private void setSizes() {
		
		frame.getContentPane().setSize(new Dimension(currentWidth, currentHeight));
		frame.getContentPane().setPreferredSize(new Dimension(currentWidth, currentHeight));
		setSize(new Dimension(currentWidth, currentHeight));
		setPreferredSize(new Dimension(currentWidth, currentHeight));
		
		textAreaScrollPane.setBounds(new Rectangle(0, currentHeight - textAreaHeight
				* currentWidth / frameWidth, currentWidth, textAreaHeight
				* currentWidth / frameWidth));
		
	
		glassPanel.setSize(new Dimension(currentWidth, currentHeight));
		glassPanel.setPreferredSize(new Dimension(currentWidth, currentHeight));
	
		glassPanel.setBounds(new Rectangle(0,0,currentWidth,currentHeight));
		
		textArea.setFont(new Font("Pokemon FireLeaf", Font.TRUETYPE_FONT, textAreaFontHeight * currentWidth / frameWidth));
		
		textArea.setSize(new Dimension(currentWidth, textAreaFontHeight * currentWidth
				* textArea.getRows() / frameWidth));
		textArea.setPreferredSize(new Dimension(currentWidth, textAreaFontHeight * currentWidth
					* textArea.getRows() / frameWidth));
		
		
		textArea.setLocation(new Point(0, currentHeight - textAreaHeight * currentHeight
				/ frameHeight));
		
		textArea.revalidate();

		JScrollBar vertical = textAreaScrollPane.getVerticalScrollBar();
		vertical.setMaximum(textArea.getHeight());
		vertical.setValue(textArea.getHeight());
		textArea.setCaretPosition(textArea.getDocument().getLength());

		/*System.out.println("height in set" + textArea.getHeight());

		System.out.println("Max" + vertical.getMaximum() + " val "
				+ vertical.getValue());*/

		// Rectangle r = new Rectangle(0,textArea.getHeight()-textAreaHeight
		// * currentHeight / frameHeight,1,1);

		// textAreaScrollPane.getViewport().scrollRectToVisible(r);

		// textAreaScrollPane.getViewport().setViewPosition(p);

		textAreaScrollPane.revalidate();

		frame.repaint();

		frame.revalidate();
		frame.pack();
	}

	public void startDisplay() {
		// make the frames visible and start the timer
		frame.setVisible(true);
		// new JFrame("after frame").setVisible(true);
		controlsFrame.setVisible(true);
		resetHomeHP();
		resetAwayHP();
		Timer frameTimer = new Timer(1000 / frameRate, new FrameTimer());
		frameTimer.start();
		battle.startBattle();
	}

	/**
	 * Sets up the disclaimer window
	 */
	private void setUpDisclaimer() {
		// Create a menu bar
		JMenuBar bar = new JMenuBar();

		// A help section in the menu
		JMenu help = new JMenu("Disclaimer");

		// A controls item
		JMenuItem controlsItem = new JMenuItem("Disclaimer");

		// Add the controls section to the help menu
		help.add(controlsItem);

		// Add the help menu to the menu bar
		bar.add(help);

		// Finally add the menu bar to the frame
		frame.setJMenuBar(bar);

		// add the disclaimer listener
		// this will open the disclaimer window
		controlsItem.addActionListener(new DisclaimListener());

		// initialize the disclaim frame
		disclaimerFrame = new JFrame();

		// the text area of the disclaimer frame
		JTextArea disclaimerTextArea = new JTextArea();
		disclaimerTextArea
				.setText("Pokémon is a product of Nintendo and Gamefreak.\n3D pokemon models are from pkparaiso.com.\n "
						+ "Background ripped from game by Klnothincomin.");
		// the user cannot edit the disclaimer frame
		disclaimerTextArea.setEditable(false);

		// add the text area to the frame
		disclaimerFrame.getContentPane().add(disclaimerTextArea);

		disclaimerFrame.setSize(new Dimension(disclaimerFrameWidth,
				disclaimerFrameHeight));
		disclaimerFrame.setTitle("Disclaimer");
	}

	/**
	 * Removes the move buttons from the controls frame
	 */
	private void removeMoveButtons() {
		controlsPanel.removeAll();
		controlsPanel.validate();
		controlsPanel.repaint();
	}

	/**
	 * Adds the move buttons to the frames
	 */
	public void addMoveButtons() {
		controlsFrame.setTitle("Moves");

		// add the move buttons back to the panel
		for (MoveButton mb : moveButtons)
			controlsPanel.add(mb);

		// add the switch to party button
		controlsPanel.add(switchToPartyButton);

		// reset the gaps for the layout
		flowLayout.setHgap(movesHorizontalGap);
		flowLayout.setVgap(movesVerticalGap);

		// validate and repaint
		controlsPanel.validate();
		controlsPanel.repaint();
	}

	/**
	 * Removes the Party Buttons from the controls panel
	 */
	public void removePartyScreen() {
		controlsPanel.removeAll();
		controlsPanel.validate();
		controlsPanel.repaint();
	}

	/**
	 * Adds the the Party Buttons to the controls panel
	 */
	public void addPartyScreen() {
		controlsFrame.setTitle("Party Pokemon");
		// reset the gaps of the flow layout
		flowLayout.setHgap(partyHGap);
		flowLayout.setVgap(partyVGap);

		for (PartyButton pb : partyButtons) {
			controlsPanel.add(pb);
		}
		controlsPanel.add(cancelPartyButton);
		controlsPanel.validate();
		controlsPanel.repaint();
	}

	/**
	 * Adds the the Party Buttons to the controls panel without the cancel
	 * button
	 */
	public void addPartyAfterFaintScreen() {
		controlsFrame.setTitle("Party Pokemon");
		// reset the gaps of the flow layout
		flowLayout.setHgap(partyHGap);
		flowLayout.setVgap(partyVGap);

		for (PartyButton pb : partyButtons) {
			controlsPanel.add(pb);
		}
		controlsPanel.validate();
		controlsPanel.repaint();
	}

	public void resetHP(PartyPokemon p) {
		if (p.isHome()) {
			resetHomeHP();
		} else {
			resetAwayHP();
		}
	}

	/**
	 * Resets the visible home hp
	 */
	public void resetHomeHP() {
		visibleHomeHP = battle.getHomePokemon().getCurrentHP();
	}

	/**
	 * Resets the visible away hp
	 */
	public void resetAwayHP() {
		visibleAwayHP = battle.getAwayPokemon().getCurrentHP();
	}

	public void animateHP(PartyPokemon p) {
		if (p.isHome()) {
			animateHomeHP();
		} else {
			animateAwayHP();
		}
	}

	/**
	 * Starts animating the home hp bar
	 */
	public void animateHomeHP() {
		regainHomeHP = 0;
		isAnimatingHomeHP = true;
	}

	/**
	 * Starts animating the away hp bar
	 */
	public void animateAwayHP() {
		regainAwayHP = 0;
		isAnimatingAwayHP = true;
	}

	/**
	 * Starts the animation of the home move
	 */
	/*
	 * public void animateHomeMove() { isAnimatingHomeMove = true; }
	 * 
	 * /** Starts the animation of the away move
	 */
	/*
	 * public void animateAwayMove() { isAnimatingAwayMove = true; }
	 */

	/**
	 * Prints the passed string to the display console
	 * 
	 * @param s
	 */
	public void consolePrint(final String s) {

		if (SwingUtilities.isEventDispatchThread()) {
			textArea.append(s);
			frame.repaint();
			/*
			 * textArea.revalidate();
			 * 
			 * JScrollBar vertical = textAreaScrollPane.getVerticalScrollBar();
			 * vertical.setValue( vertical.getMaximum() );
			 */
		} else {
			try {
				SwingUtilities.invokeAndWait(new Runnable() {
					public void run() {
						textArea.append(s);
					}
				});
				SwingUtilities.invokeAndWait(repaintRunner);
				/*
				 * textArea.revalidate();
				 * 
				 * JScrollBar vertical =
				 * textAreaScrollPane.getVerticalScrollBar(); vertical.setValue(
				 * vertical.getMaximum() );
				 */
			} catch (InvocationTargetException | InterruptedException e) {
				e.printStackTrace();
			}
			try {
				Thread.sleep(timeGap);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(textArea.getHeight() + " theight");
	}

	/**
	 * Prints the passed string with a new line
	 * 
	 * @param s
	 */
	public void consolePrintln(final String s) {
		if (SwingUtilities.isEventDispatchThread()) {
			textArea.setRows(textArea.getRows() + 1);
			frame.repaint();
		} else {
			try {
				SwingUtilities.invokeAndWait(new Runnable() {
					public void run() {
						// need to increase the number of rows after adding a
						// line
						textArea.setRows(textArea.getRows() + 1);
					}
				});
				SwingUtilities.invokeAndWait(repaintRunner);
			} catch (InvocationTargetException | InterruptedException e) {
				e.printStackTrace();
			}
		}
		consolePrint("\n" + s);
		textArea.setPreferredSize(new Dimension(currentWidth, textAreaFontHeight * currentWidth
				* textArea.getRows() / frameWidth));
		JScrollBar vertical = textAreaScrollPane.getVerticalScrollBar();
		vertical.setMaximum(textArea.getHeight());
		vertical.setValue(textArea.getHeight());
		textArea.setCaretPosition(textArea.getDocument().getLength());
		textAreaScrollPane.revalidate();

		frame.repaint();

		frame.revalidate();
	}

	/**
	 * Paints the display
	 */
	public void paintComponent(Graphics g) {
		// System.out.println("Total Memory: " +
		// Runtime.getRuntime().maxMemory()/1024);
		super.paintComponent(g);
		//BufferedImage graphicsImage = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
		BufferedImage graphicsImage = new BufferedImage(frameWidth, frameHeight, BufferedImage.TYPE_INT_ARGB);
		Graphics2D canvas = graphicsImage.createGraphics();

		/*canvas.scale(1.0 * getWidth() / frameWidth, 1.0 * getHeight()
				/ frameHeight);*/
		/*
		 * canvas.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER
		 * , 0.8f));
		 * canvas.setComposite(AlphaComposite.getInstance(AlphaComposite
		 * .SRC_OVER));
		 */
		/*
		 * canvas.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
		 * RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR);
		 * canvas.setRenderingHint(RenderingHints.KEY_RENDERING,
		 * RenderingHints.VALUE_RENDER_QUALITY);
		 */

		// Draw the background of the battlefield image
		canvas.drawImage(backgroundImage, 0, 0, frameWidth, frameHeight, this);

		// if there is a weather effect
		if (battle != null && battle.getBattlefield().isNotClear()) {
			Image weatherImage = battle.getBattlefield().getWeather()
					.getImage();
			canvas.drawImage(weatherImage, 0, 0, this);
		}

		// draw the bases
		canvas.drawImage(homeBase, homeBaseX, homeBaseY, homeBaseWidth,
				homeBaseHeight, this);
		canvas.drawImage(awayBase, awayBaseX, awayBaseY, awayBaseWidth,
				awayBaseHeight, this);

		if (battle != null && battle.hasStarted()) {
			// get the two pokemon in battle
			InBattlePokemon homePokemon = battle.getHomePokemon();
			InBattlePokemon awayPokemon = battle.getAwayPokemon();

			if (homeFrame > homePokemon.getNumHomeFrames() - 1)
				homeFrame = 0;// cycle around if too much

			// Get the image for the home pokemon
			BufferedImage homeImage = homePokemon.getHomeFrame((int) homeFrame);

			if (awayFrame > awayPokemon.getNumAwayFrames() - 1)
				awayFrame = 0;// cycle around if too much

			BufferedImage awayImage = awayPokemon.getAwayFrame((int) awayFrame);

			if (homePokemon.hasNextMove()
					&& homePokemon.getNextMove().isAnimating()) {
				homePokemon.getNextMove().animate(this, canvas, true,
						homeImage, awayImage);
			} else if (awayPokemon.hasNextMove()
					&& awayPokemon.getNextMove().isAnimating()) {
				awayPokemon.getNextMove().animate(this, canvas, false,
						homeImage, awayImage);
			} else {
				if (isAnimatingHomeSwitchIn) {
					if (isAnimatingHomeSwitchInPokeball) {
						if (framesHomePokeballStayed > 12) {
							isAnimatingHomeSwitchInPokeball = false;
							isAnimatingHomeOpenPokeball = true;
							ballHomeOpenClip.play();
						}

						double t = homePokeballFrame;

						Point p = homePokeballCurve.getCoordAtDistance(t);

						AffineTransform andRollout = canvas.getTransform();

						andRollout.rotate(Math
								.toRadians(((int) homePokeballRotation) % 360),
								p.x, frameHeight - p.y);

						canvas.setTransform(andRollout);
						canvas.drawImage(pokeballClosed,
								p.x - pokeballClosed.getWidth() / 2,
								frameHeight - p.y - pokeballClosed.getHeight()
										/ 2, this);
						andRollout
								.rotate(Math
										.toRadians(-((int) homePokeballRotation) % 360),
										p.x, frameHeight - p.y);
						canvas.setTransform(andRollout);
					} else if (isAnimatingHomeOpenPokeball) {
						if (framesHomeOpenPokeballStayed > 12) {
							isAnimatingHomeOpenPokeball = false;
							isAnimatingHomePokemonSwitchInResize = true;
						}
						canvas.drawImage(pokeballOpened, homePokemonBaseX
								- pokeballOpened.getWidth() / 2,
								homePokemonBaseY - pokeballOpened.getHeight(),
								this);
					} else if (isAnimatingHomePokemonSwitchInResize) {
						if (homePokemonSwitchInResizePercent >= 1) {
							isAnimatingHomePokemonSwitchInResize = false;
							isAnimatingHomeSwitchIn = false;
						}

						/*
						 * homeImage = Scalr.resize(homeImage, Method.SPEED,
						 * Mode.FIT_TO_WIDTH, (int)
						 * (homePokemon.getImageHomeWidth()
						 * homePokemonSwitchInResizePercent) );
						 */

						int[] colors = homeImage.getRGB(0, 0,
								homeImage.getWidth(), homeImage.getHeight(),
								null, 0, homeImage.getWidth());

						for (int i = 0; i < colors.length; i++) {
							if ((colors[i] >> 24) != 0x00) {
								colors[i] = new Color(255, 255, 255).getRGB();
							}
						}

						BufferedImage copy = new BufferedImage(
								homeImage.getWidth(), homeImage.getHeight(),
								BufferedImage.TYPE_INT_ARGB);

						copy.setRGB(0, 0, homeImage.getWidth(),
								homeImage.getHeight(), colors, 0,
								homeImage.getWidth());

						int xHomeCoord = homePokemonBaseX
								- (int) (homePokemon.getImageHomeWidth() * homePokemonSwitchInResizePercent)
								/ 2;
						int yHomeCoord = homePokemonBaseY
								- (int) (homePokemon.getImageHomeHeight() * homePokemonSwitchInResizePercent);

						canvas.drawImage(
								copy,
								(int) (xHomeCoord + homePokemon
										.getxHomeOffset()
										* homePokemonSwitchInResizePercent),
								(int) (yHomeCoord - homePokemon.getyOffset()
										* homePokemonSwitchInResizePercent),
								(int) (homePokemon.getImageHomeWidth() * homePokemonSwitchInResizePercent),
								(int) (homePokemon.getImageHomeHeight() * homePokemonSwitchInResizePercent),
								this);
					}
				} else if (isAnimatingHomeSwitchOut) {
					if (isAnimatingHomePokemonSwitchOutResize) {
						canvas.drawImage(pokeballOpened, homePokemonBaseX
								- pokeballOpened.getWidth() / 2,
								homePokemonBaseY - pokeballOpened.getHeight(),
								this);

						if (homePokemonSwitchOutResizePercent <= 0) {
							isAnimatingHomePokemonSwitchOutResize = false;
						}

						int[] colors = homeImage.getRGB(0, 0,
								homeImage.getWidth(), homeImage.getHeight(),
								null, 0, homeImage.getWidth());

						for (int i = 0; i < colors.length; i++) {
							if ((colors[i] >> 24) != 0x00) {
								colors[i] = new Color(252, 86, 94, 200)
										.getRGB();
							}
						}

						BufferedImage copy = new BufferedImage(
								homeImage.getWidth(), homeImage.getHeight(),
								BufferedImage.TYPE_INT_ARGB);

						copy.setRGB(0, 0, homeImage.getWidth(),
								homeImage.getHeight(), colors, 0,
								homeImage.getWidth());

						int xHomeCoord = homePokemonBaseX
								- (int) (homePokemon.getImageHomeWidth() * homePokemonSwitchOutResizePercent)
								/ 2;
						int yHomeCoord = homePokemonBaseY
								- (int) (homePokemon.getImageHomeHeight() * homePokemonSwitchOutResizePercent);

						canvas.drawImage(
								copy,
								(int) (xHomeCoord + homePokemon
										.getxHomeOffset()
										* homePokemonSwitchOutResizePercent),
								(int) (yHomeCoord - homePokemon.getyOffset()
										* homePokemonSwitchOutResizePercent),
								(int) (homePokemon.getImageHomeWidth() * homePokemonSwitchOutResizePercent),
								(int) (homePokemon.getImageHomeHeight() * homePokemonSwitchOutResizePercent),
								this);

					} else {
						if (framesHomePokeballStayedOnOut == 18) {
							isAnimatingHomePokemonSwitchOutResize = true;
							ballHomeReturnClip.play();
						} else if (framesHomePokeballStayedOnOut == 36) {
							isAnimatingHomeSwitchOut = false;
						}

						if (framesHomePokeballStayedOnOut <= 18) {
							int xHomeCoord = homePokemonBaseX
									- homePokemon.getImageHomeWidth() / 2;
							int yHomeCoord = homePokemonBaseY
									- homePokemon.getImageHomeHeight();

							canvas.drawImage(homeImage, xHomeCoord
									+ homePokemon.getxHomeOffset(), yHomeCoord
									- homePokemon.getyOffset(),
									homePokemon.getImageHomeWidth(),
									homePokemon.getImageHomeHeight(), this);
						}
						canvas.drawImage(pokeballClosed, homePokemonBaseX
								- pokeballClosed.getWidth() / 2,
								homePokemonBaseY - pokeballClosed.getHeight(),
								this);
					}
				} else if (isAnimatingHomeHP
						&& homePokemon.getCurrentHP() > visibleHomeHP) {
					homeImage = Scalr.resize(homeImage, Method.SPEED,
							Mode.FIT_TO_WIDTH, homePokemon.getImageHomeWidth());

					double pokemonRatio = 1.0 * homePokemon.getImageHomeWidth()
							/ homePokemon.getImageHomeHeight();
					double healRatio = 1.0 * healImage.getWidth()
							/ healImage.getHeight();

					BufferedImage tempHealImage = healImage;

					if (healRatio < pokemonRatio) {
						if (healImage.getWidth() < homeImage.getWidth()) {
							tempHealImage = Scalr.resize(healImage,
									Method.SPEED, Mode.FIT_TO_WIDTH,
									homePokemon.getImageHomeWidth());
						}
					} else {
						if (healImage.getHeight() < homeImage.getHeight()) {
							tempHealImage = Scalr.resize(healImage,
									Method.SPEED, Mode.FIT_TO_HEIGHT,
									homePokemon.getImageHomeHeight());
						}
					}

					// tempHealImage = Scalr.crop(tempHealImage,
					// homeImage.getWidth(), homeImage.getHeight());

					BufferedImage topPart;
					BufferedImage bottomPart = null;

					int topHeight = homeImage.getHeight();
					if (regainHomeHP % tempHealImage.getHeight() + topHeight > tempHealImage
							.getHeight()) {
						topHeight = tempHealImage.getHeight() - regainHomeHP
								% tempHealImage.getHeight();
					}

					topPart = Scalr.crop(tempHealImage, 0, regainHomeHP
							% tempHealImage.getHeight(), homeImage.getWidth(),
							topHeight);

					if (topPart.getHeight() < homeImage.getHeight()) {
						int heightNeeded = homeImage.getHeight()
								- topPart.getHeight();
						bottomPart = Scalr.crop(tempHealImage,
								homeImage.getWidth(), heightNeeded);
					}

					int[] colors = homeImage.getRGB(0, 0, homeImage.getWidth(),
							homeImage.getHeight(), null, 0,
							homeImage.getWidth());

					int[] healTopColors = topPart.getRGB(0, 0,
							topPart.getWidth(), topPart.getHeight(), null, 0,
							topPart.getWidth());

					int[] healBottomColors = null;

					if (bottomPart != null) {
						healBottomColors = bottomPart.getRGB(0, 0,
								bottomPart.getWidth(), bottomPart.getHeight(),
								null, 0, bottomPart.getWidth());
					}

					for (int i = 0; i < colors.length; i++) {
						if ((colors[i] >> 24) == 0x00) {
							if (i < healTopColors.length) {
								healTopColors[i] = 0x00000000;
							} else {
								healBottomColors[i - healTopColors.length] = 0x00000000;
							}

						}
					}

					topPart.setRGB(0, 0, topPart.getWidth(),
							topPart.getHeight(), healTopColors, 0,
							topPart.getWidth());

					if (healBottomColors != null) {
						bottomPart.setRGB(0, 0, bottomPart.getWidth(),
								bottomPart.getHeight(), healBottomColors, 0,
								bottomPart.getWidth());
					}

					int xHomeCoord = homePokemonBaseX
							- homePokemon.getImageHomeWidth() / 2;
					int yHomeCoord = homePokemonBaseY
							- homePokemon.getImageHomeHeight();

					canvas.drawImage(homeImage,
							xHomeCoord + homePokemon.getxHomeOffset(),
							yHomeCoord - homePokemon.getyOffset(), this);

					canvas.drawImage(topPart,
							xHomeCoord + homePokemon.getxHomeOffset(),
							yHomeCoord - homePokemon.getyOffset(), this);

					if (bottomPart != null) {
						canvas.drawImage(
								bottomPart,
								xHomeCoord + homePokemon.getxHomeOffset(),
								yHomeCoord - homePokemon.getyOffset()
										+ topPart.getHeight(), this);
					}

				} else if (isAnimatingHomeStatIncrease) {
					if (homeStatChange > 1.0 * totalTimeForStatChange / 1000
							* frameRate * 4) {
						isAnimatingHomeStatIncrease = false;
					}
					homeImage = Scalr.resize(homeImage, Method.SPEED,
							Mode.FIT_TO_WIDTH, homePokemon.getImageHomeWidth());

					double pokemonRatio = 1.0 * homePokemon.getImageHomeWidth()
							/ homePokemon.getImageHomeHeight();
					double healRatio = 1.0 * increaseImage.getWidth()
							/ increaseImage.getHeight();

					BufferedImage tempIncreaseImage = increaseImage;

					if (healRatio < pokemonRatio) {
						if (increaseImage.getWidth() < homeImage.getWidth()) {
							tempIncreaseImage = Scalr.resize(increaseImage,
									Method.SPEED, Mode.FIT_TO_WIDTH,
									homePokemon.getImageHomeWidth());
						}
					} else {
						if (increaseImage.getHeight() < homeImage.getHeight()) {
							tempIncreaseImage = Scalr.resize(increaseImage,
									Method.SPEED, Mode.FIT_TO_HEIGHT,
									homePokemon.getImageHomeHeight());
						}
					}

					// tempHealImage = Scalr.crop(tempHealImage,
					// homeImage.getWidth(), homeImage.getHeight());

					BufferedImage topPart;
					BufferedImage bottomPart = null;

					int topHeight = homeImage.getHeight();
					if (homeStatChange % tempIncreaseImage.getHeight()
							+ topHeight > tempIncreaseImage.getHeight()) {
						topHeight = tempIncreaseImage.getHeight()
								- homeStatChange
								% tempIncreaseImage.getHeight();
					}

					topPart = Scalr.crop(tempIncreaseImage, 0, homeStatChange
							% tempIncreaseImage.getHeight(),
							homeImage.getWidth(), topHeight);

					if (topPart.getHeight() < homeImage.getHeight()) {
						int heightNeeded = homeImage.getHeight()
								- topPart.getHeight();
						bottomPart = Scalr.crop(tempIncreaseImage,
								homeImage.getWidth(), heightNeeded);
					}

					int[] colors = homeImage.getRGB(0, 0, homeImage.getWidth(),
							homeImage.getHeight(), null, 0,
							homeImage.getWidth());

					int[] increaseTopColors = topPart.getRGB(0, 0,
							topPart.getWidth(), topPart.getHeight(), null, 0,
							topPart.getWidth());

					int[] increaseBottomColors = null;

					if (bottomPart != null) {
						increaseBottomColors = bottomPart.getRGB(0, 0,
								bottomPart.getWidth(), bottomPart.getHeight(),
								null, 0, bottomPart.getWidth());
					}

					for (int i = 0; i < colors.length; i++) {
						if ((colors[i] >> 24) == 0x00) {
							if (i < increaseTopColors.length) {
								increaseTopColors[i] = 0x00000000;
							} else {
								increaseBottomColors[i
										- increaseTopColors.length] = 0x00000000;
							}

						}
					}

					topPart.setRGB(0, 0, topPart.getWidth(),
							topPart.getHeight(), increaseTopColors, 0,
							topPart.getWidth());

					if (increaseBottomColors != null) {
						bottomPart.setRGB(0, 0, bottomPart.getWidth(),
								bottomPart.getHeight(), increaseBottomColors,
								0, bottomPart.getWidth());
					}

					int xHomeCoord = homePokemonBaseX
							- homePokemon.getImageHomeWidth() / 2;
					int yHomeCoord = homePokemonBaseY
							- homePokemon.getImageHomeHeight();

					canvas.drawImage(homeImage,
							xHomeCoord + homePokemon.getxHomeOffset(),
							yHomeCoord - homePokemon.getyOffset(), this);

					canvas.drawImage(topPart,
							xHomeCoord + homePokemon.getxHomeOffset(),
							yHomeCoord - homePokemon.getyOffset(), this);

					if (bottomPart != null) {
						canvas.drawImage(
								bottomPart,
								xHomeCoord + homePokemon.getxHomeOffset(),
								yHomeCoord - homePokemon.getyOffset()
										+ topPart.getHeight(), this);
					}
				} else if (isAnimatingHomeStatDecrease) {
					if (homeStatChange > 1.0 * totalTimeForStatChange / 1000
							* frameRate * 4) {
						isAnimatingHomeStatDecrease = false;
					}
					homeImage = Scalr.resize(homeImage, Method.SPEED,
							Mode.FIT_TO_WIDTH, homePokemon.getImageHomeWidth());

					double pokemonRatio = 1.0 * homePokemon.getImageHomeWidth()
							/ homePokemon.getImageHomeHeight();
					double healRatio = 1.0 * decreaseImage.getWidth()
							/ decreaseImage.getHeight();

					BufferedImage tempDecreaseImage = decreaseImage;

					if (healRatio < pokemonRatio) {
						if (decreaseImage.getWidth() < homeImage.getWidth()) {
							tempDecreaseImage = Scalr.resize(decreaseImage,
									Method.SPEED, Mode.FIT_TO_WIDTH,
									homePokemon.getImageHomeWidth());
						}
					} else {
						if (decreaseImage.getHeight() < homeImage.getHeight()) {
							tempDecreaseImage = Scalr.resize(decreaseImage,
									Method.SPEED, Mode.FIT_TO_HEIGHT,
									homePokemon.getImageHomeHeight());
						}
					}

					// tempHealImage = Scalr.crop(tempHealImage,
					// homeImage.getWidth(), homeImage.getHeight());

					BufferedImage topPart = null;
					BufferedImage bottomPart;

					int bottomHeight = homeImage.getHeight();
					if (homeStatChange % tempDecreaseImage.getHeight()
							+ bottomHeight > tempDecreaseImage.getHeight()) {
						bottomHeight = tempDecreaseImage.getHeight()
								- homeStatChange
								% tempDecreaseImage.getHeight();
					}

					bottomPart = Scalr.crop(tempDecreaseImage, 0,
							tempDecreaseImage.getHeight() - homeStatChange
									% tempDecreaseImage.getHeight()
									- bottomHeight, homeImage.getWidth(),
							bottomHeight);

					if (bottomPart.getHeight() < homeImage.getHeight()) {
						int heightNeeded = homeImage.getHeight()
								- bottomPart.getHeight();
						topPart = Scalr.crop(tempDecreaseImage, 0,
								tempDecreaseImage.getHeight() - heightNeeded,
								homeImage.getWidth(), heightNeeded);
					}

					int[] colors = homeImage.getRGB(0, 0, homeImage.getWidth(),
							homeImage.getHeight(), null, 0,
							homeImage.getWidth());

					int[] decreaseTopColors = null;

					if (topPart != null) {
						decreaseTopColors = topPart.getRGB(0, 0,
								topPart.getWidth(), topPart.getHeight(), null,
								0, topPart.getWidth());
					}

					int[] decreaseBottomColors = bottomPart.getRGB(0, 0,
							bottomPart.getWidth(), bottomPart.getHeight(),
							null, 0, bottomPart.getWidth());

					for (int i = 0; i < colors.length; i++) {
						if ((colors[i] >> 24) == 0x00) {
							if (decreaseTopColors != null) {
								if (i < decreaseTopColors.length) {
									decreaseTopColors[i] = 0x00000000;
								} else {
									decreaseBottomColors[i
											- decreaseTopColors.length] = 0x00000000;
								}
							} else {
								decreaseBottomColors[i] = 0x00000000;
							}

						}
					}

					if (decreaseTopColors != null) {
						topPart.setRGB(0, 0, topPart.getWidth(),
								topPart.getHeight(), decreaseTopColors, 0,
								topPart.getWidth());
					}

					bottomPart.setRGB(0, 0, bottomPart.getWidth(),
							bottomPart.getHeight(), decreaseBottomColors, 0,
							bottomPart.getWidth());

					int xHomeCoord = homePokemonBaseX
							- homePokemon.getImageHomeWidth() / 2;
					int yHomeCoord = homePokemonBaseY
							- homePokemon.getImageHomeHeight();

					canvas.drawImage(homeImage,
							xHomeCoord + homePokemon.getxHomeOffset(),
							yHomeCoord - homePokemon.getyOffset(), this);

					if (topPart != null) {
						canvas.drawImage(topPart,
								xHomeCoord + homePokemon.getxHomeOffset(),
								yHomeCoord - homePokemon.getyOffset(), this);
					}

					int bottomY = yHomeCoord - homePokemon.getyOffset();
					if (topPart != null) {
						bottomY = yHomeCoord - homePokemon.getyOffset()
								+ topPart.getHeight();
					}
					canvas.drawImage(bottomPart,
							xHomeCoord + homePokemon.getxHomeOffset(), bottomY,
							this);

				} else if (homePokemon.canBattle() && battle.isIntroDone()
						&& !aboutToSwitchHome) {

					/*
					 * if (isAnimatingHomeMove) { newHomeBaseX = (int)
					 * (attackProgress * awayPokemonBaseX + (1 - attackProgress)
					 * homePokemonBaseX); newHomeBaseY = (int) (attackProgress *
					 * awayPokemonBaseY + (1 - attackProgress)
					 * homePokemonBaseY); }
					 */

					int xHomeCoord = homePokemonBaseX
							- homePokemon.getImageHomeWidth() / 2;
					int yHomeCoord = homePokemonBaseY
							- homePokemon.getImageHomeHeight();

					canvas.drawImage(homeImage,
							xHomeCoord + homePokemon.getxHomeOffset(),
							yHomeCoord - homePokemon.getyOffset(),
							homePokemon.getImageHomeWidth(),
							homePokemon.getImageHomeHeight(), this);
				} else if (isAnimatingHomeFaint) {
					homeImage = Scalr.resize(homeImage, Method.SPEED,
							Mode.FIT_TO_WIDTH, homePokemon.getImageHomeWidth());
					// homeImage = Scalr.crop(homeImage, homeImage.getWidth(),
					// (int)
					// ( homeImage.getHeight()*homeFaintPercent));

					int xHomeCoord = homePokemonBaseX
							- homePokemon.getImageHomeWidth() / 2;
					int yHomeCoord = (int) (homePokemonBaseY
							- homePokemon.getImageHomeHeight()
							- homePokemon.getyOffset() + homeFaintPixel);

					if (homePokemonBaseY <= yHomeCoord) {
						isAnimatingHomeFaint = false;
					} else {
						if (yHomeCoord + homePokemon.getImageHomeHeight() > homePokemonBaseY) {
							homeImage = Scalr
									.crop(homeImage,
											homeImage.getWidth(),
											homePokemon.getImageHomeHeight()
													- (yHomeCoord
															+ homePokemon
																	.getImageHomeHeight() - homePokemonBaseY));

						}
						canvas.drawImage(homeImage,
								xHomeCoord + homePokemon.getxHomeOffset(),
								yHomeCoord, this);
					}
				}

				if (isAnimatingAwaySwitchIn) {
					if (isAnimatingAwaySwitchInPokeball) {
						if (framesAwayPokeballStayed > 12) {
							isAnimatingAwaySwitchInPokeball = false;
							isAnimatingAwayOpenPokeball = true;
							ballAwayOpenClip.play();
						}

						double t = awayPokeballFrame;

						Point p = awayPokeballCurve.getCoordAtDistance(t);

						AffineTransform andRollout = canvas.getTransform();

						andRollout
								.rotate(Math
										.toRadians(-((int) awayPokeballRotation) % 360),
										p.x, frameHeight - p.y);

						canvas.setTransform(andRollout);
						canvas.drawImage(pokeballClosed,
								p.x - pokeballClosed.getWidth() / 2,
								frameHeight - p.y - pokeballClosed.getHeight()
										/ 2, this);
						andRollout.rotate(Math
								.toRadians(((int) awayPokeballRotation) % 360),
								p.x, frameHeight - p.y);
						canvas.setTransform(andRollout);
					} else if (isAnimatingAwayOpenPokeball) {
						if (framesAwayOpenPokeballStayed > 12) {
							isAnimatingAwayOpenPokeball = false;
							isAnimatingAwayPokemonSwitchInResize = true;
						}
						canvas.drawImage(pokeballOpened, awayPokemonBaseX
								- pokeballOpened.getWidth() / 2,
								awayPokemonBaseY - pokeballOpened.getHeight(),
								this);
					} else if (isAnimatingAwayPokemonSwitchInResize) {
						if (awayPokemonSwitchInResizePercent >= 1) {
							isAnimatingAwayPokemonSwitchInResize = false;
							isAnimatingAwaySwitchIn = false;
						}

						/*
						 * homeImage = Scalr.resize(homeImage, Method.SPEED,
						 * Mode.FIT_TO_WIDTH, (int)
						 * (homePokemon.getImageHomeWidth()
						 * homePokemonSwitchInResizePercent) );
						 */

						int[] colors = awayImage.getRGB(0, 0,
								awayImage.getWidth(), awayImage.getHeight(),
								null, 0, awayImage.getWidth());

						for (int i = 0; i < colors.length; i++) {
							if ((colors[i] >> 24) != 0x00) {
								colors[i] = new Color(255, 255, 255).getRGB();
								;
							}
						}

						BufferedImage copy = new BufferedImage(
								awayImage.getWidth(), awayImage.getHeight(),
								BufferedImage.TYPE_INT_ARGB);

						copy.setRGB(0, 0, awayImage.getWidth(),
								awayImage.getHeight(), colors, 0,
								awayImage.getWidth());

						int xAwayCoord = awayPokemonBaseX
								- (int) (awayPokemon.getImageAwayWidth() * awayPokemonSwitchInResizePercent)
								/ 2;
						int yAwayCoord = awayPokemonBaseY
								- (int) (awayPokemon.getImageAwayHeight() * awayPokemonSwitchInResizePercent);

						canvas.drawImage(
								copy,
								(int) (xAwayCoord + awayPokemon
										.getxAwayOffset()
										* awayPokemonSwitchInResizePercent),
								(int) (yAwayCoord - awayPokemon.getyOffset()
										* awayPokemonSwitchInResizePercent),
								(int) (awayPokemon.getImageAwayWidth() * awayPokemonSwitchInResizePercent),
								(int) (awayPokemon.getImageAwayHeight() * awayPokemonSwitchInResizePercent),
								this);
					}
				} else if (isAnimatingAwaySwitchOut) {
					if (isAnimatingAwayPokemonSwitchOutResize) {
						canvas.drawImage(pokeballOpened, awayPokemonBaseX
								- pokeballOpened.getWidth() / 2,
								awayPokemonBaseY - pokeballOpened.getHeight(),
								this);

						if (awayPokemonSwitchOutResizePercent <= 0) {
							isAnimatingAwayPokemonSwitchOutResize = false;
						}

						int[] colors = awayImage.getRGB(0, 0,
								awayImage.getWidth(), awayImage.getHeight(),
								null, 0, awayImage.getWidth());

						for (int i = 0; i < colors.length; i++) {
							if ((colors[i] >> 24) != 0x00) {
								colors[i] = new Color(252, 86, 94, 200)
										.getRGB();
							}
						}

						BufferedImage copy = new BufferedImage(
								awayImage.getWidth(), awayImage.getHeight(),
								BufferedImage.TYPE_INT_ARGB);

						copy.setRGB(0, 0, awayImage.getWidth(),
								awayImage.getHeight(), colors, 0,
								awayImage.getWidth());

						int xAwayCoord = awayPokemonBaseX
								- (int) (awayPokemon.getImageAwayWidth() * awayPokemonSwitchOutResizePercent)
								/ 2;
						int yAwayCoord = awayPokemonBaseY
								- (int) (awayPokemon.getImageAwayHeight() * awayPokemonSwitchOutResizePercent);

						canvas.drawImage(
								copy,
								(int) (xAwayCoord + awayPokemon
										.getxAwayOffset()
										* awayPokemonSwitchOutResizePercent),
								(int) (yAwayCoord - awayPokemon.getyOffset()
										* awayPokemonSwitchOutResizePercent),
								(int) (awayPokemon.getImageAwayWidth() * awayPokemonSwitchOutResizePercent),
								(int) (awayPokemon.getImageAwayHeight() * awayPokemonSwitchOutResizePercent),
								this);

					} else {
						if (framesAwayPokeballStayedOnOut == 18) {
							isAnimatingAwayPokemonSwitchOutResize = true;
							ballAwayReturnClip.play();
						} else if (framesAwayPokeballStayedOnOut == 36) {
							isAnimatingAwaySwitchOut = false;
						}

						if (framesAwayPokeballStayedOnOut <= 18) {
							int xAwayCoord = awayPokemonBaseX
									- awayPokemon.getImageAwayWidth() / 2;
							int yAwayCoord = awayPokemonBaseY
									- awayPokemon.getImageAwayHeight();

							canvas.drawImage(awayImage, xAwayCoord
									+ awayPokemon.getxAwayOffset(), yAwayCoord
									- awayPokemon.getyOffset(),
									awayPokemon.getImageAwayWidth(),
									awayPokemon.getImageAwayHeight(), this);
						}
						canvas.drawImage(pokeballClosed, awayPokemonBaseX
								- pokeballClosed.getWidth() / 2,
								awayPokemonBaseY - pokeballClosed.getHeight(),
								this);
					}
				} else if (isAnimatingAwayHP
						&& awayPokemon.getCurrentHP() > visibleAwayHP) {
					awayImage = Scalr.resize(awayImage, Method.SPEED,
							Mode.FIT_TO_WIDTH, awayPokemon.getImageAwayWidth());

					double pokemonRatio = 1.0 * awayPokemon.getImageAwayWidth()
							/ awayPokemon.getImageAwayHeight();
					double healRatio = 1.0 * healImage.getWidth()
							/ healImage.getHeight();

					BufferedImage tempHealImage = healImage;

					if (healRatio < pokemonRatio) {
						if (healImage.getWidth() < awayImage.getWidth()) {
							tempHealImage = Scalr.resize(healImage,
									Method.SPEED, Mode.FIT_TO_WIDTH,
									awayPokemon.getImageAwayWidth());
						}
					} else {
						if (healImage.getHeight() < awayImage.getHeight()) {
							tempHealImage = Scalr.resize(healImage,
									Method.SPEED, Mode.FIT_TO_HEIGHT,
									awayPokemon.getImageAwayHeight());
						}

					}

					// tempHealImage = Scalr.crop(tempHealImage,
					// awayImage.getWidth(), awayImage.getHeight());

					BufferedImage topPart;
					BufferedImage bottomPart = null;

					int topHeight = awayImage.getHeight();
					if (regainAwayHP % tempHealImage.getHeight() + topHeight > tempHealImage
							.getHeight()) {
						topHeight = tempHealImage.getHeight() - regainAwayHP
								% tempHealImage.getHeight();
					}

					topPart = Scalr.crop(tempHealImage, 0, regainAwayHP
							% tempHealImage.getHeight(), awayImage.getWidth(),
							topHeight);

					if (topPart.getHeight() < awayImage.getHeight()) {
						int heightNeeded = awayImage.getHeight()
								- topPart.getHeight();
						bottomPart = Scalr.crop(tempHealImage,
								awayImage.getWidth(), heightNeeded);
					}

					int[] colors = awayImage.getRGB(0, 0, awayImage.getWidth(),
							awayImage.getHeight(), null, 0,
							awayImage.getWidth());

					int[] healTopColors = topPart.getRGB(0, 0,
							topPart.getWidth(), topPart.getHeight(), null, 0,
							topPart.getWidth());

					int[] healBottomColors = null;

					if (bottomPart != null) {
						healBottomColors = bottomPart.getRGB(0, 0,
								bottomPart.getWidth(), bottomPart.getHeight(),
								null, 0, bottomPart.getWidth());
					}

					for (int i = 0; i < colors.length; i++) {
						if ((colors[i] >> 24) == 0x00) {
							if (i < healTopColors.length) {
								healTopColors[i] = 0x00000000;
							} else {
								healBottomColors[i - healTopColors.length] = 0x00000000;
							}

						}
					}

					topPart.setRGB(0, 0, topPart.getWidth(),
							topPart.getHeight(), healTopColors, 0,
							topPart.getWidth());

					if (healBottomColors != null) {
						bottomPart.setRGB(0, 0, bottomPart.getWidth(),
								bottomPart.getHeight(), healBottomColors, 0,
								bottomPart.getWidth());
					}

					int xAwayCoord = awayPokemonBaseX
							- awayPokemon.getImageAwayWidth() / 2;
					int yAwayCoord = awayPokemonBaseY
							- awayPokemon.getImageAwayHeight();

					canvas.drawImage(awayImage,
							xAwayCoord + awayPokemon.getxAwayOffset(),
							yAwayCoord - awayPokemon.getyOffset(), this);

					canvas.drawImage(topPart,
							xAwayCoord + awayPokemon.getxAwayOffset(),
							yAwayCoord - awayPokemon.getyOffset(), this);

					if (bottomPart != null) {
						canvas.drawImage(
								bottomPart,
								xAwayCoord + awayPokemon.getxAwayOffset(),
								yAwayCoord - awayPokemon.getyOffset()
										+ topPart.getHeight(), this);
					}

				} else if (isAnimatingAwayStatIncrease) {
					if (awayStatChange > 1.0 * totalTimeForStatChange / 1000
							* frameRate * 4) {
						isAnimatingAwayStatIncrease = false;
					}
					awayImage = Scalr.resize(awayImage, Method.SPEED,
							Mode.FIT_TO_WIDTH, awayPokemon.getImageAwayWidth());

					double pokemonRatio = 1.0 * awayPokemon.getImageAwayWidth()
							/ awayPokemon.getImageAwayHeight();
					double healRatio = 1.0 * increaseImage.getWidth()
							/ increaseImage.getHeight();

					BufferedImage tempIncreaseImage = increaseImage;

					if (healRatio < pokemonRatio) {
						if (increaseImage.getWidth() < awayImage.getWidth()) {
							tempIncreaseImage = Scalr.resize(increaseImage,
									Method.SPEED, Mode.FIT_TO_WIDTH,
									awayPokemon.getImageAwayWidth());
						}
					} else {
						if (increaseImage.getHeight() < awayImage.getHeight()) {
							tempIncreaseImage = Scalr.resize(increaseImage,
									Method.SPEED, Mode.FIT_TO_HEIGHT,
									awayPokemon.getImageAwayHeight());
						}
					}

					// tempHealImage = Scalr.crop(tempHealImage,
					// awayImage.getWidth(), awayImage.getHeight());

					BufferedImage topPart;
					BufferedImage bottomPart = null;

					int topHeight = awayImage.getHeight();
					if (awayStatChange % tempIncreaseImage.getHeight()
							+ topHeight > tempIncreaseImage.getHeight()) {
						topHeight = tempIncreaseImage.getHeight()
								- awayStatChange
								% tempIncreaseImage.getHeight();
					}

					topPart = Scalr.crop(tempIncreaseImage, 0, awayStatChange
							% tempIncreaseImage.getHeight(),
							awayImage.getWidth(), topHeight);

					if (topPart.getHeight() < awayImage.getHeight()) {
						int heightNeeded = awayImage.getHeight()
								- topPart.getHeight();
						bottomPart = Scalr.crop(tempIncreaseImage,
								awayImage.getWidth(), heightNeeded);
					}

					int[] colors = awayImage.getRGB(0, 0, awayImage.getWidth(),
							awayImage.getHeight(), null, 0,
							awayImage.getWidth());

					int[] increaseTopColors = topPart.getRGB(0, 0,
							topPart.getWidth(), topPart.getHeight(), null, 0,
							topPart.getWidth());

					int[] increaseBottomColors = null;

					if (bottomPart != null) {
						increaseBottomColors = bottomPart.getRGB(0, 0,
								bottomPart.getWidth(), bottomPart.getHeight(),
								null, 0, bottomPart.getWidth());
					}

					for (int i = 0; i < colors.length; i++) {
						if ((colors[i] >> 24) == 0x00) {
							if (i < increaseTopColors.length) {
								increaseTopColors[i] = 0x00000000;
							} else {
								increaseBottomColors[i
										- increaseTopColors.length] = 0x00000000;
							}

						}
					}

					topPart.setRGB(0, 0, topPart.getWidth(),
							topPart.getHeight(), increaseTopColors, 0,
							topPart.getWidth());

					if (increaseBottomColors != null) {
						bottomPart.setRGB(0, 0, bottomPart.getWidth(),
								bottomPart.getHeight(), increaseBottomColors,
								0, bottomPart.getWidth());
					}

					int xAwayCoord = awayPokemonBaseX
							- awayPokemon.getImageAwayWidth() / 2;
					int yAwayCoord = awayPokemonBaseY
							- awayPokemon.getImageAwayHeight();

					canvas.drawImage(awayImage,
							xAwayCoord + awayPokemon.getxAwayOffset(),
							yAwayCoord - awayPokemon.getyOffset(), this);

					canvas.drawImage(topPart,
							xAwayCoord + awayPokemon.getxAwayOffset(),
							yAwayCoord - awayPokemon.getyOffset(), this);

					if (bottomPart != null) {
						canvas.drawImage(
								bottomPart,
								xAwayCoord + awayPokemon.getxAwayOffset(),
								yAwayCoord - awayPokemon.getyOffset()
										+ topPart.getHeight(), this);
					}
				} else if (isAnimatingAwayStatDecrease) {
					if (awayStatChange > 1.0 * totalTimeForStatChange / 1000
							* frameRate * 4) {
						isAnimatingAwayStatDecrease = false;
					}
					awayImage = Scalr.resize(awayImage, Method.SPEED,
							Mode.FIT_TO_WIDTH, awayPokemon.getImageAwayWidth());

					double pokemonRatio = 1.0 * awayPokemon.getImageAwayWidth()
							/ awayPokemon.getImageAwayHeight();
					double healRatio = 1.0 * decreaseImage.getWidth()
							/ decreaseImage.getHeight();

					BufferedImage tempDecreaseImage = decreaseImage;

					if (healRatio < pokemonRatio) {
						if (decreaseImage.getWidth() < awayImage.getWidth()) {
							tempDecreaseImage = Scalr.resize(decreaseImage,
									Method.SPEED, Mode.FIT_TO_WIDTH,
									awayPokemon.getImageAwayWidth());
						}
					} else {
						if (decreaseImage.getHeight() < awayImage.getHeight()) {
							tempDecreaseImage = Scalr.resize(decreaseImage,
									Method.SPEED, Mode.FIT_TO_HEIGHT,
									awayPokemon.getImageAwayHeight());
						}
					}

					// tempHealImage = Scalr.crop(tempHealImage,
					// awayImage.getWidth(), awayImage.getHeight());

					BufferedImage topPart = null;
					BufferedImage bottomPart;

					int bottomHeight = awayImage.getHeight();
					if (awayStatChange % tempDecreaseImage.getHeight()
							+ bottomHeight > tempDecreaseImage.getHeight()) {
						bottomHeight = tempDecreaseImage.getHeight()
								- awayStatChange
								% tempDecreaseImage.getHeight();
					}

					bottomPart = Scalr.crop(tempDecreaseImage, 0,
							tempDecreaseImage.getHeight() - awayStatChange
									% tempDecreaseImage.getHeight()
									- bottomHeight, awayImage.getWidth(),
							bottomHeight);

					if (bottomPart.getHeight() < awayImage.getHeight()) {
						int heightNeeded = awayImage.getHeight()
								- bottomPart.getHeight();
						topPart = Scalr.crop(tempDecreaseImage, 0,
								tempDecreaseImage.getHeight() - heightNeeded,
								awayImage.getWidth(), heightNeeded);
					}

					int[] colors = awayImage.getRGB(0, 0, awayImage.getWidth(),
							awayImage.getHeight(), null, 0,
							awayImage.getWidth());

					int[] decreaseTopColors = null;

					if (topPart != null) {
						decreaseTopColors = topPart.getRGB(0, 0,
								topPart.getWidth(), topPart.getHeight(), null,
								0, topPart.getWidth());
					}

					int[] decreaseBottomColors = bottomPart.getRGB(0, 0,
							bottomPart.getWidth(), bottomPart.getHeight(),
							null, 0, bottomPart.getWidth());

					for (int i = 0; i < colors.length; i++) {
						if ((colors[i] >> 24) == 0x00) {
							if (decreaseTopColors != null) {
								if (i < decreaseTopColors.length) {
									decreaseTopColors[i] = 0x00000000;
								} else {
									decreaseBottomColors[i
											- decreaseTopColors.length] = 0x00000000;
								}
							} else {
								decreaseBottomColors[i] = 0x00000000;
							}

						}
					}

					if (decreaseTopColors != null) {
						topPart.setRGB(0, 0, topPart.getWidth(),
								topPart.getHeight(), decreaseTopColors, 0,
								topPart.getWidth());
					}

					bottomPart.setRGB(0, 0, bottomPart.getWidth(),
							bottomPart.getHeight(), decreaseBottomColors, 0,
							bottomPart.getWidth());

					int xAwayCoord = awayPokemonBaseX
							- awayPokemon.getImageAwayWidth() / 2;
					int yAwayCoord = awayPokemonBaseY
							- awayPokemon.getImageAwayHeight();

					canvas.drawImage(awayImage,
							xAwayCoord + awayPokemon.getxAwayOffset(),
							yAwayCoord - awayPokemon.getyOffset(), this);

					if (topPart != null) {
						canvas.drawImage(topPart,
								xAwayCoord + awayPokemon.getxAwayOffset(),
								yAwayCoord - awayPokemon.getyOffset(), this);
					}

					int bottomY = yAwayCoord - awayPokemon.getyOffset();
					if (topPart != null) {
						bottomY = yAwayCoord - awayPokemon.getyOffset()
								+ topPart.getHeight();
					}
					canvas.drawImage(bottomPart,
							xAwayCoord + awayPokemon.getxAwayOffset(), bottomY,
							this);

				} else if (awayPokemon.canBattle() && battle.isIntroDone()
						&& !aboutToSwitchAway) {
					// awayImage = Scalr.resize(awayImage, Method.SPEED,
					// Mode.FIT_TO_WIDTH, awayPokemon.getImageAwayWidth());

					// int newAwayBaseX = awayPokemonBaseX;
					// int newAwayBaseY = awayPokemonBaseY;

					/*
					 * if (isAnimatingAwayMove) { newAwayBaseX = (int)
					 * (attackProgress * homePokemonBaseX + (1 - attackProgress)
					 * awayPokemonBaseX); newAwayBaseY = (int) (attackProgress *
					 * homePokemonBaseY + (1 - attackProgress)
					 * awayPokemonBaseY); }
					 */

					int xAwayCoord = awayPokemonBaseX
							- awayPokemon.getImageAwayWidth() / 2;
					int yAwayCoord = awayPokemonBaseY
							- awayPokemon.getImageAwayHeight();

					canvas.drawImage(awayImage,
							xAwayCoord + awayPokemon.getxAwayOffset(),
							yAwayCoord - awayPokemon.getyOffset(),
							awayPokemon.getImageAwayWidth(),
							awayPokemon.getImageAwayHeight(), this);
				} else if (isAnimatingAwayFaint) {
					awayImage = Scalr.resize(awayImage, Method.SPEED,
							Mode.FIT_TO_WIDTH, awayPokemon.getImageAwayWidth());

					int xAwayCoord = awayPokemonBaseX
							- awayPokemon.getImageAwayWidth() / 2;
					int yAwayCoord = (int) (awayPokemonBaseY
							- awayPokemon.getImageAwayHeight()
							- awayPokemon.getyOffset() + awayFaintPixel);

					if (awayPokemonBaseY <= yAwayCoord) {
						isAnimatingAwayFaint = false;
					} else {
						if (yAwayCoord + awayPokemon.getImageAwayHeight() > awayPokemonBaseY) {
							awayImage = Scalr
									.crop(awayImage,
											awayImage.getWidth(),
											awayPokemon.getImageAwayHeight()
													- (yAwayCoord
															+ awayPokemon
																	.getImageAwayHeight() - awayPokemonBaseY));

						}
						canvas.drawImage(awayImage,
								xAwayCoord + awayPokemon.getxAwayOffset(),
								yAwayCoord, this);
					}
				}
			}

			/*
			 * if (isAnimatingHomeMove) { if (attackProgress > .5) {
			 * canvas.drawImage(tackle, awayPokemonBaseX, awayPokemonBaseY -
			 * 150, this); } } if (isAnimatingAwayMove) { if (attackProgress >
			 * .5) { canvas.drawImage(tackle, homePokemonBaseX, homePokemonBaseY
			 * - 150, this); } }
			 */

			/*
			 * end animation stuff
			 */

			// set the color to the semi-transparent info background color
			canvas.setColor(pokemonInfoColor);

			// fill the home Info
			canvas.fillRoundRect(homeInfoX, homeInfoY, homeInfoWidth,
					homeInfoHeight, infoArc, infoArc);

			// set the color to black
			canvas.setColor(Color.black);

			// create and set the stroke

			canvas.setStroke(stroke);

			// draw the border
			canvas.drawRoundRect(homeInfoX, homeInfoY, homeInfoWidth,
					homeInfoHeight, infoArc, infoArc);

			// set the font
			canvas.setFont(new Font("Pokemon FireLeaf", Font.PLAIN, 23));

			// the name of the home pokemon
			String homeName = homePokemon.getName();

			// the current font height
			int stringHeight = canvas.getFontMetrics().getHeight();

			// the base of the home name
			int homeNameBaseY = homeInfoY + homeNameBufferHeight + stringHeight;

			// the level text
			String homeLevelString = "Lv" + homePokemon.getLevel();

			// the width of the level text
			int homeLvlStringWidth = canvas.getFontMetrics().stringWidth(
					homeLevelString);
			// the coordinates for the level text
			int homeLvlBaseX = homeLvlBoundaryEastX - homeLvlStringWidth;
			int homeLvlBaseY = homeNameBaseY;

			// draw the level string and the home pokemon name
			canvas.drawString(homeLevelString, homeLvlBaseX, homeLvlBaseY);
			canvas.drawString(homeName, homeNameBaseX, homeNameBaseY);

			// the gender symbols
			if (homePokemon.isMale()) {

				int symbolX = homeLvlBaseX - symbolWidthBuffer
						- maleSymbolWidth;
				int symbolY = homeLvlBaseY - maleSymbolHeight;
				canvas.drawImage(maleSymbol, symbolX, symbolY, this);
			} else if (homePokemon.isFemale()) {
				int symbolX = homeLvlBaseX - symbolWidthBuffer
						- femaleSymbolWidth;
				int symbolY = homeLvlBaseY - femaleSymbolHeight;
				canvas.drawImage(femaleSymbol, symbolX, symbolY, this);
			}

			// set a new font
			canvas.setFont(new Font("Pokemon FireLeaf", Font.BOLD, 11));
			// get the new string height
			stringHeight = canvas.getFontMetrics().getHeight();

			// the length of the hp text
			int hpLength = canvas.getFontMetrics().stringWidth(hpString);

			// the width of the backing of the hp bar
			int hpBarBackWidth = hpTextBuffer + hpLength + hpTextBuffer
					+ hpBarTotalWidth + hpWidthBuffer;

			int hpHomeBackY = homeNameBaseY + hpBarBackDistanceFromName;

			// the coordinates of the hp backing
			int hpHomeBackX = homeInfoX + homeInfoWidth
					- hpBarBackDistanceFromEdge - hpBarBackWidth;
			// the coordinates of the hp text
			int hpHomeTextBaseX = hpHomeBackX + hpTextBuffer + 1;

			int hpHomeTextBaseY = hpHomeBackY + stringHeight
					+ (hpBarBackHeight - stringHeight) / 2;

			// fill the hp backing
			canvas.fillRoundRect(hpHomeBackX, hpHomeBackY, hpBarBackWidth,
					hpBarBackHeight, 8, 8);

			canvas.setColor(hpTextColor);

			// draw the hp string
			canvas.drawString(hpString, hpHomeTextBaseX, hpHomeTextBaseY);

			// the percentage of the visible home health
			double homeHealthPercentage = 1.0 * visibleHomeHP
					/ homePokemon.getTotalHP();

			// the width of the visible home hp
			int hpHomeWidth = (int) (hpBarTotalWidth * homeHealthPercentage);

			// want the hp bar to be visible
			if (hpHomeWidth < 3 && !homePokemon.isFainted())
				hpHomeWidth = 3;

			// get the color of the hp bar depending on the health
			if (homeHealthPercentage > 0.50)
				canvas.setColor(hpBarColorGreen);
			else if (homeHealthPercentage > 0.20)
				canvas.setColor(hpBarColorYellow);
			else
				canvas.setColor(hpBarColorRed);

			// the coordinates of the actual hp bar
			int hpHomeBarX = hpHomeTextBaseX + hpLength + hpTextBuffer;
			int hpHomeBarY = hpHomeBackY + hpHeightBuffer;

			// fill in the actual hp bar
			canvas.fillRoundRect(hpHomeBarX, hpHomeBarY, hpHomeWidth,
					hpBarHeight, 5, 5);

			// back in black
			canvas.setColor(Color.black);

			// the numerical hp string, only for home
			String homeNumericalHP = (int) visibleHomeHP + "/"
					+ homePokemon.getTotalHP();

			// set a new font and get the new string height
			canvas.setFont(new Font("Pokemon FireLeaf", Font.BOLD, 15));
			stringHeight = canvas.getFontMetrics().getHeight();

			// the coordinates of the hp numerical string
			int homeNumericalHPX = hpHomeBackX + hpTextBuffer + hpLength
					+ hpTextBuffer;
			int homeNumericalHPY = hpHomeBackY + hpBarBackHeight + 5
					+ stringHeight;
			// draw the numerical hp
			canvas.drawString(homeNumericalHP, homeNumericalHPX,
					homeNumericalHPY);

			// draw the status ailment if there is one
			if (homePokemon.hasMajorStatusAilment()) {
				Image image = homePokemon.getStatusAilment().getImage();
				canvas.drawImage(image, homeInfoX + 10, homeNameBaseY + 10,
						this);
			}

			// set the color to the semi-transparent info background color
			canvas.setColor(pokemonInfoColor);

			// fill the home Info
			canvas.fillRoundRect(awayInfoX, awayInfoY, awayInfoWidth,
					awayInfoHeight, infoArc, infoArc);

			// set the color to black
			canvas.setColor(Color.black);

			// draw the border
			canvas.drawRoundRect(awayInfoX, awayInfoY, awayInfoWidth,
					awayInfoHeight, infoArc, infoArc);

			// set the font
			canvas.setFont(new Font("Pokemon FireLeaf", Font.PLAIN, 23));

			// the name of the home pokemon
			String awayName = awayPokemon.getName();

			stringHeight = canvas.getFontMetrics().getHeight();

			// the base of the home name
			int awayNameBaseY = awayInfoY + awayNameBufferHeight + stringHeight;

			// the level text
			String awayLevelString = "Lv" + awayPokemon.getLevel();

			// the width of the level text
			int awayLvlStringWidth = canvas.getFontMetrics().stringWidth(
					awayLevelString);
			// the coordinates for the level text
			int awayLvlBaseX = awayLvlBoundaryEastX - awayLvlStringWidth;
			int awayLvlBaseY = awayNameBaseY;

			// draw the level string and the home pokemon name
			canvas.drawString(awayLevelString, awayLvlBaseX, awayLvlBaseY);
			canvas.drawString(awayName, awayNameBaseX, awayNameBaseY);

			// the gender symbols
			if (awayPokemon.isMale()) {
				int symbolX = awayLvlBaseX - symbolWidthBuffer
						- maleSymbolWidth;
				int symbolY = awayLvlBaseY - maleSymbolHeight;
				canvas.drawImage(maleSymbol, symbolX, symbolY, this);
			} else if (awayPokemon.isFemale()) {
				int symbolX = awayLvlBaseX - symbolWidthBuffer
						- femaleSymbolWidth;
				int symbolY = awayLvlBaseY - femaleSymbolHeight;
				canvas.drawImage(femaleSymbol, symbolX, symbolY, this);
			}

			// set a new font
			canvas.setFont(new Font("Pokemon FireLeaf", Font.BOLD, 11));
			// get the new string height
			stringHeight = canvas.getFontMetrics().getHeight();

			// the coordinates of the hp backing
			int hpAwayBackX = awayInfoX + awayInfoWidth
					- hpBarBackDistanceFromEdge - hpBarBackWidth;
			int hpAwayBackY = awayNameBaseY + hpBarBackDistanceFromName;

			// the coordinates of the hp text
			int hpAwayTextBaseX = hpAwayBackX + hpTextBuffer + 1;
			int hpAwayTextBaseY = hpAwayBackY + stringHeight
					+ (hpBarBackHeight - stringHeight) / 2;

			// fill the hp backing
			canvas.fillRoundRect(hpAwayBackX, hpAwayBackY, hpBarBackWidth,
					hpBarBackHeight, 8, 8);

			canvas.setColor(hpTextColor);

			// draw the hp string
			canvas.drawString(hpString, hpAwayTextBaseX, hpAwayTextBaseY);

			// the percentage of the visible home health
			double awayHealthPercentage = 1.0 * visibleAwayHP
					/ awayPokemon.getTotalHP();

			// the width of the visible home hp
			int hpAwayWidth = (int) (hpBarTotalWidth * awayHealthPercentage);

			// want the hp bar to be visible
			if (hpAwayWidth < 3 && !awayPokemon.isFainted())
				hpAwayWidth = 3;

			// get the color of the hp bar depending on the health
			if (awayHealthPercentage > 0.50)
				canvas.setColor(hpBarColorGreen);
			else if (awayHealthPercentage > 0.20)
				canvas.setColor(hpBarColorYellow);
			else
				canvas.setColor(hpBarColorRed);

			// the coordinates of the actual hp bar
			int hpAwayBarX = hpAwayTextBaseX + hpLength + hpTextBuffer;
			int hpAwayBarY = hpAwayBackY + hpHeightBuffer;

			// fill in the actual hp bar
			canvas.fillRoundRect(hpAwayBarX, hpAwayBarY, hpAwayWidth,
					hpBarHeight, 5, 5);

			// draw the status ailment if there is one
			if (awayPokemon.hasMajorStatusAilment()) {
				Image image = awayPokemon.getStatusAilment().getImage();
				canvas.drawImage(image, awayInfoX + 10, awayNameBaseY + 2, this);
			}

			if (isAnimatingHomeAbility) {

				int aWidth = 200;
				int aHeight = 30;

				int aX = 0;
				if (homeAbilityFrame < aWidth) {
					aX = homeAbilityFrame - aWidth;
				} else if (homeAbilityFrame < aWidth + 300) {
					aX = 0;
				} else {
					int temp = homeAbilityFrame - (aWidth + 300);
					aX = -temp;
					if (temp > aWidth) {
						isAnimatingHomeAbility = false;
					}
				}
				int aY = homeInfoY + homeInfoHeight + 15;

				Color startColor = new Color(222, 222, 222, 180);
				Color endColor = new Color(56, 62, 249, 180);

				Paint paint = canvas.getPaint();

				GradientPaint gp = new GradientPaint(aX, aY, startColor, aX
						+ aWidth, aY + aHeight, endColor);

				canvas.setPaint(gp);

				canvas.fillRoundRect(-aWidth + aX, aY, 2 * aWidth, aHeight,
						480, 480);

				canvas.setPaint(paint);

				canvas.setColor(Color.white);

				canvas.setFont(new Font("Pokemon FireLeaf", Font.BOLD, 20));

				int fontHeight = canvas.getFontMetrics().getHeight();

				canvas.drawString(homePokemon.getAbility().getName(), aX + 15,
						aY + aHeight / 2 + fontHeight / 2);
			}

			if (isAnimatingAwayAbility) {

				int aWidth = 200;
				int aHeight = 30;

				int aX = 0;
				if (awayAbilityFrame < aWidth) {
					aX = awayAbilityFrame - aWidth;
				} else if (awayAbilityFrame < aWidth + 300) {
					aX = 0;
				} else {
					int temp = awayAbilityFrame - (aWidth + 300);
					aX = -temp;
					if (temp > aWidth) {
						isAnimatingAwayAbility = false;
					}
				}
				aX = frameWidth - aX - aWidth;

				int aY = awayInfoY + awayInfoHeight + 15;

				Color endColor = new Color(222, 222, 222, 180);
				Color startColor = new Color(56, 62, 249, 180);

				Paint paint = canvas.getPaint();

				GradientPaint gp = new GradientPaint(aX, aY, startColor, aX
						+ aWidth, aY + aHeight, endColor);

				canvas.setPaint(gp);

				canvas.fillRoundRect(aX, aY, 2 * aWidth, aHeight, 480, 480);

				canvas.setPaint(paint);

				canvas.setColor(Color.white);

				canvas.setFont(new Font("Pokemon FireLeaf", Font.BOLD, 20));

				int fontHeight = canvas.getFontMetrics().getHeight();
				int fontWidth = canvas.getFontMetrics().stringWidth(
						awayPokemon.getAbility().getName());

				canvas.drawString(awayPokemon.getAbility().getName(), aX
						+ aWidth - 15 - fontWidth, aY + aHeight / 2
						+ fontHeight / 2);
			}

		}
		
		/*int[] destArray = new int[graphicsImage.getWidth()*graphicsImage.getHeight()*4];
		
		Hqx_2x.hq2x_32_rb(graphicsImage.getRGB(0,0, graphicsImage.getWidth(), graphicsImage.getHeight(), 
				null, 0, graphicsImage.getWidth()), destArray, graphicsImage.getWidth(), graphicsImage.getHeight());
		
		BufferedImage scaledGraphics = new BufferedImage(graphicsImage.getWidth()*2,graphicsImage.getHeight()*2,BufferedImage.TYPE_INT_ARGB);
		
		scaledGraphics.setRGB(0, 0, graphicsImage.getWidth()*2, graphicsImage.getHeight()*2, destArray, 0, graphicsImage.getWidth()*2);
		*/
		Graphics2D actualCanvas = (Graphics2D) (g);
		actualCanvas.drawImage(Scalr.resize(graphicsImage, Method.SPEED,
				Mode.FIT_TO_WIDTH, getWidth()), 0,0,this);
		

		/*
		 * BufferedImage bi = new BufferedImage(frameWidth, frameHeight,
		 * BufferedImage.TYPE_INT_ARGB);
		 * 
		 * Graphics2D gr = bi.createGraphics();
		 * 
		 * gr.
		 */
	}

	/**
	 * the timer
	 * 
	 * @author Ashwin
	 *
	 */
	private class FrameTimer implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			/*
			 * if (!isFrameFull) {// frame sizing
			 * 
			 * if (currentWidth < frameWidth*3/4) { currentWidth +=
			 * incrementFrameWidth; } else if (currentWidth > frameWidth*3/4) {
			 * currentWidth = frameWidth*3/4; } if (currentHeight <
			 * frameHeight*3/4) { currentHeight += incrementFrameHeight; } else
			 * if (currentHeight > frameHeight*3/4) { currentHeight =
			 * frameHeight*3/4; } if (currentWidth == frameWidth*3/4 &&
			 * currentHeight == frameHeight*3/4){ isFrameFull = true; }
			 * 
			 * 
			 * 
			 * int currentIntWidth = (int) currentWidth; int currentIntHeight =
			 * (int) currentHeight;
			 * 
			 * frame.getContentPane().setPreferredSize( new
			 * Dimension(currentIntWidth, currentIntHeight));
			 * frame.getContentPane().setSize( new Dimension((int) currentWidth,
			 * currentIntHeight));
			 * 
			 * setSize(new Dimension(currentIntWidth, currentIntHeight));
			 * setPreferredSize(new Dimension(currentIntWidth,
			 * currentIntHeight));
			 * 
			 * // set the size of the text area textArea.setSize(new
			 * Dimension(currentIntWidth,
			 * textAreaHeight*currentIntHeight/frameHeight));
			 * textArea.setPreferredSize(new Dimension(currentIntWidth,
			 * textAreaHeight*currentIntHeight/frameHeight)); // set the
			 * location to just textArea.setLocation(0, currentIntHeight -
			 * textAreaHeight*currentIntHeight/frameHeight);
			 * 
			 * // set the font textArea.setFont(new Font("Pokemon FireLeaf",
			 * Font.TRUETYPE_FONT, 18*currentIntHeight/frameHeight));
			 * 
			 * // set the bounds to where the text area is
			 * textAreaScrollPane.setBounds(0, currentIntHeight -
			 * textAreaHeight*currentIntHeight/frameHeight, currentIntWidth,
			 * textAreaHeight*currentIntHeight/frameHeight);
			 * 
			 * frame.revalidate(); frame.pack();
			 * 
			 * if (isFrameInLocation) { int xCoord =
			 * frame.getToolkit().getScreenSize().width / 2 - frame.getWidth() /
			 * 2; frame.setLocation(xCoord, 0); } }
			 * 
			 * if (!isFrameInLocation) {// frame moving boolean isInLocationX;
			 * boolean isInLocationY; if (currentFrameLocationY > 0) {
			 * currentFrameLocationY -= incrementYLocale; isInLocationY = false;
			 * } else { currentFrameLocationY = 0; isInLocationY = true; }
			 * 
			 * int centerScreenX = (int) (frame.getToolkit().getScreenSize()
			 * .getWidth() / 2);
			 * 
			 * if (Math.abs(centerScreenX - currentFrameLocationX) <
			 * incrementXLocale) { currentFrameLocationX = centerScreenX;
			 * isInLocationX = true; } else if (currentFrameLocationX >
			 * centerScreenX) { currentFrameLocationX -= incrementXLocale;
			 * isInLocationX = false; } else { currentFrameLocationX +=
			 * incrementXLocale; isInLocationX = false; } if (isInLocationX &&
			 * isInLocationY) { isFrameInLocation = true; } int xCoord = (int)
			 * (currentFrameLocationX - frame.getWidth() / 2);
			 * frame.setLocation(xCoord, (int) currentFrameLocationY); }
			 */

			/*
			 * if (isFrameFull && isFrameInLocation && !battle.hasStarted()) {
			 * new Thread(new Runnable() { public void run() {
			 * battle.startBattle(); } }).start(); }
			 */

			if (isAnimatingHomeSwitchIn) {
				if (isAnimatingHomeSwitchInPokeball) {
					homePokeballFrame += 1.0 * frameRate
							/ timeToThrowInPokeball;
					homePokeballRotation += 1.0 * frameRate * pokeballRotations
							* 360 / timeToThrowInPokeball;

					if (homePokeballFrame > 1) {
						homePokeballFrame = 1;
						homePokeballRotation = 0;
						framesHomePokeballStayed++;
					}
				} else if (isAnimatingHomeOpenPokeball) {
					framesHomeOpenPokeballStayed++;
				} else if (isAnimatingHomePokemonSwitchInResize) {
					homePokemonSwitchInResizePercent += 1.0 * frameRate
							/ pokemonResizeTime;
					if (homePokemonSwitchInResizePercent > 1) {
						homePokemonSwitchInResizePercent = 1;
					}

				}
			}

			if (isAnimatingHomeSwitchOut) {
				if (isAnimatingHomePokemonSwitchOutResize) {
					homePokemonSwitchOutResizePercent -= 1.0 * frameRate
							/ pokemonResizeTime;
					if (homePokemonSwitchOutResizePercent < 0)
						homePokemonSwitchOutResizePercent = 0;
				} else {
					framesHomePokeballStayedOnOut++;
				}
			}

			if (isAnimatingAwaySwitchIn) {
				if (isAnimatingAwaySwitchInPokeball) {
					awayPokeballFrame += 1.0 * frameRate
							/ timeToThrowInPokeball;
					awayPokeballRotation += 1.0 * frameRate * pokeballRotations
							* 360 / timeToThrowInPokeball;
					if (awayPokeballFrame > 1) {
						awayPokeballFrame = 1;
						awayPokeballRotation = 0;
						framesAwayPokeballStayed++;
					}
				} else if (isAnimatingAwayOpenPokeball) {
					framesAwayOpenPokeballStayed++;
				} else if (isAnimatingAwayPokemonSwitchInResize) {
					awayPokemonSwitchInResizePercent += 1.0 * frameRate
							/ pokemonResizeTime;
					if (awayPokemonSwitchInResizePercent > 1) {
						awayPokemonSwitchInResizePercent = 1;
					}

				}
			}

			if (isAnimatingAwaySwitchOut) {
				if (isAnimatingAwayPokemonSwitchOutResize) {
					awayPokemonSwitchOutResizePercent -= 1.0 * frameRate
							/ pokemonResizeTime;
					if (awayPokemonSwitchOutResizePercent < 0)
						awayPokemonSwitchOutResizePercent = 0;
				} else {
					framesAwayPokeballStayedOnOut++;
				}
			}

			if (isAnimatingHomeFaint) {
				homeFaintPixel += 12;
			}

			if (isAnimatingAwayFaint) {
				awayFaintPixel += 8;
			}

			if (isAnimatingHomeStatIncrease || isAnimatingHomeStatDecrease) {
				homeStatChange += 4;
			}

			if (isAnimatingAwayStatIncrease || isAnimatingAwayStatDecrease) {
				awayStatChange += 4;
			}

			frame.repaint();
			
			InBattlePokemon homePokemon = battle.getHomePokemon();
			InBattlePokemon awayPokemon = battle.getAwayPokemon();

			if (!homePokemon.isFrozen()) {
				if(homePokemon.isAsleep()){
					homeFrame += 0.1;
				} else if(homePokemon.isBadlyPoisoned()) {
					homeFrame += 0.4;
				} else if(homePokemon.isPoisoned()) {
					homeFrame += 0.75;
				} else if(homePokemon.isBurned()) {
					homeFrame += 0.5;
				} else if(homePokemon.isParalyzed()) {
					homeFrame += 0.25;
				} else {
					homeFrame++;// increment the home frame
				}
			}
				
				
			if (!awayPokemon.isFrozen()) {
				if(awayPokemon.isAsleep()){
					awayFrame += 0.1;
				} else if(awayPokemon.isBadlyPoisoned()) {
					awayFrame += 0.4;
				} else if(awayPokemon.isPoisoned()) {
					awayFrame += 0.75;
				} else if(awayPokemon.isBurned()) {
					awayFrame += 0.5;
				} else if(awayPokemon.isParalyzed()) {
					awayFrame += 0.25;
				} else {
					awayFrame++;// increment the away frame
				} 
			}

			if (isAnimatingHomeHP) {
				if (visibleHomeHP < battle.getHomePokemon().getCurrentHP()) {
					visibleHomeHP += 1.8;
					regainHomeHP += 15;
				} else if (visibleHomeHP > battle.getHomePokemon()
						.getCurrentHP()) {
					visibleHomeHP -= 1.8;
				} else {
					isAnimatingHomeHP = false;
				}
				if (Math.abs(visibleHomeHP
						- battle.getHomePokemon().getCurrentHP()) < 1.8) {
					isAnimatingHomeHP = false;
					visibleHomeHP = battle.getHomePokemon().getCurrentHP();
				}
			}
			if (isAnimatingAwayHP) {
				if (visibleAwayHP < battle.getAwayPokemon().getCurrentHP()) {
					visibleAwayHP += 1.8;
					regainAwayHP += 15;
				} else if (visibleAwayHP > battle.getAwayPokemon()
						.getCurrentHP()) {
					visibleAwayHP -= 1.8;
				} else {
					isAnimatingAwayHP = false;
				}
				if (Math.abs(visibleAwayHP
						- battle.getAwayPokemon().getCurrentHP()) < 1.8) {
					isAnimatingAwayHP = false;
					visibleAwayHP = battle.getAwayPokemon().getCurrentHP();
				}
			}

			if (isAnimatingHomeAbility) {
				homeAbilityFrame += 6;
			}
			if (isAnimatingAwayAbility) {
				awayAbilityFrame += 6;
			}

		}
	}

	/**
	 * Displays the disclaimer frame
	 * 
	 * @author Ashwin
	 *
	 */
	private class DisclaimListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			disclaimerFrame.setVisible(true);
		}
	}

	private class PokeBGPanel extends JPanel {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private Image pokeBG = imageGetter.getImage("pokeball1600x1200.png");

		public PokeBGPanel() {
			pokeBG = pokeBG.getScaledInstance(controlsFrameWidth, -1,
					Image.SCALE_SMOOTH);
			pokeBG = new ImageIcon(pokeBG).getImage();
		}

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D canvas = (Graphics2D) g;

			int imageWidth = pokeBG.getWidth(this);
			int imageHeight = pokeBG.getHeight(this);

			int offsetWidth = (imageWidth - this.getWidth()) / 2;
			int offsetHeight = (imageHeight - this.getHeight()) / 2;

			canvas.drawImage(pokeBG, -offsetWidth, -offsetHeight, this);

		}
	}

	private class PartyButton extends JButton {

		private static final long serialVersionUID = -5979904265072603891L;
		private int partyIndex;

		public PartyButton(int partyIndex) {
			this.partyIndex = partyIndex;
			super.setContentAreaFilled(false);
			setBorder(null);
			setPreferredSize(new Dimension(partyButtonWidth, partyButtonHeight));
		}

		protected void paintComponent(Graphics g) {
			Graphics2D canvas = (Graphics2D) g;
			canvas.setFont(fireredFont);
			PartyPokemon pokemon = battle.getHomeTrainer().getTeam()[partyIndex];

			int width = getWidth(), height = getHeight();

			Color bgColorForNow;

			if (getModel().isPressed() || getModel().isRollover()) {
				if (pokemon.isFainted()) {
					bgColorForNow = bgPartyButtonFaintSelectColor;
				} else {
					bgColorForNow = bgPartyButtonSelectColor;
				}
			} else {
				if (pokemon.isFainted()) {
					bgColorForNow = bgPartyButtonFaintColor;
				} else {
					bgColorForNow = bgPartyButtonColor;
				}
			}

			canvas.setColor(bgColorForNow);

			if (partyIndex == 0) {
				canvas.fillRoundRect(0, 0, width, height, 50, 50);
				canvas.fillRect(width / 2, 0, width - width / 2, height);
			} else {
				canvas.fillPolygon(partyButtonPolygon);
			}

			String pokemonName = pokemon.getName();

			FontMetrics fm = canvas.getFontMetrics(fireredFont);
			int fontHeight = fm.getAscent();
			// int fontWidth = fm.stringWidth(pokemonName);

			canvas.setColor(Color.white);

			int partyPokemonNameBaseX = 20, partyPokemonNameBaseY = 17;
			canvas.drawString(pokemonName, partyPokemonNameBaseX,
					partyPokemonNameBaseY);
			if (pokemon.hasMajorStatusAilment()) {
				Image statusImage = pokemon.getStatusAilment().getImage();
				int statusY = height - statusImage.getHeight(this) - 5;
				canvas.drawImage(statusImage, 15, statusY, this);
			}
			int currentHP = pokemon.getCurrentHP();
			int totalHP = pokemon.getTotalHP();

			Color hpGreenColor = new Color(99, 255, 99);
			Color hpYellowColor = new Color(255, 222, 0);
			Color hpRedColor = new Color(255, 74, 57);
			Color emptyHPColor = new Color(107, 115, 99);
			Color hpBorder = Color.black;
			Color hpTextColor = new Color(239, 132, 8);
			int hpTextWidth = fm.stringWidth("HP");

			int hpBarWidth = partyButtonWidth / 2;

			double hpPercentage = 1.0 * currentHP / totalHP;

			int currentHPWidth = (int) (hpBarWidth * hpPercentage);

			canvas.setColor(hpBorder);

			canvas.fillRect(partyPokemonNameBaseX + hpTextWidth,
					partyPokemonNameBaseY + 5, hpBarWidth + 6, 8);

			canvas.setColor(emptyHPColor);
			canvas.fillRect(partyPokemonNameBaseX + hpTextWidth + 3,
					partyPokemonNameBaseY + 7, hpBarWidth, 4);

			if (hpPercentage > 0.5) {
				canvas.setColor(hpGreenColor);
			} else if (hpPercentage > 0.2) {
				canvas.setColor(hpYellowColor);
			} else {
				canvas.setColor(hpRedColor);
			}

			canvas.fillRect(partyPokemonNameBaseX + hpTextWidth + 3,
					partyPokemonNameBaseY + 7, currentHPWidth, 4);

			canvas.setColor(hpTextColor);
			canvas.drawString("HP", partyPokemonNameBaseX,
					partyPokemonNameBaseY + fontHeight);

		}
	}

	private class MoveButton extends JButton {

		private static final long serialVersionUID = 8490576171687511308L;
		private int moveIndex;

		public MoveButton(int moveIndex) {
			super.setContentAreaFilled(false);
			setBorder(null);
			setPreferredSize(new Dimension(moveButtonWidth, moveButtonHeight));
			this.moveIndex = moveIndex;
		}

		@Override
		protected void paintComponent(Graphics g) {
			Graphics2D canvas = (Graphics2D) g;
			canvas.setFont(new Font("Pokemon FireLeaf", Font.TRUETYPE_FONT, 18));
			Move move = battle.getHomePokemon().getMove(moveIndex);
			Color color = move.getType().getColor();
			if (getModel().isPressed()) {
				canvas.setColor(color.brighter().brighter());
			} else if (getModel().isRollover()) {
				canvas.setColor(color.brighter());
			} else {
				canvas.setColor(color);
			}

			int width = getWidth(), height = getHeight();
			canvas.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);

			canvas.setColor(new Color(221, 234, 162, 150));
			canvas.fillRect(width / 10, height / 10, width * 4 / 5,
					height * 4 / 5);

			Image img = move.getType().getImage();

			int xCoord = width / 10 + 3;
			int yCoord = height * 9 / 10 - img.getHeight(this) - 3;

			canvas.drawImage(img, xCoord, yCoord, this);

			canvas.setColor(Color.BLACK);
			drawCenteredString(move.getName(), getWidth(), getHeight(), g);
			canvas.drawString(move.getCurrentPP() + "/" + move.getTotalPP(),
					getWidth() / 2, height * 9 / 10 - 3);
		}

		public void drawCenteredString(String s, int w, int h, Graphics g) {
			FontMetrics fm = g.getFontMetrics();
			int x = (w - fm.stringWidth(s)) / 2;
			int y = h / 3;
			g.drawString(s, x, y);
		}
	}

	private class SwitchButton extends JButton {

		private static final long serialVersionUID = 182157337644148992L;
		private Image notHover, hover;

		public SwitchButton() {
			super.setContentAreaFilled(false);
			setBorder(null);
			BufferedImage[] images = new SpriteSheetReader().getSprites(
					"battleCommandButtons.png", 130, 46, 1, 2);
			hover = images[1];
			notHover = images[0];
			setPreferredSize(new Dimension(switchWidth, switchHeight));
		}

		@Override
		protected void paintComponent(Graphics g) {
			Graphics2D canvas = (Graphics2D) g;
			if (getModel().isPressed()) {
				canvas.drawImage(hover, 0, 0, this);
			} else if (getModel().isRollover()) {
				canvas.drawImage(hover, 0, 0, this);
			} else {
				canvas.drawImage(notHover, 0, 0, this);
			}
		}
	}

	private class MoveListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JButton button = (JButton) e.getSource();
			if (!battle.homeHasNextMove() && !battle.willHomeSwitch()) {
				for (int i = 0; i < moveButtons.length; i++) {
					if (button.equals(moveButtons[i])) {
						if (battle.getHomePokemon().getMove(i).getCurrentPP() <= 0) {
							consolePrintln(battle.getHomePokemon().getMove(i)
									.getName()
									+ " is out of PP!");
						} else if (battle.getHomePokemon().getMove(i)
								.isStatus()
								&& battle.getHomePokemon().isTaunted()) {
							consolePrintln(battle.getHomePokemon().getName()
									+ " can't use that move after the taunt.");
						} else if (battle.getHomePokemon().hasLastMove()
								&& battle
										.getHomePokemon()
										.getMove(i)
										.equals(battle.getHomePokemon()
												.getLastMove())
								&& battle.getHomePokemon().isTormented()) {
							consolePrintln(battle.getHomePokemon().getName()
									+ " can't use the same move twice in a row due to torment.");
						} else {
							battle.setHomeMove(i);
							pokemonClient.send("opponentmove" + i);
							removeMoveButtons();
							pokemonClient.send("opponentmove" + i);
						}
						return;
					}
				}
			}
		}
	}

	private class SwitchListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			removeMoveButtons();
			addPartyScreen();
		}
	}

	private class CancelListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			removePartyScreen();
			addMoveButtons();
		}
	}

	private class PartyListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			InBattlePokemon homePokemon = battle.getHomePokemon();
			if(battle.getAwayPokemon().getAbility().equals(Abilities.ARENA_TRAP) && !homePokemon.isType(Types.FLYING)
					&& !homePokemon.isType(Types.GHOST)
					&& homePokemon.getAbility().equals(Abilities.LEVITATE)){
				animateAwayAbility();
				return;
			}
			if(battle.getAwayPokemon().getAbility().equals(Abilities.MAGNET_PULL) && !homePokemon.isType(Types.STEEL)){
				animateAwayAbility();
				return;
			}
			for (int i = 0; i < partyButtons.length; i++) {
				if (e.getSource().equals(partyButtons[i])) {
					if (battle.getHomeTrainer().getTeam()[i].isFainted()) {
						consolePrintln(battle.getHomeTrainer().getTeam()[i]
								.getName() + " has fainted. It can't battle!");
					} else if (battle.getHomeTrainer().getTeam()[i]
							.equals(battle.getHomePokemon())) {
						consolePrintln(battle.getHomePokemon().getName()
								+ " is already in battle.");
					} else {
						battle.setUpSwitchForHomeTeam(i);
						removePartyScreen();
						pokemonClient.send("switchchoice" + i);
						break;
					}
				}
			}
		}
	}

	/**
	 * @return the frameWidth
	 */
	public int getFrameWidth() {
		return frameWidth;
	}

	/**
	 * @return the frameHeight
	 */
	public int getFrameHeight() {
		return frameHeight;
	}

	/**
	 * @return the frameHeight
	 */
	public int getBattleDisplayHeight() {
		return battleDisplayHeight;
	}

	@SuppressWarnings("unused")
	private class RightClicker extends MouseAdapter implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {

		}

	}

	public void setBattle(Battle battle) {
		this.battle = battle;
	}

	public void animateSwitchIn(PartyPokemon p) {
		if (p.isHome()) {
			animateHomeSwitchIn();
		} else
			animateAwaySwitchIn();
	}

	public void animateHomeSwitchIn() {
		aboutToSwitchHome = false;
		isAnimatingHomeSwitchIn = true;
		isAnimatingHomeSwitchInPokeball = true;
		homePokeballRotation = 0;
		homePokeballFrame = 0;
		framesHomePokeballStayed = 0;
		framesHomeOpenPokeballStayed = 0;
		isAnimatingHomeOpenPokeball = false;
		isAnimatingHomePokemonSwitchInResize = false;
		homePokemonSwitchInResizePercent = 0;
	}

	public void setAboutToSwitchHome() {
		aboutToSwitchHome = true;
	}

	public void animateAwaySwitchIn() {
		aboutToSwitchAway = false;
		isAnimatingAwaySwitchIn = true;
		isAnimatingAwaySwitchInPokeball = true;
		awayPokeballRotation = 0;
		awayPokeballFrame = 0;
		framesAwayPokeballStayed = 0;
		framesAwayOpenPokeballStayed = 0;
		isAnimatingAwayOpenPokeball = false;
		isAnimatingAwayPokemonSwitchInResize = false;
		awayPokemonSwitchInResizePercent = 0;
	}

	public void setAboutToSwitchAway() {
		aboutToSwitchAway = true;
	}

	public void setAboutToSwitch(PartyPokemon p) {
		if (p.isHome()) {
			setAboutToSwitchHome();
		} else
			setAboutToSwitchAway();
	}

	public void animateFaint(PartyPokemon p) {
		if (p.isHome()) {
			animateHomeFaint();
		} else
			animateAwayFaint();
	}

	public void animateHomeFaint() {
		homeFaintPixel = 0;
		isAnimatingHomeFaint = true;
	}

	public void animateAwayFaint() {
		awayFaintPixel = 0;
		isAnimatingAwayFaint = true;
	}

	public void animateSwitchOut(PartyPokemon p) {
		if (p.isHome()) {
			animateHomeSwitchOut();
		} else
			animateAwaySwitchOut();
	}

	public void animateHomeSwitchOut() {
		isAnimatingHomeSwitchOut = true;
		framesHomePokeballStayedOnOut = 0;
		isAnimatingHomePokemonSwitchOutResize = false;
		homePokemonSwitchOutResizePercent = 1;
	}

	public void animateAwaySwitchOut() {
		isAnimatingAwaySwitchOut = true;
		framesAwayPokeballStayedOnOut = 0;
		isAnimatingAwayPokemonSwitchOutResize = false;
		awayPokemonSwitchOutResizePercent = 1;
	}

	public void animateStatIncrease(PartyPokemon p) {
		if (p.isHome())
			animateHomeStatIncrease();
		else
			animateAwayStatIncrease();
		while(isAnimatingStat()){
			System.out.print("");
		}
	}

	public void animateStatDecrease(PartyPokemon p) {
		if (p.isHome())
			animateHomeStatDecrease();
		else
			animateAwayStatDecrease();
		while(isAnimatingStat()){
			System.out.print("");
		}
	}

	public void animateHomeStatIncrease() {
		homeStatChange = 0;
		isAnimatingHomeStatIncrease = true;
	}

	public void animateHomeStatDecrease() {
		homeStatChange = 0;
		isAnimatingHomeStatDecrease = true;
	}

	public void animateAwayStatIncrease() {
		awayStatChange = 0;
		isAnimatingAwayStatIncrease = true;
	}

	public void animateAwayStatDecrease() {
		awayStatChange = 0;
		isAnimatingAwayStatDecrease = true;
	}

	/**
	 * @return the disclaimerFrame
	 */
	public JFrame getDisclaimerFrame() {
		return disclaimerFrame;
	}

	/**
	 * @param disclaimerFrame
	 *            the disclaimerFrame to set
	 */
	public void setDisclaimerFrame(JFrame disclaimerFrame) {
		this.disclaimerFrame = disclaimerFrame;
	}

	/**
	 * @return the backgroundImage
	 */
	public BufferedImage getBackgroundImage() {
		return backgroundImage;
	}

	/**
	 * @param backgroundImage
	 *            the backgroundImage to set
	 */
	public void setBackgroundImage(BufferedImage backgroundImage) {
		this.backgroundImage = backgroundImage;
	}

	/**
	 * @return the homeBase
	 */
	public BufferedImage getHomeBase() {
		return homeBase;
	}

	/**
	 * @param homeBase
	 *            the homeBase to set
	 */
	public void setHomeBase(BufferedImage homeBase) {
		this.homeBase = homeBase;
	}

	/**
	 * @return the awayBase
	 */
	public BufferedImage getAwayBase() {
		return awayBase;
	}

	/**
	 * @param awayBase
	 *            the awayBase to set
	 */
	public void setAwayBase(BufferedImage awayBase) {
		this.awayBase = awayBase;
	}

	/**
	 * @return the maleSymbol
	 */
	public BufferedImage getMaleSymbol() {
		return maleSymbol;
	}

	/**
	 * @param maleSymbol
	 *            the maleSymbol to set
	 */
	public void setMaleSymbol(BufferedImage maleSymbol) {
		this.maleSymbol = maleSymbol;
	}

	/**
	 * @return the femaleSymbol
	 */
	public BufferedImage getFemaleSymbol() {
		return femaleSymbol;
	}

	/**
	 * @param femaleSymbol
	 *            the femaleSymbol to set
	 */
	public void setFemaleSymbol(BufferedImage femaleSymbol) {
		this.femaleSymbol = femaleSymbol;
	}

	/**
	 * @return the homePokemonBaseX
	 */
	public int getHomePokemonBaseX() {
		return homePokemonBaseX;
	}

	/**
	 * @param homePokemonBaseX
	 *            the homePokemonBaseX to set
	 */
	public void setHomePokemonBaseX(int homePokemonBaseX) {
		this.homePokemonBaseX = homePokemonBaseX;
	}

	/**
	 * @return the homePokemonBaseY
	 */
	public int getHomePokemonBaseY() {
		return homePokemonBaseY;
	}

	/**
	 * @param homePokemonBaseY
	 *            the homePokemonBaseY to set
	 */
	public void setHomePokemonBaseY(int homePokemonBaseY) {
		this.homePokemonBaseY = homePokemonBaseY;
	}

	/**
	 * @return the awayPokemonBaseX
	 */
	public int getAwayPokemonBaseX() {
		return awayPokemonBaseX;
	}

	/**
	 * @param awayPokemonBaseX
	 *            the awayPokemonBaseX to set
	 */
	public void setAwayPokemonBaseX(int awayPokemonBaseX) {
		this.awayPokemonBaseX = awayPokemonBaseX;
	}

	/**
	 * @return the awayPokemonBaseY
	 */
	public int getAwayPokemonBaseY() {
		return awayPokemonBaseY;
	}

	/**
	 * @param awayPokemonBaseY
	 *            the awayPokemonBaseY to set
	 */
	public void setAwayPokemonBaseY(int awayPokemonBaseY) {
		this.awayPokemonBaseY = awayPokemonBaseY;
	}

	/**
	 * @return the homeBaseX
	 */
	public int getHomeBaseX() {
		return homeBaseX;
	}

	/**
	 * @param homeBaseX
	 *            the homeBaseX to set
	 */
	public void setHomeBaseX(int homeBaseX) {
		this.homeBaseX = homeBaseX;
	}

	/**
	 * @return the homeBaseY
	 */
	public int getHomeBaseY() {
		return homeBaseY;
	}

	/**
	 * @param homeBaseY
	 *            the homeBaseY to set
	 */
	public void setHomeBaseY(int homeBaseY) {
		this.homeBaseY = homeBaseY;
	}

	/**
	 * @return the awayBaseX
	 */
	public int getAwayBaseX() {
		return awayBaseX;
	}

	/**
	 * @param awayBaseX
	 *            the awayBaseX to set
	 */
	public void setAwayBaseX(int awayBaseX) {
		this.awayBaseX = awayBaseX;
	}

	/**
	 * @return the awayBaseY
	 */
	public int getAwayBaseY() {
		return awayBaseY;
	}

	/**
	 * @param awayBaseY
	 *            the awayBaseY to set
	 */
	public void setAwayBaseY(int awayBaseY) {
		this.awayBaseY = awayBaseY;
	}

	/**
	 * @return the controlsPanel
	 */
	public PokeBGPanel getControlsPanel() {
		return controlsPanel;
	}

	/**
	 * @param controlsPanel
	 *            the controlsPanel to set
	 */
	public void setControlsPanel(PokeBGPanel controlsPanel) {
		this.controlsPanel = controlsPanel;
	}

	/**
	 * @return the moveButtons
	 */
	public MoveButton[] getMoveButtons() {
		return moveButtons;
	}

	/**
	 * @param moveButtons
	 *            the moveButtons to set
	 */
	public void setMoveButtons(MoveButton[] moveButtons) {
		this.moveButtons = moveButtons;
	}

	/**
	 * @return the switchToPartyButton
	 */
	public SwitchButton getSwitchToPartyButton() {
		return switchToPartyButton;
	}

	/**
	 * @param switchToPartyButton
	 *            the switchToPartyButton to set
	 */
	public void setSwitchToPartyButton(SwitchButton switchToPartyButton) {
		this.switchToPartyButton = switchToPartyButton;
	}

	/**
	 * @return the cancelPartyButton
	 */
	public JButton getCancelPartyButton() {
		return cancelPartyButton;
	}

	/**
	 * @param cancelPartyButton
	 *            the cancelPartyButton to set
	 */
	public void setCancelPartyButton(JButton cancelPartyButton) {
		this.cancelPartyButton = cancelPartyButton;
	}

	/**
	 * @return the switchWidth
	 */
	public int getSwitchWidth() {
		return switchWidth;
	}

	/**
	 * @param switchWidth
	 *            the switchWidth to set
	 */
	public void setSwitchWidth(int switchWidth) {
		this.switchWidth = switchWidth;
	}

	/**
	 * @return the switchHeight
	 */
	public int getSwitchHeight() {
		return switchHeight;
	}

	/**
	 * @param switchHeight
	 *            the switchHeight to set
	 */
	public void setSwitchHeight(int switchHeight) {
		this.switchHeight = switchHeight;
	}

	/**
	 * @return the partyButtons
	 */
	public PartyButton[] getPartyButtons() {
		return partyButtons;
	}

	/**
	 * @param partyButtons
	 *            the partyButtons to set
	 */
	public void setPartyButtons(PartyButton[] partyButtons) {
		this.partyButtons = partyButtons;
	}

	/**
	 * @return the homeFrame
	 */
	public int getHomeFrame() {
		return (int) homeFrame;
	}

	/**
	 * @param homeFrame
	 *            the homeFrame to set
	 */
	public void setHomeFrame(int homeFrame) {
		this.homeFrame = homeFrame;
	}

	/**
	 * @return the awayFrame
	 */
	public int getAwayFrame() {
		return (int)awayFrame;
	}

	/**
	 * @param awayFrame
	 *            the awayFrame to set
	 */
	public void setAwayFrame(int awayFrame) {
		this.awayFrame = awayFrame;
	}

	/**
	 * @return the textAreaHeight
	 */
	public int getTextAreaHeight() {
		return textAreaHeight;
	}

	/**
	 * @param textAreaHeight
	 *            the textAreaHeight to set
	 */
	public void setTextAreaHeight(int textAreaHeight) {
		this.textAreaHeight = textAreaHeight;
	}

	/**
	 * @return the frame
	 */
	public JFrame getFrame() {
		return frame;
	}

	/**
	 * @param frame
	 *            the frame to set
	 */
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	/**
	 * @return the controlsFrameWidth
	 */
	public int getControlsFrameWidth() {
		return controlsFrameWidth;
	}

	/**
	 * @param controlsFrameWidth
	 *            the controlsFrameWidth to set
	 */
	public void setControlsFrameWidth(int controlsFrameWidth) {
		this.controlsFrameWidth = controlsFrameWidth;
	}

	/**
	 * @return the controlsFrameHeight
	 */
	public int getControlsFrameHeight() {
		return controlsFrameHeight;
	}

	/**
	 * @param controlsFrameHeight
	 *            the controlsFrameHeight to set
	 */
	public void setControlsFrameHeight(int controlsFrameHeight) {
		this.controlsFrameHeight = controlsFrameHeight;
	}

	/**
	 * @return the controlsFrame
	 */
	public JFrame getControlsFrame() {
		return controlsFrame;
	}

	/**
	 * @param controlsFrame
	 *            the controlsFrame to set
	 */
	public void setControlsFrame(JFrame controlsFrame) {
		this.controlsFrame = controlsFrame;
	}

	/**
	 * @return the movesHorizontalGap
	 */
	public int getMovesHorizontalGap() {
		return movesHorizontalGap;
	}

	/**
	 * @param movesHorizontalGap
	 *            the movesHorizontalGap to set
	 */
	public void setMovesHorizontalGap(int movesHorizontalGap) {
		this.movesHorizontalGap = movesHorizontalGap;
	}

	/**
	 * @return the movesVerticalGap
	 */
	public int getMovesVerticalGap() {
		return movesVerticalGap;
	}

	/**
	 * @param movesVerticalGap
	 *            the movesVerticalGap to set
	 */
	public void setMovesVerticalGap(int movesVerticalGap) {
		this.movesVerticalGap = movesVerticalGap;
	}

	/**
	 * @return the moveButtonWidth
	 */
	public int getMoveButtonWidth() {
		return moveButtonWidth;
	}

	/**
	 * @param moveButtonWidth
	 *            the moveButtonWidth to set
	 */
	public void setMoveButtonWidth(int moveButtonWidth) {
		this.moveButtonWidth = moveButtonWidth;
	}

	/**
	 * @return the moveButtonHeight
	 */
	public int getMoveButtonHeight() {
		return moveButtonHeight;
	}

	/**
	 * @param moveButtonHeight
	 *            the moveButtonHeight to set
	 */
	public void setMoveButtonHeight(int moveButtonHeight) {
		this.moveButtonHeight = moveButtonHeight;
	}

	/**
	 * @return the textArea
	 */
	public JTextArea getTextArea() {
		return textArea;
	}

	/**
	 * @param textArea
	 *            the textArea to set
	 */
	public void setTextArea(JTextArea textArea) {
		this.textArea = textArea;
	}

	/**
	 * @return the imageGetter
	 */
	public ImageGetter getImageGetter() {
		return imageGetter;
	}

	/**
	 * @param imageGetter
	 *            the imageGetter to set
	 */
	public void setImageGetter(ImageGetter imageGetter) {
		this.imageGetter = imageGetter;
	}

	/**
	 * @return the pokeballClosed
	 */
	public BufferedImage getPokeballClosed() {
		return pokeballClosed;
	}

	/**
	 * @param pokeballClosed
	 *            the pokeballClosed to set
	 */
	public void setPokeballClosed(BufferedImage pokeballClosed) {
		this.pokeballClosed = pokeballClosed;
	}

	/**
	 * @return the pokeballOpened
	 */
	public BufferedImage getPokeballOpened() {
		return pokeballOpened;
	}

	/**
	 * @param pokeballOpened
	 *            the pokeballOpened to set
	 */
	public void setPokeballOpened(BufferedImage pokeballOpened) {
		this.pokeballOpened = pokeballOpened;
	}

	/**
	 * @return the healImage
	 */
	public BufferedImage getHealImage() {
		return healImage;
	}

	/**
	 * @param healImage
	 *            the healImage to set
	 */
	public void setHealImage(BufferedImage healImage) {
		this.healImage = healImage;
	}

	/**
	 * @return the increaseImage
	 */
	public BufferedImage getIncreaseImage() {
		return increaseImage;
	}

	/**
	 * @param increaseImage
	 *            the increaseImage to set
	 */
	public void setIncreaseImage(BufferedImage increaseImage) {
		this.increaseImage = increaseImage;
	}

	/**
	 * @return the decreaseImage
	 */
	public BufferedImage getDecreaseImage() {
		return decreaseImage;
	}

	/**
	 * @param decreaseImage
	 *            the decreaseImage to set
	 */
	public void setDecreaseImage(BufferedImage decreaseImage) {
		this.decreaseImage = decreaseImage;
	}

	/**
	 * @return the caret
	 */
	public DefaultCaret getCaret() {
		return caret;
	}

	/**
	 * @param caret
	 *            the caret to set
	 */
	public void setCaret(DefaultCaret caret) {
		this.caret = caret;
	}

	/**
	 * @return the incrementFrameWidth
	 */
	public double getIncrementFrameWidth() {
		return incrementFrameWidth;
	}

	/**
	 * @param incrementFrameWidth
	 *            the incrementFrameWidth to set
	 */
	public void setIncrementFrameWidth(double incrementFrameWidth) {
		this.incrementFrameWidth = incrementFrameWidth;
	}

	/**
	 * @return the incrementFrameHeight
	 */
	public double getIncrementFrameHeight() {
		return incrementFrameHeight;
	}

	/**
	 * @param incrementFrameHeight
	 *            the incrementFrameHeight to set
	 */
	public void setIncrementFrameHeight(double incrementFrameHeight) {
		this.incrementFrameHeight = incrementFrameHeight;
	}

	/**
	 * @return the incrementXLocale
	 */
	public double getIncrementXLocale() {
		return incrementXLocale;
	}

	/**
	 * @param incrementXLocale
	 *            the incrementXLocale to set
	 */
	public void setIncrementXLocale(double incrementXLocale) {
		this.incrementXLocale = incrementXLocale;
	}

	/**
	 * @return the incrementYLocale
	 */
	public double getIncrementYLocale() {
		return incrementYLocale;
	}

	/**
	 * @param incrementYLocale
	 *            the incrementYLocale to set
	 */
	public void setIncrementYLocale(double incrementYLocale) {
		this.incrementYLocale = incrementYLocale;
	}

	/**
	 * @return the frameRate
	 */
	public int getFrameRate() {
		return frameRate;
	}

	/**
	 * @param frameRate
	 *            the frameRate to set
	 */
	public void setFrameRate(int frameRate) {
		this.frameRate = frameRate;
	}

	/**
	 * @return the isFrameFull
	 */
	public boolean isFrameFull() {
		return isFrameFull;
	}

	/**
	 * @param isFrameFull
	 *            the isFrameFull to set
	 */
	public void setFrameFull(boolean isFrameFull) {
		this.isFrameFull = isFrameFull;
	}

	/**
	 * @return the isFrameInLocation
	 */
	public boolean isFrameInLocation() {
		return isFrameInLocation;
	}

	/**
	 * @param isFrameInLocation
	 *            the isFrameInLocation to set
	 */
	public void setFrameInLocation(boolean isFrameInLocation) {
		this.isFrameInLocation = isFrameInLocation;
	}

	/**
	 * @return the pokemonInfoColor
	 */
	public Color getPokemonInfoColor() {
		return pokemonInfoColor;
	}

	/**
	 * @param pokemonInfoColor
	 *            the pokemonInfoColor to set
	 */
	public void setPokemonInfoColor(Color pokemonInfoColor) {
		this.pokemonInfoColor = pokemonInfoColor;
	}

	/**
	 * @return the hpBarColorGreen
	 */
	public Color getHpBarColorGreen() {
		return hpBarColorGreen;
	}

	/**
	 * @param hpBarColorGreen
	 *            the hpBarColorGreen to set
	 */
	public void setHpBarColorGreen(Color hpBarColorGreen) {
		this.hpBarColorGreen = hpBarColorGreen;
	}

	/**
	 * @return the hpBarColorYellow
	 */
	public Color getHpBarColorYellow() {
		return hpBarColorYellow;
	}

	/**
	 * @param hpBarColorYellow
	 *            the hpBarColorYellow to set
	 */
	public void setHpBarColorYellow(Color hpBarColorYellow) {
		this.hpBarColorYellow = hpBarColorYellow;
	}

	/**
	 * @return the hpBarColorRed
	 */
	public Color getHpBarColorRed() {
		return hpBarColorRed;
	}

	/**
	 * @param hpBarColorRed
	 *            the hpBarColorRed to set
	 */
	public void setHpBarColorRed(Color hpBarColorRed) {
		this.hpBarColorRed = hpBarColorRed;
	}

	/**
	 * @return the visibleHomeHP
	 */
	public double getVisibleHomeHP() {
		return visibleHomeHP;
	}

	/**
	 * @param visibleHomeHP
	 *            the visibleHomeHP to set
	 */
	public void setVisibleHomeHP(double visibleHomeHP) {
		this.visibleHomeHP = visibleHomeHP;
	}

	/**
	 * @return the visibleAwayHP
	 */
	public double getVisibleAwayHP() {
		return visibleAwayHP;
	}

	/**
	 * @param visibleAwayHP
	 *            the visibleAwayHP to set
	 */
	public void setVisibleAwayHP(double visibleAwayHP) {
		this.visibleAwayHP = visibleAwayHP;
	}

	/**
	 * @return the isAnimatingHomeHP
	 */
	public boolean isAnimatingHomeHP() {
		return isAnimatingHomeHP;
	}

	/**
	 * @param isAnimatingHomeHP
	 *            the isAnimatingHomeHP to set
	 */
	public void setAnimatingHomeHP(boolean isAnimatingHomeHP) {
		this.isAnimatingHomeHP = isAnimatingHomeHP;
	}

	/**
	 * @return the isAnimatingAwayHP
	 */
	public boolean isAnimatingAwayHP() {
		return isAnimatingAwayHP;
	}

	/**
	 * @param isAnimatingAwayHP
	 *            the isAnimatingAwayHP to set
	 */
	public void setAnimatingAwayHP(boolean isAnimatingAwayHP) {
		this.isAnimatingAwayHP = isAnimatingAwayHP;
	}

	/**
	 * @return the attackProgress
	 */
	public double getAttackProgress() {
		return attackProgress;
	}

	/**
	 * @param attackProgress
	 *            the attackProgress to set
	 */
	public void setAttackProgress(double attackProgress) {
		this.attackProgress = attackProgress;
	}

	/**
	 * @return the disclaimerFrameWidth
	 */
	public int getDisclaimerFrameWidth() {
		return disclaimerFrameWidth;
	}

	/**
	 * @param disclaimerFrameWidth
	 *            the disclaimerFrameWidth to set
	 */
	public void setDisclaimerFrameWidth(int disclaimerFrameWidth) {
		this.disclaimerFrameWidth = disclaimerFrameWidth;
	}

	/**
	 * @return the disclaimerFrameHeight
	 */
	public int getDisclaimerFrameHeight() {
		return disclaimerFrameHeight;
	}

	/**
	 * @param disclaimerFrameHeight
	 *            the disclaimerFrameHeight to set
	 */
	public void setDisclaimerFrameHeight(int disclaimerFrameHeight) {
		this.disclaimerFrameHeight = disclaimerFrameHeight;
	}

	/**
	 * @return the flowLayout
	 */
	public FlowLayout getFlowLayout() {
		return flowLayout;
	}

	/**
	 * @param flowLayout
	 *            the flowLayout to set
	 */
	public void setFlowLayout(FlowLayout flowLayout) {
		this.flowLayout = flowLayout;
	}

	/**
	 * @return the fireredFont
	 */
	public Font getFireredFont() {
		return fireredFont;
	}

	/**
	 * @param fireredFont
	 *            the fireredFont to set
	 */
	public void setFireredFont(Font fireredFont) {
		this.fireredFont = fireredFont;
	}

	/**
	 * @return the bgPartyButtonColor
	 */
	public Color getBgPartyButtonColor() {
		return bgPartyButtonColor;
	}

	/**
	 * @param bgPartyButtonColor
	 *            the bgPartyButtonColor to set
	 */
	public void setBgPartyButtonColor(Color bgPartyButtonColor) {
		this.bgPartyButtonColor = bgPartyButtonColor;
	}

	/**
	 * @return the bgPartyButtonSelectColor
	 */
	public Color getBgPartyButtonSelectColor() {
		return bgPartyButtonSelectColor;
	}

	/**
	 * @param bgPartyButtonSelectColor
	 *            the bgPartyButtonSelectColor to set
	 */
	public void setBgPartyButtonSelectColor(Color bgPartyButtonSelectColor) {
		this.bgPartyButtonSelectColor = bgPartyButtonSelectColor;
	}

	/**
	 * @return the bgPartyButtonFaintColor
	 */
	public Color getBgPartyButtonFaintColor() {
		return bgPartyButtonFaintColor;
	}

	/**
	 * @param bgPartyButtonFaintColor
	 *            the bgPartyButtonFaintColor to set
	 */
	public void setBgPartyButtonFaintColor(Color bgPartyButtonFaintColor) {
		this.bgPartyButtonFaintColor = bgPartyButtonFaintColor;
	}

	/**
	 * @return the bgPartyButtonFaintSelectColor
	 */
	public Color getBgPartyButtonFaintSelectColor() {
		return bgPartyButtonFaintSelectColor;
	}

	/**
	 * @param bgPartyButtonFaintSelectColor
	 *            the bgPartyButtonFaintSelectColor to set
	 */
	public void setBgPartyButtonFaintSelectColor(
			Color bgPartyButtonFaintSelectColor) {
		this.bgPartyButtonFaintSelectColor = bgPartyButtonFaintSelectColor;
	}

	/**
	 * @return the partyButtonWidth
	 */
	public int getPartyButtonWidth() {
		return partyButtonWidth;
	}

	/**
	 * @param partyButtonWidth
	 *            the partyButtonWidth to set
	 */
	public void setPartyButtonWidth(int partyButtonWidth) {
		this.partyButtonWidth = partyButtonWidth;
	}

	/**
	 * @return the partyButtonHeight
	 */
	public int getPartyButtonHeight() {
		return partyButtonHeight;
	}

	/**
	 * @param partyButtonHeight
	 *            the partyButtonHeight to set
	 */
	public void setPartyButtonHeight(int partyButtonHeight) {
		this.partyButtonHeight = partyButtonHeight;
	}

	/**
	 * @return the partyButtonPolygon
	 */
	public Polygon getPartyButtonPolygon() {
		return partyButtonPolygon;
	}

	/**
	 * @param partyButtonPolygon
	 *            the partyButtonPolygon to set
	 */
	public void setPartyButtonPolygon(Polygon partyButtonPolygon) {
		this.partyButtonPolygon = partyButtonPolygon;
	}

	/**
	 * @return the textAreaScrollPane
	 */
	public JScrollPane getTextAreaScrollPane() {
		return textAreaScrollPane;
	}

	/**
	 * @param textAreaScrollPane
	 *            the textAreaScrollPane to set
	 */
	public void setTextAreaScrollPane(JScrollPane textAreaScrollPane) {
		this.textAreaScrollPane = textAreaScrollPane;
	}

	/**
	 * @return the partyHGap
	 */
	public int getPartyHGap() {
		return partyHGap;
	}

	/**
	 * @param partyHGap
	 *            the partyHGap to set
	 */
	public void setPartyHGap(int partyHGap) {
		this.partyHGap = partyHGap;
	}

	/**
	 * @return the partyVGap
	 */
	public int getPartyVGap() {
		return partyVGap;
	}

	/**
	 * @param partyVGap
	 *            the partyVGap to set
	 */
	public void setPartyVGap(int partyVGap) {
		this.partyVGap = partyVGap;
	}

	/**
	 * @return the timeGap
	 */
	public int getTimeGap() {
		return timeGap;
	}

	/**
	 * @param timeGap
	 *            the timeGap to set
	 */
	public void setTimeGap(int timeGap) {
		this.timeGap = timeGap;
	}

	/**
	 * @return the awayInfoX
	 */
	public int getAwayInfoX() {
		return awayInfoX;
	}

	/**
	 * @param awayInfoX
	 *            the awayInfoX to set
	 */
	public void setAwayInfoX(int awayInfoX) {
		this.awayInfoX = awayInfoX;
	}

	/**
	 * @return the awayInfoY
	 */
	public int getAwayInfoY() {
		return awayInfoY;
	}

	/**
	 * @param awayInfoY
	 *            the awayInfoY to set
	 */
	public void setAwayInfoY(int awayInfoY) {
		this.awayInfoY = awayInfoY;
	}

	/**
	 * @return the awayInfoWidth
	 */
	public int getAwayInfoWidth() {
		return awayInfoWidth;
	}

	/**
	 * @param awayInfoWidth
	 *            the awayInfoWidth to set
	 */
	public void setAwayInfoWidth(int awayInfoWidth) {
		this.awayInfoWidth = awayInfoWidth;
	}

	/**
	 * @return the awayInfoHeight
	 */
	public int getAwayInfoHeight() {
		return awayInfoHeight;
	}

	/**
	 * @param awayInfoHeight
	 *            the awayInfoHeight to set
	 */
	public void setAwayInfoHeight(int awayInfoHeight) {
		this.awayInfoHeight = awayInfoHeight;
	}

	/**
	 * @return the homeInfoX
	 */
	public int getHomeInfoX() {
		return homeInfoX;
	}

	/**
	 * @param homeInfoX
	 *            the homeInfoX to set
	 */
	public void setHomeInfoX(int homeInfoX) {
		this.homeInfoX = homeInfoX;
	}

	/**
	 * @return the homeInfoY
	 */
	public int getHomeInfoY() {
		return homeInfoY;
	}

	/**
	 * @param homeInfoY
	 *            the homeInfoY to set
	 */
	public void setHomeInfoY(int homeInfoY) {
		this.homeInfoY = homeInfoY;
	}

	/**
	 * @return the homeInfoWidth
	 */
	public int getHomeInfoWidth() {
		return homeInfoWidth;
	}

	/**
	 * @param homeInfoWidth
	 *            the homeInfoWidth to set
	 */
	public void setHomeInfoWidth(int homeInfoWidth) {
		this.homeInfoWidth = homeInfoWidth;
	}

	/**
	 * @return the homeInfoHeight
	 */
	public int getHomeInfoHeight() {
		return homeInfoHeight;
	}

	/**
	 * @param homeInfoHeight
	 *            the homeInfoHeight to set
	 */
	public void setHomeInfoHeight(int homeInfoHeight) {
		this.homeInfoHeight = homeInfoHeight;
	}

	/**
	 * @return the infoArc
	 */
	public int getInfoArc() {
		return infoArc;
	}

	/**
	 * @param infoArc
	 *            the infoArc to set
	 */
	public void setInfoArc(int infoArc) {
		this.infoArc = infoArc;
	}

	/**
	 * @return the stroke
	 */
	public BasicStroke getStroke() {
		return stroke;
	}

	/**
	 * @param stroke
	 *            the stroke to set
	 */
	public void setStroke(BasicStroke stroke) {
		this.stroke = stroke;
	}

	/**
	 * @return the homeNameBufferHeight
	 */
	public int getHomeNameBufferHeight() {
		return homeNameBufferHeight;
	}

	/**
	 * @param homeNameBufferHeight
	 *            the homeNameBufferHeight to set
	 */
	public void setHomeNameBufferHeight(int homeNameBufferHeight) {
		this.homeNameBufferHeight = homeNameBufferHeight;
	}

	/**
	 * @return the nameBufferWidth
	 */
	public int getNameBufferWidth() {
		return nameBufferWidth;
	}

	/**
	 * @param nameBufferWidth
	 *            the nameBufferWidth to set
	 */
	public void setNameBufferWidth(int nameBufferWidth) {
		this.nameBufferWidth = nameBufferWidth;
	}

	/**
	 * @return the homeNameBaseX
	 */
	public int getHomeNameBaseX() {
		return homeNameBaseX;
	}

	/**
	 * @param homeNameBaseX
	 *            the homeNameBaseX to set
	 */
	public void setHomeNameBaseX(int homeNameBaseX) {
		this.homeNameBaseX = homeNameBaseX;
	}

	/**
	 * @return the homeLvlWestBuffer
	 */
	public int getHomeLvlWestBuffer() {
		return homeLvlEastBuffer;
	}

	/**
	 * @param homeLvlWestBuffer
	 *            the homeLvlWestBuffer to set
	 */
	public void setHomeLvlWestBuffer(int homeLvlWestBuffer) {
		this.homeLvlEastBuffer = homeLvlWestBuffer;
	}

	/**
	 * @return the homeLvlBoundaryWestX
	 */
	public int getHomeLvlBoundaryWestX() {
		return homeLvlBoundaryEastX;
	}

	/**
	 * @param homeLvlBoundaryWestX
	 *            the homeLvlBoundaryWestX to set
	 */
	public void setHomeLvlBoundaryWestX(int homeLvlBoundaryWestX) {
		this.homeLvlBoundaryEastX = homeLvlBoundaryWestX;
	}

	/**
	 * @return the maleSymbolWidth
	 */
	public int getMaleSymbolWidth() {
		return maleSymbolWidth;
	}

	/**
	 * @param maleSymbolWidth
	 *            the maleSymbolWidth to set
	 */
	public void setMaleSymbolWidth(int maleSymbolWidth) {
		this.maleSymbolWidth = maleSymbolWidth;
	}

	/**
	 * @return the maleSymbolHeight
	 */
	public int getMaleSymbolHeight() {
		return maleSymbolHeight;
	}

	/**
	 * @param maleSymbolHeight
	 *            the maleSymbolHeight to set
	 */
	public void setMaleSymbolHeight(int maleSymbolHeight) {
		this.maleSymbolHeight = maleSymbolHeight;
	}

	/**
	 * @return the symbolWidthBuffer
	 */
	public int getSymbolWidthBuffer() {
		return symbolWidthBuffer;
	}

	/**
	 * @param symbolWidthBuffer
	 *            the symbolWidthBuffer to set
	 */
	public void setSymbolWidthBuffer(int symbolWidthBuffer) {
		this.symbolWidthBuffer = symbolWidthBuffer;
	}

	/**
	 * @return the femaleSymbolWidth
	 */
	public int getFemaleSymbolWidth() {
		return femaleSymbolWidth;
	}

	/**
	 * @param femaleSymbolWidth
	 *            the femaleSymbolWidth to set
	 */
	public void setFemaleSymbolWidth(int femaleSymbolWidth) {
		this.femaleSymbolWidth = femaleSymbolWidth;
	}

	/**
	 * @return the femaleSymbolHeight
	 */
	public int getFemaleSymbolHeight() {
		return femaleSymbolHeight;
	}

	/**
	 * @param femaleSymbolHeight
	 *            the femaleSymbolHeight to set
	 */
	public void setFemaleSymbolHeight(int femaleSymbolHeight) {
		this.femaleSymbolHeight = femaleSymbolHeight;
	}

	/**
	 * @return the hpString
	 */
	public String getHpString() {
		return hpString;
	}

	/**
	 * @param hpString
	 *            the hpString to set
	 */
	public void setHpString(String hpString) {
		this.hpString = hpString;
	}

	/**
	 * @return the hpHeightBuffer
	 */
	public int getHpHeightBuffer() {
		return hpHeightBuffer;
	}

	/**
	 * @param hpHeightBuffer
	 *            the hpHeightBuffer to set
	 */
	public void setHpHeightBuffer(int hpHeightBuffer) {
		this.hpHeightBuffer = hpHeightBuffer;
	}

	/**
	 * @return the hpWidthBuffer
	 */
	public int getHpWidthBuffer() {
		return hpWidthBuffer;
	}

	/**
	 * @param hpWidthBuffer
	 *            the hpWidthBuffer to set
	 */
	public void setHpWidthBuffer(int hpWidthBuffer) {
		this.hpWidthBuffer = hpWidthBuffer;
	}

	/**
	 * @return the hpTextBuffer
	 */
	public int getHpTextBuffer() {
		return hpTextBuffer;
	}

	/**
	 * @param hpTextBuffer
	 *            the hpTextBuffer to set
	 */
	public void setHpTextBuffer(int hpTextBuffer) {
		this.hpTextBuffer = hpTextBuffer;
	}

	/**
	 * @return the hpBarTotalWidth
	 */
	public int getHpBarTotalWidth() {
		return hpBarTotalWidth;
	}

	/**
	 * @param hpBarTotalWidth
	 *            the hpBarTotalWidth to set
	 */
	public void setHpBarTotalWidth(int hpBarTotalWidth) {
		this.hpBarTotalWidth = hpBarTotalWidth;
	}

	/**
	 * @return the hpBarHeight
	 */
	public int getHpBarHeight() {
		return hpBarHeight;
	}

	/**
	 * @param hpBarHeight
	 *            the hpBarHeight to set
	 */
	public void setHpBarHeight(int hpBarHeight) {
		this.hpBarHeight = hpBarHeight;
	}

	/**
	 * @return the hpBarBackHeight
	 */
	public int getHpBarBackHeight() {
		return hpBarBackHeight;
	}

	/**
	 * @param hpBarBackHeight
	 *            the hpBarBackHeight to set
	 */
	public void setHpBarBackHeight(int hpBarBackHeight) {
		this.hpBarBackHeight = hpBarBackHeight;
	}

	/**
	 * @return the hpBarBackDistanceFromEdge
	 */
	public int getHpBarBackDistanceFromEdge() {
		return hpBarBackDistanceFromEdge;
	}

	/**
	 * @param hpBarBackDistanceFromEdge
	 *            the hpBarBackDistanceFromEdge to set
	 */
	public void setHpBarBackDistanceFromEdge(int hpBarBackDistanceFromEdge) {
		this.hpBarBackDistanceFromEdge = hpBarBackDistanceFromEdge;
	}

	/**
	 * @return the hpBarBackDistanceFromName
	 */
	public int getHpBarBackDistanceFromName() {
		return hpBarBackDistanceFromName;
	}

	/**
	 * @param hpBarBackDistanceFromName
	 *            the hpBarBackDistanceFromName to set
	 */
	public void setHpBarBackDistanceFromName(int hpBarBackDistanceFromName) {
		this.hpBarBackDistanceFromName = hpBarBackDistanceFromName;
	}

	/**
	 * @return the hpTextColor
	 */
	public Color getHpTextColor() {
		return hpTextColor;
	}

	/**
	 * @param hpTextColor
	 *            the hpTextColor to set
	 */
	public void setHpTextColor(Color hpTextColor) {
		this.hpTextColor = hpTextColor;
	}

	/**
	 * @return the awayNameBufferHeight
	 */
	public int getAwayNameBufferHeight() {
		return awayNameBufferHeight;
	}

	/**
	 * @param awayNameBufferHeight
	 *            the awayNameBufferHeight to set
	 */
	public void setAwayNameBufferHeight(int awayNameBufferHeight) {
		this.awayNameBufferHeight = awayNameBufferHeight;
	}

	/**
	 * @return the awayNameBaseX
	 */
	public int getAwayNameBaseX() {
		return awayNameBaseX;
	}

	/**
	 * @param awayNameBaseX
	 *            the awayNameBaseX to set
	 */
	public void setAwayNameBaseX(int awayNameBaseX) {
		this.awayNameBaseX = awayNameBaseX;
	}

	/**
	 * @return the repaintRunner
	 */
	public Runnable getRepaintRunner() {
		return repaintRunner;
	}

	/**
	 * @param repaintRunner
	 *            the repaintRunner to set
	 */
	public void setRepaintRunner(Runnable repaintRunner) {
		this.repaintRunner = repaintRunner;
	}

	/**
	 * @return the ballHomeOpenClip
	 */
	public WAVPlayer getBallHomeOpenClip() {
		return ballHomeOpenClip;
	}

	/**
	 * @param ballHomeOpenClip
	 *            the ballHomeOpenClip to set
	 */
	public void setBallHomeOpenClip(WAVPlayer ballHomeOpenClip) {
		this.ballHomeOpenClip = ballHomeOpenClip;
	}

	/**
	 * @return the ballHomeReturnClip
	 */
	public WAVPlayer getBallHomeReturnClip() {
		return ballHomeReturnClip;
	}

	/**
	 * @param ballHomeReturnClip
	 *            the ballHomeReturnClip to set
	 */
	public void setBallHomeReturnClip(WAVPlayer ballHomeReturnClip) {
		this.ballHomeReturnClip = ballHomeReturnClip;
	}

	/**
	 * @return the ballAwayOpenClip
	 */
	public WAVPlayer getBallAwayOpenClip() {
		return ballAwayOpenClip;
	}

	/**
	 * @param ballAwayOpenClip
	 *            the ballAwayOpenClip to set
	 */
	public void setBallAwayOpenClip(WAVPlayer ballAwayOpenClip) {
		this.ballAwayOpenClip = ballAwayOpenClip;
	}

	/**
	 * @return the ballAwayReturnClip
	 */
	public WAVPlayer getBallAwayReturnClip() {
		return ballAwayReturnClip;
	}

	/**
	 * @param ballAwayReturnClip
	 *            the ballAwayReturnClip to set
	 */
	public void setBallAwayReturnClip(WAVPlayer ballAwayReturnClip) {
		this.ballAwayReturnClip = ballAwayReturnClip;
	}

	/**
	 * @return the homePokeballCurve
	 */
	public CubicBezierCurve getHomePokeballCurve() {
		return homePokeballCurve;
	}

	/**
	 * @param homePokeballCurve
	 *            the homePokeballCurve to set
	 */
	public void setHomePokeballCurve(CubicBezierCurve homePokeballCurve) {
		this.homePokeballCurve = homePokeballCurve;
	}

	/**
	 * @return the awayPokeballCurve
	 */
	public CubicBezierCurve getAwayPokeballCurve() {
		return awayPokeballCurve;
	}

	/**
	 * @param awayPokeballCurve
	 *            the awayPokeballCurve to set
	 */
	public void setAwayPokeballCurve(CubicBezierCurve awayPokeballCurve) {
		this.awayPokeballCurve = awayPokeballCurve;
	}

	/**
	 * @return the regainHomeHP
	 */
	public int getRegainHomeHP() {
		return regainHomeHP;
	}

	/**
	 * @param regainHomeHP
	 *            the regainHomeHP to set
	 */
	public void setRegainHomeHP(int regainHomeHP) {
		this.regainHomeHP = regainHomeHP;
	}

	/**
	 * @return the regainAwayHP
	 */
	public int getRegainAwayHP() {
		return regainAwayHP;
	}

	/**
	 * @param regainAwayHP
	 *            the regainAwayHP to set
	 */
	public void setRegainAwayHP(int regainAwayHP) {
		this.regainAwayHP = regainAwayHP;
	}

	/**
	 * @return the homePokeballFrame
	 */
	public double getHomePokeballFrame() {
		return homePokeballFrame;
	}

	/**
	 * @param homePokeballFrame
	 *            the homePokeballFrame to set
	 */
	public void setHomePokeballFrame(double homePokeballFrame) {
		this.homePokeballFrame = homePokeballFrame;
	}

	/**
	 * @return the awayPokeballFrame
	 */
	public double getAwayPokeballFrame() {
		return awayPokeballFrame;
	}

	/**
	 * @param awayPokeballFrame
	 *            the awayPokeballFrame to set
	 */
	public void setAwayPokeballFrame(double awayPokeballFrame) {
		this.awayPokeballFrame = awayPokeballFrame;
	}

	/**
	 * @return the currentWidth
	 */
	public double getCurrentWidth() {
		return currentWidth;
	}

	/**
	 * @param currentWidth
	 *            the currentWidth to set
	 */
	public void setCurrentWidth(int currentWidth) {
		this.currentWidth = currentWidth;
	}

	/**
	 * @return the currentHeight
	 */
	public double getCurrentHeight() {
		return currentHeight;
	}

	/**
	 * @param currentHeight
	 *            the currentHeight to set
	 */
	public void setCurrentHeight(int currentHeight) {
		this.currentHeight = currentHeight;
	}

	/**
	 * @return the currentFrameLocationY
	 */
	public double getCurrentFrameLocationY() {
		return currentFrameLocationY;
	}

	/**
	 * @param currentFrameLocationY
	 *            the currentFrameLocationY to set
	 */
	public void setCurrentFrameLocationY(double currentFrameLocationY) {
		this.currentFrameLocationY = currentFrameLocationY;
	}

	/**
	 * @return the currentFrameLocationX
	 */
	public double getCurrentFrameLocationX() {
		return currentFrameLocationX;
	}

	/**
	 * @param currentFrameLocationX
	 *            the currentFrameLocationX to set
	 */
	public void setCurrentFrameLocationX(double currentFrameLocationX) {
		this.currentFrameLocationX = currentFrameLocationX;
	}

	/**
	 * @return the timeToThrowInPokeball
	 */
	public int getTimeToThrowInPokeball() {
		return timeToThrowInPokeball;
	}

	/**
	 * @param timeToThrowInPokeball
	 *            the timeToThrowInPokeball to set
	 */
	public void setTimeToThrowInPokeball(int timeToThrowInPokeball) {
		this.timeToThrowInPokeball = timeToThrowInPokeball;
	}

	/**
	 * @return the pokeballRotations
	 */
	public int getPokeballRotations() {
		return pokeballRotations;
	}

	/**
	 * @param pokeballRotations
	 *            the pokeballRotations to set
	 */
	public void setPokeballRotations(int pokeballRotations) {
		this.pokeballRotations = pokeballRotations;
	}

	/**
	 * @return the pokemonResizeTime
	 */
	public int getPokemonResizeTime() {
		return pokemonResizeTime;
	}

	/**
	 * @param pokemonResizeTime
	 *            the pokemonResizeTime to set
	 */
	public void setPokemonResizeTime(int pokemonResizeTime) {
		this.pokemonResizeTime = pokemonResizeTime;
	}

	/**
	 * @return the pokemonClient
	 */
	public PokemonClient getPokemonClient() {
		return pokemonClient;
	}

	/**
	 * @param pokemonClient
	 *            the pokemonClient to set
	 */
	public void setPokemonClient(PokemonClient pokemonClient) {
		this.pokemonClient = pokemonClient;
	}

	/**
	 * @return the isAnimatingHomeSwitchIn
	 */
	public boolean isAnimatingHomeSwitchIn() {
		return isAnimatingHomeSwitchIn;
	}

	/**
	 * @param isAnimatingHomeSwitchIn
	 *            the isAnimatingHomeSwitchIn to set
	 */
	public void setAnimatingHomeSwitchIn(boolean isAnimatingHomeSwitchIn) {
		this.isAnimatingHomeSwitchIn = isAnimatingHomeSwitchIn;
	}

	/**
	 * @return the isAnimatingHomeSwitchInPokeball
	 */
	public boolean isAnimatingHomeSwitchInPokeball() {
		return isAnimatingHomeSwitchInPokeball;
	}

	/**
	 * @param isAnimatingHomeSwitchInPokeball
	 *            the isAnimatingHomeSwitchInPokeball to set
	 */
	public void setAnimatingHomeSwitchInPokeball(
			boolean isAnimatingHomeSwitchInPokeball) {
		this.isAnimatingHomeSwitchInPokeball = isAnimatingHomeSwitchInPokeball;
	}

	/**
	 * @return the framesHomePokeballStayed
	 */
	public int getFramesHomePokeballStayed() {
		return framesHomePokeballStayed;
	}

	/**
	 * @param framesHomePokeballStayed
	 *            the framesHomePokeballStayed to set
	 */
	public void setFramesHomePokeballStayed(int framesHomePokeballStayed) {
		this.framesHomePokeballStayed = framesHomePokeballStayed;
	}

	/**
	 * @return the framesHomeOpenPokeballStayed
	 */
	public int getFramesHomeOpenPokeballStayed() {
		return framesHomeOpenPokeballStayed;
	}

	/**
	 * @param framesHomeOpenPokeballStayed
	 *            the framesHomeOpenPokeballStayed to set
	 */
	public void setFramesHomeOpenPokeballStayed(int framesHomeOpenPokeballStayed) {
		this.framesHomeOpenPokeballStayed = framesHomeOpenPokeballStayed;
	}

	/**
	 * @return the isAnimatingHomeOpenPokeball
	 */
	public boolean isAnimatingHomeOpenPokeball() {
		return isAnimatingHomeOpenPokeball;
	}

	/**
	 * @param isAnimatingHomeOpenPokeball
	 *            the isAnimatingHomeOpenPokeball to set
	 */
	public void setAnimatingHomeOpenPokeball(boolean isAnimatingHomeOpenPokeball) {
		this.isAnimatingHomeOpenPokeball = isAnimatingHomeOpenPokeball;
	}

	/**
	 * @return the isAnimatingHomePokemonSwitchInResize
	 */
	public boolean isAnimatingHomePokemonSwitchInResize() {
		return isAnimatingHomePokemonSwitchInResize;
	}

	/**
	 * @param isAnimatingHomePokemonSwitchInResize
	 *            the isAnimatingHomePokemonSwitchInResize to set
	 */
	public void setAnimatingHomePokemonSwitchInResize(
			boolean isAnimatingHomePokemonSwitchInResize) {
		this.isAnimatingHomePokemonSwitchInResize = isAnimatingHomePokemonSwitchInResize;
	}

	/**
	 * @return the homePokemonSwitchInResizePercent
	 */
	public double getHomePokemonSwitchInResizePercent() {
		return homePokemonSwitchInResizePercent;
	}

	/**
	 * @param homePokemonSwitchInResizePercent
	 *            the homePokemonSwitchInResizePercent to set
	 */
	public void setHomePokemonSwitchInResizePercent(
			double homePokemonSwitchInResizePercent) {
		this.homePokemonSwitchInResizePercent = homePokemonSwitchInResizePercent;
	}

	/**
	 * @return the homePokeballRotation
	 */
	public double getHomePokeballRotation() {
		return homePokeballRotation;
	}

	/**
	 * @param homePokeballRotation
	 *            the homePokeballRotation to set
	 */
	public void setHomePokeballRotation(double homePokeballRotation) {
		this.homePokeballRotation = homePokeballRotation;
	}

	/**
	 * @return the aboutToSwitchHome
	 */
	public boolean isAboutToSwitchHome() {
		return aboutToSwitchHome;
	}

	/**
	 * @param aboutToSwitchHome
	 *            the aboutToSwitchHome to set
	 */
	public void setAboutToSwitchHome(boolean aboutToSwitchHome) {
		this.aboutToSwitchHome = aboutToSwitchHome;
	}

	/**
	 * @return the isAnimatingAwaySwitchIn
	 */
	public boolean isAnimatingAwaySwitchIn() {
		return isAnimatingAwaySwitchIn;
	}

	/**
	 * @param isAnimatingAwaySwitchIn
	 *            the isAnimatingAwaySwitchIn to set
	 */
	public void setAnimatingAwaySwitchIn(boolean isAnimatingAwaySwitchIn) {
		this.isAnimatingAwaySwitchIn = isAnimatingAwaySwitchIn;
	}

	/**
	 * @return the isAnimatingAwaySwitchInPokeball
	 */
	public boolean isAnimatingAwaySwitchInPokeball() {
		return isAnimatingAwaySwitchInPokeball;
	}

	/**
	 * @param isAnimatingAwaySwitchInPokeball
	 *            the isAnimatingAwaySwitchInPokeball to set
	 */
	public void setAnimatingAwaySwitchInPokeball(
			boolean isAnimatingAwaySwitchInPokeball) {
		this.isAnimatingAwaySwitchInPokeball = isAnimatingAwaySwitchInPokeball;
	}

	/**
	 * @return the framesAwayPokeballStayed
	 */
	public int getFramesAwayPokeballStayed() {
		return framesAwayPokeballStayed;
	}

	/**
	 * @param framesAwayPokeballStayed
	 *            the framesAwayPokeballStayed to set
	 */
	public void setFramesAwayPokeballStayed(int framesAwayPokeballStayed) {
		this.framesAwayPokeballStayed = framesAwayPokeballStayed;
	}

	/**
	 * @return the framesAwayOpenPokeballStayed
	 */
	public int getFramesAwayOpenPokeballStayed() {
		return framesAwayOpenPokeballStayed;
	}

	/**
	 * @param framesAwayOpenPokeballStayed
	 *            the framesAwayOpenPokeballStayed to set
	 */
	public void setFramesAwayOpenPokeballStayed(int framesAwayOpenPokeballStayed) {
		this.framesAwayOpenPokeballStayed = framesAwayOpenPokeballStayed;
	}

	/**
	 * @return the isAnimatingAwayOpenPokeball
	 */
	public boolean isAnimatingAwayOpenPokeball() {
		return isAnimatingAwayOpenPokeball;
	}

	/**
	 * @param isAnimatingAwayOpenPokeball
	 *            the isAnimatingAwayOpenPokeball to set
	 */
	public void setAnimatingAwayOpenPokeball(boolean isAnimatingAwayOpenPokeball) {
		this.isAnimatingAwayOpenPokeball = isAnimatingAwayOpenPokeball;
	}

	/**
	 * @return the isAnimatingAwayPokemonSwitchInResize
	 */
	public boolean isAnimatingAwayPokemonSwitchInResize() {
		return isAnimatingAwayPokemonSwitchInResize;
	}

	/**
	 * @param isAnimatingAwayPokemonSwitchInResize
	 *            the isAnimatingAwayPokemonSwitchInResize to set
	 */
	public void setAnimatingAwayPokemonSwitchInResize(
			boolean isAnimatingAwayPokemonSwitchInResize) {
		this.isAnimatingAwayPokemonSwitchInResize = isAnimatingAwayPokemonSwitchInResize;
	}

	/**
	 * @return the awayPokemonSwitchInResizePercent
	 */
	public double getAwayPokemonSwitchInResizePercent() {
		return awayPokemonSwitchInResizePercent;
	}

	/**
	 * @param awayPokemonSwitchInResizePercent
	 *            the awayPokemonSwitchInResizePercent to set
	 */
	public void setAwayPokemonSwitchInResizePercent(
			double awayPokemonSwitchInResizePercent) {
		this.awayPokemonSwitchInResizePercent = awayPokemonSwitchInResizePercent;
	}

	/**
	 * @return the awayPokeballRotation
	 */
	public double getAwayPokeballRotation() {
		return awayPokeballRotation;
	}

	/**
	 * @param awayPokeballRotation
	 *            the awayPokeballRotation to set
	 */
	public void setAwayPokeballRotation(double awayPokeballRotation) {
		this.awayPokeballRotation = awayPokeballRotation;
	}

	/**
	 * @return the aboutToSwitchAway
	 */
	public boolean isAboutToSwitchAway() {
		return aboutToSwitchAway;
	}

	/**
	 * @param aboutToSwitchAway
	 *            the aboutToSwitchAway to set
	 */
	public void setAboutToSwitchAway(boolean aboutToSwitchAway) {
		this.aboutToSwitchAway = aboutToSwitchAway;
	}

	/**
	 * @return the isAnimatingHomeFaint
	 */
	public boolean isAnimatingHomeFaint() {
		return isAnimatingHomeFaint;
	}

	/**
	 * @param isAnimatingHomeFaint
	 *            the isAnimatingHomeFaint to set
	 */
	public void setAnimatingHomeFaint(boolean isAnimatingHomeFaint) {
		this.isAnimatingHomeFaint = isAnimatingHomeFaint;
	}

	/**
	 * @return the homeFaintPixel
	 */
	public double getHomeFaintPixel() {
		return homeFaintPixel;
	}

	/**
	 * @param homeFaintPixel
	 *            the homeFaintPixel to set
	 */
	public void setHomeFaintPixel(double homeFaintPixel) {
		this.homeFaintPixel = homeFaintPixel;
	}

	/**
	 * @return the isAnimatingAwayFaint
	 */
	public boolean isAnimatingAwayFaint() {
		return isAnimatingAwayFaint;
	}

	/**
	 * @param isAnimatingAwayFaint
	 *            the isAnimatingAwayFaint to set
	 */
	public void setAnimatingAwayFaint(boolean isAnimatingAwayFaint) {
		this.isAnimatingAwayFaint = isAnimatingAwayFaint;
	}

	/**
	 * @return the awayFaintPixel
	 */
	public double getAwayFaintPixel() {
		return awayFaintPixel;
	}

	/**
	 * @param awayFaintPixel
	 *            the awayFaintPixel to set
	 */
	public void setAwayFaintPixel(double awayFaintPixel) {
		this.awayFaintPixel = awayFaintPixel;
	}

	/**
	 * @return the isAnimatingHomeSwitchOut
	 */
	public boolean isAnimatingHomeSwitchOut() {
		return isAnimatingHomeSwitchOut;
	}

	/**
	 * @param isAnimatingHomeSwitchOut
	 *            the isAnimatingHomeSwitchOut to set
	 */
	public void setAnimatingHomeSwitchOut(boolean isAnimatingHomeSwitchOut) {
		this.isAnimatingHomeSwitchOut = isAnimatingHomeSwitchOut;
	}

	/**
	 * @return the framesHomePokeballStayedOnOut
	 */
	public int getFramesHomePokeballStayedOnOut() {
		return framesHomePokeballStayedOnOut;
	}

	/**
	 * @param framesHomePokeballStayedOnOut
	 *            the framesHomePokeballStayedOnOut to set
	 */
	public void setFramesHomePokeballStayedOnOut(
			int framesHomePokeballStayedOnOut) {
		this.framesHomePokeballStayedOnOut = framesHomePokeballStayedOnOut;
	}

	/**
	 * @return the isAnimatingHomePokemonSwitchOutResize
	 */
	public boolean isAnimatingHomePokemonSwitchOutResize() {
		return isAnimatingHomePokemonSwitchOutResize;
	}

	/**
	 * @param isAnimatingHomePokemonSwitchOutResize
	 *            the isAnimatingHomePokemonSwitchOutResize to set
	 */
	public void setAnimatingHomePokemonSwitchOutResize(
			boolean isAnimatingHomePokemonSwitchOutResize) {
		this.isAnimatingHomePokemonSwitchOutResize = isAnimatingHomePokemonSwitchOutResize;
	}

	/**
	 * @return the homePokemonSwitchOutResizePercent
	 */
	public double getHomePokemonSwitchOutResizePercent() {
		return homePokemonSwitchOutResizePercent;
	}

	/**
	 * @param homePokemonSwitchOutResizePercent
	 *            the homePokemonSwitchOutResizePercent to set
	 */
	public void setHomePokemonSwitchOutResizePercent(
			double homePokemonSwitchOutResizePercent) {
		this.homePokemonSwitchOutResizePercent = homePokemonSwitchOutResizePercent;
	}

	/**
	 * @return the isAnimatingAwaySwitchOut
	 */
	public boolean isAnimatingAwaySwitchOut() {
		return isAnimatingAwaySwitchOut;
	}

	/**
	 * @param isAnimatingAwaySwitchOut
	 *            the isAnimatingAwaySwitchOut to set
	 */
	public void setAnimatingAwaySwitchOut(boolean isAnimatingAwaySwitchOut) {
		this.isAnimatingAwaySwitchOut = isAnimatingAwaySwitchOut;
	}

	/**
	 * @return the framesAwayPokeballStayedOnOut
	 */
	public int getFramesAwayPokeballStayedOnOut() {
		return framesAwayPokeballStayedOnOut;
	}

	/**
	 * @param framesAwayPokeballStayedOnOut
	 *            the framesAwayPokeballStayedOnOut to set
	 */
	public void setFramesAwayPokeballStayedOnOut(
			int framesAwayPokeballStayedOnOut) {
		this.framesAwayPokeballStayedOnOut = framesAwayPokeballStayedOnOut;
	}

	/**
	 * @return the isAnimatingAwayPokemonSwitchOutResize
	 */
	public boolean isAnimatingAwayPokemonSwitchOutResize() {
		return isAnimatingAwayPokemonSwitchOutResize;
	}

	/**
	 * @param isAnimatingAwayPokemonSwitchOutResize
	 *            the isAnimatingAwayPokemonSwitchOutResize to set
	 */
	public void setAnimatingAwayPokemonSwitchOutResize(
			boolean isAnimatingAwayPokemonSwitchOutResize) {
		this.isAnimatingAwayPokemonSwitchOutResize = isAnimatingAwayPokemonSwitchOutResize;
	}

	/**
	 * @return the awayPokemonSwitchOutResizePercent
	 */
	public double getAwayPokemonSwitchOutResizePercent() {
		return awayPokemonSwitchOutResizePercent;
	}

	/**
	 * @param awayPokemonSwitchOutResizePercent
	 *            the awayPokemonSwitchOutResizePercent to set
	 */
	public void setAwayPokemonSwitchOutResizePercent(
			double awayPokemonSwitchOutResizePercent) {
		this.awayPokemonSwitchOutResizePercent = awayPokemonSwitchOutResizePercent;
	}

	/**
	 * @return the totalTimeForStatChange
	 */
	public int getTotalTimeForStatChange() {
		return totalTimeForStatChange;
	}

	/**
	 * @param totalTimeForStatChange
	 *            the totalTimeForStatChange to set
	 */
	public void setTotalTimeForStatChange(int totalTimeForStatChange) {
		this.totalTimeForStatChange = totalTimeForStatChange;
	}

	/**
	 * @return the homeStatChange
	 */
	public int getHomeStatChange() {
		return homeStatChange;
	}

	/**
	 * @param homeStatChange
	 *            the homeStatChange to set
	 */
	public void setHomeStatChange(int homeStatChange) {
		this.homeStatChange = homeStatChange;
	}

	/**
	 * @return the isAnimatingHomeStatIncrease
	 */
	public boolean isAnimatingHomeStatIncrease() {
		return isAnimatingHomeStatIncrease;
	}

	/**
	 * @param isAnimatingHomeStatIncrease
	 *            the isAnimatingHomeStatIncrease to set
	 */
	public void setAnimatingHomeStatIncrease(boolean isAnimatingHomeStatIncrease) {
		this.isAnimatingHomeStatIncrease = isAnimatingHomeStatIncrease;
	}

	/**
	 * @return the isAnimatingHomeStatDecrease
	 */
	public boolean isAnimatingHomeStatDecrease() {
		return isAnimatingHomeStatDecrease;
	}

	/**
	 * @param isAnimatingHomeStatDecrease
	 *            the isAnimatingHomeStatDecrease to set
	 */
	public void setAnimatingHomeStatDecrease(boolean isAnimatingHomeStatDecrease) {
		this.isAnimatingHomeStatDecrease = isAnimatingHomeStatDecrease;
	}

	/**
	 * @return the awayStatChange
	 */
	public int getAwayStatChange() {
		return awayStatChange;
	}

	/**
	 * @param awayStatChange
	 *            the awayStatChange to set
	 */
	public void setAwayStatChange(int awayStatChange) {
		this.awayStatChange = awayStatChange;
	}

	/**
	 * @return the isAnimatingAwayStatIncrease
	 */
	public boolean isAnimatingAwayStatIncrease() {
		return isAnimatingAwayStatIncrease;
	}

	/**
	 * @param isAnimatingAwayStatIncrease
	 *            the isAnimatingAwayStatIncrease to set
	 */
	public void setAnimatingAwayStatIncrease(boolean isAnimatingAwayStatIncrease) {
		this.isAnimatingAwayStatIncrease = isAnimatingAwayStatIncrease;
	}

	/**
	 * @return the isAnimatingAwayStatDecrease
	 */
	public boolean isAnimatingAwayStatDecrease() {
		return isAnimatingAwayStatDecrease;
	}

	/**
	 * @param isAnimatingAwayStatDecrease
	 *            the isAnimatingAwayStatDecrease to set
	 */
	public void setAnimatingAwayStatDecrease(boolean isAnimatingAwayStatDecrease) {
		this.isAnimatingAwayStatDecrease = isAnimatingAwayStatDecrease;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * @return the battle
	 */
	public Battle getBattle() {
		return battle;
	}

	/**
	 * @param battleDisplayHeight
	 *            the battleDisplayHeight to set
	 */
	public void setBattleDisplayHeight(int battleDisplayHeight) {
		this.battleDisplayHeight = battleDisplayHeight;
	}

	/**
	 * @param frameWidth
	 *            the frameWidth to set
	 */
	public void setFrameWidth(int frameWidth) {
		this.frameWidth = frameWidth;
	}

	/**
	 * @param frameHeight
	 *            the frameHeight to set
	 */
	public void setFrameHeight(int frameHeight) {
		this.frameHeight = frameHeight;
	}

	private boolean isAnimatingHomeAbility = false;
	private int homeAbilityFrame = 0;

	public void animateAbility(PartyPokemon p) {
		if (p.isHome())
			animateHomeAbility();
		else
			animateAwayAbility();
	}

	public void animateHomeAbility() {
		isAnimatingHomeAbility = true;
		homeAbilityFrame = 0;
	}

	private boolean isAnimatingAwayAbility = false;
	private int awayAbilityFrame = 0;

	public void animateAwayAbility() {
		isAnimatingAwayAbility = true;
		awayAbilityFrame = 0;
	}

	/**
	 * @return the isAnimatingHomeAbility
	 */
	public boolean isAnimatingHomeAbility() {
		return isAnimatingHomeAbility;
	}

	/**
	 * @param isAnimatingHomeAbility
	 *            the isAnimatingHomeAbility to set
	 */
	public void setAnimatingHomeAbility(boolean isAnimatingHomeAbility) {
		this.isAnimatingHomeAbility = isAnimatingHomeAbility;
	}

	/**
	 * @return the homeAbilityFrame
	 */
	public int getHomeAbilityFrame() {
		return homeAbilityFrame;
	}

	/**
	 * @param homeAbilityFrame
	 *            the homeAbilityFrame to set
	 */
	public void setHomeAbilityFrame(int homeAbilityFrame) {
		this.homeAbilityFrame = homeAbilityFrame;
	}

	/**
	 * @return the isAnimatingAwayAbility
	 */
	public boolean isAnimatingAwayAbility() {
		return isAnimatingAwayAbility;
	}

	/**
	 * @param isAnimatingAwayAbility
	 *            the isAnimatingAwayAbility to set
	 */
	public void setAnimatingAwayAbility(boolean isAnimatingAwayAbility) {
		this.isAnimatingAwayAbility = isAnimatingAwayAbility;
	}

	/**
	 * @return the awayAbilityFrame
	 */
	public int getAwayAbilityFrame() {
		return awayAbilityFrame;
	}

	/**
	 * @param awayAbilityFrame
	 *            the awayAbilityFrame to set
	 */
	public void setAwayAbilityFrame(int awayAbilityFrame) {
		this.awayAbilityFrame = awayAbilityFrame;
	}

	public boolean isAnimatingStat() {
		return isAnimatingAwayStatDecrease || isAnimatingAwayStatIncrease
				|| isAnimatingHomeStatDecrease || isAnimatingHomeStatIncrease;
	}

}