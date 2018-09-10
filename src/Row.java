import java.util.ArrayList;

public class Row {
	
	private String key;
	private ArrayList<String> contents;

	public Row(String key, ArrayList<String> contents){
		this.key = key;
		this.contents = contents;
	}
	
	public String getKey(){
		return key;
	}
	
	public ArrayList<String> getContents(){
		return contents;
	}
	
	public ArrayList<String> omitKey(){
		ArrayList<String> c = contents;
		c.remove(0);
		return c;
	}
	
	public void addContents(String s){
		contents.add(s);
	}
	
	public String toString(){
		String str = "";
		for(String s: contents) {
			str = str + "\n" + s;
		}
		return str;
		
	}
	
	
	
	public static void main(String[] args) {
		String name = "Name";
		String[] arr = {"a","b","c"};
		//Header h = new Header(name,arr);
		//System.out.println(h.toString());
		

	}

}