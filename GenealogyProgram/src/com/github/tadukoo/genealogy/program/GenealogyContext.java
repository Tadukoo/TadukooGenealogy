package com.github.tadukoo.genealogy.program;

import com.github.tadukoo.genealogy.program.event.GenealogyViewChangeEventHandler;
import com.github.tadukoo.util.event.view.old.ViewChangeEventHandler;
import com.github.tadukoo.util.view.old.Context;

public class GenealogyContext extends Context{
	
	@Override
	protected void initEventHandlers(){
		ViewChangeEventHandler viewChangeEventHandler = new GenealogyViewChangeEventHandler();
		eventHandlers.put(ViewChangeEventHandler.class, viewChangeEventHandler);
	}
}
