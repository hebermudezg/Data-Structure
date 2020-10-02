import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;
public class Main {
    public static Scanner input = new Scanner(System.in);
    public static LinkedList<Usuario> RegistrosUsuarios  = new LinkedList<>();

    public static void main(String[] args) {
        String option;
        while (true) {
            System.out.println();
            System.out.println("-----------------------------");
            System.out.println("Buenas, bienvenido al sistema empresas de entregas");
            System.out.println("Escoja una opcion:");
            System.out.println("1. Iniciar sesión");
            System.out.println("2. Registrarse");
            System.out.println("0. Salir");
            option = input.next();
            if (option.equals("1")) {
                Iniciarsesion();
            } else if (option.equals("2")) {
                NuevoUsuario();
            } else if (option.equals("0")) {
                break;
            }
        }
    }
    public static void NuevoUsuario() {
        System.out.println("Registro de un nuevo usuario.");
        System.out.println("Ingrese la cedula del nuevo usurio:");
        int documento = input.nextInt();
        if (documento < 0) {
            System.out.println("Ingresaste una cedula invalida");
            return;
        }
        for (Usuario RegistroUsuario :RegistrosUsuarios){
            if (RegistroUsuario.Documento == documento) {
                System.out.println("Ingresaste una cedula ya existente");
                return;
            }
        }
        input.nextLine();
        System.out.println("Ingrese el nombre del nuevo usuario:");
        String nombre = input.nextLine();
        System.out.println("Ingrese el apellido del nuevo usuario:");
        String apellido = input.nextLine();
        System.out.println("Ingrese el correo del nuevo usuario:");
        System.out.println("El correo debe contener un @");
        String correo = input.nextLine();
        Stack<Integer> pila= new Stack<>();
        String f = "";
        for (int i = 0; i < correo.length(); i++) {
            f = correo.substring(i, i + 1);
            if (f.equals("@") == true) {
                pila.push(i);
            }
        }
        if (pila.empty()==true) {
            System.out.println("Ingresaste un correo invalida falta el @");
            return;
        }
        for (Usuario RegistroUsuario :RegistrosUsuarios){
            if (RegistroUsuario.Correo == correo) {
                System.out.println("Ingresaste un correo ya existente");
                return;
            }
        }
        System.out.println("Ingrese la contraceña del nuevo empleado:");
        String contraseña = input.nextLine();

        Usuario RegistroUsuario = new Usuario(documento,nombre,apellido,correo,contraseña);
        RegistrosUsuarios.add(RegistroUsuario);
        System.out.println("Registro exitoso");
        System.out.println("Ya podra iniciar sesion");
        //Iniciarsesion();
    }
    public static void Iniciarsesion() {
        while (true) {
            input.nextLine();
            System.out.println("-----------------------------");
            System.out.println("Iniciar sesion");
            System.out.println("Por favor ingrese su documento o correo");
            String entrada = input.nextLine();
            System.out.println("Por favor ingrese su contraseña");
            String contras = input.nextLine();
            Usuario inicio = null;
            Stack<Integer> pila = new Stack<>();
            String f = "";
            for (int i = 0; i < entrada.length(); i++) {
                f = entrada.substring(i, i + 1);
                if (f.equals("@") == true) {
                    pila.push(i);
                }
            }
            if (pila.empty() != true) {
                for (Usuario RegistroUsuario : RegistrosUsuarios) {
                    if (RegistroUsuario.Correo == entrada) {
                        inicio = RegistroUsuario;
                        break;
                    }
                }
            } else if (isNumeric(entrada)) {
                int documento = Integer.parseInt(entrada);
                for (Usuario RegistroUsuario : RegistrosUsuarios) {
                    if (RegistroUsuario.Documento == documento) {
                        inicio = RegistroUsuario;
                        break;
                    }
                }
            }
            if (inicio == null) {
                System.out.println("El documento o correo no fueron encontrados");
                //break;
            }else {
                if(inicio.Contraseña!=contras){
                    System.out.println("La contraseña es incorrecta");
                    //break
                }else {
                    //el siguente menu
                }
            }
            //sin usar pila
            //if (isNumeric(entrada)) {
            //                int documento = Integer.parseInt(entrada);
            //                for (Usuario RegistroUsuario : RegistrosUsuarios) {
            //                    if (RegistroUsuario.Documento == documento) {
            //                        inicio = RegistroUsuario;
            //                        break;
            //                    }
            //                }
            //            }else{
            //for (Usuario RegistroUsuario : RegistrosUsuarios) {
            //                    if (RegistroUsuario.Correo == entrada) {
            //                        inicio = RegistroUsuario;
            //                        break;
            //                    }
            //                }
        }
    }
    public static boolean isNumeric(String cadena){
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException nfe){
            return false;
        }
    }
}
