package it.polito.tdp.PremierLeague.model;

public class Avversari implements Comparable<Avversari> {

	Player p;
	int differenza;
	public Avversari(Player p, int differenza) {
		super();
		this.p = p;
		this.differenza = differenza;
	}
	public Player getP() {
		return p;
	}
	public void setP(Player p) {
		this.p = p;
	}
	public int getDifferenza() {
		return differenza;
	}
	public void setDifferenza(int differenza) {
		this.differenza = differenza;
	}
	@Override
	public String toString() {
		return p.getName()+" - "+p.getPlayerID()+" ("+this.differenza+")";
	}
	@Override
	public int compareTo(Avversari o) {
		return -(this.differenza-o.differenza);
	}
	
	
}
