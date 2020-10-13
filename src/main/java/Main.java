
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
                System.out.print(inicio.contraseña);
                //System.out.print(contras);
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
        System.out.println("ingrese el nit de la nueva empresa: ");
        String nit =input.nextLine();

        for (Empresa empresa : empresas) {
            if (empresa.Nit.equals(nit) ) {
                System.out.println("Ingresaste un nit que ya esta registrado");
                return;
            }
        }
        System.out.println("ingrese la razon social de la empresa: ");
        String razonsocial =input.nextLine();
        System.out.println("ingrese el presidente de la empresa: ");
        String presidente = input.nextLine();

        Empresa nuevaEmpresa = new Empresa(nit,razonsocial,presidente);
        empresas.add(nuevaEmpresa);
        //EscribirJSON.guardarEmpresa(empresas); // se guarda en la opcion guardar
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
                    System.out.println("ingrese el nuevo Nit:");
                    String x = input.nextLine();
                    empresa.Nit=x;
                    System.out.println("Nit modificado satisfactoriamente");
                    break;
                }else if (option.equals("2")) {
                    input.nextLine();
                    System.out.println("ingrese la nueva razon social:");
                    String x = input.nextLine();
                    empresa.RazonSocial=x;
                    System.out.println("Razon social modificada satisfactoriamente");
                    break;
                }else if (option.equals("3")) {
                    input.nextLine();
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
        input.nextLine();
        System.out.println("ingrese el nit de la empresa a eliminar: ");
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
        System.out.println("ingrese el Codigo de la nueva sucursal: ");
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
        System.out.println("ingrese la Ciudad de la sucursal: ");
        input.nextLine();
        String ciudad =input.nextLine();
        System.out.println("ingrese la direccion de la sucursal: ");
        String direccion = input.nextLine();
        System.out.println("ingrese la cantidad de empleados de la nueva sucursal: ");
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
        System.out.println("ingrese el codigo de la sucursal a modificar: ");
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
                    System.out.println("ingrese el nuevo Codigo:");
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
                    System.out.println("ingrese la nueva ciudad:");
                    String x = input.nextLine();
                    sucursal.ciudad=x;
                    System.out.println("Razon social modificada satisfactoriamente");
                    break;
                }else if (option.equals("3")) {
                    input.nextLine();
                    System.out.println("ingrese la nueva direccion:");
                    String x = input.nextLine();
                    sucursal.direccion = x;
                    System.out.println("Direccion modificada satisfactoriamente");
                    break;
                }else if (option.equals("4")) {
                    System.out.println("ingrese la nueva cantidad de empleados");
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
        System.out.println("ingrese el Codigo de la nueva especialidad: ");
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
        System.out.println("ingrese la Encargado de la especialidad: ");
        String encargado =input.nextLine();
        System.out.println("ingrese la Enfoque de la especialidad: ");
        String enfoque = input.nextLine();
        System.out.println("ingrese la Linea de atencion de la especialidad: ");
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
        EscribirJSON.guardarEspecialida(especialidades); // guardandolo
        System.out.println("Especialidad ingresada");
    }


    public static void EEspecialidad() {
        // mostar primeros los codigos
        System.out.println("Acontinuacion se muestra una lista de codigo de las sucursales: ");
        for (Especialidad especiali : especialidades) {
            System.out.println(especiali.codigoEspecialidad);
        }
        System.out.println("ingrese el codigo de la especialidad a modificar: ");
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
                    System.out.println("ingrese el nuevo Codigo:");
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
                    System.out.println("ingrese nuevo encargado:");
                    String x = input.nextLine();
                    especialidad.encargado=x;
                    System.out.println("Encargado modificada satisfactoriamente");
                    break;
                }else if (option.equals("3")) {
                    input.nextLine();
                    System.out.println("ingrese nuevo enfoque:");
                    String x = input.nextLine();
                    especialidad.enfoque = x;
                    System.out.println("Enfoque modificada satisfactoriamente");
                    break;
                }else if (option.equals("4")) {
                    System.out.println("ingrese nueva linea de atencion");
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
        System.out.println("ingrese el codigo de la especialidad a eliminar: ");
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
        System.out.println("ingrese el numero de contrato de arriendo nuevo: ");
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
        System.out.println("ingrese la fecha de inicio del contrato de arriendo: ");
        String y=input.nextLine();
        System.out.println("ingrese la fecha de fin del contrato de arriendo: ");
        String z=input.nextLine();
        System.out.println("ingrese el canon del contrato de arriendo: ");
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
        //EscribirJSON.guardarEspecialida(especialidades); // guardandolo
        System.out.println("Contrato de arriendo ingresada");
    }
    public static void EContratoArriendo() {
        // mostar primeros los codigos
        System.out.println("Acontinuacion se muestra una lista de codigo de las sucursales: ");
        for (ContratoArriendo contratoArrie : contratoArriendos) {
            System.out.println(contratoArrie.numContrato);
        }
        System.out.println("ingrese el numero del contrato a modificar: ");
        int nit = input.nextInt();
        Iterator<ContratoArriendo> iterador = contratoArriendos.listIterator();
        while (iterador.hasNext()) {
            ContratoArriendo contratoArriendo = iterador.next();
            if (contratoArriendo.numContrato == nit) {
                System.out.println("Que deseas modificar: ");
                System.out.println("1. Numero de contrato ");
                System.out.println("2. Fecha de inicio ");
                System.out.println("3. Fecha de fin ");
                System.out.println("4. canon ");
                String option;
                option = input.next();
                if (option.equals("1")) {
                    System.out.println("ingrese el nuevo numero de contrato:");
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
                    System.out.println("ingrese nueva fecha de inicio");
                    String x = input.nextLine();
                    contratoArriendo.fechadeInicio=x;
                    System.out.println("Fecha de inicio modificado satisfactoriamente");
                    break;
                }else if (option.equals("3")) {
                    input.nextLine();
                    System.out.println("ingrese nueva Fecha de fin");
                    String x = input.nextLine();
                    contratoArriendo.FechadeFin = x;
                    System.out.println("Fecha de fin modificado satisfactoriamente");
                    break;
                }else if (option.equals("4")) {
                    System.out.println("ingrese nueva canon");
                    int x = input.nextInt();
                    if (x<0){
                        System.out.println("Numero invalido, seras regresado al menu anterior");
                        return;
                    }
                    contratoArriendo.canon=x;
                    System.out.println("canon modificado satisfactoriamente");
                    break;
                }
            }
        }
    }


    public static void ELContratoArriendo() {
        System.out.println("ingrese el numero del contrato a elinimar: ");
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
        System.out.println("ingrese el Codigo del tipo de entrega: ");
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
        System.out.println("ingrese el tiempo estimado del tipo de entrega: ");
        int w=input.nextInt();
        if(w<0){
            System.out.println("El numero ingresado es invalido, seras regresado al menu anterior");
            return;
        }
        input.nextLine();
        System.out.println("ingrese medio de transporte del tipo de entrega: ");
        String y=input.nextLine();

        TipoDeEntrega tipoDeEntrega = new TipoDeEntrega(x,w,y);
        tipoDeEntregas.add(tipoDeEntrega);
        //EscribirJSON.guardarEspecialida(especialidades); // guardandolo
        System.out.println("Tipo de entrega ingresada");
    }


    public static void ETipoEntrega() {
        // mostar primeros los codigos
        System.out.println("Acontinuacion se muestra una lista de codigo de los tipo de entrega: ");
        for (TipoDeEntrega tipoDeEnt  : tipoDeEntregas) {
            System.out.println(tipoDeEnt.Codigo);
        }
        System.out.println("ingrese Codigo del tipo de entrega a modificar: ");
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
                    System.out.println("ingrese nueva Tiempo de entrega:");
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
        System.out.println("ingrese el codigo del tipo de entrega  a elinimar: ");
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
        System.out.println("ingrese la cedula del repartidor: ");
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
        System.out.println("ingrese el nombre del repartidor: ");
        String y=input.nextLine();
        System.out.println("ingrese la edad del repartidor: ");
        int a=input.nextInt();
        if(a<0){
            System.out.println("El numero ingresado es invalido, seras regresado al menu anterior");
            return;
        }
        System.out.println("ingrese el numero celular del repartidor: ");
        int b=input.nextInt();
        if(b<0){
            System.out.println("El numero ingresado es invalido, seras regresado al menu anterior");
            return;
        }
        input.nextLine();
        System.out.println("ingrese el tipo de licencia del repartidor: ");
        String z = input.nextLine();
        System.out.println("ingrese el sueldo del repartidor: ");
        double c=input.nextInt();
        if(c<0){
            System.out.println("El numero ingresado es invalido, seras regresado al menu anterior");
            return;
        }

        Repartidor repartidor = new Repartidor(x,y,a,b,z,c);
        repartidores.add(repartidor);
        //EscribirJSON.guardarEspecialida(especialidades); // guardandolo
        System.out.println("Repartidor ingresado");
    }
    public static void ERepartidor() {
        // mostar primeros los codigos
        System.out.println("Acontinuacion se muestra una lista de las cedulas de los repartidores: ");
        for (Repartidor reparti  : repartidores) {
            System.out.println(reparti.Cedula);
        }
        System.out.println("ingrese cedula del repartidor a modificar: ");
        int n = input.nextInt();
        Iterator<Repartidor> iterador = repartidores.listIterator();
        while (iterador.hasNext()) {
            Repartidor repartidor = iterador.next();
            if (repartidor.Cedula == n) {
                System.out.println("Que deseas modificar: ");
                System.out.println("1. Edad ");
                System.out.println("2. Numero de celular ");
                System.out.println("3. Tipo de licencia ");
                System.out.println("4. Sueldo ");
                String option;
                option = input.next();
                if (option.equals("1")) {
                    System.out.println("ingrese nueva edad:");
                    int x = input.nextInt();
                    if (x < 0) {
                        System.out.println("Numero invalido, seras regresado al menu anterior");
                        return;
                    }
                    repartidor.Edad = x;
                    System.out.println("Edad modificado satisfactoriamente");
                    break;
                }else if (option.equals("2")) {
                    System.out.println("ingrese nueva numero de celular");
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
                    System.out.println("ingrese nuevo tipo de licencia:");
                    String x = input.nextLine();
                    repartidor.Tipo_Licencia=x;
                    System.out.println("Tipo de licencia modificada satisfactoriamente");
                    break;
                }else if (option.equals("4")) {
                    System.out.println("ingrese nueva sueldo");
                    double x = input.nextInt();
                    if (x<0){
                        System.out.println("Numero invalido, seras regresado al menu anterior");
                        return;
                    }
                    repartidor.Sueldo=x;
                    System.out.println("sueldo modificado satisfactoriamente");
                    break;
                }
            }
        }
    }

    public static void ELRepartidor() {
        System.out.println("ingrese el codigo del tipo de entrega  a elinimar: ");
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

    //************************** CRUD CLIENTE ***********************
    public static void VEntrega() {
        if (entregas.size() == 0) {
            System.out.println("La lista esta vacia");
            return;
        } else {
            System.out.println(entregas.toString());
        }
    }

    public static void CEntrega() {
        return;
    }

    public static void EEntrega() {
        // mostar primeros los codigos
        System.out.println("Acontinuacion se muestra una lista de los codigos  de los entrega: ");
        for (Entrega entre  : entregas) {
            System.out.println(entre.codEntrega);
        }
        System.out.println("ingrese Codigo de entrega a modificar: ");
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
                    System.out.println("ingrese nueva Codigo:");
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
        System.out.println("ingrese el documento del cliente: ");
        int x=input.nextInt();
        if(x<0){
            System.out.println("el nit ingresado es invalido, seras regresado al menu anterior");
            return;
        }
        for (Cliente cliente : clientes) {
            if (cliente.Documento==x ) {
                System.out.println("Ingresaste un docuemento que ya esta registrado");
                return;
            }
        }
        input.nextLine();
        System.out.println("ingrese el nombre del cliente: ");
        String y=input.nextLine();
        System.out.println("ingrese la direccion del cliente: ");
        String z = input.nextLine();
        System.out.println("ingrese el telefono del cliente: ");
        int a=input.nextInt();
        if(a<0){
            System.out.println("el nit ingresado es invalido, seras regresado al menu anterior");
            return;
        }
        System.out.println("ingrese el codigo postal del cliente: ");
        int b=input.nextInt();
        if(b<0){
            System.out.println("el nit ingresado es invalido, seras regresado al menu anterior");
            return;
        }

        Cliente cliente = new Cliente(x,y,z,a,b);
        clientes.add(cliente);
        //EscribirJSON.guardarEspecialida(especialidades); // guardandolo
        System.out.println("Cliente ingresada");
    }

    public static void ECliente() {
        // mostras docuemntos del clientes
        System.out.println("Acontinuacion se muestra una lista de documentos de los clientes: ");
        for (Cliente client: clientes) {
            System.out.println(client.Documento);
        }
        System.out.println("ingrese Documento del cliente a modificar: ");
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
                    System.out.println("ingrese nuevo Direccion:");
                    String x = input.nextLine();
                    cliente.Direccion=x;
                    System.out.println("Direccion modificada satisfactoriamente");
                    break;
                }else if (option.equals("2")) {
                    System.out.println("ingrese nueva telefono");
                    int x = input.nextInt();
                    if (x<0){
                        System.out.println("Numero invalido, seras regresado al menu anterior");
                        return;
                    }
                    cliente.Telefono=x;
                    System.out.println("Telefono modificado satisfactoriamente");
                    break;
                }else if (option.equals("3")) {
                    System.out.println("ingrese nueva Codigo postal");
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
        System.out.println("ingrese el documento del cliente a elinimar: ");
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
// aqui empieza el menu de busqueda
    public static void Busqueda() {
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
        System.out.println("9. Contrato de Repartidor");
        System.out.println("0. Cancelar");
        System.out.println();
        String option;
        option = input.next();
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
            if (option1.equals("1")) {
                TexBusqueda();
            } else if (option1.equals("2")) {
                TexBusqueda();
            } else if (option1.equals("3")) {
                TexBusqueda();
            } else if (option1.equals("4")) { // Mostrar todas las empresas***
                if (empresas.size() == 0){
                    System.out.println("No hay empresas registradas en el momento");
                }else{
                    System.out.println(empresas.toString());
                }


            } else {
                return;
            }


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
                NumBusqueda();
                if(Numbus == 0){

                }else if (Numbus == 1){

                }else if (Numbus == 2){

                }else if (Numbus == 3){

                }
            } else if (option1.equals("2")) {
                TexBusqueda();
                if(Texbus == 0){

                }else if (Texbus == 1){

                }
            } else if (option1.equals("3")) {
                TexBusqueda();
                if(Texbus == 0){

                }else if (Texbus == 1){

                }
            } else if (option1.equals("4")) {
                NumBusqueda();
                if(Numbus == 0){

                }else if (Numbus == 1){

                }else if (Numbus == 2){

                }else if (Numbus == 3){

                }
            } else if (option1.equals("5")) {
            } else {
                return;
            }
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
                NumBusqueda();
                if(Numbus == 0){

                }else if (Numbus == 1){

                }else if (Numbus == 2){

                }else if (Numbus == 3){

                }
            } else if (option1.equals("2")) {
                TexBusqueda();
                if(Texbus == 0){

                }else if (Texbus == 1){

                }
            } else if (option1.equals("3")) {
                TexBusqueda();
                if(Texbus == 0){

                }else if (Texbus == 1){

                }
            } else if (option1.equals("4")) {
                NumBusqueda();
                if(Numbus == 0){

                }else if (Numbus == 1){

                }else if (Numbus == 2){

                }else if (Numbus == 3){

                }
            } else if (option1.equals("5")) {
            } else {
                return;
            }
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
                NumBusqueda();
                if(Numbus == 0){

                }else if (Numbus == 1){

                }else if (Numbus == 2){

                }else if (Numbus == 3){

                }
            } else if (option1.equals("2")) {
                NumBusqueda();
                if(Numbus == 0){

                }else if (Numbus == 1){

                }else if (Numbus == 2){

                }else if (Numbus == 3){

                }
            } else if (option1.equals("3")) {
                NumBusqueda();
                if(Numbus == 0){

                }else if (Numbus == 1){

                }else if (Numbus == 2){

                }else if (Numbus == 3){

                }
            } else if (option1.equals("4")) {
                NumBusqueda();
                if(Numbus == 0){

                }else if (Numbus == 1){

                }else if (Numbus == 2){

                }else if (Numbus == 3){

                }
            } else if (option1.equals("5")) {
            } else {
                return;
            }
        } else if (option.equals("5")) {
            System.out.println("Los atributos que tiene la clase seleccionada");
            System.out.println("Escoja una opcion:");
            System.out.println("1. Cedula");
            System.out.println("2. Nombre");
            System.out.println("3. Edad");
            System.out.println("4. Numero de celular");
            System.out.println("5. Tipo de licencia");
            System.out.println("6. Sueldo");
            System.out.println("7. Mostrar todos los Repartidores");
            System.out.println("0. Cancelar");
            String option1;
            option1 = input.next();
            if (option1.equals("1")) {
                NumBusqueda();
                if(Numbus == 0){

                }else if (Numbus == 1){

                }else if (Numbus == 2){

                }else if (Numbus == 3){

                }
            } else if (option1.equals("2")) {
                TexBusqueda();
                if(Texbus == 0){

                }else if (Texbus == 1){

                }
            } else if (option1.equals("3")) {
                NumBusqueda();
                if(Numbus == 0){

                }else if (Numbus == 1){

                }else if (Numbus == 2){

                }else if (Numbus == 3){

                }
            } else if (option1.equals("4")) {
                NumBusqueda();
                if(Numbus == 0){

                }else if (Numbus == 1){

                }else if (Numbus == 2){

                }else if (Numbus == 3){

                }
            } else if (option1.equals("5")) {
                TexBusqueda();
                if(Texbus == 0){

                }else if (Texbus == 1){

                }
            } else if (option1.equals("6")) {
                NumBusqueda();
                if(Numbus == 0){

                }else if (Numbus == 1){

                }else if (Numbus == 2){

                }else if (Numbus == 3){

                }
            } else if (option1.equals("7")) {
            } else {
                return;
            }
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
                NumBusqueda();
                if(Numbus == 0){

                }else if (Numbus == 1){

                }else if (Numbus == 2){

                }else if (Numbus == 3){

                }
            } else if (option1.equals("2")) {
                NumBusqueda();
                if(Numbus == 0){

                }else if (Numbus == 1){

                }else if (Numbus == 2){

                }else if (Numbus == 3){

                }
            } else if (option1.equals("3")) {
                TexBusqueda();
                if(Texbus == 0){

                }else if (Texbus == 1){

                }
            } else if (option1.equals("4")) {

            } else {
                return;
            }
        } else if (option.equals("7")) {
            System.out.println("Los atributos que tiene la clase seleccionada");
            System.out.println("Escoja una opcion:");
            System.out.println("1. Codigo de entrega");
            System.out.println("2. Peso");
            System.out.println("3. Dimenciones");
            System.out.println("4. Fragil");
            System.out.println("5. Costo");
            System.out.println("6. Estado de entrega");
            System.out.println("7. Mostrar todas las entregas");
            System.out.println("0. Cancelar");
            String option1;
            option1 = input.next();
            if (option1.equals("1")) {
                NumBusqueda();
                if(Numbus == 0){

                }else if (Numbus == 1){

                }else if (Numbus == 2){

                }else if (Numbus == 3){

                }
            } else if (option1.equals("2")) {
                NumBusqueda();
                if(Numbus == 0){

                }else if (Numbus == 1){

                }else if (Numbus == 2){

                }else if (Numbus == 3){

                }
            } else if (option1.equals("3")) {
                NumBusqueda();
                if(Numbus == 0){

                }else if (Numbus == 1){

                }else if (Numbus == 2){

                }else if (Numbus == 3){

                }
            } else if (option1.equals("4")) {

            } else if (option1.equals("5")) {
                NumBusqueda();
                if(Numbus == 0){

                }else if (Numbus == 1){

                }else if (Numbus == 2){

                }else if (Numbus == 3){

                }
            } else if (option1.equals("6")) {
                TexBusqueda();
                if(Texbus == 0){

                }else if (Texbus == 1){

                }
            } else if (option1.equals("7")) {
            } else {
                return;
            }
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
                NumBusqueda();
                if(Numbus == 0){

                }else if (Numbus == 1){

                }else if (Numbus == 2){

                }else if (Numbus == 3){

                }
            } else if (option1.equals("2")) {
                TexBusqueda();
                if(Texbus == 0){

                }else if (Texbus == 1){

                }
            } else if (option1.equals("3")) {
                TexBusqueda();
                if(Texbus == 0){

                }else if (Texbus == 1){

                }
            } else if (option1.equals("4")) {
                NumBusqueda();
                if(Numbus == 0){

                }else if (Numbus == 1){

                }else if (Numbus == 2){

                }else if (Numbus == 3){

                }
            } else if (option1.equals("5")) {
                NumBusqueda();
                if(Numbus == 0){

                }else if (Numbus == 1){

                }else if (Numbus == 2){

                }else if (Numbus == 3){

                }
            } else if (option1.equals("6")) {
            } else {
                return;
            }
        } else {
            return;
        }
    }

    public static void DiagnosticoInconsistencias() {
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
    public static void NumBusqueda() {
        System.out.println("Escoja una opcion:");
        System.out.println("1. Valor exacto");
        System.out.println("2. Valor mínimo");
        System.out.println("3. Valor máximo");
        System.out.println("4. Rango");
        System.out.println("0. Cancelar");
        String option1;
        option1 = input.next();
        if (option1.equals("1")) {
            Numbus =0;
        } else if (option1.equals("2")) {
            Numbus =1;
        } else if (option1.equals("3")) {
            Numbus =2;
        } else if (option1.equals("4")) {
            Numbus =3;
        } else {
            return;
        }
    }
    public static void TexBusqueda() {
        System.out.println("Escoja una opcion:");
        System.out.println("1. Valor exacto");
        System.out.println("2. Valor sin considerar mayúsculas");

        System.out.println("0. Cancelar");
        String option1;
        option1 = input.next();
        if (option1.equals("1")) {
            Texbus =0;
        } else if (option1.equals("2")) {
            Texbus =1;
        } else {
            return;
        }
    }


    public static void MostrarClase(int option){

    }

}
