
public class ClienteNormal extends Cliente{
	private int num;
	
	public ClienteNormal(String dNI, String name, int num) {
		super(dNI, name);
		this.num = num;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	@Override
	public String toString() {
		return "ClienteNormal [num=" + num + ", getDNI()=" + getDNI() + ", getName()=" + getName() + ", toString()="
				+ super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}
	
}
