package interviewQ;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

// yelp 2018.2.9 interview question, similar to but easier compared with leetcode 298 alien dictionary
/*
 * Company Management Tree: Yelp has a management hierarchy, where each employee reports to a single manager
 * and each manager has up to N reportees.
 * ===== Problem
 * Suppose we have a file with manager and reportee pairs.(manager, reportee) and we would like to convert
 * this to a tree structure.
 * Tree Node data structure:
 *     class Node(object):
 *        	name = " "     	# name of the employee
 *        	reportees = []  # Reportees list of type Node
 *        
 *  ====== Example
 *  			Alice
 *  			  |
 *  		 	  Ben
 *  			/     \
 *  		Charlie   Denis
 *  
 *  == Input 
 *  management_pairs = [ ('Ben', 'Charlie'), ('Alice', 'Ben'), ('Ben', 'Denis)] 
 */
public class CompanyManagementTree {
	public static CompanyTreeNode createTree(List<Relation> pairs) {
		if (pairs == null || pairs.size() == 0) return null;
		Map<String, List<String>> inbound = new HashMap<>();
		Map<String, List<String>> outbound = new HashMap<>();
		HashSet<String> ceo = new HashSet<>();
		
		for (Relation r: pairs) {
			ceo.addAll(Arrays.asList(r.first, r.second)); // put all names into ceo
			if (!inbound.containsKey(r.second)) 
				inbound.put(r.second, new ArrayList<String>());
			inbound.get(r.second).add(r.first);
			if (!outbound.containsKey(r.first))
				outbound.put(r.first, new ArrayList<String>());
			outbound.get(r.first).add(r.second);
		}
		// take all reportees out and get the only ceo
		for (String reportee: inbound.keySet()) {
			if (ceo.contains(reportee)) ceo.remove(reportee);
		}
		String ceo_name = ceo.iterator().next();
		// Do a BFS and construct company tree from here
		Queue<CompanyTreeNode> queue = new LinkedList<>();
		CompanyTreeNode ceo_node = new CompanyTreeNode(ceo_name);
		System.out.println("ceo is: " + ceo_node.name);
		queue.add(ceo_node);
		
		while (!queue.isEmpty()) {
			CompanyTreeNode node = queue.poll();
			node.reportees = inbound.get(node.name);
			List<CompanyTreeNode> reportees = getReportees(node, outbound);
			queue.addAll(reportees);
			System.out.println("Boss: " + node.name + " reportees: " + reportees);
		}
		return ceo_node;
	}
	
	public static List<CompanyTreeNode> getReportees(CompanyTreeNode node, Map<String, List<String>> outbound) {
		List<CompanyTreeNode> res = new ArrayList<>();
		List<String> reportees = outbound.get(node.name);
		if (reportees != null) {
			for (String r: reportees) {
				res.add(new CompanyTreeNode(r));
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		List<Relation> pairs = new ArrayList<>();
		Relation r1 = new Relation("Ben", "Charlie");
		Relation r2 = new Relation("Ben", "Denis");
		Relation r3 = new Relation("Alice", "Ben");
		pairs.addAll(Arrays.asList(r1, r2, r3));
		createTree(pairs);
		
		
	}

}

class Relation {
	String first;
	String second;
	Relation(String f, String s) {
		first = f;
		second = s;
	}
}

class CompanyTreeNode {
	String name;
	List<String> reportees;
	CompanyTreeNode(String name) {
		this.name = name;
		reportees = new ArrayList<String>();
	}
}
