package programa;


public class Coche {
	 private double miVelocidad; // Velocidad en pixels/segundo
	 protected double miDireccionActual; // Dirección en la que estoy mirando en grados (de 0 a 360)
	 protected double posX; // Posición en X (horizontal)
	 protected double posY; // Posición en Y (vertical)
	 private String piloto; // Nombre de piloto



	 public Coche() {
		 this.miVelocidad=0;
		 this.miDireccionActual=0;
		 this.posX=0;
		 this.posY=0;
		 this.piloto="";
	 }
	 public Coche(int miVelocidad,int miDireccionActual,int posX,int posY,String piloto) {
		 this.miVelocidad=miVelocidad;
		 this.miDireccionActual=miDireccionActual;
		 this.posX=posX;
		 this.posY= posY;
		 this.piloto=piloto;
	 }



	 /** Cambia la velocidad actual del coche
		 * @param aceleracion Incremento de la velocidad en pixels/segundo
		 */
		 public void acelera( double aceleracion ) {
		 
			miVelocidad = miVelocidad + aceleracion;
		 
		 }
		
		 
		 
	



		/** Cambia la dirección actual del coche
		 * @param giro Angulo de giro a sumar o restar de la dirección actual, en grados (-180 a +180)
		 */
		 public void gira( double giro ) {
			
			 this.miDireccionActual = this.miDireccionActual + giro;
		 
		 
		 }
		
		 
		 
		 
		 /** Cambia la posición del coche dependiendo de su velocidad y dirección
		 * @param tiempoDeMovimiento Tiempo transcurrido, en segundos
		 */
		 public void mueve( ) {
		
			 this.posX= this.posX+ this.miVelocidad+Math.cos(this.miDireccionActual+(Math.PI/2));
			 this.posY= this.posY+ this.miVelocidad+Math.cos(this.miDireccionActual+(Math.PI/2));

		 } 
		

		 public double getMiVelocidad() {
				return miVelocidad;
			}



			public void setMiVelocidad(double miVelocidad) {
				this.miVelocidad = miVelocidad;
			}



			public double getMiDireccionActual() {
				return miDireccionActual;
			}



			public void setMiDireccionActual(double miDireccionActual) {
				this.miDireccionActual = miDireccionActual;
			}



			public double getPosX() {
				return posX;
			}



			public void setPosX(int posX) {
				this.posX = posX;
			}



			public double getPosY() {
				return posY;
			}



			public void setPosY(int posY) {
				this.posY = posY;
			}



			public String getPiloto() {
				return piloto;
			}



			public void setPiloto(String piloto) {
				this.piloto = piloto;
			}


			public String toString() {
				return "Velocidad: " + this.miVelocidad  +"Direccion: " + this.miDireccionActual+ "Pos x: "+ this.posX+ "Pos y: "+ this.posY;
			}




}