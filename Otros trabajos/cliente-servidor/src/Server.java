import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String args[]) {
ServerSocket servidor;
Socket conexion;
DataOutputStream salida;
DataInputStream entrada;
int num = 0;
try {
servidor = new ServerSocket(5000); // Creamos un ServerSocket en el puerto especificado
System.out.println("Servidor Arrancado correctamente");
while (true) {
conexion = servidor.accept();     // Esperamos una conexi�n
num++;
System.out.println("Conexi�n n�mero" + num + " desde: " + conexion.getInetAddress().getHostName());
entrada = new DataInputStream(conexion.getInputStream());  // Abrimos los canales de entrada y salida
salida = new DataOutputStream(conexion.getOutputStream());
String mensaje = entrada.readUTF();    //Leemos el mensaje del cliente
System.out.println("Conexi�n n." + num + " mensaje: " + mensaje);
salida.writeUTF("Sois los mejores " + mensaje);  // Le respondemos
conexion.close();                           // Y cerramos la conexi�n
}
} catch (IOException e) {
	}
	}
}



