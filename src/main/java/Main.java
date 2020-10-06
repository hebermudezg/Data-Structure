import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;
public class Main {
    public static Scanner input = new Scanner(System.in);
    public static LinkedList<Usuario> RegistrosUsuarios  = new LinkedList<>();
    public static LinkedList<Cliente> clientes  = new LinkedList<>();
    public static LinkedList<ContratoArriendo> contratoArriendos  = new LinkedList<>();
    public static LinkedList<Empresa> empresas  = new LinkedList<>();
    public static LinkedList<Entrega> entregas  = new LinkedList<>();
    public static LinkedList<Especialidad> especialidades  = new LinkedList<>();
    public static LinkedList<Repartidor> repartidores = new LinkedList<>();
    public static LinkedList<Sucursal> sucursales  = new LinkedList<>();
    public static LinkedList<TipoDeEntrega> tipoDeEntregas  = new LinkedList<>();


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

        Usuario RegistrUsuario = new Usuario(documento,nombre,apellido,correo,contraseña);
        RegistrosUsuarios.add(RegistrUsuario);
        System.out.println("Registro exitoso");
        System.out.println("Ya podra iniciar sesion");
        Iniciarsesion();
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
                break;
            }else if(inicio.Contraseña != contras){
                System.out.println("La contraseña es incorrecta");
                break;
            }else {
                System.out.println("Hola"+inicio.Nombre+"\n"+
                        "Bienvenido al sistema Empresa de entregas"+"\n");
                MenuPrincipal();
            }
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
    public static void MenuPrincipal(){
        String option;
        while(true) {
            System.out.println();
            System.out.println("-----------------------------");
            System.out.println("Buenas, bienvenido al menu pricipal");
            System.out.println("Escoja una opcion:");
            System.out.println("1. Administración");
            System.out.println("2. Búsqueda");
            System.out.println("3. Diagnóstico de inconsistencias");
            System.out.println("4. Guardar");
            System.out.println("0. Salir y cancelar");
            System.out.println();
            option = input.next();
            if (option.equals("1")) {
                Administracion();
            } else if (option.equals("2")) {
                Busqueda();
            } else if (option.equals("3")) {
                DiagnosticoInconsistencias();
            } else if (option.equals("4")) {
                Guardar();
            } else if (option.equals("0")) {
                SalirCancelar();
            }
        }
    }
    public static void Administracion(){
        System.out.println("Estos son los elementos posibles");
        System.out.println("Escoja una opcion:");
        System.out.println("1. Empresas");
        System.out.println("2. Sucursales");
        System.out.println("3. Especialidades");
        System.out.println("4. Contrato de arriendos");
        System.out.println("5. Repartidores");
        System.out.println("6. Tipo de entregas");
        System.out.println("7. Entregas");
        System.out.println("8. Clientes");
        System.out.println("0. Cancelar");
        System.out.println();
        String option;
        option = input.next();
        if (option.equals("1")) {
            String i="Empresa";
            System.out.println("Cual de las acciones quiere realizar");
            System.out.println("Escoja una opcion:");
            System.out.println("1. Ver "+i+"s");
            System.out.println("2. Crear "+i);
            System.out.println("3. Editar "+i);
            System.out.println("4. Eliminar "+i);
            System.out.println("0. Cancelar "+i);
            String option1;
            option1 = input.next();
            if (option1.equals("1")) {
                VEmpresa();
            }else if (option1.equals("2")) {
                CEmpresa();
            }else if (option1.equals("3")) {
                EEmpresa();
            }else if (option1.equals("4")) {
                ELEmpresa();
            }else {
                return;
            }
        } else if (option.equals("2")) {
            String i="Sucursal";
            System.out.println("Cual de las acciones quiere realizar");
            System.out.println("Escoja una opcion:");
            System.out.println("1. Ver "+i+"es");
            System.out.println("2. Crear "+i);
            System.out.println("3. Editar "+i);
            System.out.println("4. Eliminar "+i);
            System.out.println("0. Cancelar "+i);
            String option1;
            option1 = input.next();
            if (option1.equals("1")) {
                VSucursal();
            }else if (option1.equals("2")) {
                CSucursal();
            }else if (option1.equals("3")) {
                ESucursal();
            }else if (option1.equals("4")) {
                ELSucursal();
            }else {
                return;
            }
        } else if (option.equals("3")) {
            String i="Especialidad";
            System.out.println("Cual de las acciones quiere realizar");
            System.out.println("Escoja una opcion:");
            System.out.println("1. Ver "+i+"es");
            System.out.println("2. Crear "+i);
            System.out.println("3. Editar "+i);
            System.out.println("4. Eliminar "+i);
            System.out.println("0. Cancelar "+i);
            String option1;
            option1 = input.next();
            if (option1.equals("1")) {
                VEspecialidad();
            }else if (option1.equals("2")) {
                CEspecialidad();
            }else if (option1.equals("3")) {
                EEspecialidad();
            }else if (option1.equals("4")) {
                ELEspecialidad();
            }else {
                return;
            }
        } else if (option.equals("4")) {
            String i="Contrato de arriendo";
            System.out.println("Cual de las acciones quiere realizar");
            System.out.println("Escoja una opcion:");
            System.out.println("1. Ver "+i+"s");
            System.out.println("2. Crear "+i);
            System.out.println("3. Editar "+i);
            System.out.println("4. Eliminar "+i);
            System.out.println("0. Cancelar "+i);
            String option1;
            option1 = input.next();
            if (option1.equals("1")) {
                VContratoArriendo();
            }else if (option1.equals("2")) {
                CContratoArriendo();
            }else if (option1.equals("3")) {
                EContratoArriendo();
            }else if (option1.equals("4")) {
                ELContratoArriendo();
            }else {
                return;
            }
        } else if (option.equals("5")) {
            String i="Repartidor";
            System.out.println("Cual de las acciones quiere realizar");
            System.out.println("Escoja una opcion:");
            System.out.println("1. Ver "+i+"es");
            System.out.println("2. Crear "+i);
            System.out.println("3. Editar "+i);
            System.out.println("4. Eliminar "+i);
            System.out.println("0. Cancelar "+i);
            String option1;
            option1 = input.next();
            if (option1.equals("1")) {
                VRepartidor();
            }else if (option1.equals("2")) {
                CRepartidor();
            }else if (option1.equals("3")) {
                ERepartidor();
            }else if (option1.equals("4")) {
                ELRepartidor();
            }else {
                return;
            }
        }else if (option.equals("6")) {
            String i="Tipo de entrega";
            System.out.println("Cual de las acciones quiere realizar");
            System.out.println("Escoja una opcion:");
            System.out.println("1. Ver "+i+"s");
            System.out.println("2. Crear "+i);
            System.out.println("3. Editar "+i);
            System.out.println("4. Eliminar "+i);
            System.out.println("0. Cancelar "+i);
            String option1;
            option1 = input.next();
            if (option1.equals("1")) {
                VTipoEntrega();
            }else if (option1.equals("2")) {
                CTipoEntrega();
            }else if (option1.equals("3")) {
                ETipoEntrega();
            }else if (option1.equals("4")) {
                ELTipoEntrega();
            }else {
                return;
            }
        } else if (option.equals("7")) {
            String i="Entrega";
            System.out.println("Cual de las acciones quiere realizar");
            System.out.println("Escoja una opcion:");
            System.out.println("1. Ver "+i+"s");
            System.out.println("2. Crear "+i);
            System.out.println("3. Editar "+i);
            System.out.println("4. Eliminar "+i);
            System.out.println("0. Cancelar "+i);
            String option1;
            option1 = input.next();
            if (option1.equals("1")) {
                VEntrega();
            }else if (option1.equals("2")) {
                CEntrega();
            }else if (option1.equals("3")) {
                EEntrega();
            }else if (option1.equals("4")) {
                ELEntrega();
            }else {
                return;
            }
        } else if (option.equals("8")) {
            String i="Cliente";
            System.out.println("Cual de las acciones quiere realizar");
            System.out.println("Escoja una opcion:");
            System.out.println("1. Ver "+i+"s");
            System.out.println("2. Crear "+i);
            System.out.println("3. Editar "+i);
            System.out.println("4. Eliminar "+i);
            System.out.println("0. Cancelar "+i);
            String option1;
            option1 = input.next();
            if (option1.equals("1")) {
                VCliente();
            }else if (option1.equals("2")) {
                CCliente();
            }else if (option1.equals("3")) {
                ECliente();
            }else if (option1.equals("4")) {
                ELCliente();
            }else {
                return;
            }
        } else {
            return;
        }
    }
    public static void VEmpresa(){
        Iterator<Empresa> iterador = empresas.listIterator();
        while (iterador.hasNext()) {
            Empresa empresa = iterador.next();
            System.out.println(empresa);
        }
    }
    public static void CEmpresa(){
        System.out.println("ingrese el nit de la nueva empresa: ");
        int nit=input.nextInt();
        if(nit<0){
            System.out.println("el nit ingresado es invalido, seras regresado al menu anterior");
            return;
        }
        //en caso de necesitar iterador
        //for (Empresa ){
        //    if(personaPendiente.cedula == cedula) {
        //        System.out.println("Ya existe una persona con esta cedula");
        //        return;
        //    }
        System.out.println("ingrese la razon social de la empresa: ");
        int razon=input.nextInt();
        if (razon<0){
            System.out.println("la razon social ingresada es invalida, seras regresado al menu anterior");
            return;
        }
        System.out.println("ingrese el presidente de la empresa: ");
        String presidente = input.nextLine();

        Empresa nuevaEmpresa = new Empresa(nit,razon,presidente);
        empresas.add(nuevaEmpresa);
        System.out.println("Empresa ingresada");

    }
    public static void EEmpresa(){
        System.out.println("ingrese el nit de la empresa a modificar: ");
        int nit = input.nextInt();
        Iterator<Empresa> iterator = empresas.listIterator();
        while (iterator.hasNext()){
            Empresa empresa = iterator.next();
            if (empresa.Nit==nit){
                System.out.println("Que deseas modificar: ");
                System.out.println("1. Nit ");
                System.out.println("2. Razon social ");
                System.out.println("3. Presidente ");
                String option;
                option = input.next();
                if (option.equals("1")) {
                    System.out.println("ingrese el nuevo Nit:");
                    int x = input.nextInt();
                    if (x<0){
                        System.out.println("Nit invalido, seras regresado al menu anterior");
                        return;
                    }
                    empresa.Nit=x;
                    System.out.println("Nit modificado satisfactoriamente");
                }else if (option.equals("2")) {
                    System.out.println("ingrese la nueva razon social:");
                    int x = input.nextInt();
                    if (x<0){
                        System.out.println("razon social invalida, seras regresado al menu anterior");
                        return;
                    }
                    empresa.RazonSocial=x;
                    System.out.println("Razon social modificada satisfactoriamente");
                }else if (option.equals("3")) {
                    System.out.println("ingrese el nuevo Presidente:");
                    String x = input.nextLine();
                    empresa.Presidente = x;
                    System.out.println("Presidente modificado satisfactoriamente");
                    break;
                }
            }
        }
    }
    public static void ELEmpresa(){
            System.out.println("ingrese el nit de la empresa a modificar: ");
            int nit = input.nextInt();
            Iterator<Empresa> iterator = empresas.listIterator();
            while (iterator.hasNext()){
                Empresa empresa = iterator.next();
                if (empresa.Nit==nit){
                    //COMO SE ELIMINA EL OBJETO DE LA ARRAYLIST?
                }
        }
    }
    public static void VSucursal(){
    }
    public static void CSucursal(){
    }
    public static void ESucursal() {
    }
    public static void ELSucursal(){
    }
    public static void VEspecialidad(){
    }
    public static void CEspecialidad(){
    }
    public static void EEspecialidad(){
    }
    public static void ELEspecialidad(){
    }
    public static void VContratoArriendo(){
    }
    public static void CContratoArriendo(){
    }
    public static void EContratoArriendo(){
    }
    public static void ELContratoArriendo(){
    }
    public static void VRepartidor(){
    }
    public static void CRepartidor(){
    }
    public static void ERepartidor(){
    }
    public static void ELRepartidor(){
    }
    public static void VTipoEntrega(){
    }
    public static void CTipoEntrega(){
    }
    public static void ETipoEntrega(){
    }
    public static void ELTipoEntrega(){
    }
    public static void VEntrega(){
    }
    public static void CEntrega(){
    }
    public static void EEntrega(){
    }
    public static void ELEntrega(){
    }
    public static void VCliente(){
    }
    public static void CCliente(){
    }
    public static void ECliente(){
    }
    public static void ELCliente(){
    }
    public static void Busqueda(){
    }
    public static void DiagnosticoInconsistencias(){

    }
    public static void Guardar(){

    }
    public static void SalirCancelar(){

    }
}
