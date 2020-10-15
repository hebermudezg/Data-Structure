
import java.util.*;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static String ruta = "src/main/resources/database/";
    public static int Numbus= 0;
    public static int Texbus=0;
    public static Scanner input = new Scanner(System.in);

    // LinkedList para las distintas clases.
    public static LinkedList<Usuario> RegistrosUsuarios = new LinkedList<>();
    public static LinkedList<Empresa> empresas  = new LinkedList<>();
    public static LinkedList<ContratoArriendo> contratoArriendos  = new LinkedList<>();
    public static LinkedList<Sucursal> sucursales  = new LinkedList<>();
    public static LinkedList<Especialidad> especialidades  = new LinkedList<>();
    public static LinkedList<TipoDeEntrega> tipoDeEntregas  = new LinkedList<>();
    public static LinkedList<Cliente> clientes  = new LinkedList<>();
    public static LinkedList<ContratoRepartidor> contratorepartidores = new LinkedList<>();
    public static LinkedList<Repartidor> repartidores = new LinkedList<>();
    public static LinkedList<Entrega> entregas  = new LinkedList<>();
    //************************** INICIO DE SESION Y LEER JSON***********************
    public static void main(String[] args) {
        // Leyendo los JSON********************************************************************
        Path pathusuarios = Paths.get("src/main/resources/database/UsuariosJSON.json");
        if(Files.exists(pathusuarios) && !Files.isDirectory(pathusuarios)) {
            RegistrosUsuarios = LeerJSON.leerUsuariosJson();
            //System.out.println("pathusuarios");
        }

        Path pathempresas = Paths.get("src/main/resources/database/EmpresasJSON.json");
        if(Files.exists(pathempresas) && !Files.isDirectory(pathempresas)) {
            empresas = LeerJSON.leerEmpresasJson();
            //System.out.println("pathempresas");
        }


        Path pathSucursalesJSON = Paths.get("src/main/resources/database/sucursalesJSON.json");
        if(Files.exists(pathSucursalesJSON) && !Files.isDirectory(pathSucursalesJSON)) {
            sucursales = LeerJSON.leerSucursalesJson();
           //System.out.println("pathSucursalesJSON");
        }

        Path pathcontratoarriendo = Paths.get("src/main/resources/database/contratoArriendosJSON.json");
        if(Files.exists(pathcontratoarriendo) && !Files.isDirectory(pathcontratoarriendo)) {
            contratoArriendos = LeerJSON.leerContratoArriendoJson();
            //System.out.println("pathcontratoarriendo");
        }

        Path pathespecialidadesJSON = Paths.get("src/main/resources/database/especialidadesJSON.json");
        if(Files.exists(pathespecialidadesJSON) && !Files.isDirectory(pathespecialidadesJSON)) {
            especialidades = LeerJSON.leerEspecialidadJson();
            //System.out.println("pathespecialidadesJSON");

        }

        Path pathTipoDeEntregaJSON = Paths.get("src/main/resources/database/TipoDeEntregaJSON.json");
        if(Files.exists(pathTipoDeEntregaJSON) && !Files.isDirectory(pathTipoDeEntregaJSON)) {
            tipoDeEntregas = LeerJSON.leerTipoDeEntregaJson();
            //System.out.println("pathTipoDeEntregaJSON");
        }


        Path pathClienteJSON = Paths.get("src/main/resources/database/ClienteJSON.json");
        if(Files.exists(pathClienteJSON) && !Files.isDirectory(pathClienteJSON)) {
            clientes = LeerJSON.leerClienteJson();
            //System.out.println("pathClienteJSON");

        }

         Path pathRepartidorJSON = Paths.get("src/main/resources/database/RepartidorJSON.json");
        if(Files.exists(pathRepartidorJSON) && !Files.isDirectory(pathRepartidorJSON)) {
            repartidores = LeerJSON.leerRepartidorJson();
            //System.out.println("pathRepartidorJSON");
        }

        Path pathContratoRepartidorJSON = Paths.get("src/main/resources/database/ContratoRepartidorJSON.json");
        if(Files.exists(pathContratoRepartidorJSON) && !Files.isDirectory(pathContratoRepartidorJSON)) {
            contratorepartidores = LeerJSON.leerContratoRepartidorJson();
            //System.out.println("pathContratoRepartidorJSON");
        }

        Path pathEntregaJSON = Paths.get("src/main/resources/database/EntregaJSON.json");
        if(Files.exists(pathEntregaJSON) && !Files.isDirectory(pathEntregaJSON)) {
            entregas = LeerJSON.leerEntregaJson();
            //System.out.println("pathEntregaJSON");
        }
        // Fin de lectura de JSON ************************************************


        // NO BORRAR
        // agunos experimnetos**********************NO BORRAR ++++++++++++++++++++++++++++++++++++++++++++++++++
        /*Usuario nuevousuario = new Usuario(1,"admin","apell", "admin@","123");
        RegistrosUsuarios.add(nuevousuario);

        Empresa nuevaempresa = new Empresa("90.888.333-1", "Aguacates Rdorguez","Heber" );
        Empresa nuevaempresa2 = new Empresa("90.444.222-2", "Ferreteria Ferreamaya","Andrea" );
        empresas.add(nuevaempresa);
        empresas.add(nuevaempresa2);

        Sucursal nuevasucursal = new Sucursal(1, "Ibague", "calle2", 20, nuevaempresa);
        Sucursal nuevasucursal2 = new Sucursal(2, "bogota", "calle4", 10, nuevaempresa);
        Sucursal nuevasucursal3 = new Sucursal(3, "bogota", "calle4", 10, nuevaempresa2);

        sucursales.add(nuevasucursal);
        sucursales.add(nuevasucursal2);
        sucursales.add(nuevasucursal3);

        ContratoArriendo contratoArriendos1 = new ContratoArriendo(123, "10-10-2000", "10-10-20020", 20000000, nuevasucursal);
        ContratoArriendo contratoArriendos2 = new ContratoArriendo(1234, "10-10-2001", "10-10-2020", 20000000, nuevasucursal2);
        ContratoArriendo contratoArriendos3 = new ContratoArriendo(1234, "10-10-2002", "10-10-2020", 20000000, nuevasucursal3);
        contratoArriendos.add(contratoArriendos1);
        contratoArriendos.add(contratoArriendos2);
        contratoArriendos.add(contratoArriendos3);

        Especialidad epecialidad1 = new Especialidad(1, "pedro", "medicamento", 1233, nuevasucursal2);
        Especialidad epecialidad2 = new Especialidad(2, "juan", "alimentos", 123345, nuevasucursal3);
        especialidades.add(epecialidad1);
        especialidades.add(epecialidad2);

        TipoDeEntrega tipoentrega1 = new TipoDeEntrega(1, 20, "Burro viejo");
        TipoDeEntrega tipoentrega2 = new TipoDeEntrega(2, 100, "Zorra");
        tipoDeEntregas.add(tipoentrega1);
        tipoDeEntregas.add(tipoentrega2);

        Cliente cliente1 = new Cliente(95032, "Esteban Bermudez","Carre39 sur n 20 a 31", 31156, 123);
        Cliente cliente2 = new Cliente(95032501, "Jualiana Bermudez","Carre39 sur n 20 a 41", 3115678, 12366);
        clientes.add(cliente1);
        clientes.add(cliente2);


        Repartidor repartidor1 = new Repartidor(123, "repartidor1",12, 31156078,"AAA", 200000);
        Repartidor repartidor2 = new Repartidor(1234, "repartidor2",22, 311560,"AAA", 300000);
        repartidores.add(repartidor1);
        repartidores.add(repartidor2);

        ContratoRepartidor contratoRepartidor1 = new ContratoRepartidor(1234, 200000, "12-01-2020", "12-01-2020", repartidor1);
        ContratoRepartidor contratoRepartidor2 = new ContratoRepartidor(12345, 200000, "12-01-2020", "12-01-2020", repartidor2);
        contratorepartidores.add(contratoRepartidor1);
        contratorepartidores.add(contratoRepartidor2);

        Entrega entrega1 = new Entrega(12, 20.1, 100, true, 200000, "Una elegancia",
                epecialidad1, tipoentrega1,cliente1,  repartidor1);
        Entrega entrega2 = new Entrega(123, 20.1, 100, true, 200000, "Una elegancia",
                epecialidad1, tipoentrega1,cliente2,  repartidor1);
        entregas.add(entrega1);
        entregas.add(entrega2); */
        // fin de los experimentos *******************************************+++++++++++++++++++++++++++++++++++++++++




        // Menú principal
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
    // Registro de nuevo usuario
    public static void NuevoUsuario() {
        System.out.println("Registro de un nuevo usuario.");
        System.out.println("Ingrese la cedula del nuevo usuario:");
        int documento = input.nextInt();

        // Validacion para el documento
        if (documento < 0) {
            System.out.println("Ingresaste una cedula invalida");
            return;
        }
        // Verificación que el usuario no este registrado
        for (Usuario RegistroUsuario : RegistrosUsuarios) {
            if (RegistroUsuario.documento == documento) {
                System.out.println("Ingresaste una cedula ya existente");
                return;
            }
        }
        input.nextLine();
        System.out.println("Ingrese el nombre del nuevo usuario:");
        String nombre = input.nextLine();
        System.out.println("Ingrese el apellido del nuevo usuario:");
        String apellido = input.nextLine();
        System.out.println("Ingrese el correo del nuevo usuario, El correo debe contener un @ :");
        String correo = input.nextLine();

        // Verificando que tenga al menos una arroba
        Stack<Integer> pila = new Stack<>();
        String f = "";
        for (int i = 0; i < correo.length(); i++) {
            f = correo.substring(i, i + 1);
            if (f.equals("@") == true) {
                pila.push(i); // Insertar
            }
        }
        if (pila.empty() == true) {
            System.out.println("Ingresaste un correo invalida falta el @");
            return;
        }

        // Verificar que el correo no este registrado aún
        for (Usuario RegistroUsuario : RegistrosUsuarios) {
            if (RegistroUsuario.correo.equals(correo)) {
                System.out.println("Ingresaste un correo ya existente");
                return;
            }
        }
        System.out.println("Ingrese la contraseña del nuevo empleado:");
        String contraseña = input.nextLine();
        Usuario RegistrUsuario = new Usuario(documento, nombre, apellido, correo, contraseña);


        // agragando nuevo usuario a la lista
        RegistrosUsuarios.add(RegistrUsuario);
        // Guadar el usuario en el json
        EscribirJSON.guardarUsuario(RegistrosUsuarios); // Guardando una instancia de usuario corregir

        System.out.println("Registro exitoso ! ");
        System.out.println("Ya podra iniciar sesion, \n" +
                "Presione enter");
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
                if (f.equals("@")) {
                    pila.push(i);
                }
            }
            if (pila.empty() != true) {
                for (Usuario RegistroUsuario : RegistrosUsuarios) {
                    if (RegistroUsuario.correo.equals(entrada)) {
                        inicio = RegistroUsuario;
                        break;
                    }
                }
            } else if (isNumeric(entrada)) {
                int documento = Integer.parseInt(entrada);
                for (Usuario RegistroUsuario : RegistrosUsuarios) {
                    if (RegistroUsuario.documento == documento) {
                        inicio = RegistroUsuario;
                        break;
                    }
                }
            }
            if (inicio == null) {
                System.out.println("El documento o correo no fueron encontrados");
                break;
            } else if (!inicio.contraseña.equals(contras)) {
                System.out.println("La contraseña es incorrecta");
                break;
            } else {
                System.out.println("Hola " + inicio.nombre + "! \n" +
                        "Bienvenido al sistema Empresa de entregas");
                MenuPrincipal();
            }
        }
    }
    public static boolean isNumeric(String cadena) {
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }
    //************************** PROGRAMA ***********************
    public static void MenuPrincipal() {
        String option;
        while (true) {
            System.out.println("-----------------------------");
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
    public static void Administracion() {
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
        System.out.println("9. Contrato Repartidores");
        System.out.println("0. Cancelar");
        System.out.println();
        String option;
        option = input.next();

        if (option.equals("1")) {
            String i = "Empresa";
            System.out.println("Cual de las acciones quiere realizar");
            System.out.println("Escoja una opcion:");
            System.out.println("1. Ver " + i + "s");
            System.out.println("2. Crear " + i);
            System.out.println("3. Editar " + i);
            System.out.println("4. Eliminar " + i);
            System.out.println("0. Cancelar " + i);
            String option1;
            option1 = input.next();
            if (option1.equals("1")) {
                VEmpresa();
            } else if (option1.equals("2")) {
                CEmpresa();
            } else if (option1.equals("3")) {
                EEmpresa();
            } else if (option1.equals("4")) {
                ELEmpresa();
            } else {
                return;
            }
        } else if (option.equals("2")) {
            String i = "Sucursal";
            System.out.println("Cual de las acciones quiere realizar");
            System.out.println("Escoja una opcion:");
            System.out.println("1. Ver " + i + "es");
            System.out.println("2. Crear " + i);
            System.out.println("3. Editar " + i);
            System.out.println("4. Eliminar " + i);
            System.out.println("0. Cancelar " + i);
            String option1;
            option1 = input.next();
            if (option1.equals("1")) {
                VSucursal();
            } else if (option1.equals("2")) {
                CSucursal();
            } else if (option1.equals("3")) {
                ESucursal();
            } else if (option1.equals("4")) {
                ELSucursal();
            } else {
                return;
            }
        } else if (option.equals("3")) {
            String i = "Especialidad";
            System.out.println("Cual de las acciones quiere realizar");
            System.out.println("Escoja una opcion:");
            System.out.println("1. Ver " + i + "es");
            System.out.println("2. Crear " + i);
            System.out.println("3. Editar " + i);
            System.out.println("4. Eliminar " + i);
            System.out.println("0. Cancelar " + i);
            String option1;
            option1 = input.next();
            if (option1.equals("1")) {
                VEspecialidad();
            } else if (option1.equals("2")) {
                CEspecialidad();
            } else if (option1.equals("3")) {
                EEspecialidad();
            } else if (option1.equals("4")) {
                ELEspecialidad();
            } else {
                return;
            }
        } else if (option.equals("4")) {
            String i = "Contrato de arriendo";
            System.out.println("Cual de las acciones quiere realizar");
            System.out.println("Escoja una opcion:");
            System.out.println("1. Ver " + i + "s");
            System.out.println("2. Crear " + i);
            System.out.println("3. Editar " + i);
            System.out.println("4. Eliminar " + i);
            System.out.println("0. Cancelar " + i);
            String option1;
            option1 = input.next();
            if (option1.equals("1")) {
                VContratoArriendo();
            } else if (option1.equals("2")) {
                CContratoArriendo();
            } else if (option1.equals("3")) {
                EContratoArriendo();
            } else if (option1.equals("4")) {
                ELContratoArriendo();
            } else {
                return;
            }
        } else if (option.equals("5")) {
            String i = "Repartidor";
            System.out.println("Cual de las acciones quiere realizar");
            System.out.println("Escoja una opcion:");
            System.out.println("1. Ver " + i + "es");
            System.out.println("2. Crear " + i);
            System.out.println("3. Editar " + i);
            System.out.println("4. Eliminar " + i);
            System.out.println("0. Cancelar " + i);
            String option1;
            option1 = input.next();
            if (option1.equals("1")) {
                VRepartidor();
            } else if (option1.equals("2")) {
                CRepartidor();
            } else if (option1.equals("3")) {
                ERepartidor();
            } else if (option1.equals("4")) {
                ELRepartidor();
            } else {
                return;
            }
        } else if (option.equals("6")) {
            String i = "Tipo de entrega";
            System.out.println("Cual de las acciones quiere realizar");
            System.out.println("Escoja una opcion:");
            System.out.println("1. Ver " + i + "s");
            System.out.println("2. Crear " + i);
            System.out.println("3. Editar " + i);
            System.out.println("4. Eliminar " + i);
            System.out.println("0. Cancelar " + i);
            String option1;
            option1 = input.next();
            if (option1.equals("1")) {
                VTipoEntrega();
            } else if (option1.equals("2")) {
                CTipoEntrega();
            } else if (option1.equals("3")) {
                ETipoEntrega();
            } else if (option1.equals("4")) {
                ELTipoEntrega();
            } else {
                return;
            }
        } else if (option.equals("7")) {
            String i = "Entrega";
            System.out.println("Cual de las acciones quiere realizar");
            System.out.println("Escoja una opcion:");
            System.out.println("1. Ver " + i + "s");
            System.out.println("2. Crear " + i);
            System.out.println("3. Editar " + i);
            System.out.println("4. Eliminar " + i);
            System.out.println("0. Cancelar " + i);
            String option1;
            option1 = input.next();
            if (option1.equals("1")) {
                VEntrega();
            } else if (option1.equals("2")) {
                CEntrega();
            } else if (option1.equals("3")) {
                EEntrega();
            } else if (option1.equals("4")) {
                ELEntrega();
            } else {
                return;
            }
        } else if (option.equals("8")) {
            String i = "Cliente";
            System.out.println("Cual de las acciones quiere realizar");
            System.out.println("Escoja una opcion:");
            System.out.println("1. Ver " + i + "s");
            System.out.println("2. Crear " + i);
            System.out.println("3. Editar " + i);
            System.out.println("4. Eliminar " + i);
            System.out.println("0. Cancelar " + i);
            String option1;
            option1 = input.next();
            if (option1.equals("1")) {
                VCliente();
            } else if (option1.equals("2")) {
                CCliente();
            } else if (option1.equals("3")) {
                ECliente();
            } else if (option1.equals("4")) {
                ELCliente();
            } else {
                return;
            }
        } else if (option.equals("9")) {
            String i = "Contrato Repartidores";
            System.out.println("Cual de las acciones quiere realizar");
            System.out.println("Escoja una opcion:");
            System.out.println("1. Ver " + i + "s");
            System.out.println("2. Crear " + i);
            System.out.println("3. Editar " + i);
            System.out.println("4. Eliminar " + i);
            System.out.println("0. Cancelar " + i);
            String option1;
            option1 = input.next();
            if (option1.equals("1")) {
                VContratoRepartidores();
            } else if (option1.equals("2")) {
                CContratoRepartidores();
            } else if (option1.equals("3")) {
                EContratoRepartidores();
            } else if (option1.equals("4")) {
                ELContratoRepartidores();
            } else {
                return;
            }
        } else {
            return;
        }
    }
    //************************** CRUD EMPRESA ***********************
    public static void VEmpresa(){
        if (empresas.size() == 0) {
            System.out.println("La lista esta vacia");
            return;
        } else {
            System.out.println(empresas.toString());
        }
    }
    public static void CEmpresa(){
        input.nextLine(); // importante
        System.out.println("Ingrese el nit de la nueva empresa: ");
        String nit =input.nextLine();

        for (Empresa empresa : empresas) {
            if (empresa.Nit.equals(nit) ) {
                System.out.println("Ingresaste un nit que ya esta registrado");
                return;
            }
        }
        System.out.println("Ingrese la razon social de la empresa: ");
        String razonsocial =input.nextLine();
        System.out.println("Ingrese el presidente de la empresa: ");
        String presidente = input.nextLine();

        Empresa nuevaEmpresa = new Empresa(nit,razonsocial,presidente);
        empresas.add(nuevaEmpresa);
        System.out.println("Empresa ingresada correctamente!");

    }
    public static void EEmpresa(){
        // mostar primeros los NIT
        System.out.println("Acontinuacion se muestra una lista de nits de las empresas: ");
        for (Empresa empresa : empresas) {
            System.out.println(empresa.Nit);
        }
        input.nextLine();
        System.out.println("Ingrese el Nit de la empresa a modificar: ");
        String nit = input.nextLine();
        Iterator<Empresa> iterator = empresas.listIterator();
        while (iterator.hasNext()){
            Empresa empresa = iterator.next();
            if (empresa.Nit.equals(nit)){
                System.out.println("Que deseas modificar: ");
                System.out.println("1. Nit ");
                System.out.println("2. Razon social ");
                System.out.println("3. Presidente ");
                String option;
                option = input.next();
                if (option.equals("1")) {
                    input.nextLine();
                    System.out.println("Ingrese el nuevo Nit:");
                    String x = input.nextLine();
                    empresa.Nit=x;
                    System.out.println("Nit modificado satisfactoriamente");
                    break;
                }else if (option.equals("2")) {
                    input.nextLine();
                    System.out.println("Ingrese la nueva razon social:");
                    String x = input.nextLine();
                    empresa.RazonSocial=x;
                    System.out.println("Razon social modificada satisfactoriamente");
                    break;
                }else if (option.equals("3")) {
                    input.nextLine();
                    System.out.println("Ingrese el nuevo Presidente:");
                    String x = input.nextLine();
                    empresa.Presidente = x;
                    System.out.println("Presidente modificado satisfactoriamente");
                    break;
                }
            }
        }
    }
    public static void ELEmpresa(){
        input.nextLine();
        System.out.println("Ingrese el nit de la empresa a eliminar: ");
        String nit = input.nextLine();

        for (int i = 0; i < empresas.size(); i++) {
            if (empresas.get(i).Nit.equals(nit)) {
                empresas.remove(i);
                System.out.println("¡ Se realizo la operacion correctamente !");
                return;
            }
        }
        System.out.println("No fue encontrado");
    }
    // ************************************* CRUD sucursal *************
    public static void VSucursal() {
        if (sucursales.size() == 0) {
            System.out.println("La lista esta vacia");
            return;
        } else {
            System.out.println(sucursales.toString());
        }
    }
    public static void CSucursal() {
        System.out.println("Ingrese el Codigo de la nueva sucursal: ");
        int codigosucursal=input.nextInt();
        if(codigosucursal<0){
            System.out.println("El numero ingresado es invalido, seras regresado al menu anterior");
            return;
        }
        for (Sucursal sucursal : sucursales) {
            if (sucursal.codigoScursal==codigosucursal ) {
                System.out.println("Ingresaste un codigo que ya esta registrado");
                return;
            }
        }
        System.out.println("Ingrese la Ciudad de la sucursal: ");
        input.nextLine();
        String ciudad =input.nextLine();
        System.out.println("Ingrese la direccion de la sucursal: ");
        String direccion = input.nextLine();
        System.out.println("Ingrese la cantidad de empleados de la nueva sucursal: ");
        int cantidadempleados =input.nextInt();
        if(cantidadempleados<0){
            System.out.println("El numero ingresado es invalido, seras regresado al menu anterior");
            return;
        }
        input.nextLine();
        System.out.println("Ingrese el Nit de la empresa a la que pertenece esta sucursal");
        String Nit = input.nextLine();
        Empresa empresa = null;
        for (Empresa empresa1 : empresas) {
            if(empresa1.Nit.equals(Nit) ){
                empresa = empresa1;
                break;
            }
        }   if(empresa == null){
            System.out.println("El Nit no fue encontrado");
            return;
        }

        Sucursal sucursal = new Sucursal(codigosucursal, ciudad, direccion, cantidadempleados, empresa);
        sucursales.add(sucursal);
        EscribirJSON.guardarSucursal(sucursales);
        System.out.println("Sucusal ingresada");
    }
    public static void ESucursal() {
        // mostar primeros los codigos
        System.out.println("Acontinuacion se muestra una lista de codigo de las sucursales: ");
        for (Sucursal sucursa : sucursales) {
            System.out.println(sucursa.codigoScursal);
        }
        System.out.println("Ingrese el codigo de la sucursal a modificar: ");
        int n = input.nextInt();
        Iterator<Sucursal> iterador = sucursales.listIterator();
        while (iterador.hasNext()) {
            Sucursal sucursal = iterador.next();
            if (sucursal.codigoScursal==n){
                System.out.println("Que deseas modificar: ");
                System.out.println("1. Codigo ");
                System.out.println("2. Ciudad ");
                System.out.println("3. Direccion ");
                System.out.println("4. Cantidad de empleados ");
                String option;
                option = input.next();
                if (option.equals("1")) {
                    System.out.println("Ingrese el nuevo Codigo:");
                    int x = input.nextInt();
                    if (x<0){
                        System.out.println("Numero invalido, seras regresado al menu anterior");
                        return;
                    }
                    sucursal.codigoScursal=x;
                    System.out.println("Codigo modificado satisfactoriamente");
                    break;
                }else if (option.equals("2")) {
                    input.nextLine();
                    System.out.println("Ingrese la nueva ciudad:");
                    String x = input.nextLine();
                    sucursal.ciudad=x;
                    System.out.println("Razon social modificada satisfactoriamente");
                    break;
                }else if (option.equals("3")) {
                    input.nextLine();
                    System.out.println("Ingrese la nueva direccion:");
                    String x = input.nextLine();
                    sucursal.direccion = x;
                    System.out.println("Direccion modificada satisfactoriamente");
                    break;
                }else if (option.equals("4")) {
                    System.out.println("Ingrese la nueva cantidad de empleados");
                    int x = input.nextInt();
                    if (x<0){
                        System.out.println("Numero invalido, seras regresado al menu anterior");
                        return;
                    }
                    sucursal.cantEmpleados=x;
                    System.out.println("Cantidad de empleados modificado satisfactoriamente");
                    break;
                }
            }
        }
    }
    public static void ELSucursal(){
        System.out.println("ingrese el Codigo de la sucursal a eliminar: ");
        int x = input.nextInt();
        for (int i = 0; i < sucursales.size(); i++) {
            if (sucursales.get(i).codigoScursal == x) {
                sucursales.remove(i);
                System.out.println("¡ Se realizo la operacion correctamente !");
                return;
            }
        }
        System.out.println("No fue encontrado");
    }
    //************************** CRUD ESPECIALIAD ***********************
    public static void VEspecialidad() {
        if (especialidades.size() == 0) {
            System.out.println("La lista esta vacia");
            return;
        } else {
            System.out.println(especialidades.toString());
        }
    }
    public static void CEspecialidad() {
        System.out.println("Ingrese el Codigo de la nueva especialidad: ");
        int codigo=input.nextInt();
        if(codigo<0){
            System.out.println("El numero ingresado es invalido, seras regresado al menu anterior");
            return;
        }
        for (Especialidad especialidad : especialidades) {
            if (especialidad.codigoEspecialidad==codigo ) {
                System.out.println("Ingresaste un codigo que ya esta registrado");
                return;
            }
        }
        input.nextLine();
        System.out.println("Ingrese la Encargado de la especialidad: ");
        String encargado =input.nextLine();
        System.out.println("Ingrese la Enfoque de la especialidad: ");
        String enfoque = input.nextLine();
        System.out.println("Ingrese la Linea de atencion de la especialidad: ");
        int lineaatencion =input.nextInt();
        if( lineaatencion<0){
            System.out.println("El numero ingresado es invalido, seras regresado al menu anterior");
            return;
        }

        System.out.println("Ingrese el código de la sucursal a la cual pertenece esta especialidad");
        int codigoScursal = input.nextInt();

        Sucursal sucursal = null;
        for (Sucursal sucursal1 : sucursales) {
            if(sucursal1.codigoScursal == codigoScursal ){
                sucursal = sucursal1;
                break;
            }
        }

        if(sucursal == null){
            System.out.println("La sucursal no fue encontrada");
            return;
        }

        Especialidad especialidad = new Especialidad(codigo,encargado,enfoque,lineaatencion, sucursal);
        especialidades.add(especialidad);
        System.out.println("Especialidad ingresada");
    }
    public static void EEspecialidad() {
        // mostar primeros los codigos
        System.out.println("Acontinuacion se muestra una lista de codigo de las especialidades: ");
        for (Especialidad especiali : especialidades) {
            System.out.println(especiali.codigoEspecialidad);
        }
        System.out.println("Ingrese el codigo de la especialidad a modificar: ");
        int n = input.nextInt();
        Iterator<Especialidad> iterador = especialidades.listIterator();
        while (iterador.hasNext()) {
            Especialidad especialidad = iterador.next();
            if (especialidad.codigoEspecialidad==n){
                System.out.println("Que deseas modificar: ");
                System.out.println("1. Codigo ");
                System.out.println("2. Encargado ");
                System.out.println("3. Enfoque ");
                System.out.println("4. Linea de atencion ");
                String option;
                option = input.next();
                if (option.equals("1")) {
                    System.out.println("Ingrese el nuevo Codigo:");
                    int x = input.nextInt();
                    if (x<0){
                        System.out.println("Numero invalido, seras regresado al menu anterior");
                        return;
                    }
                    especialidad.codigoEspecialidad=x;
                    System.out.println("Codigo modificado satisfactoriamente");
                    break;
                }else if (option.equals("2")) {
                    input.nextLine();
                    System.out.println("Ingrese nuevo encargado:");
                    String x = input.nextLine();
                    especialidad.encargado=x;
                    System.out.println("Encargado modificada satisfactoriamente");
                    break;
                }else if (option.equals("3")) {
                    input.nextLine();
                    System.out.println("Ingrese nuevo enfoque:");
                    String x = input.nextLine();
                    especialidad.enfoque = x;
                    System.out.println("Enfoque modificada satisfactoriamente");
                    break;
                }else if (option.equals("4")) {
                    System.out.println("Ingrese nueva linea de atencion");
                    int x = input.nextInt();
                    if (x<0){
                        System.out.println("Numero invalido, seras regresado al menu anterior");
                        return;
                    }
                    especialidad.lineaAtencion=x;
                    System.out.println("Linea de atencion modificado satisfactoriamente");
                    break;
                }
            }
        }
    }
    public static void ELEspecialidad() {
        System.out.println("Ingrese el codigo de la especialidad a eliminar: ");
        int x = input.nextInt();
        for (int i = 0; i < especialidades.size(); i++) {
            if (especialidades.get(i).codigoEspecialidad == x) {
                especialidades.remove(i);
                System.out.println("¡ Se realizo la operacion correctamente !");
                return;
            }
        }
        System.out.println("No fue encontrado");
    }
    //************************** CRUD Contrato ***********************
    public static void VContratoArriendo() {
        if (contratoArriendos.size() == 0) {
            System.out.println("La lista esta vacia");
            return;
        } else {
            System.out.println(contratoArriendos.toString());
        }
    }
    public static void CContratoArriendo() {
        System.out.println("Ingrese el numero de contrato de arriendo nuevo: ");
        int x=input.nextInt();
        if(x<0){
            System.out.println("El numero ingresado es invalido, seras regresado al menu anterior");
            return;
        }
        for (ContratoArriendo contratoArriendo : contratoArriendos) {
            if (contratoArriendo.numContrato==x ) {
                System.out.println("Ingresaste un numero de contrato que ya esta registrado");
                return;
            }
        }
        input.nextLine();
        System.out.println("Ingrese la fecha de inicio del contrato de arriendo: ");
        String y=input.nextLine();
        System.out.println("Ingrese la fecha de fin del contrato de arriendo: ");
        String z=input.nextLine();
        System.out.println("Ingrese el canon del contrato de arriendo: ");
        int w=input.nextInt();
        if(w<0){
            System.out.println("El numero ingresado es invalido, seras regresado al menu anterior");
            return;
        }
        System.out.println("Ingrese el código de la sucursal a la cual pertenece esta especialidad");
        int codigoScursal = input.nextInt();

        Sucursal sucursal = null;
        for (Sucursal sucursal1 : sucursales) {
            if(sucursal1.codigoScursal == codigoScursal ){
                sucursal = sucursal1;
                break;
            }
        }

        if(sucursal == null){
            System.out.println("La sucursal no fue encontrada");
            return;
        }
        ContratoArriendo contratoArriendo = new ContratoArriendo(x,y,z,w,sucursal);
        contratoArriendos.add(contratoArriendo);
        System.out.println("Contrato de arriendo ingresada");
    }
    public static void EContratoArriendo() {
        // mostar primeros los codigos
        System.out.println("Acontinuacion se muestra una lista de los numeros de contreto de ariiendo: ");
        for (ContratoArriendo contratoArrie : contratoArriendos) {
            System.out.println(contratoArrie.numContrato);
        }
        System.out.println("Ingrese el numero del contrato a modificar: ");
        int nit = input.nextInt();
        Iterator<ContratoArriendo> iterador = contratoArriendos.listIterator();
        while (iterador.hasNext()) {
            ContratoArriendo contratoArriendo = iterador.next();
            if (contratoArriendo.numContrato == nit) {
                System.out.println("Que deseas modificar: ");
                System.out.println("1. Numero de contrato ");
                System.out.println("2. Fecha de inicio ");
                System.out.println("3. Fecha de fin ");
                System.out.println("4. Canon ");
                String option;
                option = input.next();
                if (option.equals("1")) {
                    System.out.println("Ingrese el nuevo numero de contrato:");
                    int x = input.nextInt();
                    if (x < 0) {
                        System.out.println("Numero invalido, seras regresado al menu anterior");
                        return;
                    }
                    contratoArriendo.numContrato = x;
                    System.out.println("Numero de contrato modificado satisfactoriamente");
                    break;
                }else if (option.equals("2")) {
                    input.nextLine();
                    System.out.println("Ingrese nueva fecha de inicio");
                    String x = input.nextLine();
                    contratoArriendo.fechadeInicio=x;
                    System.out.println("Fecha de inicio modificado satisfactoriamente");
                    break;
                }else if (option.equals("3")) {
                    input.nextLine();
                    System.out.println("Ingrese nueva fecha de fin");
                    String x = input.nextLine();
                    contratoArriendo.FechadeFin = x;
                    System.out.println("Fecha de fin modificado satisfactoriamente");
                    break;
                }else if (option.equals("4")) {
                    System.out.println("Ingrese nueva canon");
                    int x = input.nextInt();
                    if (x<0){
                        System.out.println("Numero invalido, seras regresado al menu anterior");
                        return;
                    }
                    contratoArriendo.canon=x;
                    System.out.println("Canon modificado satisfactoriamente");
                    break;
                }
            }
        }
    }
    public static void ELContratoArriendo() {
        System.out.println("Ingrese el numero del contrato a elinimar: ");
        int x = input.nextInt();
        for (int i = 0; i < contratoArriendos.size(); i++) {
            if (contratoArriendos.get(i).numContrato == x) {
                contratoArriendos.remove(i);
                System.out.println("¡ Se realizo la operacion correctamente !");
                return;
            }
        }
        System.out.println("No fue encontrado");
    }
    //************************** CRUD TIPOENTREGA ***********************
    public static void VTipoEntrega() {
        if (tipoDeEntregas.size() == 0) {
            System.out.println("La lista esta vacia");
            return;
        } else {
            System.out.println(tipoDeEntregas.toString());
        }
    }
    public static void CTipoEntrega() {
        System.out.println("Ingrese el Codigo del tipo de entrega: ");
        int x=input.nextInt();
        if(x<0){
            System.out.println("El numero ingresado es invalido, seras regresado al menu anterior");
            return;
        }
        for (TipoDeEntrega tipoDeEntrega: tipoDeEntregas) {
            if (tipoDeEntrega.Codigo ==x ) {
                System.out.println("Ingresaste un tipo de entrega que ya esta registrado");
                return;
            }
        }
        System.out.println("Ingrese el tiempo estimado del tipo de entrega: ");
        int w=input.nextInt();
        if(w<0){
            System.out.println("El numero ingresado es invalido, seras regresado al menu anterior");
            return;
        }
        input.nextLine();
        System.out.println("Ingrese medio de transporte del tipo de entrega: ");
        String y=input.nextLine();

        TipoDeEntrega tipoDeEntrega = new TipoDeEntrega(x,w,y);
        tipoDeEntregas.add(tipoDeEntrega);
        System.out.println("Tipo de entrega ingresada");
    }
    public static void ETipoEntrega() {
        // mostar primeros los codigos
        System.out.println("Acontinuacion se muestra una lista de codigo de los tipo de entrega: ");
        for (TipoDeEntrega tipoDeEnt  : tipoDeEntregas) {
            System.out.println(tipoDeEnt.Codigo);
        }
        System.out.println("Ingrese Codigo del tipo de entrega a modificar: ");
        int n = input.nextInt();
        Iterator<TipoDeEntrega> iterador = tipoDeEntregas.listIterator();
        while (iterador.hasNext()) {
            TipoDeEntrega tipoDeEntrega = iterador.next();
            if (tipoDeEntrega.Codigo == n) {
                System.out.println("Que deseas modificar: ");
                System.out.println("1. Tiempo estimado ");
                String option;
                option = input.next();
                if (option.equals("1")) {
                    System.out.println("Ingrese nueva tiempo de entrega:");
                    int x = input.nextInt();
                    if (x < 0) {
                        System.out.println("Numero invalido, seras regresado al menu anterior");
                        return;
                    }
                    tipoDeEntrega.Tiempo_Estimado = x;
                    System.out.println("Timepo de entrega modificado satisfactoriamente");
                    break;
                }
            }
        }
    }
    public static void ELTipoEntrega() {
        System.out.println("Ingrese el codigo del tipo de entrega  a elinimar: ");
        int x = input.nextInt();
        for (int i = 0; i < tipoDeEntregas.size(); i++) {
            if (tipoDeEntregas.get(i).Codigo== x) {
                tipoDeEntregas.remove(i);
                System.out.println("¡ Se realizo la operacion correctamente !");
                return;
            }
        }
        System.out.println("No fue encontrado");
    }
    //************************** CRUD REPARTIDOR ***********************
    public static void VRepartidor() {
        if (repartidores.size() == 0) {
            System.out.println("La lista esta vacia");
            return;
        } else {
            System.out.println(repartidores.toString());
        }
    }
    public static void CRepartidor() {
        System.out.println("Ingrese la cedula del repartidor: ");
        int x=input.nextInt();
        if(x<0){
            System.out.println("El numero ingresado es invalido, seras regresado al menu anterior");
            return;
        }
        for (Repartidor repartidor: repartidores) {
            if (repartidor.Cedula ==x ) {
                System.out.println("Ingresaste un cedula  que ya esta registrado");
                return;
            }
        }
        input.nextLine();
        System.out.println("Ingrese el nombre del repartidor: ");
        String y=input.nextLine();
        System.out.println("Ingrese la edad del repartidor: ");
        int a=input.nextInt();
        if(a<0){
            System.out.println("El numero ingresado es invalido, seras regresado al menu anterior");
            return;
        }
        System.out.println("Ingrese el numero celular del repartidor: ");
        int b=input.nextInt();
        if(b<0){
            System.out.println("El numero ingresado es invalido, seras regresado al menu anterior");
            return;
        }
        input.nextLine();
        System.out.println("Ingrese el tipo de licencia del repartidor: ");
        String z = input.nextLine();

        Repartidor repartidor = new Repartidor(x,y,a,b,z);
        repartidores.add(repartidor);
        System.out.println("Repartidor ingresado");
    }
    public static void ERepartidor() {
        // mostar primeros los codigos
        System.out.println("Acontinuacion se muestra una lista de las cedulas de los repartidores: ");
        for (Repartidor reparti  : repartidores) {
            System.out.println(reparti.Cedula);
        }
        System.out.println("Ingrese cedula del repartidor a modificar: ");
        int n = input.nextInt();
        Iterator<Repartidor> iterador = repartidores.listIterator();
        while (iterador.hasNext()) {
            Repartidor repartidor = iterador.next();
            if (repartidor.Cedula == n) {
                System.out.println("Que deseas modificar: ");
                System.out.println("1. Edad ");
                System.out.println("2. Numero de celular ");
                System.out.println("3. Tipo de licencia ");
                String option;
                option = input.next();
                if (option.equals("1")) {
                    System.out.println("Ingrese nueva edad:");
                    int x = input.nextInt();
                    if (x < 0) {
                        System.out.println("Numero invalido, seras regresado al menu anterior");
                        return;
                    }
                    repartidor.Edad = x;
                    System.out.println("Edad modificado satisfactoriamente");
                    break;
                }else if (option.equals("2")) {
                    System.out.println("Ingrese nueva numero de celular");
                    int x = input.nextInt();
                    if (x<0){
                        System.out.println("Numero invalido, seras regresado al menu anterior");
                        return;
                    }
                    repartidor.Num_Celular=x;
                    System.out.println("Numero celular modificado satisfactoriamente");
                    break;
                }else if (option.equals("3")) {
                    input.nextLine();
                    System.out.println("Ingrese nuevo tipo de licencia:");
                    String x = input.nextLine();
                    repartidor.Tipo_Licencia=x;
                    System.out.println("Tipo de licencia modificada satisfactoriamente");
                    break;
                }
            }
        }
    }
    public static void ELRepartidor() {
        System.out.println("Ingrese el codigo del tipo de entrega  a elinimar: ");
        int x = input.nextInt();
        for (int i = 0; i < repartidores.size(); i++) {
            if (repartidores.get(i).Cedula == x) {
                repartidores.remove(i);
                System.out.println("¡ Se realizo la operacion correctamente !");
                return;
            }
            System.out.println("No fue encontrado");
        }
    }
    //************************** CRUD ENTREGA ***********************
    public static void VEntrega() {
        if (entregas.size() == 0) {
            System.out.println("La lista esta vacia");
            return;
        } else {
            System.out.println(entregas.toString());
        }
    }
    public static void CEntrega(){
        System.out.println("Ingrese el Codigo de entrega: ");
        int a=input.nextInt();
        if(a<0){
            System.out.println("El numero ingresado es invalido, seras regresado al menu anterior");
            return;
        }
        for (Entrega entrega: entregas) {
            if (entrega.codEntrega ==a ) {
                System.out.println("Ingresaste un cedula  que ya esta registrado");
                return;
            }
        }
        System.out.println("Ingrese el peso de entrega: ");
        double b=input.nextInt();
        if(b<0){
            System.out.println("El numero ingresado es invalido, seras regresado al menu anterior");
            return;
        }
        System.out.println("Ingrese las dimenciones de entrega: ");
        int c=input.nextInt();
        if(c<0){
            System.out.println("El numero ingresado es invalido, seras regresado al menu anterior");
            return;
        }
        input.nextLine();
        System.out.println("la entrega es fragil: ");
        System.out.println("1. Si");
        System.out.println("2. No");
        String option = input.nextLine();
        boolean w;
        if (option.equals("1")){
            w=true;
        }else if (option.equals("2")){
            w=false;
        }else{
            System.out.println("Opcion no valida");
            return;
        }
        System.out.println("Ingrese el costo de entrega: ");
        double x=input.nextInt();
        if(x<0){
            System.out.println("El numero ingresado es invalido, seras regresado al menu anterior");
            return;
        }
        input.nextLine();
        System.out.println("Ingrese estado de la entrega: ");
        String y=input.nextLine();
        System.out.println("Ingrese el código de la especialidad que esta encargada de la entrega:");
        int codEspe = input.nextInt();
        Especialidad especialidad = null;
        for (Especialidad especialidad1 : especialidades) {
            if(especialidad1.codigoEspecialidad ==codEspe ){
                especialidad = especialidad1;
                break;
            }
        }
        if(especialidad == null){
            System.out.println("La especialidad no fue encontrada");
            return;
        }
        System.out.println("Ingrese el código del tipo de entrega que es:");
        int codTipo = input.nextInt();
        TipoDeEntrega tipoDeEntrega= null;
        for (TipoDeEntrega tipoDeEntrega1 : tipoDeEntregas) {
            if(tipoDeEntrega1.Codigo == codTipo ){
                tipoDeEntrega= tipoDeEntrega1;
                break;
            }
        }
        if(tipoDeEntrega == null){
            System.out.println("El tipo de entrega no fue encontrada");
            return;
        }
        System.out.println("Ingrese el documento del cliente al cual pertenece esta entrega:");
        int docCli = input.nextInt();
        Cliente cliente = null;
        for (Cliente cliente1 :clientes) {
            if(cliente1.Documento == docCli ){
                cliente = cliente1;
                break;
            }
        }
        if(cliente == null){
            System.out.println("El clientre no fue encontrada");
            return;
        }
        System.out.println("Ingrese la cedula del repartidor al cual le corresponde hacer entrega:");
        int cedRep = input.nextInt();
        Repartidor repartidor = null;
        for (Repartidor repartidor1 :repartidores) {
            if(repartidor1.Cedula == cedRep ){
                repartidor = repartidor1;
                break;
            }
        }
        if(repartidor == null){
            System.out.println("El repoertidor no fue encontrada");
            return;
        }
        Entrega entrega = new Entrega(a,b,c,w,x,y,especialidad,tipoDeEntrega,cliente,repartidor);
        entregas.add(entrega);
        System.out.println("Entrega ingresada");
    }
    public static void EEntrega() {
        // mostar primeros los codigos
        System.out.println("Acontinuacion se muestra una lista de los codigos  de los entrega: ");
        for (Entrega entre  : entregas) {
            System.out.println(entre.codEntrega);
        }
        System.out.println("Ingrese Codigo de entrega a modificar: ");
        int n = input.nextInt();
        Iterator<Entrega> iterador = entregas.listIterator();
        while (iterador.hasNext()) {
            Entrega entrega = iterador.next();
            if (entrega.codEntrega == n) {
                System.out.println("Que deseas modificar: ");
                System.out.println("1. Codigo ");
                String option;
                option = input.next();
                if (option.equals("1")) {
                    System.out.println("Ingrese nueva Codigo:");
                    int x = input.nextInt();
                    if (x < 0) {
                        System.out.println("Numero invalido, seras regresado al menu anterior");
                        return;
                    }
                    entrega.codEntrega = x;
                    System.out.println("Codigo modificado satisfactoriamente");
                    break;
                }
            }
        }
    }
    public static void ELEntrega() {
        System.out.println("ingrese el codigo del tipo de entrega  a elinimar: ");
        int x = input.nextInt();
        for (int i = 0; i < entregas.size(); i++) {
            if (entregas.get(i).codEntrega== x) {
                entregas.remove(i);
                System.out.println("¡ Se realizo la operacion correctamente !");
                return;
            }
        }
        System.out.println("No fue encontrado");
    }
    //************************** CRUD CLIENTE ***********************
    public static void VCliente() {
        if (clientes.size() == 0) {
            System.out.println("La lista esta vacia");
            return;
        } else {
            System.out.println(clientes.toString());
        }
    }
    public static void CCliente() {
        System.out.println("Ingrese el documento del cliente: ");
        int x=input.nextInt();
        if(x<0){
            System.out.println("El numero ingresado es invalido, seras regresado al menu anterior");
            return;
        }
        for (Cliente cliente : clientes) {
            if (cliente.Documento==x ) {
                System.out.println("Ingresaste un docuemento que ya esta registrado");
                return;
            }
        }
        input.nextLine();
        System.out.println("Ingrese el nombre del cliente: ");
        String y=input.nextLine();
        System.out.println("Ingrese la direccion del cliente: ");
        String z = input.nextLine();
        System.out.println("Ingrese el telefono del cliente: ");
        int a=input.nextInt();
        if(a<0){
            System.out.println("El numero ingresado es invalido, seras regresado al menu anterior");
            return;
        }
        System.out.println("Ingrese el codigo postal del cliente: ");
        int b=input.nextInt();
        if(b<0){
            System.out.println("El numero ingresado es invalido, seras regresado al menu anterior");
            return;
        }

        Cliente cliente = new Cliente(x,y,z,a,b);
        clientes.add(cliente);
        System.out.println("Cliente ingresada");
    }
    public static void ECliente() {
        // mostras docuemntos del clientes
        System.out.println("Acontinuacion se muestra una lista de documentos de los clientes: ");
        for (Cliente client: clientes) {
            System.out.println(client.Documento);
        }
        System.out.println("Ingrese Documento del cliente a modificar: ");
        int n = input.nextInt();
        Iterator<Cliente> iterador = clientes.listIterator();
        while (iterador.hasNext()) {
            Cliente cliente = iterador.next();
            if (cliente.Documento == n) {
                System.out.println("Que deseas modificar: ");
                System.out.println("1. Direccion ");
                System.out.println("2. Telefono ");
                System.out.println("3. Codigo postal ");
                String option;
                option = input.next();
                if (option.equals("1")) {
                    input.nextLine();
                    System.out.println("Ingrese nuevo Direccion:");
                    String x = input.nextLine();
                    cliente.Direccion=x;
                    System.out.println("Direccion modificada satisfactoriamente");
                    break;
                }else if (option.equals("2")) {
                    System.out.println("Ingrese nueva telefono");
                    int x = input.nextInt();
                    if (x<0){
                        System.out.println("Numero invalido, seras regresado al menu anterior");
                        return;
                    }
                    cliente.Telefono=x;
                    System.out.println("Telefono modificado satisfactoriamente");
                    break;
                }else if (option.equals("3")) {
                    System.out.println("Ingrese nueva Codigo postal");
                    int x = input.nextInt();
                    if (x<0){
                        System.out.println("Numero invalido, seras regresado al menu anterior");
                        return;
                    }
                    cliente.CodigoPostal=x;
                    System.out.println("Codigo postal modificado satisfactoriamente");
                    break;
                }
            }
        }
    }
    public static void ELCliente() {
        System.out.println("Ingrese el documento del cliente a elinimar: ");
        int x = input.nextInt();
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).Documento == x) {
                clientes.remove(i);
                System.out.println("¡ Se realizo la operacion correctamente !");
                return;
            }
        }
        System.out.println("No fue encontrado");
    }
    //************************** CRUD Contrato Repartidores ***********************
    public static void VContratoRepartidores() {
        if (contratorepartidores.size() == 0) {
            System.out.println("La lista esta vacia");
            return;
        } else {
            System.out.println(contratorepartidores.toString());
        }
    }
    public static void CContratoRepartidores() {
        System.out.println("Ingrese el numero del contrato del repartidor nuevo: ");
        int x=input.nextInt();
        if(x<0){
            System.out.println("El numero ingresado es invalido, seras regresado al menu anterior");
            return;
        }
        for (ContratoRepartidor contratoRepartidor : contratorepartidores) {
            if (contratoRepartidor.numerocontrato==x ) {
                System.out.println("Ingresaste un numero de contrato que ya esta registrado");
                return;
            }
        }
        System.out.println("Ingrese el salario del repartidor: ");
        int w=input.nextInt();
        if(w<0){
            System.out.println("El numero ingresado es invalido, seras regresado al menu anterior");
            return;
        }
        input.nextLine();
        System.out.println("Ingrese la fecha de inicio del contrato de repartidor: ");
        String y=input.nextLine();
        System.out.println("Ingrese la fecha de fin del contrato de repartidor: ");
        String z=input.nextLine();

        System.out.println("Ingrese el documento del repartidor al cual pertenece esta contrato");
        int documento = input.nextInt();

        Repartidor repartidor = null;
        for (Repartidor repartidor1 : repartidores) {
            if(repartidor1.Cedula == documento ){
                repartidor = repartidor1;
                break;
            }
        }

        if(repartidor == null){
            System.out.println("El repartidor no fue encontrada");
            return;
        }
        ContratoRepartidor contratoRepartidor = new ContratoRepartidor(x,w,y,z,repartidor);
        contratorepartidores.add(contratoRepartidor);
        System.out.println("Contrato de repartidor ingresada");

    }
    public static void EContratoRepartidores() {
        // mostar primeros los codigos
        System.out.println("Acontinuacion se muestra una lista de los numeros de contrato de los repartidores: ");
        for (ContratoRepartidor contratoRepar : contratorepartidores) {
            System.out.println(contratoRepar.numerocontrato);
        }
        System.out.println("Ingrese el numero del contrato a modificar: ");
        int nit = input.nextInt();
        Iterator<ContratoRepartidor> iterador = contratorepartidores.listIterator();
        while (iterador.hasNext()) {
            ContratoRepartidor contratoRepartidor = iterador.next();
            if (contratoRepartidor.numerocontrato == nit) {
                System.out.println("Que deseas modificar: ");
                System.out.println("1. Numero de contrato ");
                System.out.println("2. Salario ");
                System.out.println("3. Fecha de inicio ");
                System.out.println("4. Fecha de fin ");
                String option;
                option = input.next();
                if (option.equals("1")) {
                    System.out.println("Ingrese el nuevo numero de contrato:");
                    int x = input.nextInt();
                    if (x < 0) {
                        System.out.println("Numero invalido, seras regresado al menu anterior");
                        return;
                    }
                    contratoRepartidor.numerocontrato = x;
                    System.out.println("Numero de contrato modificado satisfactoriamente");
                    break;
                }else if (option.equals("3")) {
                    input.nextLine();
                    System.out.println("Ingrese nueva fecha de inicio");
                    String x = input.nextLine();
                    contratoRepartidor.fechainicio=x;
                    System.out.println("Fecha de inicio modificado satisfactoriamente");
                    break;
                }else if (option.equals("4")) {
                    input.nextLine();
                    System.out.println("Ingrese nueva fecha de fin");
                    String x = input.nextLine();
                    contratoRepartidor.fechafin = x;
                    System.out.println("Fecha de fin modificado satisfactoriamente");
                    break;
                }else if (option.equals("2")) {
                    System.out.println("Ingrese nueva salario");
                    int x = input.nextInt();
                    if (x<0){
                        System.out.println("Numero invalido, seras regresado al menu anterior");
                        return;
                    }
                    contratoRepartidor.salario=x;
                    System.out.println("Canon modificado satisfactoriamente");
                    break;
                }
            }
        }
    }
    public static void ELContratoRepartidores() {
        System.out.println("Ingrese el numero del contrato a elinimar: ");
        int x = input.nextInt();
        for (int i = 0; i < contratorepartidores.size(); i++) {
            if (contratorepartidores.get(i).numerocontrato == x) {
                contratorepartidores.remove(i);
                System.out.println("¡ Se realizo la operacion correctamente !");
                return;
            }
        }
        System.out.println("No fue encontrado");
    }
// aqui empieza el menu de BUSCAR ------------------------------------------------------------------
    public static void Busqueda() {
        System.out.println("Estos son los elementos posibles a Buscar");
        System.out.println("Escoja una opcion:");
        System.out.println("1. Empresas");
        System.out.println("2. Sucursales");
        System.out.println("3. Especialidades");
        System.out.println("4. Contrato de arriendos");
        System.out.println("5. Repartidores");
        System.out.println("6. Tipo de entregas");
        System.out.println("7. Entregas");
        System.out.println("8. Clientes");
        System.out.println("9. Contrato de Repartidor");
        System.out.println("0. Cancelar");
        System.out.println();
        String option;
        option = input.next();

        // Busqueda Empresa .------------------------------------------------------------------
        if (option.equals("1")) {
            System.out.println("Los atributos que tiene la clase seleccionada");
            System.out.println("Escoja una opcion:");
            System.out.println("1. Nit");
            System.out.println("2. Razon social");
            System.out.println("3. Presidente");
            System.out.println("4. Mostrar todas las empresas");
            System.out.println("0. Cancelar");
            String option1;
            option1 = input.next();

            if (option1.equals("1")) { //Nit
                BusquedaEmpresa(option1);
            } else if (option1.equals("2")) { // Razon social
                BusquedaEmpresa(option1);
            } else if (option1.equals("3")) { // presidente
                BusquedaEmpresa(option1);
            } else if (option1.equals("4")) { // Mostrar todas las empresas***
                BusquedaEmpresa(option1);
            } else {
                return;
            }


        // Busqueda Sucursales  .------------------------------------------------------------------
        } else if (option.equals("2")) {
            System.out.println("Los atributos que tiene la clase seleccionada");
            System.out.println("Escoja una opcion:");
            System.out.println("1. Codigo");
            System.out.println("2. Ciudad");
            System.out.println("3. Direccion");
            System.out.println("4. Cantidad de empleados");
            System.out.println("5. Mostrar todas las sucursales");
            System.out.println("0. Cancelar");
            String option1;
            option1 = input.next();
            if (option1.equals("1")) {
                BusquedaSucursal(option1);
            } else if (option1.equals("2")) {
                BusquedaSucursal(option1);
            } else if (option1.equals("3")) {
                BusquedaSucursal(option1);
            } else if (option1.equals("4")) {
                BusquedaSucursal(option1);
            } else if (option1.equals("5")) {
                BusquedaSucursal(option1);
            } else {
                return;
            }

        // Busqueda Especialidades  ------------------------------------------------------------------
        } else if (option.equals("3")) {
            System.out.println("Los atributos que tiene la clase seleccionada");
            System.out.println("Escoja una opcion:");
            System.out.println("1. Codigo");
            System.out.println("2. Encargado");
            System.out.println("3. Enfoque");
            System.out.println("4. Linea de atencion");
            System.out.println("5. Mostrar todas las especialidades");
            System.out.println("0. Cancelar");
            String option1;
            option1 = input.next();
            if (option1.equals("1")) {
                BusquedaEspecialidad(option1);
            } else if (option1.equals("2")) {
                BusquedaEspecialidad(option1);
            } else if (option1.equals("3")) {
                BusquedaEspecialidad(option1);
            } else if (option1.equals("4")) {
                BusquedaEspecialidad(option1);
            } else if (option1.equals("5")) {
                BusquedaEspecialidad(option1);
            } else {
                return;
            }

        // Busqueda Contrato de arriendos  ------------------------------------------------------------------
        } else if (option.equals("4")) {
            System.out.println("Los atributos que tiene la clase seleccionada");
            System.out.println("Escoja una opcion:");
            System.out.println("1. Numero de contrato");
            System.out.println("2. Fecha de inicio");
            System.out.println("3. Fecha de finalizacion");
            System.out.println("4. Canon");
            System.out.println("5. Mostrar todos los contrato de arriendos");
            System.out.println("0. Cancelar");
            String option1;
            option1 = input.next();
            if (option1.equals("1")) {
                BusquedaContratoArriendo(option1);
            } else if (option1.equals("2")) {
                BusquedaContratoArriendo(option1);
            } else if (option1.equals("3")) {
                BusquedaContratoArriendo(option1);
            } else if (option1.equals("4")) {
                BusquedaContratoArriendo(option1);
            } else if (option1.equals("5")) {
                BusquedaContratoArriendo(option1);
            } else {
                return;
            }

        // Busqueda Repartidores --------------------------------------------------------------
        } else if (option.equals("5")) {
            System.out.println("Los atributos que tiene la clase seleccionada");
            System.out.println("Escoja una opcion:");
            System.out.println("1. Cedula");
            System.out.println("2. Nombre");
            System.out.println("3. Edad");
            System.out.println("4. Numero de celular");
            System.out.println("5. Tipo de licencia");
            System.out.println("6. Mostrar todos los Repartidores");
            System.out.println("0. Cancelar");
            String option1;
            option1 = input.next();
            if (option1.equals("1")) {
                BusquedaRepartidor(option1);
            } else if (option1.equals("2")) {
                BusquedaRepartidor(option1);
            } else if (option1.equals("3")) {
                BusquedaRepartidor(option1);
            } else if (option1.equals("4")) {
                BusquedaRepartidor(option1);
            } else if (option1.equals("5")) {
                BusquedaRepartidor(option1);
            } else if (option1.equals("6")) {
                BusquedaRepartidor(option1);
            } else if (option1.equals("0")) {
                return;
            } else{
                return;
            }


         // Busqueda Tipo de entregas --------------------------------------------------------------
        } else if (option.equals("6")) {
            System.out.println("Los atributos que tiene la clase seleccionada");
            System.out.println("Escoja una opcion:");
            System.out.println("1. Codigo");
            System.out.println("2. Tiempo estimado");
            System.out.println("3. Medio de transporte");
            System.out.println("4. Mostrar todos los tipo de entregas");
            System.out.println("0. Cancelar");
            String option1;
            option1 = input.next();
            if (option1.equals("1")) {
                BusquedaTipoDeEntrega(option1);
            } else if (option1.equals("2")) {
                BusquedaTipoDeEntrega(option1);
            } else if (option1.equals("3")) {
                BusquedaTipoDeEntrega(option1);
            } else if (option1.equals("4")) {
                BusquedaTipoDeEntrega(option1);
            } else {
                return;
            }


            // Busqueda entregas --------------------------------------------------------------
        } else if (option.equals("7")) {
            System.out.println("Los atributos que tiene la clase seleccionada");
            System.out.println("Escoja una opcion:");
            System.out.println("1. Codigo de entrega");
            System.out.println("2. Peso");
            System.out.println("3. Dimenciones");
            System.out.println("4. Costo");
            System.out.println("5. Estado de entrega");
            System.out.println("6" +
                    "" +
                    ". Mostrar todas las entregas");
            System.out.println("0. Cancelar");
            String option1;
            option1 = input.next();
            if (option1.equals("1")) {
                BusquedaEntrega(option1);
            } else if (option1.equals("2")) {
                BusquedaEntrega(option1);
            } else if (option1.equals("3")) {
                BusquedaEntrega(option1);
            } else if (option1.equals("4")) {
                BusquedaEntrega(option1);
            } else if (option1.equals("5")) {
                BusquedaEntrega(option1);
            } else {
                return;
            }

            // Busqueda Clientes --------------------------------------------------------------
        } else if (option.equals("8")) {
            System.out.println("Los atributos que tiene la clase seleccionada");
            System.out.println("Escoja una opcion:");
            System.out.println("1. Documento");
            System.out.println("2. Nombre");
            System.out.println("3. Direccion");
            System.out.println("4. Telefono");
            System.out.println("5. Codigo postal");
            System.out.println("6. Mostrar todos los clientes");
            System.out.println("0. Cancelar");
            String option1;
            option1 = input.next();
            if (option1.equals("1")) {
                BusquedaCliente(option1);
            } else if (option1.equals("2")) {
                BusquedaCliente(option1);
            } else if (option1.equals("3")) {
                BusquedaCliente(option1);
            } else if (option1.equals("4")) {
                BusquedaCliente(option1);
            } else if (option1.equals("5")) {
                BusquedaCliente(option1);
            } else {
                return;
            }

        // Busqueda Contrato de Repartidor --------------------------------------------------------------
        } else if (option.equals("9")){
            System.out.println("Los atributos que tiene la clase seleccionada");
            System.out.println("Escoja una opcion:");
            System.out.println("1. numero de contrato");
            System.out.println("2. salario ");
            System.out.println("3. fecha de inicio");
            System.out.println("4. fecha de fin");
            System.out.println("0. Cancelar");
            String option1;
            option1 = input.next();
            if (option1.equals("1")) {
                BusquedaContratoRepartidor(option1);
            } else if (option1.equals("2")) {
                BusquedaContratoRepartidor(option1);
            } else if (option1.equals("3")) {
                BusquedaContratoRepartidor(option1);
            } else if (option1.equals("4")) {
                BusquedaContratoRepartidor(option1);
            } else if (option1.equals("5")) {
                BusquedaContratoRepartidor(option1);
            } else {
                return;
            }

        }else{
            return;
        }
    }


    // Diagnostico de incosistencias -------------------------------------------------------------------
    public static void DiagnosticoInconsistencias() {
        LinkedList<Empresa> empre = new LinkedList<>();
        for (int i = 0; i < empresas.size(); i++) {
            for (int j = 0; j < sucursales.size(); j++) {
                if (empresas.get(i).Nit.equals(sucursales.get(j).empresa.Nit)) {
                    break;
                } else {
                    if (j == (sucursales.size() - 1)) {
                        empre.add(empresas.get(i));
                    }
                }
            }
        }
        System.out.println("Empresas que no tiene sucursales----------------------");
        System.out.println(empre.toString());
        LinkedList<Sucursal> sucurCon = new LinkedList<>();
        for (int i = 0; i < sucursales.size(); i++) {
            for (int j = 0; j < contratoArriendos.size(); j++) {
                if (sucursales.get(i).codigoScursal == contratoArriendos.get(j).sucursal.codigoScursal) {
                    break;
                } else {
                    if (j == (contratoArriendos.size() - 1)) {
                        sucurCon.add(sucursales.get(i));
                    }
                }
            }
        }
        System.out.println("Sucursales que no tiene contrato de arrendamiento----------------------");
        System.out.println(sucurCon.toString());
        LinkedList<Sucursal> sucurEspe = new LinkedList<>();
        for (int i = 0; i < sucursales.size(); i++) {
            for (int j = 0; j < especialidades.size(); j++) {
                if (sucursales.get(i).codigoScursal == especialidades.get(j).sucursal.codigoScursal) {
                    break;
                } else {
                    if (j == (especialidades.size() - 1)) {
                        sucurEspe.add(sucursales.get(i));
                    }
                }
            }
        }
        System.out.println("Sucursales que no tiene especialidad----------------------");
        System.out.println(sucurEspe.toString());
        LinkedList<Repartidor> repar = new LinkedList<>();
        for (int i = 0; i < repartidores.size(); i++) {
            for (int j = 0; j < contratorepartidores.size(); j++) {
                if (repartidores.get(i).Cedula == contratorepartidores.get(j).repartidor.Cedula) {
                    break;
                } else {
                    if (j == (contratorepartidores.size() - 1)) {
                        repar.add(repartidores.get(i));
                    }
                }
            }

        }
        System.out.println("Repartidor que no tiene contrato----------------------");
        System.out.println(repar.toString());
        LinkedList<TipoDeEntrega> tipod = new LinkedList<>();
        for (int i = 0; i < tipoDeEntregas.size(); i++) {
            for (int j = 0; j < entregas.size(); j++) {
                if (tipoDeEntregas.get(i).Codigo ==entregas.get(j).tipoDeEntrega.Codigo) {
                    break;
                } else {
                    if (j == (entregas.size() - 1)) {
                        tipod.add(tipoDeEntregas.get(i));
                    }
                }
            }
        }
        System.out.println("Tipo de entrega no tiene entrega----------------------");
        System.out.println(tipod.toString());
    }

    // Funcion para guardar all (lo que hay en la sesion)
    public static void Guardar() {
        EscribirJSON.guardarUsuario(RegistrosUsuarios);
        EscribirJSON.guardarEmpresa(empresas);
        EscribirJSON.guardarContratoArriendo(contratoArriendos);
        EscribirJSON.guardarSucursal(sucursales);
        EscribirJSON.guardarEspecialida(especialidades);
        EscribirJSON.guardarTipoDeEntrega(tipoDeEntregas);
        EscribirJSON.guardarCliente(clientes);
        EscribirJSON.guardarContratoRepartidor(contratorepartidores);
        EscribirJSON.guardarRepartidor(repartidores);
        EscribirJSON.guardarEntrega(entregas);
        System.out.println("Se han guardado satisfactoriamente todos los datos de esta sesión");
    }


    public static void SalirCancelar() {
        while (true) {
            System.out.println("Si sale se perderán los cambios sin guardar:");
            System.out.println("Y. Si");
            System.out.println("N. NO");
            String option1;
            option1 = input.next();
            if (option1.equals("Y")||option1.equals("y")) {
                System.exit(0);
            } else if (option1.equals("N") || option1.equals("n")) {
                MenuPrincipal();
            }
        }
    }



    // BUSQUEDAS ****************************************************************************
    public static void BusquedaEmpresa(String option1){
        // NIt
        if (option1.equals("1")){
            System.out.println("Escoja una opcion:");
            System.out.println("1. Valor exacto");
            System.out.println("2. Valor sin considerar caracteres especiales para el Nit");
            System.out.println("0. Cancelar");
            String option2 = input.next();
            if (option2.equals("1")) {
                System.out.println("Ingrese el valor exacto del Nit");
                input.nextLine();
                String buscanit = input.nextLine();
                for (Empresa empresa : empresas) {
                    if (empresa.Nit.equals(buscanit)){
                        //imprimir empresa
                        System.out.println(empresa.toString());
                    }
                }

            } else if (option2.equals("2")) {
                System.out.println("Ingrese el valor sin caracteres especiales para el Nit");
                input.nextLine();
                String buscanit2 = input.nextLine();
                for (Empresa empresa : empresas) {
                    if (limpiarcadena(empresa.Nit).equals(limpiarcadena(buscanit2))){
                        //imprimir empresa
                        System.out.println(empresa.toString());
                    }
                }

            } else {
                return;
            }

            // Razon social
        }else if(option1.equals("2")){
            System.out.println("Escoja una opcion:");
            System.out.println("1. Valor exacto");
            System.out.println("2. Valor sin considerar mayúsculas ");
            System.out.println("0. Cancelar");
            String option2 = input.next();
            if (option2.equals("1")) {
                System.out.println("Ingrese el valor exacto del la razon social");
                input.nextLine();
                String razonsocial = input.nextLine();
                for (Empresa empresa : empresas) {
                    if (empresa.RazonSocial.equals(razonsocial)){
                        System.out.println(empresa.toString());
                    }
                }

            } else if (option2.equals("2")) {
                System.out.println("Ingrese la razon social sin considerar mayúsculas");
                input.nextLine();
                String razonsocial2 = input.nextLine();
                for (Empresa empresa : empresas) {
                    if (limpiarcadena(empresa.RazonSocial).equals(limpiarcadena(razonsocial2))){
                        //imprimir empresa
                        System.out.println(empresa.toString());
                    }
                }

            } else{
                return;
            }

        // Presidente
        }else if(option1.equals("3")){
            System.out.println("Escoja una opcion:");
            System.out.println("1. Valor exacto");
            System.out.println("2. Valor sin considerar mayúsculas ");
            System.out.println("0. Cancelar");
            String option2 = input.next();
            if (option2.equals("1")) {
                System.out.println("Ingrese el valor del presidente");
                input.nextLine();
                String presidente = input.nextLine();
                for (Empresa empresa : empresas) {
                    if (empresa.Presidente.equals(presidente)){
                        System.out.println(empresa.toString());
                    }
                }

            } else if (option2.equals("2")) {
                System.out.println("Ingrese el presidente sin considerar mayúsculas");
                input.nextLine();
                String Presidente = input.nextLine();
                for (Empresa empresa : empresas) {
                    if (limpiarcadena(empresa.Presidente).equals(limpiarcadena(Presidente))){
                        //imprimir empresa
                        System.out.println(empresa.toString());
                    }
                }

            } else if(option1.equals("4")){ // mostrar empresa
                if(empresas.size() == 0){
                    System.out.println("No hay empresas registradas");
                }else{
                    System.out.println(empresas.toString());
                }

            } else {
                return;
            }

        // Mostar las emresas
        } else if (option1.equals("4")){
            if (sucursales.size() == 0){
                System.out.println("No hay empresas registradas en el momento");
            }else{
                System.out.println(sucursales.toString());
            }
        }

    }

    // Busqueda Sucursales
    public static void BusquedaSucursal(String option1){
        // Codigo**************
        if (option1.equals("1")){
            System.out.println("Escoja una opcion:");
            System.out.println("1. Valor exacto");
            System.out.println("2. Valor mínimo");
            System.out.println("3. Valor máximo");
            System.out.println("4. Rango");
            String option2 = input.next();
            if (option2.equals("1")) {
                System.out.println("Ingrese el valor exacto"); // valor exacto
                input.nextLine();
                int busca = input.nextInt();
                for (Sucursal sucursal : sucursales) {
                    if (sucursal.codigoScursal == busca){
                        //imprimir empresa
                        System.out.println(sucursal.toString());
                    }
                }

            } else if (option2.equals("2")) { // valor minimo
                System.out.println("Ingrese el valor mínimo");
                input.nextLine();
                int busca = input.nextInt();
                System.out.println("Por cual atributo desea ordenar");
                System.out.println("1. Codigo de sucursal");
                System.out.println("2. Cantidad de empleados");
                String atriordena = input.next();
                System.out.println("De que manera desea ordenar");
                System.out.println("1. ascendente");
                System.out.println("2. descendente");
                String ordena = input.next();

                LinkedList<Sucursal> sucursalescopy = new LinkedList<>(sucursales);
                Collections.sort(sucursalescopy, new SucursalComparator(atriordena,ordena));
                for (Sucursal sucursale : sucursalescopy) {
                    if (sucursale.codigoScursal >= busca){
                        System.out.println(sucursale.toString());
                    }
                }


            } else if (option2.equals("3")){  // valor maximo
                System.out.println("Ingrese el valor máximo");
                input.nextLine();
                int busca = input.nextInt();
                System.out.println("Por cual atributo desea ordenar");
                System.out.println("1. Codigo de sucursal");
                System.out.println("2. Cantidad de empleados");
                String atriordena = input.next();
                System.out.println("De que manera desea ordenar");
                System.out.println("1. ascendente");
                System.out.println("2. descendente");
                String ordena = input.next();
                LinkedList<Sucursal> sucursalescopy = new LinkedList<>(sucursales);
                Collections.sort(sucursalescopy, new SucursalComparator(atriordena,ordena));
                for (Sucursal sucursale : sucursalescopy) {
                    if (sucursale.codigoScursal <= busca){
                        System.out.println(sucursale.toString());
                    }
                }

            } else if (option2.equals("4")){ // rango
                System.out.println("Ingrese valor minimo y el maximo del rango separado por espacio");
                input.nextLine();
                int busca1 = input.nextInt();
                int busca2 = input.nextInt();
                System.out.println("Por cual atributo desea ordenar");
                System.out.println("1. Codigo de sucursal");
                System.out.println("2. Cantidad de empleados");
                String atriordena = input.next();
                System.out.println("De que manera desea ordenar");
                System.out.println("1. ascendente");
                System.out.println("2. descendente");
                String ordena = input.next();

                LinkedList<Sucursal> sucursalescopy = new LinkedList<>(sucursales);
                Collections.sort(sucursalescopy, new SucursalComparator(atriordena,ordena));
                for (Sucursal sucursale : sucursalescopy) {
                    if ((sucursale.codigoScursal >= busca1) && (sucursale.codigoScursal <= busca2)){
                        System.out.println(sucursale.toString());
                    }
                }
            }


        // Ciudad
        } else if (option1.equals("2")){
            System.out.println("Escoja una opcion:");
            System.out.println("1. Valor exacto");
            System.out.println("2. Valor sin considerar mayúsculas");
            System.out.println("0. Cancelar");
            String option2 = input.next();
            if (option2.equals("1")) {
                System.out.println("Ingrese el valor exacto");
                input.nextLine();
                String busca = input.nextLine();
                for (Sucursal sucursal : sucursales) {
                    if (sucursal.ciudad.equals(busca)){
                        //imprimir empresa
                        System.out.println(sucursal.toString());
                    }
                }

            } else if (option2.equals("2")) {//**************************************
                System.out.println("Ingrese Valor sin considerar mayúsculas");
                input.nextLine();
                String busca = input.nextLine();
                for (Sucursal sucursal : sucursales) {
                    if (limpiarcadena(sucursal.ciudad).equals(limpiarcadena(busca))){
                        //imprimir empresa
                        System.out.println(sucursal.toString());
                    }
                }

            } else {
                return;
            }

            // Direccion
        } else if (option1.equals("3")){
            System.out.println("Escoja una opcion:");
            System.out.println("1. Valor exacto");
            System.out.println("2. Valor sin considerar mayúsculas");
            System.out.println("0. Cancelar");
            String option2 = input.next();
            if (option2.equals("1")) {
                System.out.println("Ingrese el valor exacto");
                input.nextLine();
                String busca = input.nextLine();
                for (Sucursal sucursal : sucursales) {
                    if (sucursal.direccion.equals(busca)){
                        //imprimir empresa
                        System.out.println(sucursal.toString());
                    }
                }

            } else if (option2.equals("2")) {//**************************************
                System.out.println("Ingrese Valor sin considerar mayúsculas");
                input.nextLine();
                String busca = input.nextLine();
                for (Sucursal sucursal : sucursales) {
                    if (limpiarcadena(sucursal.direccion).equals(limpiarcadena(busca))){
                        //imprimir empresa
                        System.out.println(sucursal.toString());
                    }
                }

            } else {
                return;
            }

           // Cantidad de Empleados
        } else if (option1.equals("3")) {
            System.out.println("Escoja una opcion:");
            System.out.println("1. Valor exacto");
            System.out.println("2. Valor mínimo");
            System.out.println("3. Valor máximo");
            System.out.println("4. Rango");
            String option2 = input.next();
            if (option2.equals("1")) {
                System.out.println("Ingrese el valor exacto"); // valor exacto
                input.nextLine();
                int busca = input.nextInt();
                for (Sucursal sucursal : sucursales) {
                    if (sucursal.cantEmpleados == busca){
                        //imprimir empresa
                        System.out.println(sucursal.toString());
                    }
                }

            } else if (option2.equals("2")) { // valor minimo
                System.out.println("Ingrese el valor mínimo");
                input.nextLine();
                int busca = input.nextInt();
                System.out.println("Por cual atributo desea ordenar");
                System.out.println("1. Codigo de sucursal");
                System.out.println("2. Cantidad de empleados");
                String atriordena = input.next();
                System.out.println("De que manera desea ordenar");
                System.out.println("1. ascendente");
                System.out.println("2. descendente");
                String ordena = input.next();

                LinkedList<Sucursal> sucursalescopy = new LinkedList<>(sucursales);
                Collections.sort(sucursalescopy, new SucursalComparator(atriordena,ordena));
                for (Sucursal sucursale : sucursalescopy) {
                    if (sucursale.cantEmpleados >= busca){
                        System.out.println(sucursale.toString());
                    }
                }


            } else if (option2.equals("3")){  // valor maximo
                System.out.println("Ingrese el valor máximo");
                input.nextLine();
                int busca = input.nextInt();
                System.out.println("Por cual atributo desea ordenar");
                System.out.println("1. Codigo de sucursal");
                System.out.println("2. Cantidad de empleados");
                String atriordena = input.next();
                System.out.println("De que manera desea ordenar");
                System.out.println("1. ascendente");
                System.out.println("2. descendente");
                String ordena = input.next();

                LinkedList<Sucursal> sucursalescopy = new LinkedList<>(sucursales);
                Collections.sort(sucursalescopy, new SucursalComparator(atriordena,ordena));
                for (Sucursal sucursale : sucursalescopy) {
                    if (sucursale.cantEmpleados <= busca){
                        System.out.println(sucursale.toString());
                    }
                }

            } else if (option2.equals("4")){ // rango
                System.out.println("Ingrese valor minimo y el maximo del rango separado por espacio");
                input.nextLine();
                int busca1 = input.nextInt();
                int busca2 = input.nextInt();
                System.out.println("Por cual atributo desea ordenar");
                System.out.println("1. Codigo de sucursal");
                System.out.println("2. Cantidad de empleados");
                String atriordena = input.next();
                System.out.println("De que manera desea ordenar");
                System.out.println("1. ascendente");
                System.out.println("2. descendente");
                String ordena = input.next();

                LinkedList<Sucursal> sucursalescopy = new LinkedList<>(sucursales);
                Collections.sort(sucursalescopy, new SucursalComparator(atriordena,ordena));
                for (Sucursal sucursale : sucursalescopy) {
                    if ((sucursale.cantEmpleados >= busca1) && (sucursale.cantEmpleados <= busca2)){
                        System.out.println(sucursale.toString());
                    }
                }
            }


        }

    }

    // Busqueda Especialidad
    public static void BusquedaEspecialidad(String option1){
        // Codigo**************
        if (option1.equals("1")){
            System.out.println("Escoja una opcion:");
            System.out.println("1. Valor exacto");
            System.out.println("2. Valor mínimo");
            System.out.println("3. Valor máximo");
            System.out.println("4. Rango");
            String option2 = input.next();
            if (option2.equals("1")) {
                System.out.println("Ingrese el valor exacto"); // valor exacto
                input.nextLine();
                int busca = input.nextInt();
                for (Especialidad especialidad : especialidades) {
                    if (especialidad.codigoEspecialidad == busca){
                        //imprimir empresa
                        System.out.println(especialidad.toString());
                    }
                }

            } else if (option2.equals("2")) { // valor minimo
                System.out.println("Ingrese el valor mínimo");
                input.nextLine();
                int busca = input.nextInt();
                System.out.println("Por cual atributo desea ordenar");
                System.out.println("1. Codigo de especialidad");
                System.out.println("2. Linea de atención");
                String atriordena = input.next();
                System.out.println("De que manera desea ordenar");
                System.out.println("1. ascendente");
                System.out.println("2. descendente");
                String ordena = input.next();

                LinkedList<Especialidad> especialidadescopy = new LinkedList<>(especialidades);
                Collections.sort(especialidadescopy, new EspecialidadComparator(atriordena,ordena));
                for (Especialidad especialidad : especialidadescopy) {
                    if (especialidad.codigoEspecialidad >= busca){
                        System.out.println(especialidad.toString());
                    }
                }


            } else if (option2.equals("3")){  // valor maximo
                System.out.println("Ingrese el valor máximo");
                input.nextLine();
                int busca = input.nextInt();
                System.out.println("Por cual atributo desea ordenar");
                System.out.println("1. Codigo de especialidad");
                System.out.println("2. Linea de atención");
                String atriordena = input.next();
                System.out.println("De que manera desea ordenar");
                System.out.println("1. ascendente");
                System.out.println("2. descendente");
                String ordena = input.next();

                LinkedList<Especialidad> especialidadescopy = new LinkedList<>(especialidades);
                Collections.sort(especialidadescopy, new EspecialidadComparator(atriordena,ordena));
                for (Especialidad especialidad : especialidadescopy) {
                    if (especialidad.codigoEspecialidad <= busca){
                        System.out.println(especialidad.toString());
                    }
                }

            } else if (option2.equals("4")){ // rango
                System.out.println("Ingrese valor minimo y el maximo del rango separado por espacio");
                input.nextLine();
                int busca1 = input.nextInt();
                int busca2 = input.nextInt();
                System.out.println("Por cual atributo desea ordenar");
                System.out.println("1. Codigo de especialidad");
                System.out.println("2. Linea de atención");
                String atriordena = input.next();
                System.out.println("De que manera desea ordenar");
                System.out.println("1. ascendente");
                System.out.println("2. descendente");
                String ordena = input.next();

                LinkedList<Especialidad> especialidadescopy = new LinkedList<>(especialidades);
                Collections.sort(especialidadescopy, new EspecialidadComparator(atriordena,ordena));
                for (Especialidad especialidad : especialidades) {
                    if ((especialidad.codigoEspecialidad >= busca1) && (especialidad.codigoEspecialidad <= busca2)){
                        System.out.println(especialidad.toString());
                    }
                }
            }


            // Encargado
        } else if (option1.equals("2")){
            System.out.println("Escoja una opcion:");
            System.out.println("1. Valor exacto");
            System.out.println("2. Valor sin considerar mayúsculas");
            System.out.println("0. Cancelar");
            String option2 = input.next();
            if (option2.equals("1")) {
                System.out.println("Ingrese el valor exacto");
                input.nextLine();
                String busca = input.nextLine();
                for (Especialidad especialidad : especialidades) {
                    if (especialidad.encargado.equals(busca)){
                        System.out.println(especialidad.toString());
                    }
                }

            } else if (option2.equals("2")) {//**************************************
                System.out.println("Ingrese Valor sin considerar mayúsculas");
                input.nextLine();
                String busca = input.nextLine();
                for (Especialidad especialidad : especialidades) {
                    if (limpiarcadena(especialidad.encargado).equals(limpiarcadena(busca))){
                        System.out.println(especialidad.toString());
                    }
                }

            } else {
                return;
            }

            // enfoque
        } else if (option1.equals("3")){ //enfoque
            System.out.println("Escoja una opcion:");
            System.out.println("1. Valor exacto");
            System.out.println("2. Valor sin considerar mayúsculas");
            System.out.println("0. Cancelar");
            String option2 = input.next();
            if (option2.equals("1")) {
                System.out.println("Ingrese el valor exacto");
                input.nextLine();
                String busca = input.nextLine();
                for (Especialidad especialidad : especialidades) {
                    if (especialidad.enfoque.equals(busca)){
                        System.out.println(especialidad.toString());
                    }
                }

            } else if (option2.equals("2")) {//**************************************
                System.out.println("Ingrese Valor sin considerar mayúsculas");
                input.nextLine();
                String busca = input.nextLine();
                for (Especialidad especialidad : especialidades) {
                    if (limpiarcadena(especialidad.enfoque).equals(limpiarcadena(busca))){
                        System.out.println(especialidad.toString());
                    }
                }

            } else {
                return;
            }

            // linea de atencion
        } else if (option1.equals("4")) {
            System.out.println("Escoja una opcion:");
            System.out.println("1. Valor exacto");
            System.out.println("2. Valor mínimo");
            System.out.println("3. Valor máximo");
            System.out.println("4. Rango");
            String option2 = input.next();
            if (option2.equals("1")) {
                System.out.println("Ingrese el valor exacto"); // valor exacto
                input.nextLine();
                int busca = input.nextInt();
                for (Especialidad especialidad : especialidades) {
                    if (especialidad.codigoEspecialidad == busca){
                        //imprimir empresa
                        System.out.println(especialidad.toString());
                    }
                }

            } else if (option2.equals("2")) { // valor minimo
                System.out.println("Ingrese el valor mínimo");
                input.nextLine();
                int busca = input.nextInt();
                System.out.println("Por cual atributo desea ordenar");
                System.out.println("1. Codigo de especialidad");
                System.out.println("2. Linea de atención");
                String atriordena = input.next();
                System.out.println("De que manera desea ordenar");
                System.out.println("1. ascendente");
                System.out.println("2. descendente");
                String ordena = input.next();

                LinkedList<Especialidad> especialidadescopy = new LinkedList<>(especialidades);
                Collections.sort(especialidadescopy, new EspecialidadComparator(atriordena,ordena));
                for (Especialidad especialidad : especialidadescopy) {
                    if (especialidad.lineaAtencion >= busca){
                        System.out.println(especialidad.toString());
                    }
                }


            } else if (option2.equals("3")){  // valor maximo
                System.out.println("Ingrese el valor máximo");
                input.nextLine();
                int busca = input.nextInt();
                System.out.println("Por cual atributo desea ordenar");
                System.out.println("1. Codigo de especialidad");
                System.out.println("2. Linea de atención");
                String atriordena = input.next();
                System.out.println("De que manera desea ordenar");
                System.out.println("1. ascendente");
                System.out.println("2. descendente");
                String ordena = input.next();

                LinkedList<Especialidad> especialidadescopy = new LinkedList<>(especialidades);
                Collections.sort(especialidadescopy, new EspecialidadComparator(atriordena,ordena));
                for (Especialidad especialidad : especialidadescopy) {
                    if (especialidad.lineaAtencion <= busca){
                        System.out.println(especialidad.toString());
                    }
                }

            } else if (option2.equals("4")) { // rango
                System.out.println("Ingrese valor minimo y el maximo del rango separado por espacio");
                input.nextLine();
                int busca1 = input.nextInt();
                int busca2 = input.nextInt();
                System.out.println("Por cual atributo desea ordenar");
                System.out.println("1. Codigo de especialidad");
                System.out.println("2. Linea de atención");
                String atriordena = input.next();
                System.out.println("De que manera desea ordenar");
                System.out.println("1. ascendente");
                System.out.println("2. descendente");
                String ordena = input.next();

                LinkedList<Especialidad> especialidadescopy = new LinkedList<>(especialidades);
                Collections.sort(especialidadescopy, new EspecialidadComparator(atriordena, ordena));
                for (Especialidad especialidad : especialidadescopy) {
                    if ((especialidad.lineaAtencion >= busca1) && (especialidad.lineaAtencion <= busca2)) {
                        System.out.println(especialidad.toString());
                    }
                }
            }

        } else if (option1.equals("5")) { //mostrar todo
            if (sucursales.size() == 0){
                System.out.println("No hay elementos en la lista");
            }else{
                System.out.println(sucursales.toString());
            }
        } else {
            return;
        }

    }

    // Busqueda Contrato arriendo
    public static void BusquedaContratoArriendo(String option1){
        // codigo
        if (option1.equals("1")){
            System.out.println("Escoja una opcion:");
            System.out.println("1. Valor exacto");
            System.out.println("2. Valor mínimo");
            System.out.println("3. Valor máximo");
            System.out.println("4. Rango");
            String option2 = input.next();
            if (option2.equals("1")) {
                System.out.println("Ingrese el valor exacto"); // valor exacto
                input.nextLine();
                int busca = input.nextInt();
                for (ContratoArriendo contratoarriendo : contratoArriendos) {
                    if (contratoarriendo.numContrato == busca){
                        //imprimir empresa
                        System.out.println(contratoarriendo.toString());
                    }
                }

            } else if (option2.equals("2")) { // valor minimo
                System.out.println("Ingrese el valor mínimo");
                input.nextLine();
                int busca = input.nextInt();
                System.out.println("Por cual atributo desea ordenar");
                System.out.println("1. Código");
                System.out.println("2. Canon");
                String atriordena = input.next();
                System.out.println("De que manera desea ordenar");
                System.out.println("1. ascendente");
                System.out.println("2. descendente");
                String ordena = input.next();

                LinkedList<ContratoArriendo> contratoArriendoscopy = new LinkedList<>(contratoArriendos);
                Collections.sort(contratoArriendoscopy, new ContratoDeArriendoComparator(atriordena,ordena));
                for (ContratoArriendo contratoarriendo : contratoArriendoscopy) {
                    if (contratoarriendo.numContrato >= busca){
                        System.out.println(contratoarriendo.toString());
                    }
                }


            } else if (option2.equals("3")){  // valor maximo
                System.out.println("Ingrese el valor máximo");
                input.nextLine();
                int busca = input.nextInt();
                System.out.println("Por cual atributo desea ordenar");
                System.out.println("1. Código");
                System.out.println("2. Canon");
                String atriordena = input.next();
                System.out.println("De que manera desea ordenar");
                System.out.println("1. ascendente");
                System.out.println("2. descendente");
                String ordena = input.next();

                LinkedList<ContratoArriendo> contratoArriendoscopy = new LinkedList<>(contratoArriendos);
                Collections.sort(contratoArriendoscopy, new ContratoDeArriendoComparator(atriordena,ordena));
                for (ContratoArriendo contratoarriendo : contratoArriendoscopy) {
                    if (contratoarriendo.numContrato <= busca){
                        System.out.println(contratoarriendo.toString());
                    }
                }

            } else if (option2.equals("4")){ // rango
                System.out.println("Ingrese valor minimo y el maximo del rango separado por espacio");
                input.nextLine();
                int busca1 = input.nextInt();
                int busca2 = input.nextInt();
                System.out.println("Por cual atributo desea ordenar");
                System.out.println("1. Código");
                System.out.println("2. Canon");
                String atriordena = input.next();
                System.out.println("De que manera desea ordenar");
                System.out.println("1. ascendente");
                System.out.println("2. descendente");
                String ordena = input.next();

                LinkedList<ContratoArriendo> contratoArriendoscopy = new LinkedList<>(contratoArriendos);
                Collections.sort(contratoArriendoscopy, new ContratoDeArriendoComparator(atriordena,ordena));
                for (ContratoArriendo contratoarriendo : contratoArriendoscopy) {
                    if ((contratoarriendo.numContrato >= busca1) && (contratoarriendo.numContrato <= busca2)){
                        System.out.println(contratoarriendo.toString());
                    }
                }
            }

            //fecha inicio
        } else if (option1.equals("2")){
            System.out.println("Escoja una opcion:");
            System.out.println("1. Valor exacto");
            System.out.println("2. Valor sin considerar mayúsculas");
            System.out.println("0. Cancelar");
            String option2 = input.next();
            if (option2.equals("1")) {
                System.out.println("Ingrese el valor exacto");
                input.nextLine();
                String busca = input.nextLine();
                for (ContratoArriendo contratoarriendo : contratoArriendos) {
                    if (contratoarriendo.fechadeInicio.equals(busca)){
                        System.out.println(contratoarriendo.toString());
                    }
                }

            } else if (option2.equals("2")) {//**************************************
                System.out.println("Ingrese Valor sin considerar mayúsculas");
                input.nextLine();
                String busca = input.nextLine();
                for (ContratoArriendo contratoarriendo : contratoArriendos) {
                    if (limpiarcadena(contratoarriendo.fechadeInicio).equals(limpiarcadena(busca))){
                        System.out.println(contratoarriendo.toString());
                    }
                }

            } else {
                return;
            }

            // fecha fin
        } else if (option1.equals("3")){ //enfoque
            System.out.println("Escoja una opcion:");
            System.out.println("1. Valor exacto");
            System.out.println("2. Valor sin considerar mayúsculas");
            System.out.println("0. Cancelar");
            String option2 = input.next();
            if (option2.equals("1")) {
                System.out.println("Ingrese el valor exacto");
                input.nextLine();
                String busca = input.nextLine();
                for (ContratoArriendo contratoarriendo : contratoArriendos) {
                    if (contratoarriendo.FechadeFin.equals(busca)){
                        System.out.println(contratoarriendo.toString());
                    }
                }

            } else if (option2.equals("2")) {//**************************************
                System.out.println("Ingrese Valor sin considerar mayúsculas");
                input.nextLine();
                String busca = input.nextLine();
                for (ContratoArriendo contratoarriendo : contratoArriendos) {
                    if (limpiarcadena(contratoarriendo.FechadeFin).equals(limpiarcadena(busca))){
                        System.out.println(contratoarriendo.toString());
                    }
                }

            } else {
                return;
            }

            // canon
        } else if (option1.equals("4")) {
            System.out.println("Escoja una opcion:");
            System.out.println("1. Valor exacto");
            System.out.println("2. Valor mínimo");
            System.out.println("3. Valor máximo");
            System.out.println("4. Rango");
            String option2 = input.next();
            if (option2.equals("1")) {
                System.out.println("Ingrese el valor exacto"); // valor exacto
                input.nextLine();
                int busca = input.nextInt();
                for (ContratoArriendo contratoarriendo : contratoArriendos) {
                    if (contratoarriendo.canon == busca){
                        //imprimir empresa
                        System.out.println(contratoarriendo.toString());
                    }
                }

            } else if (option2.equals("2")) { // valor minimo
                System.out.println("Ingrese el valor mínimo");
                input.nextLine();
                int busca = input.nextInt();
                System.out.println("Por cual atributo desea ordenar");
                System.out.println("1. Código");
                System.out.println("2. Canon");
                String atriordena = input.next();
                System.out.println("De que manera desea ordenar");
                System.out.println("1. ascendente");
                System.out.println("2. descendente");
                String ordena = input.next();

                LinkedList<ContratoArriendo> contratoArriendoscopy = new LinkedList<>(contratoArriendos);
                Collections.sort(contratoArriendoscopy, new ContratoDeArriendoComparator(atriordena,ordena));
                for (ContratoArriendo contratoarriendo : contratoArriendoscopy) {
                    if (contratoarriendo.canon >= busca){
                        System.out.println(contratoarriendo.toString());
                    }
                }


            } else if (option2.equals("3")){  // valor maximo
                System.out.println("Ingrese el valor máximo");
                input.nextLine();
                int busca = input.nextInt();
                System.out.println("Por cual atributo desea ordenar");
                System.out.println("1. Código");
                System.out.println("2. Canon");
                String atriordena = input.next();
                System.out.println("De que manera desea ordenar");
                System.out.println("1. ascendente");
                System.out.println("2. descendente");
                String ordena = input.next();

                LinkedList<ContratoArriendo> contratoArriendoscopy = new LinkedList<>(contratoArriendos);
                Collections.sort(contratoArriendoscopy, new ContratoDeArriendoComparator(atriordena,ordena));
                for (ContratoArriendo contratoarriendo : contratoArriendoscopy) {
                    if (contratoarriendo.canon <= busca){
                        System.out.println(contratoarriendo.toString());
                    }
                }

            } else if (option2.equals("4")) { // rango canon
                System.out.println("Ingrese valor minimo y el maximo del rango separado por espacio");
                input.nextLine();
                int busca1 = input.nextInt();
                int busca2 = input.nextInt();
                System.out.println("Por cual atributo desea ordenar");
                System.out.println("1. Código");
                System.out.println("2. Canon");
                String atriordena = input.next();
                System.out.println("De que manera desea ordenar");
                System.out.println("1. ascendente");
                System.out.println("2. descendente");
                String ordena = input.next();

                LinkedList<ContratoArriendo> contratoArriendoscopy = new LinkedList<>(contratoArriendos);
                Collections.sort(contratoArriendoscopy, new ContratoDeArriendoComparator(atriordena,ordena));
                for (ContratoArriendo contratoarriendo : contratoArriendoscopy) {
                    if ((contratoarriendo.canon >= busca1) && (contratoarriendo.canon <= busca2)) {
                        System.out.println(contratoarriendo.toString());
                    }
                }
            }

        } else if (option1.equals("5")) {
            if (contratoArriendos.size()==0){
                System.out.println("La lista está vacía");
            }else {
                System.out.println(contratoArriendos.toString());
            }
        }

    }

    // Busqueda Contrato repartidor
    public static void BusquedaRepartidor(String option1){
        // cedula
        if (option1.equals("1")){
            System.out.println("Escoja una opcion:");
            System.out.println("1. Valor exacto");
            System.out.println("2. Valor mínimo");
            System.out.println("3. Valor máximo");
            System.out.println("4. Rango");
            String option2 = input.next();
            if (option2.equals("1")) {
                System.out.println("Ingrese el valor exacto"); // valor exacto
                input.nextLine();
                int busca = input.nextInt();
                for (Repartidor repartidor : repartidores) {
                    if (repartidor.Cedula == busca){
                        //imprimir empresa
                        System.out.println(repartidor.toString());
                    }
                }

            } else if (option2.equals("2")) { // valor minimo
                System.out.println("Ingrese el valor mínimo");
                input.nextLine();
                int busca = input.nextInt();
                System.out.println("Por cual atributo desea ordenar");
                System.out.println("1. Cedula");
                System.out.println("2. Edad");

                String atriordena = input.next();
                System.out.println("De que manera desea ordenar");
                System.out.println("1. ascendente");
                System.out.println("2. descendente");
                String ordena = input.next();

                LinkedList<Repartidor> repartidorescopy = new LinkedList<>(repartidores);
                Collections.sort(repartidorescopy, new RepartidorComparator(atriordena,ordena));
                for (Repartidor repartidor : repartidorescopy) {
                    if (repartidor.Cedula >= busca){
                        System.out.println(repartidor.toString());
                    }
                }


            } else if (option2.equals("3")){  // valor maximo
                System.out.println("Ingrese el valor máximo");
                input.nextLine();
                int busca = input.nextInt();
                System.out.println("Por cual atributo desea ordenar");
                System.out.println("1. Cedula");
                System.out.println("2. Edad");
                String atriordena = input.next();
                System.out.println("De que manera desea ordenar");
                System.out.println("1. ascendente");
                System.out.println("2. descendente");
                String ordena = input.next();

                LinkedList<Repartidor> repartidorescopy = new LinkedList<>(repartidores);
                Collections.sort(repartidorescopy, new RepartidorComparator(atriordena,ordena));
                for (Repartidor repartidor : repartidorescopy) {
                    if (repartidor.Cedula <= busca){
                        System.out.println(repartidor.toString());
                    }
                }

            } else if (option2.equals("4")){ // rango
                System.out.println("Ingrese valor minimo y el maximo del rango separado por espacio");
                input.nextLine();
                int busca1 = input.nextInt();
                int busca2 = input.nextInt();
                System.out.println("Por cual atributo desea ordenar");
                System.out.println("1. Cedula");
                System.out.println("2. Edad");
                String atriordena = input.next();
                System.out.println("De que manera desea ordenar");
                System.out.println("1. ascendente");
                System.out.println("2. descendente");
                String ordena = input.next();

                LinkedList<Repartidor> repartidorescopy = new LinkedList<>(repartidores);
                Collections.sort(repartidorescopy, new RepartidorComparator(atriordena,ordena));
                for (Repartidor repartidor : repartidorescopy) {
                    if ((repartidor.Cedula >= busca1) && (repartidor.Cedula <= busca2)){
                        System.out.println(repartidor.toString());
                    }
                }
            }

        } else if (option1.equals("2")){ //nombre
            System.out.println("Escoja una opcion:");
            System.out.println("1. Valor exacto");
            System.out.println("2. Valor sin considerar mayúsculas");
            System.out.println("0. Cancelar");
            String option2 = input.next();
            if (option2.equals("1")) {
                System.out.println("Ingrese el valor exacto");
                input.nextLine();
                String busca = input.nextLine();
                for (Repartidor repartidor : repartidores) {
                    if (repartidor.Nombre.equals(busca)){
                        System.out.println(repartidor.toString());
                    }
                }

            } else if (option2.equals("2")) {//**************************************
                System.out.println("Ingrese Valor sin considerar mayúsculas");
                input.nextLine();
                String busca = input.nextLine();
                for (Repartidor repartidor : repartidores) {
                    if (limpiarcadena(repartidor.Nombre).equals(limpiarcadena(busca))){
                        System.out.println(repartidor.toString());
                    }
                }
            }


        } else if (option1.equals("4")) {
            System.out.println("Escoja una opcion:");
            System.out.println("1. Valor exacto");
            System.out.println("2. Valor mínimo");
            System.out.println("3. Valor máximo");
            System.out.println("4. Rango");
            String option2 = input.next();
            if (option2.equals("1")) {
                System.out.println("Ingrese el valor exacto"); // valor exacto
                input.nextLine();
                int busca = input.nextInt();
                for (Repartidor repartidor : repartidores) {
                    if (repartidor.Num_Celular == busca){
                        //imprimir empresa
                        System.out.println(repartidor.toString());
                    }
                }

            } else if (option2.equals("2")) { // valor minimo
                System.out.println("Ingrese el valor mínimo");
                input.nextLine();
                int busca = input.nextInt();
                System.out.println("Por cual atributo desea ordenar");
                System.out.println("1. Cedula");
                System.out.println("2. Edad");
                String atriordena = input.next();
                System.out.println("De que manera desea ordenar");
                System.out.println("1. ascendente");
                System.out.println("2. descendente");
                String ordena = input.next();

                LinkedList<Repartidor> repartidorescopy = new LinkedList<>(repartidores);
                Collections.sort(repartidorescopy, new RepartidorComparator(atriordena,ordena));
                for (Repartidor repartidor : repartidorescopy) {
                    if (repartidor.Num_Celular >= busca){
                        System.out.println(repartidor.toString());
                    }
                }


            } else if (option2.equals("3")){  // valor maximo
                System.out.println("Ingrese el valor máximo");
                input.nextLine();
                int busca = input.nextInt();
                System.out.println("Por cual atributo desea ordenar");
                System.out.println("1. Cedula");
                System.out.println("2. Edad");
                String atriordena = input.next();
                System.out.println("De que manera desea ordenar");
                System.out.println("1. ascendente");
                System.out.println("2. descendente");
                String ordena = input.next();

                LinkedList<Repartidor> repartidorescopy = new LinkedList<>(repartidores);
                Collections.sort(repartidorescopy, new RepartidorComparator(atriordena,ordena));
                for (Repartidor repartidor : repartidorescopy) {
                    if (repartidor.Num_Celular <= busca){
                        System.out.println(repartidor.toString());
                    }
                }

            } else if (option2.equals("4")) { // rango
                System.out.println("Ingrese valor minimo y el maximo del rango separado por espacio");
                input.nextLine();
                int busca1 = input.nextInt();
                int busca2 = input.nextInt();
                System.out.println("Por cual atributo desea ordenar");
                System.out.println("1. Cedula");
                System.out.println("2. Edad");
                String atriordena = input.next();
                System.out.println("De que manera desea ordenar");
                System.out.println("1. ascendente");
                System.out.println("2. descendente");
                String ordena = input.next();

                LinkedList<Repartidor> repartidorescopy = new LinkedList<>(repartidores);
                Collections.sort(repartidorescopy, new RepartidorComparator(atriordena,ordena));
                for (Repartidor repartidor : repartidorescopy) {
                    if ((repartidor.Num_Celular >= busca1) && (repartidor.Num_Celular <= busca2)) {
                        System.out.println(repartidor.toString());
                    }
                }
            }

            // Edadd
        } else if (option1.equals("3")) {
            System.out.println("Escoja una opcion:");
            System.out.println("1. Valor exacto");
            System.out.println("2. Valor mínimo");
            System.out.println("3. Valor máximo");
            System.out.println("4. Rango");
            String option2 = input.next();
            if (option2.equals("1")) {
                System.out.println("Ingrese el valor exacto"); // valor exacto
                input.nextLine();
                int busca = input.nextInt();
                for (Repartidor repartidor : repartidores) {
                    if (repartidor.Edad == busca){
                        //imprimir empresa
                        System.out.println(repartidor.toString());
                    }
                }

            } else if (option2.equals("2")) { // valor minimo
                System.out.println("Ingrese el valor mínimo");
                input.nextLine();
                int busca = input.nextInt();
                System.out.println("Por cual atributo desea ordenar");
                System.out.println("1. Cedula");
                System.out.println("2. Edad");
                String atriordena = input.next();
                System.out.println("De que manera desea ordenar");
                System.out.println("1. ascendente");
                System.out.println("2. descendente");
                String ordena = input.next();

                LinkedList<Repartidor> repartidorescopy = new LinkedList<>(repartidores);
                Collections.sort(repartidorescopy, new RepartidorComparator(atriordena,ordena));
                for (Repartidor repartidor : repartidorescopy) {
                    if (repartidor.Edad >= busca){
                        System.out.println(repartidor.toString());
                    }
                }


            } else if (option2.equals("3")){  // valor maximo
                System.out.println("Ingrese el valor máximo");
                input.nextLine();
                int busca = input.nextInt();
                System.out.println("Por cual atributo desea ordenar");
                System.out.println("1. Cedula");
                System.out.println("2. Edad");
                String atriordena = input.next();
                System.out.println("De que manera desea ordenar");
                System.out.println("1. ascendente");
                System.out.println("2. descendente");
                String ordena = input.next();

                LinkedList<Repartidor> repartidorescopy = new LinkedList<>(repartidores);
                Collections.sort(repartidorescopy, new RepartidorComparator(atriordena,ordena));
                for (Repartidor repartidor : repartidorescopy) {
                    if (repartidor.Edad <= busca){
                        System.out.println(repartidor.toString());
                    }
                }

            } else if (option2.equals("4")) { // rango
                System.out.println("Ingrese valor minimo y el maximo del rango separado por espacio");
                input.nextLine();
                int busca1 = input.nextInt();
                int busca2 = input.nextInt();
                System.out.println("Por cual atributo desea ordenar");
                System.out.println("1. Cedula");
                System.out.println("2. Edad");
                String atriordena = input.next();
                System.out.println("De que manera desea ordenar");
                System.out.println("1. ascendente");
                System.out.println("2. descendente");
                String ordena = input.next();

                LinkedList<Repartidor> repartidorescopy = new LinkedList<>(repartidores);
                Collections.sort(repartidorescopy, new RepartidorComparator(atriordena,ordena));
                for (Repartidor repartidor : repartidorescopy) {
                    if ((repartidor.Edad >= busca1) && (repartidor.Edad <= busca2)) {
                        System.out.println(repartidor.toString());
                    }
                }
            }

        // numero de celular

        } else if (option1.equals("4")) {
            System.out.println("Escoja una opcion:");
            System.out.println("1. Valor exacto");
            System.out.println("2. Valor mínimo");
            System.out.println("3. Valor máximo");
            System.out.println("4. Rango");
            String option2 = input.next();
            if (option2.equals("1")) {
                System.out.println("Ingrese el valor exacto"); // valor exacto
                input.nextLine();
                int busca = input.nextInt();
                for (Repartidor repartidor : repartidores) {
                    if (repartidor.Num_Celular == busca) {
                        //imprimir empresa
                        System.out.println(repartidor.toString());
                    }
                }

            } else if (option2.equals("2")) { // valor minimo
                System.out.println("Ingrese el valor mínimo");
                input.nextLine();
                int busca = input.nextInt();
                System.out.println("Por cual atributo desea ordenar");
                System.out.println("1. Cedula");
                System.out.println("2. Edad");
                String atriordena = input.next();
                System.out.println("De que manera desea ordenar");
                System.out.println("1. ascendente");
                System.out.println("2. descendente");
                String ordena = input.next();

                LinkedList<Repartidor> repartidorescopy = new LinkedList<>(repartidores);
                Collections.sort(repartidorescopy, new RepartidorComparator(atriordena, ordena));
                for (Repartidor repartidor : repartidorescopy) {
                    if (repartidor.Num_Celular >= busca) {
                        System.out.println(repartidor.toString());
                    }
                }


            } else if (option2.equals("3")) {  // valor maximo
                System.out.println("Ingrese el valor máximo");
                input.nextLine();
                int busca = input.nextInt();
                System.out.println("Por cual atributo desea ordenar");
                System.out.println("1. Cedula");
                System.out.println("2. Edad");
                String atriordena = input.next();
                System.out.println("De que manera desea ordenar");
                System.out.println("1. ascendente");
                System.out.println("2. descendente");
                String ordena = input.next();

                LinkedList<Repartidor> repartidorescopy = new LinkedList<>(repartidores);
                Collections.sort(repartidorescopy, new RepartidorComparator(atriordena, ordena));
                for (Repartidor repartidor : repartidorescopy) {
                    if (repartidor.Num_Celular <= busca) {
                        System.out.println(repartidor.toString());
                    }
                }

            } else if (option2.equals("4")) { // rango
                System.out.println("Ingrese valor minimo y el maximo del rango separado por espacio");
                input.nextLine();
                int busca1 = input.nextInt();
                int busca2 = input.nextInt();
                System.out.println("Por cual atributo desea ordenar");
                System.out.println("1. Cedula");
                System.out.println("2. Edad");
                String atriordena = input.next();
                System.out.println("De que manera desea ordenar");
                System.out.println("1. ascendente");
                System.out.println("2. descendente");
                String ordena = input.next();

                LinkedList<Repartidor> repartidorescopy = new LinkedList<>(repartidores);
                Collections.sort(repartidorescopy, new RepartidorComparator(atriordena, ordena));
                for (Repartidor repartidor : repartidorescopy) {
                    if ((repartidor.Num_Celular >= busca1) && (repartidor.Num_Celular <= busca2)) {
                        System.out.println(repartidor.toString());
                    }
                }
            }

        } else if (option1.equals("5")) { // tipo de licencia
            System.out.println("Escoja una opcion:");
            System.out.println("1. Valor exacto");
            System.out.println("2. Valor sin considerar mayúsculas");
            System.out.println("0. Cancelar");
            String option2 = input.next();
            if (option2.equals("1")) {
                System.out.println("Ingrese el valor exacto");
                input.nextLine();
                String busca = input.nextLine();
                for (Repartidor repartidor : repartidores) {
                    if (repartidor.Tipo_Licencia.equals(busca)) {
                        System.out.println(repartidor.toString());
                    }
                }

            } else if (option2.equals("2")) {//**************************************
                System.out.println("Ingrese Valor sin considerar mayúsculas");
                input.nextLine();
                String busca = input.nextLine();
                for (Repartidor repartidor : repartidores) {
                    if (limpiarcadena(repartidor.Tipo_Licencia).equals(limpiarcadena(busca))) {
                        System.out.println(repartidor.toString());
                    }
                }

            }

        } else if (option1.equals("5")) {
            if (repartidores.size() == 0){
                System.out.println("No hay registros");
            }else{
                System.out.println(repartidores.toString());
            }
        }

    }

    // Busqueda Tipo de entrega
    public static void BusquedaTipoDeEntrega(String option1){
        // Codigo**************
        if (option1.equals("1")){
            System.out.println("Escoja una opcion:");
            System.out.println("1. Valor exacto");
            System.out.println("2. Valor mínimo");
            System.out.println("3. Valor máximo");
            System.out.println("4. Rango");
            String option2 = input.next();
            if (option2.equals("1")) {
                System.out.println("Ingrese el valor exacto"); // valor exacto
                input.nextLine();
                int busca = input.nextInt();
                for (TipoDeEntrega tipodeentrega : tipoDeEntregas) {
                    if (tipodeentrega.Codigo == busca){
                        //imprimir empresa
                        System.out.println(tipodeentrega.toString());
                    }
                }

            } else if (option2.equals("2")) { // valor minimo
                System.out.println("Ingrese el valor mínimo");
                input.nextLine();
                int busca = input.nextInt();
                System.out.println("Por cual atributo desea ordenar");
                System.out.println("1. Codigo ");
                System.out.println("2. Tiempo estimado");
                String atriordena = input.next();
                System.out.println("De que manera desea ordenar");
                System.out.println("1. ascendente");
                System.out.println("2. descendente");
                String ordena = input.next();

                LinkedList<TipoDeEntrega> tipoDeEntregascopy = new LinkedList<>(tipoDeEntregas);
                Collections.sort(tipoDeEntregascopy, new TipoDeEntregaComparator(atriordena,ordena));
                for (TipoDeEntrega tipodeentrega : tipoDeEntregascopy) {
                    if (tipodeentrega.Codigo >= busca){
                        System.out.println(tipodeentrega.toString());
                    }
                }


            } else if (option2.equals("3")){  // valor maximo
                System.out.println("Ingrese el valor máximo");
                input.nextLine();
                int busca = input.nextInt();
                System.out.println("Por cual atributo desea ordenar");
                System.out.println("1. Codigo ");
                System.out.println("2. Tiempo estimado");
                String atriordena = input.next();
                System.out.println("De que manera desea ordenar");
                System.out.println("1. ascendente");
                System.out.println("2. descendente");
                String ordena = input.next();

                LinkedList<TipoDeEntrega> tipoDeEntregascopy = new LinkedList<>(tipoDeEntregas);
                Collections.sort(tipoDeEntregascopy, new TipoDeEntregaComparator(atriordena,ordena));
                for (TipoDeEntrega tipodeentrega : tipoDeEntregascopy) {
                    if (tipodeentrega.Codigo <= busca){
                        System.out.println(tipodeentrega.toString());
                    }
                }

            } else if (option2.equals("4")){ // rango
                System.out.println("Ingrese valor minimo y el maximo del rango separado por espacio");
                input.nextLine();
                int busca1 = input.nextInt();
                int busca2 = input.nextInt();
                System.out.println("Por cual atributo desea ordenar");
                System.out.println("1. Codigo ");
                System.out.println("2. Tiempo estimado");
                String atriordena = input.next();
                System.out.println("De que manera desea ordenar");
                System.out.println("1. ascendente");
                System.out.println("2. descendente");
                String ordena = input.next();

                LinkedList<TipoDeEntrega> tipoDeEntregascopy = new LinkedList<>(tipoDeEntregas);
                Collections.sort(tipoDeEntregascopy, new TipoDeEntregaComparator(atriordena,ordena));
                for (TipoDeEntrega tipodeentrega : tipoDeEntregascopy) {
                    if ((tipodeentrega.Codigo >= busca1) && (tipodeentrega.Codigo <= busca2)){
                        System.out.println(tipodeentrega.toString());
                    }
                }
            }


        } else if (option1.equals("2")) { // tiempo estimado
            System.out.println("Escoja una opcion:");
            System.out.println("1. Valor exacto");
            System.out.println("2. Valor mínimo");
            System.out.println("3. Valor máximo");
            System.out.println("4. Rango");
            String option2 = input.next();
            if (option2.equals("1")) {
                System.out.println("Ingrese el valor exacto"); // valor exacto
                input.nextLine();
                int busca = input.nextInt();
                for (TipoDeEntrega tipodeentrega : tipoDeEntregas) {
                    if (tipodeentrega.Tiempo_Estimado == busca){
                        System.out.println(tipodeentrega.toString());
                    }
                }

            } else if (option2.equals("2")) { // valor minimo
                System.out.println("Ingrese el valor mínimo");
                input.nextLine();
                int busca = input.nextInt();
                System.out.println("Por cual atributo desea ordenar");
                System.out.println("1. Codigo ");
                System.out.println("2. Tiempo estimado");
                String atriordena = input.next();
                System.out.println("De que manera desea ordenar");
                System.out.println("1. ascendente");
                System.out.println("2. descendente");
                String ordena = input.next();

                LinkedList<TipoDeEntrega> tipoDeEntregascopy = new LinkedList<>(tipoDeEntregas);
                Collections.sort(tipoDeEntregascopy, new TipoDeEntregaComparator(atriordena,ordena));
                for (TipoDeEntrega tipodeentrega : tipoDeEntregascopy) {
                    if (tipodeentrega.Tiempo_Estimado >= busca){
                        System.out.println(tipodeentrega.toString());
                    }
                }


            } else if (option2.equals("3")){  // valor maximo
                System.out.println("Ingrese el valor máximo");
                input.nextLine();
                int busca = input.nextInt();
                System.out.println("Por cual atributo desea ordenar");
                System.out.println("1. Codigo ");
                System.out.println("2. Tiempo estimado");
                String atriordena = input.next();
                System.out.println("De que manera desea ordenar");
                System.out.println("1. ascendente");
                System.out.println("2. descendente");
                String ordena = input.next();

                LinkedList<TipoDeEntrega> tipoDeEntregascopy = new LinkedList<>(tipoDeEntregas);
                Collections.sort(tipoDeEntregascopy, new TipoDeEntregaComparator(atriordena,ordena));
                for (TipoDeEntrega tipodeentrega : tipoDeEntregascopy) {
                    if (tipodeentrega.Tiempo_Estimado <= busca){
                        System.out.println(tipodeentrega.toString());
                    }
                }

            } else if (option2.equals("4")) { // rango
                System.out.println("Ingrese valor minimo y el maximo del rango separado por espacio");
                input.nextLine();
                int busca1 = input.nextInt();
                int busca2 = input.nextInt();
                System.out.println("Por cual atributo desea ordenar");
                System.out.println("1. Codigo ");
                System.out.println("2. Tiempo estimado");
                String atriordena = input.next();
                System.out.println("De que manera desea ordenar");
                System.out.println("1. ascendente");
                System.out.println("2. descendente");
                String ordena = input.next();

                LinkedList<TipoDeEntrega> tipoDeEntregascopy = new LinkedList<>(tipoDeEntregas);
                Collections.sort(tipoDeEntregascopy, new TipoDeEntregaComparator(atriordena,ordena));
                for (TipoDeEntrega tipodeentrega : tipoDeEntregascopy) {
                    if ((tipodeentrega.Tiempo_Estimado >= busca1) && (tipodeentrega.Tiempo_Estimado <= busca2)) {
                        System.out.println(tipodeentrega.toString());
                    }
                }
            }

        } else if (option1.equals("3")) {
            System.out.println("Escoja una opcion:");
            System.out.println("1. Valor exacto");
            System.out.println("2. Valor sin considerar mayúsculas");
            System.out.println("0. Cancelar");
            String option2 = input.next();
            if (option2.equals("1")) {
                System.out.println("Ingrese el valor exacto");
                input.nextLine();
                String busca = input.nextLine();
                for (TipoDeEntrega tipodeentrega : tipoDeEntregas) {
                    if (tipodeentrega.MedioDeTransporte.equals(busca)) {
                        System.out.println(tipodeentrega.toString());
                    }
                }

            } else if (option2.equals("2")) {//**************************************
                System.out.println("Ingrese Valor sin considerar mayúsculas");
                input.nextLine();
                String busca = input.nextLine();
                for (TipoDeEntrega tipodeentrega : tipoDeEntregas) {
                    if (limpiarcadena(tipodeentrega.MedioDeTransporte).equals(limpiarcadena(busca))) {
                        System.out.println(tipodeentrega.toString());
                    }
                }

            }
        }
    }

    // Busqueda clientes
    public static void BusquedaCliente(String option1){
        // Codigo**************
        if (option1.equals("1")){
            System.out.println("Escoja una opcion:");
            System.out.println("1. Valor exacto");
            System.out.println("2. Valor mínimo");
            System.out.println("3. Valor máximo");
            System.out.println("4. Rango");
            String option2 = input.next();
            if (option2.equals("1")) {
                System.out.println("Ingrese el valor exacto"); // valor exacto
                input.nextLine();
                int busca = input.nextInt();
                for (Cliente cliente : clientes) {
                    if (cliente.Documento == busca){
                        //imprimir empresa
                        System.out.println(cliente.toString());
                    }
                }

            } else if (option2.equals("2")) { // valor minimo
                System.out.println("Ingrese el valor mínimo");
                input.nextLine();
                int busca = input.nextInt();
                System.out.println("Por cual atributo desea ordenar");
                System.out.println("1. Documento");
                System.out.println("2. Telefono");
                System.out.println("3. Codigo postal");

                String atriordena = input.next();
                System.out.println("De que manera desea ordenar");
                System.out.println("1. ascendente");
                System.out.println("2. descendente");
                String ordena = input.next();

                LinkedList<Cliente> clientescopy = new LinkedList<>(clientes);
                Collections.sort(clientescopy, new ClienteComparator(atriordena,ordena));
                for (Cliente cliente : clientescopy) {
                    if (cliente.Documento >= busca){
                        System.out.println(cliente.toString());
                    }
                }


            } else if (option2.equals("3")){  // valor maximo
                System.out.println("Ingrese el valor máximo");
                input.nextLine();
                int busca = input.nextInt();
                System.out.println("Por cual atributo desea ordenar");
                System.out.println("1. Documento");
                System.out.println("2. Telefono");
                System.out.println("3. Codigo postal");
                String atriordena = input.next();
                System.out.println("De que manera desea ordenar");
                System.out.println("1. ascendente");
                System.out.println("2. descendente");
                String ordena = input.next();

                LinkedList<Cliente> clientescopy = new LinkedList<>(clientes);
                Collections.sort(clientescopy, new ClienteComparator(atriordena,ordena));
                for (Cliente cliente : clientescopy) {
                    if (cliente.Documento <= busca){
                        System.out.println(cliente.toString());
                    }
                }

            } else if (option2.equals("4")){ // rango
                System.out.println("Ingrese valor minimo y el maximo del rango separado por espacio");
                input.nextLine();
                int busca1 = input.nextInt();
                int busca2 = input.nextInt();
                System.out.println("Por cual atributo desea ordenar");
                System.out.println("1. Documento");
                System.out.println("2. Telefono");
                System.out.println("3. Codigo postal");
                String atriordena = input.next();
                System.out.println("De que manera desea ordenar");
                System.out.println("1. ascendente");
                System.out.println("2. descendente");
                String ordena = input.next();

                LinkedList<Cliente> clientescopy = new LinkedList<>(clientes);
                Collections.sort(clientescopy, new ClienteComparator(atriordena,ordena));
                for (Cliente cliente : clientescopy) {
                    if ((cliente.Documento >= busca1) && (cliente.Documento <= busca2)){
                        System.out.println(cliente.toString());
                    }
                }
            }


            // Nombre
        } else if (option1.equals("2")){
            System.out.println("Escoja una opcion:");
            System.out.println("1. Valor exacto");
            System.out.println("2. Valor sin considerar mayúsculas");
            System.out.println("0. Cancelar");
            String option2 = input.next();
            if (option2.equals("1")) {
                System.out.println("Ingrese el valor exacto");
                input.nextLine();
                String busca = input.nextLine();
                for (Cliente cliente : clientes) {
                    if (cliente.Nombre.equals(busca)){
                        System.out.println(cliente.toString());
                    }
                }

            } else if (option2.equals("2")) {//**************************************
                System.out.println("Ingrese Valor sin considerar mayúsculas");
                input.nextLine();
                String busca = input.nextLine();
                for (Cliente cliente : clientes) {
                    if (limpiarcadena(cliente.Nombre).equals(limpiarcadena(busca))){
                        System.out.println(cliente.toString());
                    }
                }

            } else {
                return;
            }

            // Direccionn
        } else if (option1.equals("3")){ //enfoque
            System.out.println("Escoja una opcion:");
            System.out.println("1. Valor exacto");
            System.out.println("2. Valor sin considerar mayúsculas");
            System.out.println("0. Cancelar");
            String option2 = input.next();
            if (option2.equals("1")) {
                System.out.println("Ingrese el valor exacto");
                input.nextLine();
                String busca = input.nextLine();
                for (Cliente cliente : clientes) {
                    if (cliente.Nombre.equals(busca)){
                        System.out.println(cliente.toString());
                    }
                }

            } else if (option2.equals("2")) {//**************************************
                System.out.println("Ingrese Valor sin considerar mayúsculas");
                input.nextLine();
                String busca = input.nextLine();
                for (Cliente cliente : clientes) {
                    if (limpiarcadena(cliente.Nombre).equals(limpiarcadena(busca))){
                        System.out.println(cliente.toString());
                    }
                }
            } else {
                return;
            }

            // teefono
        } else if (option1.equals("4")) {
            System.out.println("Escoja una opcion:");
            System.out.println("1. Valor exacto");
            System.out.println("2. Valor mínimo");
            System.out.println("3. Valor máximo");
            System.out.println("4. Rango");
            String option2 = input.next();
            if (option2.equals("1")) {
                System.out.println("Ingrese el valor exacto"); // valor exacto
                input.nextLine();
                int busca = input.nextInt();
                for (Cliente cliente : clientes) {
                    if (cliente.Telefono == busca){
                        //imprimir empresa
                        System.out.println(cliente.toString());
                    }
                }

            } else if (option2.equals("2")) { // valor minimo
                System.out.println("Ingrese el valor mínimo");
                input.nextLine();
                int busca = input.nextInt();
                System.out.println("Por cual atributo desea ordenar");
                System.out.println("1. Documento");
                System.out.println("2. Telefono");
                System.out.println("3. Codigo postal");
                String atriordena = input.next();
                System.out.println("De que manera desea ordenar");
                System.out.println("1. ascendente");
                System.out.println("2. descendente");
                String ordena = input.next();

                LinkedList<Cliente> clientescopy = new LinkedList<>(clientes);
                Collections.sort(clientescopy, new ClienteComparator(atriordena,ordena));
                for (Cliente cliente : clientescopy) {
                    if (cliente.Telefono >= busca){
                        System.out.println(cliente.toString());
                    }
                }


            } else if (option2.equals("3")){  // valor maximo
                System.out.println("Ingrese el valor máximo");
                input.nextLine();
                int busca = input.nextInt();
                System.out.println("Por cual atributo desea ordenar");
                System.out.println("1. Documento");
                System.out.println("2. Telefono");
                System.out.println("3. Codigo postal");
                String atriordena = input.next();
                System.out.println("De que manera desea ordenar");
                System.out.println("1. ascendente");
                System.out.println("2. descendente");
                String ordena = input.next();

                LinkedList<Cliente> clientescopy = new LinkedList<>(clientes);
                Collections.sort(clientescopy, new ClienteComparator(atriordena,ordena));
                for (Cliente cliente : clientescopy) {
                    if (cliente.Telefono <= busca){
                        System.out.println(cliente.toString());
                    }
                }

            } else if (option2.equals("4")) { // rango
                System.out.println("Ingrese valor minimo y el maximo del rango separado por espacio");
                input.nextLine();
                int busca1 = input.nextInt();
                int busca2 = input.nextInt();
                System.out.println("Por cual atributo desea ordenar");
                System.out.println("1. Documento");
                System.out.println("2. Telefono");
                System.out.println("3. Codigo postal");
                String atriordena = input.next();
                System.out.println("De que manera desea ordenar");
                System.out.println("1. ascendente");
                System.out.println("2. descendente");
                String ordena = input.next();

                LinkedList<Cliente> clientescopy = new LinkedList<>(clientes);
                Collections.sort(clientescopy, new ClienteComparator(atriordena,ordena));
                for (Cliente cliente : clientescopy) {
                    if ((cliente.Telefono >= busca1) && (cliente.Telefono <= busca2)) {
                        System.out.println(cliente.toString());
                    }
                }
            }

            // codigo postal
        } else if (option1.equals("5")) {
            System.out.println("Escoja una opcion:");
            System.out.println("1. Valor exacto");
            System.out.println("2. Valor mínimo");
            System.out.println("3. Valor máximo");
            System.out.println("4. Rango");
            String option2 = input.next();
            if (option2.equals("1")) {
                System.out.println("Ingrese el valor exacto"); // valor exacto
                input.nextLine();
                int busca = input.nextInt();
                for (Cliente cliente : clientes) {
                    if (cliente.CodigoPostal == busca){
                        //imprimir empresa
                        System.out.println(cliente.toString());
                    }
                }

            } else if (option2.equals("2")) { // valor minimo
                System.out.println("Ingrese el valor mínimo");
                input.nextLine();
                int busca = input.nextInt();
                System.out.println("Por cual atributo desea ordenar");
                System.out.println("1. Documento");
                System.out.println("2. Telefono");
                System.out.println("3. Codigo postal");
                String atriordena = input.next();
                System.out.println("De que manera desea ordenar");
                System.out.println("1. ascendente");
                System.out.println("2. descendente");
                String ordena = input.next();

                LinkedList<Cliente> clientescopy = new LinkedList<>(clientes);
                Collections.sort(clientescopy, new ClienteComparator(atriordena,ordena));
                for (Cliente cliente : clientescopy) {
                    if (cliente.CodigoPostal >= busca){
                        System.out.println(cliente.toString());
                    }
                }


            } else if (option2.equals("3")){  // valor maximo
                System.out.println("Ingrese el valor máximo");
                input.nextLine();
                int busca = input.nextInt();
                System.out.println("Por cual atributo desea ordenar");
                System.out.println("1. Documento");
                System.out.println("2. Telefono");
                System.out.println("3. Codigo postal");
                String atriordena = input.next();
                System.out.println("De que manera desea ordenar");
                System.out.println("1. ascendente");
                System.out.println("2. descendente");
                String ordena = input.next();

                LinkedList<Cliente> clientescopy = new LinkedList<>(clientes);
                Collections.sort(clientescopy, new ClienteComparator(atriordena,ordena));
                for (Cliente cliente : clientescopy) {
                    if (cliente.CodigoPostal <= busca){
                        System.out.println(cliente.toString());
                    }
                }

            } else if (option2.equals("4")) { // rango
                System.out.println("Ingrese valor minimo y el maximo del rango separado por espacio");
                input.nextLine();
                int busca1 = input.nextInt();
                int busca2 = input.nextInt();
                System.out.println("Por cual atributo desea ordenar");
                System.out.println("1. Documento");
                System.out.println("2. Telefono");
                System.out.println("3. Codigo postal");
                String atriordena = input.next();
                System.out.println("De que manera desea ordenar");
                System.out.println("1. ascendente");
                System.out.println("2. descendente");
                String ordena = input.next();

                LinkedList<Cliente> clientescopy = new LinkedList<>(clientes);
                Collections.sort(clientescopy, new ClienteComparator(atriordena,ordena));
                for (Cliente cliente : clientescopy) {
                    if ((cliente.CodigoPostal >= busca1) && (cliente.CodigoPostal <= busca2)) {
                        System.out.println(cliente.toString());
                    }
                }
            }

        }else if(option1.equals("6")){
            if (clientes.size()==0){
                System.out.println("No hay registros");
            }else{
                System.out.println(clientes.toString());
            }

        }else{
            return;
        }

    }

    // Busqueda Contrato de repartidor
    public static void BusquedaContratoRepartidor(String option1){
        // Codigo**************
        if (option1.equals("1")){
            System.out.println("Escoja una opcion:");
            System.out.println("1. Valor exacto");
            System.out.println("2. Valor mínimo");
            System.out.println("3. Valor máximo");
            System.out.println("4. Rango");
            String option2 = input.next();
            if (option2.equals("1")) {
                System.out.println("Ingrese el valor exacto"); // valor exacto
                input.nextLine();
                int busca = input.nextInt();
                for (ContratoRepartidor contratorepartidor : contratorepartidores) {
                    if (contratorepartidor.numerocontrato == busca){
                        //imprimir empresa
                        System.out.println(contratorepartidor.toString());
                    }
                }

            } else if (option2.equals("2")) { // valor minimo
                System.out.println("Ingrese el valor mínimo");
                input.nextLine();
                int busca = input.nextInt();
                System.out.println("Por cual atributo desea ordenar");
                System.out.println("1. Numero");
                System.out.println("2. Salario");
                String atriordena = input.next();
                System.out.println("De que manera desea ordenar");
                System.out.println("1. ascendente");
                System.out.println("2. descendente");
                String ordena = input.next();

                LinkedList<ContratoRepartidor> contratoRepartidorescopy = new LinkedList<>(contratorepartidores);
                Collections.sort(contratoRepartidorescopy, new ContratoRepartidorComparator(atriordena,ordena));
                for (ContratoRepartidor contratorepartidor : contratoRepartidorescopy) {
                    if (contratorepartidor.numerocontrato >= busca){
                        System.out.println(contratorepartidor.toString());
                    }
                }


            } else if (option2.equals("3")){  // valor maximo
                System.out.println("Ingrese el valor máximo");
                input.nextLine();
                int busca = input.nextInt();
                System.out.println("Por cual atributo desea ordenar");
                System.out.println("1. Numero");
                System.out.println("2. Salario");
                String atriordena = input.next();
                System.out.println("De que manera desea ordenar");
                System.out.println("1. ascendente");
                System.out.println("2. descendente");
                String ordena = input.next();

                LinkedList<ContratoRepartidor> contratoRepartidorescopy = new LinkedList<>(contratorepartidores);
                Collections.sort(contratoRepartidorescopy, new ContratoRepartidorComparator(atriordena,ordena));
                for (ContratoRepartidor contratorepartidor : contratoRepartidorescopy) {
                    if (contratorepartidor.numerocontrato <= busca){
                        System.out.println(contratorepartidor.toString());
                    }
                }

            } else if (option2.equals("4")){ // rango
                System.out.println("Ingrese valor minimo y el maximo del rango separado por espacio");
                input.nextLine();
                int busca1 = input.nextInt();
                int busca2 = input.nextInt();
                System.out.println("Por cual atributo desea ordenar");
                System.out.println("1. Numero");
                System.out.println("2. Salario");
                String atriordena = input.next();
                System.out.println("De que manera desea ordenar");
                System.out.println("1. ascendente");
                System.out.println("2. descendente");
                String ordena = input.next();

                LinkedList<ContratoRepartidor> contratoRepartidorescopy = new LinkedList<>(contratorepartidores);
                Collections.sort(contratoRepartidorescopy, new ContratoRepartidorComparator(atriordena,ordena));
                for (ContratoRepartidor contratorepartidor : contratoRepartidorescopy) {
                    if ((contratorepartidor.numerocontrato >= busca1) && (contratorepartidor.numerocontrato <= busca2)){
                        System.out.println(contratorepartidor.toString());
                    }
                }
            }

            // salario
        } else if (option1.equals("2")){
            System.out.println("Escoja una opcion:");
            System.out.println("1. Valor exacto");
            System.out.println("2. Valor mínimo");
            System.out.println("3. Valor máximo");
            System.out.println("4. Rango");
            String option2 = input.next();
            if (option2.equals("1")) {
                System.out.println("Ingrese el valor exacto"); // valor exacto
                input.nextLine();
                int busca = input.nextInt();
                for (ContratoRepartidor contratorepartidor : contratorepartidores) {
                    if (contratorepartidor.salario == busca){
                        //imprimir empresa
                        System.out.println(contratorepartidor.toString());
                    }
                }

            } else if (option2.equals("2")) { // valor minimo
                System.out.println("Ingrese el valor mínimo");
                input.nextLine();
                int busca = input.nextInt();
                System.out.println("Por cual atributo desea ordenar");
                System.out.println("1. Numero");
                System.out.println("2. Salario");
                String atriordena = input.next();
                System.out.println("De que manera desea ordenar");
                System.out.println("1. ascendente");
                System.out.println("2. descendente");
                String ordena = input.next();

                LinkedList<ContratoRepartidor> contratoRepartidorescopy = new LinkedList<>(contratorepartidores);
                Collections.sort(contratoRepartidorescopy, new ContratoRepartidorComparator(atriordena,ordena));
                for (ContratoRepartidor contratorepartidor : contratoRepartidorescopy) {
                    if (contratorepartidor.salario >= busca){
                        System.out.println(contratorepartidor.toString());
                    }
                }


            } else if (option2.equals("3")){  // valor maximo
                System.out.println("Ingrese el valor máximo");
                input.nextLine();
                int busca = input.nextInt();
                System.out.println("Por cual atributo desea ordenar");
                System.out.println("1. Numero");
                System.out.println("2. Salario");
                String atriordena = input.next();
                System.out.println("De que manera desea ordenar");
                System.out.println("1. ascendente");
                System.out.println("2. descendente");
                String ordena = input.next();

                LinkedList<ContratoRepartidor> contratoRepartidorescopy = new LinkedList<>(contratorepartidores);
                Collections.sort(contratoRepartidorescopy, new ContratoRepartidorComparator(atriordena,ordena));
                for (ContratoRepartidor contratorepartidor : contratoRepartidorescopy) {
                    if (contratorepartidor.salario <= busca){
                        System.out.println(contratorepartidor.toString());
                    }
                }

            } else if (option2.equals("4")){ // rango
                System.out.println("Ingrese valor minimo y el maximo del rango separado por espacio");
                input.nextLine();
                int busca1 = input.nextInt();
                int busca2 = input.nextInt();
                System.out.println("Por cual atributo desea ordenar");
                System.out.println("1. Numero");
                System.out.println("2. Salario");
                String atriordena = input.next();
                System.out.println("De que manera desea ordenar");
                System.out.println("1. ascendente");
                System.out.println("2. descendente");
                String ordena = input.next();

                LinkedList<ContratoRepartidor> contratoRepartidorescopy = new LinkedList<>(contratorepartidores);
                Collections.sort(contratoRepartidorescopy, new ContratoRepartidorComparator(atriordena,ordena));
                for (ContratoRepartidor contratorepartidor : contratoRepartidorescopy) {
                    if ((contratorepartidor.salario >= busca1) && (contratorepartidor.salario <= busca2)){
                        System.out.println(contratorepartidor.toString());
                    }
                }
            }

            // fecha inicio
        } else if (option1.equals("3")){ //enfoque
            System.out.println("Escoja una opcion:");
            System.out.println("1. Valor exacto");
            System.out.println("2. Valor sin considerar mayúsculas");
            System.out.println("0. Cancelar");
            String option2 = input.next();
            if (option2.equals("1")) {
                System.out.println("Ingrese el valor exacto");
                input.nextLine();
                String busca = input.nextLine();
                for (ContratoRepartidor contratorepartidor : contratorepartidores) {
                    if (contratorepartidor.fechainicio.equals(busca)){
                        System.out.println(contratorepartidor.toString());
                    }
                }

            } else if (option2.equals("2")) {//**************************************
                System.out.println("Ingrese Valor sin considerar mayúsculas");
                input.nextLine();
                String busca = input.nextLine();
                for (ContratoRepartidor contratorepartidor : contratorepartidores) {
                    if (limpiarcadena(contratorepartidor.fechainicio).equals(limpiarcadena(busca))){
                        System.out.println(contratorepartidor.toString());
                    }
                }

            } else {
                return;
            }

            // fecha fin
        } else if (option1.equals("3")) {
            System.out.println("Escoja una opcion:");
            System.out.println("1. Valor exacto");
            System.out.println("2. Valor sin considerar mayúsculas");
            System.out.println("0. Cancelar");
            String option2 = input.next();
            if (option2.equals("1")) {
                System.out.println("Ingrese el valor exacto");
                input.nextLine();
                String busca = input.nextLine();
                for (ContratoRepartidor contratorepartidor : contratorepartidores) {
                    if (contratorepartidor.fechafin.equals(busca)){
                        System.out.println(contratorepartidor.toString());
                    }
                }

            } else if (option2.equals("2")) {//**************************************
                System.out.println("Ingrese Valor sin considerar mayúsculas");
                input.nextLine();
                String busca = input.nextLine();
                for (ContratoRepartidor contratorepartidor : contratorepartidores) {
                    if (limpiarcadena(contratorepartidor.fechafin).equals(limpiarcadena(busca))){
                        System.out.println(contratorepartidor.toString());
                    }
                }

            } else {
                return;
            }

        }

    }

    // Busqueda Contrato entrega
    public static void BusquedaEntrega(String option1){
        // Codigo**************
        if (option1.equals("1")){
            System.out.println("Escoja una opcion:");
            System.out.println("1. Valor exacto");
            System.out.println("2. Valor mínimo");
            System.out.println("3. Valor máximo");
            System.out.println("4. Rango");
            String option2 = input.next();
            if (option2.equals("1")) {
                System.out.println("Ingrese el valor exacto"); // valor exacto
                input.nextLine();
                int busca = input.nextInt();
                for (Entrega entrega : entregas) {
                    if (entrega.codEntrega == busca){
                        System.out.println(entrega.toString());
                    }
                }

            } else if (option2.equals("2")) { // valor minimo
                System.out.println("Ingrese el valor mínimo");
                input.nextLine();
                int busca = input.nextInt();
                System.out.println("Por cual atributo desea ordenar");
                System.out.println("1. Codigo de especialidad");
                System.out.println("2. Linea de atencion");
                String atriordena = input.next();
                System.out.println("De que manera desea ordenar");
                System.out.println("1. ascendente");
                System.out.println("2. descendente");
                String ordena = input.next();

                LinkedList<Entrega> entregascopy = new LinkedList<>(entregas);
                Collections.sort(entregascopy, new EntregaComparator(atriordena,ordena));
                for (Entrega entrega : entregascopy) {
                    if (entrega.codEntrega >= busca){
                        System.out.println(entrega.toString());
                    }
                }


            } else if (option2.equals("3")){  // valor maximo
                System.out.println("Ingrese el valor máximo");
                input.nextLine();
                int busca = input.nextInt();
                System.out.println("Por cual atributo desea ordenar");
                System.out.println("1. Codigo de especialidad");
                System.out.println("2. Linea de atencion");
                String atriordena = input.next();
                System.out.println("De que manera desea ordenar");
                System.out.println("1. ascendente");
                System.out.println("2. descendente");
                String ordena = input.next();

                LinkedList<Entrega> entregascopy = new LinkedList<>(entregas);
                Collections.sort(entregascopy, new EntregaComparator(atriordena,ordena));
                for (Entrega entrega : entregascopy) {
                    if (entrega.codEntrega <= busca){
                        System.out.println(entrega.toString());
                    }
                }

            } else if (option2.equals("4")){ // rango
                System.out.println("Ingrese valor minimo y el maximo del rango separado por espacio");
                input.nextLine();
                int busca1 = input.nextInt();
                int busca2 = input.nextInt();
                System.out.println("Por cual atributo desea ordenar");
                System.out.println("1. Codigo de especialidad");
                System.out.println("2. Linea de atencion");
                String atriordena = input.next();
                System.out.println("De que manera desea ordenar");
                System.out.println("1. ascendente");
                System.out.println("2. descendente");
                String ordena = input.next();

                LinkedList<Entrega> entregascopy = new LinkedList<>(entregas);
                Collections.sort(entregascopy, new EntregaComparator(atriordena,ordena));
                for (Entrega entrega : entregascopy) {
                    if ((entrega.codEntrega >= busca1) && (entrega.codEntrega <= busca2)){
                        System.out.println(entrega.toString());
                    }
                }
            }


            // Peso
        } else if (option1.equals("2")){
            System.out.println("Escoja una opcion:");
            System.out.println("1. Valor exacto");
            System.out.println("2. Valor mínimo");
            System.out.println("3. Valor máximo");
            System.out.println("4. Rango");
            String option2 = input.next();
            if (option2.equals("1")) {
                System.out.println("Ingrese el valor exacto"); // valor exacto
                input.nextLine();
                int busca = input.nextInt();
                for (Entrega entrega : entregas) {
                    if (entrega.peso == busca){
                        System.out.println(entrega.toString());
                    }
                }

            } else if (option2.equals("2")) { // valor minimo
                System.out.println("Ingrese el valor mínimo");
                input.nextLine();
                int busca = input.nextInt();
                System.out.println("Por cual atributo desea ordenar");
                System.out.println("1. Codigo de especialidad");
                System.out.println("2. Linea de atencion");
                String atriordena = input.next();
                System.out.println("De que manera desea ordenar");
                System.out.println("1. ascendente");
                System.out.println("2. descendente");
                String ordena = input.next();

                LinkedList<Entrega> entregascopy = new LinkedList<>(entregas);
                Collections.sort(entregascopy, new EntregaComparator(atriordena,ordena));
                for (Entrega entrega : entregascopy) {
                    if (entrega.peso >= busca){
                        System.out.println(entrega.toString());
                    }
                }


            } else if (option2.equals("3")){  // valor maximo
                System.out.println("Ingrese el valor máximo");
                input.nextLine();
                int busca = input.nextInt();
                System.out.println("Por cual atributo desea ordenar");
                System.out.println("1. Codigo de especialidad");
                System.out.println("2. Linea de atencion");
                String atriordena = input.next();
                System.out.println("De que manera desea ordenar");
                System.out.println("1. ascendente");
                System.out.println("2. descendente");
                String ordena = input.next();

                LinkedList<Entrega> entregascopy = new LinkedList<>(entregas);
                Collections.sort(entregascopy, new EntregaComparator(atriordena,ordena));
                for (Entrega entrega : entregascopy) {
                    if (entrega.peso <= busca){
                        System.out.println(entrega.toString());
                    }
                }

            } else if (option2.equals("4")){ // rango
                System.out.println("Ingrese valor minimo y el maximo del rango separado por espacio");
                input.nextLine();
                int busca1 = input.nextInt();
                int busca2 = input.nextInt();
                System.out.println("Por cual atributo desea ordenar");
                System.out.println("1. Codigo de especialidad");
                System.out.println("2. Linea de atencion");
                String atriordena = input.next();
                System.out.println("De que manera desea ordenar");
                System.out.println("1. ascendente");
                System.out.println("2. descendente");
                String ordena = input.next();

                LinkedList<Entrega> entregascopy = new LinkedList<>(entregas);
                Collections.sort(entregascopy, new EntregaComparator(atriordena,ordena));
                for (Entrega entrega : entregascopy) {
                    if ((entrega.peso >= busca1) && (entrega.peso <= busca2)){
                        System.out.println(entrega.toString());
                    }
                }
            }

            // dimensiones
        } else if (option1.equals("3")){
            System.out.println("Escoja una opcion:");
            System.out.println("1. Valor exacto");
            System.out.println("2. Valor mínimo");
            System.out.println("3. Valor máximo");
            System.out.println("4. Rango");
            String option2 = input.next();
            if (option2.equals("1")) {
                System.out.println("Ingrese el valor exacto"); // valor exacto
                input.nextLine();
                int busca = input.nextInt();
                for (Entrega entrega : entregas) {
                    if (entrega.dimenciones == busca){
                        System.out.println(entrega.toString());
                    }
                }

            } else if (option2.equals("2")) { // valor minimo
                System.out.println("Ingrese el valor mínimo");
                input.nextLine();
                int busca = input.nextInt();
                System.out.println("Por cual atributo desea ordenar");
                System.out.println("1. Codigo de especialidad");
                System.out.println("2. Linea de atencion");
                String atriordena = input.next();
                System.out.println("De que manera desea ordenar");
                System.out.println("1. ascendente");
                System.out.println("2. descendente");
                String ordena = input.next();

                LinkedList<Entrega> entregascopy = new LinkedList<>(entregas);
                Collections.sort(entregascopy, new EntregaComparator(atriordena,ordena));
                for (Entrega entrega : entregascopy) {
                    if (entrega.dimenciones >= busca){
                        System.out.println(entrega.toString());
                    }
                }


            } else if (option2.equals("3")){  // valor maximo
                System.out.println("Ingrese el valor máximo");
                input.nextLine();
                int busca = input.nextInt();
                System.out.println("Por cual atributo desea ordenar");
                System.out.println("1. Codigo de especialidad");
                System.out.println("2. Linea de atencion");
                String atriordena = input.next();
                System.out.println("De que manera desea ordenar");
                System.out.println("1. ascendente");
                System.out.println("2. descendente");
                String ordena = input.next();

                LinkedList<Entrega> entregascopy = new LinkedList<>(entregas);
                Collections.sort(entregascopy, new EntregaComparator(atriordena,ordena));
                for (Entrega entrega : entregascopy) {
                    if (entrega.dimenciones <= busca){
                        System.out.println(entrega.toString());
                    }
                }

            } else if (option2.equals("4")){ // rango
                System.out.println("Ingrese valor minimo y el maximo del rango separado por espacio");
                input.nextLine();
                int busca1 = input.nextInt();
                int busca2 = input.nextInt();
                System.out.println("Por cual atributo desea ordenar");
                System.out.println("1. Codigo de especialidad");
                System.out.println("2. Linea de atencion");
                String atriordena = input.next();
                System.out.println("De que manera desea ordenar");
                System.out.println("1. ascendente");
                System.out.println("2. descendente");
                String ordena = input.next();

                LinkedList<Entrega> entregascopy = new LinkedList<>(entregas);
                Collections.sort(entregascopy, new EntregaComparator(atriordena,ordena));
                for (Entrega entrega : entregascopy) {
                    if ((entrega.dimenciones >= busca1) && (entrega.dimenciones <= busca2)){
                        System.out.println(entrega.toString());
                    }
                }
            }

            // costo
        } else if (option1.equals("4")) {
            System.out.println("Escoja una opcion:");
            System.out.println("1. Valor exacto");
            System.out.println("2. Valor mínimo");
            System.out.println("3. Valor máximo");
            System.out.println("4. Rango");
            String option2 = input.next();
            if (option2.equals("1")) {
                System.out.println("Ingrese el valor exacto"); // valor exacto
                input.nextLine();
                int busca = input.nextInt();
                for (Entrega entrega : entregas) {
                    if (entrega.costo == busca){
                        //imprimir empresa
                        System.out.println(entrega.toString());
                    }
                }

            } else if (option2.equals("2")) { // valor minimo
                System.out.println("Ingrese el valor mínimo");
                input.nextLine();
                int busca = input.nextInt();
                System.out.println("Por cual atributo desea ordenar");
                System.out.println("1. Codigo de especialidad");
                System.out.println("2. Linea de atencion");
                String atriordena = input.next();
                System.out.println("De que manera desea ordenar");
                System.out.println("1. ascendente");
                System.out.println("2. descendente");
                String ordena = input.next();

                LinkedList<Entrega> entregascopy = new LinkedList<>(entregas);
                Collections.sort(entregascopy, new EntregaComparator(atriordena,ordena));
                for (Entrega entrega : entregascopy) {
                    if (entrega.costo >= busca){
                        System.out.println(entrega.toString());
                    }
                }


            } else if (option2.equals("3")){  // valor maximo
                System.out.println("Ingrese el valor máximo");
                input.nextLine();
                int busca = input.nextInt();
                System.out.println("Por cual atributo desea ordenar");
                System.out.println("1. Codigo de especialidad");
                System.out.println("2. Linea de atencion");
                String atriordena = input.next();
                System.out.println("De que manera desea ordenar");
                System.out.println("1. ascendente");
                System.out.println("2. descendente");
                String ordena = input.next();

                LinkedList<Entrega> entregascopy = new LinkedList<>(entregas);
                Collections.sort(entregascopy, new EntregaComparator(atriordena,ordena));
                for (Entrega entrega : entregascopy) {
                    if (entrega.costo <= busca){
                        System.out.println(entrega.toString());
                    }
                }

            } else if (option2.equals("4")) { // rango
                System.out.println("Ingrese valor minimo y el maximo del rango separado por espacio");
                input.nextLine();
                int busca1 = input.nextInt();
                int busca2 = input.nextInt();
                System.out.println("Por cual atributo desea ordenar");
                System.out.println("1. Codigo de especialidad");
                System.out.println("2. Linea de atencion");
                String atriordena = input.next();
                System.out.println("De que manera desea ordenar");
                System.out.println("1. ascendente");
                System.out.println("2. descendente");
                String ordena = input.next();

                LinkedList<Entrega> entregascopy = new LinkedList<>(entregas);
                Collections.sort(entregascopy, new EntregaComparator(atriordena,ordena));
                for (Entrega entrega : entregascopy) {
                    if ((entrega.costo >= busca1) && (entrega.costo <= busca2)) {
                        System.out.println(entrega.toString());
                    }
                }
            }

            // Estado de entrega
        } else if (option1.equals("5")) {
            System.out.println("Escoja una opcion:");
            System.out.println("1. Valor exacto");
            System.out.println("2. Valor sin considerar mayúsculas");
            System.out.println("0. Cancelar");
            String option2 = input.next();
            if (option2.equals("1")) {
                System.out.println("Ingrese el valor exacto");
                input.nextLine();
                String busca = input.nextLine();
                for (Entrega entrega : entregas) {
                    if (entrega.estadoEntrega.equals(busca)) {
                        System.out.println(entrega.toString());
                    }
                }

            } else if (option2.equals("2")) {//**************************************
                System.out.println("Ingrese Valor sin considerar mayúsculas");
                input.nextLine();
                String busca = input.nextLine();
                for (Entrega entrega : entregas) {
                    if (limpiarcadena(entrega.estadoEntrega).equals(limpiarcadena(busca))) {
                        System.out.println(entrega.toString());
                    }
                }

            } else {
                return;
            }
        } else if (option1.equals("6")) {
            if (entregas.size()==0){
                System.out.println("No hay registros");
            }else{
                System.out.println(entregas.toString());
            }
        } else{
            return;
        }
    }


    // Limpoar cadena ------------------------------------------------------------------------------
    public static String limpiarcadena(String cadena){
        return cadena.replaceAll("\\p{P}", "").toLowerCase();
    }

}
