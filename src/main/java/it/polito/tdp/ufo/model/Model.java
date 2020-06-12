package it.polito.tdp.ufo.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleDirectedGraph;
import org.jgrapht.traverse.BreadthFirstIterator;

import it.polito.tdp.ufo.db.SightingsDAO;

public class Model {
	private SightingsDAO dao ;
	private Graph<String, DefaultEdge> graph;

	public Model() {
		
		this.dao = new SightingsDAO();
	}
	
	public List<YearAndCount> getYearsAndCount() {
		return this.dao.getYearsAndCount();
	}
	
	public void creaGrafo(int anno)
	{
		this.graph= new SimpleDirectedGraph<String, DefaultEdge>(DefaultEdge.class);
		if(this.dao.getState(anno)==null)
		{
			System.out.print("Errore lettura vertici model!\n");
			return;
		}
		Graphs.addAllVertices(this.graph, this.dao.getState(anno));
		
		if(this.dao.getAdiacenza(anno)==null)
		{
			System.out.print("Errore lettura edge model!\n");
			return;
		}
		for(Adiacenza a : this.dao.getAdiacenza(anno))
		{
				this.graph.addEdge(a.getStato1(), a.getStato2());
		}
		
		
	
	}
	public Set<String> vertexSet()
	{
		return this.graph.vertexSet();
	}
	
	public List<String> outSet(String stato)
	{
		return Graphs.successorListOf(this.graph, stato);
	}
	
	public List<String> inSet(String stato)
	{
		return Graphs.predecessorListOf(this.graph, stato);
	}
	
	public List<String> raggiungibili(String stato)
	{
		List<String> list = new ArrayList<>();
		BreadthFirstIterator<String, DefaultEdge> bfs = new BreadthFirstIterator<String, DefaultEdge>(this.graph,stato);
		while(bfs.hasNext())
		{
			list.add(bfs.next());
		}
		return list;
	}
	
	public Set<DefaultEdge> edgeSet()
	{
		return this.graph.edgeSet();
	}

}
