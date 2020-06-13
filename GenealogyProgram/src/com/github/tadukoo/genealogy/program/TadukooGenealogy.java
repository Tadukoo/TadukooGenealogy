package com.github.tadukoo.genealogy.program;

import com.github.tadukoo.engine.Program;

import javax.swing.*;

public class TadukooGenealogy implements Program{
	
	@Override
	public boolean load(){
		return true;
	}
	
	@Override
	public void run(){
		SwingUtilities.invokeLater(() -> new GenealogyMainFrame().setVisible(true));
	}
}
