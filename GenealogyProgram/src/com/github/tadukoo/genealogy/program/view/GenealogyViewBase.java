package com.github.tadukoo.genealogy.program.view;

import com.github.tadukoo.util.view.old.Context;
import com.github.tadukoo.util.view.old.View;
import com.github.tadukoo.util.view.old.ViewBase;
import com.github.tadukoo.util.view.old.ViewBaseParams;
import com.github.tadukoo.genealogy.program.GenealogyContext;

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
