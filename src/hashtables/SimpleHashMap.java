package hashtables;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SimpleHashMap {
	private List<Employee>[] hashmap;
	
	public SimpleHashMap() {
		
		this.hashmap = new ArrayList[10];
		
	}
	
	public Employee put(String key, Employee employee) {
		Employee availableEmployee = null;
		
		int hashkey = hash(key), index = 0;
		
		// checking to find if arraylist at hashkey position is initialized
		if(occupied(hashkey)) {
			Iterator<Employee> iterator = hashmap[hashkey].iterator();
			
			// looping over the available data to check for update
			while(iterator.hasNext()) {
				availableEmployee = iterator.next();
				
				if(availableEmployee.getName().equals(key)) {
					
//					System.out.println(availableEmployee.getId());
//					System.out.println(hashmap[hashkey].get(index)+" : id="+hashmap[hashkey].get(index).getId());
					hashmap[hashkey].set(index, employee);
					break;
				}
				else {
					index++;
				}
			}
			
			if(index == hashmap[hashkey].size()) {
				hashmap[hashkey].add(employee);
				availableEmployee = null;
			}
		}
		// if not initialized at hashkey position, 
		// then initializing and adding first element in arraylist at hashkey position
		else {
			hashmap[hashkey] = new ArrayList<Employee>();
			hashmap[hashkey].add(employee);
		}
		
		return availableEmployee;
	}
	
	// returns the matched element with the given key, else returns null 
	public Employee get(String key) {
		
		int hashkey = hash(key);
		Employee availableEmployee = null;
		
		if(occupied(hashkey)) {

			for(Employee emp : hashmap[hashkey]) {
				availableEmployee = emp.getName().equals(key) ? emp : null;
				if(availableEmployee!=null)
					break;
			}
		}
		
		return availableEmployee;
	}
	
	// returns deleted element from the hashmap on key match, else returns null
	public Employee delete(String key) {
		
		int hashkey = hash(key), index = 0;
		
		// checking the availability of arraylist at hashmap[hashkey]
		// if not present ie occupied(hashkey) = false, searched key is not available
		if(occupied(hashkey)) {
			
			// to loop through all the elements at the found hashkey position
			while(index < hashmap[hashkey].size()) {
				
				// checking if searched key is the only element at hashkey position
				if(hashmap[hashkey].size() == 1 && getKeyAtHashkeyIndex(hashkey, index).equals(key)) {
					Employee emp = hashmap[hashkey].get(index);
					hashmap[hashkey] = null;
					return emp;
				}
					
				// matched element key at index is removed
				if(hashmap[hashkey].get(index++).getName().equals(key))
					return hashmap[hashkey].remove(index-1);
			}
			
			// checking if iteration through all elements is complete and yet key not found
			if(index == hashmap[hashkey].size())
				System.out.println("No values found to delete with key = "+key);
		}
		else
			System.out.println("No values found to delete with key = "+key);
		
		// returning null if else is reached
		return null;
	}
	
	private String getKeyAtHashkeyIndex(int hashkey, int index) {
		return hashmap[hashkey].get(index).getName();
	}
	
	private int hash(String hashkey) {
		return hashkey.length() % hashmap.length;
	}
	
	private boolean occupied(int hashkey) {
		return hashmap[hashkey] != null;
	}
	
	public void printAll() {
		System.out.println("****");
		
		/*for(int i = 0; i < hashtable.length; i++) {
			if(this.hashtable[i] == null)
				System.out.println("null");
			else
				System.out.println(this.hashtable[i]);
		}*/
		
		for(int i = 0; i < hashmap.length; i++) {
			if(this.hashmap[i] == null) {
				System.out.println("null");
			}
			else {
				hashmap[i].stream().forEach(employee -> System.out.print(" -> "+employee));
				System.out.println();
			}
		}
	} 
}
