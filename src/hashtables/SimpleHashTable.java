package hashtables;

public class SimpleHashTable {
	
	private Employee[] hashtable;
	
	public SimpleHashTable() {
		hashtable = new Employee[10];
	}
	
	private int hash(String key) {
		
		return key.length() % hashtable.length;
	}
	
	public void put(String key, Employee employee) {
		int hashkey = hash(key);
		
		if (hashtable[hashkey] != null) 
			System.out.println("already element present in the hashkey position in the table\nkey = "+key);
		else
			hashtable[hashkey] = employee;
	}
	
	public Employee get (String key) {
		return hashtable[hash(key)];
	} 
	
	public void printAll() {
		for(int i = 0; i < hashtable.length; i++) {
			if(this.hashtable[i] == null)
				System.out.println("null");
			else
				System.out.println(this.hashtable[i]);
		}
	}
}
