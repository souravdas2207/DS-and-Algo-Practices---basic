package hashtables;

public class SimpleHashTableWithLinearProbing {
	
	private Employee[] hashtable;
	private static final double LOAD_FACTOR = 1; 
	
	public SimpleHashTableWithLinearProbing() {
		hashtable = new Employee[10];
	}
	
	/*private SimpleHashTableWithLinearProbing(int size, Employee[] hashtable) {
		hashtable = new Employee[size];
	}*/
	
	private SimpleHashTableWithLinearProbing(int size) {
		this.hashtable = new Employee[size];
	}
	
	private int hash(String key) {
		
		return key.length() % hashtable.length;
	}
	
	public Employee put(String key, Employee employee) {
		int hashkey = hash(key), stopIndex;
		
		Employee availableEmployee = null;
		
		stopIndex = hashkey;
		
		do {
			if(occupied(hashkey)) {
				if(hashtable[hashkey].getName().equals(key)) {
					
					System.out.println("\n****\n"
							+ "already element present in the hashkey position in the table\n"
							+ "hence, updating the element and returning the previous element\n"
							+ "key = "+key);
					
					availableEmployee = hashtable[hashkey];
					updateEmployee(hashkey, employee);
					
					break;
				}
				
//				hashkey == hashtable.length-1 ? 0 : ++hashkey
				hashkey = hashkeyLinearProbe(hashkey);
				
				if(hashkey == stopIndex) {
					// the hashtable is full at this point
					// the size of the hashtable backing array needs to be increased
					
					System.out.println("\n****\n"
							+ "Hashtable is full !\n"
							+ "Resizing hashtable to accomodate new insertion for key = "+key);
					
					resizeHashtableAndUpdate();
					
					hashkey = hash(key);
					stopIndex = hashkey;
					
					if(occupied(hashkey)) {
//						hashkey == hashtable.length-1 ? 0 : ++hashkey
						hashkey = hashkeyLinearProbe(hashkey);
					}
					else {
						hashtable[hashkey] = employee;
						break;
					}
				}
			}
			else {
				hashtable[hashkey] = employee;
				break;
			}
		}while(hashkey!=stopIndex);
		
		return availableEmployee == null ? employee : availableEmployee;
	}
	
	private void updateEmployee(int hashkey, Employee updatedEmployee) {
		hashtable[hashkey] = updatedEmployee;
	}
	
	public Employee get (String key) {
		
		int hashkey = hash(key), stopIndex;
		
		stopIndex = hashkey;
		
		do {
			
			if(occupied(hashkey)) {
				
				if(hashtable[hashkey].getName()==key)
					break;
				
//				hashkey == hashtable.length-1 ? 0 : ++hashkey
				hashkey = hashkeyLinearProbe(hashkey);
			}
			else
				break;
			
		}while(hashkey != stopIndex);
		
		return hashtable[hashkey];
	} 
	
	public Employee delete(String key) {
		
		int hashkey = hash(key), stopIndex;
		
		stopIndex = hashkey;
		
		Employee deletedEmployee = null;
		
		do {
			
			if(occupied(hashkey) && hashtable[hashkey].getName().equals(key)) {
				deletedEmployee = hashtable[hashkey];
//				System.out.println("Inside delete before nulling (deletedEmployee): "+deletedEmployee); // console debugging
				hashtable[hashkey] = null;
				break;
			}
			
//			hashkey == hashtable.length-1 ? 0 : ++hashkey
			hashkey = hashkeyLinearProbe(hashkey);
			
//			System.out.println(hashkey); // for console debugging purpose
			
		}while(hashkey != stopIndex);
		
		if(hashkey==stopIndex) {
			System.out.println("\n\nNo element exists with key : "+key);
			return null;
		}
			
		return deletedEmployee;
	}
	
	public void printAll() {
		System.out.println("****");
		for(int i = 0; i < hashtable.length; i++) {
			if(this.hashtable[i] == null)
				System.out.println("null");
			else
				System.out.println(this.hashtable[i]);
		}
	} 
	
	private boolean occupied(int hashkey) {
		return hashtable[hashkey] != null;
	}
	
	private int hashkeyLinearProbe(int hashkey) {
		return hashkey == hashtable.length-1 ? 0 : ++hashkey;
	}
	
	private void resizeHashtableAndUpdate() {
		Employee[] tempArray = new Employee[hashtable.length];
		
		System.arraycopy(hashtable, 0, tempArray, 0, hashtable.length);
//		System.arraycopy(src, srcPos, dest, destPos, length);
		
		resizeHashtable();
		
		System.out.println("After hashtable backing Array resize : "+hashtable.length);
//		printAll();
		
		updateHashtable(tempArray);
		
	}
	
	private void resizeHashtable() {
		/*SimpleHashTableWithLinearProbing newObj = new SimpleHashTableWithLinearProbing(hashtable.length + 10);
		this.hashtable = newObj.hashtable;*/
		
		// creating a new object and assigning the empty (null) hashtable into existing hashtable
		this.hashtable = new SimpleHashTableWithLinearProbing(hashtable.length + 10).hashtable;
	}
	
	private void updateHashtable(Employee[] tempArray) {
		
		// inserting the available content of the existing hashtable (tempArray) into new hashtable with hashing
		System.out.println("TempArray size : "+tempArray.length);
		for(int i = 0; i < tempArray.length; i++) {
			
			put(tempArray[i].getName(), tempArray[i]);
			
		}
	}
}
