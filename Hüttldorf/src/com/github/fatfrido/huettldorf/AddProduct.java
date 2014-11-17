package com.github.fatfrido.huettldorf;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JComboBox;

public class AddProduct extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddProduct frame = new AddProduct();
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
	public AddProduct() {
		ExcelManager em = new ExcelManager();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 783, 416);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton back = new JButton("<--");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Huettldorf hd = new Huettldorf();
				hd.frame.setVisible(true);
			}
		});
		back.setBounds(0, 0, 50, 378);
		contentPane.add(back);
		
		JButton proceed = new JButton("-->");
		proceed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Huettldorf hd = new Huettldorf();
				hd.frame.setVisible(true);
			}
		});
		proceed.setBounds(717, 0, 50, 378);
		contentPane.add(proceed);
		
		JComboBox<ArrayList<?>> chooseGroup = new JComboBox<ArrayList<?>>();
		chooseGroup.setMaximumRowCount(15);
		chooseGroup.setBounds(60, 0, 255, 37);
		chooseGroup.addItem((ArrayList<?>) em.getGroups(em.yearnum));
		contentPane.add(chooseGroup);
	}
}
