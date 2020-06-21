package com.github.tadukoo.genealogy.program;

import javax.swing.*;

public class GenealogyMainFrame extends JFrame{
	private JPanel panel;
	private JLabel label;
	
	public GenealogyMainFrame(){
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		panel = new JPanel();
		add(panel);
		
		label = new JLabel("It works");
		panel.add(label);
		
		pack();
	}
}
