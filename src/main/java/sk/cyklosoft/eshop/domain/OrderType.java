package sk.cyklosoft.eshop.domain;

/**
 * nevybavene(neodoslane, zaplatene/nezaplatene, odoslana faktura)
 * 
 * @author radko28
 *
 */
public enum OrderType {
	NOSEND, PAID, NOPAID, SEND;
}
