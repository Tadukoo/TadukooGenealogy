package com.github.tadukoo.genealogy.program.view;

import com.github.tadukoo.util.event.view.old.ViewChangeEvent;
import com.github.tadukoo.util.view.old.Context;
import com.github.tadukoo.util.view.old.View;
import com.github.tadukoo.util.view.old.draw.Draw.ORIENTATION;
import com.github.tadukoo.util.view.old.textinput.TextInputPrompt;

public class MainMenu extends View{
	
	@Override
	public void init(Context context){
		super.init(context);
		addClickable(0, TextInputPrompt.builder()
										.x(1366/2-100)
										.y(768/2-25)
										.width(200)
										.height(50)
										.textOrientation(ORIENTATION.CENTER)
										.textX(100)
										.textY(25)
										.build());
		/*
		addDrawable(0, Text.builder()
							.text("Derp")
							.x(1366/2)
							.y(768/2)
							.color(Color.RED)
							.build());
		/**/
	}
	
	@Override
	public void handleEvent(ViewChangeEvent e){
		
	}
	
	// TODO: Change this to be within a FullEventListener instead, and have a Genealogy abstract view to contain it
	public void onViewChangeEvent(ViewChangeEvent e){
		
	}
}
