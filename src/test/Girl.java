package test;

public class Girl {

    int id;
    String name;
    
    Girl(int p_id, String p_name){
	id = p_id;
	name = p_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
	return "Girl [id=" + id + ", name=" + name + "]";
    }
    
}
