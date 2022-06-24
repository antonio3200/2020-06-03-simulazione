package it.polito.tdp.PremierLeague.model;

import java.util.LinkedList;
import java.util.List;

public class TopPlayer {

	Player p;
	List<Avversari> avversari;
	public TopPlayer(Player p) {
		super();
		this.p = p;
		this.avversari= new LinkedList<>();
	}
	public Player getP() {
		return p;
	}
	public void setP(Player p) {
		this.p = p;
	}
	public List<Avversari> getAvversari() {
		return avversari;
	}
	public void setAvversari(List<Avversari> avversari) {
		this.avversari = avversari;
	}
	@Override
	public String toString() {
		return p.getName()+" - "+p.getPlayerID();
	}
	
	
	
}
