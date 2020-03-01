package com.gmail.realtadukoo.genealogy.program;

import com.gmail.realtadukoo.genealogy.program.event.GenealogyViewChangeEventHandler;
import com.gmail.realtadukoo.util.event.view.ViewChangeEventHandler;
import com.gmail.realtadukoo.util.view.Context;

public class GenealogyContext extends Context{
	
	@Override
	protected void initEventHandlers(){
		ViewChangeEventHandler viewChangeEventHandler = new GenealogyViewChangeEventHandler();
		eventHandlers.put(ViewChangeEventHandler.class, viewChangeEventHandler);
	}
}
