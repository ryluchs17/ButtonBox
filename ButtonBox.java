/**
 * This program plays sounds when you press buttons in a box!
 * @author Ryan Luchs
 * 
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import javax.sound.sampled.*;

/**
 * ButtonBox main class
 * @author Ryan Luchs
 * 
 */
public class ButtonBox extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1;
	
	Clip clip;
	private File[] sounds = new File[7];
	
	public ButtonBox() {
		super("Button Box");
		
		JButton button;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridLayout(8, 1));
		
		sounds[0] = new File("clips/423.wav");
		sounds[1] = new File("clips/Waluigi1.wav");
		sounds[2] = new File("clips/Waluigi5.wav");
		sounds[3] = new File("clips/041.wav");
		sounds[4] = new File("clips/478.wav");
		sounds[5] = new File("clips/PandaRed_Adult_WhistleA.wav");
		sounds[6] = new File("clips/PandaRed_Young_WhistleA.wav");
		
		//JLabel label;
		
		add(new JLabel("Press a button to play a sound!"));
		
		button = new JButton("Gastrodon");
		button.setActionCommand("0");
		button.addActionListener(this);
		add(button);
		
		button = new JButton("\"Wa\"");
		button.setActionCommand("1");
		button.addActionListener(this);
		add(button);
		
		button = new JButton("\"Move!\"");
		button.setActionCommand("2");
		button.addActionListener(this);
		add(button);
		
		button = new JButton("Zubat");
		button.setActionCommand("3");
		button.addActionListener(this);
		add(button);
		
		button = new JButton("Froslass");
		button.setActionCommand("4");
		button.addActionListener(this);
		add(button);
		
		button = new JButton("Red Panda");
		button.setActionCommand("5");
		button.addActionListener(this);
		add(button);
		
		button = new JButton("Baby Red Panda");
		button.setActionCommand("6");
		button.addActionListener(this);
		add(button);
		
//		label = new JLabel("*I do not own any of these sounds, they are the property of their respective owners*");
//		label.setFont(new Font("TimesRoman", Font.BOLD, 6));
//		add(label);
		
		setSize(getPreferredSize());
		pack();
		setResizable(false);
		setVisible(true);
	}
	
	public void playSound(File sound) {
		try {
			Clip clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(sound));
			clip.start();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "The sound clip could not be played.");
			e.printStackTrace();
		}
	}
		
	
	public void actionPerformed(ActionEvent e) {
		JButton button  = (JButton)e.getSource();
		switch(button.getActionCommand()) {
			case "0":
				playSound(sounds[0]);
				break;
			case "1":
				playSound(sounds[1]);
				break;
			case "2":
				playSound(sounds[2]);
				break;
			case "3":
				playSound(sounds[3]);
				break;
			case "4":
				playSound(sounds[4]);
				break;
			case "5":
				playSound(sounds[5]);
				break;
			case "6":
				playSound(sounds[6]);
				break;
			default:
				JOptionPane.showMessageDialog(this, "Unknown button pressed!");
				break;
		}
	}
	
	public static void main(String[] args) {
		new ButtonBox();
	}
}
