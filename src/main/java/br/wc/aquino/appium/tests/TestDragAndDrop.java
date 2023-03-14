package br.wc.aquino.appium.tests;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

import br.wc.aquino.appium.core.BaseTest;
import br.wc.aquino.appium.page.DragAndDropPage;
import br.wc.aquino.appium.page.MenuPage;

public class TestDragAndDrop extends BaseTest {
	
	private MenuPage menu=new MenuPage();
	private DragAndDropPage page= new DragAndDropPage();
	
	private String[] estadoInicial=new String[] {"Esta","� uma lista", "Drag em Drop!", "Fa�a um clique longo", "e arraste para", "qualquer local desejado."};
	private String[] estadoIntermedirio=new String[] {"� uma lista", "Drag em Drop!", "Fa�a um clique longo", "e arraste para", "Esta", "qualquer local desejado."};
	private String[] estadoFinal=new String[] {"Fa�a um clique longo", "� uma lista", "Drag em Drop!", "e arraste para", "Esta", "qualquer local desejado."};
	
	@Test
	public void deveEfetuarDragAndDrop() {
		menu.clicarDragAndDrop();
		esperar(1000);
		assertArrayEquals(estadoInicial, page.obterLista());
		page.arrastar("Esta", "e arraste para");
		assertArrayEquals(estadoIntermedirio, page.obterLista());
		page.arrastar("Fa�a um clique longo", "� uma lista");
		assertArrayEquals(estadoFinal, page.obterLista());
		
	}
}
