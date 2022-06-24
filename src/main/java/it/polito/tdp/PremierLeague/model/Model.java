package it.polito.tdp.PremierLeague.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleDirectedWeightedGraph;

import it.polito.tdp.PremierLeague.db.PremierLeagueDAO;

public class Model {

	private PremierLeagueDAO dao;
	private SimpleDirectedWeightedGraph<Player,DefaultWeightedEdge> grafo;
	private Map<Integer,Player> idMap;
	private List<Player> vertici;
	
	public Model() {
		dao= new PremierLeagueDAO();
		this.idMap= new HashMap<>();
		this.vertici= new ArrayList<>();
	}
	
	public void creaGrafo(double mediaMinima) {
		this.grafo= new SimpleDirectedWeightedGraph<>(DefaultWeightedEdge.class);
		this.vertici=this.dao.getPlayerPerGoals(mediaMinima, this.idMap);
		//aggiungo vertici
		Graphs.addAllVertices(this.grafo,this.vertici);
		//aggiungo archi
		List<Arco> archi = this.dao.getArchi(this.idMap);
		for(Arco a : archi) {
			if(a.getPeso()<0) {
				Graphs.addEdgeWithVertices(this.grafo, a.getP2(), a.getP1(), -a.getPeso());
			}
			else {
				Graphs.addEdgeWithVertices(this.grafo, a.getP1(), a.getP2(), a.getPeso());
			}
		}
	}
	
	public int nVertici(){
		return this.grafo.vertexSet().size();
	}
	
	public int nArchi() {
		return this.grafo.edgeSet().size();
	}
	
	public List<Player> getVertici(){
		return this.vertici;
	}
	
	public TopPlayer getTopPlayer() {
		Player best=null;
		int max=0;
		for(Player p : this.grafo.vertexSet()) {
			if(this.grafo.outDegreeOf(p)>max) {
				max=this.grafo.outDegreeOf(p);
				best=p;
			}
		}
		
		TopPlayer top= new TopPlayer(best);
		List<Avversari> avversari= new ArrayList<>();
		for(DefaultWeightedEdge e : this.grafo.outgoingEdgesOf(best)) {
			Avversari a = new Avversari(this.grafo.getEdgeTarget(e),(int) this.grafo.getEdgeWeight(e));
			avversari.add(a);
		}
		Collections.sort(avversari);
		top.setAvversari(avversari);
		return top;
	}
}
