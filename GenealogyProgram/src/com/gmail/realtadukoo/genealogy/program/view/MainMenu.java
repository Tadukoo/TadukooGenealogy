package com.gmail.realtadukoo.genealogy.program.view;

import java.awt.Color;

import com.gmail.realtadukoo.util.event.view.ViewChangeEvent;
import com.gmail.realtadukoo.util.view.Context;
import com.gmail.realtadukoo.util.view.View;
import com.gmail.realtadukoo.util.view.draw.Text;

public class MainMenu extends View{
	
	@Override
	public void init(Context context){
		super.init(context);
		addDrawable(0, Text.builder()
							.text("Derp")
							.x(1366/2)
							.y(768/2)
							.color(Color.RED)
							.build());
	}
	
	@Override
	public void handleEvent(ViewChangeEvent e){
		
	}
	
	// TODO: Change this to be within a FullEventListener instead, and have a Genealogy abstract view to contain it
	public void onViewChangeEvent(ViewChangeEvent e){
		
	}
}
