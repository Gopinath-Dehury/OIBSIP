package ngg;

import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.border.EmptyBorder;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Random;

public class NumberGuess extends JFrame {

	private JPanel contentPane;
	private JTextField guessField;
	private int generatedNumber;
	private int maxAttempts =5;
	private int currentAttempt = 0;
	private int score =100;
	private JLabel resultLabel,attemptsLabel,scoreLabel; 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NumberGuess frame = new NumberGuess();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public NumberGuess() {
		
		//Generate a random number
		Random random = new Random();
		generatedNumber = random.nextInt(100);
		
		
		//set up JFrame
		setTitle("Number GUessing Game");
		setSize(620,278);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		//create components
		guessField = new JTextField(10); 
		JButton submitbtn = new JButton("Submit Guess");
		resultLabel =new JLabel("Welcome, Guess the number.");
		attemptsLabel = new JLabel("Attempts left "+ (maxAttempts - currentAttempt));
		scoreLabel = new JLabel("Score "+score);
		
		//set layout manager
		getContentPane().setLayout(new GridLayout(4,1));
		
		//Add components to the frame
		getContentPane().add(guessField);
		getContentPane().add(submitbtn);
		getContentPane().add(resultLabel);
		getContentPane().add(attemptsLabel);
		getContentPane().add(scoreLabel);
		
		//add action listener to the button
		
		submitbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				checkGuess();
				
			}
			
		});

		
		
		
	}
	
	private void checkGuess() {
		if(currentAttempt < maxAttempts) {
			int userGuess = Integer.parseInt(guessField.getText());
			
			if(userGuess == generatedNumber) {
				resultLabel.setText("Congrats, You guessed the correct number.");
				disableInput();
			}else {
				resultLabel.setText("Wrong guess. "+(userGuess >generatedNumber ? "Too high.":"Too low"));
				currentAttempt++;
				attemptsLabel.setText("Attempts left: "+(maxAttempts - currentAttempt));
				score-=20;
				scoreLabel.setText("Score" +score);
			}
		}else {
				resultLabel.setText("Out of attempts.The correct number was: "+generatedNumber);
				disableInput();


			}
		
	}
	private void disableInput() {
		guessField.setEnabled(false);
	}
	
}
