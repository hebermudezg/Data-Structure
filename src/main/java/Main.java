import java.util.*;


public class Main {
    public static int Numbus= 0;
    public static int Texbus=0;
    public static Scanner input = new Scanner(System.in);

    // LinkedList para las distintas clases.
    public static LinkedList<Usuario> RegistrosUsuarios = new LinkedList<>();
    public static LinkedList<Cliente> clientes  = new LinkedList<>();
    public static LinkedList<ContratoArriendo> contratoArriendos  = new LinkedList<>();
    public static LinkedList<Empresa> empresas  = new LinkedList<>();
    public static LinkedList<Entrega> entregas  = new LinkedList<>();
    public static LinkedList<Especialidad> especialidades  = new LinkedList<>();
    public static LinkedList<Repartidor> repartidores = new LinkedList<>();
    public static LinkedList<Sucursal> sucursales  = new LinkedList<>();
    public static LinkedList<TipoDeEntrega> tipoDeEntregas  = new LinkedList<>();

    public static void main(String[] args) {

         // Escribamos un usuario de Admin
        Usuario prueba = new Usuario(1, "Admin", "Admin2", "andmin@admin.com", "123");


        // Agregando usuario a la lista de Registro de usuarios
        RegistrosUsuarios.add(prueba);
        // Se procede a guardar en el json
        EscribirJSON.guardarUsuario(RegistrosUsuarios);
        // Leyendo los json
        RegistrosUsuarios = LeerJSON.leerUsuariosJson();


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
            if (RegistroUsuario.correo == correo) {
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

        System.out.println("Registro exitoso");
        System.out.println("Ya podra iniciar sesion");

        // Imprimamos para corroborar que hay en la lista
        for (Usuario registrosUsuario : RegistrosUsuarios) {
            System.out.println(registrosUsuario.toString());
        }

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
                System.out.print(contras);
                System.out.println("La contraseña es incorrecta");
                break;
            } else {
                System.out.println("Hola" + inicio.nombre + "\n" +
                        "Bienvenido al sistema Empresa de entregas" + "\n");
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
        String razon=input.nextLine();
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
                    input.nextLine();
                    System.out.println("ingrese la nueva razon social:");
                    String x = input.nextLine();
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

    public static void VSucursal() {
        return;
    }

    public static void CSucursal() {
        return;
    }

    public static void ESucursal() {
        return;
    }

    public static void ELSucursal() {
        return;
    }

    public static void VEspecialidad() {
        return;
    }

    public static void CEspecialidad() {
        return;
    }

    public static void EEspecialidad() {
        return;
    }

    public static void ELEspecialidad() {
        return;
    }

    public static void VContratoArriendo() {
        return;
    }

    public static void CContratoArriendo() {
        return;
    }

    public static void EContratoArriendo() {
        return;
    }

    public static void ELContratoArriendo() {
        return;
    }

    public static void VRepartidor() {
        return;
    }

    public static void CRepartidor() {
        return;
    }

    public static void ERepartidor() {
        return;
    }

    public static void ELRepartidor() {
        return;
    }

    public static void VTipoEntrega() {
        return;
    }

    public static void CTipoEntrega() {
        return;
    }

    public static void ETipoEntrega() {
        return;
    }

    public static void ELTipoEntrega() {
        return;
    }

    public static void VEntrega() {
        return;
    }

    public static void CEntrega() {
        return;
    }

    public static void EEntrega() {
        return;
    }

    public static void ELEntrega() {
        return;
    }

    public static void VCliente() {
        return;
    }

    public static void CCliente() {
        return;
    }

    public static void ECliente() {
        return;
    }

    public static void ELCliente() {
        return;
    }


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
                NumBusqueda();
                if(Numbus == 0){

                }else if (Numbus == 1){

                }else if (Numbus == 2){

                }else if (Numbus == 3){

                }
            } else if (option1.equals("2")) {
                TexBusqueda();
                if(Numbus == 0){

                }else if (Numbus == 1){

                }
            } else if (option1.equals("3")) {
                TexBusqueda();
                if(Numbus == 0){

                }else if (Numbus == 1){

                }
            } else if (option1.equals("4")) {

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
                if(Numbus == 0){

                }else if (Numbus == 1){

                }
            } else if (option1.equals("3")) {
                TexBusqueda();
                if(Numbus == 0){

                }else if (Numbus == 1){

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
                if(Numbus == 0){

                }else if (Numbus == 1){

                }
            } else if (option1.equals("3")) {
                TexBusqueda();
                if(Numbus == 0){

                }else if (Numbus == 1){

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
                if(Numbus == 0){

                }else if (Numbus == 1){

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
                if(Numbus == 0){

                }else if (Numbus == 1){

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
                if(Numbus == 0){

                }else if (Numbus == 1){

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
                if(Numbus == 0){

                }else if (Numbus == 1){

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
                if(Numbus == 0){

                }else if (Numbus == 1){

                }
            } else if (option1.equals("3")) {
                TexBusqueda();
                if(Numbus == 0){

                }else if (Numbus == 1){

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

    public static void Guardar() {
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
}
