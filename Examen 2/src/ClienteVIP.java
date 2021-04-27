
public class ClienteVIP extends ClienteNormal{
	private int puntos;
	
	public ClienteVIP(String dNI, String name, int num, int puntos) {
		super(dNI, name, num);
		this.puntos= puntos;
	}

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	@Override
	public String toString() {
		return "ClienteVIP [puntos=" + puntos + ", getNum()=" + getNum() + ", toString()=" + super.toString()
				+ ", getDNI()=" + getDNI() + ", getName()=" + getName() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + "]";
	}	
}
