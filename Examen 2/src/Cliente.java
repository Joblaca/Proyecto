
public class Cliente {
	private String DNI;
	private String name;
	
	public Cliente(String dNI, String name) {
		super();
		DNI = dNI;
		this.name = name;
	}
	public String getDNI() {
		return DNI;
	}
	public void setDNI(String dNI) {
		DNI = dNI;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Cliente [DNI=" + DNI + ", name=" + name + "]";
	}
	
	
}
