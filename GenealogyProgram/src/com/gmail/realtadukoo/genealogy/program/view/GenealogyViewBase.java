package com.gmail.realtadukoo.genealogy.program.view;

import com.gmail.realtadukoo.genealogy.program.GenealogyContext;
import com.gmail.realtadukoo.util.view.Context;
import com.gmail.realtadukoo.util.view.View;
import com.gmail.realtadukoo.util.view.ViewBase;
import com.gmail.realtadukoo.util.view.ViewBaseParams;

@SuppressWarnings("serial")
public class GenealogyViewBase extends ViewBase{
	
	public GenealogyViewBase(){
		super(ViewBaseParams.builder()
							.title("Tadukoo Genealogy")
							.build());
	}
	
	@Override
	protected Context createContext(){
		return new GenealogyContext();
	}
	
	@Override
	protected View initFirstView(){
		return new MainMenu();
	}
}
