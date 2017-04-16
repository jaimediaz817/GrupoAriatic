import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Aplicacion {
	
	final static int MAX_CARTAS_PINTA = 13;
	final static int MAX_ANCHO_CARTA  = 125;
	final static int MAX_LARGO_CARTA  = 158;
	final static int REVERSO          = 52;
	
    public static void main(String[] args) throws IOException
	{
		ImageIcon a[];
		int       respuesta;
		
		mostrarImagenCarta( obtenerImagenCarta( 39 ), 11 );
		
		a = new ImageIcon[ 5 ];
		a [ 0 ] = obtenerImagenCarta( REVERSO );
		a [ 1 ] = null;
		a [ 2 ] = obtenerImagenCarta( 23 );
		a [ 3 ] = null;
		a [ 4 ] = obtenerImagenCarta( 45 );
		
		respuesta = preguntarImagenCarta( a, 17 );
		
		if ( respuesta == JOptionPane.YES_OPTION )
		{
			JOptionPane.showMessageDialog( null, "Excelente, una nueva carta" );
		}
		else
		{
			JOptionPane.showMessageDialog( null, "Muchas gracias" );
		}
		
	}

	
    /**
     * Método para obtener una imagen de la baraja de poker incluyendo el reverso
     * @param n Número de la carta ( 0 .. 51 ) y 52 es el reverso
     * @return Imagen de la carta indicada o el reverso
     * @throws IOException
     */
	public static ImageIcon obtenerImagenCarta ( int n ) throws IOException
	{
		int tipoPinta, tipoCarta;
		BufferedImage baraja;
		ImageIcon     carta;
		
		if ( n < 0 || n > REVERSO )
		{
			n = REVERSO;
		}
		
		tipoCarta = n % MAX_CARTAS_PINTA;
		tipoPinta = ( n - tipoCarta ) / MAX_CARTAS_PINTA;
		
		baraja = ImageIO.read(  Aplicacion.class.getResource( "baraja-poker.jpg") ); 	   
		carta = new ImageIcon( baraja.getSubimage(tipoCarta * MAX_ANCHO_CARTA, tipoPinta * MAX_LARGO_CARTA, MAX_ANCHO_CARTA, MAX_LARGO_CARTA ));
		
		return carta;
	}
	
	
	/**
	 * Método que muestra la imagen o imagenes ( ignora los null del arreglo) en un JOptionPane indicando el valor
	 * @param carta ImageIcon o arreglo de ImageIcon que son mostrados en un JOptionPane
	 * @param valor Valor de la carta o cartas
	 */
	public static void mostrarImagenCarta ( Object carta, int valor ) 
	{
		JOptionPane.showMessageDialog(null, carta, "Valor: " + valor , JOptionPane.PLAIN_MESSAGE );
	}
	
	/**
	 * Método que muestra la imagen o imagenes ( ignora los null del arreglo) en un JOptionPane indicando el valor
	 * @param carta ImageIcon o arreglo de ImageIcon que son mostrados en un JOptionPane
	 * @param valor Valor de la carta o cartas
	 */
	public static int preguntarImagenCarta ( Object carta, int valor ) 
	{
		return JOptionPane.showConfirmDialog(null, carta, "Valor: " + valor , JOptionPane.YES_NO_OPTION, 0, new ImageIcon(Aplicacion.class.getResource( "Pregunta.png")) );
	}
	
}



