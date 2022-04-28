package co.com.devco.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class DemoblazeCarritoPage {
	public static final Target TITULO_PRODUCTO_CARRITO = Target.the("titulo del producto del carrito").locatedBy("//tbody[@id='tbodyid']//td[text()='{0}']");
	public static final Target LISTA_PRODUCTOS_CARRITO = Target.the("Lista de productos del carrito").locatedBy("//tbody[@id='tbodyid']");
	public static final Target CANTIDAD_PRODUCTOS_CARRITO = Target.the("Cantidad de productos del carrito").locatedBy("//tbody[@id='tbodyid']/tr");
	public static final Target LINK_PRIMER_DELETE_PRODUCTOS_CARRITO = Target.the("Link para borrado de productos del carrito").locatedBy("//tbody[@id='tbodyid']/tr[1]//a[text()='Delete']");
	public static final Target LINK_DELETE_DEL_PRODUCTO = Target.the("Link para borrado de un producto en especifico del carrito").locatedBy("//tbody[@id='tbodyid']/tr/td[text()='{0}']/..//a[text()='Delete']");

	public static final Target PRODUCTOS_CARRITO_TIPO = Target.the("productos del carrito del tipo {0}").locatedBy("//tbody[@id='tbodyid']//td[text()='{0}']/..");
}
